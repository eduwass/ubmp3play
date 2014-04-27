/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */


package edu.ub.prog2.WassRosadoEduardo.controlador;
import edu.ub.prog2.WassRosadoEduardo.model.*;
import edu.ub.prog2.WassRosadoEduardo.controlador.*;
import edu.ub.prog2.utils.FitxerAudioErrorException;

import java.util.ArrayList;

/**
 *
 * @author edu.wass
 */
public class CtrlReproductor {
    
    // ========================
    // Atributos
    // ========================    

    // Enlace a Modelo
    private final DadesReproductor Modelo;
    
    // Reproductor
    private final ReproductorAudio Reproductor;
    
    
    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funció constructora
     */
    public CtrlReproductor(){
        this.Modelo = new DadesReproductor();
        this.Reproductor = new ReproductorAudio();
        Reproductor.setCtrlFlags(Modelo.ciclic, Modelo.aleatori);
    }
    
    /**
     * Retorna copia de l'objecte biblioteca per emprar a la vista
     * @return Objecte Biblioteca (LlistaFitxers)
     */
    public LlistaFitxers getBiblioteca(){
        LlistaFitxers Copia = Modelo.getBiblioteca();
        return Copia;
    }
    
    /**
     * Afegeix fitxer donat a biblioteca
     * @param fa 
     */
    public void afegirFitxer(FitxerAudio fa){
        Modelo.afegirFitxerBiblioteca(fa);
    }
    
    /**
     * Afegeix fitxer donat a la llista de reproduccio donada
     * @param fa
     * @param llista 
     */
    public void afegirFitxer(FitxerAudio fa, LlistaReproduccio llista){
        Modelo.afegirFitxerLlista(fa, llista);
    }
    
    /**
     * Eliminar fitxer donat de biblioteca i llistes de reproducció
     * @param fa 
     */
    public void eliminarFitxer(FitxerAudio fa){
        Modelo.eliminarFitxerBiblioteca(fa);
    }
    
    /**
     * Eliminar fitxer donat de la llista reproducció donada
     * @param fa
     * @param llista 
     */
    public void eliminarFitxer(FitxerAudio fa, LlistaReproduccio llista){
        Modelo.eliminarFitxerLlista(fa, llista);
    }
    
    /**
     * Crea nova llista de reproducció amb el nom donat
     * @param nomLlista 
     */
    public void crearLlistaReproduccio(String nomLlista){
        Modelo.afegirLlista(nomLlista);
    }
    
    /**
     * Elimina llista de reproducció donada
     * @param llista 
     */
    public void eliminarLlistaReproduccio(int posicio){
        Modelo.eliminarLlista(posicio);
    }

    
    /**
     * Retorna noms de les llistes de reproducció
     * @return 
     */
    public ArrayList<String> getLlistesReproduccio(){
        return Modelo.getLlistesReproduccio();
    };
    
    /**
     * Retorna llista de reproducció donat el seu nom
     * @param nom
     * @return 
     */
    public LlistaReproduccio getLlistaReproduccio(String nom){return null;}
    
    /**
     * Mostra per pantalla continguts de biblioteca
     */
    public void mostrarBiblioteca(){
        Modelo.mostrarBiblioteca();
    }
    
    /**
     * Comprova si existeix fitxer a la biblioteca
     * @param f
     * @return booleà
     */
    public boolean existeixFitxer(FitxerAudio f){
        return Modelo.existeixFitxerBiblioteca(f);
    }
    
    /**
     * Comprova si existeix llista de reproducció donat nom llista
     * @param nomllista
     * @return booleà
     */
    public boolean existeixLlista(String nomllista){
        return Modelo.existeixLlista(nomllista);
    }
    
    /**
     * Retorna FitxerAudio de la biblioteca donada posicio
     * @param posicio
     * @return FitxerAudio
     */
    public FitxerAudio donaFitxerAudio(int posicio){
        return Modelo.donaFitxerAudio(posicio);
    }
 
     /**
     * Retorna FitxerAudio de la llista donada posicio i llista
     * @param posicio
     * @param llista
     * @return FitxerAudio
     */
    public FitxerAudio donaFitxerAudio(int posicio, LlistaReproduccio llista){
        return Modelo.donaFitxerAudio(posicio, llista);
    }

    /**
     * Retorna el tamany en elements de la biblioteca
     * @return 
     */
    public int donaTamanyBiblioteca() {
        
        return Modelo.donaTamanyBiblioteca();
        
    }
    
    /**
     * Dona quantitat de llistes de reproducció
     * @return int
     */
    public int donaTamanyLlistes(){
        return Modelo.donaTamanyLlistes();
    }

    /**
     * Dona llista de reproducció donada posició
     * @param posicio
     * @return LlistaReproduccio
     */
    public LlistaReproduccio donaLlista(int posicio) {
        return Modelo.donaLlista(posicio);
    }

    public void mostrarLlista(LlistaReproduccio llista) {
        Modelo.mostrarLlista(llista);
    }

    public Object donaDadesReproductor() {
        return Modelo.donaDadesReproductor();
    }

    public void carregarDadesReproductor(DadesReproductor readObject) {
        Modelo.carregarDadesReproductor(readObject);
    }

    
    /**
     * Reproduix fitxer por posicio
     * @param pos
     */
    public void playFitxer(int pos){}
    
    /**
     * Reprodueix fitxer donat objecte
     * @param fitxer
     * @throws edu.ub.prog2.utils.FitxerAudioErrorException
     */
    public void playFitxer(FitxerAudio fitxer) throws FitxerAudioErrorException{
        LlistaFitxers list = new LlistaFitxers();
        list.afegirFitxer(fitxer);
        this.playLlista(list);
    }
    
    /**
     * Reprodueix biblioteca
     */
    public void playLlista(){}
    
    /**
     * Reprodueix llista de reproduccio donada
     * @param llista 
     */
    public void playLlista(LlistaFitxers llista) throws FitxerAudioErrorException{
        Reproductor.playFilesList(llista);
    }
    public void next() throws FitxerAudioErrorException{
        Reproductor.seguent();
    }
    
    public void play(){ Reproductor._play(); }
    public void pause() { Reproductor._pause(); }
    public void stop(){ Reproductor._stop(); }
    
    public void setRandom() {
        Modelo.setRandom();
        Reproductor.setCtrlFlags(Modelo.ciclic, Modelo.aleatori);
    }

    public void setCiclic() {
        Modelo.setCiclic();
        Reproductor.setCtrlFlags(Modelo.ciclic, Modelo.aleatori);
    }
    
}
