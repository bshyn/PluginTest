package bshyn.com.github.PluginTest.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import bshyn.com.github.PluginTest.data.SavedCoordinateDAO;
import bshyn.com.github.PluginTest.entities.SavedCoordinate;

public class Guardar implements CommandExecutor{
	
	public Guardar() {
	}
	
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

			SavedCoordinateDAO.saveFile(coord);
			sender.sendMessage("Se guardo con exito");
		}
		catch (Exception e) {
			File file = new File("coords.json");
			Boolean bool = file.canWrite();
			sender.sendMessage(file.toPath().toString());
			sender.sendMessage(bool.toString());
			sender.sendMessage("\n" + e.toString() + "\n" + e.getMessage() + "\n" + e.getLocalizedMessage());
			return false;
		}
		return true;
	}

}
