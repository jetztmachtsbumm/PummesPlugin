package de.pummes.plugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        int i = ThreadLocalRandom.current().nextInt(1, 11);
        if(i == 5 || i == 6){
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            meta.setOwningPlayer(e.getEntity());
            head.setItemMeta(meta);
            e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), head);
        }
    }

}
