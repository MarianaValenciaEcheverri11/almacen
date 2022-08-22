package co.edu.uniquindio.almacen.almacen.models;

public class Almacen {
	
	private Administrador administrador;
	
	public Almacen(Administrador administrador) {
		super();
		this.administrador = administrador;
	}
	
	public Almacen() {
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	@Override
	public String toString() {
		return "Almacen [administrador=" + administrador + "]";
	}

}
