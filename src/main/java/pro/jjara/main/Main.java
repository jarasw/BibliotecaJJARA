package pro.jjara.main;

import java.util.Scanner;
import pro.jjara.modelo.Llibre;
import pro.jjara.controlador.Biblioteca;
import pro.jjara.utils.GestorArxius;

/**
 * Classe principal del programa de gestió de biblioteca.
 * Permet afegir llibres, cercar-los, fer prèstecs i retornar llibres.
 * Les dades es carreguen i es guarden en un fitxer CSV.
 */
public class Main {

    /**
     * Mètode principal. Mostra un menú d'opcions per gestionar llibres.
     * @param args Arguments de la línia de comandes.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Carrega els llibres des d'un fitxer CSV al iniciar el programa
        GestorArxius.carregarLlibres("biblioteca.csv");

        int opcio = -1;

        while (opcio != 0) {
            System.out.println("\n1. Afegir llibre");
            System.out.println("2. Cercar per títol");
            System.out.println("3. Fer prèstec");
            System.out.println("4. Retornar llibre");
            System.out.println("0. Sortir");
            System.out.print("Selecciona una opcio: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {
                case 1:
                    // Opció per afegir un nou llibre
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Títol: ");
                    String titol = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    Llibre llibre = new Llibre(isbn, titol, autor, "DISPONIBLE");
                    Biblioteca.afegirLlibre(llibre);
                    break;

                case 2:
                    // Opció per cercar un llibre pel títol
                    System.out.print("Títol a cercar: ");
                    String cerca = sc.nextLine();
                    Llibre trobat = Biblioteca.cercarPerTitol(cerca);
                    if (trobat != null) {
                        System.out.println("Trobat: " + trobat.getTitol() + " - " + trobat.getAutor() + " - " + trobat.getEstat());
                    } else {
                        System.out.println("No trobat.");
                    }
                    break;

                case 3:
                    // Opció per fer un prèstec d’un llibre posant l’ISBN
                    System.out.print("ISBN a prestar: ");
                    Biblioteca.ferPrestec(sc.nextLine());
                    break;

                case 4:
                    // Opció per retornar un llibre posant l’ISBN
                    System.out.print("ISBN a retornar: ");
                    Biblioteca.retornarLlibre(sc.nextLine());
                    break;

                case 0:
                    // Guarda els llibres abans de sortir a la carpeta csv
                    GestorArxius.guardarLlibres("csv/biblioteca.csv");
                    break;

                default:
                    // Error default
                    System.out.println("Opció no vàlida.");
            }
        }

        // Tanca l’escàner
        sc.close();
    }
}
