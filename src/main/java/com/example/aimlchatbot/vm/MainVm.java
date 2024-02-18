package com.example.aimlchatbot.vm;

import com.example.aimlchatbot.model.ChatMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicStrings;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Main view model.
 *
 * @author yann39
 * @since 0.0.1
 */
@Slf4j
public class MainVm {

    private static final String BOT_NAME = "super";

    private Chat chat;

    @Getter
    private final List<ChatMessage> messages = new ArrayList<>();

    @Getter
    @Setter
    private String inputValue;

    @Init
    public void init() {
        log.info("Using bot {}", BOT_NAME);

        final String res = getResourcesPath();

        final Bot bot = new Bot(BOT_NAME, res);
        chat = new Chat(bot);
        bot.brain.nodeStats();

        final ChatMessage chatMessageBot = new ChatMessage();
        chatMessageBot.setFrom("Bot");
        if (BOT_NAME.equalsIgnoreCase("custom")) {
            chatMessageBot.setMessage("Bonjour, comment puis-je vous aider ?");
        } else {
            chatMessageBot.setMessage("Hi !");
        }
        chatMessageBot.setSentOn(LocalDateTime.now());
        messages.add(chatMessageBot);
    }

    @Command
    @NotifyChange({"messages", "inputValue"})
    public String sendMessage() {

        log.info("You : {}", inputValue);
        final ChatMessage chatMessageUser = new ChatMessage();
        chatMessageUser.setFrom("You");
        chatMessageUser.setMessage(inputValue);
        chatMessageUser.setSentOn(LocalDateTime.now());
        messages.add(chatMessageUser);

        String textLine = MagicStrings.null_input;
        if (inputValue != null && !inputValue.isEmpty()) {
            textLine = inputValue;
        }

        final String response = chat.multisentenceRespond(textLine);

        log.info("Bot : {}", response);

        final ChatMessage chatMessageBot = new ChatMessage();
        chatMessageBot.setFrom("Bot");
        chatMessageBot.setMessage(response);
        chatMessageBot.setSentOn(LocalDateTime.now());
        messages.add(chatMessageBot);

        inputValue = null;

        return response;
    }

    private String getResourcesPath() {
        final File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        return path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    }

}
