package affichage;

public class Score {
    
    private final int NBRE_TOTAL_PIECEs = 10;
    private int nbrePieces;

    public Score() {
        this.nbrePieces = 0;
    }

    public int getNbrePiece() {
        return nbrePieces;
    }

    public int getNBRE_TOTAL_PIECES() {
        return NBRE_TOTAL_PIECEs;
    }

    public void setNbrePieces(int nbrePieces) {
        this.nbrePieces = nbrePieces;
    }

}