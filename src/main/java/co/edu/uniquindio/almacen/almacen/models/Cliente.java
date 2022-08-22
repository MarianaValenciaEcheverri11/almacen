package co.edu.uniquindio.almacen.almacen.models;

public class Cliente extends Persona {
	
	private TipoCliente tipoCliente;
	public  Cliente(){
		super();

	}
	public Cliente(String nombre, String apellido, String identificacion, String direccion, String telefono,
			TipoCliente tipoCliente) {
		super(nombre, apellido, identificacion, direccion, telefono);
		this.tipoCliente = tipoCliente;
	}
	public Cliente(String nombre, String apellido, String identificacion, String direccion, String telefono
				  ) {
		super(nombre, apellido, identificacion, direccion, telefono);

	}


	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [tipoCliente=" + tipoCliente + "]";
	}



	
	
	
	

}
