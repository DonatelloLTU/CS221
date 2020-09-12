import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.net.URL;
import java.io.File;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class Card here.
 *
 * @author Donatas Vasauskas
 * @version 2020.09.06-01
 */
public class Card {

    int suit;
    int value;
    private static String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    private static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "A"};

    boolean visible = false;

    /**
     * Constructor for objects of class Card
     */
    public Card(int suit, int value, boolean visible) {


    }
    public String getCard()
    {

    }
}