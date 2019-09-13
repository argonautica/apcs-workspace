import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class SpiralBug extends Bug {
int spirals;
int x = 0;
int temp;
	public SpiralBug(int spirals) {
		this.spirals = spirals;
		// TODO Auto-generated constructor stub
		
		
		temp = 1;
	}


public void act() {
if ( x < spirals);
for ( int z = 0; z < x; z++) {
	move();
	
}

x++;
turn();
turn();
	
}
	



}
