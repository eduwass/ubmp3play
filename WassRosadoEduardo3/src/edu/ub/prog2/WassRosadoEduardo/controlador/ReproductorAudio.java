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
import java.util.ArrayList;
import java.util.Random;

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
    
    public ReproductorAudio(){
        this.played = new ArrayList<Boolean>();
        this.index = -1;
    }
    
    public void setCtrlFlags(boolean ciclic, boolean aleatori){
        this.ciclic = ciclic;
        this.aleatori = aleatori;
    }

    public void playAudioFile(FitxerAudio fitxerAudio) throws FitxerAudioErrorException {
        stop();
        this.played.set(this.index,true); // set played!
        openAudioFile(fitxerAudio.getPath());
        play();
        
    }

    public void playFilesList(LlistaFitxers llista) throws FitxerAudioErrorException{
        this.playlist = llista;
        this.played = new ArrayList<Boolean>();
        // Set played = 0 para todas inicialmente
        for (FitxerAudio f : this.playlist.taula){
            this.played.add(false);
        }
        seguent();
    }

    public void seguent() throws FitxerAudioErrorException{
        // stop!
        stop();
        if(this.ciclic){
            
            if((this.index+1)!=this.playlist.tamany()){
                // si aun quedan canciones por reproducir
                // Modo ciclo, la siguiente sera index+1
                this.index += 1;
                FitxerAudio next = this.playlist.taula.get(this.index);
                playAudioFile(next);
            } 
            
        } else {
            if(!allPlayed()){
                // Modo random, la siguiente puede ser cualquiera
                int randindex;
                Random rand = new Random();
                randindex = rand.nextInt(this.playlist.tamany());
                while(this.played.get(randindex)){
                    // mientras ya este reproducida buscar otra
                    randindex = rand.nextInt(this.playlist.tamany());
                }
                FitxerAudio next = this.playlist.taula.get(randindex);
                this.index = randindex;
                playAudioFile(next);
            }
        }
    }

    private void iniciarReproduccio(){}
    
    public void _play(){
        play();
    }
    
    public void _pause() {
        pause();
    }
    
    public void _stop(){
        stop();
    }
    
    private boolean allPlayed(){
        for(boolean isplayed:this.played){
            if(!isplayed) return false;
        }
        return true;
    }
}
