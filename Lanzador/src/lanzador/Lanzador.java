package lanzador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Clase que representa un lanzador de procesos para generar cadenas y calcular
 * frecuencias.
 */
public class Lanzador {

	/**
	 * Constructor por defecto de la clase Lanzador. No se utiliza directamente, ya
	 * que la clase no es instanciada.
	 */
	private Lanzador() {
		// Este constructor no se utiliza, ya que la clase contiene solo métodos
		// estáticos.
	}

	/**
	 * Método principal que inicia la ejecución del lanzador.
	 *
	 * @param args Argumentos de línea de comandos. args[0]: Número de instancias.
	 *             args[1]: Archivo de salida.
	 */
	public static void main(String[] args) {
		int instancias = Integer.parseInt(args[0]);
		String[] cmdGenerador = { "java", "-jar", "generador.jar", args[1] };
		String[] cmdFrecuencia = { "java", "-jar", "frecuencia.jar" };

		// Creación de los procesos
		ProcessBuilder generadorBuilder = new ProcessBuilder(cmdGenerador);
		ProcessBuilder frecuenciaBuilder = new ProcessBuilder(cmdFrecuencia);

		for (int i = 0; i < instancias; i++) {

			try {
				// Inicio de los procesos
				Process frecuencia = frecuenciaBuilder.start();
				Process generador = generadorBuilder.start();

				// En esta variable se guarda los outputs del generador
				BufferedReader salidaGenerador = new BufferedReader(new InputStreamReader(generador.getInputStream()));
				// En esta variable se recoge lo que se le pasa por la entrada estandar a frecuencia
				BufferedWriter entradaFrecuencia = new BufferedWriter(new OutputStreamWriter(frecuencia.getOutputStream()));
				// En esta variable se guarda los output de frecuencia
				BufferedReader salidaFrecuencia = new BufferedReader(new InputStreamReader(frecuencia.getInputStream()));
				
				String resultadoGenerador, resultadoFrecuencia;
				
				//Este bucle ira leyendo la salida de generador y la ira introduciendo en la entrada de frecuencia
				while ((resultadoGenerador = salidaGenerador.readLine()) != null) {
					entradaFrecuencia.write(resultadoGenerador);
					entradaFrecuencia.newLine();
					entradaFrecuencia.flush();
					//Aqui leemos la salida de frecuencia y la mostramos por pantall
					resultadoFrecuencia = salidaFrecuencia.readLine();
					System.out.println("Instancia " + (i+1) + ": " + resultadoFrecuencia);

				}
				System.out.println("");

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Proceso numero " + (i + 1) + " finalizado");
			System.out.println("----------------------------\n");
		}
	}
}
