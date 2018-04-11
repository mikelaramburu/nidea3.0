package com.ipartek.formacion.nidea.ejemplos;

public class Utilidades {
	/**
	 * Metodo estatico para poder usarse desde la propia clase sin tener que
	 * instanciar un objeto. <br>
	 * 
	 * Limpia los caracteres vacios " " de una cadena String.<br>
	 * Hacemos trim, ademas de sustituir todos los espacios en blanco innecesarios
	 * por uno unico. <br>
	 * ejem.: " hola que hase " => "hola que hace"
	 * 
	 * @param cadena
	 * @return en caso de null retorna cadena vacia
	 */

	public static String limpiarEspacios(String cadena) {
		String resul = "";
		if (cadena != null) {
			resul = cadena.trim();
			resul = resul.replaceAll("\\s+", " ");
		}
		return resul;
	}

}
