package bshyn.com.github.PluginTest.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import bshyn.com.github.PluginTest.entities.SavedCoordinate;

public class Listar implements CommandExecutor{

	List<SavedCoordinate> savedCoords;
	//Repository

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) {
			//SavedCoordinate coords = repository.findbydesc(args[0]);
			//sender.sendMessage(coords.toString());
			return true;
		}
		
		try {
			savedCoords.forEach(coord -> sender.sendMessage(coord.toString()));
		}catch (Exception e) {
			sender.sendMessage("Error");
			return false;
		}
		
		return true;
	}
}
