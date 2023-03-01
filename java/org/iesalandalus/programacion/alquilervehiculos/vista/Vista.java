//Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controladorParam) {
		if (controlador != null)
			controlador = controladorParam;
		else
			throw new NullPointerException();
	}

	public void comenzar() {
		controlador.comenzar();
	}

	public void terminar() {
		controlador.terminar();
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion) {
		case SALIR:
			terminar();
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();
			break;
		case INSERTAR_TURISMO:
			insertarTurismo();
			break;

		case INSERTAR_ALQUILER:
			insertarAlquiler();
			break;

		case BUSCAR_CLIENTE:
			buscarCliente();
			break;

		case BUSCAR_TURISMO:
			buscarTurismo();
			break;

		case BUSCAR_ALQUILER:
			buscarAlquiler();
			break;

		case MODIFICAR_CLIENTE:
			modificarCliente();
			break;

		case DEVOLVER_ALQUILER:
			devolverAlquiler();
			break;

		case BORRAR_CLIENTE:
			borrarCliente();
			break;

		case BORRAR_TURISMO:
			borrarTurismo();
			break;

		case BORRAR_ALQUILER:
			borrarAlquiler();
			break;

		case LISTAR_CLIENTES:
			listarClientes();
			break;

		case LISTAR_TURISMOS:
			listarTurismos();
			break;

		case LISTAR_ALQUILERES:
			listarAlquileres();
			break;

		case LISTAR_ALQUILERES_CLIENTE:
			listarAlquileresCliente();
			break;

		case LISTAR_ALQUILERES_TURISMO:
			listarAlquileresTurismo();
			break;

		}
	}

	private void listarAlquileresTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void listarAlquileresCliente() {
		// TODO Auto-generated method stub
		
	}

	private void listarAlquileres() {
		// TODO Auto-generated method stub
		
	}

	private void listarTurismos() {
		// TODO Auto-generated method stub
		
	}

	private void listarClientes() {
		// TODO Auto-generated method stub
		
	}

	private void borrarAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void borrarTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void borrarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void devolverAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void modificarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void buscarAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void buscarTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void buscarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void insertarAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void insertarTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void insertarCliente() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
