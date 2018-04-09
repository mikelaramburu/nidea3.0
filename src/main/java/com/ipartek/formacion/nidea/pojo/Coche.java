package com.ipartek.formacion.nidea.pojo;

public class Coche implements AutoCloseable {

	public Coche() {
		super();
		System.out.println("Creamos coche");
	}

	public void conducir() {
		System.out.println("brum brum estamos conduciendo");
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Paramos coche");
	}

	public static void main(String[] args) {

		// Si declaramos un objeto que implemente la interfaz Autocloseable
		// dentro de parentesis de TRY, cuando llega al FINALLY se ejecuta de forma
		// automatica su metodo "close()"

		try (Coche c = new Coche()) {

			System.out.println("Empezamos programa");
			c.conducir();
			String nullo = null;
			nullo.length();

		} catch (Exception e) {
			System.out.println("Tenemos una excepcion");
		} finally {
			System.out.println("Finalizamos");
		}

	}

}
