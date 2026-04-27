import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.salesianos.Validaciones.Validaciones;
import net.salesianos.Videojuegos.Videojuego;

public class App {

    public static void main(String[] args) {

        ArrayList<Videojuego> lista = new ArrayList<>();

        int opcion;

        do {
            opcion = Validaciones.pedirEntero(
                "1. Añadir\n2. Editar\n3. Mostrar\n4. Eliminar\n5. Salir"
            );

            switch (opcion) {

                case 1: 
                    String nombre = Validaciones.pedirString("Nombre:");
                    String genero = Validaciones.pedirString("Género:");
                    String plataforma = Validaciones.pedirString("Plataforma:");
                    int puntuacion = Validaciones.pedirEntero("Puntuación (1-5):");

                    lista.add(new Videojuego(nombre, genero, plataforma, puntuacion));
                    break;

                case 2:
                    try {
                        int pos = Validaciones.pedirEntero("Posición a editar:");

                        Videojuego v = lista.get(pos);

                        v.setNombre(Validaciones.pedirString("Nuevo nombre:"));
                        v.setGenero(Validaciones.pedirString("Nuevo género:"));
                        v.setPlataforma(Validaciones.pedirString("Nueva plataforma:"));
                        v.setPuntuacion(Validaciones.pedirEntero("Nueva puntuación:"));

                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Error: posición inválida");
                    }
                    break;

                case 3:
                    String texto = "";

                    if (lista.isEmpty()) {
                        texto = "No hay videojuegos registrados";
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            texto += i + " - " + lista.get(i).toString() + "\n";
                        }
                    }

                    JOptionPane.showMessageDialog(null, texto);
                    break;

                case 4: 
                    try {
                        int pos = Validaciones.pedirEntero("Posición a eliminar:");
                        lista.remove(pos);
                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Error: posición inválida");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 5);
    }
}
