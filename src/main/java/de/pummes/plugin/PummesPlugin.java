package de.pummes.plugin;

import de.pummes.plugin.commands.CordsCommand;
import de.pummes.plugin.listeners.PlayerChatListener;
import de.pummes.plugin.listeners.PlayerDeathListener;
import de.pummes.plugin.listeners.PlayerPaintSignListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PummesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPaintSignListener(), this);

        getCommand("cords").setExecutor(new CordsCommand());
    }

    @Override
    public void onDisable() {

    }

}
