package de.pummes.plugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OneWayElytraCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                ItemStack elytra = new ItemStack(Material.ELYTRA);
                ItemMeta meta = elytra.getItemMeta();
                meta.setDisplayName("§eOne Way Elytra");
                meta.addEnchant(Enchantment.KNOCKBACK, 1, false);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                elytra.setItemMeta(meta);
                player.getInventory().setItem(0, elytra);
            }else{
                player.sendMessage("§cDazu hast du keine Rechte! (Du gehörst der niederen Schicht an)");
            }
        }
        return true;
    }
}
