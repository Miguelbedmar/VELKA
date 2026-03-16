package main;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import vista.JFramePrincipal;

public class Principal {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		JFramePrincipal ventana = new JFramePrincipal();
		ventana.setVisible(true);
	}

}
