package bshyn.com.github.PluginTest;

import org.bukkit.plugin.java.JavaPlugin;

import bshyn.com.github.PluginTest.commands.Guardar;
import bshyn.com.github.PluginTest.commands.Listar;

public class PluginTestApplication extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("guardar").setExecutor(new Guardar());
		getCommand("listar").setExecutor(new Listar());
	}

}
