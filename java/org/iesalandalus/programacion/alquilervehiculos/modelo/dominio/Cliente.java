
// Por Joaquin Francisco Sánchez Capel
package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Pattern;

public class Cliente {
	private static final String ER_NOMBRE = "[A-ZÁÉÍÓÚÜÑ][a-záéíóúüñ]+([ '-][A-ZÁÉÍÓÚÜÑ][a-záéíóúüñ]+)*";
	private static final String ER_DNI = "\\d{8}\\w";
	private static final String ER_TELEFONO = "\\d{9}";
	private String nombre;
	private String dni;
	private String telefono;

	public Cliente(String Nombre, String DNI, String Telefono) {
		setNombre(Nombre);
		setDni(DNI);
		setTelefono(Telefono);
	}

	public Cliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
		setNombre(cliente.getNombre());
		setDni(cliente.getDni());
		setTelefono(cliente.getTelefono());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		if (!Pattern.matches(ER_NOMBRE,nombre)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		if (!Pattern.matches(ER_DNI,dni)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if(!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		}
		this.dni = dni;
	}

	private boolean comprobarLetraDni(String dni) {
		Integer valorDNI = Integer.parseInt(dni.substring(0, dni.length() - 1));
		Character dniLetra = dni.charAt(dni.length()-1);
		boolean salida = false;
		switch (valorDNI % 23) {
		case 0:
			if (dniLetra == 'T')
				salida = true;
			break;
		case 1:
			if (dniLetra == 'R')
				salida = true;
			break;
		case 2:
			if (dniLetra == 'W')
				salida = true;
			break;
		case 3:
			if (dniLetra == 'A')
				salida = true;
			break;
		case 4:
			if (dniLetra == 'G')
				salida = true;
			break;
		case 5:
			if (dniLetra == 'M')
				salida = true;
			break;
		case 6:
			if (dniLetra == 'Y')
				salida = true;
			break;
		case 7:
			if (dniLetra == 'F')
				salida = true;
			break;
		case 8:
			if (dniLetra == 'P')
				salida = true;
			break;
		case 9:
			if (dniLetra == 'D')
				salida = true;
			break;
		case 10:
			if (dniLetra == 'X')
				salida = true;
			break;
		case 11:
			if (dniLetra == 'B')
				salida = true;
			break;
		case 12:
			if (dniLetra == 'N')
				salida = true;
			break;
		case 13:
			if (dniLetra == 'J')
				salida = true;
			break;
		case 14:
			if (dniLetra == 'Z')
				salida = true;
			break;
		case 15:
			if (dniLetra == 'S')
				salida = true;
			break;
		case 16:
			if (dniLetra == 'Q')
				salida = true;
			break;
		case 17:
			if (dniLetra == 'V')
				salida = true;
			break;
		case 18:
			if (dniLetra == 'H')
				salida = true;
			break;
		case 19:
			if (dniLetra == 'L')
				salida = true;
			break;
		case 20:
			if (dniLetra == 'C')
				salida = true;
			break;
		case 21:
			if (dniLetra == 'K')
				salida = true;
			break;
		case 22:
			if (dniLetra == 'E')
				salida = true;
			break;
		default:
			salida = false;
		}
		return salida;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}
		if (!Pattern.matches(ER_TELEFONO,telefono)) {
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}
		this.telefono = telefono;
	}

	public static Cliente getClienteConDni(String dni) {
		
		if(dni==null)
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		
		Cliente clienteFicticio = new Cliente("Bob Esponja", dni,"950112233");
		clienteFicticio.setDni(dni);
		return clienteFicticio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return this.getDni()==other.getDni() && this.getNombre()==other.getNombre()
				&& this.getTelefono()==other.getTelefono();
	}

	@Override
	public String toString() {
		return String.format("%s - %s (%s)", nombre, dni, telefono);
	}

}