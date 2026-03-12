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
	private Map  mapaModelo;
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
	 * declarar un objeto de tipo ImageIO que se guardara en un objeto de tipo 
	 * BufferredImagen posteriormente se le asigna   imagen y decir si tendra colision o no
	 * la colision asignada unicamente se indica con false o true
	 */
	public void asignarTiles() throws IOException {
		
		tile[0] = new Tile(null, false);
		BufferedImage plataforma = ImageIO.read(getClass().getResource("/recursos/recursosSPRITESMAPA/PLATAFORMA.png"));
		tile[1] = new Tile(plataforma, true);
		BufferedImage pincho = ImageIO.read(getClass().getResource("/recursos/recursosSPRITESMAPA/PINCHOS.png"));
		tile[2] = new Tile(pincho, true);
		BufferedImage Coleccionable = ImageIO.read(getClass().getResource("/recursos/recursosSPRITESMAPA/ESTRELLAS.png"));
		tile[3] = new Tile(Coleccionable, true);
		BufferedImage Colecciona = ImageIO.read(getClass().getResource("/recursos/recursosSPRITESMAPA/ESTRELLAS.png"));
		tile[4] = new Tile(plataforma, true);
		BufferedImage PORTAL = ImageIO.read(getClass().getResource("/recursos/recursosSPRITESMAPA/PORTAL.png"));
		tile[5] = new Tile(PORTAL, true);
	}

	@Override
	public void paint(Graphics g) {
		
		for(int i =0;i<mapaModelo.getRoomActual();i++) {
			
		}
		
	}

}
