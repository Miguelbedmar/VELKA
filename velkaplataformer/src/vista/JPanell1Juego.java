package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modelo.Map;
import modelo.Tile;

public class JPanell1Juego extends JPanel {
	// Atributos
	private Map mapaModelo;
	private Tile[] tile;

	// Constructor
	public JPanell1Juego() throws IOException {
		mapaModelo = new Map();
		tile = new Tile[6];
		asignarTiles();
	}

	// Metodos

	/*
	 * EL metodo asignarTiles Este metodo se encarga de asignar las colisiones que
	 * en función del número será una colison o no tendrá colisión Empezamos con
	 * declarar un objeto
	 * 
	 */
	public void asignarTiles() throws IOException {
		BufferedImage plataforma = ImageIO.read(getClass().getResource("/recursos/BUFERREDDEIMAGENES.png"));

		tile[0] = new Tile(plataforma, false);
		tile[1] = new Tile(plataforma, true);
		tile[2] = new Tile(plataforma, true);
		tile[3] = new Tile(plataforma, true);
		tile[4] = new Tile(plataforma, true);
		tile[5] = new Tile(plataforma, true);
	}

	@Override
	public void paint(Graphics g) {
	}

}
