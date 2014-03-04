package reproductorub1a;


import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ewass
 */
public class FitxerAudio extends File {
    
    // Atributos
    public String nombre;
    public String autor;
    public String disco;
    public short ano;
    public String discografia;
    public int duracion;

    public FitxerAudio(String string) {
        super(string);
    }
    
    // Funciones
    public boolean demanaDadesTeclat(){
        return true;
    }
    
    
    @Override
    public String toString(){
        return null;
    }
}
