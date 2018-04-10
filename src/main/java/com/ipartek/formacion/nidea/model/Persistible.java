package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Persistible<P> {

	/**
	 * Lista de una tabla de la base de datos ordenaod por id descentente y limitado
	 * a 500
	 * 
	 * @return Coleccion
	 */

	public ArrayList<P> getAll();

	/**
	 * Obtenemos el detalle de un registro
	 * 
	 * @param id
	 *            identificador
	 * @return Registro si existe, null en caso contrario
	 */

	public P getById(int id);

	/**
	 * Guardamos un registro en la BBDD.<br>
	 * Si el id del Pojo == -1 Creamos <br>
	 * Si el id del Pojo > 1 Modificamos
	 * 
	 * @param pojo
	 * @return
	 */
	public boolean save(P pojo);

	/**
	 * Eliminamos un resgistro por su identificador
	 * 
	 * @param id
	 * @return
	 */

	public boolean delete(int id);

	public P mapper(ResultSet rs) throws SQLException;

	/**
	 * Nos Mapea un Resultado de la BBDD a un Pojo
	 * 
	 * @param rs
	 *            ResultSet 1 registro de consulta
	 * @return Pojo con los valores del ResultSet o null si no hay valores
	 */

	public boolean busqueda(String nombre);

}