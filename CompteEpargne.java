public class CompteEpargne extends Compte {

    private double tauxInteret;

    public CompteEpargne(int id, String proprietaire, double solde, double tauxInteret) {
        super(id, proprietaire, solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculerInterets() throws MontantNonValideException {
        double interets = getSolde() * tauxInteret / 100;
        deposer(interets);
    }
}
