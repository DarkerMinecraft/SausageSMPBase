package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Main;

import java.io.File;
import java.io.IOException;

public class ConfigUtils {

    private static Main plugin;

    public static void setupConfigUtils(Main plugin) {ConfigUtils.plugin = plugin;}

    public static FileConfiguration getConfig(String configName) {
        File customConfigFile = new File(plugin.getDataFolder(), configName);
        if(!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            plugin.saveResource(configName, false);
        }

        YamlConfiguration customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
            return null;
        }

        return customConfig;
    }

    public static void saveConfig(FileConfiguration config, String file) throws IOException {
        File configFile = new File(plugin.getDataFolder(), file);
        if(!configFile.exists()) {
            if(!configFile.createNewFile()) return;
        }

        config.save(configFile);
    }

}
