package org.avs.core.http.authentification;

public interface IAuthManager {
	void initialize();
	
	boolean checkValidity();
	
	void setAuth();
}
