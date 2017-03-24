package filework;



import java.util.*;

public class FilesSearcher
{
	String searchDir="";//директория, где должны находиться все части словаря
	ArrayList<ArrayList<String>> dicts=new ArrayList<>();
	public FilesSearcher(){
		dicts.add(ReadsDictFile.readFileThere(null));
	}
	public ArrayList<ArrayList<String>>getDicts(){
		return dicts;
	}
	
	
}
