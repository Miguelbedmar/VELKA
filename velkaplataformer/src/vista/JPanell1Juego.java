package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		tile = new Tile[12];
		asignarTiles();

	}

	// Metodos

	/*
	 * EL metodo asignarTiles Este metodo se encarga de asignar las colisiones que
	 * en función del número será una colison o no tendrá colisión Empezamos con
	 * declarar un objeto de tipo ImageIO que se guardara en un objeto de tipo
	 * BufferredImagen posteriormente se le asigna imagen y decir si tendra colision
	 * o no la colision asignada unicamente se indica con false o true hay un total
	 * de 12 tiles que van del 0 al 11, se comienza a contar desde el 0
	 */
	public void asignarTiles() throws IOException {
		tile[0] = new Tile(null, false);
		BufferedImage plataforma = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PLATAFORMA.png"));
		tile[1] = new Tile(plataforma, true);
		BufferedImage pincho = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PINCHOS.png"));
		tile[2] = new Tile(pincho, true);
		BufferedImage coleccionable = ImageIO
				.read(getClass().getResource("/recursos/SPRITEMAPA/ESTRELLAS.png"));

		tile[3] = new Tile(coleccionable, false);
		BufferedImage portal1 = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PORTAL.png"));

		tile[4] = new Tile(portal1, false);
		BufferedImage portal = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPAPORTAL.png"));
		tile[5] = new Tile(portal, true);
		BufferedImage pilar = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPAPILAR.png"));
		tile[6] = new Tile(pilar, false);
		BufferedImage plataformamediana = ImageIO
				.read(getClass().getResource("/recursos/SPRITEMAPA/PLATAFORMAMEDIANA.png"));
		tile[7] = new Tile(plataformamediana, true);
		BufferedImage plataformapequeña = ImageIO
				.read(getClass().getResource("/recursos/SPRITEMAPA/PLATAFORMAPEQUENA.png"));
		tile[8] = new Tile(plataformapequeña, true);
		BufferedImage bloque = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/BLOQUE.png"));
		tile[9] = new Tile(bloque, true);
		BufferedImage torre = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/TORRE.png"));
		tile[10] = new Tile(torre, true);
		BufferedImage pinchounico = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PINCHO.png"));
		tile[11] = new Tile(pinchounico, true);
	}

	@Override
	public void paint(Graphics g) {
		Dimension dimension = this.getSize();
		ImageIcon fondo = new ImageIcon(getClass().getResource("/recursos/SPRITEMAPA/FONDOJUEGO.png"));
		g.drawImage(fondo.getImage(), 0, 0, dimension.width, dimension.height, null);

		int[][] zona = mapaModelo.zonActual();

		for (int fila = 0; fila < zona.length; fila++) {
			for (int col = 0; col < zona[fila].length; col++) {
				int num = zona[fila][col];
				if (num == 0) {
					continue; // Saltamos la iterracion en el caso de que numero 0
				}
				g.drawImage(tile[num].getImagen(), col * mapaModelo.getTitleSi(), fila * mapaModelo.getTitleSi(),
						mapaModelo.getTitleSi(), mapaModelo.getTitleSi(), null);

			}
		}
		super.paintChildren(g);

	}

}
