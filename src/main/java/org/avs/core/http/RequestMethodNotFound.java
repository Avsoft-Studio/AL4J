package org.avs.core.http;

public class RequestMethodNotFound extends Exception{
	private static final long serialVersionUID = 2209949046500807366L;
	
	public RequestMethodNotFound() { super("The method for the web request is not know !"); }
	
	public RequestMethodNotFound(String message) { super(message); }
}
