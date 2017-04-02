package filework;



import java.util.*;
import java.io.*;
public class FilesSearcher
{
	String searchDir="//storage//emulated//0//SimpleNotepad2";//директория, где должны находиться все части словаря
	ArrayList<ArrayList<String>> dicts=new ArrayList<>();
	ArrayList<String> fDirs=new ArrayList<>();
	ArrayList<String> fNames=new ArrayList<>();
	public FilesSearcher(String ssearchDir){
		if(ssearchDir!=null)
			searchDir=ssearchDir;
		File constitDir=new File(searchDir);
		File [] fls=constitDir.listFiles();
		//System.out.println("len="+fls.length);
		for(File b:fls){
			//System.out.println(b.getName());
			//System.out.println(b.lastModified());
			fNames.add(b.getName());
			fDirs.add(b.toString());
			dicts.add(ReadsDictFile.readFileThere(b.toString()));
		}
		//dicts.add(ReadsDictFile.readFileThere(null));
	}
	public ArrayList<ArrayList<String>>getDicts(){
		return dicts;
	}
	public ArrayList<String> getFDirs(){
		return fDirs;
	}
	public ArrayList<String> getFNames(){
		return fNames;
	}
	public ArrayList<Integer> getMetrics(){
		ArrayList<Integer> arr=new ArrayList<>();
		try
		{
			for (String str:fNames)
			{
				arr.add(parseFileName(str));
			}
		}
		catch (Exception xx)
		{
			xx.printStackTrace();
		}
		return arr;
	}
	private int parseFileName(String fileName) throws Exception{
		String metrStr=new String();
		char ch=fileName.charAt(0);
		for(int i=1;ch!='-';i++){
			metrStr+=ch;
			ch=fileName.charAt(i);
			
		}
		if(metrStr.length()==0)
			throw new Exception("not correct file name");
		int metric=Integer.parseInt(metrStr);
		return metric;
	}
	
	
}
