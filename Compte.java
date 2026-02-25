public class Compte implements Comparable<Compte> {

    private int id;
    private String proprietaire;
    private double solde;

    // Constante pour éviter les valeurs magiques
    private static final double MONTANT_MINIMUM = 0.0;

    // Constructeur avec paramètres
    public Compte(int id, String proprietaire, double solde) {
        this.id = id;
        this.proprietaire = proprietaire;
        this.solde = solde;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public double getSolde() {
        return solde;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    // Méthode deposer
    public void deposer(double montant) throws MontantNonValideException {
        if (montant <= MONTANT_MINIMUM) {
            throw new MontantNonValideException("Montant de dépôt invalide ! Le montant doit être positif.");
        }
        solde += montant;
    }

    // Méthode retirer
    public void retirer(double montant) throws MontantNonValideException {
        if (montant <= MONTANT_MINIMUM) {
            throw new MontantNonValideException("Montant invalide ! Le montant doit être positif.");
        }
        if (montant > solde) {
            throw new MontantNonValideException("Solde insuffisant ! Solde actuel : " + solde);
        }
        solde -= montant;
    }

    // Méthode toString
    @Override
    public String toString() {
        return String.format("Compte [id=%d, proprietaire=%s, solde=%.2f]", id, proprietaire, solde);
    }

    // Méthode compareTo (comparaison par solde)
    @Override
    public int compareTo(Compte other) {
        return Double.compare(this.solde, other.solde);
    }
    
    // Méthode utilitaire pour vérifier si le solde est négatif
    public boolean isSoldeNegatif() {
        return solde < 0;
    }
    
    // Méthode pour transférer de l'argent entre comptes
    public void transfererVers(Compte compteDestinataire, double montant) 
            throws MontantNonValideException {
        this.retirer(montant);
        compteDestinataire.deposer(montant);
    }
}
