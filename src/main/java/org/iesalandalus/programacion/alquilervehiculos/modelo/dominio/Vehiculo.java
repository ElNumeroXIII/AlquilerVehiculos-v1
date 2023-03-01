package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Pattern;

public class Vehiculo {

	private static final String ER_MARCA = "[A-Z][a-z]+([',. -]?[A-Z][a-z]+)*|[A-Z]+";
	private static final String ER_MATRICULA = "[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private String matricula;

	protected Vehiculo(String marca, String modelo, String matricula) {
			setMarca(marca);
			setModelo(modelo);
			setMatricula(matricula);
	}
	
	protected Vehiculo(Vehiculo vehiculo) {
		if (vehiculo == null)
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		
		setMarca(vehiculo.getMarca());
		setModelo(vehiculo.getModelo());
		setMatricula(vehiculo.getMatricula());
	}

	public String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
	
		if(marca == null)
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		if (!Pattern.matches(ER_MARCA, marca)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		
		if(Pattern.matches("\\s+", modelo)||modelo=="")
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
	
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if(matricula == null) {
				throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!Pattern.matches(ER_MATRICULA, matricula)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, matricula, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(marca, other.marca)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(modelo, other.modelo);
	}

}