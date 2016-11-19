package com.georgiev.rename.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Rename2 {

	private String pathRoot = "C:/scan";
	private String pathName = "";
	private String separator = File.separator;

	public List<String> getFilesInDir(String dirName) {
		String fullPath = pathRoot +separator+dirName;
		File dir = new File(fullPath);
		String[] filesInDir = dir.list();
		return new ArrayList<String>(Arrays.asList(filesInDir));

	}

	public Map<String, String> getFileNames(String dirName, String  newFileName) {
		List<String> fileNames = getFilesInDir(dirName);
		ForwardRenamer fRenamer = new ForwardRenamer(newFileName);
		return fRenamer.getNewFileNames(fileNames);
	}

	public void renameFiles(Map<String, String> fileNames) {
		for (String oldFileName : fileNames.keySet()) {
			File oldFile = new File(pathName, oldFileName);
			File newFile = new File(pathName, fileNames.get(oldFileName));
			try {
				boolean success = oldFile.renameTo(newFile);
				if (!success) {
					System.out.println("File " + oldFileName + " was not successfully renamed");
				}
			} catch (Exception e) {
			}
		}
	}

	
	public void renameForward(Map<String, String> fileNames) {
		for (String oldFileName : fileNames.keySet()) {
			File oldFile = new File(pathName, oldFileName);
			File newFile = new File(pathName, fileNames.get(oldFileName));
			try {
				boolean success = oldFile.renameTo(newFile);
				if (!success) {
					System.out.println("File " + oldFileName + " was not successfully renamed");
				}
			} catch (Exception e) {
			}
		}
	}

	
	

	public static void main(String[] args) {
		Rename2 r = new Rename2();
		r.renameFiles("DSC_");
	}
}
