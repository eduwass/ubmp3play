/*
 * Eduardo Wass Rosado
 * eduwass@gmail.com
 */

package edu.ub.prog2.WassRosadoEduardo.vista;
import edu.ub.prog2.WassRosadoEduardo.controlador.CtrlReproductor;
import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 * Classe que implementa l'objecte principal de la vista
 * @author edu.wass
 */
public class ReproductorUB2 {

    
    // ========================
    // Atributos
    // ========================
            
    // MENU PRINCIPAL
    static private enum OpcionsMenuPrincipal {  MENU_PRINCIPAL_BIBLIOTECA,
                                                MENU_PRINCIPAL_LLISTES,
                                                MENU_PRINCIPAL_GUARDAR,
                                                MENU_PRINCIPAL_CARREGAR,
                                                MENU_PRINCIPAL_SORTIR};
    
    private static final String[] descMenuPrincipal={   "Gestió Biblioteca",
                                                        "Gestió Llistes Reproducció",
                                                        "Guardar dades",
                                                        "Carregar dades",
                                                        "Sortir de l'aplicació"};
    
     // MENU BIBLIOTECA
    static private enum OpcionsMenuBiblioteca{  MENU_BIBLIOTECA_AFEGIR,
                                                MENU_BIBLIOTECA_MOSTRAR,
                                                MENU_BIBLIOTECA_BORRAR,
                                                MENU_BIBLIOTECA_PLAY,
                                                MENU_BIBLIOTECA_SORTIR};
    
    private static final String[] descMenuBiblioteca={  "Afegir Fitxer Audio",
                                                        "Mostrar biblioteca",
                                                        "Eliminar fitxer",
                                                        "Reproduir canço",
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
    

    // ========================
    // Funciones
    // ========================  
    
    /**
     * Funcio constructora
     */
    public ReproductorUB2() {
        // Llamada para inicializar Controlador
        
        // (Posteriormente usado en las subfunciones del menu)
    }

    
    /**
     * Funció principal del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Creem un objecte per llegir des del teclat
        Scanner sc=new Scanner(System.in);       

        // Crear objeto ReproductorUB2
        ReproductorUB2 repro=new ReproductorUB2();
        
        // Mostrar menu
        repro.gestioMenuPrincipal(sc);
    }
    
    
    /**
     * Funció que gestiona el menu
     */
    private void gestioMenuPrincipal(Scanner sc) {
   
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
                case MENU_PRINCIPAL_GUARDAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                     
                    break;
                case MENU_PRINCIPAL_CARREGAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 4");
                    
                    break;                                              
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    
    }
        
    private void gestioMenuBiblioteca(Scanner sc){
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
                     
                    break;
                case MENU_BIBLIOTECA_MOSTRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    
                    break;
                case MENU_BIBLIOTECA_BORRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                     
                    break;
                case MENU_BIBLIOTECA_PLAY:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 4");
                    
                    break;                                              
                case MENU_BIBLIOTECA_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuBiblioteca.MENU_BIBLIOTECA_SORTIR);
    }

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
                     
                    break;
                case MENU_LLISTES_MOSTRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    
                    break;
                case MENU_LLISTES_BORRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                     
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

    private void gestioMenuLlista(Scanner sc){
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
                     
                    break;
                case MENU_LLISTA_MOSTRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    
                    break;
                case MENU_LLISTA_BORRAR:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                     
                    break;                                         
                case MENU_LLISTA_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuLlista.MENU_LLISTA_SORTIR);
    }    
}
