package me.pulz.simplysleep;

import me.pulz.simplysleep.commands.Adddays;
import me.pulz.simplysleep.commands.Sleep;
import me.pulz.simplysleep.commands.Sleeptime;
import me.pulz.simplysleep.events.onBedUse;
import me.pulz.simplysleep.events.onPhantomSpawn;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplySleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        cmdRegister();
        eventRegister();
        this.saveDefaultConfig();
        if(getConfig().getBoolean("features.disable-phantoms")){
            System.out.println("§5[§dSimplySleep§5]§7: Natural Phantom-spawning disabled via config");
        }
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

    public void eventRegister(){
        getServer().getPluginManager().registerEvents(new onBedUse(), this);
        //check if phantom spawn events (natural) should be cancelled
        if(getConfig().getBoolean("features.disable-phantom")) {
            getServer().getPluginManager().registerEvents(new onPhantomSpawn(), this);
        }
    }

}