package org.avs.core.patterns;

public interface IService extends Runnable, AutoCloseable{
	boolean isRunning();
	
	String name();
}
