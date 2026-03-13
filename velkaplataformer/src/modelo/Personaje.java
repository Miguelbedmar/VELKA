package modelo;

public abstract class Personaje {
	protected int x;
	protected int y;
	
	
	
	public abstract	 void run();
 
 
	public abstract  void  gravedad();


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
	
	
		
	
 }
 
