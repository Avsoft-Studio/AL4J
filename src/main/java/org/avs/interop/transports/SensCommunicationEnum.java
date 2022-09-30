package org.avs.interop.transports;

//import Avsoft.Patrons.Enumeration.ICommonEnum;

public enum SensCommunicationEnum /*implements ICommonEnum*/{
	ENTRANT("ENT", "Entrant"),
	SORTANT("SORT", "Sortant"),
	BIDIRECTIONNEL("BIDI", "Bidirectionnel");
	
	private String code;
	private String libelle;
	
	private SensCommunicationEnum(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	public String getCode() { return code; }

	public String getLibelle() { return libelle ; }	
}
