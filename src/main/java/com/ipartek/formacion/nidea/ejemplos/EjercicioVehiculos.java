package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculos {

	public static void main(String[] args) {
		/**
		 * NO SE PUEDEN CREAR OBJETOS DE UNA CLASE ABSTRACTA
		 * 
		 * Vehiculos rayoMcQueen = new Vehiculos();
		 * System.out.println(rayoMcQueen.toString());
		 */

		Vehiculos.dimeMatricula();

		System.out.println("******************************************************************");

		VehiculoElectrico tesla = new VehiculoElectrico();
		System.out.println(tesla.toString());

		System.out.println("Tesla");
		System.out.println("color: " + tesla.getColor());

	}

}
