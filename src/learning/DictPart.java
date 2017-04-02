package learning;
import java.util.*;

public class DictPart
{
	public DictPart(ArrayList<String> arr,String sname, String sdirStr, Integer smetric){
		if(smetric==null)
		{
			metric=(int)(Math.random()*1000)%67;
		}
		else{
			metric=smetric;
		}
		name=sname;
		dirStr=sdirStr;
		String s=new String();
		
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
					//System.out.print(v + "-" + "{" + spls[v] + "}");
				}
				eng.add(spls[0]);
				rus.add(spls[1]);
			}

		}
	}
	public ArrayList<String> eng=new ArrayList <>();
	public ArrayList<String> rus=new ArrayList <>();
	public String dirStr=new String();
	String name="";
	Integer metric=null;
	public int getMetric(){
		return metric;
	}
	public int getWordsNumber(){
		//System.out.println("\n("+eng.size()+")");
		return eng.size();
	}
}
