package com.jeff_media.easymentions;

import com.jeff_media.jefflib.VectorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Locale;

public class ChatListener implements Listener {

    private final EasyMentions plugin;

    public ChatListener(EasyMentions plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        String[] words = message.split(" ");
        boolean foundMentions = false;
        for(int index = 0; index < words.length; index++) {
            String word = words[index];
            if (word.toLowerCase(Locale.ROOT).startsWith(plugin.getConfig().getPrefix())) {
                String mentionedName = word.substring(plugin.getConfig().getPrefix().length());
                Player mentioned = plugin.getMentionedPlayer(mentionedName);
                if(mentioned != null) {
                    foundMentions = true;
                }
            }
        }

        if(foundMentions) {
            event.setMessage(String.join(" ", words));
        }
    }
}
