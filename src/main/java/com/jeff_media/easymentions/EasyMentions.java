package com.jeff_media.easymentions;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyMentions extends JavaPlugin {

    @Getter private MainConfig config;

    @Override
    public void onEnable() {
        reload();
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    }

    private void reload() {
        config = new MainConfig();
    }

    public Player getMentionedPlayer(String string) {
        if(config.isExactNames()) {
            return getServer().getPlayerExact(string);
        } else {
            return getServer().getPlayer(string);
        }
    }
}
