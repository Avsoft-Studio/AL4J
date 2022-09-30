package org.avs.core.http;

import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Optional;

import org.avs.core.helper.GenericMethod;

public class WebRequest extends HttpRequest{
	private MethodEnum method;
	
	@Override
	public String method() { return method.code(); }
	
	public void method(String method) throws Throwable {
		GenericMethod.requireNonNull(method);
		this.method = GenericMethod.<MethodEnum>fromValue(method.toUpperCase(), MethodEnum.values(), new RequestMethodNotFound());
	}
	
	public void method(MethodEnum method) { this.method = method; }

	@Override
	public Optional<BodyPublisher> bodyPublisher() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Optional<Duration> timeout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean expectContinue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public URI uri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Version> version() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders headers() {
		// TODO Auto-generated method stub
		return null;
	}

}
