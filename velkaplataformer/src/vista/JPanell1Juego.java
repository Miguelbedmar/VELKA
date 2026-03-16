package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controlador.TecladoControlador;
import modelo.Coleccionable;
import modelo.Jugador;
import modelo.Map;
import modelo.Tile;

public class JPanell1Juego extends JPanel {

	private final int altura = 64;
	private final int ancho = 48;
	// Atributos
	private Map mapaModelo;
	private Tile[] tile;
	private Jugador jugador;
	private TecladoControlador key;
	private ArrayList<Coleccionable> coleccionable;

	// Constructor
	public JPanell1Juego() throws IOException {
		mapaModelo = new Map();
		tile = new Tile[12];
		asignarTiles();

		jugador = new Jugador(this);
		key = new TecladoControlador(jugador);
		jugador.setTeclado(key);
		addKeyListener(key);
		setFocusable(true);
		requestFocus();
		Thread hilo = new Thread(jugador);
		hilo.start();
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
		// ASIGNAR TILE [0] AIRE
		tile[0] = new Tile(null, false, false);
		// ASIGNAR TILE[1] PLATAFORMA
		BufferedImage plataforma = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PLATAFORMA.png"));
		tile[1] = new Tile(plataforma, true, false);
		// ASIGNAR TILE[2] PINCHOS
		BufferedImage pincho = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PINCHOS.png"));
		tile[2] = new Tile(pincho, true, true);
		// ASIGNAR TILE [3] COLECCIONABLE
		BufferedImage coleccionable = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/ESTRELLAS.png"));
		tile[3] = new Tile(coleccionable, false, false);
		// ASIGNA TILE[4] PORTAL SIGUIENTE MATRIZ
		BufferedImage portal1 = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PORTAL.png"));
		tile[4] = new Tile(portal1, false, false);
		// ASIGNA TILE[5] PORTAL FIN DEL JUEGO
		BufferedImage portal = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PORTAL.png"));
		tile[5] = new Tile(portal, true, false);
		// ASIGNA TILE[6] PILAR SIN COLISION
		BufferedImage pilar = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PILAR.png"));
		tile[6] = new Tile(pilar, false, false);
		// ASIGNA TILE [7] PLATAFORMA MEDIANA
		BufferedImage plataformamediana = ImageIO
				.read(getClass().getResource("/recursos/SPRITEMAPA/PLATAFORMAMEDIANA.png"));
		tile[7] = new Tile(plataformamediana, true, false);
		// ASIGNA TILE [8] PLATAFORMA PEQUEÑA
		BufferedImage plataformapequena = ImageIO
				.read(getClass().getResource("/recursos/SPRITEMAPA/PLATAFORMAPEQUENA.png"));
		tile[8] = new Tile(plataformapequena, true, false);
		// ASIGNA TILE [9] BLOQUE
		BufferedImage bloque = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/BLOQUE.png"));
		tile[9] = new Tile(bloque, true, false);
		// ASIGNA TILE [10] TORRE
		BufferedImage torre = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/TORRE.png"));
		tile[10] = new Tile(torre, true, false);
		// ASIGNA TILE [11] PINCHO ÚNICO
		BufferedImage pinchounico = ImageIO.read(getClass().getResource("/recursos/SPRITEMAPA/PINCHO.png"));
		tile[11] = new Tile(pinchounico, true, true);
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
		} /*
			 * Si el jugador devuelve true en movimiento derecha dibujamelo hacia la derecha
			 * en el caso contrario volteame el sprite esto se consigue gracias al metodo
			 * gráfico con el ancho negativo
			 */
		if (jugador.isMovimientoDerecha()) {
			g.drawImage(jugador.getspriteActual(), jugador.getX(), jugador.getY(), 64, 64, null);
		} else {
			g.drawImage(jugador.getspriteActual(), jugador.getX(), jugador.getY(), -64, 64, null); // Ancho negativo
																									// para conseguir el
																									// efecto de sprite
																									// volteado

		}
		super.paintChildren(g);

	}

	/*
	 * Estos metodos se encargan de calcular la colision para ello primero
	 * necesitamo el tamaño de las tile las filas con y entre el is hay tile y
	 * columna con x entre las tile segundo necesitamos la zona actual para ello
	 * llamamos a mapaModelo.zonActual y lo meto dentro de una variable
	 * bidimensional por unicamente necesito la zona en la que el jugador se
	 * encuentre en ese momento, entonces para comprobar si hay colision y el
	 * jugador recibe danio tiene que cumplir la condicion de si la fila es menor
	 * que la longitud de la habitacion y si la columna es menor que la habitacion
	 * posteriormente instanciamos un objeto Tile y el metodo devuleve la colision y
	 * si dicha colision hace danio.
	 */
	public boolean hayColision(int x, int y) {

		int tilesi = mapaModelo.getTitleSi();
		int fila = y / tilesi;
		int col = x / tilesi;

		int[][] room = mapaModelo.zonActual();

		if (fila < room.length && col < room[fila].length) {
			Tile ti = tile[room[fila][col]];
			return ti.isColision() && !ti.isDanioJugador();
		}

		return false;
	}

	public void cargarColeccionable() {
		int[][] room = mapaModelo.zonActual();
		for (int fila = 0; fila < room.length; fila++) {
			for (int col = 0; col < room[fila].length; col++) {
				if (room[fila][col] == 3) {
					int x = col * mapaModelo.getTitleSi();
					int y = fila * mapaModelo.getTitleSi();
					coleccionable.add(new Coleccionable(x, y));

				}
			}
		}
	}

	public boolean danio(int x, int y) {
		int fila = y / mapaModelo.getTitleSi();

		int col = x / mapaModelo.getTitleSi();
		int[][] room = mapaModelo.zonActual();

		if (fila < room.length && col < room[fila].length) {
			return tile[room[fila][col]].isDanioJugador();
		}

		return false;

	}

	public boolean tileSolido(int x, int y) {
		int fila = y / mapaModelo.getTitleSi();

		int col = x / mapaModelo.getTitleSi();
		int[][] room = mapaModelo.zonActual();

		if (fila < room.length && col < room[fila].length) {
			return tile[room[fila][col]].isColision();
		}

		return false;
	}

	public boolean colisonde(int x, int y) {

		int tilesi = mapaModelo.getTitleSi();
		int col = (x + ancho) / tilesi;
		int fisu = y / tilesi;
		int fiinfe = (y + altura - 1) / tilesi;
		int[][] room = mapaModelo.zonActual();

		if (fisu < room.length && col < room[fisu].length) {
			return tile[room[fisu][col]].isColision() || tile[room[fiinfe][col]].isColision();

		}

		return false;
	}

	public boolean colisonizq(int x, int y) {
		int tilesi = mapaModelo.getTitleSi();
		int col = x / tilesi;
		int fisu = y / tilesi;
		int fiinfe = (y + altura - 1) / tilesi;
		int[][] room = mapaModelo.zonActual();

		if (fisu < room.length && col < room[fisu].length) {
			return tile[room[fisu][col]].isColision() || tile[room[fiinfe][col]].isColision();
		}
		return false;
	}

	// METODO DE DETECTAR TILE PARA ESCALAR.
	public boolean torreCerca(int x, int y) {
		int tilesi = mapaModelo.getTitleSi();
		int col = x / tilesi;
		int fila = y / tilesi;
		int[][] room = mapaModelo.zonActual();

		if (fila < room.length && col < room[fila].length) {
			return room[fila][col] == 10;
		}
		return false;

	}

	public int getTilesi() {
		return mapaModelo.getTitleSi();
	}

	public Map getMapaModelo() {
		return mapaModelo;
	}

	public void setMapaModelo(Map mapaModelo) {
		this.mapaModelo = mapaModelo;
	}

	public Tile[] getTile() {
		return tile;
	}

	public void setTile(Tile[] tile) {
		this.tile = tile;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public TecladoControlador getTeclado() {
		return key;
	}

	public void setTeclado(TecladoControlador teclado) {
		this.key = teclado;
	}

	public int getAltura() {
		return altura;
	}

	public int getAncho() {
		return ancho;
	}

	public ArrayList<Coleccionable> getColeccionable() {
		return coleccionable;
	}

	public void setColeccionable(ArrayList<Coleccionable> coleccionable) {
		this.coleccionable = coleccionable;
	}

	public TecladoControlador getKey() {
		return key;
	}

	public void setKey(TecladoControlador key) {
		this.key = key;
	}

}
