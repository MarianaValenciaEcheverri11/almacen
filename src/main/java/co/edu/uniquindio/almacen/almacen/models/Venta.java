package co.edu.uniquindio.almacen.almacen.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
	private String codigo;
	private LocalDate fecha;
	private ArrayList<Detalle> detalles = new ArrayList<Detalle>();
	private Cliente cliente;
	private double total;
	private float iva;
	
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}


	public Venta(String codigo, LocalDate fecha, ArrayList<Detalle> detalles, Cliente cliente, double total,
			float iva) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.detalles = detalles;
		this.cliente = cliente;
		this.total = total;
		this.iva = iva;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}


	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public float getIva() {
		return iva;
	}


	public void setIva(float iva) {
		this.iva = iva;
	}


	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", fecha=" + fecha + ", detalles=" + detalles + ", cliente=" + cliente
				+ ", total=" + total + ", iva=" + iva + "]";
	}
	
	

}
