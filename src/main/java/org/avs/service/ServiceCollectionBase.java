package org.avs.service;

import java.util.HashMap;
import java.util.Map;

import org.avs.core.patterns.IService;
import org.avs.core.patterns.IServiceCollection;

public class ServiceCollectionBase implements IServiceCollection<IService> {
	private final Map<IService, Thread> list;
	
	public ServiceCollectionBase() {
		this.list = new HashMap<IService, Thread>();
	}

	@Override
	public boolean addService(IService service) {
		
		this.list.put(service, null);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IService removeService(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IService removeService(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addService(IService service, boolean launchService) {
		// TODO Auto-generated method stub
		return false;
	}
}
