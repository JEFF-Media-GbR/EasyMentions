package com.jeff_media.easymentions;

import com.jeff_media.jefflib.data.Config;
import lombok.Getter;

import javax.annotation.Nonnull;

public class MainConfig extends Config {

    @Getter private final String prefix = getString("prefix", "@");
    @Getter private final boolean exactNames = getBoolean("exact-names");
    @Getter private final String mentionFormat = getString("mention-format", "&7[&b{displayname}&7]");

    public MainConfig() {
        super("config.yml");
    }
}
