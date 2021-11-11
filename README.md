# DiscordTwitchConnector
Simple Java program that connects your live-twitch-chat to a discord channel.f

## how to use:
1. fill out settings.json:
```json
{
  "discord": {
    "guildid": "0000000000000000000",
    "channelid": "0000000000000000000",
    "bot": {
      "token": "your discodr bot token",
      "activity": "listing to stuff rn"
    }
  },
  "twitch": {
    "streamer-name": "lunarbaw",
    "bot": {
      "name": "twitch bot name",
      "acces-token": "twitch access token",
      "streamelements-token": "streamelements access token"
    }
  }
}
```

2. run the java program
3. it should work
