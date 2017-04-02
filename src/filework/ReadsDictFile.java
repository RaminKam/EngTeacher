package filework;
import java.util.*;
import java.io.*;
public class ReadsDictFile
{
	public ReadsDictFile(String flDir){
		
	}
	
	public static String fdir="//storage//emulated//0//SimpleNotepad2//dict-[01-02-2016].txt";  //1490126478692.txt";  //dict-[01-02-2016].txt" ;
	private static ArrayList<String> arr = new ArrayList<>();
	
	public static ArrayList<String> readFileThere(String flDir){
		if(flDir!=null){
			fdir=flDir;
		}
		try{
			FileReader fstr=new FileReader(fdir);
			arr = new ArrayList<>();
			int ch=fstr.read();

			String strfor=new String();
			while(ch!=-1){
				//System.out.print((char)ch);
				if((char)ch=='\n'){
					arr.add(strfor);
					//System.out.println(":"+strfor);
					strfor=new String();
				}else {
					strfor=strfor+(char)ch;
				}
				ch=fstr.read();
			}
			arr.add(strfor);
			//System.out.println(":"+strfor+":");
			//System.out.println("size="+arr.size());
			//for(int g=0;g<arr.size();g++){
				//System.out.print(arr.get(g));
			//}
			//System.out.println();
			//for(int y=0;y<arr.get(1).length();y++){
				//System.out.println((int)arr.get(1).charAt(y));
			//}
			//System.out.println("\nhere"+arr.get(1).length());
			fstr.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
		return arr;



	}
}
