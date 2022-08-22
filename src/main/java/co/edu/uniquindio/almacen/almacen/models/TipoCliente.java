package co.edu.uniquindio.almacen.almacen.models;

public class TipoCliente {
	private PersonaNatural personaNatural;
	private PersonaJuridica personaJuridica;
	
	public TipoCliente(PersonaNatural personaNatural) {
		super();
		this.personaNatural = personaNatural;
	}
	
	
	
	
	public TipoCliente(PersonaJuridica personaJuridica) {
		super();
		this.personaJuridica = personaJuridica;
	}




	public PersonaNatural getPersonaNatural() {
		return personaNatural;
	}
	public void setPersonaNatural(PersonaNatural personaNatural) {
		this.personaNatural = personaNatural;
	}
	public PersonaJuridica getPersonaJuridica() {
		return personaJuridica;
	}
	public void setPersonaJuridica(PersonaJuridica personaJuridica) {
		this.personaJuridica = personaJuridica;
	}




	public String toStringPersonaNatural() {
		return "TipoCliente [personaNatural=" + personaNatural + "]";
	}
	public String toStringPersonaJuridica() {
		return "TipoCliente [personaJuridica=" + personaJuridica + "]";
	}
	
	




}
