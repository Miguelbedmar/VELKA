package modelo;

public class Map {
	// Declaración de atributos

	private int[][][] room; // matriz tridimensional
	private int titleSi =112;

	/*
	 * Está clase se encarga de modelar el mapa por medio de matrices de 32*32 que
	 * contendran cada parte del mapa el mapa tendrá colisiones y elementos en donde
	 * el jugador pordrá escalar y mantenerse sobre la misma. La matriz tendra
	 * número del 0 al 5 teniendo cada un significado 
	 * 0: sin colisiones 
	 * 1: colisióny
	 * plataforma 
	 * 2: colisión y enemigo que restara vida al jugador 
	 * 3:  sin Colisión y
	 * coleccionable que el jugador pordrá recolectar.
	 *  4. Siguiente o anterior
	 * matriz. 
	 * 5. Fin del juego. 
	 * 6. Pilar sin colision 
	 * 7.Plataforma 2*2 Mediana con colision
	 * 8.Plataforma única con colision
	 * 9.Bloque con colision
	 * 10.Torre con colision
	 * 11.pincho unico con colision
	 */

	// Matrices.
	public Map() {

		room = new int[][][] {

				// Primera matriz principio de nivel
					
				{ 		{0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{ 0, 8, 11, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 10, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 6, 0, 6, 0, 0, 10, 0, 0, 10, 10, 0, 1, 1, 1, 4 },
						{ 0, 6, 0, 6, 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0 },
						{ 2, 9, 9, 9, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 9, 9, 9, 9, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },

				},
				// Segunda matriz.
				 		{ 
						{ 0, 0, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 1, 1, 1, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 9, 9, 0, 0, 0, 0, 1, 0, 0, 7, 7, 0, 0, 0, 3, 0, 0 },
						{ 9 ,9, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 9, 11, 8, 0,0},
						{ 9, 9, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 9, 6, 2, 2,2 }, 
						},

				// Tercera Matriz
				{

						{ 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 2, 0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 2, 0, 0, 9, 9, 0, 0, 10, 10, 0, 0, 3, 0, 0 }, 
						{ 2, 0, 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0 },
						{ 2, 0, 0, 0, 0, 0, 0, 10, 10, 7, 8, 7, 8, 0 }, 
						{ 2, 2, 2, 2, 2, 0,2, 2, 2, 2, 1, 1, 1, 1, 2 }, },

				{ // Cuarta matriz
						{ 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 3, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 8, 7, 7, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 1, 1, 1, 0, 0, 0, 4, 7, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, },

				{
						// Quinta matriz
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 4, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 9, 9, 7, 7, 0, 0, 8, 4 },
						{ 0, 0, 9, 9, 0, 0, 0, 9, 9, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 9, 9, 0, 0, 0, 9, 9, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 2, 2, 9, 9, 2, 2, 7, 7, 2, 2, 2, 2, 2, 2, 2 }

				},

				{ // Sexta matriz

						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 3, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 8, 4 },
						{ 8, 0, 8, 0, 0, 10, 0, 0, 10, 7, 7, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 10, 0, 0, 10, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 10, 0, 0, 10, 0, 0, 0, 0, 0, 0 },
						{ 2, 2, 2, 2, 2, 10, 7, 7, 10, 2, 2, 2, 2, 2, 2 } },

				{ // Séptima matriz

						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 10, 10, 10, 0, 0, 9, 9,9, 0, 0, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0,0},
						{ 1, 1, 0, 0, 10, 0, 10, 0, 0, 9, 0, 9, 0, 0, 9, 3, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 10, 0, 10, 0, 0, 9, 0, 9, 0, 0, 9, 9, 9, 0, 0, 0, 0, 0, 0, 1, 1, 1, 5 },
						{ 0, 0, 0, 2, 10, 0, 10, 11, 2,9, 0, 9, 2, 2, 9, 9, 9, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }

				},

		};

	}

	private int roomActual = 0;

	public int[][] zonActual() {
		return room[roomActual];

	}

	// GETTERS Y SETTERS.

	public int getTitleSi() {
		return titleSi;
	}

	public void setTitleSi(int titleSi) {
		this.titleSi = titleSi;
	}

	public int[][][] getRoom() {
		return room;
	}

	public void setRoom(int[][][] room) {
		this.room = room;
	}

	public int getRoomActual() {
		return roomActual;
	}

	public void setRoomActual(int roomActual) {
		this.roomActual = roomActual;
	}
}
