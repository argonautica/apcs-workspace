import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
int length;
int x = 0;
int temp;
	public ZBug(int length) {
		this.length = length;
		// TODO Auto-generated constructor stub
		
		
		temp = 1;
	}


public void act() {
	if ( x == 0) {
	turn();
	turn();
for ( int i = 0; i < length; i++) {
	move ();
	
	
	
}
turn();
turn();
turn();

for ( int i = 0; i <= length; i++) {
	move ();
	
	
	
}

turn();
turn();
turn();
turn();
turn();
for ( int i = 0; i < length; i++) {
	move ();
	
	
	
}
x++;
	
	}

}
}
