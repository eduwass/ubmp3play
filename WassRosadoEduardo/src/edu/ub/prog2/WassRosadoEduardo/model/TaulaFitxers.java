/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ub.prog2.WassRosadoEduardo.model;

/**
 *
 * @author mat.aules
 */
public class TaulaFitxers {
    
    // ========================
    // Atributos
    // ========================
    
    private final FitxerAudio[] taula;
    private final int tamany = 100;
    
    // ========================
    // Funciones
    // ========================
    
    /**
     * Funcio constructora
     */
    public TaulaFitxers() {
        taula =  new FitxerAudio[tamany];
    }
    
    /**
     * Retorna el nombre d’elements que hi ha a la llista
     * @return
     */
        
    public int tamany(){
        return tamany;
    }
    
    /**
     * Afegeix una nova cançó a la llista
     * @param fitxer Fitxer a afegir
     */
    public void afegirFitxer(FitxerAudio fitxer){
        
    }
    
    /**
     * Elimina una cançó de la llista si coincideix amb la cançó passada. 
     * Caldrà fer servir el mètode equals de la vostra classe FitxerAudio
     * @param fitxer
     */
    public void eliminarFitxer(FitxerAudio fitxer){
        
    }
    
    /**
     * Retorna la cançó a la posició indicada de la llista.
     * @param position posicio indicada
     * @return FitxerAudio canço
     */
    public FitxerAudio getAt(int position){
        return null;
    }
    
    /**
     * Eliminar tots els elements de la llista
     */
    public void clear(){
        
    }
    
    /**
     * Indica si la llista està plena
     * @return boolean
     */
    protected boolean isFull(){
        return false;
    }
    
    @Override
    public String toString(){
        return null;
    }
    
    /**
     * Compara dues taules de FitxerAudio per veure si contenen el mateix
     * @return boolean
     */
    public boolean equals(){
        return false;
    }    
}
