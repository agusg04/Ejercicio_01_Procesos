package frecuencia;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase que calcula la frecuencia de las vocales 'a', 'e' y 'o' en cadenas de texto.
 */
public class Frecuencia {
	
	/**
     * Constructor por defecto de la clase Frecuencia.
     * No se utiliza directamente, ya que la clase no es instanciada.
     */
    private Frecuencia() {
        // Este constructor no se utiliza, ya que la clase contiene solo métodos estáticos.
    }
	
	/**
     * Método principal que inicia el cálculo de frecuencias.
     *
     * @param args No se utilizan argumentos de línea de comandos.
     */
	public static void main(String[] args) {
		//Leemos por entrada estándar para leer las cadenas de generador
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String linea;

			while ((linea = br.readLine()) != null) {
				//Pasamos la cadena a minuscula para no distinguir entre mayuscula y minuscula
				linea = linea.toLowerCase();
				int a = 0, e = 0, o = 0;
				
				
				//Con un for recorremos la cadena y comprobamos si es una de las tres vocales
				for (int i = 0; i < linea.length(); i++) {
					switch (linea.charAt(i)) {
					case 'a':
						a++;
						break;

					case 'e':
						e++;
						break;

					case 'o':
						o++;
						break;
					}
				}
				//Mostamos los resultados por pantalla para que se puedan rescatar por InputStream
				System.out.println(linea + ": " + a + " " + e + " " + o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
