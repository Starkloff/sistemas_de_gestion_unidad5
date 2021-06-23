package com.turnos.drools.data;

public class Especialidad {

	private String estado;
	
	private String nombre;
	
	public Especialidad(String estado, String nombre) {
		super();
		this.estado = estado;
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
