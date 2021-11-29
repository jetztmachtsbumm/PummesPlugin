package de.pummes.plugin.util;

import de.pummes.plugin.PummesPlugin;
import org.bukkit.Location;

public class ConfigTeleporterUtil {

    public static void saveNewTeleporter(String name, Location loc){
        PummesPlugin.getPlugin(PummesPlugin.class).getConfig().set(name + ".X", loc.getX());
        PummesPlugin.getPlugin(PummesPlugin.class).getConfig().set(name + ".Y", loc.getY());
        PummesPlugin.getPlugin(PummesPlugin.class).getConfig().set(name + ".Z", loc.getZ());
        PummesPlugin.getPlugin(PummesPlugin.class).saveConfig();
    }

}
