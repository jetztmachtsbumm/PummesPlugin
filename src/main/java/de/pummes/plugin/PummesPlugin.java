package de.pummes.plugin;

import de.pummes.plugin.commands.ColorHelpCommand;
import de.pummes.plugin.commands.CordsCommand;
import de.pummes.plugin.commands.OneWayElytraCommand;
import de.pummes.plugin.listeners.*;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class PummesPlugin extends JavaPlugin {

    public static final List<String> oneWayElytraUsers = new ArrayList<>();

    @Override
    public void onEnable() {
        createTeleporterItem();
        spawnTeleporterParticles();

        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPaintSignListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerGlideListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceTeleporterListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerUseTeleporterListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerUseTeleporterUIListener(), this);

        getCommand("cords").setExecutor(new CordsCommand());
        getCommand("onewayelytra").setExecutor(new OneWayElytraCommand());
        getCommand("colorhelp").setExecutor(new ColorHelpCommand());
    }

    private void createTeleporterItem(){
        ItemStack teleporter = new ItemStack(Material.BEDROCK);

        ItemMeta meta = teleporter.getItemMeta();
        meta.setDisplayName("Teleporter");
        meta.addEnchant(Enchantment.LURE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teleporter.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "teleporter"), teleporter);

        recipe.shape("EEE", "GNG", "III");

        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('G', Material.GLASS_PANE);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('I', Material.IRON_BLOCK);

        getServer().addRecipe(recipe);
    }

    private void spawnTeleporterParticles(){
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for(String key : getConfig().getKeys(false)){
                if(!key.equalsIgnoreCase("TeleportersPlacedByPlayers")) {
                    getServer().getWorld(getConfig().getString(key + ".World")).spawnParticle(Particle.DUST_COLOR_TRANSITION, new Location(getServer().getWorld("world"), getConfig().getDouble(key + ".X"), getConfig().getDouble(key + ".Y"), getConfig().getDouble(key + ".Z")).add(0.5, 1, 0.5), 1, new Particle.DustTransition(Color.PURPLE, Color.FUCHSIA, 10));
                }
            }
        }, 0, 5);
    }

}
