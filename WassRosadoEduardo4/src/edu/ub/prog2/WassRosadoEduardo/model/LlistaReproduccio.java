/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.model;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerNoExisteix;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerRepetit;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edu.wass
 */
public class LlistaReproduccio implements Serializable {
    // ========================
    // Atributos
    // ========================    
    
    // Nombre de la lista
    private String nom;
    private LlistaFitxers llista;
    final private int n = 10; // maximo elementos lista

    
    // ========================
    // Funciones
    // ========================
    
    /**
     * Funció constructora
     * @param nom 
     */
    public LlistaReproduccio(String nom){
        this.nom = nom;
        this.llista = new LlistaFitxers();
    }
    
    /**
     * Retorna nom de llista de reproducció
     * @return 
     */
    public String getNom(){
        return this.nom;
    }
 
     /**
     * Mostra llista per pantalla
     * @return str
     */
    public String mostrarLlista(){
        return this.llista.mostrarLlista();
    }
    
     /**
     * Comprova si existeix fitxer a la llista de fitxers
     * @param f
     * @return booleà
     */
    public boolean existeixFitxer(FitxerAudio f){
        return this.llista.existeixFitxer(f);
    }   
     /**
     * Afegeix un fitxer a la Llista donat fitxer
     * @param f
     */
    public void afegirFitxer(FitxerAudio f){
        if(this.llista.tamany()>=this.n){
            // Comprovar que nombre elements no sigui > n
            System.out.println("Error: llista plena, no es poden afegir mes fitxers.");
        } else {
            try {
                this.llista.simpleAdd(f,false);
            } catch (ExcepcioFitxerRepetit ex) {
                Logger.getLogger(LlistaReproduccio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcioFitxerNoExisteix ex) {
                Logger.getLogger(LlistaReproduccio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Elimina fitxer de llista donat fitxer 
     * @param f
     */
    public void eliminarFitxer(FitxerAudio f){
        this.llista.eliminarFitxer(f);
    }
    
    /**
     * Eliminar fitxer donat index de fitxer
     * @param i 
     */
    public void eliminarFitxer(int i){
        this.llista.eliminarFitxer(i-1);
    }
    
    /**
     * Dona tamany de llista de reproducció
     * @return int
     */
    public int donaTamany(){
        return this.llista.tamany();
    }

    /**
     * Dona fitxer en llista de reproducció donada posició
     * @param posicio
     * @return FitxerAudio
     */
    public FitxerAudio donaFitxer(int posicio) {
        return this.llista.taula.get(posicio-1);
    }
    
    /**
     * Dona llista de fitxers
     * @return LlistaFitxers
     */
    public LlistaFitxers donaLlistaFitxers(){
        return this.llista;
    }
    
    /**
     * Dona limit tamany llista
     */
    public int donaLimit(){
        return this.n;
    }
}
