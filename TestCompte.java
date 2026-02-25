import java.sql.*;

public class TestCompte {
    public static void main(String[] args) {
        Compte compte1 = new Compte(1, "Anis", 1000.0); // Crée un compte avec un solde initial de 1000.0
        Compte compte2 = new Compte(2, "Mohamed", 500.0); // Crée un compte avec un solde initial de 500.0

        // Afficher les informations des comptes
        System.out.println("Compte 1 :");
        System.out.println("ID : " + compte1.getId());
        System.out.println("Propriétaire : " + compte1.getProprietaire());
        System.out.println("Solde : " + compte1.getSolde());

        System.out.println("\nCompte 2 :");
        System.out.println("ID : " + compte2.getId());
        System.out.println("Propriétaire : " + compte2.getProprietaire());
        System.out.println("Solde : " + compte2.getSolde());

        try {
            // Effectuer des opérations sur les comptes
            compte1.deposer(200.0); // Déposer 200.0 dans le compte1
            compte2.retirer(100.0); // Retirer 100.0 du compte2
            System.out.println("\nBLA BLA BLA");

            // Test du compte épargne
            CompteEpargne compteEpargne = new CompteEpargne(3, "Charlie", 1500.0, 5.0); // Crée un compte épargne avec un
                                                                                      // taux d'intérêt de 5%
            System.out.println(compteEpargne);

        } catch (MontantNonValideException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
        } finally {
            System.out.println("\nOpérations terminées.");
        }

        // Test de la connexion à la base de données
        getCompte();
    }

    static void getCompte() {
        Connection c = null;
        Statement stmt = null;
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String usr = "postgres";
        String pwd = "postgres";

        try {
            c = DriverManager.getConnection(url, usr, pwd);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPTE;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double solde = rs.getDouble("solde");

                System.out.println("ID = " + id);
                System.out.println(" - NAME = " + name);
                System.out.println(" - SOLDE = " + solde);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}

