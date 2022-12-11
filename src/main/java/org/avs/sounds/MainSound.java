package org.avs.sounds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import avsoft.age.fr.back.Initializer;
//import avsoft.back.sounds.playformats.extendsounds.PlayOgg;

//import avsoft.back.sounds.playformats.*;

public class MainSound {
	public static void main(String[] args) throws Exception {
		
		/*******PLAYSOUND FOR BASE FILE (WAV AU AIFF)********/
		//Initializer.initialize();
		//PlaySoundBase psb = new PlaySoundBase("C:\\Users\\IM2AG\\Downloads\\test.wav"); //String en parametre
		//PlaySoundBase psb = new PlaySoundBase(new File("C:\\Users\\IM2AG\\Downloads\\test.wav")); //File en parametre
		System.out.println("Play()");
		//psb.play();
		//TEST FONCTION CHANGESOUND
		try { Thread.sleep(10000); } catch (Exception e) {};
		//System.out.println("changeSound()");
		//psb.changeSound("C:\\Users\\IM2AG\\Downloads\\test2.wav");
		//psb.play();
		try { Thread.sleep(10000); } catch (Exception e) {};
		//TEST FONCTION PAUSE ET RESUME
		/*try { Thread.sleep(10000); } catch (Exception e) {};
		psb.pause();
		System.out.println("Pause()");
		try { Thread.sleep(5000); } catch (Exception e) {};
		psb.resume();
		System.out.println("Resume()");
		try { Thread.sleep(5000); } catch (Exception e) {};*/
		//TEST FONCTION LOOP
		/*psb.loop();
		try { Thread.sleep(1000); } catch (Exception e) {};
		System.out.println(psb.getMilliTime());
		try { Thread.sleep(psb.getMilliTime()); } catch (Exception e) {};
		System.out.println("fin première loop");
		System.out.println("début deuxième loop");
		try { Thread.sleep(psb.getMilliTime()); } catch (Exception e) {};
		System.out.println("fin deuxième loop");*/
		/*******PLAYSOUND FOR WAV FILE DEPRECATED********/
        /*System.out.println("test 2");
        SoundManager test1 = new SoundManager(null, (byte)100, "C:\\Users\\IM2AG\\Downloads\\test.wav");
        test1.setRepeat(true);
        Thread test = new Thread(test1);

        test.start();
        try{
            test.join();
        }catch(Exception e){
            e.printStackTrace();
        }*/
		
		/*******PLAYSOUND FOR OGG FILE********/
		/*try {
			Initializer.initialize();
			FileInputStream test = new FileInputStream("C:\\test.ogg");
			File f = new File("c:\\test.ogg");
			//PlayOgg ogg = new PlayOgg(test); //Stream en parametre
			//PlayOgg ogg = new PlayOgg(f); //File en parametre
			PlayOgg ogg = new PlayOgg("C:\\test.ogg"); //String en parametre
			System.out.println("Play()");
			ogg.loop();
			ogg.setBalance(-1.0f);
			try { Thread.sleep(3000); } catch (Exception e) {};
			System.out.println("Pause()");
			ogg.pause();
			try { Thread.sleep(2000); } catch (Exception e) {};
			System.out.println("Resume()");
			ogg.resume();
			
			try { Thread.sleep(3000); } catch (Exception e) {};
			System.out.println("Stop()");
			ogg.stop();
			try { Thread.sleep(3000); } catch (Exception e) {};
			System.out.println("Play()");
			ogg.setBalance(0f);
			ogg.setGain(1.0f);
			ogg.play();
			try { Thread.sleep(3000); } catch (Exception e) {};
			ogg.stop();

			System.out.println("Start Loop");
			ogg.loop();
			
			boolean gameLooping = true;
			int num = 0;
			while (gameLooping) {
				num++;
				System.out.println("Game Logic: "+num);
				try { Thread.sleep(1000); } catch (Exception e) {};
				
				if (num == 20) {
					System.out.println("Stop");
					ogg.stop();
				}
				if (num == 30) {
					System.out.println("Reloop");
					ogg.loop();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
}}
