package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);

        String imgPath = "/home/debbie/gitdir/Java-Projects/ImageManipulation/src/main/java/org/example/image.png"; // default
        do {
            setPath(imgPath); // A default image

            System.out.println("Enter the path to your image :");
            imgPath = kb.nextLine();
            setPath(imgPath);

            System.out.print("Would you like to display another image ? y/n :");
        } while (kb.nextLine() == "y"); // broken loop
    }

        private static void setPath(String imgPath) throws IOException{
        Picture newimage = new Picture();
        newimage.setImage(imgPath);
    }
}