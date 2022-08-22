package co.edu.uniquindio.almacen.almacen.models;

public class ProductoRefrigerado {
	
	private String codigoControlOrganismoControl;
	private double temperaturaRefrigeracionRecomendada;
	
	
	
	public ProductoRefrigerado(String codigoControlOrganismoControl, double temperaturaRefrigeracionRecomendada) {
		super();
		this.codigoControlOrganismoControl = codigoControlOrganismoControl;
		this.temperaturaRefrigeracionRecomendada = temperaturaRefrigeracionRecomendada;
	}
	public String getCodigoControlOrganismoControl() {
		return codigoControlOrganismoControl;
	}
	public void setCodigoControlOrganismoControl(String codigoControlOrganismoControl) {
		this.codigoControlOrganismoControl = codigoControlOrganismoControl;
	}
	public double getTemperaturaRefrigeracionRecomendada() {
		return temperaturaRefrigeracionRecomendada;
	}
	public void setTemperaturaRefrigeracionRecomendada(double temperaturaRefrigeracionRecomendada) {
		this.temperaturaRefrigeracionRecomendada = temperaturaRefrigeracionRecomendada;
	}
	@Override
	public String toString() {
		return "ProductoRefrigerado [codigoControlOrganismoControl=" + codigoControlOrganismoControl
				+ ", temperaturaRefrigeracionRecomendada=" + temperaturaRefrigeracionRecomendada + "]";
	}
	
	
	

}
