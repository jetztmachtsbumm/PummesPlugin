package de.pummes.plugin.listeners;

import de.pummes.plugin.PummesPlugin;
import de.pummes.plugin.inventory.TeleporterInventory;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerUseTeleporterListener implements Listener {

    @EventHandler
    public void handlePlayerUseTeleporter(PlayerInteractEvent e){
        if(e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.BEDROCK){
            if(isTeleporter(e.getClickedBlock().getLocation())){
                e.getPlayer().openInventory(TeleporterInventory.get());
                e.setCancelled(true);
            }
        }
    }

    private boolean isTeleporter(Location loc){
        for(String key : PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getKeys(false)){
            if(PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(key + ".X") == loc.getX() && PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(key + ".Y") == loc.getY() && PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(key + ".Z") == loc.getZ()){
                return true;
            }
        }
        return false;
    }

}
