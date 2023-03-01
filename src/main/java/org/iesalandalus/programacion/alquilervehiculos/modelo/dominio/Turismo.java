//Por Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;


public class Turismo extends Vehiculo {
	int cilindrada;
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		super();
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Turismo(Turismo turismo) {
		super();
		if (turismo == null)
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());
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

	public static Turismo getTurismoConMatricula(String matricula) {
        Turismo Falso = new Turismo("Seat", "León", 90, matricula);
        Falso.setMatricula(matricula);
        return Falso;
    }

	@Override
	public String toString() {
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada,
				matricula);
	}

}
