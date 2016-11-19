package com.georgiev.rename.app;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RenamerTest {

	@Test
	public void shouldRenameFilesListTest() {
		String newFileName = "i";
		int newIndex = 1;
		String extenstion =".JPG";
		Renamer renamer = new Renamer(newFileName, newIndex,extenstion);
		List<String> names = new ArrayList<String>();
		names.add("a");
		names.add("b");
		names.add("c");

		Map<String, String> newFileNames = renamer.getNewFileNames(names);

		Assert.assertNotNull(newFileNames);
		Assert.assertEquals("i1.JPG", newFileNames.get("a"));
		Assert.assertEquals("i2.JPG", newFileNames.get("b"));
		Assert.assertEquals("i3.JPG", newFileNames.get("c"));

	}
}