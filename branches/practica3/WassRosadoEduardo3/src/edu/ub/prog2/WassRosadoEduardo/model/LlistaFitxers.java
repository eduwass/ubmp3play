/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.model;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerNoExisteix;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerRepetit;
import java.io.File;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author edu.wass
 */
public class LlistaFitxers implements Serializable {
 
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
     * @return string
     */
    public String mostrarLlista(){
        if (this.taula.size()>0){
            int i = 1;
            String retorn = "";
            for (FitxerAudio f : this.taula){
                retorn += "\n["+i+"] | ";
                retorn += f;
                i++;
            }
            return retorn;          
        } else {
            String retorn = "No hi ha fitxers.";
            return retorn;
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
     * @throws edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerRepetit
     * @throws edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerNoExisteix
     */
    public void afegirFitxer(FitxerAudio f) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix{
        // Comprovar si existeix ruta
        File fitxer = new File(f.getPath());
        if(fitxer.exists()){
            // Comprovar si esta repe:
            if(existeixFitxer(f)){
                // lanzar excepcion
                throw new ExcepcioFitxerRepetit();
            } else {
                // Creem un objecte per llegir des del teclat
                Scanner sc = new Scanner(System.in);
                f.demanaDadesTeclat(sc);
                // Llamar a controlador para que inserte fichero
                taula.add(f);              
            }                
        } else {
            throw new ExcepcioFitxerNoExisteix();
        }
    }
    
    /**
     * Accedir direcatmente al metode add de la taula
     * @param f 
     */
    public void simpleAdd(FitxerAudio f){
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
