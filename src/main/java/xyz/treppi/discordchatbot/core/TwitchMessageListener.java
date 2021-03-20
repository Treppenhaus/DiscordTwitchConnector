package xyz.treppi.discordchatbot.core;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

public class TwitchMessageListener {

    public TwitchMessageListener(SimpleEventHandler eventHandler) {
        eventHandler.onEvent(ChannelMessageEvent.class, event -> onChannelMessage(event));
    }

    public void onChannelMessage(ChannelMessageEvent event) {
        String user = event.getUser().getName();
        String message = event.getMessage();

        if(user.equalsIgnoreCase(Main.name)) return;
        if(message.startsWith("!")) return;

        String msg = "**Twitch | "+user+": ** " + message;
        Main.sendDiscordMessage(msg);

        System.out.println("Twitch -> Discord [" + user + "]: " + message);
    }
}
