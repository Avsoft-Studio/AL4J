package org.avs.xml.java;

import org.avs.core.patterns.enumerations.IBaseEnum;

/**
 * 
 * @author Avanzino.A
 * @since 14/07/2022
 * @version 1.0
 */
public enum AccessibilityEnum implements IBaseEnum{
	PUBLIC("public"),
	PROTECTED("protected"),
	PRIVATE("private"),
	PACKAGE("package"),
	NONE("");
	
	private String code;
	
	AccessibilityEnum(String code){
		this.code = code;
	}
	
	public String getCode() { return this.code; }
}
