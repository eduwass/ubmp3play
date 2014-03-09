/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ub.prog2.WassRosadoEduardo.model;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author mat.aules
 */
public class FitxerAudio extends File {
    
    // ========================
    // Atributos
    // ========================
    private String nombre;
    private String autor;
    private String disco;
    private short ano;
    private short numero;
    private String discografica;
    private int duracion;

    
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
     * Demana per teclat dades de un FitxerAudio
     * @param sc Scanner
     * @return boolea Indica si tot ha anat be
     */
    public boolean demanaDadesTeclat(Scanner sc){
        // Demanar dades de fitxer per teclat
        
        System.out.println("Nom:");
        this.nombre = sc.nextLine();
        
        System.out.println("Autor:");
        this.autor = sc.nextLine();
        
        System.out.println("Disc:");
        this.disco = sc.nextLine();
        
        System.out.println("Any:");
        try { 
            this.ano = Short.parseShort(sc.nextLine());
        } catch (NumberFormatException e) { 
            return false; 
        }
        
        System.out.println("Numero canço:");
        try { 
            this.numero = Short.parseShort(sc.nextLine());
        } catch (NumberFormatException e) { 
            return false; 
        }
        
        System.out.println("Discogràfica:");
        this.discografica = sc.nextLine();
        
        System.out.println("Duracion:");
        try { 
            this.duracion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) { 
            return false; 
        }
        
        return true;
    }
    
    
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
     * @return true/false
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
