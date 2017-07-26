package main;

import config.ReadConfigFile;
import learning.Learning;
import learning.*;
import filework.*;
import java.util.ArrayList;
import java.io.File;


public class Main
{
	public static final Integer WORDSNUMBER=5000;
	public static final int TIME1=Learning.CUSTOMTIME1;
	public static final int TIME2=Learning.CUSTOMTIME2;
	public static final String DICTFILESDIR=FilesSearcher.CUSTDIR;
	public static final boolean SHUFMODE=false;
	

	public static void main(String[] args)
	{
		//DictPart dp1=null;
		FilesSearcher fs=new FilesSearcher(DICTFILESDIR);
		ArrayList<ArrayList<String>> dictsStrings= fs.getDicts();
		ArrayList<String> fDirs=fs.getFDirs();
		ArrayList<String> fNames=fs.getFNames();
		Dictionary dictionary=new Dictionary();
		ArrayList<Integer> metrics=fs.getMetrics();
		
		for(int i=0;i<dictsStrings.size();i++){
			DictPart dp=new DictPart(dictsStrings.get(i),fNames.get(i), fDirs.get(i), metrics.get(i));
			dictionary.addDictPart(dp);
		}
		System.out.println("\n");
		
		
		Learning ln=new Learning(TIME1,TIME2,SHUFMODE);
		ln.rememberWordsCase1(dictionary, Learning.LearnType.MIXED, WORDSNUMBER);
		
	}
}
