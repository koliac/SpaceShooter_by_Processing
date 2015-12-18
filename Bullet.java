package SpaceShooter;
import processing.core.*;
import java.util.*;
public class Bullet {
	float bx;//data field: including location and speed of the bullet
	float by;
	float bSpeed=10;
	boolean fired = false;
	PApplet page;
	Bullet(PApplet page){//default constructor 
		this.page=page;
	}
	
	Bullet(PApplet page,Spacecraft ship){//instantiate a bullet at the tip of the ship
		 bx = ship.x-(5/2);
		 by= ship.y-20;
		 this.page=page;	
	}
	public void fire(){//this block contains codes for the bullet movement
		by=by-bSpeed;
		page.fill(255,0,0);
		page.stroke(255);
		page.rect(bx, by, 5, 20);
		
		fired = true;				
		
	}
}
