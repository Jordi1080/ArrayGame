package arraygame;
import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

	Scanner sc = new Scanner(System.in);
	ScreenDrawer sd;
	Player p = new Player(6, 6, '@');
	int score = 0;
	String message = "";
	ArrayList<SpotFiller> sfList = new ArrayList<>();
	
	
	public Gameplay(){
		sd = new ScreenDrawer();
		sd.gp = this;
		
		sd.initChars();
		initObstacles();
		createPlayer(p);
		sfList.add(p);
		setItems();
		
		// place player at start position
		//sd.setChar(p.getStartX(), p.getStartY(), '@');
		sd.printFrame();
		
		gameLoop();
	}
	
	public void gameLoop(){
		while(true){
			getMovementInput(p); //next_x wordt geupdate
//			sd.setChar(p.getX(), p.getY(), '@'); //
//			ScreenDrawer.erasePrevious(); oud

			sd.updateMap(this);
			setItems();
			
			sd.printFrame();
			message = "";
		}
	}
	
	public void getMovementInput(Player p){
		String input = sc.nextLine();
		switch (input){
			case "d":
				// if geen muur rechts van je
				if (!(sd.map[p.getX()+1][p.getY()] instanceof Muur)){
					p.move(1, 0);
				}
				else{
					message = "Je kan niet door een muur bewegen";
				}
				
			break;
			
			case "a":
				p.move(-1, 0);
			break;
			
			case "w":
				p.move(0, -1);
			break;
			
			case "s":
				p.move(0, 1);
			break;
		}
	}
	
	public void createPlayer(Player p){
//		System.out.println(p);
//		sd.setChar(, p.getStartY(), p.getToken());
	}
	
	public void createEnemy(SpotFiller sf){
//		sd.setChar(sf.getX(), sf.getY(), sf.getToken());
	}
	
	public void createItem(SpotFiller sf){
//		sd.setChar(sf.getX(), sf.getY(), sf.getToken());
	}
	
	public boolean colliding(SpotFiller a, SpotFiller b){
		if ( a.getX() == b.getX()
			&& a.getY() == b.getY() ){
		
			return true;
		}
		return false;
	}
	
//	public void pickUpCollectible(){
//		if (){
//			
//		}
//	}

	public void setItems(){
		sd.setItems(this);
	}
	
	public void initObstacles(){
		Enemy1 henk = new Enemy1(14, 13, 'E');
		Collectible treasure = new Collectible(24, 10, 'G');
		sfList.add(henk);
		sfList.add(treasure);
		
		for (int i = 8; i < 15; i++){
			Muur muur = new Muur(20, i, '#');
			sfList.add(muur);
		}
	}
}
