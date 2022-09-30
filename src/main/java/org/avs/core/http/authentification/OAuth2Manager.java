package org.avs.core.http.authentification;

import java.util.Date;

public class OAuth2Manager implements IAuthManager{
	private Date dateExpirationToken;
	private String authUrl;
	private String authRefreshUrl;
	private String token;
	private String refreshToken;
	
	public OAuth2Manager(String authUrl) {
		
	}
	
	public OAuth2Manager(String authUrl, String authRefreshUrl) {
		
	}
	
	

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkValidity() {
		return false;
	}

	@Override
	public void setAuth() {
		// TODO Auto-generated method stub
		
	}
}
