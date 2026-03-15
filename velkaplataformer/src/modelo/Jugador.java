package modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import vista.JPanell1Juego;

public class Jugador extends Personaje implements Runnable {
	private final int altura = 64;
	private final int ancho = 48;
	// ATRIBUTOS DEL JUGADOR
	private int vida;
	private int velocidad;
	private boolean suelo;
	private boolean movimiento;

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

	private int velocidaCaida;
	private final int gravedad = 1;

	// ATRIBUTO ADICIONAL
	private JPanell1Juego juego;

	// CONSTRUCTOR JUGADOR.
	public Jugador(JPanell1Juego juego) throws IOException {
		this.juego = juego;
		vida = 3;
		velocidad = 5;
		suelo = false;
		x = 215;
		y = 350;
		posturaActual = "IDLE";
		contadorFra = 0;
		spriteActual = 0;

		// INICIALIZACION DE LOS SPRITES
		idle = new BufferedImage[4];
		correr = new BufferedImage[6];
		salto = new BufferedImage[4];
		escala = new BufferedImage[5];
		danio = new BufferedImage[4];
		porta = new BufferedImage[4];
		asignarsprites();
	}

	private void asignarsprites() throws IOException {

		// ASIGNAR SPRITES DE INACTIVIDAD
		idle[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/IDLE/IDLE0.png"));
		idle[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/IDLE/IDLE1.png"));
		idle[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/IDLE/IDLE2.png"));
		idle[3] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/IDLE/IDLE3.png"));

		// ASIGNAR SPRITES DE CORRER
		correr[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/CORRER/CORRER0.png"));
		correr[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/CORRER/CORRER1.png"));
		correr[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/CORRER/CORRER2.png"));
		correr[3] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/CORRER/CORRER3.png"));
		correr[4] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/CORRER/CORRER4.png"));
		correr[5] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/CORRER/CORRER5.png"));

		// ASIGNAR SPRITES DE SALTO
		salto[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/SALTO/SALTO0.png"));
		salto[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/SALTO/SALTO1.png"));
		salto[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/SALTO/SALTO2.png"));
		// ASIGNA SPRITES DE ESCALA
		escala[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/ESCALA/ESCALA0.png"));
		escala[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/ESCALA/ESCALA1.png"));
		escala[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/ESCALA/ESCALA2.png"));
		// ASIGNACION SPRITES DE DANIO.
		danio[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/DANIO/DANIO0.png"));
		danio[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/DANIO/DANIO1.png"));
		danio[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/DANIO/DANIO2.png"));
		danio[3] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/DANIO/DANIO3.png"));
		// ASIGNACION SPRITES DE PORTAL
		porta[0] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/PORTA/PORTA0.png"));
		porta[1] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/PORTA/PORTA1.png"));
		porta[2] = ImageIO.read(getClass().getResource("/recursos/SPRITESJUGADOR2/PORTA/PORTA2.png"));

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
		if (posturaActual.equals("PORTA"))
			return porta[spriteActual];
		return idle[0];
	}

	/*
	 * Este metodo se encarga de detectar la colison del jugador para eso se
	 * determina que un jugador tiene varias colisones en las diferentes
	 * dirrecciones arriba para techo abajo suelo izquierda y derecha para paredes.
	 */
	public boolean comprobarColision() {

		return juego.hayColision(x, y + altura) || juego.hayColision(x + ancho - 1, y + altura);
	}

	@Override
	public void run() { // Ejecucion de hilos llamando al metodo gravedad
		while (true) {
			gravedad();
			actualizarsprite();
			try {
				Thread.sleep(16);
				recogerColeccionable();
				juego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void gravedad() { // El metodo graveda calcula a que velocidad cae el jugador de un altura
		velocidaCaida += gravedad;
		int nuy = y + velocidaCaida; // teniendo en cuenta la teoria de la gravedad
		if (juego.tileSolido(x, y + altura) || (juego.tileSolido(x + ancho - 1, y + altura))) {

			// PERMITIR QUE EL
			if (velocidad >= 0) { // JUGADOR SALTO SI
				suelo = true;
				velocidaCaida = 0;
				y = (nuy + altura) / juego.getTilesi() * juego.getTilesi() - altura;
			}
			if (juego.danio(x, y + altura) || juego.danio(x + ancho - 1, y + altura)) {
				recibirdanio();
				if (vida <= 0) {
					vida = 3;
					x = 215;
					y = 350;
				}
			}

		} else {
			y = nuy;
			suelo = false;
		}

	}

	// METODO COLECCIONABLE
	public void recogerColeccionable() {
		for (Coleccionable c : juego.getColeccionable()) {
			if (!c.isAdquirido() && Math.abs(x - c.getX()) < juego.getTilesi()
					&& Math.abs(y - c.getY()) < juego.getTilesi()) {
				c.setAdquirido(true);
			}
		}
	}

	// METODOS DE MOVIMIENTO DEL JUGADOR

	public void moverDerecha() {
		movimiento = true;
		if (!juego.colisonde(x, y)) {
			x += velocidad;
		}
	}

	public void moverIzquierda() {
		x -= velocidad;
	}

	public void salto() {

		if (suelo) {
			velocidaCaida = -15;
			suelo = false;
		}
	}

	public void escalada() {

	}

	// METODO QUE SE ENCARGARA DE ACTUALIZAS EL SPRITE DEL JUGADOR .
	private void actualizarsprite() {
		String postuAnterior = posturaActual;
		if (!suelo)
			posturaActual = "SALTO";
		else if (movimiento)
			posturaActual = "CORRER";
		else
			posturaActual = "IDLE";
		if (!posturaActual.equals(postuAnterior)) {
			spriteActual = 0;
			contadorFra = 0;
		}

		contadorFra++;

		if (contadorFra >= 8) {
			contadorFra = 0;
			spriteActual++;
			if (posturaActual.equals("IDLE") && spriteActual >= idle.length)

				spriteActual = 0;
			if (posturaActual.equals("CORRER") && spriteActual >= correr.length)

				spriteActual = 0;
			if (posturaActual.equals("SALTO") && spriteActual >= salto.length)

				spriteActual = 0;
		}

	}

	public void recibirdanio() {
		vida--;
		x = 215;
		y = 350;
		velocidaCaida = 0;
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

	public boolean isMovimiento() {
		return movimiento;
	}

	public void setMovimiento(boolean movimiento) {
		this.movimiento = movimiento;
	}

}
