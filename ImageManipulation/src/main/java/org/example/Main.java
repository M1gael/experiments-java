package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        UI userInterface = new UI();
        Picture myPicture = new Picture(); //instanced all objects

        String imgPath = "/home/debbie/gitdir/Java-Projects/ImageManipulation/src/main/java/org/example/image.png"; // Default value

        do {
            //User chooses a file for the next loop
            imgPath = userInterface.chooseFile();
            userInterface.loadIcon(myPicture.setImage(imgPath)); // Invoke methods from both classes to buffer image and then store it

            // User controls loop
            System.out.println("Would you like to display another image ? y/n :");

        } while (kb.nextLine().equalsIgnoreCase("y"));
        kb.close();
        userInterface.dispose();
        System.exit(0); //properly end instances
    }
}