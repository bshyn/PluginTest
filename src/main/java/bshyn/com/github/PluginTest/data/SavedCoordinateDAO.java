package bshyn.com.github.PluginTest.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import bshyn.com.github.PluginTest.entities.SavedCoordinate;

public class SavedCoordinateDAO {

	public static Optional<SavedCoordinate> findByDesc(String desc){
		
		try {
			List<SavedCoordinate> coords = readFile();
			for (SavedCoordinate savedCoordinate : coords) {
				if(savedCoordinate.getCoordDescription().equals(desc)) {
					return Optional.of(savedCoordinate);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public static List<SavedCoordinate> findAll() {
		List<SavedCoordinate> saved = null;
		try {
			saved = readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saved;
	}
	
	private static List<SavedCoordinate> readFile() throws IOException {
		FileReader reader = new FileReader("coords.json");
		int data = reader.read();
		Gson gson = new Gson();
		String json = "";
		List<SavedCoordinate> coords;
		
		while(data != -1) {
			json += (char) data;
			data = reader.read();
		}
		reader.close();
		
		@SuppressWarnings("serial")
		Type listType = new TypeToken<List<SavedCoordinate>>() {}.getClass();
		coords = gson.fromJson(json, listType);
		
		return coords;
	}
	
	public static void saveFile(List<SavedCoordinate> coords) throws IOException {
		FileWriter writer = new FileWriter("coords.json");
		Gson gson = new Gson();
		String json = gson.toJson(coords);
		writer.write(json);
		writer.close();
	}
	
}
