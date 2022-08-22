package co.edu.uniquindio.almacen.almacen.models;

import java.util.ArrayList;

public class Administrador extends Persona {


	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Venta> ventas = new ArrayList<Venta>(); 
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Administrador(String nombre, String apellido, String identificacion, String direccion, String telefono,
			ArrayList<Cliente> clientes, ArrayList<Venta> ventas, ArrayList<Producto> productos) {
		super(nombre, apellido, identificacion, direccion, telefono);
		this.clientes = clientes;
		this.ventas = ventas;
		this.productos = productos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Administrador [clientes=" + clientes + ", ventas=" + ventas + ", productos=" + productos + "]";
	}
	

}
