// Joaquin francisco sanchez capel

package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public class Turismos {

	private List<Turismo> coleccionTurismos;

	public Turismos() {
		coleccionTurismos = new ArrayList<>();
	}

	public List<Turismo> get() {
		return Collections.unmodifiableList(coleccionTurismos);
	}

	public int getCantidad() {
		return coleccionTurismos.size();
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		} else {
			coleccionTurismos.add(turismo);
		}

	}

	public Turismo buscar(Vehiculo turismos) {
		if(turismos == null)
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");		
		for (Turismo turismo : coleccionTurismos) {
			if (turismo.equals(turismos)) {
				return turismo;
			}
		}
		return null;
	}

	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (!coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}
		coleccionTurismos.remove(turismo);

	}

}