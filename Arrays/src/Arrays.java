
public class Arrays {

	public static void main(String[] args) {
		
		int [][] array = new int [10][10];
		for(int i=0;i<array.length;i++)
		{
			array[i][0]=i;
			for(int j=0;j<array[i].length;j++)
			{
				array[i][j]=j;
				System.out.print(array[i][j]);
				
			}
		System.out.print("\n");

		}

	}

}
