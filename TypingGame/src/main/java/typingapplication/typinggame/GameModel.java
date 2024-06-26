package typingapplication.typinggame;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Integer.parseInt;

public class GameModel {
    public static String getRandomWord() {
        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\Khizer Projects (CPP)\\Java OOP\\TypingGame\\src\\main\\resources\\typingapplication\\typinggame\\words_alpha.txt", "r");
            Random rand = new Random();
            int randInt = rand.nextInt(3864812);
            raf.seek(randInt);
            int x = 0;
            String line = raf.readLine();
            int lenVar = line.length();
            while (lenVar >= 1) {
                raf.seek(randInt + x);
                line = raf.readLine();
                lenVar = line.length();
                x++;
            }
            return raf.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("FNFException" + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException" + e);
            e.printStackTrace();
        }
        return "";
    }
}

