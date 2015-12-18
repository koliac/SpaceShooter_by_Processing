package SpaceShooter;
import processing.core.*;
import java.util.ArrayList;
public class Enemy {
	PVector dir;//data filed includes: location,speed and movement direction of the enemy object 
	float enemyX, enemyY, speed;
	PApplet page;
	Enemy(){//default constructor 
		
	}
	Enemy(PApplet page){//spawn an enemy randomly on the X-Axis outside of the window 
		this.page=page;
		enemyY=0;
		enemyX=page.random(0,600);
		speed=12;
		
	}
	
	public void crawl(){
		dir=new PVector(Spacecraft.x-enemyX,Spacecraft.y-enemyY);//the enemy moves toward the player
		dir.normalize();
		enemyX=enemyX+(dir.x*speed);
		enemyY=enemyY+(dir.y*speed);
		page.fill(page.random(0,255),page.random(0,255),page.random(0,255));
		page.noStroke();
		page.beginShape();//creating the shape of the enemy: an arrow
		page.vertex(enemyX,enemyY);
		page.vertex(enemyX+8,enemyY-6);
		page.vertex((float) (enemyX+2.5),enemyY-6);
		page.vertex((float) (enemyX+2.5),enemyY-15);
		page.vertex((float) (enemyX-2.5),enemyY-15);
		page.vertex((float) (enemyX-2.5),enemyY-6);
		page.vertex(enemyX-8,enemyY-6);
		page.vertex(enemyX,enemyY);
		page.endShape();		
	}	
}
