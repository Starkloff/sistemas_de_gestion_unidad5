package com.autentia.tutorial.drools.data;

public class Doctor {

	
	private String nombre;
	private String estado;
	
	public Doctor(String estado, String nombre) {
		super();
		this.estado = estado;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
