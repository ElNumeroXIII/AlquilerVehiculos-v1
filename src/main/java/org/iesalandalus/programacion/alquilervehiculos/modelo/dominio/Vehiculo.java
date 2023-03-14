package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Vehiculo {

	private static final String ER_MARCA = "[A-Za-z0-9]+";
	private static final String ER_MATRICULA = "\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private String matricula;
	

	protected Vehiculo(String marca, String modelo, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
	}
	
	protected Vehiculo(Vehiculo vehiculo) {
		setMarca(vehiculo.getMarca());
		setMatricula(vehiculo.getMatricula());
		setModelo(vehiculo.getMarca());
	}

	public static Vehiculo copiar(Vehiculo vehiculo) {
		Vehiculo vehiculoCopia= null;
		
		if(vehiculo instanceof Turismo turismo)
			vehiculoCopia = new Turismo(turismo);
		else if ( vehiculo instanceof Autobus bus)
			vehiculoCopia = new Autobus(bus);
		else if(vehiculo instanceof Furgoneta furgo)
			vehiculoCopia = new Furgoneta (furgo);
		
		return vehiculoCopia;
	}
	
	public static Vehiculo getVehiculoConMatricula (String matricula) {
		Vehiculo fake;
		
		

        return fake;
	}
	
	abstract int getFactorPrecio();
	
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
		
		if(Pattern.matches("\\s+", modelo)||"".equals(modelo))
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
	
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
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
		boolean salida=false;
		if(obj instanceof Vehiculo)
			if(this.getMarca()==((Vehiculo) obj).getMarca() && this.getMatricula()==((Vehiculo) obj).getMatricula() && this.getModelo()==((Vehiculo) obj).getModelo() && this.getFactorPrecio()==((Vehiculo) obj).getFactorPrecio())
				salida= true;
				else
					salida = false;
		return salida;
	}

}