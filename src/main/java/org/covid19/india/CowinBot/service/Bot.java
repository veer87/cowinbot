package org.covid19.india.CowinBot.service;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;
import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot {
    /**
     * Method for receiving messages.
     * @param update Contains a message from the user.
     */

    private static String TOKEN = "1634232499:AAFedEHYuq3gUMB_MNESCD5ObXar2OZDzsY";
    private static String USERNAME = "Cowin19bot";


    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            String message = update.getMessage().getText();
            sendMsg(update.getMessage().getChatId().toString(), message);
        }
    }

    /**
     * Method for creating a message and sending it.
     * @param chatId chat id
     * @param s The String that you want to send as a message.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
          // LOGGER.debug(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("++++++++++++++ " + update);
    }

    /**
     * This method returns the bot's name, which was specified during registration.
     * @return bot name
     */
    @Override
    public String getBotUsername() {
        return USERNAME;
    }
    /**
     * This method returns the bot's token for communicating with the Telegram server
     * @return the bot's token
     */
    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onClosing() {

    }
}
