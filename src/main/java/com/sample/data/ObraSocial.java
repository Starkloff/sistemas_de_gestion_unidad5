package com.sample.data;


public class ObraSocial {

	private int id;
	private String nombre;
	private boolean esPrivado;
	
	public ObraSocial(int id, String nombre, boolean esPrivado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.esPrivado = esPrivado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEsPrivado() {
		return esPrivado;
	}
	public void setEsPrivado(boolean esPrivado) {
		this.esPrivado = esPrivado;
	}
	
	
	
}
