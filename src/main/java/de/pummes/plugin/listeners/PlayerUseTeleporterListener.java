package de.pummes.plugin.listeners;

import de.pummes.plugin.PummesPlugin;
import de.pummes.plugin.inventory.TeleporterInventory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerUseTeleporterListener implements Listener {

    @EventHandler
    public void handlePlayerUseTeleporter(PlayerInteractEvent e){
        if(e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.BEDROCK){
            if(isTeleporter(e.getClickedBlock().getLocation())){
                if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eTeleporter Breaker")){
                    String name = removeTeleporter(e.getClickedBlock().getLocation());
                    ItemStack teleporter = PummesPlugin.teleporter;
                    ItemMeta meta = teleporter.getItemMeta();
                    meta.setDisplayName(name);
                    teleporter.setItemMeta(meta);
                    e.getClickedBlock().setType(Material.AIR);
                    e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), teleporter);
                    e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
                }else {
                    switch (e.getPlayer().getLocation().getWorld().getName()) {
                        case "world":
                            e.getPlayer().openInventory(TeleporterInventory.getInvOverworld());
                            break;
                        case "world_nether":
                            e.getPlayer().openInventory(TeleporterInventory.getInvNether());
                            break;
                        case "world_the_end":
                            e.getPlayer().openInventory(TeleporterInventory.getInvEnd());
                            break;
                    }
                }
                e.setCancelled(true);
            }
        }
    }

    private String removeTeleporter(Location loc){
        for(String key : PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getKeys(false)){
            if(PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(key + ".X") == loc.getX() && PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(key + ".Y") == loc.getY() && PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getInt(key + ".Z") == loc.getZ()){
                PummesPlugin.getPlugin(PummesPlugin.class).getConfig().set(key, null);
                PummesPlugin.getPlugin(PummesPlugin.class).saveConfig();
                return key;
            }
        }
        return null;
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
