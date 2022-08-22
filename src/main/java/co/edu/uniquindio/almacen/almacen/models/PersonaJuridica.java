package co.edu.uniquindio.almacen.almacen.models;

public class PersonaJuridica {
	private String nit;

	public PersonaJuridica(String nit) {
		this.nit = nit;

	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@Override
	public String toString() {
		return "PersonaJuridica{" +
				"nit='" + nit + '\'' +
				'}';
	}
}
