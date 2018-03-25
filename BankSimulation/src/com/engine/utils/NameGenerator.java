package com.engine.utils;

import java.util.List;
import java.util.Random;

import com.engine.io.Reader;

public class NameGenerator {

	private Random random = new Random();
	
	private List<String> names = Reader.readFile(getClass().getResource("/com/resources/namegenerator/Names.txt").getPath());
	private List<String> familyNames = Reader.readFile(getClass().getResource("/com/resources/namegenerator/FamilyNames.txt").getPath());
	
	/**
	 * Grabs a name out of the names list.
	 * @return random name.
	 */
	public String generateName() {
		return fixString(names.get(random.nextInt(names.size())));
	}
	
	/**
	 * Grabs a familyname out of the familyNames list.
	 * @return random family name.
	 */
	public String generateFamilyName() {
		String[] family = fixString(familyNames.get(random.nextInt(familyNames.size()))).split(" ");
		String result = "";
		for (int i = 0; i < family.length; i++) {
			if (i != family.length)
				result += fixString(family[i]) + " ";
			else
				result += fixString(family[i]);
		}
		return result;
	}

	/**
	 * generates a name and family name.
	 * @return complete name.
	 */
	public String generateFullName() {
		String name = generateName();
		String family = generateFamilyName();
		return name + " " + family;
	}
	
	/**
	 * Changes the current string to first character uppercase, and other characters lowercase.
	 * @param string - random string
	 * @return fixed string.
	 */
	private String fixString(String string) {
		String result = string.substring(0, 1).toUpperCase() + string.substring(1, string.length()).toLowerCase();
		return result.replaceAll("_", " ");
	}

}