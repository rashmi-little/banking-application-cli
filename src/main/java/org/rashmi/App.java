package org.rashmi;

import org.rashmi.view.UserInterface;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        new UserInterface().showMenuPage();
    }
}
