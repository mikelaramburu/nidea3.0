package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculos {

	private float potencia; // kW

	public VehiculoElectrico() {
		super();
		potencia = 0;
		System.out.println("Instanciado VehiculoElectrico");
		// TODO Auto-generated constructor stub
	}

	public VehiculoElectrico(float potencia) {
		this(); // Al sobrecargar cambiar el super por el this
		this.potencia = potencia;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		System.out.println("pulsar boton de encencido");
	}

	@Override
	public String toString() {
		return super.toString() + "VehiculoElectrico [potencia=" + potencia + "]";
	}

}
