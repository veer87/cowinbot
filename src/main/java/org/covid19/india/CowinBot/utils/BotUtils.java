package org.covid19.india.CowinBot.utils;

public class BotUtils {
    private static String MENU_CARD = "1. Type slot pincode\n"
            + "2. Type slot pincode date(dd-mm-yyyy)\n";

    public static String getMenuCard() {
        return MENU_CARD;
    }

    public static boolean isValidParams(String[] tokens) {
        if (tokens.length <= 1) return false;
        return true;
    }
}
