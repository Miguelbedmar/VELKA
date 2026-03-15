package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TecladoControlador implements KeyListener {

	private int key;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { //  IR a la derecha con flecha derecha o con la D de wdas

		}
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { // Ir a la izquierda con la flecha izquierda o a de wdas

		} 
		if (key == KeyEvent.VK_C || key == KeyEvent.VK_SPACE) { // Tecla Salto con x o con espacio

		}if(key==KeyEvent.VK_Z) { // Tecla de escalada
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
