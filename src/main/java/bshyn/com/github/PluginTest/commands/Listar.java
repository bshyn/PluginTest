package bshyn.com.github.PluginTest.commands;

import java.util.List;
import java.util.Optional;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import bshyn.com.github.PluginTest.data.SavedCoordinateDAO;
import bshyn.com.github.PluginTest.entities.SavedCoordinate;


public class Listar implements CommandExecutor{
	
	public Listar() {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) {
			String desc = args[0];
			Optional<SavedCoordinate> opt = SavedCoordinateDAO.findByDesc(desc);
			if (opt.isPresent()) {
				sender.sendMessage(opt.get().toString());
				return true;
			} else {
				sender.sendMessage("No se encontro");
			}
		} else {
			Optional<List<SavedCoordinate>> opt = SavedCoordinateDAO.findAll();
			if(opt.isPresent()) {
				List<SavedCoordinate> saved = opt.get();
				if(saved.isEmpty()) {
					sender.sendMessage("Lista vacia");
					return false;
				}
				for (SavedCoordinate savedCoordinate : saved) {
					sender.sendMessage(savedCoordinate.toString());
				}
				return true;
			}
		}
		return false;
	}
}
