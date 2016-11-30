import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Sounds {
	private static Boolean soundon = true;

	public void singleClick() {
		if (soundon == true)
			try {
				ClassLoader classloader = getClass().getClassLoader();
				File audioFile = new File(classloader.getResource("sounds/singleclick.wav").getFile());
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.open(audioStream);
				audioClip.start();
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	public void noMatchClick() {
		if (soundon == true)
			try {
				ClassLoader classloader = getClass().getClassLoader();
				File audioFile = new File(classloader.getResource("sounds/nomatch.wav").getFile());
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.open(audioStream);
				audioClip.start();
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	public void doubleClick() {
		if (soundon == true)
			try {
				ClassLoader classloader = getClass().getClassLoader();
				File audioFile = new File(classloader.getResource("sounds/doubleclick.wav").getFile());
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.open(audioStream);
				audioClip.start();
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	public static Boolean getSoundon() {
		return soundon;
	}

	public static void setSoundon(Boolean soundon) {
		Sounds.soundon = soundon;
	}

}
