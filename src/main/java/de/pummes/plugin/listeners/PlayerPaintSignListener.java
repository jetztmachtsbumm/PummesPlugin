package de.pummes.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class PlayerPaintSignListener implements Listener {

    @EventHandler
    public void onPaintSign(SignChangeEvent e){
        String[] lines = e.getLines();
        for(int i = 0; i < lines.length; i++){
            lines[i] = lines[i].replaceAll("&", "§");
        }
    }

}
