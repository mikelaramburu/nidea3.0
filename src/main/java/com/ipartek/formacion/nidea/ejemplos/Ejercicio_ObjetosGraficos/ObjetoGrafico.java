package com.ipartek.formacion.nidea.ejemplos.Ejercicio_ObjetosGraficos;

import java.io.Serializable;

public abstract class ObjetoGrafico implements Imprimible, Cloneable, Serializable {

	private int x, y;

	private void mover(int X, int Y) {

		this.x = x;
		this.y = y;

	}

	abstract void dibujar();
}
