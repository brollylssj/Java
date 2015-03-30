
public class Skoczek extends CheesPiece {
	
	private String pSkoczek;
	boolean moveSkoczek;
	
	public Skoczek()
	{
		pSkoczek="S";
		moveSkoczek=false;
		
	}
	
	public void moveSkoczek()
	{
		if(isSelected == true)
		{
			moveSkoczek=true;
			
		}
		
	}

}
