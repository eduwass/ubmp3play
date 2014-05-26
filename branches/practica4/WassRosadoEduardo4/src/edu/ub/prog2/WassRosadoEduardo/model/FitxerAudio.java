/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.model;
import java.util.Scanner;
import java.io.File;
import java.io.Serializable;

/**
 * Classe que defineix un Fitxer de Audio i el seus atributs.
 * Heredada de la classe File de Java.
 * @author edu.wass
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
    
    // Setters:
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setDisco(String disco){
        this.disco = disco;
    }

    public void setDiscografica(String discografica){
        this.discografica = discografica;
    }
    
    public void setDuracion(double duracion){
        this.duracion = duracion;
    }
    
    public void setAno(short ano){
        this.ano = ano;
    }
    
    public void setNumero(short numero){
        this.numero = numero;
    }
    
    

      
}
