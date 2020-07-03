package me.pulz.simplysleep.commands;

import me.pulz.simplysleep.SimplySleep;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Adddays implements CommandExecutor {

    static SimplySleep plugin;

    public Adddays(SimplySleep simplysleep) {
        plugin = simplysleep;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("adddays")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("simplysleep.adddays")) {
                    int sanityCheck = p.getStatistic(Statistic.TIME_SINCE_REST);
                    int selectedNumber = Integer.parseInt(args[0]);
                    if (args.length != 0) {
                        if (selectedNumber >= 100) {
                            p.sendMessage("§5[§dSimplySleep§5]§7: §fPlease provide a whole number, less than 100 E.G §7/adddays 1");
                        } else {
                            //Check to make sure the number since last sleep is not rediculously high that it breaks the command
                            if (sanityCheck >= 2400000) { //100 days
                                p.sendMessage("§5[§dSimplySleep§5]§7: §f100 days is the longest you can stay awake. You fall asleep..");
                                p.setStatistic(Statistic.TIME_SINCE_REST, 0);
                            } else {

                                int finalNumber = selectedNumber * 24000;

                                p.incrementStatistic(Statistic.TIME_SINCE_REST, finalNumber);
                                p.sendMessage("§5[§dSimplySleep§5]§7: §fAdded §7" + selectedNumber + " §fdays to your time since last sleep!");
                            }
                        }

                    } else {
                        p.sendMessage("§5[§dSimplySleep§5]§7: §fYou do not have permission for this command!");
                        return true;
                    }

                } else {
                    System.out.println("§5[§dSimplySleep§5]§7: §fThis command must be sent by a player!");
                    return true;
                }
            }
        }
        return true;
    }
}
