package co.edu.uniquindio.almacen.almacen.models;

import java.time.LocalDate;

public class ProductoEnvasado {
	private LocalDate fechaEnvasado;
	private double pesoEnvase;
	private Pais paisOrigen;
	public ProductoEnvasado(LocalDate fechaEnvasado, double pesoEnvase, Pais paisOrigen) {
		super();
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
		this.paisOrigen = paisOrigen;
	}
	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public double getPesoEnvase() {
		return pesoEnvase;
	}
	public void setPesoEnvase(float pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}
	public Pais getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	@Override
	public String toString() {
		return "ProductoEnvasado [fechaEnvasado=" + fechaEnvasado + ", pesoEnvase=" + pesoEnvase + ", paisOrigen="
				+ paisOrigen + "]";
	}
	
	
	
	
	
	
	
}
