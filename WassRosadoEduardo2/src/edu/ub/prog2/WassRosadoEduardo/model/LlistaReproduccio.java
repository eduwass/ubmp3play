/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.model;

/**
 *
 * @author edu.wass
 */
public class LlistaReproduccio {
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
     */
    public void mostrarLlista(){
        this.llista.mostrarLlista();
    }
    
     /**
     * Comprova si existeix fitxer a la llista de fitxers
     * @param f
     * @return booleà
     */
    public boolean existeixFitxer(FitxerAudio f){
        return this.existeixFitxer(f);
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
            this.llista.afegirFitxer(f);
        }
    }
    
    /**
     * Elimina fitxer de llista donat fitxer 
     * @param f
     */
    public void eliminarFitxer(FitxerAudio f){
        this.llista.eliminarFitxer(f);
    }       
    
}
