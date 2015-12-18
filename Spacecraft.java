package SpaceShooter;
import processing.core.*;
public class Spacecraft {
	static float x;//data field includes: the location of the spaceship
	static float y;
	PApplet page;
	Spacecraft(PApplet page){//default constructor
		this.page=page;
	}
	public void move(){//code of the movement of the ship
		
		x=page.mouseX;//the ship always follows the mouse cursor
		y=page.mouseY;
		//these codes make sure the ship won't go out of the boundary
		if(y<=150)
			y=150;
		else if(y+100>=page.height)
			y=page.height-100;
		else if(x-50<=0)
			x=50;
		else if(x+50>=page.width)
			x=page.width-50;	
		
		page.fill(0,0,200,50);
		page.stroke(255);
		page.beginShape();//create the shape of the enemy
		page.vertex(x,y);
		page.vertex(x+50,y+100);
		page.vertex(x,y+75);
		page.vertex(x-50,y+100);
		page.vertex(x,y);
		page.vertex(x,y+75);
		page.endShape();
			
	}
}
