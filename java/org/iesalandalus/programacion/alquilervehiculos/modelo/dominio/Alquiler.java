//Por joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;
import java.time.*;

public class Alquiler {
	static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final int PRECIO_DIA = 20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;
	
	public Alquiler (Cliente cliente, Turismo turismo,LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}
	
	public Alquiler (Alquiler alquiler) {
		if(alquiler == null)
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		Cliente clienteTemp = new Cliente(alquiler.getCliente());
		Turismo turismoTemp = new Turismo(alquiler.getTurismo());
		setCliente(clienteTemp);
		setTurismo(turismoTemp);
		setFechaAlquiler(alquiler.getFechaAlquiler());
		setFechaDevolucion(alquiler.getFechaDevolucion());
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		if(cliente == null)
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		this.cliente = cliente;
	}
	
	public Turismo getTurismo() {
		return turismo;
	}

	private void setTurismo(Turismo turismo) {
		if(turismo == null)
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		this.turismo = turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		if(fechaAlquiler==null)
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		if(fechaAlquiler.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if(fechaDevolucion==null)
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		if(fechaDevolucion.isBefore(fechaAlquiler)||fechaDevolucion.isEqual(fechaAlquiler))
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		if(fechaDevolucion.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public void devolver (LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if(getFechaDevolucion()!=null)
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		
			setFechaDevolucion(fechaDevolucion);
		
	}
	
	public int getPrecio() {
		if(getFechaDevolucion()==null)
			return 0;
		return (int) ((PRECIO_DIA+(turismo.getCilindrada()/10))*(ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(PRECIO_DIA, cliente, fechaAlquiler, fechaDevolucion, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return PRECIO_DIA == other.PRECIO_DIA && Objects.equals(cliente, other.cliente)
				&& Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		if(getFechaDevolucion()==null)
			return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,getFechaAlquiler().format(Alquiler.FORMATO_FECHA).toString(), "Aún no devuelto", 0);
		return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo,getFechaAlquiler().format(Alquiler.FORMATO_FECHA).toString(), getFechaDevolucion().format(Alquiler.FORMATO_FECHA).toString(), getPrecio());
	}
	
	
	
	
}
