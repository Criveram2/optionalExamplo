package com.crm.OptionalPractice.main;

import java.util.Optional;

public class OptinalPractive {

	public static void main(String[] args) {
		Persona camilo = new Persona("Camilo");
		Persona camilo1 = new Persona(null);
		System.out.println("1-" + returnName(camilo));
		Persona nada = null;
		System.out.println("2-" + returnName(nada));
		System.out.println("3-" + returnName(camilo1));

		System.out.println("1-" + returnNameOptional(camilo));
		System.out.println("2-" + returnNameOptional(nada));
		System.out.println("3-" + returnNameOptional(camilo1));
		ejemplo2();
	}

	private static void ejemplo2() {
		Persona camilo = new Persona("Camilo", "cedula");
		Persona camilo1 = new Persona("Camilo", null);
		System.out.println("4-" + returnTipoIdentificacion(camilo));
		System.out.println("5-" + returnTipoIdentificacion(camilo1));
		System.out.println("6-" + returnOptinalTipoIdentificacion(camilo));
		System.out.println("7-" + returnOptinalTipoIdentificacion(camilo1));
		ejemploFilter();
	}

	private static void ejemploFilter() {
		Persona camilo = new Persona("Camilo", "cedula");
		Persona camilo1 = new Persona("Camilo", null);
		System.out.println("8-" + returnNameTipoIdentificacionCedula(camilo));
		System.out.println("9-" + returnNameTipoIdentificacionCedula(camilo1));
		System.out.println("10-" + returnOptinalNameTipoIdentificacionCedula(camilo));
		System.out.println("11-" + returnOptinalNameTipoIdentificacionCedula(camilo1));

	}

	private static String returnTipoIdentificacion(Persona persona) {
		if (persona != null && persona.getTipoIdentificacion() != null
				&& persona.getTipoIdentificacion().getTipoIdentificacion() != null) {
			return persona.getTipoIdentificacion().getTipoIdentificacion();
		}
		return "N/A";
	}

	private static String returnOptinalTipoIdentificacion(Persona persona) {
		return Optional.ofNullable(persona).map(p -> p.getTipoIdentificacion()).map(t -> t.getTipoIdentificacion())
				.orElse("N/A");
	}

	private static String returnNameTipoIdentificacionCedula(Persona persona) {
		if (persona != null && persona.getTipoIdentificacion() != null
				&& persona.getTipoIdentificacion().getTipoIdentificacion() != null
				&& persona.getTipoIdentificacion().getTipoIdentificacion() == "cedula") {
			return persona.getName();
		}
		return "N/A";
	}

	private static String returnOptinalNameTipoIdentificacionCedula(Persona persona) {
		return Optional.ofNullable(persona).map(p -> p.getTipoIdentificacion())
				.map(t -> t.getTipoIdentificacion())
				//.filter(t -> t.equals("cedula"))
				.filter(tipoIdent -> valideIfTipoIdentificacionIsCedula(tipoIdent))
				.map(j -> persona.getName()).orElse("N/A");
	}
	
	
	private static boolean valideIfTipoIdentificacionIsCedula(String tipoIdent){
		
		if(tipoIdent.equals("cedula")){
			return true;
		}
		return false;
	}
	
	

	private static String returnName(Persona persona) {
		if (persona != null && persona.getName() != null) {
			return persona.getName();
		}
		return "N/A";
	}

	private static String returnNameOptional(Persona persona) {
		return Optional.ofNullable(persona).map(p -> p.getName()).orElse("N/A");
	}

}
