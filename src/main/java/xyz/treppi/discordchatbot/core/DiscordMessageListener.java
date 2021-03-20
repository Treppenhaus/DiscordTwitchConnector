package xyz.treppi.discordchatbot.core;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordMessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        User author = e.getAuthor();
        Guild g = e.getGuild();
        TextChannel tc = e.getTextChannel();
        Message m = e.getMessage();

        // ignore own messages
        if(author.getId().equalsIgnoreCase(Main.getJDA().getSelfUser().getId())) return;

        if(g.getId().equalsIgnoreCase(Main.guildID) && tc.getId().equalsIgnoreCase(Main.channelID)) {

            //send message to twitch
            String message = "Discord | " + author.getName() + ": " + translatePings(m);
            System.out.println("Discord -> Twitch ["+author.getName()+"]: "+translatePings(m));
            Main.sendTwitchMessage(message);
        }
    }

    private static String translatePings(Message m) {
        String message = m.getContentDisplay();
        return message;
    }
}
