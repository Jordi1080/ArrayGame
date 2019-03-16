package arraygame;
	
public class Enemy1 extends SpotFiller{
//	private char token;
//	private int x;
//	private int y;
	
	private int startX;
	private int startY;
	
	public Enemy1(int x, int y, char token){
		super(x, y, token);
		this.startX = x;
		this.startY = y;
	}
}
