import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
public class ChallengeBug extends Bug {

	
	public boolean wantsToMove() {
		
		   Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return (neighbor == null) || !(neighbor instanceof Flower);
	}
	
	
	public boolean hasToMove() {
	 for ( int i = 0; i < 8; i ++) {
		 
		if (wantsToMove()) {
			return false;
			
		}
		super.turn();
		
	 }  
		 return true;
				 
	 
	 
	}
	
	public void act() {
		
		
		if ( (wantsToMove() && canMove())|| ((hasToMove() && canMove()))) {
			
			super.move();
		}
	}
	
}
