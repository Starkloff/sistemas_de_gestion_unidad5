package com.turnos.drools.data;

public class Departamento {
	private int id;
	private String nombre;
	public Departamento(int id,String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
}
