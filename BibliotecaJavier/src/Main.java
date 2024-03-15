import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // Agregar usuarios
        Usuario usuario1 = new Usuario("Juan", "Perez", "522431769", "juan@gmail.com");
        Usuario usuario2 = new Usuario("Javier", "Pastor", "687654221", "maria@gmail.com");
        Usuario usuario3 = new Usuario("Pedro", "Rodríguez", "456789123", "pedro@gmail.com");
        Usuario usuario4 = new Usuario("Ana", "Martínez", "654321987", "ana@gmail.com");
        Usuario usuario5 = new Usuario("Luisa", "Sánchez", "789123456", "luisa@gmail.com");
        Usuario usuario6 = new Usuario("Carlos", "López", "321987654", "carlos@gmail.com");
        Usuario usuario7 = new Usuario("Laura", "Fernández", "987654123", "laura@gmail.com");

        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);
        biblioteca.agregarUsuario(usuario4);
        biblioteca.agregarUsuario(usuario5);
        biblioteca.agregarUsuario(usuario6);
        biblioteca.agregarUsuario(usuario7);

        // Agregar libros
        Libro libro1 = new Libro("El principito", "Antoine", "9788431422609");
        Libro libro2 = new Libro("Don Quijote", "Miguel Cervantes", "9456424122609");
        Libro libro3 = new Libro("Crimen y castigo", "Fyodor Dostoevsky", "9780143058147");
        Libro libro4 = new Libro("Matar a un ruiseñor", "Harper Lee", "9780061120084");
        Libro libro5 = new Libro("La Odisea", "Homero", "9788491051647");
        Libro libro6 = new Libro("El retrato de Dorian Gray", "Oscar Wilde", "9788491051265");
        Libro libro7 = new Libro("Anna Karenina", "Lev Tolstói", "9780143035001");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);
        biblioteca.agregarLibro(libro7);

        int opcion;
        label54:
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Acceder a un usuario");
            System.out.println("2. Libros disponibles");
            System.out.println("3. Libros pendientes de devolver por un usuario");
            System.out.println("4. Pedir un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("0. Salir");
            System.out.print("Introduzca el número de la opción que desea seleccionar:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            String tituloLibro;
            PrintStream var10000;
            String var10001;
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = biblioteca.encontrarUsuario(nombreUsuario);
                    if (usuario != null) {
                        var10000 = System.out;
                        var10001 = usuario.getNombre();
                        var10000.println("Usuario encontrado: " + var10001 + " " + usuario.getApellido());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Libros disponibles:");
                    for (Libro libro : biblioteca.getLibros()) {
                        var10000 = System.out;
                        var10001 = libro.getTitulo();
                        var10000.println(var10001 + " - " + libro.getAutor() + " - ISBN: " + libro.getIsbn());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioPendientes = scanner.nextLine();
                    Usuario usuarioPendientes = biblioteca.encontrarUsuario(nombreUsuarioPendientes);
                    if (usuarioPendientes != null) {
                        System.out.println("Libros pendientes de devolver por " + usuarioPendientes.getNombre() + ":");
                        for (Libro libro : usuarioPendientes.getLibrosPendientes()) {
                            var10000 = System.out;
                            var10001 = libro.getTitulo();
                            var10000.println(var10001 + " - " + libro.getAutor() + " - ISBN: " + libro.getIsbn());
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioPrestamo = scanner.nextLine();
                    Usuario usuarioPrestamo = biblioteca.encontrarUsuario(nombreUsuarioPrestamo);
                    if (usuarioPrestamo != null) {
                        System.out.print("Ingrese el título del libro que desea pedir: ");
                        tituloLibro = scanner.nextLine();
                        Libro libroPrestamo = biblioteca.encontrarLibro(tituloLibro);
                        if (libroPrestamo != null) {
                            if (libroPrestamo.isPrestado()) {
                                usuarioPrestamo.agregarAColaEspera(libroPrestamo);
                                System.out.println("El libro está prestado, se ha añadido a la cola de espera.");
                            } else {
                                usuarioPrestamo.prestarLibro(libroPrestamo);
                                System.out.println("Libro prestado correctamente a " + usuarioPrestamo.getNombre());
                            }
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioDevolucion = scanner.nextLine();
                    Usuario usuarioDevolucion = biblioteca.encontrarUsuario(nombreUsuarioDevolucion);
                    if (usuarioDevolucion != null) {
                        System.out.print("Ingrese el título del libro que desea devolver: ");
                        tituloLibro = scanner.nextLine();
                        Libro libroDevolucion = biblioteca.encontrarLibro(tituloLibro);
                        if (libroDevolucion != null) {
                            usuarioDevolucion.devolverLibro(libroDevolucion);
                            System.out.println("Libro devuelto correctamente por " + usuarioDevolucion.getNombre());
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
