package pro.jjara.utils;

import java.io.*;
import java.util.*;
import pro.jjara.modelo.Llibre;
import pro.jjara.controlador.Biblioteca;

/**
 * Classe per gestionar la lectura i escriptura d'arxius de llibres.
 * 
 * Estic usant NetBeans i realment era un codi més simple 
 * s'estava creant el CSV. El que passa és que les carpetes que contenen coses com "csv" 
 * el IDE no les mostra. Per això vaig fer que es creés una carpeta csv dins, 
 * no era necessari però com és funcional ho deixo.
 */
public class GestorArxius {

    /**
     * Carrega els llibres d’un fitxer CSV i els afegeix a la biblioteca.
     * El fitxer ha de tenir format: ISBN;Títol;Autor;Estat
     *
     * @param nomFitxer Ruta i nom del fitxer CSV a carregar.
     */
    public static void carregarLlibres(String nomFitxer) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(";");
                if (parts.length == 4) {
                    Llibre l = new Llibre(parts[0], parts[1], parts[2], parts[3]);
                    Biblioteca.afegirLlibre(l);
                }
            }
        } catch (IOException e) {
            System.out.println("No s'ha pogut carregar l'arxiu.");
        }
    }

    /**
     * Desa l'estat actual dels llibres de la biblioteca a un fitxer CSV.
     * Crea automàticament la carpeta si no existeix.
     * El format del CSV és: ISBN,Títol,Autor,Estat
     *
     * No sabia fer això, era la primera vegada. Referència:
     * https://www.geeksforgeeks.org/file-mkdirs-method-in-java-with-examples/
     *
     * @param nomFitxer Ruta i nom del fitxer on es guardaran els llibres.
     */
    public static void guardarLlibres(String nomFitxer) {
        try {
            File fitxer = new File(nomFitxer);
            File carpeta = fitxer.getParentFile();

            // Crear la carpeta si no existeix
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
            }

            // Escriure els llibres al fitxer
            PrintWriter writer = new PrintWriter(new FileWriter(fitxer));
            for (Llibre llibre : Biblioteca.llibres.values()) {
                writer.println(llibre.getIsbn() + "," + llibre.getTitol() + "," + llibre.getAutor() + "," + llibre.getEstat());
            }
            writer.close();
            System.out.println("Dades desades a: " + fitxer.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("No s'ha pogut guardar l'arxiu.");
        }
    }
}
