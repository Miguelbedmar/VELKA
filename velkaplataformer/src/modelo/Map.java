package modelo;

public class Map {

	private int[][][] mapa;
	private int[][][] room;
	private int titleSi = 32;

	/*
	 * Está clase se encarga de modelar el mapa por medio de matrices de 32*32 que
	 * contendran cada parte del mapa el mapa tendrá colisiones y elementos en donde
	 * el jugador pordrá escalar y mantenerse sobre la misma.
	 * La matriz tendra número del 0 al 3 teniendo cada un significado
	 * 0: sin colisiones
	 * 1: colisión y plataforma
	 * 2: colisión y enemigo que restara vida al jugador
	 * 3: Colisión y coleccionable que el jugador pordrá recolectar.
	 */

	// Matrices.
	public Map() {
		
	room=new int [][][]{
			
	//Matriz 1
		{
	{3,1,2,1,0,0,0,0,0,0,0,0,0,0,0},	
	{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
	{0,0,0,0,0,0,1,0,0,1,1,0,0,0,0},
	{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0},	
	{0,1,1,1,0,0,1,1,0,0,0,0,0,0,0},	
	{2,1,1,1,2,2,2,2,2,2,2,2,2,2,2},
	
		},
	// Matriz 2.
	{	
		{0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	},	

			};
	

		

	}
	private int roomActual=0;

	public int[][][] getMapa() {
		return mapa;
	}

	public void setMapa(int[][][] mapa) {
		this.mapa = mapa;
	}

	public int getTitleSi() {
		return titleSi;
	}

	public void setTitleSi(int titleSi) {
		this.titleSi = titleSi;
	}
}
