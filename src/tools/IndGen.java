package tools;
import java.util.*;

public class IndGen
{
//	public static void main(String[] args){
//		int max=8;
//		IndGen n=null;
//		try{
//		 n=new IndGen(max);}
//		catch(Exception exs){
//			exs.printStackTrace();
//		}
//		for(int y=0;y<max;y++){
//			try{
//				
//			
//			System.out.print(n.getInd());
//			}catch(Exception ex){
//				ex.printStackTrace();
//			}
//		}
//	}
	ArrayList<Integer> arr=new ArrayList<Integer>();
	public IndGen(int smaxNumber) throws Exception{
		if(smaxNumber<1)
			throw new Exception("illegal max number");
		maxNumber=smaxNumber;
		
	}
	int maxNumber=0;
	public int getInd() throws Exception{
		int g=((int)(Math.random()*1000)%maxNumber);
		
		while (arr.contains(g)){
			
			g=((int)(Math.random()*1000)%maxNumber);
			if(arr.size()==maxNumber){
				throw new Exception("Array error");
			}
			
		}
		arr.add(g);
		return g;
	}
}
