package me.pulz.simplysleep;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplySleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new onBedUse(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("sleep")) {

            if (sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("simplysleep.sleep")){
                    p.setStatistic(Statistic.TIME_SINCE_REST, 0);
                    p.sendMessage("§5[§dSimplySleep§5]§7: You suddenly feel well rested!");
                } else {
                    p.sendMessage("§5[§dSimplySleep§5]§7: You do not have permission for this command!");
                }
            } else {
                System.out.println("§5[§dSimplySleep§5]§7: This command can only be run by a player!");
            }
        }
        if (command.getName().equals("sleeptime")) {

            if (sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("simplysleep.sleeptime")) {
                    //there are 24000 ticks in a minecraft day, so obviously 1000 ticks in an hour
                    long ticktime = p.getStatistic(Statistic.TIME_SINCE_REST);
                    //long hours = ticktime / 1000 + 6;
                    //long minutes = (ticktime % 1000) * 60 / 1000;
                    p.sendMessage("§5[§dSimplySleep§5]§f:");
                    p.sendMessage("Time since last sleep is: §7" + ticktime + " ticks");
                    //p.sendMessage("Or in Minecraft time: §7"+ hours + " hours, " + minutes + " minutes");
                } else {
                    p.sendMessage("§5[§dSimplySleep§5]§7: You do not have permission for this command!");
                }
            } else {
                System.out.println("§5[§dSimplySleep§5]§7: This command can only be run by a player!");
            }
        }
        return true;
    }
}