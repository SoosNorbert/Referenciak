package Szepsegverseny;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private static int versenyzokCount = 0;

    public static int getVersenyzokCount() {
        return versenyzokCount;
    }

    public static void readFileByLine(String filePath, Versenyzok[] versenyzok) {
        BufferedReader reader;
        int i = 0;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",", 4);

                Versenyzok versenyzo = new Versenyzok();

                if (Integer.parseInt(data[1]) >= Versenyzok.MAX_KOR || Integer.parseInt(data[1]) < 16)
                    versenyzo.setNev(data[0] + "-DQ");
                else
                    versenyzo.setNev(data[0]);

                versenyzo.setKor(Integer.parseInt(data[1]));
                versenyzo.setSzepsegPont(Integer.parseInt(data[2]));
                versenyzo.setSkillpont((Integer.parseInt(data[3])));

                versenyzokCount++;
                versenyzok[i++] = versenyzo;

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
