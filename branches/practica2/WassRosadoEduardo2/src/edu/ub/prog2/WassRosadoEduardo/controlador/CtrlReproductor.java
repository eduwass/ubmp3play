/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */


package edu.ub.prog2.WassRosadoEduardo.controlador;
import edu.ub.prog2.WassRosadoEduardo.model.*;
import edu.ub.prog2.utils.FitxerAudioErrorException;

/**
 *
 * @author edu.wass
 */
public class CtrlReproductor {
    
    // ========================
    // Atributos
    // ========================    

    // Enlace a Modelo
    private DadesReproductor Modelo;
    
    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funció constructora
     */
    public CtrlReproductor(){
        this.Modelo = new DadesReproductor();
        
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
    
    }
    
    /**
     * Elimina llista de reproducció donada
     * @param llista 
     */
    public void eliminarLlistaReproduccio(LlistaReproduccio llista){
    
    }
    
    /**
     * Reprodueix el fitxer d'audio donat
     * @param fitxer
     * @throws FitxerAudioErrorException 
     */
    public void play(FitxerAudio fitxer) throws FitxerAudioErrorException{
        
    }
    
    /**
     * Retorna noms de les llistes de reproducció
     * @return 
     */
    public String [] getLlistesReproduccio(){return null;};
    
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
     * Comprova si existeix un fitxer a la biblioteca donada posicio
     * @param posicio
     * @return booleà
     */
    public boolean existeixPosicio(int posicio){
        return false;
    }
    
    /**
     * Comprova si existeix un fitxer a una llista, donada posicio i llista
     * @param posicio
     * @param llista
     * @return booleà
     */
    public boolean existeixPosicio(int posicio, LlistaReproduccio llista){
        return false;
    }
    
    /**
     * Comprova si existeix llista de reproducció donada posicio
     * @param posicio
     * @return booleà
     */
    public boolean existeixLlista(int posicio){
        return false;
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
        return null;
    }

    /**
     * Retorna el tamany en elements de la biblioteca
     * @return 
     */
    public int donaTamanyBiblioteca() {
        
        return Modelo.donaTamanyBiblioteca();
        
    }
    
    
}
