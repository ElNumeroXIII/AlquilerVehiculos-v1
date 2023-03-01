//Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Alquileres alquileres;
	private Clientes clientes;
	private Turismos turismos;

	public Modelo() {

	}

	public void comenzar() {

		alquileres = new Alquileres();
		clientes = new Clientes();
		turismos = new Turismos();

	}

	public void terminar() {
		System.out.printf("La ejecución ha finalizado");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		Cliente clienteNuevo = new Cliente(cliente);
		clientes.insertar(clienteNuevo);
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		Turismo turismoNuevo = new Turismo(turismo);
		turismos.insertar(turismoNuevo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		if (clientes.buscar(alquiler.getCliente()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		if (turismos.buscar(alquiler.getTurismo()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		Cliente clienteAlquiler = new Cliente(buscar(alquiler.getCliente()));
		Turismo turismoAlquiler = new Turismo(buscar(alquiler.getTurismo()));
		LocalDate dateAlquiler = alquiler.getFechaAlquiler();
		Alquiler alquilerNuevo = new Alquiler(clienteAlquiler, turismoAlquiler, dateAlquiler);
		alquileres.insertar(alquilerNuevo);
	}

	public Cliente buscar(Cliente cliente) {
		Cliente clienteNuevo = new Cliente(clientes.buscar(cliente));
		return clientes.buscar(clienteNuevo);

	}

	public Turismo buscar(Vehiculo turismo) {
		Vehiculo turismoNuevo = new Turismo(turismos.buscar(turismo));
		return turismos.buscar(turismoNuevo);

	}

	public Alquiler buscar(Alquiler alquiler) {
		Alquiler alquilerNuevo = new Alquiler(alquileres.buscar(alquiler));
		return alquileres.buscar(alquilerNuevo);

	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquileres.buscar(alquiler) == null)
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		alquiler.devolver(fechaDevolucion);

	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(cliente))
			alquileres.borrar(alquiler);
		clientes.borrar(cliente);
	}

	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo))
			alquileres.borrar(alquiler);
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> clientesLista = new ArrayList<>();
		for (Cliente clienteNuevo : clientes.get()) {
			clientesLista.add(new Cliente(clienteNuevo));
		}
		return clientesLista;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> turismosLista = new ArrayList<>();
		for (Turismo turismoNuevo : turismos.get()) {
			turismosLista.add(new Turismo(turismoNuevo));
		}
		return turismosLista;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> alquileresLista = new ArrayList<>();
		for (Alquiler alquilerNuevo : alquileres.get()) {
			alquileresLista.add(new Alquiler(alquilerNuevo));
		}
		return alquileresLista;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> alquileresLista = new ArrayList<>();
		for (Alquiler alquilerNuevo : alquileres.get(cliente)) {
			alquileresLista.add(new Alquiler(alquilerNuevo));
		}
		return alquileresLista;
	}

	public List<Alquiler> getAlquileres(Vehiculo turismo) {
		List<Alquiler> alquileresLista = new ArrayList<>();
		for (Alquiler alquilerNuevo : alquileres.get(turismo)) {
			alquileresLista.add(new Alquiler(alquilerNuevo));
		}
		return alquileresLista;
	}

}
