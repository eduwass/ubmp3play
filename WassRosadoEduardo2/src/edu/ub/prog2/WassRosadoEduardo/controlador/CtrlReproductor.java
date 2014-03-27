/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */


package edu.ub.prog2.WassRosadoEduardo.controlador;
import edu.ub.prog2.WassRosadoEduardo.model.DadesReproductor;
import edu.ub.prog2.WassRosadoEduardo.model.FitxerAudio;
import edu.ub.prog2.WassRosadoEduardo.model.LlistaFitxers;
import edu.ub.prog2.WassRosadoEduardo.model.LlistaReproduccio;
import edu.ub.prog2.utils.FitxerAudioErrorException;

/**
 *
 * @author edu.wass
 */
public class CtrlReproductor {
    
    // ========================
    // Atributos
    // ========================    
    
    
    // ========================
    // Funciones
    // ========================  
    
    public LlistaFitxers getBiblioteca(){return null;}
    public void afegirFitxer(FitxerAudio fa){}
    public void afegirFitxer(FitxerAudio fa, LlistaReproduccio llista){}
    public void eliminarFitxer(FitxerAudio fa){}
    public void eliminarFitxer(FitxerAudio fa, LlistaReproduccio llista){}
    public void crearLlistaReproduccio(String nomLlista){}
    public void eliminarLlistaReproduccio(LlistaReproduccio llista){}
    public void play(FitxerAudio fitxer) throws FitxerAudioErrorException{}
    
    // A més, mètodes per:
    // Comprovar que una posició donada d’un fitxer d’àudio sigui correcte en la biblioteca i en una llista de reproducció.
    // Comprovar que la posició donada d’una llista sigui correcta per a les llista de llistes.
    // Retornar el fitxer d'àudio d’una llista de reproducció a una posició donada.
}
