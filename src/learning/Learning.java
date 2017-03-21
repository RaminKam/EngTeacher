package learning;
import java.util.*;
import java.io.*;
public class Learning
{
	static final int time1=1000;
	static final int time2=2000;
	String fdir="//storage//emulated//0//SimpleNotepad2//dict-[01-02-2016].txt";  //1490126478692.txt";  //dict-[01-02-2016].txt" ;
	ArrayList<String> arr = new ArrayList<>();
	public Learning(){

	}
	public void readFileThere(){
		try{
			FileReader fstr=new FileReader(fdir);
			arr = new ArrayList<>();
			int ch=fstr.read();

			String strfor=new String();
			while(ch!=-1){
				//System.out.print((char)ch);
				if((char)ch=='\n'){
					arr.add(strfor);
					System.out.println(":"+strfor);
					strfor=new String();
				}else {
					strfor=strfor+(char)ch;
				}
				ch=fstr.read();
			}
			arr.add(strfor);
			System.out.println(":"+strfor+":");
			System.out.println("size="+arr.size());
			for(int g=0;g<arr.size();g++){
				System.out.print(arr.get(g));
			}
			//System.out.println();
			for(int y=0;y<arr.get(1).length();y++){
				//System.out.println((int)arr.get(1).charAt(y));
			}
			//System.out.println("\nhere"+arr.get(1).length());
			fstr.close();
		}catch(Exception ex){
			System.out.println(ex);
		}

		genPairs();
		
	}
	public void genPairs(){

		ArrayList <String> eng=new ArrayList<>();
		ArrayList <String> rus=new ArrayList<>();
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
		System.out.println(Arrays.toString(eng.toArray()));

		
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
