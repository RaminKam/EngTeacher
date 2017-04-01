package learning;
import java.util.*;

public class Dictionary
{
	public Dictionary(){
		//its for testing
		
	}
	public void addDictPart(DictPart dp){
		parts.add(dp);
	}
	private ArrayList <DictPart> parts=new ArrayList<>();
	//private int numPairs=0;
	public int getNumPairs(){
		ArrayList<Integer> nums=getAllPartSizes();
		int sum=0;
		for(Integer n:nums){
			sum+=n;
		}
		return sum;
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
	public DictPart getPart(int i){
		return parts.get(i);
	}

	@Override
	public String toString(){
	
		String s="";
		for(int i=0;i<parts.size();i++){
			s=s+parts.get(i).getWordsNumber()+"  ";
		}
		s=s+" parts="+parts.size();
		
		return s;
	}
	
}
