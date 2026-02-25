

            // Test du compte épargne
            ComteEpargne compteEpargne = new ComteEpargne(3, "Charlie", 1500.0, 5.0); // Crée un compte épargne avec un
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

    static void insertTest() {
        Connection c = null;
        PreparedStatement prepSt = null;
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String usr = "postgres";
        String pwd = "postgres";

        try {
            // Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usr, pwd);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            prepSt = c.prepareStatement("INSERT INTO TEST (NOM) VALUES (?)");

            prepSt.setString(1, "Salah");

            prepSt.executeUpdate();

            prepSt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}