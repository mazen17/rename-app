package com.georgiev.rename.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Renamer{
	
	private String startName;
	private int newIndex;
	private String extension;
		
	public Renamer(String startName, int newIndex,String extension) {
		this.startName=startName;
		this.newIndex = newIndex;
		this.extension=extension;
	}

	public Map<String,String> getNewFileNames(List<String>names) {
		Map<String, String> newFileNames= new HashMap<String, String>();
		
		
		Collections.sort(names);
		for (String fileName:names) {
			newFileNames.put(fileName, startName+newIndex+extension);
			newIndex++;			
		}
				
		return newFileNames;
	}
}