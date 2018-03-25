package engine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

	public void WriteCSVFile(String name, List<Property> list) {
		Thread t = new Thread(() -> {
			try {
				File file = new File("src/resources/" + name + ".csv");
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				writer.write("street,city,zip,state,beds,baths,sq__ft,type,sale_date,price,latitude,longitude\n");
				list.stream().forEach(e -> {
					try {
						writer.write(e.toString() +"\n");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				});
				writer.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		});
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getState());
	}
	
}