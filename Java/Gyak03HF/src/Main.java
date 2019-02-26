import Szepsegverseny.ReadFile;
import Szepsegverseny.Versenyzok;

// Feladat:
// "Szépségverseny pontszám számító app",
// Versenyzők: Név, életkor, szépségpont, skillpont.
// Szépségpont = kor * szepsegpont
// Skillpont = (Max kor - kor) * skillpont
// Összpontszám = szépségpont + skillpont

// + saját kiegészítés
// .txt fájlból való beolvasás.
// 16 éves kor alatt és 25 felett diszkvalifikáció.
// Mátrix szerű kiiratás.

public class Main {

    //VersenyzokData.txt elérését be kell állítani.
    private static final String FILE_NAME = "E:\\Java Projects\\Gyak03HF\\VersenyzokData.txt";
    private static final int VERSENYZOK_COUNT = ReadFile.getVersenyzokCount();
    private static Versenyzok[] versenyzok;

    public static void main(String[] args) {
        ReadFile.readFileByLine(FILE_NAME, versenyzok);

        versenyzok = new Versenyzok[VERSENYZOK_COUNT];

        for (int i = 0; i < versenyzok.length; i++) {
            versenyzok[i].setPontszam(Versenyzok.calculatePoints(versenyzok[i]));
        }

        Versenyzok.printVersenyzok(versenyzok);

        System.out.println("------------------ Rendezés után -------------------");

        Versenyzok.sortVersenyzok(versenyzok);
        Versenyzok.printVersenyzok(versenyzok);
    }
}
