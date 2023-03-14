package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo {
	private final int FACTOR_PMA = 100;
	private final int FACTOR_PLAZAS = 1;
	private int pma;
	private int plazas;
	
	public Furgoneta(String marca, String modelo, int pma,int plazas, String matricula) {
		super(matricula, modelo, marca);
		setPma(pma);
		setPlazas(plazas);
	}

	public Furgoneta(Furgoneta furgoneta) {
		super(furgoneta);
		if (furgoneta == null)
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		setPma(furgoneta.getPma());
		setPlazas(furgoneta.getPlazas());
	}

	public int getPma() {
		return pma;
	}

	private void setPma(int pma) {
		this.pma = pma;
	}

	public int getPlazas() {
		return plazas;
	}

	private void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	int getFactorPrecio() {
		return getPma()/(FACTOR_PMA + (getPlazas()*FACTOR_PLAZAS));
	}
	
	@Override
	public String toString() {
		return String.format( "%s,%s,%d,%d,%s", this.getMarca(),this.getModelo(),this.getPma(),getPlazas(),this.getMatricula());
	}
}
