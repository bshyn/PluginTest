package bshyn.com.github.PluginTest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import bshyn.com.github.PluginTest.entities.SavedCoordinate;

public class Guardar extends JavaPlugin implements CommandExecutor{

	//Repositorio
	
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
			
			//repository.save(coord);
			sender.sendMessage("Se guardo con exito");
		}
		catch (Exception e) {
			sender.sendMessage("Error");
			return false;
		}
		return true;
	}

}
