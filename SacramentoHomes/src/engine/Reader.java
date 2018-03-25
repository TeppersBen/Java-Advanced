package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	Mapper mapper = new Mapper();
	
	public List<Property> readCSVFile(String path) {
		try {
			List<Property> list = new ArrayList<>();
			FileReader file = new FileReader(path);
			BufferedReader reader = new BufferedReader(file);
			String line = null;
			String[] elements = null;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				elements = line.split(",");
				list.add(mapper.map(elements[0], elements[1],
									  elements[2], elements[3],
									  Integer.parseInt(elements[4]), Integer.parseInt(elements[5]),
									  Double.parseDouble(elements[6]), elements[7],
									  elements[8], Long.parseLong(elements[9]),
									  Double.parseDouble(elements[10]), Double.parseDouble(elements[11])));
			}
			reader.close();
			return list;
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
