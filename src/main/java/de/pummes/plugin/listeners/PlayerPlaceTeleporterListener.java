package de.pummes.plugin.listeners;

import de.pummes.plugin.PummesPlugin;
import de.pummes.plugin.util.ConfigTeleporterUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceTeleporterListener implements Listener {

    @EventHandler
    public void handleTeleporterPlacement(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.BEDROCK){
            if(PummesPlugin.getPlugin(PummesPlugin.class).getConfig().contains("§e" + e.getItemInHand().getItemMeta().getDisplayName())){
                e.setCancelled(true);
                e.getPlayer().sendMessage("§cEin Teleporter mit dem Namen §e" + e.getItemInHand().getItemMeta().getDisplayName() + "§c existiert bereits!");
                e.getPlayer().sendMessage("§cBitte benenne deinen Teleporter an einem Amboss um.");
            }else {
                ConfigTeleporterUtil.saveNewTeleporter("§e" + e.getItemInHand().getItemMeta().getDisplayName(), e.getBlock().getLocation());
            }
        }
    }

}
