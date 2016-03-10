package graphic;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import main.Circle;
import main.Point;
import main.Rectangle;

public class Game extends BasicGame{
	
	public Game(String title) {
		super(title);
	}
	
	//vars
	Rectangle rect;
	Circle circle;
	Input input;
	Point point;
	boolean pointIsCreated = false;
	boolean rectIsCreated = false;
	
	public static final int scrX = 800;
	public static final int scrY = 600;
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {	
		
		g.drawString("Press numpad - and + keys to resize. Arrows to move", 20, Game.scrY-50);
		g.drawString("Use mouse to set point. (Left click)", 20, Game.scrY-30);
		g.drawString("Press space to create reactanlge", 20, Game.scrY-70);
		
		if (this.rectIsCreated == true){
			g.drawRect(rect.getX(), rect.getY(), rect.getW(), rect.getH());
		}
		
		
		g.drawOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
		
		String tempRad = String.format("%,6.2f", this.circle.perimetr());
		String tempSq = String.format("%,6.2f", this.circle.square());
		//String tempPi = String.format("%,6.2f", this.circle.perimetr()/this.circle.getRadius());
		g.drawString("Circle periment is " + tempRad + " and square is " + tempSq +".", 30, 30);
		
		if (this.pointIsCreated == true){
			g.drawOval(point.getX(), point.getY(), 1, 1);
			g.drawString("Point is inside Circle: " + circle.isInside(point.getX(), point.getY()), 30, 50);
			if (this.rectIsCreated == true){
				g.drawString("Point is inside Rectangle: " + rect.isInside(point.getX(), point.getY()), 30, 70);
			}
		}
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		circle = new Circle (100,150,100);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		this.input = gc.getInput();
		circle.move(this.input);
		circle.resize(this.input);
		
		//create point
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if (this.pointIsCreated == false){
				this.point = new Point(input.getMouseX(),input.getMouseY());
				this.pointIsCreated = true;
			} else {
				this.point.setPosition(input.getMouseX(), input.getMouseY());
			}
		}
		
		//create rect
		if (input.isKeyPressed(Input.KEY_SPACE)){
			if (this.rectIsCreated == false){
				this.rect = this.circle.boundingBox();
				this.rectIsCreated = true;
			} else {
				this.rectIsCreated = false;
			}
		}
		
		if (this.rectIsCreated == true){
			rect.update(circle);
		}
	}
	
	public static void main (String args[]) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game("Square"));
		app.setDisplayMode(Game.scrX, Game.scrY, false);
		app.setVSync(true);                    
		/*app.setMaximumLogicUpdateInterval(1); 
		app.setMinimumLogicUpdateInterval(0);*/
		app.setTargetFrameRate(60);
		app.start();
	}

}