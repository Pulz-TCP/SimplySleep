package me.pulz.simplysleep.commands;

import me.pulz.simplysleep.SimplySleep;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sleep implements CommandExecutor {

    static SimplySleep plugin;
    public Sleep(SimplySleep simplysleep) {
        plugin = simplysleep;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("sleep")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                    if (label.equalsIgnoreCase("sleep")) {
                        if (p.hasPermission("simplysleep.sleep")) {
                            p.setStatistic(Statistic.TIME_SINCE_REST, 0);
                            p.sendMessage("§5[§dSimplySleep§5]§7: §fYou suddenly feel well rested!");
                        } else {
                            p.sendMessage("§5[§dSimplySleep§5]§7: §fYou do not have permission for this command!");
                        }
                    }
            } else {
                System.out.println("§5[§dSimplySleep§5]§7: §fThis command can only be run by a player!");
            }
        }
        return true;
    }
}
