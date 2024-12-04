package Sistema;

public class Livro {
    private String titulo;
    private String autor;
    private int ISBN;
    private boolean status;

    public Livro(String titulo, String autor, int ISBN, boolean status) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.status = status;
    }

    public boolean setTitulo(String titulo) {
        if (!titulo.equals(" ")) {
            this.titulo = titulo;
            return true;
        } else return false;
    }

    public boolean setAutor(String autor) {
        if (!autor.equals(" ")) {
            this.autor = autor;
            return true;
        } else return false;
    }

    public boolean setStatus(boolean status) {
        return this.status = status;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getISBN() {
        return this.ISBN;
    }
    public boolean getStatus() {
        return this.status;
    }
    @Override
    public String toString() {
        return "Titulo: " + this.titulo + ", " +
                "Autor: " + this.autor + ", " +
                "ISBN: " + this.ISBN + ", " +
                "Status: " + this.status;
    }
}

