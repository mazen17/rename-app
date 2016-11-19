package com.georgiev.rename.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Rename {

	private String pathname = "D:/nosync/102D5200";

	public void renameFiles(String newName) {
		try {
			File dir = new File(pathname);
			String[] filesInDir = dir.list();
			Arrays.sort(filesInDir);

			Renamer renamer = new Renamer(newName, 3845, ".JPG");
			Map<String, String> newFileNames = renamer
					.getNewFileNames(new ArrayList<String>(Arrays.asList(filesInDir)));

			for (String oldFileName : newFileNames.keySet()) {
				File oldFile = new File(pathname, oldFileName);
				File newFile = new File(pathname, newFileNames.get(oldFileName));
				boolean success = oldFile.renameTo(newFile);
				if (!success) {
					System.out.println("File " + oldFileName + " was not successfully renamed");
				}
			}

		} catch (Exception e) {
		}

	}
	public static void main(String[] args) {
		Rename r= new Rename();
		r.renameFiles("DSC_");
	}
}
