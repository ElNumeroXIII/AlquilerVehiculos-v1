//Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Modelo modeloParam, Vista vistaParam) {
		
	vista = vistaParam;
	modelo = modeloParam;
	
	}
	
	public void comenzar() {
		modelo.comenzar();
	}
	
	public void terminar() {
		modelo.terminar();
	}
	
	public void insertar (Cliente cliente) throws OperationNotSupportedException {
		modelo.insertar(new Cliente(cliente));
	}
	
	public void insertar (Turismo turismo) throws OperationNotSupportedException {
		modelo.insertar(new Turismo(turismo));
	}
	
	public void insertar (Alquiler alquiler) throws OperationNotSupportedException {
		modelo.insertar(new Alquiler(alquiler));
	}
	
	public Cliente buscar (Cliente cliente) throws OperationNotSupportedException {
		return modelo.buscar(new Cliente(cliente));
	}
	
	public Vehiculo buscar (Turismo turismo) throws OperationNotSupportedException {
		return modelo.buscar(new Turismo(turismo));
	}
	
	public Alquiler buscar (Alquiler alquiler) throws OperationNotSupportedException {
		return modelo.buscar(new Alquiler(alquiler));
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		modelo.modificar(new Cliente(cliente),nombre , telefono);
	}
	
	public void devolver( Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modelo.devolver(new Alquiler(alquiler), fechaDevolucion);
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		modelo.borrar(new Cliente(cliente));
	}
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		modelo.borrar(new Turismo(turismo));
	}
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.borrar(new Alquiler(alquiler));
	}
	
	public List<Cliente> getClientes(){
	return	modelo.getClientes();
	}
	public List<Turismo> getTurismos(){
	return	modelo.getTurismos();
	}	
	public List<Alquiler> getAlquileres(){
	return	modelo.getAlquileres();
	}
	
	public List<Alquiler> getAlquileres(Cliente cliente){
		return	modelo.getAlquileres(new Cliente(cliente));
		}
	public List<Alquiler> getAlquileres(Turismo turismo){
		return	modelo.getAlquileres(new Turismo(turismo));
		}
	
}

