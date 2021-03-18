package com.meekapoo.playerdatarestorer;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerdataRestorer extends JavaPlugin {

    public static JavaPlugin pl;

    @Override
    public void onEnable() {
        // Plugin startup logic
        pl = this;
        this.getServer().getPluginManager().registerEvents(new RecordPlayerUUID(), this);
        this.getCommand("pd").setExecutor(new QuickRestore());
        this.getCommand("pd").setTabCompleter(new QuickRestoreTabCompleter());
        UUIDManager.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
