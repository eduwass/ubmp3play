/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.vista;
import edu.ub.prog2.WassRosadoEduardo.controlador.CtrlReproductor;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerNoExisteix;
import edu.ub.prog2.WassRosadoEduardo.controlador.ExcepcioFitxerRepetit;
import edu.ub.prog2.WassRosadoEduardo.model.DadesReproductor;
import edu.ub.prog2.WassRosadoEduardo.model.FitxerAudio;
import edu.ub.prog2.WassRosadoEduardo.model.LlistaReproduccio;
import edu.ub.prog2.utils.FitxerAudioErrorException;
import edu.ub.prog2.utils.Menu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que implementa l'objecte principal de la vista
 * @author edu.wass
 */
public class ReproductorUB3 {

    
    // ========================
    // Atributos
    // ========================
            
    // MENU PRINCIPAL
    static private enum OpcionsMenuPrincipal {  MENU_PRINCIPAL_BIBLIOTECA,
                                                MENU_PRINCIPAL_LLISTES,
                                                MENU_PRINCIPAL_REPRODUCCIO,
                                                MENU_PRINCIPAL_GUARDAR,
                                                MENU_PRINCIPAL_CARREGAR,
                                                MENU_PRINCIPAL_SORTIR};
    
    private static final String[] descMenuPrincipal={   "Gestió Biblioteca",
                                                        "Gestió Llistes Reproducció",
                                                        "Control Reproducció",
                                                        "Guardar dades",
                                                        "Carregar dades",
                                                        "Sortir de l'aplicació"};
    
     // MENU BIBLIOTECA
    static private enum OpcionsMenuBiblioteca{  MENU_BIBLIOTECA_AFEGIR,
                                                MENU_BIBLIOTECA_MOSTRAR,
                                                MENU_BIBLIOTECA_BORRAR,
                                                MENU_BIBLIOTECA_SORTIR};
    
    private static final String[] descMenuBiblioteca={  "Afegir Fitxer Audio",
                                                        "Mostrar biblioteca",
                                                        "Eliminar fitxer",
                                                        "Menu Anterior"};
    
    // MENU LLISTES DE REPRODUCCIO
    static private enum OpcionsMenuLlistes {    MENU_LLISTES_AFEGIR,
                                                MENU_LLISTES_MOSTRAR,
                                                MENU_LLISTES_BORRAR,
                                                MENU_LLISTES_GESTIONAR,
                                                MENU_LLISTES_SORTIR};
    
    private static final String[] descMenuLlistes={ "Afegir Llista",
                                                    "Mostrar llistes",
                                                    "Eliminar llista",
                                                    "Gestionar llista",
                                                    "Menu Anterior"};
    

    
    // MENU LLISTA
    static private enum OpcionsMenuLlista{  MENU_LLISTA_AFEGIR,
                                            MENU_LLISTA_MOSTRAR,
                                            MENU_LLISTA_BORRAR,
                                            MENU_LLISTA_SORTIR};
    
    private static final String[] descMenuLlista={  "Afegir Fitxer Audio",
                                                    "Mostrar llista",
                                                    "Eliminar fitxer",
                                                    "Menu Anterior"};
    
    // MENU REPRODUCCIO
    static private enum OpcionsMenuReproduccio { MENU_REPRODUCCIO_REP_CANCO,
                                                 MENU_REPRODUCCIO_REP_BIB,
                                                 MENU_REPRODUCCIO_REP_LISTA,
                                                 MENU_REPRODUCCIO_RANDOM,
                                                 MENU_REPRODUCCIO_ORDERED,
                                                 MENU_REPRODUCCIO_GESTIONAR,
                                                 MENU_REPRODUCCIO_SORTIR};
    
   
    private static final String[] descMenuReproduccio={ "Repr. cançó",
                                                        "Repr. biblioteca",
                                                        "Repr. llista",
                                                        "Activar/desactivar repr.aleatoria",
                                                        "Activar/desactivar repr.cíclica",
                                                        "Gestió reproducció",
                                                        "Menu anterior"};
    
    // MENU GESTIO REPRODUCCIO
    static private enum OpcionsMenuGestReproduccio { MENU_GESTREPR_PLAY,
                                                 MENU_GESTREPR_PAUSE,
                                                 MENU_GESTREPR_NEXT,
                                                 MENU_GESTREPR_STOP,
                                                 MENU_GESTREPR_SORTIR};
    
   
    private static final String[] descMenuGestReproduccio={ "Play",
                                                        "Pausa",
                                                        "Següent",
                                                        "Stop",
                                                        "Menu anterior"};
    
    // Enlace a Controlador
    private CtrlReproductor Controlador;
    
    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funcio constructora
     */
    public ReproductorUB3() {
        this.Controlador = new CtrlReproductor();

    }

    
    /**
     * Funció principal del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix {
         // Creem un objecte per llegir des del teclat
        Scanner sc=new Scanner(System.in);       

        // Crear objeto ReproductorUB3
        ReproductorUB3 repro=new ReproductorUB3();
        
        // Mostrar menu
        repro.gestioMenuPrincipal(sc);
    }
    
    
    /**
     * Funció que gestiona el menu principal
     * @param sc 
     */
    private void gestioMenuPrincipal(Scanner sc) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix {
   
        // Creem l'objecte per al menú. 
        // Li passem com a primer paràmetre el nom del menú
        Menu menu=new Menu("Menu Principal",OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=(OpcionsMenuPrincipal) menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case MENU_PRINCIPAL_BIBLIOTECA:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 1");
                    gestioMenuBiblioteca(sc);
                    break;
                case MENU_PRINCIPAL_LLISTES:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    gestioMenuLlistes(sc);
                    break;
                case MENU_PRINCIPAL_REPRODUCCIO:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    gestioMenuReproduccio(sc);
                    break;
                case MENU_PRINCIPAL_GUARDAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 4");
                    try {
                        guardar(sc);
                    } catch (IOException ex) {
                        System.out.println("Error: no s'ha pogut guardar.");
                    }
                    break;
                case MENU_PRINCIPAL_CARREGAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 5");
                    try {
                        carregar(sc);
                    } catch (FileNotFoundException ex1){
                        System.out.println("Error: no s'ha pogut carregar (FileNotFoundException)");
                    } catch (IOException ex2){
                        System.out.println("Error: no s'ha pogut carregar (IOException)");
                        System.out.println(ex2.getMessage());
                    } catch (ClassNotFoundException ex3){
                        System.out.println("Error: no s'ha pogut carregar (ClassNotFoundException)");
                    }
                    
                    break;                                              
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    
    }
    
    /**
     * Funció que gestiona el menu de biblioteca
     * @param sc 
     */
    private void gestioMenuBiblioteca(Scanner sc) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix{
        // Creem l'objecte per al menú. 
        // Li passem com a primer paràmetre el nom del menú
        Menu menu=new Menu("Menu Biblioteca",OpcionsMenuBiblioteca.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuBiblioteca);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuBiblioteca opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();
            
            // Demanem una opcio
            opcio=(OpcionsMenuBiblioteca) menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case MENU_BIBLIOTECA_AFEGIR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 1");
                    try {
                        bibliotecaAfegir(sc);
                    } catch (ExcepcioFitxerNoExisteix e1){
                        System.out.println("Error: fitxer no existeix");
                    } catch (ExcepcioFitxerRepetit e2){
                        System.out.println("Error: fitxer repetit");
                    }
                    
                    break;
                case MENU_BIBLIOTECA_MOSTRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    bibliotecaMostrar(sc);
                    break;
                case MENU_BIBLIOTECA_BORRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    bibliotecaBorrar(sc);
                    break;                                       
                case MENU_BIBLIOTECA_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuBiblioteca.MENU_BIBLIOTECA_SORTIR);
    }

    /**
     * Funció que gestiona el menu de llistes de reproducció
     * @param sc 
     */
    private void gestioMenuLlistes(Scanner sc){
        // Creem l'objecte per al menú. 
        // Li passem com a primer paràmetre el nom del menú
        Menu menu=new Menu("Menu Llistes de Reproducció",OpcionsMenuLlistes.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuLlistes);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuLlistes opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=(OpcionsMenuLlistes) menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case MENU_LLISTES_AFEGIR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 1");
                    llistesAfegir(sc);
                    break;
                case MENU_LLISTES_MOSTRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    llistesMostrar();
                    break;
                case MENU_LLISTES_BORRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    llistesBorrar(sc);
                    break;
                case MENU_LLISTES_GESTIONAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    gestioMenuLlista(sc);
                    break;                                              
                case MENU_LLISTES_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuLlistes.MENU_LLISTES_SORTIR);
    }

    /**
     * Funció que gestiona el menu de gestió de una llista
     * @param sc 
     */    
    private void gestioMenuLlista(Scanner sc){
        
        llistesMostrar();
        
        int posicio;
        System.out.println("Dona la posicio de la llista que vols gestionar:");
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                posicio = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((posicio > 0) && (posicio <= Controlador.donaTamanyLlistes())){

            // Creem l'objecte per al menú. 
            // Li passem com a primer paràmetre el nom del menú
            Menu menu=new Menu("Menu Llista",OpcionsMenuLlista.values());

            // Assignem la descripció de les opcions
            menu.setDescripcions(descMenuLlista);

            // Obtenim una opció des del menú i fem les accions pertinents
            OpcionsMenuLlista opcio = null;
            do {
                // Mostrem les opcions del menú
                menu.mostrarMenu();

                // Demanem una opcio
                opcio=(OpcionsMenuLlista) menu.getOpcio(sc);

                // Fem les accions necessàries
                switch(opcio) {
                    case MENU_LLISTA_AFEGIR:
                        // Mostrem un missatge indicant que s'ha triat aquesta opció
                        System.out.println("Has triat la opció 1");
                        llistaAfegir(sc, posicio);
                        break;
                    case MENU_LLISTA_MOSTRAR:
                        // Mostrem un missatge indicant que s'ha triat aquesta opció
                        System.out.println("Has triat la opció 2");
                        llistaMostrar(sc, posicio);
                        break;
                    case MENU_LLISTA_BORRAR:
                        // Mostrem un missatge indicant que s'ha triat aquesta opció
                        System.out.println("Has triat la opció 3");
                        llistaBorrar(sc, posicio);
                        break;                                         
                    case MENU_LLISTA_SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }

            } while(opcio!=OpcionsMenuLlista.MENU_LLISTA_SORTIR);            
            
        }        
        

    }    

    /**
     * Funció que gestiona el menu de reproducció
     * @param sc 
     */
    private void gestioMenuReproduccio(Scanner sc){
        // Creem l'objecte per al menú. 
        // Li passem com a primer paràmetre el nom del menú
        Menu menu=new Menu("Menu de Reproducció",OpcionsMenuReproduccio.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuReproduccio);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuReproduccio opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=(OpcionsMenuReproduccio) menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case MENU_REPRODUCCIO_REP_CANCO:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 1");
                    reprCanco(sc);
                    break;
                case MENU_REPRODUCCIO_REP_BIB:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    reprBib();
                    break;
                case MENU_REPRODUCCIO_REP_LISTA:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    reprLlista(sc);
                    break;
                case MENU_REPRODUCCIO_RANDOM:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 4");
                    if(Controlador.setRandom()){
                        System.out.println("Aleatori activat.");
                    } else {
                        System.out.println("Aleatori desactivat.");
                    }
                    break;
                case MENU_REPRODUCCIO_ORDERED:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 5");
                    if(Controlador.setCiclic()){
                        System.out.println("Ciclic activat.");
                    } else {
                        System.out.println("Ciclic desactivat.");
                    }
                    break;
                case MENU_REPRODUCCIO_GESTIONAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 6");
                    gestioMenuGestReproduccio(sc);
                    break;
                case MENU_REPRODUCCIO_SORTIR:
                    break;
            }

        } while(opcio!=OpcionsMenuReproduccio.MENU_REPRODUCCIO_SORTIR);
    }
     
    /**
     * Funció que gestiona el menu de gestio de reproducció
     * @param sc 
     */
    private void gestioMenuGestReproduccio(Scanner sc){
        // Creem l'objecte per al menú. 
        // Li passem com a primer paràmetre el nom del menú
        Menu menu=new Menu("Menu de Gest.Reproducció",OpcionsMenuGestReproduccio.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuGestReproduccio);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuGestReproduccio opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=(OpcionsMenuGestReproduccio) menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case MENU_GESTREPR_PLAY:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 1");
                    Controlador.play();
                    break;
                case MENU_GESTREPR_PAUSE:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    Controlador.pause();
                    break;
                case MENU_GESTREPR_NEXT:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    next();
                    break;
                case MENU_GESTREPR_STOP:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 4");
                    Controlador.stop();
                    break;
                case MENU_GESTREPR_SORTIR:
                    break;
            }

        } while(opcio!=OpcionsMenuGestReproduccio.MENU_GESTREPR_SORTIR);
    }
    
    
    /**
     * Implementa opcio del menu: Afegir fitxer a biblioteca
     * @param sc 
     */
    private void bibliotecaAfegir(Scanner sc) throws ExcepcioFitxerRepetit, ExcepcioFitxerNoExisteix{
        
        System.out.println("Introdueix ruta de Fitxer:");
        // Demanar dades de fitxer per teclat
        String rutaFitxer = sc.nextLine();
        FitxerAudio f = new FitxerAudio(rutaFitxer);
        // Llamar a controlador para que inserte fichero
        try {
            Controlador.afegirFitxer(f);
        } catch(ExcepcioFitxerNoExisteix ex1){
            System.out.println("La ruta no existeix.");
        } catch(ExcepcioFitxerRepetit ex2){
            System.out.println("El fitxer ja existeix.");
        }
    }
    
    /**
     * Implementa opcio del menu: mostrar biblioteca
     * @param sc 
     */
    private void bibliotecaMostrar(Scanner sc){
        String mostrarBiblioteca = Controlador.mostrarBiblioteca();
        System.out.println(mostrarBiblioteca);
    }
    
    /**
     * Implementa opcio del menu: borrar fitxer bibliotca
     * @param sc 
     */
    private void bibliotecaBorrar(Scanner sc){
        
        int posicio;
        System.out.println("Dona la posicio del fitxer a eliminar:");
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                posicio = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((posicio > 0) && (posicio <= Controlador.donaTamanyBiblioteca())){
            // Recuperar fichero en esa posicion
            FitxerAudio f = Controlador.donaFitxerAudio(posicio);
            // Eliminar fichero de biblioteca
            Controlador.eliminarFitxer(f);
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }
            
    }

    /**
     * Implementa opció del menu: reproduir arxiu
     * @param sc 
     */    
    private void bibliotecaPlay(Scanner sc){
        // No implementat
    }

    /**
     * Implementa opció del menu: afegir llista
     * @param sc 
     */
    private void llistesAfegir(Scanner sc) {
        
        // Demanar nom llista
        String nombre;
        System.out.println("Nom:");
        nombre = sc.nextLine();
        
        // Comprovar que no estigui repetida
        if(Controlador.existeixLlista(nombre)){
            System.out.println("Error: ja existeix una llista amb aquest nom.");
        } else {        
            // Si no esta repetida, crear
            Controlador.crearLlistaReproduccio(nombre);
        }
        
        
        
    }

    /**
     * Implementa opció del menu: mostrar llistes
     */
    private void llistesMostrar() {
        if(Controlador.donaTamanyLlistes()>0){
            ArrayList<String> llistes = Controlador.getLlistesReproduccio();
            String retorn = "";
            int i = 1;
            for(String llista:llistes){
                retorn += "\n["+i+"] | ";
                retorn += llista;
                i++;
            }
            System.out.println(retorn);            
        } else {
            System.out.println("No hi ha llistes de reproducció.");
        }

    }

    /**
     * Implementa opció del menu: elimininar llista
     * @param sc 
     */
    private void llistesBorrar(Scanner sc) {
        
        int posicio;
        System.out.println("Dona la posicio de la llista a eliminar:");
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                posicio = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((posicio > 0) && (posicio <= Controlador.donaTamanyLlistes())){
            // Eliminar fichero de biblioteca
            Controlador.eliminarLlistaReproduccio(posicio);
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }
        
    }

    /**
     * Implementa opcio del menú: afegir fitxer a llista
     * @param sc 
     */
    private void llistaAfegir(Scanner sc, int posicio) {
        bibliotecaMostrar(sc);
        System.out.println("Introdueix posició del Fitxer que vols afegir a llista:");
        // Demanar posicio de fitxer a afegir a llista
        int fitxer;
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                fitxer = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((fitxer > 0) && (fitxer <= Controlador.donaTamanyBiblioteca())){
            // Recuperar fichero en esa posicion
            FitxerAudio f = Controlador.donaFitxerAudio(fitxer);
            LlistaReproduccio l = Controlador.donaLlista(posicio);
            Controlador.afegirFitxer(f, l);
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }       
    }

     /**
     * Implementa opcio del menú: mostrar fitxers de llista
     * @param sc 
     */
    private void llistaMostrar(Scanner sc, int posicio) {
        LlistaReproduccio llista = Controlador.donaLlista(posicio);
        String mostrarLlista = Controlador.mostrarLlista(llista);
        System.out.println(mostrarLlista);
    }


    /**
     * Implementa opcio del menú: eliminar fitxer de llista
     * @param sc 
     */    
    private void llistaBorrar(Scanner sc, int posicio) {
        
        // Obtenir info llista actual
        LlistaReproduccio llista = Controlador.donaLlista(posicio);
        int tamanyllista = llista.donaTamany();
        
        llistaMostrar(sc, posicio);
        System.out.println("Introdueix posició del Fitxer que vols eliminar:");
        // Demanar posicio de fitxer a afegir a llista
        int fitxer;
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                fitxer = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((fitxer > 0) && (fitxer <= tamanyllista)){
            // Recuperar fichero en esa posicion
            FitxerAudio f = llista.donaFitxer(fitxer);
            Controlador.eliminarFitxer(f, llista);
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }
    }

    /**
     * Implementa opcio del menú: guardar
     * @param sc 
     */        
    private void guardar(Scanner sc) throws IOException{
        
        // Demana ruta per guardar
        System.out.println("Dona la ruta per guardar llista:");
        // Demanar dades de ruta per teclat
        String nomFitxer = sc.nextLine();
        FileOutputStream fout = new FileOutputStream(nomFitxer);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(Controlador.donaDadesReproductor());
        fout.close();
               
    }

    /**
     * Implementa opcio del menú: carregar
     * @param sc 
     */        
    private void carregar(Scanner sc) throws FileNotFoundException, IOException, ClassNotFoundException{
        // Demana ruta per guardar
        System.out.println("Dona la ruta de l'arxiu per recuperar les dades:");
        // Demanar dades de ruta per teclat
        String nomFitxer = sc.nextLine();
        try (FileInputStream fin = new FileInputStream(nomFitxer)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            Controlador.carregarDadesReproductor((DadesReproductor) ois.readObject());
        }            
    }
    
    /**
     * Funció que es crida per reproduri canco
     * @param sc 
     */
    private void reprCanco(Scanner sc) {
        Controlador.mostrarBiblioteca();
        
        int posicio;
        System.out.println("Dona la posicio del fitxer a reproduir:");
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                posicio = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((posicio > 0) && (posicio <= Controlador.donaTamanyBiblioteca())){
            // Recuperar fichero en esa posicion
            FitxerAudio f = Controlador.donaFitxerAudio(posicio);
            try {
                // Reproducir!
                Controlador.playFitxer(f);
            } catch (FitxerAudioErrorException ex) {
                System.out.println("Error: Error al reproduir fitxer");
            }
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }
        
    }
    
    /**
     * Funció que es crida per reproduir biblioteca
     */
    private void reprBib(){
        try {
            Controlador.playLlista(Controlador.getBiblioteca());
        } catch (FitxerAudioErrorException ex) {
            System.out.println("Error: Error al reproduir fitxer");
        }
    }
    
    /**
     * Funció que es crida per reproduir llista
     * @param sc 
     */
    private void reprLlista(Scanner sc){
        this.llistesMostrar();
        int posicio;
        System.out.println("Dona la posicio de la llista a reproduir:");
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                posicio = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        if((posicio > 0) && (posicio <= Controlador.donaTamanyLlistes())){
            try {
                // Reproducir lista
                LlistaReproduccio l = Controlador.donaLlista(posicio);
                Controlador.playLlista(l.donaLlistaFitxers());
            } catch (FitxerAudioErrorException ex) {
                System.out.println("Error: Error al reproduir fitxer");
            }
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }       
    }

    /**
     * Funció que es crida per canviar a seguent canco
     */
    private void next(){
        try {
            Controlador.next();
        } catch (FitxerAudioErrorException ex) {
            System.out.println("Error: Error al reproduir fitxer");
        }
    }
    
    

}