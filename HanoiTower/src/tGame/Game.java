/*Unfortunately I have no time to add input for number of discs. So it's hardcoded.
 * You can change it by modifying this.totalCount variable.
 * Please use 2-11 because of graphical interpretation limitations.
 * 
 * I also have problem with project settings while transfering
 * Mb you it's necessary to specify native library path for lwjgl library if nothing works.
 * 
*/
package tGame;

import org.newdawn.slick.*;

import towers.Tower;

public class Game extends BasicGame{

	public Game(String title) {
		super(title);
	}
	
	//variables
	int totalCount;
	Tower tFrom;
	Tower tBuf;
	Tower tTo;
	Disc[] dss; //massive for disc data
	int maxR;
	
	//events data
	
	WHS db;
	int maxInd;
	int maxIndTo;
	
	//game states
	int step = 0;
	int state = 0;
	int dataTo;
	int dataFrom;
	int dataCount;
	int activeCount = 0;
	int fromCount;
	int toCount;
	boolean isActive;
	
	//test pupr
	//int avtiveInd;
	
	//Disc colors:
	Color colArr[] = {Color.blue,
			Color.cyan,
			Color.yellow,
			Color.darkGray,
			Color.green,
			Color.lightGray,
			Color.magenta,
			Color.orange,
			Color.pink,
			Color.red,
			Color.white
			};
	
	//boolean complete;
	
	static int screenX = 800;
	static final int screenY = 800;
	int xScr = 800;
	int yScr = 800;
	
	//render----------------------------------------------------------------------------
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = this.totalCount-1; i>=0;i--){
		g.setColor(dss[i].getCol());
		g.fillRect((dss[i].getX()+maxR/2-dss[i].getW()/2)-maxR/2, dss[i].getY(), dss[i].getW(), dss[i].getH());
		}
		
		g.setColor(Color.white);
		
		/*for (int i = this.totalCount-1 ; i>=0; i--){
			int j = totalCount-1 - i;
			g.drawString("Number " + i +" Tow "+ dss[i].getTow() +" Ind " + dss[i].getInd(), 500, 50+j*40);
			g.drawString("Ind " + dss[i].getInd() +" is active: "+ dss[i].getActive(), 500, 70 +j*40);
		}*/
		g.drawString("From Count: "+this.fromCount, 600, 20);
		g.drawString("To Count: "+this.toCount, 600, 40);
		g.drawString("Active: "+this.activeCount, 600, 60);
	}
	//Init-------------------------------------------------------------------------------
	@Override
	public void init(GameContainer gc) throws SlickException {
		totalCount = 6;//////////////Total count

		maxR = totalCount*16;

		dss = new Disc[this.totalCount];
		for (int i = this.totalCount-1; i >= 0 ;i--){
			dss[i]= new Disc(screenX/4, screenY-this.totalCount*20 -i*30
					, this.colArr[i], this.totalCount-i, i);
		}
		
		//whs test
		db = new WHS();
		db.initDB();
		
		//update towers and generate events
		Tower tow = new Tower();
		tow.start(this.totalCount, db);
		
	}
	//--------------------------------------------------------------------------------------------
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		//go to next step |||| state 0
		if (state == 0){
			
			state = 1;
			this.activeCount = 0;
			
			//read stuff from event:
			this.dataFrom = db.getById(step).getFrom();
			this.dataTo = db.getById(step).getTo();
			this.dataCount = db.getById(step).getCount();
			this.activeCount = 0; //data to test
			this.fromCount= 0;
			this.toCount = 0;
			
			//count indexes in from and to towers
			
			for (int i = 0; i < this.totalCount; i++){
				if (dss[i].getTow() == this.dataFrom){
					this.fromCount +=1;
				}
			}
			
			for (int i = 0; i < this.totalCount; i++){
				if (dss[i].getTow() == this.dataTo){
					this.toCount +=1;
				}
			}
			
			//set  active and count:
			for (int i = 0; i < this.totalCount; i++){
				if (dss[i].getTow()==this.dataFrom && dss[i].getInd()>this.fromCount-this.dataCount-1){
					dss[i].setActive();
					this.activeCount+=1;
				}
			}
			
		}
			
				
		if (state == 1){
			//
	
			for (int i = 0; i < this.totalCount; i++){
				if (dss[i].getActive() == true){
					dss[i].moveTower((this.dataTo*this.xScr/4)
							, 200 -(dss[i].getInd()-(this.fromCount-this.toCount-this.activeCount))*30
							, screenY-this.totalCount*20-(dss[i].getInd()-(this.fromCount-this.toCount-this.activeCount))*30);
							// basicly screenY-this.totalCount*20 -i*20
				}
			}

			//checking if anymore active:
			isActive = false;
			for (int i = 0; i < this.totalCount; i++){
					if (dss[i].getActive()==true){
						isActive = true;
					}
				}
			
			if (isActive==false) {
				this.state = 2;
				//setting new indexes
				for (int j = 0; j < this.totalCount; j++){
					if (dss[j].getIsChanged() == true){
						int tempInd = dss[j].getInd()-(this.fromCount-this.activeCount)+this.toCount;
						dss[j].setInd(tempInd, this.dataTo);
					}
				}
				this.activeCount = 0;
			}
			}
		
		//checking if this is the end, beautiful friend the end
		
		if (state == 2){
			//procced to next event
			if (this.step == db.getSize()-1){
				state = 4;
				} else{
					state = 0;
					this.step +=1;
			}
		}
		
		}
	
	//App start adn screen attributes:
	
	public static void main (String args[]) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game("Hanoi Tower"));
		app.setDisplayMode(screenX, screenY, false);
		app.setVSync(true);                    
		app.setMaximumLogicUpdateInterval(1); 
		app.setMinimumLogicUpdateInterval(0);
		app.start();
	}
	
}
