package org.covid19.india.CowinBot.service;

import org.covid19.india.CowinBot.utils.BotUtils;
import org.covid19.india.CowinBot.utils.CowinApiUtils;
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
    private static String HELP = "HELP";
    private static String SLOTS = "SLOT";

    private static String DEFAULT_MESSAGE = "Sorry, unable to understand.\n" +
                                                    "for more info type HELP";




    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            String message = update.getMessage().getText();
            String[] tokens = message.split(" ");

            String query = tokens[0];


            String response = DEFAULT_MESSAGE;

            if (query.equalsIgnoreCase(HELP)) {
                //TODO return menu card
                response = BotUtils.getMenuCard();
            } else if (query.equalsIgnoreCase(SLOTS)) {
                //TODO call slots query
                if (BotUtils.isValidParams(tokens)) {
                    response = CowinApiUtils.callCowinQueryApi(tokens);
                    if (response == null) {
                        response = DEFAULT_MESSAGE;
                        // log the query which is failed
                    }
                }
            }


            //System.out.println("++ onUpdatesReceived +++ " + update );
            sendMsg(update.getMessage().getChatId().toString(), response);
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
