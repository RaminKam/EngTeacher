package learning;
import java.util.*;
import java.io.*;
import tools.*;
public class Learning
{
	static final int time1=1000;
	static final int time2=1000;
	//String fdir="//storage//emulated//0//SimpleNotepad2//dict-[01-02-2016].txt";  //1490126478692.txt";  //dict-[01-02-2016].txt" ;
	
	
	public Learning(){

	}
	public ArrayList<int[]> makeShowedSequence(Dictionary dictionary){
		int seqLen=10;
		ArrayList<Integer> ms=dictionary.getAllMetrics();
		int[] msps=new int[ms.size()];
		int[] msc=new int[ms.size()];
		for(int i=0;i<ms.size();i++){
			msps[i]=i;
			msc[i]=ms.get(i);
		}
		
		//
		



		for (int i=0; i < ms.size(); i++)
		{            
			for (int j = ms.size() - 1; j > i; j--)
			{  
				int bufx;

				if (msc[j - 1] > msc[j])
				{
					bufx = msps[j - 1]; msps[j - 1] = msps[j]; msps[j] = bufx;
					bufx = msc[j - 1]; msc[j - 1] = msc[j]; msc[j] = bufx;
				
					
				}
			}
		}

		//
		int sumMetrics=0;
		for(Integer i:ms){
			sumMetrics+=i;
		}
		double[] pers=new double[ms.size()];   //доли длин на каждую часть
		
		
		int lens[]=new int[ms.size()];        //длины на каждую часть
		
		for(int i=0;i<ms.size();i++){
			pers[i]=(double)(ms.get(i))/(double)(sumMetrics);
			
			lens[i]=(int)(seqLen*pers[i]);
			//System.out.println("*"+lens[i]+"*");
			if(dictionary.getAllPartSizes().get(i)<lens[i]){
				lens[i]=dictionary.getAllPartSizes().get(i);
			}

		}
		
		int realSeqLen=0;//длина с учетом возможного округления и ограничений колва слов существующего
		for(int y=0;y<lens.length;y++){
			realSeqLen+=lens[y];
		}
		int[] indOfPart=new int[realSeqLen];
		int[] indOfWord=new int[realSeqLen];
		ArrayList<IndGen> indGens=IndGen.makeGenArr(dictionary.getAllPartSizes());
		
		
		
		for(int i=0, pi=0;i<realSeqLen && pi <ms.size();i+=lens[pi], pi++){
			for(int j=0;j<lens[pi]&&(i+j)<realSeqLen;j++){
				indOfPart[i+j]=msps[pi];
				try{
				indOfWord[i+j]=indGens.get(pi).getInd();
				}catch(Exception exx){
					
					exx.printStackTrace();
					
				}
			}
			
		}
	
		
		ArrayList<int[]> indexes=new ArrayList();
		for(int k=0;k<indOfPart.length;k++){
			indexes.add(new int[]{indOfPart[k],indOfWord[k]});
		}
		return indexes;
		
	}
	public enum LearnType{ONLYENG,ONLYRUS,MIXED};
	public void rememberWordsCase1(Dictionary dictionary, LearnType sltp){
	
		LearnType ltp=null;
		if(sltp==null)
			ltp=LearnType.ONLYRUS;
		else 
			ltp=sltp;
		
		ArrayList<int[]> indexes=makeShowedSequence(dictionary);
		for(int[] el:indexes){
			int i=el[0];
			int j=el[1];
			if(ltp==LearnType.ONLYENG)
			{
				System.out.println(dictionary.getPart(i).eng.get(j));
				try
				{
					Thread.currentThread().sleep(time1);
				}
				catch (Exception exx1)
				{}
				System.out.print(dictionary.getPart(i).rus.get(j));
				try
				{
					Thread.currentThread().sleep(time2);
				}
				catch (Exception exx1)
				{}
					
			}
			if(ltp==LearnType.ONLYRUS){
				System.out.print(dictionary.getPart(i).rus.get(j));
				try
				{
					Thread.currentThread().sleep(time1);
				}
				catch (Exception exx1)
				{}
				System.out.println(dictionary.getPart(i).eng.get(j));
				try
				{
					Thread.currentThread().sleep(time2);
				}
				catch (Exception exx1)
				{}
			}
			if(ltp==LearnType.MIXED){
				int rann=(int)(Math.random()*100)%2;
				if (rann == 0)
				{
					System.out.print(dictionary.getPart(i).rus.get(j));
					
					try
					{
						Thread.currentThread().sleep(time1);
					}
					catch (Exception exx1)
					{}
					System.out.println(dictionary.getPart(i).eng.get(j));
				}
				else
				{
					System.out.print(dictionary.getPart(i).eng.get(j));
					try
					{
						Thread.currentThread().sleep(time1);
					}
					catch (Exception exx1)
					{}
					System.out.println(dictionary.getPart(i).rus.get(j));
				}
				try
				{
					Thread.currentThread().sleep(time2);
				}
				catch (Exception exx1)
				{}
			}
			
			
			//System.out.println(el[0]+"-"+el[1]);
		}
		
	}

	public void genPairs(DictPart dp){
		ArrayList<String> arr = new ArrayList<>();
		ArrayList <String> eng=new ArrayList<>();
		ArrayList <String> rus=new ArrayList<>();

		rus=dp.rus;
		eng=dp.eng;

		
		int mode=(int)(Math.random()*10)%2;
		System.out.println("mode"+mode);
		ArrayList<String> aa=(ArrayList<String>)eng.clone();
		ArrayList<String> bb=(ArrayList<String>)rus.clone();
		while(aa.size()>0){
			int ind=(int)(Math.random()*100)%aa.size();
			System.out.println("\n\n\n\n\n");
			if(mode==1)
				System.out.println("\n"+aa.get(ind));
			else
				System.out.print("\n"+bb.get(ind));
			try{
				Thread.currentThread().sleep(time1);

			}
			catch(Exception exx){}
			if (mode==1)
				System.out.print("-"+bb.get(ind));
			else
				System.out.println("-"+aa.get(ind));
			try{
				Thread.currentThread().sleep(time2);

			}
			catch(Exception exx){}		
			aa.remove(ind);
			bb.remove(ind);
			mode=(int)(Math.random()*10)%2;
		}

	}
}
