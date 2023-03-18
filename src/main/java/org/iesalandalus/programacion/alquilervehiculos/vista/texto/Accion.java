//Por Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

public enum Accion {
	
	
	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar Cliente"),
	INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"),
	BUSCAR_CLIENTE("Buscar cliente"),
	BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"),
	MODIFICAR_CLIENTE("Modificar cliente"),
	DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"),
	BORRAR_TURISMO("Borrar turismo"),
	BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"),
	LISTAR_TURISMOS("Listar turismos"),
	LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres turismo");
	
	 private String texto="";
	
	private Accion(String string) {
		texto = string;
	}
	private static boolean esOrdinalValido(int ordinal) {
		boolean returnal=false;
		if (ordinal<0 || ordinal>values().length) {
			returnal=false;
			throw new IllegalArgumentException();
		}
		else
			returnal = true;
		
		return returnal;
	}
	public static Accion get(int ordinal) {
		if(esOrdinalValido(ordinal)) {
			 return values()[ordinal];	
		}
		else
			throw new IllegalArgumentException("Ordinal no válido");
			
	}
	@Override
    public String toString() {
        return ordinal() + ": " + texto;
    }
	
	}
