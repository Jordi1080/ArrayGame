package arraygame;

public class Empty extends SpotFiller{
	private int x;
	private int y;
	private char token;
	
	public Empty(int x, int y, char token){
		super(x, y , token);
//		this.x = x;
//		this.y = y;
//		this.token = token;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
