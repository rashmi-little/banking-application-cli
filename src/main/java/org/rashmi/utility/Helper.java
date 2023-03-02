package org.rashmi.utility;

import java.util.Random;

public class Helper {
    public static final String PREFIX = "-".repeat(4);

    private Helper() {
    }

    public static String getRandomNumber(int range) {
        String characters = "0123456789";
        Random random = new Random();
        String result = "";

        for (int i = 0; i < range; i++) {
            int position = random.nextInt(characters.length());
            result += characters.charAt(position);
        }

        return result;
    }

    public static void logMessage(String message) {
        System.out.println(message);
    }
}
