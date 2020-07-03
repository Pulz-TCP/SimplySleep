package me.pulz.simplysleep.commands;

import me.pulz.simplysleep.SimplySleep;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sleeptime implements CommandExecutor {

    static SimplySleep plugin;
    public Sleeptime(SimplySleep simplysleep) {
        plugin = simplysleep;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("simplysleep.sleeptime")) {
                    long currentTickTime = p.getStatistic(Statistic.TIME_SINCE_REST);
                    long ticktime = currentTickTime;

                    long days = ticktime / (24 * 1000);
                    ticktime -= days * (24 * 1000);

                    long hours = ticktime / 1000;
                    ticktime -= hours * 1000;

                    long minutes = (long) ((double) ticktime / (1000d / 60d));
                    ticktime -= minutes * (1000d / 60d);

                    long seconds = (long) ((double) ticktime / (1000d / 60d / 60d));
                    ticktime -= seconds * (1000d / 60d / 60d);
                    p.sendMessage("§5[§dSimplySleep§5]§7: §fTime since last sleep is: \n§7" + days + " §fdays, §7" + hours + " §fhours, §7" + minutes + " §fminutes, §7" + seconds + " §fseconds.");
                } else {
                    p.sendMessage("§5[§dSimplySleep§5]§7: §fYou do not have permission for this command!");
                }
            } else {
                System.out.println("§5[§dSimplySleep§5]§7: §fThis command must be run by a player!");
            }
            return true;
        }
    }