//Por Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo extends Vehiculo {

	private final int FACTOR_CILINDRADA = 10;
	private int cilindrada;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		super(matricula, modelo, marca);
		setCilindrada(cilindrada);
	}

	public Turismo(Turismo turismo) {
		super(turismo);
		if (turismo == null)
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		setCilindrada(turismo.getCilindrada());
	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0 && 5000 >= cilindrada)
			this.cilindrada = cilindrada;

		else
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
	}

	@Override
	int getFactorPrecio() {
		return getCilindrada() / FACTOR_CILINDRADA;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%d,%s", this.getMarca(), this.getModelo(), this.getCilindrada(),
				this.getMatricula());
	}

}
