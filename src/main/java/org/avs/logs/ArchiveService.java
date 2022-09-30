package org.avs.logs;

import org.avs.core.patterns.IService;

public class ArchiveService implements IService{

	@Override
	public String name() {
		return this.getClass().getName();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
