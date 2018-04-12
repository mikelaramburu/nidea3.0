package com.ipartek.formacion.nidea.ejemplos.Ejercicio_ObjetosGraficos;

import java.io.Serializable;

public abstract class ObjetoGrafico implements Imprimible, Cloneable, Serializable {

	private int x;
	private int y;

	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract void dibujar();

}