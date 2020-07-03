package me.pulz.simplysleep;

import me.pulz.simplysleep.commands.Adddays;
import me.pulz.simplysleep.commands.Sleep;
import me.pulz.simplysleep.commands.Sleeptime;
import me.pulz.simplysleep.events.onBedUse;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplySleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        cmdRegister();
        getServer().getPluginManager().registerEvents(new onBedUse(), this);
        //this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new sleepWarning());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //HandlerList.unregisterAll(new, SleepWarning());
    }

    public void cmdRegister(){
        this.getCommand("sleep").setExecutor(new Sleep(this));
        this.getCommand("sleeptime").setExecutor(new Sleeptime(this));
        this.getCommand("adddays").setExecutor(new Adddays(this));
    }

}