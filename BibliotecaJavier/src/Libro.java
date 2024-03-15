public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public boolean isPrestado() {
        return this.prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
