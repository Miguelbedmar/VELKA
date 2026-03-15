package modelo;

public class Coleccionable {

	private int x;
	private int y;
	private boolean adquirido;

	public Coleccionable(int x, int y) {
		this.x = x;
		this.y = y;
		this.adquirido = false;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isAdquirido() {
		return adquirido;
	}

	public void setAdquirido(boolean adquirido) {
		this.adquirido = adquirido;
	}

}
