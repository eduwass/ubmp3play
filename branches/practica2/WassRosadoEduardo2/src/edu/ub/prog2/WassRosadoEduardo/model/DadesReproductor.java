/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */


package edu.ub.prog2.WassRosadoEduardo.model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author edu.wass
 */
public class DadesReproductor {
    
    // ========================
    // Atributos
    // ========================    
    
    // una biblioteca (LlistaFitxers)
    private LlistaFitxers biblioteca;
    
    // una coleccion de listas de reproduccion (LlistaReproduccio)
    private ArrayList<LlistaReproduccio> llistes_reproduccio;
    
    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funció constructora
     */
    public DadesReproductor(){
        this.biblioteca = new LlistaFitxers();
        this.llistes_reproduccio = new ArrayList<>();
    }
    
    /**
     * Guardar objectes a un fitxer donat el nom
     * @param nomFitxer
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardarDades(String nomFitxer) throws FileNotFoundException, IOException {
    
    }
    
    /**
     * Carregar objectes de un fitxer donat el nom
     * @param nomFitxer
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static DadesReproductor recuperarDades(String nomFitxer) throws FileNotFoundException, IOException, ClassNotFoundException { return null; }
    
    /**
     * Afegir un fitxer a la biblioteca donat fitxer
     * @param fitxer 
     */
    public void afegirFitxerBiblioteca(FitxerAudio fitxer) {
        biblioteca.afegirFitxer(fitxer);
    }
    
    /**
     * Eliminar fitxer de la biblioteca i llistes donat fitxer
     * @param fitxer 
     */
    public void eliminarFitxerBiblioteca(FitxerAudio fitxer) {
        biblioteca.eliminarFitxer(fitxer);
    }
    
    public boolean existeixFitxerBiblioteca(FitxerAudio fitxer){
        return biblioteca.existeixFitxer(fitxer);
    }
    
    /**
     * Afegir fitxer a llista reproducció donat fitxer i llista
     * @param fitxer
     * @param lrep 
     */
    public void afegirFitxerLlista(FitxerAudio fitxer, LlistaReproduccio lrep) {
    
    }
    
    /**
     * Eliminar fitxer de llista reproducció donat fitxer i llista
     * @param fitxer
     * @param lrep 
     */
    public void eliminarFitxerLlista(FitxerAudio fitxer, LlistaReproduccio lrep){
        
    }
    
    /**
     * Retornar objecte biblioteca
     * @return biblioteca
     */
    public LlistaFitxers getBiblioteca(){
        return biblioteca;
    }
    
    /**
     * Mostra biblioteca per pantalla
     */
    public void mostrarBiblioteca(){
        biblioteca.mostrarLlista();
    }
    
    /**
     * Crea nova llista de reproducció amb el nom donat
     * @param nom 
     */
    public void afegirLlista(String nom){
        // Comprobar que no exista lista con mismo nombre
        
        // Crear lista
        
    }
    
    public void eliminarLlista(String nom){
        
    }
    
    //@Override public void toString(){}

    /**
     * Retorna tamany de la biblioteca
     * @return tamany
     */
    public int donaTamanyBiblioteca() {
        return biblioteca.taula.size();
    }

    public FitxerAudio donaFitxerAudio(int posicio) {
        return biblioteca.taula.get(posicio-1);
    }
    
}
