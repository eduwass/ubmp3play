/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.model;
import java.util.ArrayList;

/**
 *
 * @author edu.wass
 */
public class LlistaFitxers {
 
    // ========================
    // Atributos
    // ========================    
    
    public ArrayList <FitxerAudio> taula;

    
    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funció constructora
     */
    public LlistaFitxers(){
        this.taula = new ArrayList<>();
    }
    
    /**
     * Mostra llista per pantalla
     */
    public void mostrarLlista(){
        if (this.taula.size()>0){
            int i = 1;
            String retorn = "";
            for (FitxerAudio f : this.taula){
                retorn += "\n["+i+"] | ";
                retorn += f;
                i++;
            }
            System.out.println(retorn);            
        } else {
            System.out.println("No hi ha fitxers.");
        }

    }
    
    /**
     * Comprova si existeix fitxer a la llista de fitxers
     * @param f
     * @return booleà
     */
    public boolean existeixFitxer(FitxerAudio f){
        for (FitxerAudio f2 : this.taula){
            // Recorrer y si se encuentra return true
            if(f.equals(f2)) return true;
        }
        // Si no se encuentra return false
        return false;
    }
    
    /**
     * Afegeix un fitxer a la Llista donat fitxer
     * @param f
     */
    public void afegirFitxer(FitxerAudio f){
        taula.add(f);
    }
    
    /**
     * Elimina fitxer de llista donat fitxer 
     * @param f
     */
    public void eliminarFitxer(FitxerAudio f){
        taula.remove(f);
    }
    
    /**
     * Retorna tamany de la llista
     * @return int
     */
    public int tamany(){
        return taula.size();
    }

}
