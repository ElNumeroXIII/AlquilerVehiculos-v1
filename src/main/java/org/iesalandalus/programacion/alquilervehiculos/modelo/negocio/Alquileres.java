//Por Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public class Alquileres {
	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {
		coleccionAlquileres = new ArrayList<>();
	}

	public List<Alquiler> get() {
		return Collections.unmodifiableList(coleccionAlquileres);
	}

	public List<Alquiler> get(Cliente cliente) {
		List<Alquiler> alquileresCliente = new ArrayList<>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
	}

	public List<Alquiler> get(Vehiculo turismo) {
		List<Alquiler> alquilerTurismo = new ArrayList<>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getVehiculo().equals(turismo)) {
				alquilerTurismo.add(alquiler);
			}
		}
		return alquilerTurismo;
	}

	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(), alquiler.getVehiculo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	private void comprobarAlquiler(Cliente cliente, Vehiculo turismo, LocalDate fechaAlquiler)
            throws OperationNotSupportedException {

        for (int i = 0; i < get(cliente).size(); i++) {

            if (get(cliente).get(i).getFechaDevolucion() == null) {
                throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
            }
            if (get(cliente).get(i).getFechaDevolucion().isAfter(fechaAlquiler)||
                     get(cliente).get(i).getFechaDevolucion().isEqual(fechaAlquiler)) {
                throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
            }

        }

        for (int i = 0; i < get(turismo).size(); i++) {

            if (get(turismo).get(i).getFechaDevolucion() == null) {
                throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
            }
            if (get(turismo).get(i).getFechaDevolucion().isAfter(fechaAlquiler)||
                     get(turismo).get(i).getFechaDevolucion().isEqual(fechaAlquiler)) {
                throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
            }
        }

    }



	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(alquiler);
	}

	public Alquiler buscar(Alquiler alquileres) {
		if (alquileres == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.equals(alquileres)) {
				return alquiler;
			}
		}
		return null;
	}

}
