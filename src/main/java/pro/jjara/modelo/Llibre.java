package pro.jjara.modelo;

/**
 * Classe que representa un llibre amb ISBN, títol, autor i estat.
 * 
 * La més fàcil de fer
 */

public class Llibre {

    private String isbn;
    private String titol;
    private String autor;
    private String estat; // DISPONIBLE o EN PRESTEC

    public Llibre() {
        this.isbn = "";
        this.titol = "";
        this.autor = "";
        this.estat = "DISPONIBLE";
    }
    
    /**
     * Constructor
     *
     * @param isbn Codi ISBN del llibre.
     * @param titol Títol del llibre.
     * @param autor Autor del llibre.
     * @param estat Estat del llibre ("DISPONIBLE" o "EN PRESTEC").
     */

    public Llibre(String isbn, String titol, String autor, String estat) {
        this.isbn = isbn;
        this.titol = titol;
        this.autor = autor;
        this.estat = estat;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {
        return isbn + " - " + titol + " de " + autor + " (" + estat + ")";
    }
}
