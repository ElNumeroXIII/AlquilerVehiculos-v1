//Joaquin Francisco Sanchez Capel
package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		Vista vista = FactoriaVista.TEXTO.crear();
		
		Modelo modelo = new ModeloCascada(FactoriaFuenteDatos.MEMORIA.crear());
		
		Controlador controlador = new Controlador(modelo,vista) ;
		
		controlador.comenzar();
	}

}
