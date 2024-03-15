import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Libro> libros = new ArrayList();

    public Biblioteca() {
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public Usuario encontrarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public Libro encontrarLibro(String titulo) {
        System.out.println("Buscando libro con título: " + titulo);
        for (Libro libro : libros) {
            System.out.println("Título del libro en la biblioteca: " + libro.getTitulo());
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
