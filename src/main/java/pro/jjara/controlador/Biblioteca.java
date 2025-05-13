package pro.jjara.controlador;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pro.jjara.modelo.Llibre;

/**
 * Classe per afegir els llibres, validar el ISBN, fer els prestecs, cercar i retornar
 */

public class Biblioteca {

    public static HashMap<String, Llibre> llibres = new HashMap<>();

    // Regex per validar ISBN (formato XXX-XXXXX-XXX)
    // https://codegym.cc/groups/posts/regex-java
    private static final String ISBN_REGEX = "^[0-9]{3}-[0-9]{5}-[0-9]{3}$";

    public static void afegirLlibre(Llibre llibre) {
        // Validem el ISBN abans d'afegir el llibre
        if (validarISBN(llibre.getIsbn())) {
            if (!llibres.containsKey(llibre.getIsbn())) {
                llibres.put(llibre.getIsbn(), llibre);
                System.out.println("Llibre afegit.");
            } else {
                System.out.println("Ja existeix un llibre amb aquest ISBN.");
            }
        } else {
            System.out.println("ISBN invàlid. Has de seguir el format XXX-XXXXX-XXX.");
        }
    }

    /**
     * Valida el format de l'ISBN amb RegEx que es una expressió regular.
     * @param isbn ISBN a validar.
     * @return true si el format és vàlid, false en cas contrari.
     */
    public static boolean validarISBN(String isbn) {
        Pattern pattern = Pattern.compile(ISBN_REGEX);
        Matcher matcher = pattern.matcher(isbn);
        return matcher.matches();
    }

    public static Llibre cercarPerTitol(String titol) {
        for (Llibre l : llibres.values()) {
            if (l.getTitol().equalsIgnoreCase(titol)) {
                return l;
            }
        }
        return null;
    }

    public static void ferPrestec(String isbn) {
        Llibre l = llibres.get(isbn);
        if (l != null && l.getEstat().equals("DISPONIBLE")) {
            l.setEstat("EN PRESTEC");
            System.out.println("Prèstec fet.");
        } else {
            System.out.println("No disponible o no trobat.");
        }
    }

    public static void retornarLlibre(String isbn) {
        Llibre l = llibres.get(isbn);
        if (l != null && l.getEstat().equals("EN PRESTEC")) {
            l.setEstat("DISPONIBLE");
            System.out.println("Llibre retornat.");
        } else {
            System.out.println("No es pot retornar.");
        }
    }
}
