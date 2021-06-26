package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.data.*;

public class DroolsTest {

	public static final void main(String[] args) {

		KieServices ks = KieServices.Factory.get();

		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");

		kSession.addEventListener(new DebugAgendaEventListener());
		kSession.addEventListener(new DebugRuleRuntimeEventListener());
		KieRuntimeLogger logger = ks.getLoggers().newFileLogger(kSession, "./turnos");

		List<Cierre> cierres = new ArrayList<>();
		List<String> obrasSociales = Arrays.asList("OSMATA", "OSPE", "OSMATA", "OSDE", "OSPIA", "PAMI", "OSPIP");
		List<Paciente> pacientes = new ArrayList<>();

		for (int i = 0; i < obrasSociales.size(); i++) {
			ObraSocial obraSocial = new ObraSocial(i, obrasSociales.get(i), false);
			if (obraSocial.getNombre().equals("OSPE")) {
				obraSocial.setEsPrivado(true);
			}
			Turnos turno = new Turnos(i, obraSocial, 3000.00);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), 0, turno);
			cierres.add(cierre);
		}

		pacientes.add(new Paciente("Sofia", 'F'));
		pacientes.add(new Paciente("Lola", 'F'));

		for (int i = 0; i < pacientes.size(); i++) {
			Especialidad especialidad = new Especialidad(1, "Mastologo");
			Turnos turno = new Turnos(i + obrasSociales.size(), pacientes.get(i), especialidad, 4500);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), turno.getImporte(), turno);
			cierres.add(cierre);
		}

		List<Paciente> solteras = new ArrayList<>();
		solteras.add(new Paciente("Jenny", 'F', 6, "Soltera", new Departamento(2, "Guaymallen")));

		for (int i = 0; i < solteras.size(); i++) {
			Turnos turno = new Turnos(i + obrasSociales.size() + pacientes.size(), solteras.get(i), 8888);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), turno.getImporte(), turno);
			cierres.add(cierre);
		}

		List<Paciente> abuelos = new ArrayList<>();

		abuelos.add(new Paciente("Holga", 75, new Departamento(3, "San Rafael")));

		for (int i = 0; i < abuelos.size(); i++) {
			Turnos turno = new Turnos(i + obrasSociales.size() + pacientes.size() + solteras.size(), abuelos.get(i),
					new Especialidad(1, "Neumologia"), 20000);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), turno.getImporte(), turno);
			cierres.add(cierre);
		}

		List<Paciente> cirugia_plastica = new ArrayList<>();

		cirugia_plastica.add(new Paciente("Jose", 28));

		for (int i = 0; i < cirugia_plastica.size(); i++) {

			Especialidad especialidad = new Especialidad(1, "Cirugia plastica");

			Turnos turno = new Turnos(i + obrasSociales.size() + pacientes.size() + solteras.size() + abuelos.size(),
					cirugia_plastica.get(i), especialidad, 35000);
			Cierre cierre = new Cierre(turno.getImporte(), turno.getImporte(), turno.getImporte(), turno);
			cierres.add(cierre);
		}

		for (Cierre cierre : cierres) {
			kSession.insert(cierre);
		}

		kSession.fireAllRules();

		kSession.dispose();
		logger.close();
		showResults(cierres);
	}

	private static void showResults(List<Cierre> cierres) {
		for (Cierre cierre : cierres) {
			System.out.println("Turno " + cierre.getTurnos().getId_turno() + " montoTotal: " + cierre.getMontoTotal()
					+ " Precio cubierto por la obra social: " + cierre.getMontoCubiertoObrasSociales()
					+ " Monto Restante: " + cierre.getMontoSinCubrir());
		}
	}
}
