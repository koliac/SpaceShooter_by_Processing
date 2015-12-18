package SpaceShooter;
import processing.core.*;
import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;

public class Scene extends PApplet{
	Spacecraft a;
	Bullet b;
	ArrayList<Bullet> bList;
	ArrayList<Enemy> eList;
	int timer=1;
	int count=0;
	PFont f;
	long startTime,endTime,totalTime;

	public void setup(){//setup the screen and initialize variables
		size(600,900);
		a=new Spacecraft(this);
		bList = new ArrayList<Bullet>();//A list of Bullet objects
		eList=new ArrayList<Enemy>();//A list of Enemy objects
		frameRate(60);
		smooth();
		noCursor();
		f=createFont("Arial",16,true);//creating a font for the game text	
		
	}
	public void draw() {
		background(0);//Getting ready screen
		fill(255);
		textFont(f,32);
		
		text("Press SPACE key to play",300,300);
		textAlign(CENTER);
		if(key==' '){//pressing SPACE key allows user to start the game
			while(timer>0){
				startTime=System.currentTimeMillis();//start the timer
				timer--;
			}
			background(0);
			textFont(f,16);
			fill(255);
			text("Score: "+count*10,50,height-20);
			a.move();
			if(key==' '){//press SPACE key allow user to fire a bullet
				for(int i=0;i<bList.size();i++){
			
					bList.get(i).fire();
					if(bList.get(i).by<10){//destroy bullets that are out of boundary
						bList.get(i).fired=false;
						bList.remove(i);                 
					}
				}
			}
			if( frameCount%15==0){
			eList.add(new Enemy(this));//spawn a enemy
	
		    }
			for(int j=0;j<eList.size();j++){//enemy moves toward the player
				eList.get(j).crawl();
			}
			
			try{/**because the processing speed sometime it will create an exception of 
			      *of IndexOutOfBoundsException. This block tends to catch this excepton */
				for(int j=eList.size()-1;j>=0;j--){
					for(int i=bList.size()-1;i>=0;i--){
						if(dist(bList.get(i).bx+2.5f,bList.get(i).by,eList.get(j).enemyX,eList.get(j).enemyY)<=15){
							//check collision between the bullet and the enemy
							bList.remove(i);
							eList.remove(j);
							count++;//recording the scores
						}
					}
					
			}
			}catch(IndexOutOfBoundsException error){
				//System.out.println(error.getMessage());
			}
			
			for(int k=eList.size()-1;k>=0;k--){//this block check the collision between enemy and the ship
				if(dist(a.x,a.y,eList.get(k).enemyX,eList.get(k).enemyY)<=10){
					endTime=System.currentTimeMillis();
					totalTime=(endTime-startTime)/1000L;
					background(0);
					fill(255);//End of game scene
					text("You are dead! You survived: "+totalTime+" seconds",width/2-10,height/2);
					noLoop();	
				}
			}
		}	
	}	 
	public void keyPressed(){//add a new Bullet object whenever a key is pressed
		
			b=new Bullet(this,a);
			bList.add(b);	
	}
}

