package org.avs.core.http;

public enum MethodEnum {
	GET("GET"), DELETE("DELETE"), PUT("PUT"), POST("POST");
	
	private String code;
	
	private MethodEnum(String code) { this.code = code; }
	
	public String code() { return code; }
}
