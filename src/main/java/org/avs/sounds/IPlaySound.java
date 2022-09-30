package org.avs.sounds;

import java.io.File;

public interface IPlaySound {
	
	void setGain(float gain);
	
	void setDefaultGain();
	
	void changeSound(String url) throws Exception;
	
	void changeSound(File f) throws Exception;
	
	void setDefaultBalance();
	
	void setBalance(float balance);
	
	void pause();
	
	boolean isPaused();
	
	void resume();
	
	void stop();
	
	boolean isStopped();
	
	void loop();
	
	void close();
	
	void play();
}
