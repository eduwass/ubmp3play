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
    
    /**
     * Comprova si ja existeix el fitxer a la biblioteca
     * @param fitxer
     * @return booleà
     */
    public boolean existeixFitxerBiblioteca(FitxerAudio fitxer){
        return biblioteca.existeixFitxer(fitxer);
    }
    
    /**
     * Comprova si ja existeix una llista amb el mateix nom
     * @param nomllista
     * @return booleà
     */
    public boolean existeixLlista(String nomllista){
        for(LlistaReproduccio llista: this.llistes_reproduccio){
            // recorrer listas
            if(llista.getNom().equals(nomllista)){
                // si coincide nombre return true
                return true;
            }
        }
        // si no false
        return false;
    }
    
    /**
     * Afegir fitxer a llista reproducció donat fitxer i llista
     * @param fitxer
     * @param lrep 
     */
    public void afegirFitxerLlista(FitxerAudio fitxer, LlistaReproduccio lrep) {
        lrep.afegirFitxer(fitxer);
    }
    
    /**
     * Eliminar fitxer de llista reproducció donat fitxer i llista
     * @param fitxer
     * @param lrep 
     */
    public void eliminarFitxerLlista(FitxerAudio fitxer, LlistaReproduccio lrep){
        lrep.eliminarFitxer(fitxer);
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
     * Mostra continguts llista reproducció
     * @param llista 
     */
    public void mostrarLlista(LlistaReproduccio llista){
        llista.mostrarLlista();
    }
    
    /**
     * Crea nova llista de reproducció amb el nom donat
     * @param nom 
     */
    public void afegirLlista(String nom){
        // Crear lista
        LlistaReproduccio llista = new LlistaReproduccio(nom);
        llistes_reproduccio.add(llista);
    }
    
    public void eliminarLlista(int posicio){
        llistes_reproduccio.remove(posicio-1);
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

    /**
     * Retorna noms de llistes de reproducció
     * @return string array
     */
    public ArrayList<String> getLlistesReproduccio() {
        ArrayList<String> retorn = new ArrayList<>();
        for(LlistaReproduccio llista:llistes_reproduccio){
            retorn.add(llista.getNom());
        }
        return retorn;
    }

    /**
     * Dona quantitat de llistes de reproducció
     * @return int
     */
    public int donaTamanyLlistes() {
        return this.llistes_reproduccio.size();
    }

    /**
     * Dona llista de reproducció donada posició
     * @param posicio
     * @return LlistaReproduccio
     */
    public LlistaReproduccio donaLlista(int posicio) {
        return this.llistes_reproduccio.get(posicio-1);
    }

    public FitxerAudio donaFitxerAudio(int posicio, LlistaReproduccio llista) {
        return llista.donaFitxer(posicio);
    }
    
}
