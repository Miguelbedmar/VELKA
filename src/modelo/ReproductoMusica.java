package modelo;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ReproductoMusica {

	private Clip music;

	public ReproductoMusica(String ruta) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL url = getClass().getResource(ruta);

		AudioInputStream audio = AudioSystem.getAudioInputStream(url);

		music = AudioSystem.getClip();

		music.open(audio);

	}

	public void reproducirAudio() {
		if (music != null) {
			music.loop(music.LOOP_CONTINUOUSLY);

			music.start();
		}

	}

	public void pararMusica() {
		if (music != null && music.isRunning()) {
			music.stop();
		}
	}

}
