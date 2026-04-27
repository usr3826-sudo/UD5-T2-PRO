package net.salesianos.Validaciones;

import javax.swing.JOptionPane;

public class Validaciones {

      public static String pedirString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public static int pedirEntero(String mensaje) {
        int numero = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                correcto = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: introduce un número válido");
            }
        }
        
        return numero;
    }
}
