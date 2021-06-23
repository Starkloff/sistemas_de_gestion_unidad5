package com.turnos.drools.data;

public class Paciente {
	private int estado;
	private String nombre;
	private Character sexo;
	
	public Paciente(int estado,String nombre,char sexo) {
		super();
		this.estado=estado;
		this.nombre=nombre;
		this.sexo=sexo;
	}
	public Paciente(String nombre,char sexo) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
	}
	
	public int getEstado () {
		return this.estado;
	}
	public void setEstado(int estado) {
		this.estado=estado;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Character getSexo() {
		return this.sexo;
	}
	
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Customer [status=" + this.estado + ", name=" + this.nombre+ "]";
	}
}
