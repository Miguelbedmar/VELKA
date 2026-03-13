package modelo;

import java.awt.image.BufferedImage;

public class Jugador extends Personaje implements Runnable {

	// ATRIBUTOS DEL JUGADOR
	private int vida;
	private int velocidad;
	private boolean suelo;

	// ATRIBUTOS ANIMACIONES.

	private BufferedImage[] Idle;
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
		Idle = new BufferedImage[6];
		correr = new BufferedImage[4];
		salto = new BufferedImage[3];
	}

	private void asignarsprites() {
		
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
