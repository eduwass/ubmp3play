package edu.ub.prog2.WassRosadoEduardo.model;
import java.io.Serializable;

/**
 * Classe que implementa una Taula funcional formada per objectes FitxerAudio
 * @author mat.aules
 */
public class TaulaFitxers implements Serializable {
    
    // ========================
    // Atributos
    // ========================
    
    private FitxerAudio[] taula;
    private final int tamanymax = 100;
    private int index = 0;
    
    // ========================
    // Funciones
    // ========================
    
    /**
     * Funcio constructora
     */
    public TaulaFitxers() {
        this.taula =  new FitxerAudio[tamanymax];
    }
    
    /**
     * Retorna el nombre d’elements que hi ha a la llista
     * @return nombre d'elements de la llista
     */
        
    public int tamany(){
        return this.index;
    }
    
    /**
     * Afegeix una nova cançó a la llista
     * @param fitxer Fitxer a afegir
     */
    public void afegirFitxer(FitxerAudio fitxer){
        if(this.tamany()<= this.tamanymax){
            this.taula[index] = fitxer; // afegir fitxer
            this.index++;               // incrementar index taula
        } 
    }
    
    /**
     * Elimina un fitxer de la llista si coincideix amb el fitxer passat.
     * @param fitxer que es vol eliminar
     */
    public void eliminarFitxer(FitxerAudio fitxer){
        // Recorrer lista
        for(int i=0;i<this.tamany();i++){
            // Coincideix ?
            if(fitxer.equals(this.taula[i])){
                // Si troba que coincideix hem d'eliminar i shiftar la resta
                // Eliminar posicio actual
                this.taula[i] = null;
                // Shiftar part dreta de lo eliminat
                for(int j=i;j<this.tamany();j++){
                    // desde posicio actual fins a final
                    if(j+1==this.tamany()){
                        // si es l'ultima posicio null automatic
                        this.taula[j] = null;
                        this.index--; // hem acabat, -1 index
                    } else {
                        if(this.taula[j+1]==null){
                            // si la seguent es null parem de shiftar
                            this.taula[j] = null;
                            break;
                        }
                        // si no shiftar
                        this.taula[j] = this.taula[j+1];
                    }
                }
            }
        }
    }
    
    /**
     * Retorna la cançó a la posició indicada de la llista.
     * @param position posicio indicada
     * @return FitxerAudio si trobat, null si no existeix posicio
     */
    public FitxerAudio getAt(int position){
        if(position>=0 && position<=this.tamany()){
            return this.taula[position];
        } else {
            return null;
        }
    }
    
    /**
     * Eliminar tots els elements de la llista
     */
    public void clear(){
        this.taula = null;
        this.taula = new FitxerAudio[tamanymax];
    }
    
    /**
     * Indica si la llista està plena
     * @return boolean true=plena, false=no plena
     */
    protected boolean isFull(){
        if(this.tamany()==this.tamanymax){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Dona output legible de l'objecte TaulaFitxers
     * @return string legible amb elements de l'objecte
     */
    @Override
    public String toString(){
        
        if(this.tamany()==0){
            return "No hi ha fitxers.";
        }
        
        String retorn = "Llista Fitxers\n"+"==============";
        for(int i=0;i<this.tamany();i++){
            retorn += "\n["+i+"] | ";
            retorn += this.taula[i];
        }
        return retorn;
        
    }

}
