package me.daqem.rightclickfarming;

import me.daqem.rightclickfarming.listeners.PlayerInteractListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class RightClickFarming extends JavaPlugin {

    private static RightClickFarming instance;

    @Override
    public void onEnable() {
        registerEvents();
        loadConfig();
        instance = this;
    }

    public static RightClickFarming getInstance() {
        return instance;
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
    }

    public void loadConfig() {
        final FileConfiguration config = this.getConfig();

        config.options().copyDefaults(true);
        saveConfig();
        System.out.println("[RightClickFarming] Loaded config");
    }
}
