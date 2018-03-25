package com.engine.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Reader {

	public static List<String> readFile(String path) {
		List<String> list = new LinkedList<>();

		try {
			FileReader file = new FileReader(path);
			BufferedReader reader = new BufferedReader(file);
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] names = line.split(",");
				for (String name : names) {
					if (!name.trim().equalsIgnoreCase("")) {
						list.add(name.trim());
					}
				}
			}
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
}