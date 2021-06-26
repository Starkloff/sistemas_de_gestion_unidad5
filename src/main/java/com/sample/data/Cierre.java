package com.sample.data;

public class Cierre {
	private double montoTotal;
	private double montoCubiertoObrasSociales;
	private double montoSinCubrir;
	private Turnos turno;
	
	public Cierre(double montoTotal, double montoCubiertoObrasSociales, double montoSinCubrir, Turnos turno) {
		super();
		this.montoTotal = montoTotal;
		this.montoCubiertoObrasSociales = montoCubiertoObrasSociales;
		this.montoSinCubrir = montoSinCubrir;
		this.turno = turno;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public double getMontoCubiertoObrasSociales() {
		return montoCubiertoObrasSociales;
	}
	public void setMontoCubiertoObrasSociales(double montoCubiertoObrasSociales) {
		this.montoCubiertoObrasSociales = montoCubiertoObrasSociales;
	}
	public double getMontoSinCubrir() {
		return montoSinCubrir;
	}
	public void setMontoSinCubrir(double montoSinCubrir) {
		this.montoSinCubrir = montoSinCubrir;
	}
	public Turnos getTurnos() {
		return turno;
	}
	public void setTurnos(Turnos turno) {
		this.turno = turno;
	}
}
