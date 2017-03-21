package main;

import config.ReadConfigFile;
import learning.Learning;

public class Main
{
	public static void main(String[] args){
		System.out.println("");
		ReadConfigFile.getConfig();
		Learning ln=new Learning();
		ln.readFileThere();
		
	}
}
