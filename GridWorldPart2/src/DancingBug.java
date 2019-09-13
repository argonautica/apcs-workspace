import info.gridworld.actor.Bug;

public class DancingBug extends Bug		  {
	private int a = 0;
	private int[] turns;
	
	public DancingBug(int[] turns){
		this.turns = turns;
	}
	
	
	
	/**
     * Moves to the next location of the dance, according to the <code>turns</code> array.
     */
    public void act()
    {
        if(a < turns.length && canMove())
        {
        	for(int i=0; i<turns[a]; i++)
        		turn();
            move();
            a++;
        }else{
        	a = 0;
        }
    }
	
}