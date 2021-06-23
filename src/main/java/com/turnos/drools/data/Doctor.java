package com.turnos.drools.data;

public class Doctor {

	
	private String nombre;
	private String estado;
	private Especialidad especialidad;
	
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

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
