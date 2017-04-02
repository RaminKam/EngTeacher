package main;

import config.ReadConfigFile;
import learning.Learning;
import learning.*;
import filework.*;
import java.util.ArrayList;
import java.io.File;


public class Main
{
	static final Integer wordsNumber=10;
	public static void main(String[] args)
	{
		DictPart dp1=null;
		FilesSearcher fs=new FilesSearcher(null);
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
		
		
		Learning ln=new Learning();
		ln.rememberWordsCase1(dictionary, Learning.LearnType.MIXED, wordsNumber);
		
	}
}
