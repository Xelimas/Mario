package affichage;

public class CompteARebours implements Runnable {

    private final int PAUSE = 1000;
    private int compteurTemps;
    private String str;

    public CompteARebours() {
        this.compteurTemps = 100;
        this.str = "temps restant : 100";

        Thread compteARebours = new Thread(this);
        compteARebours.start();
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {}
            this.compteurTemps--;
            this.str = "Temps restant : " + this.compteurTemps;
        }

    }

    /**
     * @return int return the compteurTemps
     */
    public int getCompteurTemps() {
        return compteurTemps;
    }

    /**
     * @return String return the str
     */
    public String getStr() {
        return str;
    }

}