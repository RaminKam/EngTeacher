package tools;
import java.util.*;

public class IndGen
{
	ArrayList<Integer> arr=new ArrayList<Integer>();
	public IndGen(int smaxNumber){
		maxNumber=smaxNumber;
	}
	int maxNumber=0;
	public int getInd(){
		int g=((int)(Math.random()*1000)%maxNumber);
		
		return 0;
	}
}
