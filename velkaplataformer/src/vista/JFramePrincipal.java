package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

import modelo.ReproductoMusica;

public class JFramePrincipal extends JFrame {
	private ReproductoMusica music;
	JpanelMenu panel = new JpanelMenu();

	public JFramePrincipal() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setTitle("VELKA");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel, BorderLayout.CENTER);
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/VELKAAA.png"));
		setIconImage(icono.getImage());
		music=new ReproductoMusica("/recursos/MUSICA/MusicaMenu.wav");
		music.reproducirAudio();
		
	}

}
