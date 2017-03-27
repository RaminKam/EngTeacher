package learning;
import java.util.*;

public class Dictionary
{
	public Dictionary(){
		//its for testing
		
	}
	private ArrayList <DictPart> parts=new ArrayList<>();
	private int numPairs=0;
	public int getNumPairs(){
		return numPairs;
	}
	public ArrayList<Integer> getAllMetrics(){
		ArrayList<Integer> ms=new ArrayList<>();
		for (DictPart p:parts){
			ms.add(p.getMetric());
		}
		return ms;
	}
	public ArrayList<Integer> getAllPartSizes(){
		ArrayList<Integer> szs=new ArrayList<>();
		for(DictPart p:parts){
			szs.add(p.getWordsNumber());
		}
		
		return szs;
	}
}
