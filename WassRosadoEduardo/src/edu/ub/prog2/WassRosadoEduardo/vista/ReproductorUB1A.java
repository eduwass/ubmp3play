package edu.ub.prog2.WassRosadoEduardo.vista;
import edu.ub.prog2.WassRosadoEduardo.model.FitxerAudio;
import edu.ub.prog2.WassRosadoEduardo.model.TaulaFitxers;
import edu.ub.prog2.utils.Menu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Primera implementació del reproductor, fent servir la classe TaulaFitxers.
 * @author ewass
 */
public class ReproductorUB1A {
    
    // ========================
    // Atributos
    // ========================
        
    public TaulaFitxers taula;
    
    // Declarem les opcions per a referir-se a les opcions del menú.
    static private enum OpcionsMenuPrincipal {  MENU_PRINCIPAL_OPCIO1,
                                                MENU_PRINCIPAL_OPCIO2,
                                                MENU_PRINCIPAL_OPCIO3,
                                                MENU_PRINCIPAL_OPCIO4,
                                                MENU_PRINCIPAL_OPCIO5,
                                                MENU_PRINCIPAL_SORTIR};
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    private static final String[] descMenuPrincipal={"Afegir fitxer",
                                                    "Mostrar llista",
                                                    "Eliminar fitxer",
                                                    "Guardar llista",
                                                    "Recuperar llista",
                                                    "Sortir de l'aplicació"};

    // ========================
    // Funciones
    // ========================   
    

    /**
     * Funcio constructora
     */
    public ReproductorUB1A() {
        taula = new TaulaFitxers();
    }
    
    /**
     * Funció principal del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creem un objecte per llegir des del teclat
        Scanner sc=new Scanner(System.in);

        // Creem un objecte principal
        ReproductorUB1A repro=new ReproductorUB1A();

        // Iniciem la gestió del menú principal de l'aplicació
        repro.gestioMenuPrincipal(sc);
        
    }
    
    /**
     * Menú principal del reproductor d'audio
     * @param sc Objecte de tipus Scanner que permet accedir al teclat
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
                case MENU_PRINCIPAL_OPCIO1:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 1");
                    afegirFitxer(sc);
                    break;
                case MENU_PRINCIPAL_OPCIO2:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 2");
                    mostrarLlista();
                    break;
                case MENU_PRINCIPAL_OPCIO3:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 3");
                    eliminarFitxer(sc);
                    break;
                case MENU_PRINCIPAL_OPCIO4:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 4");
                    try {
                        guardarLlista(sc);
                    } catch (IOException ex) {
                        System.out.println("Error d'escritura.");
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO5:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opció 5");
                    try {
                        recuperarLlista(sc);
                    } catch (FileNotFoundException ex) {
                        System.out.println("L'arxiu no s'ha trobat.");
                    } catch (IOException ex) {
                        System.out.println("Error de lectura.");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Classe no trobata.");
                    }
                    break;                        
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }

    /**
     * Pas 1 del menu: afegirFitxer
     * @param sc scanner
     */
    private void afegirFitxer(Scanner sc){
        System.out.println("Introdueix ruta de Fitxer:");
        // Demanar dades de fitxer per teclat
        String nomFitxer = sc.nextLine();
        // Crear FitxerAudio;
        FitxerAudio f = new FitxerAudio(nomFitxer);
        f.demanaDadesTeclat(sc);
        taula.afegirFitxer(f);
    }
    
    /**
     * Pas 2 del menu: mostra llista de fitxers
     */
    private void mostrarLlista(){
        System.out.println(this.taula);
    }
    
    /**
     * Pas 3 del menu: elimina un fitxer donada posicio entrada per input
     * @param sc scanner
     */
    private void eliminarFitxer(Scanner sc){
        
        short posicio;
        
        // Donat una ruta, cercar a taula i retornar FitxerAudio
        System.out.println("Dona la posicio del fitxer a eliminar:");
        // Demanar dades de posicio per teclat
        while(true){
            try { 
                posicio = Short.parseShort(sc.nextLine());
                break;
            } catch (NumberFormatException e) { 
                System.out.println("Error: Posició de ser númeric!");
            }
        }
        
        
        if(posicio < this.taula.tamany()){
            // Si es posicio valida
            FitxerAudio Actual = this.taula.getAt(posicio);
            this.taula.eliminarFitxer(Actual);
            System.out.println("Fitxer eliminat.");
        } else {
            // Si no:
            System.out.println("Posicio no existeix.");
        }
        
        
    }
    
    /**
     * Pas 4 del menu: guardar llista a fitxer
     * @param sc scanner
     */
    private void guardarLlista(Scanner sc) throws IOException{
        // Demana ruta per guardar
        System.out.println("Dona la ruta per guardar llista:");
        // Demanar dades de ruta per teclat
        String nomFitxer = sc.nextLine();
        FileOutputStream fout = new FileOutputStream(nomFitxer);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this.taula);
        fout.close();
    }
    
    /**
     * Pas 5 del menu: carregar llista desde fitxer
     * @param sc  scanner
     */
    private void recuperarLlista(Scanner sc) throws FileNotFoundException, IOException, ClassNotFoundException{
        // Demana ruta per guardar
        System.out.println("Dona la ruta de l'arxiu per recuperar les dades:");
        // Demanar dades de ruta per teclat
        String nomFitxer = sc.nextLine();
        FileInputStream fin = new FileInputStream(nomFitxer);
        ObjectInputStream ois = new ObjectInputStream(fin);
        this.taula = (TaulaFitxers) ois.readObject();
        fin.close();        
    }
    
   
}
