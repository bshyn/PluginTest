package bshyn.com.github.PluginTest.data;

import java.io.File;
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
			List<SavedCoordinate> coords = readFile().get();
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
	
	public static Optional<List<SavedCoordinate>> findAll() {
		Optional<List<SavedCoordinate>> saved = Optional.empty();
		try {
			saved = readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saved;
	}
	
	private static Optional<List<SavedCoordinate>> readFile() throws IOException {
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
		
		return Optional.of(coords).isPresent() ? Optional.of(coords) : Optional.empty();
	}
	
	public static void saveFile(SavedCoordinate coord) throws IOException {
		FileWriter writer = new FileWriter("coords.json");
		Gson gson = new Gson();
		Optional<List<SavedCoordinate>> opt = readFile();
		if(opt.isPresent()) {
			List<SavedCoordinate> saved = opt.get();
			
			if(saved.isEmpty()) {
				String json = gson.toJson(coord);
				writer.write(json);
			} else {
				saved.add(coord);
				String json = gson.toJson(saved);
				writer.write(json);
			}
		}
		writer.close();
	}
	
}
