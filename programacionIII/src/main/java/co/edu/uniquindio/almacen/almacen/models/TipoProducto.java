package co.edu.uniquindio.almacen.almacen.models;

public class TipoProducto {
	private ProductoPerecedero productoPerecedero;
	private ProductoEnvasado productoEnvasado;
	private ProductoRefrigerado productoRefrigerado;
	

	public TipoProducto(ProductoPerecedero productoPerecedero) {
		super();
		this.productoPerecedero = productoPerecedero;
	}


	public TipoProducto(ProductoEnvasado productoEnvasado) {
		super();
		this.productoEnvasado = productoEnvasado;
	}


	public TipoProducto(ProductoRefrigerado productoRefrigerado) {
		super();
		this.productoRefrigerado = productoRefrigerado;
	}


	public ProductoPerecedero getProductoPerecedero() {
		return productoPerecedero;
	}


	public void setProductoPerecedero(ProductoPerecedero productoPerecedero) {
		this.productoPerecedero = productoPerecedero;
	}


	public ProductoEnvasado getProductoEnvasado() {
		return productoEnvasado;
	}


	public void setProductoEnvasado(ProductoEnvasado productoEnvasado) {
		this.productoEnvasado = productoEnvasado;
	}


	public ProductoRefrigerado getProductoRefrigerado() {
		return productoRefrigerado;
	}


	public void setProductoRefrigerado(ProductoRefrigerado productoRefrigerado) {
		this.productoRefrigerado = productoRefrigerado;
	}


	
	public String toStringProductoEnvasado() {
		return "TipoProducto [productoEnvasado=" + productoEnvasado + "]";
	}
	public String toStringProductoRefrigeador() {
		return "TipoProducto [productoRefrigerado=" + productoRefrigerado + "]";
	}
	public String toStringProductoPerecedero() {
		return "TipoProducto [productoPerecedero=" + productoPerecedero + "]";
	}
	



	
	
	
	
	
	
	

}
