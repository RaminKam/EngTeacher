package main;

import config.ReadConfigFile;
import learning.Learning;
import learning.*;
import filework.*;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		DictPart dp1=null;
		FilesSearcher fs=new FilesSearcher();
		ArrayList<ArrayList<String>> dictsStrings= fs.getDicts();
		dp1=new DictPart(dictsStrings.get(0));
		Learning ln=new Learning();
		ln.genPairs(dp1);
		
		System.out.println("\nend");
	}
}
