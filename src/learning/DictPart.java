package learning;
import java.util.*;

public class DictPart
{
	public DictPart(ArrayList<String> arr){
		String s=new String();
		System.out.println("\n===");
		String []spls=null;
		for(int g=0;g<arr.size();g++){
			String t=arr.get(g);
			spls =t.split("-");
			//if string have not word pairs:
			//плохой стиль - нкжны свои классы
			//исключений

			if (spls.length == 2)
			{

				for (int v=0;v < spls.length;v++)
				{
					System.out.print(v + "-" + "{" + spls[v] + "}");
				}
				eng.add(spls[0]);
				rus.add(spls[1]);
			}

		}
	}
	public ArrayList<String> eng=new ArrayList <>();
	public ArrayList<String> rus=new ArrayList <>();
	public String dirAsStr=new String();
}
