import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class CircleBug extends BoxBug {
	boolean c = true;

	public CircleBug(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	public void turn() {
		setDirection(getDirection() + Location.HALF_RIGHT / 2);
	}



}
