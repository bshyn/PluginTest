package bshyn.com.github.PluginTest.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import bshyn.com.github.PluginTest.data.SavedCoordinateDAO;
import bshyn.com.github.PluginTest.entities.SavedCoordinate;

public class Guardar extends JavaPlugin implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length < 4) {
			sender.sendMessage("Faltan datos");
			return false;
		}
		try {
			String desc = args[0];
			int xCoord = Integer.parseInt(args[1]);
			int yCoord = Integer.parseInt(args[2]);
			int zCoord = Integer.parseInt(args[3]);
			SavedCoordinate coord = new SavedCoordinate(desc, xCoord, yCoord, zCoord);
			
			List<SavedCoordinate> savedCoords = SavedCoordinateDAO.findAll();
			
			savedCoords.add(coord);
			SavedCoordinateDAO.saveFile(savedCoords);
			sender.sendMessage("Se guardo con exito");
		}
		catch (Exception e) {
			sender.sendMessage("Error");
			return false;
		}
		return true;
	}

}
