package generador;

import java.util.Random;

/**
 * Clase que genera cadenas aleatorias.
 */
public class Generador {
	
	/**
     * Constructor por defecto de la clase Generador.
     * No se utiliza directamente, ya que la clase no es instanciada.
     */
    private Generador() {
        // Este constructor no se utiliza, ya que la clase contiene solo métodos estáticos.
    }

	/**
	 * Método principal que inicia la generación de cadenas aleatorias.
	 *
	 * @param args Argumentos de línea de comandos. args[0]: Número de cadenas a
	 *             generar.
	 */
	public static void main(String[] args) {
		// Se crean tantas cadenas como se hayan pasado por los argumentos
		int cadenas = Integer.parseInt(args[0]);

		// Para crear cadenas aleatorias elegimos caracteres aleatorios de este String
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rn = new Random();

		try {

			for (int i = 0; i < cadenas; i++) {
				StringBuilder cadena = new StringBuilder();
				for (int j = 0; j < 10; j++) {
                    // Generamos un numero aleatorio que tenga como máximo el largo del String
					int index = rn.nextInt(letras.length());

					// Buscamos el numero aleatorio en el String
					char caracter = letras.charAt(index);

					// Añadimos el caracter a la cadena
					cadena.append(caracter);
				}
				// La mostramos por pantalla para que podamos rescatarla leerla despues a traves del input
				System.out.println(cadena);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}