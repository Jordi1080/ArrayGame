package arraygame;

public class ScreenDrawer {
	Gameplay gp;
	SpotFiller map[][];
//	char charMap[][];
	static final int breedte = 60; //j
	static final int hoogte = 20; //i
	
	public ScreenDrawer(){
		map = new SpotFiller[breedte][hoogte];
	}
	
	// just the printing
	public void printFrame(){
		String res = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";//"+---------+\n";
		
		for (int i = 0; i < hoogte; i++){
			for (int j = 0; j < breedte; j++){
				res += map[j][i].getToken();
			}
			res += "\n";
		}
		
		// info bar
		res += "+----------------------------------------------------------+\n";
		res += "Player X: " + gp.p.getX() + " Y: " + gp.p.getY() + "\n";
		res += "Gold: " + gp.score + "\n";
		res += gp.message + "\n";
//		res += map[gp.p.getX()][gp.p.getY()].getClass().getName() + "\n";
		res += "+----------------------------------------------------------+";
		System.out.println(res);
	}

	
	// leeg veld maken
	public void initChars(){
		// empties
		for (int y = 0; y < hoogte; y++){
			for (int x = 0; x < breedte; x++){
					map[x][y] = new Empty(x, y, '.');
			}
		}
		
		
	}
	
	// update map objects
	public void updateMap(Gameplay gp){
		for (int y = 0; y < hoogte; y++){
			for (int x = 0; x < breedte; x++){
//				System.out.println("Emptyspot x: " + x + ", y:" + y + ", char: " + map[x][y].getToken());
				if (gp.p.getX() != x || gp.p.getY() != y){
					setChar(x, y, new Empty(x, y, '.'));
				}
				else{
					setChar(x, y, map[x][y]);
				}
				
				if ( map[x][y] instanceof Collectible
					&& x == gp.p.getX()
					&& y == gp.p.getY() ){
					setChar(x, y, new Empty(x, y, '.'));
					gp.score += 10;
					gp.message = "Je hebt 100 Gold gevonden!";
				}
				
				
			}
		}
	}
	
	public char charAtThisSpot(int xx, int yy){
		char charry;
		if (xx == gp.p.getX() && yy == gp.p.getY() && map[xx][yy].equals(gp.p)){
			charry = '@';
		}
		else{
//			System.out.println("else charry = .");
			charry = '.';
		}
		return charry;
	}
	
	public void setItems(Gameplay gp){
		for (SpotFiller s : gp.sfList){
			setChar(s.getX(), s.getY(), s);
		}
	}
	
//	public boolean isEmptySpot(int xx, int yy){
//		return map[xx][yy].equals(new Empty(xx, yy, '.'));
//	}
	
//	public boolean noSpotFiller(){
//		return map[xx][yy].equals(new SpotFiller(xx, yy, '.'));
//	}
	
	public void setChar(int x, int y, SpotFiller sf){
		map[x][y] = sf;
	}
	
	public char drawChar(int x, int y, char c){
		return map[x][y].getToken();
	}
	

	
	
}
