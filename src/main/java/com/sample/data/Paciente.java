package com.sample.data;

public class Paciente {
	private int estado;
	private String nombre;
	private Character sexo;
	private int numHijos;
	private String estadoCivil;
	private Departamento departamento;
	private int edad;
	
	public Paciente(String nombre,char sexo, int numHijos,String estadoCivil, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.numHijos = numHijos;
		this.estadoCivil = estadoCivil;
		this.departamento = departamento;
	}
	
	public Paciente(String nombre, int edad,Departamento departamento ) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.departamento = departamento;
	}
	
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
	
	public Paciente(String nombre, int edad ) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
		
	public int getEdad() {
		return this.edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	public Departamento getDepartamento() {
		return this.departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
	
	public void setNumHijos (int numHijos) {
		this.numHijos = numHijos;
	}
	public int getNumHijos() {
		return this.numHijos;
	}
	
	public void setEstadoCivil (String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getEstadoCivil() {
		return this.estadoCivil;
	}
}
