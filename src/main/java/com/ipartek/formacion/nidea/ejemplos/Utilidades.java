package com.ipartek.formacion.nidea.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {
	/**
	 * Metodo estatico para poder usarse desde la propia Clase, sin tener que
	 * instanciar un objeto.<br>
	 * 
	 * Limpia los caracteres vacios " " de una cadena String.<br>
	 * Hacemos trim, ademas de sustituir todos los espacios en blanco por uno unico,
	 * ej:<br>
	 * " hola que haxe " => "hola que haxe"
	 * 
	 * @param cadena
	 * @return en caso de null retorna cadena vacia ""
	 */
	public static String limpiarEspacios(String cadena) {
		String resul = "";
		if (cadena != null) {
			resul = cadena.trim();
			resul = resul.replaceAll("\\s+", " ");
		}
		return resul;
	}

	/**
	 * Ordenar una colecion con el algoritmo bubble sort, ordena de menor a mayor
	 * basandose en el metodo getValor de la interfaz Ordenable
	 * 
	 * @see com.ipartek.formacion.nidea.ejemplos.Ordenable
	 * @param coleccion
	 *            List<Ordenable> coleccion con los elementos a ordenadar
	 * @return en caso de null retornamos una lista vacia
	 */
	public static List<Ordenable> bubbleSort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();
		if (coleccion != null) {
			// TODO implementar metodo bubblesort
			resul = coleccion;
		}
		return resul;
	}

}