package Szepsegverseny;

public class Versenyzok {

    public static final int MAX_KOR = 25;
    public static final int MIN_KOR = 16;

    private String nev;
    private int kor;
    private int szepsegPont;
    private int skillpont;
    private double pontszam;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        if (kor > 15)
            this.kor = kor;
        else
            System.out.println("Csak 16 életévet betöltött versenyző vehet részt!");
    }

    public int getSzepsegPont() {
        return szepsegPont;
    }

    public void setSzepsegPont(int szepsegPont) {
        if (szepsegPont > 0)
            this.szepsegPont = szepsegPont;
        else
            System.out.println("Csak nullánál nagyobb értékű szépségpont adható!");
    }

    public int getSkillpont() {
        return skillpont;
    }

    public void setSkillpont(int skillpont) {
        if (skillpont >= 0)
            this.skillpont = skillpont;
        else
            System.out.println("Nem lehet negatív értékű skillpont!");
    }

    public double getPontszam() {
        return pontszam;
    }

    public void setPontszam(double pontszam) {
        this.pontszam = pontszam;
    }

    public static void sortVersenyzok(Versenyzok[] versenyzok) {
        for (int i = 0; i < versenyzok.length; i++) {
            for (int j = 0; j < versenyzok.length; j++) {
                if (versenyzok[i].getPontszam() > versenyzok[j].getPontszam()) {
                    Versenyzok tempVersenyzo = new Versenyzok();
                    tempVersenyzo = versenyzok[i];
                    versenyzok[i] = versenyzok[j];
                    versenyzok[j] = tempVersenyzo;
                }
            }
        }
    }

    public static void printVersenyzok(Versenyzok[] versenyzok) {
        System.out.println("Név\t\t\tKor\t\tSzépség pont\tSkill pont\t\tÖssz pontszám");
        for (int i = 0; i < versenyzok.length; i++) {
            System.out.println(
                    versenyzok[i].getNev() + "\t\t" +
                    versenyzok[i].getKor() + "\t\t" +
                    versenyzok[i].getSzepsegPont() + "\t\t\t\t" +
                    versenyzok[i].getSkillpont() + "\t\t\t\t" +
                    versenyzok[i].getPontszam()
            );
        }
    }

    public static double calculatePoints(Versenyzok versenyzo) {
        double szepPoints = versenyzo.kor * versenyzo.szepsegPont;
        double skillPoints = (MAX_KOR - versenyzo.kor) * versenyzo.skillpont;
        double SzumPoints = szepPoints + skillPoints;

        return SzumPoints;
    }
}
