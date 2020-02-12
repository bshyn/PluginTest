package bshyn.com.github.PluginTest.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import com.google.gson.Gson;

import bshyn.com.github.PluginTest.entities.SavedCoordinate;

public class SavedCoordinateDAO {

	public static Optional<SavedCoordinate> findByDesc(String desc){
		Optional<SavedCoordinate> opt = Optional.empty();
		try {
			SavedCoordinate[] coords = readFile();
			
			for (SavedCoordinate savedCoordinate : coords) {
				if(savedCoordinate.getCoordDescription().equals(desc)) {
					opt = Optional.of(savedCoordinate);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return opt;
	}
	
	public static Optional<SavedCoordinate[]> findAll() {
		Optional<SavedCoordinate[]> opt = Optional.empty();
		try {
			opt = Optional.of(readFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return opt;
	}
	
	private static SavedCoordinate[] readFile() throws IOException {
		FileReader reader = new FileReader("coords.json");
		int data = reader.read();
		Gson gson = new Gson();
		String json = "";
		SavedCoordinate[] coords;
		
		while(data != -1) {
			json += (char) data;
			data = reader.read();
		}
		reader.close();
		
		coords = gson.fromJson(json, SavedCoordinate[].class);
		
		return coords;
	}
	
	public static void saveFile(SavedCoordinate[] coords) throws IOException {
		FileWriter writer = new FileWriter("coords.json");
		Gson gson = new Gson();
		String json = gson.toJson(coords);
		writer.write(json);
		writer.close();
	}
	
}
