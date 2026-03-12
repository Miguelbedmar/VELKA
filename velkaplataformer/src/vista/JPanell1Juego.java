package vista;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modelo.Map;
import modelo.Tile;

public class JPanell1Juego {
	// Atributos
	private Map mapaModelo;
	private Tile[] tile;

	// Constructor
	public JPanell1Juego() {
		mapaModelo = new Map();
		tile = new Tile[5];
	}

	
	//Metodos
	
	
	public void asignarTils() throws IOException  {
		BufferedImage plataforma= ImageIO.read(getClass().getResource("/recursos/BUFERREDDEIMAGENES.png"));
		
		
	}
}
