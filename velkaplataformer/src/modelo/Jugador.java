package modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Jugador extends Personaje implements Runnable {

	// ATRIBUTOS DEL JUGADOR
	private int vida;
	private int velocidad;
	private boolean suelo;

	// ATRIBUTOS ANIMACIONES.

	private BufferedImage[] idle;
	private BufferedImage[] correr;
	private BufferedImage[] salto;

	private int spriteActual;
	private int contadorFra;
	private String posturaActual;
	private Thread hiloJugador;

	// CONSTRUCTOR JUGADOR.
	public Jugador() {
		vida = 3;
		velocidad = 4;
		suelo = false;

		// INICIALIZACION DE LOS SPRITES
		idle = new BufferedImage[6];
		correr = new BufferedImage[4];
		salto = new BufferedImage[3];
	}

	private void asignarsprites() throws IOException {
		// ASIGNAR SPRITES DE INACTIVIDAD
		idle[0] = ImageIO.read(getClass().getResource(""));
		idle[1] = ImageIO.read(getClass().getResource(""));
		idle[2] = ImageIO.read(getClass().getResource(""));
		idle[3] = ImageIO.read(getClass().getResource(""));
		idle[4] = ImageIO.read(getClass().getResource(""));
		idle[5] = ImageIO.read(getClass().getResource(""));

		// ASIGNAR SPRITES DE CORRER
		correr[0] = ImageIO.read(getClass().getResource(""));
		correr[1] = ImageIO.read(getClass().getResource(""));
		correr[2] = ImageIO.read(getClass().getResource(""));
		correr[3] = ImageIO.read(getClass().getResource(""));
		// ASIGNAR SPRITES DE SALTO
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public void gravedad() {
		// TODO Auto-generated method stub

	}

}
