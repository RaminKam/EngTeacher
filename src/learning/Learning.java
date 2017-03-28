package learning;
import java.util.*;
import java.io.*;
import tools.*;
public class Learning
{
	static final int time1=5000;
	static final int time2=1000;
	//String fdir="//storage//emulated//0//SimpleNotepad2//dict-[01-02-2016].txt";  //1490126478692.txt";  //dict-[01-02-2016].txt" ;
	
	
	public Learning(){

	}
	public ArrayList<int[]> makeShowedSequence(Dictionary dictionary){
		int seqLen=12;
		ArrayList<Integer> ms=dictionary.getAllMetrics();
		
		int sumMetrics=0;
		for(Integer i:ms){
			sumMetrics+=i;
		}
		double[] pers=new double[ms.size()];   //доли длин на каждую часть
		
		
		int lens[]=new int[ms.size()];        //длины на каждую часть
		
		for(int i=0;i<ms.size();i++){
			pers[i]=(double)(ms.get(i))/(double)(sumMetrics)*100;
			lens[i]=(int)(seqLen*pers[i]*100);
			System.out.println("*"+lens[i]+"*");
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
				indOfPart[i+j]=pi;
				try{
				indOfWord[i+j]=indGens.get(pi).getInd();
				}catch(Exception exx){
					//System.out.println("u");
					exx.printStackTrace();
					//break;
				}
			}
			
		}
	
		ArrayList<int[]> indexes=new ArrayList();
		for(int k=0;k<indOfPart.length;k++){
			indexes.add(new int[]{indOfPart[k],indOfWord[k]});
		}
		return indexes;
		
	}
	public void rememberWordsCase1(Dictionary dictionary){
		ArrayList<int[]> indexes=makeShowedSequence(dictionary);
		for(int[] el:indexes){
			System.out.println(el[0]+"-"+el[1]);
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
