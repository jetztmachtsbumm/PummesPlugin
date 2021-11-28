package de.pummes.plugin.listeners;

import de.pummes.plugin.PummesPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerGlideListener implements Listener {

    @EventHandler
    public void onPlayerLanded(EntityToggleGlideEvent e){
        Player player = (Player) e.getEntity();
        if(player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§eOne Way Elytra")){
            if(PummesPlugin.oneWayElytraUsers.contains(player.getName())){
                player.getInventory().setItem(38, new ItemStack(Material.AIR));
                PummesPlugin.oneWayElytraUsers.remove(player.getName());
            }else{
                PummesPlugin.oneWayElytraUsers.add(player.getName());
            }
        }
    }

}
