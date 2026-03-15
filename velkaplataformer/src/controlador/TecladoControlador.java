package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Jugador;

public class TecladoControlador implements KeyListener {

	private int key;
	private Jugador jugador;
	private boolean derechapress;
	private boolean izquierdapress;

	public TecladoControlador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			derechapress = true;

		}
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { // Ir a la izquierda con la flecha izquierda o a de wdas
			izquierdapress = true;

		}
		if (key == KeyEvent.VK_C || key == KeyEvent.VK_SPACE) { // Tecla Salto con x o con espacio
			jugador.salto();
		}
		if (key == KeyEvent.VK_Z) { // Tecla de escalada Z

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_D) {
			derechapress = false;

		}
		if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_A) { // Ir a la izquierda con la flecha izquierda o a de wdas
			izquierdapress = false;

		}

		jugador.setMovimiento(false);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public boolean isDerechapress() {
		return derechapress;
	}

	public void setDerechapress(boolean derechapress) {
		this.derechapress = derechapress;
	}

	public boolean isIzquierdapress() {
		return izquierdapress;
	}

	public void setIzquierdapress(boolean izquierdapress) {
		this.izquierdapress = izquierdapress;
	}

}
