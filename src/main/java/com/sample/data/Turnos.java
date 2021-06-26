package com.sample.data;

import java.util.Date;

public class Turnos {

	private int id_turno;
	
	private Date fecha_tur;

	private Paciente paciente;
	private Doctor doctor;
	private Especialidad especialidad;
	private ObraSocial obraSocial;
	private boolean diferido;
	private boolean facturado;
	private int orden;
	private int codigodoc;
	private double importe;
	private int id_estado;
	
	public Turnos(int id_turno, Date fecha_tur, Paciente paciente, Doctor doctor, Especialidad especialidad,
			ObraSocial obraSocial, boolean diferido, boolean facturado, int orden, int codigodoc, double importe,
			int id_estado) {
		super();
		this.id_turno = id_turno;
		this.fecha_tur = fecha_tur;
		this.paciente = paciente;
		this.doctor = doctor;
		this.especialidad = especialidad;
		this.obraSocial = obraSocial;
		this.diferido = diferido;
		this.facturado = facturado;
		this.orden = orden;
		this.codigodoc = codigodoc;
		this.importe = importe;
		this.id_estado = id_estado;
	}
	
	public Turnos(int id_turno,Paciente paciente,Especialidad especialidad ,double importe) {
		super();
		this.id_turno = id_turno;
		this.paciente = paciente;
		this.importe = importe;
		this.especialidad = especialidad;
	}

	public Turnos(int id_turno, ObraSocial obraSocial, double importe) {
		super();
		this.id_turno = id_turno;
		this.obraSocial = obraSocial;
		this.importe = importe;
	}
	
	public Turnos(int id_turno,Paciente paciente,double importe) {
		super();
		this.id_turno = id_turno;
		this.paciente = paciente;
		this.importe = importe;
	}
	


	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
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
