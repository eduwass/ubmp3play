/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ub.prog2.WassRosadoEduardo.model;
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
    private String discografia;
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
     * @return boolea Indica si tot ha anat be
     */
    public boolean demanaDadesTeclat(){
        return true;
    }
    
    
    @Override
    public String toString(){
        return null;
    }    
}
