package modelo;

public class Map {

	private int[][] mapa;
	private int titleSi = 32;

	/*
	 * Está clase se encarga de modelar el mapa por medio de matrices de 32*32 que
	 * contendran cada parte del mapa el mapa tendrá colisiones y elementos en donde
	 * el jugador pordrá escalar y mantenerse sobre la misma.
	 */

	// Matrices.
	public Map() {
		mapa= new int [][]{
	
			
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},	
	{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
	{2,0,0,0,0,1,0,1,1,0,0,0,0,0,1},
	{0,0,1,0,0,0,0,0,0,2,2,2,1,0,0},	
	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},	
	{1,1,1,1,1,0,0,0,0,0,0,1,0,1,0},

			
		};	
	
	
}

	public int[][] getMapa() {
		return mapa;
	}

	public void setMapa(int[][] mapa) {
		this.mapa = mapa;
	}

	public int getTitleSi() {
		return titleSi;
	}

	public void setTitleSi(int titleSi) {
		this.titleSi = titleSi;
	}
}
