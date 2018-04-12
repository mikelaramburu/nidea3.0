package com.ipartek.formacion.nidea.ejemplos.Ejercicio_ObjetosGraficos;

import com.ipartek.formacion.nidea.ejemplos.Ordenable;

public class Circulo extends ObjetoGrafico implements Ordenable {
	private int radio;

	public Circulo() {
		super();
		this.radio = 0;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub

	}

	@Override
	void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getValor() {
		return this.radio;
	}

}
