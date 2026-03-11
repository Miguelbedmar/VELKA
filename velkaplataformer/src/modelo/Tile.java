package modelo;

import java.awt.Image;

public class Tile {

	/*
	 * Está clase dentro del paquete de los modelos se encargara de modelar la
	 * estructura del modelo mapa mediante aspectos gráficos para ello se utilizaran
	 * los distintos sprites para las platoformas pinchos y coleccionables. a su vez
	 * de que para que está clase funcione de manera correcta se ha establecido un
	 * atributo tridimensional en la clase map que contiene 7 matrices que acaparan
	 * el mapa.
	 */

	// ATRIBUTOS DEL TILE.

	private Image imagen;
	private boolean colision;
	
	//CONSTRUCTOR
	public Tile(Image imagen,boolean colision) {
		this.imagen=imagen;
		this.colision=colision;
		
	}


	
	// GETTERS Y SETTERS.
	public Image getImagen() {
		return imagen;
	}


	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}


	public boolean isColision() {
		return colision;
	}


	public void setColision(boolean colision) {
		this.colision = colision;
	}

	
	
}
