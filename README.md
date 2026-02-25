# Projet Gestion de Comptes Bancaires (TP Java)

[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.java.com)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14%2B-blue)](https://www.postgresql.org/)

Une application console en Java pour la gestion de comptes bancaires, illustrant les concepts de la Programmation Orientée Objet (POO) : héritage, polymorphisme, encapsulation, gestion des exceptions et connexion à une base de données PostgreSQL via JDBC.

# les Fonctionnalités

*   **Types de comptes** : Compte standard (`Compte`) et Compte Épargne (`CompteEpargne`) avec taux d'intérêt.
*   **Opérations de base** : Dépôt (`deposer()`) et retrait (`retirer()`) avec validation des montants.
*   **Calcul d'intérêts** : Les comptes épargne peuvent calculer et ajouter leurs intérêts au solde.
*   **Gestion des erreurs** : Utilisation d'une exception personnalisée `MontantNonValideException`.
*   **Persistance des données** : Connexion à une base de données PostgreSQL pour afficher la liste des comptes.
*   **Comparaison** : Les comptes sont comparables (`Comparable<Compte>`) basé sur leur solde.

# Structure du Projet
TP-Java/
├── .gitignore
├── README.md
├── src/
│ ├── Compte.java 
│ ├── CompteEpargne.java 
│ ├── MontantNonValideException.java 
│ └── TestCompte.java 
└── lib/ # (Optionnel) Pour les drivers JDBC
└── postgresql-<version>.jar

# 🛠️ Prérequis

Avant de commencer, assurez-vous d'avoir installé :

*   **Java Development Kit (JDK)** : version 8 ou supérieure.
*   **PostgreSQL** : version 10 ou supérieure, avec un serveur en fonctionnement.
*   **Driver JDBC PostgreSQL** : Le fichier JAR (par exemple `postgresql-42.x.x.jar`) à télécharger depuis le [site officiel](https://jdbc.postgresql.org/download/).

## Exemple d'exécution attendu 
Compte 1 :
ID : 1
Propriétaire : Alice
Solde : 1000.0

Compte 2 :
ID : 2
Propriétaire : Bob
Solde : 500.0

BLA BLA BLA
Compte Épargne [ID=3, Proprietaire=Charlie, Solde=1575.0, Taux d'intérêt=5.0%]

Opérations terminées.
Opened database successfully
ID = 1 - NAME = Anis - SOLDE = 1000.0
ID = 2 - NAME = Mohamed - SOLDE = 500.0
Operation done successfully

