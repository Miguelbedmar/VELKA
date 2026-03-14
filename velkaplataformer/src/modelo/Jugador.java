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
	private BufferedImage[] escala;
	private BufferedImage[] danio;
	private BufferedImage[] porta;

	private int spriteActual;
	private int contadorFra;
	private String posturaActual;
	private Thread hiloJugador;

	// CONSTRUCTOR JUGADOR.
	public Jugador() throws IOException {
		vida = 3;
		velocidad = 4;
		suelo = false;
		x = 100;
		y = 100;
		posturaActual = "IDLE";
		contadorFra = 0;
		spriteActual = 0;

		// INICIALIZACION DE LOS SPRITES
		idle = new BufferedImage[4];
		correr = new BufferedImage[6];
		salto = new BufferedImage[3];
		escala = new BufferedImage[3];
		danio = new BufferedImage[4];
		porta = new BufferedImage[3];
		asignarsprites();
	}

	private void asignarsprites() throws IOException {
		// ASIGNAR SPRITES DE INACTIVIDAD
		idle[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/IDLE/IDLE0.png"));
		idle[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/IDLE/IDLE1.png"));
		idle[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/IDLE/IDLE2.png"));
		idle[3] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/IDLE/IDLE3.png"));

		// ASIGNAR SPRITES DE CORRER
		correr[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/CORRER/CORRER0.png"));
		correr[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/CORRER/CORRER1.png"));
		correr[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/CORRER/CORRER2.png"));
		correr[3] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/CORRER/CORRER3.png"));
		correr[4] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/CORRER/CORRER4.png"));
		correr[5] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/CORRER/CORRER5.png"));

		// ASIGNAR SPRITES DE SALTO
		salto[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/SALTO/SALTO0.png"));
		salto[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/SALTO/SALTO1.png"));
		salto[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/SALTO/SALTO2.png"));
		// ASIGNA SPRITES DE ESCALA
		escala[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/ESCALA/ESCALA0.png"));
		escala[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/ESCALA/ESCALA1.png"));
		escala[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/ESCALA/ESCALA2.png"));
		// ASIGNACION SPRITES DE DANIO.
		danio[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/DANIO/DANIO0.png"));
		danio[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/DANIO/DANIO1.png"));
		danio[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/DANIO/DANIO2.png"));
		danio[3] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/DANIO/DANIO3.png"));
		// ASIGNACION SPRITES DE PORTAL
		porta[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/PORTA/PORTA0.png"));
		porta[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/PORTA/PORTA1.png"));
		porta[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR/PORTA/PORTA2.png"));

	}

	public BufferedImage getspriteActual() {
		// SI LA POSTURA EQUIVALE A JUGADOR INACTIVO
		if (posturaActual.equals("IDLE"))
			return idle[spriteActual];
		// SI LA POSTURA EQUIVALE A JUGADOR CORRIENDO
		if (posturaActual.equals("CORRER"))
			return correr[spriteActual];
		// SI LA POSTURA EQUIVALE A JUGADOR SALTANDO
		if (posturaActual.equals("SALTO"))
			return salto[spriteActual];
		if (posturaActual.equals("ESCALA"))
			return escala[spriteActual];
		if (posturaActual.equals("DANIO"))
			return danio[spriteActual];
		if (posturaActual.equals("PORTAL"))
			return porta[spriteActual];
		return idle[0];
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public void gravedad() {
		// TODO Auto-generated method stub

	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isSuelo() {
		return suelo;
	}

	public void setSuelo(boolean suelo) {
		this.suelo = suelo;
	}

	public BufferedImage[] getIdle() {
		return idle;
	}

	public void setIdle(BufferedImage[] idle) {
		this.idle = idle;
	}

	public BufferedImage[] getCorrer() {
		return correr;
	}

	public void setCorrer(BufferedImage[] correr) {
		this.correr = correr;
	}

	public BufferedImage[] getSalto() {
		return salto;
	}

	public void setSalto(BufferedImage[] salto) {
		this.salto = salto;
	}

	public BufferedImage[] getEscala() {
		return escala;
	}

	public void setEscala(BufferedImage[] escala) {
		this.escala = escala;
	}

	public BufferedImage[] getDanio() {
		return danio;
	}

	public void setDanio(BufferedImage[] danio) {
		this.danio = danio;
	}

	public BufferedImage[] getPorta() {
		return porta;
	}

	public void setPorta(BufferedImage[] porta) {
		this.porta = porta;
	}

	public int getSpriteActual() {
		return spriteActual;
	}

	public void setSpriteActual(int spriteActual) {
		this.spriteActual = spriteActual;
	}

	public int getContadorFra() {
		return contadorFra;
	}

	public void setContadorFra(int contadorFra) {
		this.contadorFra = contadorFra;
	}

	public String getPosturaActual() {
		return posturaActual;
	}

	public void setPosturaActual(String posturaActual) {
		this.posturaActual = posturaActual;
	}

	public Thread getHiloJugador() {
		return hiloJugador;
	}

	public void setHiloJugador(Thread hiloJugador) {
		this.hiloJugador = hiloJugador;
	}

}
