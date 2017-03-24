package filework;



import java.util.*;
import java.io.*;
public class FilesSearcher
{
	String searchDir="//storage//emulated//0//SimpleNotepad2";//директория, где должны находиться все части словаря
	ArrayList<ArrayList<String>> dicts=new ArrayList<>();
	public FilesSearcher(String ssearchDir){
		if(ssearchDir!=null)
			searchDir=ssearchDir;
		File constitDir=new File(searchDir);
		File [] fls=constitDir.listFiles();
		System.out.println("len="+fls.length);
		for(File b:fls){
			System.out.println(b.getName());
			System.out.println(b.lastModified());
		}
		dicts.add(ReadsDictFile.readFileThere(null));
	}
	public ArrayList<ArrayList<String>>getDicts(){
		return dicts;
	}
	
	
}
