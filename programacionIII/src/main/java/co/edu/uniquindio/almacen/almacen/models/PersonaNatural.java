package co.edu.uniquindio.almacen.almacen.models;

import java.time.LocalDate;

public class PersonaNatural {
	private String email;
	private LocalDate fechaNacimiento;

	public PersonaNatural(String email, LocalDate fechaNacimiento) {
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "PersonaNatural{" +
				"email='" + email + '\'' +
				", fechaNacimiento=" + fechaNacimiento +
				'}';
	}
}
