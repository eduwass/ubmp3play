package edu.ub.prog2.WassRosadoEduardo.model;
import java.util.Scanner;
import java.io.File;
import java.io.Serializable;

/**
 * Classe que defineix un Fitxer de Audio i el seus atributs.
 * Heredada de la classe File de Java.
 * @author mat.aules
 */
public class FitxerAudio extends File implements Serializable {
    
    // ========================
    // Atributos
    // ========================
    private String nombre;
    private String autor;
    private String disco;
    private short ano;
    private short numero;
    private String discografica;
    private double duracion;

    
    // ========================
    // Funciones
    // ========================

    /**
     * Funcio constructora
     * @param cami Ruta al fitxer
     */
    public FitxerAudio(String cami) {
        super(cami);
    }

    /**
     * Demana per teclat atributs de FitxerAudio i es guarden a l'objecte.
     * @param sc Scanner
     */
    public void demanaDadesTeclat(Scanner sc){
        // Demanar dades de fitxer per teclat
        
        System.out.println("Nom:");
        this.nombre = sc.nextLine();
        
        System.out.println("Autor:");
        this.autor = sc.nextLine();
        
        System.out.println("Disc:");
        this.disco = sc.nextLine();
        
        System.out.println("Any:");
        while(true){
            try { 
                this.ano = Short.parseShort(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Any ha de ser númeric!");
            }
        }
        
        System.out.println("Numero canço:");
        while(true){
            try { 
                this.numero = Short.parseShort(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Numero ha de ser númeric!");
            }
        }
        
        System.out.println("Discogràfica:");
        this.discografica = sc.nextLine();
        
        System.out.println("Duracion:");
        while(true){
            try { 
                this.duracion = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Duració ha de ser númeric!");
            }
        }
        
    }
    
    /**
     * Dona output legible de l'objecte FitxerAudio
     * @return string legible amb elements de l'objecte
     */
    @Override
    public String toString(){
        String retorn = "";
        retorn = "Titol: "+this.nombre+
                " | Autor: "+this.autor+
                " | Disc: "+this.disco+
                " | Pista: "+this.numero+
                " | Discogràfica: "+this.discografica+
                " | Duració: "+this.duracion+
                " | Any: "+this.ano+
                " | Fitxer: <"+this.getPath()+"> |\n";
        return retorn;
    }
    
    /**
     * Compara que dos fitxers tinguin exactament els mateixos atributs
     * @param f2 Fitxer a comparar
     * @return boolean true=iguals, false=diferents
     */
    public boolean equals(FitxerAudio f2){
        
        if(!this.getPath().equals(f2.getPath()))          { return false; }
        if(!this.nombre.equals(f2.nombre) )               { return false; }
        if(!this.autor.equals(f2.autor) )                 { return false; }
        if(!this.disco.equals(f2.disco) )                 { return false; }
        if(this.ano != f2.ano )                           { return false; }
        if(this.numero != f2.numero )                     { return false; }
        if(!this.discografica.equals(f2.discografica) )   { return false; }
        if(this.duracion != f2.duracion )                 { return false; }        
        
        return true;
    }        
}
