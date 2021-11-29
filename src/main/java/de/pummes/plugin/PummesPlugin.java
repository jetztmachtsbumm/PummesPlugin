package de.pummes.plugin;

import de.pummes.plugin.commands.ColorHelpCommand;
import de.pummes.plugin.commands.CordsCommand;
import de.pummes.plugin.commands.OneWayElytraCommand;
import de.pummes.plugin.listeners.PlayerChatListener;
import de.pummes.plugin.listeners.PlayerDeathListener;
import de.pummes.plugin.listeners.PlayerGlideListener;
import de.pummes.plugin.listeners.PlayerPaintSignListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class PummesPlugin extends JavaPlugin {

    public static final List<String> oneWayElytraUsers = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPaintSignListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerGlideListener(), this);

        getCommand("cords").setExecutor(new CordsCommand());
        getCommand("onewayelytra").setExecutor(new OneWayElytraCommand());
        getCommand("colorhelp").setExecutor(new ColorHelpCommand());
    }

}
