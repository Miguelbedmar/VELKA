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
	
	/* EL metodo asignarTiles
	 * Este metodo se encarga de asignar las colisiones que en función del número será una colison o no tendrá colisión*/
	public void asignarTiles() throws IOException  {
		BufferedImage plataforma= ImageIO.read(getClass().getResource("/recursos/BUFERREDDEIMAGENES.png"));
	
		tile[0]=new Tile(plataforma, false) 
				;
	}
}
