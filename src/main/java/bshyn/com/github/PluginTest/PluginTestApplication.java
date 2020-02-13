package bshyn.com.github.PluginTest;

import org.bukkit.plugin.java.JavaPlugin;

import bshyn.com.github.PluginTest.commands.Guardar;
import bshyn.com.github.PluginTest.commands.Listar;

public class PluginTestApplication extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("guardar").setExecutor(new Guardar());
		this.getCommand("listar").setExecutor(new Listar());
	}

}
