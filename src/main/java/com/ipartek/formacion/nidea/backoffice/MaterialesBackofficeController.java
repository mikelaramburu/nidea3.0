package com.ipartek.formacion.nidea.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialesBackofficeController
 */
@WebServlet("/backoffice/materiales")
public class MaterialesBackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "materiales/index.jsp";
	private static final String VIEW_FORM = "materiales/form.jsp";

	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	ValidatorFactory factory;
	Validator validator;

	private RequestDispatcher dispatcher;
	private Alert alert;
	private MaterialDAO dao;

	// parametros comunes
	private String search; // para el buscador por nombre matertial
	private int op; // operacion a realizar

	// parametros del Material
	private int id;
	private String nombre;
	private float precio;

	/**
	 * Se ejecuta solo la 1º vez que llaman al Servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = MaterialDAO.getInstance();
	}

	/**
	 * Se ejecuta cuando Paramos Servidor de Aplicaciones
	 */
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de Ejecutar doGET o doPost");
		super.service(request, response);
		System.out.println("Despues de Ejecutar doGET o doPost");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * Unimos las peticiones doGet y doPost, vamos que hacemos los mismo!!!
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = null;

		try {

			recogerParametros(request);

			switch (op) {
			case OP_MOSTRAR_FORMULARIO:
				mostrarFormulario(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_BUSQUEDA:
				buscar(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;
			default:
				listar(request);
				break;
			}

		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher(VIEW_INDEX);

		} finally {
			request.setAttribute("alert", alert);
			dispatcher.forward(request, response);
		}
	}

	private void guardar(HttpServletRequest request) {
		// Importante que los input tengan el atributo name para recoger su valor
		Material material = new Material();

		material.setId(id);
		material.setNombre(nombre);
		String precio1 = String.valueOf(precio);

		material.setPrecio(precio);
		if (!dao.busqueda(nombre)) {
			if (nombre != "" && precio > 0) {
				if (dao.save(material)) {// Llamamos al save de materialDAo
					alert = new Alert("Material guardado", Alert.TIPO_PRIMARY);

				} else {
					// alert = new Alert("Lo sentimos pero no hemos podido guardar el material",
					// Alert.TIPO_PRIMARY);
					/*
					 * alert = new Alert(
					 * "Lo sentimos pero el valor del nombre del material que intentas introducir es incorrecto"
					 * , Alert.TIPO_PRIMARY);
					 */
					alert = new Alert(
							"El campo nombre con un nombre válido. Por favor, compruebe que no exista o que su longitud no sea excesiva.",
							Alert.TIPO_WARNING);
				}
				request.setAttribute("material", material);
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
			} else {

				if (nombre == "") {
					alert = new Alert(
							"El campo nombre con un nombre válido. Por favor, compruebe que no exista o que su longitud no sea excesiva.",
							Alert.TIPO_WARNING);
					request.setAttribute("material", material);
					dispatcher = request.getRequestDispatcher(VIEW_FORM);
				} else if (precio < 0 || precio1.equals("")) {
					alert = new Alert("Por favor introduzca un precio con valor positivo.", Alert.TIPO_DANGER);
					request.setAttribute("material", material);
					dispatcher = request.getRequestDispatcher(VIEW_FORM);
				}
			}
		} else {
			alert = new Alert("Lo sentimos pero el material ya existe", Alert.TIPO_DANGER);
			request.setAttribute("material", material);
			dispatcher = request.getRequestDispatcher(VIEW_FORM);
		}

	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		request.setAttribute("materiales", dao.getAll());
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request) {
		if (dao.delete(id)) {
			alert = new Alert("Material Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("Error Eliminando, sentimos las molestias ", Alert.TIPO_WARNING);
		}
		listar(request);

	}

	private void mostrarFormulario(HttpServletRequest request) {

		Material material = new Material();
		if (id > -1) {
			// TODO recuperar de la BBDD que es un material que existe
			material = dao.getById(id);

		} else {
			alert = new Alert("Nuevo Producto", Alert.TIPO_WARNING);
		}
		request.setAttribute("material", material);

		dispatcher = request.getRequestDispatcher(VIEW_FORM);
	}

	private void listar(HttpServletRequest request) {

		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.getAll();
		request.setAttribute("materiales", materiales);

		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	/**
	 * Recogemos todos los posibles parametros enviados
	 * 
	 * @param request
	 */
	private void recogerParametros(HttpServletRequest request) {

		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));
		} else {
			op = 0;
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		} else {
			id = -1;
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		} else {
			nombre = "";
		}

		if (request.getParameter("precio") != null) {
			precio = Float.parseFloat(request.getParameter("precio"));
		} else {
			precio = 0;
		}

	}

}