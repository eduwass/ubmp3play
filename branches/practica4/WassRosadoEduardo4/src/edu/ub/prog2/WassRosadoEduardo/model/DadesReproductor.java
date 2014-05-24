/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */


package edu.ub.prog2.WassRosadoEduardo.model;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerNoExisteix;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerRepetit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author edu.wass
 */
public class DadesReproductor implements Serializable {
    
    // ========================
    // Atributos
    // ========================    
    
    // una biblioteca (LlistaFitxers)
    private LlistaFitxers biblioteca;
    
    // una coleccion de listas de reproduccion (LlistaReproduccio)
    private ArrayList<LlistaReproduccio> llistes_reproduccio;
    
    // debemos declarar el serialVersionUID del  para garantizar la serialización!
    private static final long serialVersionUID = 123456789;
    
    public boolean ciclic;
    public boolean aleatori;
    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funció constructora
     */
    public DadesReproductor(){
        this.biblioteca = new LlistaFitxers();
        this.llistes_reproduccio = new ArrayList<>();
        this.ciclic = false;
        this.aleatori = false;
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
     * @throws edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerRepetit 
     * @throws edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerNoExisteix 
     */
    public void afegirFitxerBiblioteca(FitxerAudio fitxer) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix {
        biblioteca.afegirFitxer(fitxer);
    }
    
    /**
     * Eliminar fitxer de la biblioteca i llistes donat fitxer
     * @param fitxer 
     */
    public void eliminarFitxerBiblioteca(FitxerAudio fitxer) {
        biblioteca.eliminarFitxer(fitxer);
        for(LlistaReproduccio llista:llistes_reproduccio){
            if(llista.existeixFitxer(fitxer)){
                llista.eliminarFitxer(fitxer);
            }
        }
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
     * @return str
     */
    public String mostrarBiblioteca(){
        return biblioteca.mostrarLlista();
    }
    
    /**
     * Mostra continguts llista reproducció
     * @param llista 
     * @return  str
     */
    public String mostrarLlista(LlistaReproduccio llista){
        return llista.mostrarLlista();
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
    
    /**
     * Elimina llista donada posició
     * @param posicio 
     */
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

    /**
     * Dona FitxerAudio de biblioteca donada posició
     * @param posicio
     * @return FitxerAudio
     */
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

    /**
     * Dona FitxerAudio donada llista i posició a la llista
     * @param posicio
     * @param llista
     * @return FitxerAudio
     */
    public FitxerAudio donaFitxerAudio(int posicio, LlistaReproduccio llista) {
        return llista.donaFitxer(posicio);
    }

    /**
     * Retorna tot l'objecte DadesReproductor (biblioteca i llistes)
     * @return objecte
     */
    public DadesReproductor donaDadesReproductor() {
        return this;
    }

    /**
     * Carrega dades d'objecte
     * @param readObject 
     */
    public void carregarDadesReproductor(DadesReproductor readObject) {
        this.biblioteca = readObject.biblioteca;
        this.llistes_reproduccio = readObject.llistes_reproduccio;
    }
    
    /**
     * Estableix reproducció aleatoria
     */
    public void setRandom(boolean valor){
        this.aleatori = valor;
    }
    
    /**
     * Estableix reproducció cíclica
     */
    public void setCiclic(boolean valor){
        this.ciclic = valor;
    }
    
}
