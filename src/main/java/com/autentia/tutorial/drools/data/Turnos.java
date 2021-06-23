package com.autentia.tutorial.drools.data;

import java.util.Date;

public class Turnos {

	private int id_turno;
	
	private Date fecha_tur;

	private Paciente paciente;
	private Doctor doctor;
	private Especialidad especialidad;
	private boolean diferido;
	private boolean facturado;
	private int orden;
	private int codigodoc;
	private double importe;
	private int id_estado;

	public Turnos(Paciente paciente) {
		super();
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getId_turno() {
		return id_turno;
	}

	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}

	public Date getFecha_tur() {
		return fecha_tur;
	}

	public void setFecha_tur(Date fecha_tur) {
		this.fecha_tur = fecha_tur;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public boolean isDiferido() {
		return diferido;
	}

	public void setDiferido(boolean diferido) {
		this.diferido = diferido;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getCodigodoc() {
		return codigodoc;
	}

	public void setCodigodoc(int codigodoc) {
		this.codigodoc = codigodoc;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	
}
