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
import java.util.HashMap;

import com.turnos.drools.data.Cierre;
import com.turnos.drools.data.ObraSocial;
import com.turnos.drools.data.Turnos;
import com.turnos.drools.data.Especialidad;
import com.turnos.drools.data.Paciente;

public class TurnosTest {
	
	public static final void main(String[] args) {
		final KnowledgeBase kbase = readKnowledgeBase();
		final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
		List<Cierre> cierres = new ArrayList<>();
		List<String> obrasSociales = Arrays.asList("OSMATA", "OSPE", "OSMATA", "OSDE", "OSPIA", "PAMI", "OSPIP");
		List<Paciente> pacientes = new ArrayList<>();
		
		pacientes.add(new Paciente("Sofia",'F'));
		pacientes.add(new Paciente("Lola",'F'));
		pacientes.add(new Paciente("Juana",'F'));
		
		for (int i = 0; i < obrasSociales.size(); i++) {
			ObraSocial obraSocial = new ObraSocial(i, obrasSociales.get(i));
			Turnos turnos = new Turnos(i, obraSocial, 3000.00);
			Cierre cierre = new Cierre(turnos.getImporte(), turnos.getImporte(), 0, turnos);
			cierres.add(cierre);
		}

		for (int i=0;i<pacientes.size();i++) {
			Especialidad especialidad = new Especialidad(1,"MASTOLOGO");
			Turnos turno = new Turnos(i,pacientes.get(i),especialidad,3500);
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
					+ " Precio cubierto por la obra social: " + cierre.getMontoCubiertoObrasSociales() + " Monto Restante: " + cierre.getMontoSinCubrir());
		}
	}
}
