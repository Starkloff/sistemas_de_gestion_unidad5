package com.turnos.drools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.turnos.drools.data.*;

public class TurnosTest {

	public static final void main(String[] args) {

		final KnowledgeBase kbase = readKnowledgeBase();
		final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		List<Cierre> cierres = new ArrayList<>();
		List<String> obrasSociales = Arrays.asList("OSMATA", "OSPE", "OSMATA", "OSDE", "OSPIA", "PAMI", "OSPIP");
		List<Paciente> pacientes = new ArrayList<>();

		for (int i = 0; i < obrasSociales.size(); i++) {
			ObraSocial obraSocial = new ObraSocial(i, obrasSociales.get(i));
			Turnos turnos = new Turnos(i, obraSocial, 3000.00);
			Cierre cierre = new Cierre(turnos.getImporte(), turnos.getImporte(), 0, turnos);
			cierres.add(cierre);
		}

		pacientes.add(new Paciente("Sofia", 'F'));
		pacientes.add(new Paciente("Lola", 'F'));

		for (int i = 0; i < pacientes.size(); i++) {
			Especialidad especialidad = new Especialidad(1, "Mastologo");
			Turnos turno = new Turnos(i+7, pacientes.get(i), especialidad, 4500);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), 0, turno);
			cierres.add(cierre);
		}

		List<Paciente> solteras = new ArrayList<>();
		solteras.add(new Paciente("Jenny", 'F', 6, "Soltera", new Departamento(2, "Guaymallen")));

		for (int i = 0; i < solteras.size(); i++) {
			Turnos turno = new Turnos(i+10, solteras.get(i), 8888);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), 0, turno);
			cierres.add(cierre);
		}

		List<Paciente> abuelos = new ArrayList<>();

		abuelos.add(new Paciente("Holga", 75, new Departamento(3, "San Rafael")));

		for (int i = 0; i < abuelos.size(); i++) {
			Turnos turno = new Turnos(i+11, abuelos.get(i), new Especialidad(1, "Neumologia"), 20000);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), 0, turno);
			cierres.add(cierre);
		}

		List<Paciente> cirugia_plastica = new ArrayList<>();

		cirugia_plastica.add(new Paciente("Jose", 28));

		for (int i = 0; i < cirugia_plastica.size(); i++) {

			Especialidad especialidad = new Especialidad(1, "Cirugia plastica");

			Turnos turno = new Turnos(i+12, cirugia_plastica.get(i), especialidad, 35000);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), 0, turno);
			cierres.add(cierre);
		}

		for (Cierre cierre : cierres) {
			ksession.insert(cierre);
		}

		ksession.fireAllRules();
		showResults(cierres);
	}

	private static KnowledgeBase readKnowledgeBase() {
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("Order.drl"), ResourceType.DRL);
		if (kbuilder.hasErrors()) {
			for (KnowledgeBuilderError error : kbuilder.getErrors()) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Imposible crear knowledge con Order.drl");
		}
		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

	private static void showResults(List<Cierre> cierres) {
		for (Cierre cierre : cierres) {
			System.out.println("Turno " + cierre.getTurnos().getId_turno() + " montoTotal: " + cierre.getMontoTotal()
					+ " Precio cubierto por la obra social: " + cierre.getMontoCubiertoObrasSociales()
					+ " Monto Restante: " + cierre.getMontoSinCubrir());
		}
	}
}
