package com.ipartek.formacion.nidea.ejemplos;

public class Vehiculos {

	private int puertas;
	private String color;

	public Vehiculos() {
		super(); // java.lang.object
		this.puertas = 3;
		this.color = "blanco";
		System.out.println("Instanciado vehiculo nuevo");
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void arrancar() {
		System.out.println("introducir llave y girar");

	}

	@Override
	public String toString() {
		return "Vehiculos [puertas=" + puertas + ", color=" + color + "]";
	}

}
