package co.edu.uniquindio.almacen.almacen.models;

public class Detalle {
	private int cantidad;
	private double subtotal;
	private Producto producto;

	public Detalle() {
		// TODO Auto-generated constructor stub
	}

	public Detalle(int cantidad, double subtotal, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Detalle [cantidad=" + cantidad + ", subtotal=" + subtotal + ", producto=" + producto + "]";
	}
	
	

}
