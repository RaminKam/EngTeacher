package learning;
import java.util.*;
import java.io.*;
public class Learning
{
	static final int time1=3000;
	static final int time2=1000;
	//String fdir="//storage//emulated//0//SimpleNotepad2//dict-[01-02-2016].txt";  //1490126478692.txt";  //dict-[01-02-2016].txt" ;
	
	
	public Learning(){

	}
	public void makeShowedSequence(Dictionary dictionary){
		int seqLen=12;
		ArrayList<Integer> ms=dictionary.getAllMetrics();
		
		int sumMetrics=0;
		for(Integer i:ms){
			sumMetrics+=i;
		}
		double[] pers=new double[ms.size()];
		
		int lens[]=new int[ms.size()];
		
		for(int i=0;i<ms.size();i++){
			pers[i]=(double)(ms.get(i))/(double)(sumMetrics)*100;
			lens[i]=(int)(seqLen*pers[i]*100);

		}
		System.out.println("ending of makeShowedSequence");
		int realSeqLen=0;
		for(int y=0;y<lens.length;y++){
			realSeqLen+=lens[y];
		}
		int[] indOfPart=new int[realSeqLen];
		int[] indOfWord=new int[realSeqLen];
		
		for(int i=0, pi=0;i<realSeqLen && pi <ms.size();i+=lens[pi], pi++){
			for(int j=0;j<lens[pi];j++){
				indOfPart[i+j]=6;
				indOfWord[i+j]=8;
			}
		}
		
	}
	public void rememberWordsCase1(Dictionary dictionary){
		
		
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
