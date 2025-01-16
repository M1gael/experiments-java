package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner kb;
    private static UI userInterface;
    public static Picture myPicture; // Reserve objects to use in class methods

    public static void main(String[] args) throws IOException {

        kb = new Scanner(System.in);
        userInterface = new UI();
        myPicture = new Picture(); //instanced all objects

        String imgPath = "/home/debbie/gitdir/Java-Projects/ImageManipulation/src/main/java/org/example/image.png"; // A
        //setPath(imgPath); // A , sets defaults at startup
        userInterface.loadIcon(myPicture.setImage(imgPath)); // Invoke methods from both classes to buffer image and then store it
        do {
            setPath(userInterface.chooseFile()); // Set path as what user chooses
            System.out.print("Would you like to display another image ? y/n :"); // Loop

        } while (kb.nextLine().equalsIgnoreCase("y")); // broken loop
    }

    private static void setPath(String imgPath) throws IOException{

    }
}