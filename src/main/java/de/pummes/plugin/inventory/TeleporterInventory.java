package de.pummes.plugin.inventory;

import de.pummes.plugin.PummesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleporterInventory {

    private static Inventory inv = Bukkit.createInventory(null, 9*5, "§dTeleporter");

    private static void setup(){
        inv.clear();
        for(String key : PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getKeys(false)){
            ItemStack teleporter = new ItemStack(Material.PAPER);
            ItemMeta meta = teleporter.getItemMeta();
            meta.setDisplayName(key);
            meta.addEnchant(Enchantment.LURE, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            teleporter.setItemMeta(meta);
            inv.addItem(teleporter);
        }
    }

    public static Inventory get(){
        setup();
        return inv;
    }

}
