package com.meekapoo.playerdatarestorer;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class RecordPlayerUUID implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        UUIDManager.playerJoined(event.getPlayer().getName(),event.getPlayer().getUniqueId().toString());
        Bukkit.getLogger().log(new LogRecord(Level.INFO,"UUID of " + event.getPlayer().getName() + " recorded!"));
    }
}
