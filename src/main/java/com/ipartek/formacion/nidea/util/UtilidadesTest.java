package com.ipartek.formacion.nidea.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ipartek.formacion.nidea.ejemplos.Utilidades;

public class UtilidadesTest {

	@Test
	public void testLimpiarEspacios() {
		assertEquals("hola que hase", Utilidades.limpiarEspacios("      hola     que         hase"));
		assertEquals("", Utilidades.limpiarEspacios(null));
	}

	@Test
	public void testBebida() {
		assertEquals("hola que hase", Utilidades.limpiarEspacios("      hola     que         hase"));
		assertEquals("", Utilidades.limpiarEspacios(null));
	}

}
