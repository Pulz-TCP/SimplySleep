package me.pulz.simplysleep.events;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class onBedUse implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerUseBed (PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("simplysleep.oninteract")){
            p.setStatistic(Statistic.TIME_SINCE_REST, 0);
            p.sendMessage("§5[§dSimplySleep§5]§7: You suddenly feel well rested!");
        }
    }
}