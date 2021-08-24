package thequizmaster.objects;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	String path = ".//res//audio//tripwire.wav";
	public Clip clip;
	
	public Audio() {
		setFile();
	}
	
	public void setFile() {
		try {
			File sound = new File(path);
			AudioInputStream audio = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audio);
		} catch(Exception e) {
			System.out.println("Audio at " + path + " not found");
			System.out.println(e);
		}
	}
	
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
}
