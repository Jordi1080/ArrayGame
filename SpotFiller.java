package arraygame;

public class SpotFiller {
	private int x;
	private int y;
	private char token;
	
	public SpotFiller(int x, int y, char token){
		this.x = x;
		this.y = y;
		this.token = token;
	}
	
	public void move(int xSteps, int ySteps){
		x += xSteps;
		y += ySteps;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public char getToken(){
		return token;
	}
}
