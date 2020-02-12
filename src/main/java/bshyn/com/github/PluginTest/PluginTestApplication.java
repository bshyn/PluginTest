package bshyn.com.github.PluginTest;

import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bshyn.com.github.PluginTest.commands.Guardar;
import bshyn.com.github.PluginTest.commands.Listar;

@SpringBootApplication
public class PluginTestApplication extends JavaPlugin {

	public static void main(String[] args) {
		SpringApplication.run(PluginTestApplication.class, args);
	}
	
	@Override
	public void onEnable() {
		this.getCommand("guardar").setExecutor(new Guardar());
		this.getCommand("listar").setExecutor(new Listar());
	}

}
