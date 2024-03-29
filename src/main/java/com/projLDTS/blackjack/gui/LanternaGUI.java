package com.projLDTS.blackjack.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.projLDTS.blackjack.model.game.Cards.Card;
import com.projLDTS.blackjack.model.game.Cards.Hand;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class LanternaGUI {
    private Screen screen;
    private TerminalSize size;
    private TextGraphics textGraphics;
    TextColor buttonColor = TextColor.Factory.fromString("#727272");
    TextColor selectedColor = TextColor.Factory.fromString("#03C04A");

    public LanternaGUI(DefaultTerminalFactory dtf) throws IOException, FontFormatException, URISyntaxException {

        size = new TerminalSize(130, 40);
        URL fontResource = getClass().getClassLoader().getResource("CARDC___.TTF");
        File fontFile = new File(Objects.requireNonNull(fontResource).toURI());
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);

        Font loadedFont = customFont.deriveFont(Font.PLAIN, 15);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = dtf.setInitialTerminalSize(size).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        textGraphics = newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), size, ' ');
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#03C04A"));

        screen.refresh();
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {

        size = new TerminalSize(width, height);
        URL fontResource = getClass().getClassLoader().getResource("CARDC___.TTF");
        File fontFile = new File(Objects.requireNonNull(fontResource).toURI());
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);

        Font loadedFont = customFont.deriveFont(Font.PLAIN, 15);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setForceAWTOverSwing(true);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = factory.setInitialTerminalSize(size).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        textGraphics = newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), size, ' ');
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#03C04A"));

        screen.refresh();
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void drawBlackjack() throws IOException {
        textGraphics.putString(new TerminalPosition(24, 5), "BB          BB                       BB        BB                       BB         \n");
        textGraphics.putString(new TerminalPosition(24, 6), "BB          BB                       BB        \"\"                       BB         \n");
        textGraphics.putString(new TerminalPosition(24, 7), "BB          BB                       BB                                 BB         \n");
        textGraphics.putString(new TerminalPosition(24, 8), "BB,dPPYba,  BB ,adPPYYba,  ,adPPYba, BB   ,dB  BB ,adPPYYba,  ,adPPYba, BB   ,dB   \n");
        textGraphics.putString(new TerminalPosition(24, 9), "BBP'    \"Ba BB \"\"     `YB aB\"     \"\" BB ,aB'   BB \"\"     `YB aB\"     \"\" BB ,aB\"    \n");
        textGraphics.putString(new TerminalPosition(24, 10), "BB       dB BB ,adPPPPPBB Bb         BBBB[     BB ,adPPPPPBB Bb         BBBB[      \n");
        textGraphics.putString(new TerminalPosition(24, 11), "BBb,   ,aB\" BB BB,    ,BB \"Ba,   ,aa BB`\"Yba,  BB BB,    ,BB \"Ba,   ,aa BB`\"Yba,   \n");
        textGraphics.putString(new TerminalPosition(24, 12), "BY\"YbbdB\"'  BB `\"BbbdP\"YB  `\"YbbdB\"' BB   `YBa BB `\"BbbdP\"YB  `\"YbbdB\"' BB   `YBa  \n");
        textGraphics.putString(new TerminalPosition(24, 13), "                                              ,BB                                  \n");
        textGraphics.putString(new TerminalPosition(24, 14), "                                            BBBP\"\n");
        screen.refresh();
    }

    public void drawHowToPlay() {
        textGraphics.putString(new TerminalPosition(9, 5), "BB        BB                                   BBBBBBBBBBBB              BBBBBBBBba  BB                         \n");
        textGraphics.putString(new TerminalPosition(9, 6), "BB        BB                                        BB                   BB      \"Bb BB                         \n");
        textGraphics.putString(new TerminalPosition(9, 7), "BB        BB                                        BB                   BB      ,BP BB                         \n");
        textGraphics.putString(new TerminalPosition(9, 8), "BBaaaaaaaaBB  ,adPPYba,  Bb      db      dB         BB  ,adPPYba,        BBaaaaaaBP' BB ,adPPYYba, Bb       dB  \n");
        textGraphics.putString(new TerminalPosition(9, 9), "BB\"\"\"\"\"\"\"\"BB aB\"     \"Ba `Bb    dBBb    dB'         BB aB\"     \"Ba       BB\"\"\"\"\"\"'   BB \"\"     `YB `Bb     dB'  \n");
        textGraphics.putString(new TerminalPosition(9, 10), "BB        BB Bb       dB  `Bb  dB'`Bb  dB'          BB Bb       dB       BB          BB ,adPPPPPBB  `Bb   dB'   \n");
        textGraphics.putString(new TerminalPosition(9, 11), "BB        BB \"Ba,   ,aB\"   `BbdB'  `BbdB'           BB \"Ba,   ,aB\"       BB          BB BB,    ,BB   `Bb,dB'    \n");
        textGraphics.putString(new TerminalPosition(9, 12), "BB        BB  `\"YbbdP\"'      YP      YP             BB  `\"YbbdP\"'        BB          BB `\"BbbdP\"YB     YBB'     \n");
        textGraphics.putString(new TerminalPosition(9, 13), "                                                                                                       dB'      \n");
        textGraphics.putString(new TerminalPosition(9, 14), "                                                                                                      dB'       ");
    }

    public void drawGetUsername(StringBuilder username) {
        textGraphics.putString(new TerminalPosition(46, 17), "Insert your username: (Max 20 characters)\n");

        int maxUsernameLength = 20;

        int boxWidth = 22;
        int boxHeight = 3;
        int x = 48 + 5 + 2;
        int y = 19;

        String truncatedUsername = username.toString();
        if (truncatedUsername.length() > maxUsernameLength) {
            truncatedUsername = truncatedUsername.substring(0, maxUsernameLength);
        }
        int usernameX = x + (boxWidth - truncatedUsername.length()) / 2;
        int usernameY = y + boxHeight / 2;
        textGraphics.putString(new TerminalPosition(usernameX, usernameY), truncatedUsername);

        drawBox(x, y, boxWidth, boxHeight, TextColor.Factory.fromString("#727272"));

    }

    public void drawBox(int x, int y, int width, int height, TextColor borderColor) {
        for (int i = 0; i < width; i++) {
            textGraphics.setForegroundColor(borderColor);
            textGraphics.setCharacter(x + i, y, '-');
            textGraphics.setCharacter(x + i, y + height - 1, '-');
        }
        for (int i = 1; i < height - 1; i++) {
            textGraphics.setForegroundColor(borderColor);
            textGraphics.setCharacter(x, y + i, '|');
            textGraphics.setCharacter(x + width - 1, y + i, '|');
        }
    }

    public void drawExitButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(50, 29), new TerminalSize(30, 3), ' ');
        textGraphics.putString(new TerminalPosition(63, 30), "EXIT");
    }

    public void drawStartButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(50, 21),new TerminalSize(30, 3),' ');
        textGraphics.putString(new TerminalPosition(63, 22), "START");
    }

    public void drawHowToPlayButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(50, 25), new TerminalSize(30, 3), ' ');
        textGraphics.putString(new TerminalPosition(60, 26), "HOW TO PLAY");
    }

    public void drawLast10GamesButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(112, 35), new TerminalSize(16, 3), ' ');
        textGraphics.putString(new TerminalPosition(115, 36), "LAST GAMES");
    }

    public void drawbReturnButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(35, 24), new TerminalSize(14, 3), ' ');
        textGraphics.putString(new TerminalPosition(39, 25), "RETURN");
    }

    public void drawPlayButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(83, 24), new TerminalSize(12, 3), ' ');
        textGraphics.putString(new TerminalPosition(87, 25), "PLAY");
    }

    public void drawYesButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(29, 27), new TerminalSize(15, 3), ' ');
        textGraphics.putString(new TerminalPosition(35, 28), "YES");
    }

    public void drawNoButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(85, 27), new TerminalSize(15, 3), ' ');
        textGraphics.putString(new TerminalPosition(91, 28), "NO");
    }

    public void drawRet1() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(9, 33), new TerminalSize(50, 3), ' ');
        textGraphics.putString(new TerminalPosition(30, 34), "RETURN");
    }

    public void drawNext() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(70, 33), new TerminalSize(50, 3), ' ');
        textGraphics.putString(new TerminalPosition(94, 34), "-->");
    }

    public void drawPrevious() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(9, 33), new TerminalSize(50, 3), ' ');
        textGraphics.putString(new TerminalPosition(30, 34), "<--");
    }

    public void drawRet2() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(70, 33), new TerminalSize(50, 3), ' ');
        textGraphics.putString(new TerminalPosition(94, 34), "RETURN");
    }

    public void drawHowToPlayPage1() {
        drawHowToPlay();
        textGraphics.putString(new TerminalPosition(9, 18), "1. **Objective:**\n");
        textGraphics.putString(new TerminalPosition(9, 20), "   The goal of Blackjack is to beat the dealer by having a hand value");
        textGraphics.putString(new TerminalPosition(9, 22), "2. **Card Values:**\n");
        textGraphics.putString(new TerminalPosition(9, 24), "   - Number cards (2-10) are worth their face value.\n");
        textGraphics.putString(new TerminalPosition(9, 25), "   - Face cards (Jack, Queen, King) are each worth 10.");
        textGraphics.putString(new TerminalPosition(9, 26), "   - Aces can be worth 1 or 11, depending on which value benefits the hand more.\n");
        textGraphics.putString(new TerminalPosition(63, 30), "1/4");
    }

    public void drawHowToPlayPage2() {
        drawHowToPlay();
        textGraphics.putString(new TerminalPosition(9, 18), "3. **Game Flow:**\n");
        textGraphics.putString(new TerminalPosition(9, 20), "   - Each player, including the dealer, is dealt two cards.\n");
        textGraphics.putString(new TerminalPosition(9, 21), "   - Players can 'Hit' to receive additional cards or 'Stand' to keep their current hand.\n");
        textGraphics.putString(new TerminalPosition(9, 22), "   - If the total value of a player's cards exceeds 21, they bust and lose the round.\n");
        textGraphics.putString(new TerminalPosition(9, 24), "4. **Winning:**\n");
        textGraphics.putString(new TerminalPosition(9, 26), "   - If a player's total is closer to 21 than the dealer's, they win.\n");
        textGraphics.putString(new TerminalPosition(9, 27), "   - If the dealer busts and the player doesn't, the player wins.\n");
        textGraphics.putString(new TerminalPosition(9, 28), "   - If both the player and dealer have the same total, it's a draw (no one wins or loses).\n");
        textGraphics.putString(new TerminalPosition(63, 30), "2/4");
    }

    public void drawHowToPlayPage3() {
        drawHowToPlay();
        textGraphics.putString(new TerminalPosition(9, 18), "5. **Special Moves:**\n");
        textGraphics.putString(new TerminalPosition(9, 20), "   - **Double Down:** Double your original bet and receive only one additional card.\n");
        textGraphics.putString(new TerminalPosition(9, 22), "6. **Blackjack:**\n");
        textGraphics.putString(new TerminalPosition(9, 24), "   - A \"Blackjack\" is an Ace and a 10-value card.\n");
        textGraphics.putString(new TerminalPosition(63, 30), "3/4");
    }

    public void drawHowToPlayPage4() {
        drawHowToPlay();
        textGraphics.putString(new TerminalPosition(9, 18), "7. **Tips:**\n");
        textGraphics.putString(new TerminalPosition(9, 20), "   - Pay attention to the dealer's upcard and adjust your strategy accordingly.\n");
        textGraphics.putString(new TerminalPosition(9, 21), "   - Practice basic strategy to maximize your chances of winning.\n");
        textGraphics.putString(new TerminalPosition(9, 23), "8. **Have Fun and Good Luck!**\n");
        textGraphics.putString(new TerminalPosition(63, 30), "4/4");
    }

    public void drawOneButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(29, 27), new TerminalSize(20, 3), ' ');
        textGraphics.putString(new TerminalPosition(35, 28), "One Deck");
    }

    public void drawTwoButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(53, 27), new TerminalSize(21, 3), ' ');
        textGraphics.putString(new TerminalPosition(59, 28), "Two Decks");
    }

    public void drawInfButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(79, 27), new TerminalSize(21, 3), ' ');
        textGraphics.putString(new TerminalPosition(86, 28), "Infinite");
    }

    public void drawRetDecks(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(57, 34), new TerminalSize(14, 3), ' ');
        textGraphics.putString(new TerminalPosition(61, 35), "RETURN");
    }

    public void clear() throws IOException {
        screen.clear();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), size, ' ');
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        refresh();
    }

    public void close() throws IOException {
        screen.close();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public TextGraphics newTextGraphics() {
        return this.screen.newTextGraphics();
    }

    public void drawExitQ() throws IOException {
        drawBlackjack();
        textGraphics.putString(new TerminalPosition(52, 22), "Are you sure you want to");
        textGraphics.putString(new TerminalPosition(58, 23), "leave the game?");
    }

    public void drawDecksText() throws IOException {
        drawBlackjack();
        textGraphics.putString(new TerminalPosition(52, 22), "How many decks of cards?");
    }

    public void drawLast10GamesText() {
        textGraphics.putString(new TerminalPosition(7, 3), "88                                        ");
        textGraphics.putString(new TerminalPosition(7, 4), "88                                 ,d     ");
        textGraphics.putString(new TerminalPosition(7, 5), "88                                 ,d     ");
        textGraphics.putString(new TerminalPosition(7, 6), "88          ,adPPYYba, ,adPPYba, MM88MMM  ");
        textGraphics.putString(new TerminalPosition(7, 7), "88          \"\"     `Y8 I8[    \"\"   88    ");
        textGraphics.putString(new TerminalPosition(7, 8), "88          ,adPPPPP88  `\"Y8ba,    88   ");
        textGraphics.putString(new TerminalPosition(7, 9), "88          88,    ,88 aa    ]8I   88,    ");
        textGraphics.putString(new TerminalPosition(7, 10), "88888888888 `\"8bbdP\"Y8 `\"YbbdP\"'   \"Y888  ");

        textGraphics.putString(new TerminalPosition(7, 13), "    88    ,a8888a,     ");
        textGraphics.putString(new TerminalPosition(7, 14), "  ,d88  ,8P\"'  `\"Y8,   ");
        textGraphics.putString(new TerminalPosition(7, 15), "888888 ,8P        Y8,  ");
        textGraphics.putString(new TerminalPosition(7, 16), "    88 88          88  ");
        textGraphics.putString(new TerminalPosition(7, 17), "    88 88          88  ");
        textGraphics.putString(new TerminalPosition(7, 18), "    88 `8b        d8'  ");
        textGraphics.putString(new TerminalPosition(7, 19), "    88  `8ba,  ,ad8'   ");
        textGraphics.putString(new TerminalPosition(7, 20), "    88    \"Y8888P\"     ");

        textGraphics.putString(new TerminalPosition(7, 23), "  ,ad8888ba,                                                      ");
        textGraphics.putString(new TerminalPosition(7, 24), " d8\"'    `\"8b                                                     ");
        textGraphics.putString(new TerminalPosition(7, 25), "d8'                                                               ");
        textGraphics.putString(new TerminalPosition(7, 26), "88            ,adPPYYba, 88,dPYba,,adPYba,   ,adPPYba, ,adPPYba,  ");
        textGraphics.putString(new TerminalPosition(7, 27), "88      88888 \"\"     `Y8 88P'   \"88\"    \"8a a8P     88 I8[    \"\"  ");
        textGraphics.putString(new TerminalPosition(7, 28), "Y8,        88 ,adPPPPP88 88      88      88 8PP\"\"\"\"\"\"\"  `\"Y8ba,   ");
        textGraphics.putString(new TerminalPosition(7, 29), " Y8a.    .a88 88,    ,88 88      88      88 \"8b,   ,aa aa    ]8I  ");
        textGraphics.putString(new TerminalPosition(7, 30), "  `\"Y88888P\"  `\"8bbdP\"Y8 88      88      88  `\"Ybbd8\"' `\"YbbdP\"'  ");
    }

    public void drawCredit() {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.putString(new TerminalPosition(61, 5), "credit");
        int a = UserInput.getCredit();
        textGraphics.putString(new TerminalPosition(62, 6), String.valueOf(a));
    }

    public void drawLine() {
        textGraphics.putString(new TerminalPosition(40, 20), "--------------------------------------------------");
    }

    public void drawBet() {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.putString(new TerminalPosition(62, 32), "bet");
        int boxWidth = 7;
        int boxHeight = 3;
        int x = 60;
        int y = 33;
        textGraphics.putString(new TerminalPosition(61, 34), UserInput.getBet().toString());
        drawBox(x, y, boxWidth, boxHeight, TextColor.Factory.fromString("#727272"));
    }

    public void drawHitButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(43, 31), new TerminalSize(14, 3), ' ');
        textGraphics.putString(new TerminalPosition(48, 32), "HIT");
    }

    public void drawStandButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(70, 31), new TerminalSize(14, 7), ' ');
        textGraphics.putString(new TerminalPosition(74, 34), "STAND");
    }

    public void drawDoubleDownButton(boolean selected) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (selected) textGraphics.setBackgroundColor(selectedColor);
        else textGraphics.setBackgroundColor(buttonColor);
        textGraphics.fillRectangle(new TerminalPosition(43, 35), new TerminalSize(14, 3), ' ');
        textGraphics.putString(new TerminalPosition(44, 36), "DOUBLE DOWN");
    }

    public void drawExit() {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.putString(new TerminalPosition(85, 2), "Return to Main Menu: E");
    }

    public void drawPlayerLost() {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.fillRectangle(new TerminalPosition(2, 15), new TerminalSize(126, 10), ' ');
        textGraphics.putString(new TerminalPosition(65, 18), "YOU LOST");
        textGraphics.putString(new TerminalPosition(50, 20), "DO YOU WANT TO KEEP PLAYING? Y/N");
    }

    public void drawPlayerWon() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(selectedColor);
        textGraphics.fillRectangle(new TerminalPosition(2, 15), new TerminalSize(126, 10), ' ');
        textGraphics.putString(new TerminalPosition(65, 18), "YOU WON");
        textGraphics.putString(new TerminalPosition(50, 20), "DO YOU WANT TO KEEP PLAYING? Y/N");
    }

    public void drawPlayDraw() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(selectedColor);
        textGraphics.fillRectangle(new TerminalPosition(2, 15), new TerminalSize(126, 10), ' ');
        textGraphics.putString(new TerminalPosition(65, 18), "DRAW");
        textGraphics.putString(new TerminalPosition(50, 20), "DO YOU WANT TO KEEP PLAYING? Y/N");
    }

    public void drawPlayerNoCredit() {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        textGraphics.fillRectangle(new TerminalPosition(2, 15), new TerminalSize(126, 10), ' ');
        textGraphics.putString(new TerminalPosition(50, 18), "YOU LOST. THERE IS NO CREDIT LEFT");
        textGraphics.putString(new TerminalPosition(50, 20), "DO YOU WANT TO PLAY AGAIN? Y/N");
    }

    public void drawCards(Hand hand, int row) {
        int position = 0;
        for (Card card : hand.getHand()) {
            drawCard(card, position, row);
            position += 5;
        }
    }

    public void drawDealerCards(Hand hand, int row) throws InterruptedException {
        int position = 0;
        for (Card card : hand.getHand()) {
            drawCard(card, position, row);
            TimeUnit.MILLISECONDS.sleep(250);
            position += 5;
        }
    }

    public void drawCard(Card card, int position, int row) {
        ArrayList<String> playingCard = card.getPlayingCard();
        if (Objects.equals(card.getSuit(), "Hearts") || Objects.equals(card.getSuit(), "Diamonds"))
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        else textGraphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        for (int i = 0; i < playingCard.size(); i++) {
            textGraphics.putString(new TerminalPosition(40 + position, row + i), playingCard.get(i));
        }
    }


    public void drawDealerPlayerText() {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));

        textGraphics.putString(new TerminalPosition(35, 8), "D");
        textGraphics.putString(new TerminalPosition(35, 10), "E");
        textGraphics.putString(new TerminalPosition(35, 12), "A");
        textGraphics.putString(new TerminalPosition(35, 14), "L");
        textGraphics.putString(new TerminalPosition(35, 16), "E");
        textGraphics.putString(new TerminalPosition(35, 18), "R");

        textGraphics.putString(new TerminalPosition(94, 20), "P");
        textGraphics.putString(new TerminalPosition(94, 22), "L");
        textGraphics.putString(new TerminalPosition(94, 24), "A");
        textGraphics.putString(new TerminalPosition(94, 26), "Y");
        textGraphics.putString(new TerminalPosition(94, 28), "E");
        textGraphics.putString(new TerminalPosition(94, 30), "R");
    }

    public void drawValues(int value, boolean dealer) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if (dealer) textGraphics.putString(new TerminalPosition(90, 14), String.valueOf(value));
        else textGraphics.putString(new TerminalPosition(90, 25), String.valueOf(value));
    }

    public void drawLast10Lines(List<String> last10Lines) {
        int row = 4;
        for (String line : last10Lines) {
            if (line.contains("+")) {
                textGraphics.setForegroundColor(TextColor.Factory.fromString("#00FF00")); // Green for positive values
            } else if (line.contains("-")) {
                textGraphics.setForegroundColor(TextColor.Factory.fromString("#FF0000")); // Red for negative values
            }
            textGraphics.putString(new TerminalPosition(82, row), line);
            row += 3;
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#03C04A"));
        }
    }

    // tests

    public void setScreen(Screen mockScreen) {
        screen = mockScreen;
    }

    public void setTextGraphics(TextGraphics mockTextGraphics) {
        textGraphics = mockTextGraphics;
    }
}
