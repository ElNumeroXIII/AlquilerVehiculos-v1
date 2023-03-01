//Por Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Pattern;

public class Turismo {
	private static final String ER_MARCA = "[A-Z][a-z]+([',. -]?[A-Z][a-z]+)*|[A-Z]+";
	private static final String ER_MATRICULA = "[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Turismo(Turismo turismo) {
		if (turismo == null)
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());
	}

	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {

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

	private void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		
		if(Pattern.matches("\\s+", modelo)||modelo=="")
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");

		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		if (cilindrada > 0 && 5000 >= cilindrada) 
			this.cilindrada = cilindrada;
	
	else 
		throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
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
	
	public static Turismo getTurismoConMatricula(String matricula) {
        Turismo Falso = new Turismo("Seat", "León", 90, matricula);
        Falso.setMatricula(matricula);
        return Falso;
    }

	@Override
	public int hashCode() {
		return Objects.hash(cilindrada, marca, matricula, modelo);
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
		return cilindrada == other.cilindrada && Objects.equals(marca, other.marca)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString() {
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada,
				matricula);
	}

}
