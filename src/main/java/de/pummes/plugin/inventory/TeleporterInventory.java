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

    private static Inventory invOverworld = Bukkit.createInventory(null, 9*5, "§2Teleporter-Overworld");
    private static Inventory invNether = Bukkit.createInventory(null, 9*5, "§4Teleporter-Nether");
    private static Inventory invEnd = Bukkit.createInventory(null, 9*5, "§eTeleporter-End");

    private static void setupInvOverworld(){
        invOverworld.clear();
        for(String key : PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getKeys(false)){
            if(PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getString(key + ".World").equalsIgnoreCase("world")) {
                ItemStack teleporter = new ItemStack(Material.PAPER);
                ItemMeta meta = teleporter.getItemMeta();
                meta.setDisplayName(key);
                meta.addEnchant(Enchantment.LURE, 1, false);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                teleporter.setItemMeta(meta);
                invOverworld.addItem(teleporter);
            }
        }
    }

    private static void setupInvNether(){
        invNether.clear();
        for(String key : PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getKeys(false)){
            if( PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getString(key + ".World").equalsIgnoreCase("world_nether")) {
                ItemStack teleporter = new ItemStack(Material.PAPER);
                ItemMeta meta = teleporter.getItemMeta();
                meta.setDisplayName(key);
                meta.addEnchant(Enchantment.LURE, 1, false);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                teleporter.setItemMeta(meta);
                invNether.addItem(teleporter);
            }
        }
    }

    private static void setupInvEnd(){
        invEnd.clear();
        for(String key : PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getKeys(false)){
            if( PummesPlugin.getPlugin(PummesPlugin.class).getConfig().getString(key + ".World").equalsIgnoreCase("world_the_end")) {
                ItemStack teleporter = new ItemStack(Material.PAPER);
                ItemMeta meta = teleporter.getItemMeta();
                meta.setDisplayName(key);
                meta.addEnchant(Enchantment.LURE, 1, false);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                teleporter.setItemMeta(meta);
                invEnd.addItem(teleporter);
            }
        }
    }

    public static Inventory getInvOverworld(){
        setupInvOverworld();
        return invOverworld;
    }

    public static Inventory getInvNether() {
        setupInvNether();
        return invNether;
    }

    public static Inventory getInvEnd() {
        setupInvEnd();
        return invEnd;
    }
}
