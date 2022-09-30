package org.avs.xml.java;

import org.avs.core.patterns.enumerations.IBaseEnum;

public enum TypeJavaFileEnum implements IBaseEnum{
	ENUM("enum"),
	INTERFACE("interface"),
	ANNOTINTERFACE("@interface"),
	CLASS("class"),
	RECORD("record");

	private String code;
	
	TypeJavaFileEnum(String code){ this.code = code; }
	
	public String getCode() { return code; }
}
