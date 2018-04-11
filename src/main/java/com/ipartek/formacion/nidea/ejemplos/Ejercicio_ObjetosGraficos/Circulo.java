package com.ipartek.formacion.nidea.ejemplos.Ejercicio_ObjetosGraficos;

public class Circulo extends ObjetoGrafico {
	private int radio;

	public Circulo() {
		super();
		this.radio = 0;
	}

	@Override
	public void imprimir() {
		System.out.println("Metodo imprimir");

	}

	@Override
	void dibujar() {
		System.out.println("Metodo dibujar");
	}

}
