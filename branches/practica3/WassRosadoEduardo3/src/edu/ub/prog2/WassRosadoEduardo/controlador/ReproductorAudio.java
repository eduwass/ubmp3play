/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ub.prog2.WassRosadoEduardo.controlador;
import edu.ub.prog2.WassRosadoEduardo.model.FitxerAudio;
import edu.ub.prog2.WassRosadoEduardo.model.LlistaFitxers;
import edu.ub.prog2.utils.FitxerAudioErrorException;
import edu.ub.prog2.utils.ReproductorBasic;
import edu.ub.prog2.utils.ReproductorEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mat.aules
 */
public class ReproductorAudio extends ReproductorBasic {
    
    
    // ========================
    // Atributos
    // ========================
    private LlistaFitxers playlist;
    private ArrayList<Boolean> played;
    private int index;
    private boolean ciclic;
    private boolean aleatori;
    
    
    // ========================
    // Funciones
    // ========================    
    
    /**
     * Funció constructora
     */
    public ReproductorAudio(){
        this.played = new ArrayList<Boolean>();
        this.index = -1;
    }
    
    /**
     * Estableix tipus de reproducció donats parametres
     * @param ciclic
     * @param aleatori 
     */
    public void setCtrlFlags(boolean ciclic, boolean aleatori){
        this.ciclic = ciclic;
        this.aleatori = aleatori;
    }

    /**
     * Reprodueix un FitxerAudio
     * @param fitxerAudio
     * @throws FitxerAudioErrorException 
     */
    public void playAudioFile(FitxerAudio fitxerAudio) throws FitxerAudioErrorException {
        stop();
        this.played.set(this.index,true); // set played!
        openAudioFile(fitxerAudio.getPath());
        play();
        
    }

    /**
     * Reprodueix una llista
     * @param llista
     * @throws FitxerAudioErrorException 
     */
    public void playFilesList(LlistaFitxers llista) throws FitxerAudioErrorException{
        this.index = -1;
        this.playlist = llista;
        this.played = new ArrayList<Boolean>();
        // Set played = 0 para todas inicialmente
        for (FitxerAudio f : this.playlist.taula){
            this.played.add(false);
        }
        seguent();
    }

    /**
     * Pasa a seguent pista
     * @throws FitxerAudioErrorException 
     */
    public void seguent() throws FitxerAudioErrorException{
        // stop!
        stop();
        FitxerAudio next = null;
        if(this.aleatori){
            // MODO ALEATORIO
            if(!allPlayed()){
                // NEXT = indice random (dentro de notPlayed)
                int randindex;
                Random rand = new Random();
                randindex = rand.nextInt(this.playlist.tamany());
                while(this.index!=-1 && this.played.get(randindex)){
                    // mientras ya este reproducida buscar otra
                    randindex = rand.nextInt(this.playlist.tamany());
                }
                next = this.playlist.taula.get(randindex);
                this.index = randindex;
            } else {
                // FINAL:
                if(this.ciclic){
                    // Set played = 0
                    this.played = new ArrayList<Boolean>();
                    // Set played = 0 para todas inicialmente
                    for (FitxerAudio f : this.playlist.taula) {
                        this.played.add(false);
                    }
                    // NEXT = indice random
                    int randindex;
                    Random rand = new Random();
                    randindex = rand.nextInt(this.playlist.tamany());
                    next = this.playlist.taula.get(randindex);
                    this.index = randindex;
                }
            }
        } else {
            // MODO SECUENCIAL
            if(this.index+1!=this.playlist.tamany()){
                // NEXT = indice + 1
                this.index+=1;
                next = this.playlist.taula.get(this.index);
            } else {
                // FINAL:
                if(this.ciclic){
                    // NEXT = 0
                    this.index=0;
                    next = this.playlist.taula.get(this.index);
                }
            }
        }
        
        // Si existe NEXT -> Play next
        if(next!=null){
            try {
                // es pot reproduir correctament
                playAudioFile(next);
            } catch(FitxerAudioErrorException ex){
                // no s'ha aconseguit reproduir:
                // continuar amb seguent
                seguent();
            }
        }

    }

    /**
     * Inicia reproduccio
     */
    public void _play(){
        play();
    }
    
    /**
     * Pausa reproducció
     */
    public void _pause() {
        pause();
    }
    
    /**
     * Para reproducció
     */
    public void _stop(){
        stop();
    }
    
    /**
     * Comprova si totes les pistes han estat escoltades
     * @return bool
     */
    private boolean allPlayed(){
        for(boolean isplayed:this.played){
            if(!isplayed) return false;
        }
        return true;
    }
    
    /**
     * Quan acaba la pista canvia de pista
     * @param re 
     */
    public void onEndFile(ReproductorEvent re) {
        try {
            seguent();
        } catch (FitxerAudioErrorException ex) {
            Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
