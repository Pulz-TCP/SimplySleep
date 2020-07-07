package me.pulz.simplysleep.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class onPhantomSpawn implements Listener {

        @EventHandler(priority = EventPriority.HIGHEST)
        public void onCreatureSpawn (CreatureSpawnEvent e) {
            if(e.getEntityType() == EntityType.PHANTOM && e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL){
                e.setCancelled(true);
            }
        }
}
