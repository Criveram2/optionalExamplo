package com.crm.OptionalPractice.main;

public class Persona {

	private String name;
    private Identificacion tipoIdentificacion;
	
	public Identificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(Identificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Persona(String name, String iden) {
		super();
		this.name = name;
		this.tipoIdentificacion = new Identificacion(iden);
	}
    
	public Persona(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
