package de.pummes.plugin.listeners;

import de.pummes.plugin.PummesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerUseTeleporterUIListener implements Listener {

    @EventHandler
    public void handlePlayerUIUsage(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase("§2Teleporter-Overworld") || e.getView().getTitle().equalsIgnoreCase("§4Teleporter-Nether") || e.getView().getTitle().equalsIgnoreCase("§eTeleporter-End")){
            if(e.getCurrentItem() != null){
                Location destination = new Location(Bukkit.getWorld(PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getString(e.getCurrentItem().getItemMeta().getDisplayName() + ".World")), PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(e.getCurrentItem().getItemMeta().getDisplayName() + ".X"), PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(e.getCurrentItem().getItemMeta().getDisplayName() + ".Y"), PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(e.getCurrentItem().getItemMeta().getDisplayName() + ".Z")).add(0.5, 1, 0.5);
                e.getWhoClicked().teleport(destination);
                Bukkit.getWorld(PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getString(e.getCurrentItem().getItemMeta().getDisplayName() + ".World")).playSound(destination, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            }
            e.setCancelled(true);
        }
    }

}
