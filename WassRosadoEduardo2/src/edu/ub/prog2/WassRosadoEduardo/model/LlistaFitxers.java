/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.model;
import java.io.File;
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
     * Mostra llista per pantalla
     */
    private void mostrarLlista(){
        int i = 0;
        String retorn = "";
        for (FitxerAudio f : this.taula){
            retorn += "\n["+i+"] | ";
            retorn += f;
            i++;
        }
        System.out.println(retorn);
    }
    
    /**
     * Afegeix un fitxer a la Llista
     * @param ruta (ruta del fitxer que es vol afegir)
     * @return boolea que indica l'exit
     */
    private boolean afegirFitxer(String ruta){
        // Comprovar si existeix ruta
        File fitxer = new File(ruta);
        if(fitxer.exists()){
            // Si es una ruta valida
            // Crear FitxerAudio;
            FitxerAudio f = new FitxerAudio(ruta);
            f.demanaDadesTeclat();
            taula.add(f);
            return true;
        } else { 
            // Si no:
            return false;
        }
        
    }
    /**
     * Elimina fitxer indicat per posicio
     * @param posicio 
     */
    private boolean eliminarFitxer(int posicio){
        if(posicio < this.taula.size()){
            // Si es posicio valida
            FitxerAudio Actual = this.taula.get(posicio);
            this.taula.remove(posicio);
            return true;
        } else {
            // Si no:
            return false;
        }
    }    

}
