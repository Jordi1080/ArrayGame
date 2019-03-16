package arraygame;

public class Player extends SpotFiller{
//	private int x;
//	private int y;
	
	private int projectedX;
	private int projectedY;
	
	private int startX;
	private int startY;
	static public int counter; //test
	
	public Player(int x, int y, char token){
		super(x, y, token);
		startX = x;
		startY = y;
		counter++;
	}
	
//	private char token;
	
//	public Player(int x, int y, char token){
//		this.x = x;
//		this.y = y;
//		this.token = token;
//	}
	

	
//	public int getX(){
//		return x;
//	}
//	public int getY(){
//		return y;
//	}
	public int getStartX(){
		return startX;
	}
	public int getStartY(){
		return startY;
	}
}
