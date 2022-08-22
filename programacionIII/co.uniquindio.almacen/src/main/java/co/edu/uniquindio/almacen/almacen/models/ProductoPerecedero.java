package co.edu.uniquindio.almacen.almacen.models;

import java.time.LocalDate;

public class ProductoPerecedero {
	private LocalDate fechaVencimiento;

	public ProductoPerecedero(LocalDate fechaVencimiento) {
		super();
		this.fechaVencimiento = fechaVencimiento;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public String toString() {
		return "ProductoPerecedero [fechaVencimiento=" + fechaVencimiento + "]";
	}
	
	

}
