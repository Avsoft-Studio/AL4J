package org.avs.core.patterns;

public interface IServiceCollection<T extends IService> extends AutoCloseable{
	boolean addService(IService service, boolean launchService);
	
	boolean addService(IService service);
	
	IService removeService(String name);

	IService removeService(int index);
}
