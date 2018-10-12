package com.enishan;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int choixDuMenu,
                choixRetourAuMenuOuQuitter;

        double
                valeur = 0,                 // Permet de saisir la valeur initiale du compte lors de sa creation
                tauxEpargne = 0.0;          // Permet de saisir le taux d'epargne pour un compte, s'il est de type "epargne"

        Date date;                          // Sera utile dans l'ajout d'une ligne comptable

        String
                numeroDeCompte = "nul" ,     // Permet de creer un compte en saisissant son numero. (exemple : 135.231.67.187C)
                typeDeCompte = "nul",       // Permet de definir si le compte creer est de type "courant" ou "epargne".
                theme,                      // Sera utile pour spécifier de quel genre de paiement il s'agit (exemple : Loyer, Abonnement mobile)
                moyenDePaiement,            // Sera utile pour ajouter une ligne comptable
                verificationNumeroDeCompte; // Afin de tester si le compte saisi existe afin de l'afficher, dans l'option 2.

        boolean verificationCompteEpargne = false,    // Permet de tester le type de compte saisi afin d'affichager les donnes a saisir, AVEC la demande de saisie du taux d'epargne (si TRUE)
                verificationCompteCourant = false,    // Permet de tester le type de compte saisi afin d'affichager les donnes a saisir, SANS la demande de saisie du taux d'epargne (dans tous les cas)
                repeterProgramme = true;

        Scanner lectureClavier = new Scanner(System.in);    //déclaration d'une variable de type objet (String), avec une fonction de lecture de saisie.

        while (repeterProgramme) {

	    /*
	    Après affichage du menu principal, le programme teste la valeur entrée par l'utilisateur et affiche le menu correspondant et les valeurs à saisir.
	    Sachant que toutes les options du menu principal ont une probabilite voisine, la structure de test SWITCH est utilisee.
	    */

            System.out.println("Bonjour et bienvenue dans votre application de gestion de comptes bancaires !");
            System.out.println("Voici le menu principal :");
            System.out.println("1. Cree un compte");
            System.out.println("2. Afficher un compte");
            System.out.println("3. Creer une ligne comptable");
            System.out.println("4. Sortir");
            System.out.println("5. De l'aide");

            System.out.println("Veuillez saisir le numero du menu de votre choix :");
            choixDuMenu = lectureClavier.nextInt();

            switch (choixDuMenu) {

                case 1:    // Affiche la demande de saisie pour le type du compte a creer, puis affecte ce type de compte saisi dans la variable.

                    System.out.println("Veuillez ecrire [courant] ou [epargne] pour definir le type du compte que vous souhaitez ajouter :");
                    typeDeCompte = lectureClavier.next();

                    switch (typeDeCompte) {

                        case "epargne":
                            verificationCompteEpargne = true;
                            break;

                        case "courant":
                            verificationCompteCourant = true;
                            break;

                        default:
                            System.out.println("Ce type de compte n'existe pas");
                    }

                    if (verificationCompteCourant || verificationCompteEpargne) {
                        System.out.println("Veuillez saisir le Numero du compte que vous souhaitez creer :");
                        numeroDeCompte = lectureClavier.next();
                        System.out.println("Veuillez saisir la premiere valeur a crediter sur le compte :");
                        valeur = lectureClavier.nextDouble();

                        if (verificationCompteEpargne) {
                            System.out.println("Vous avez ajoutez un compte de type epargne, veuillez saisir finalement son taux de placement :");
                            tauxEpargne = lectureClavier.nextDouble();
                        }
                    }

                    System.out.println("Pour retourner au menu, saisissez le chiffre [1], sinon sur n'importe quel autre chiffre pour quitter le programme");
                    choixRetourAuMenuOuQuitter = lectureClavier.nextInt();
                    if (choixRetourAuMenuOuQuitter != 1)
                        repeterProgramme = false;
                    break;

                case 2:

                    /*
                    Demande au programme de verifier que le numero de compte saisi par l'utilisateur existe, de facon a :
                    Affiche le numero de compte, le type, la valeur initiale et son taux dans le cas d'un compte d'epargne, si le compte existe.
                    Affiche un message indiquant que le numero du compte n'est pas valide, si le compte n'existe pas.
                    */

                    System.out.println("Veuillez saisir le numero de compte que vous souhaitez consulter :");
                    verificationNumeroDeCompte = lectureClavier.next();

                    if (verificationNumeroDeCompte.equals(numeroDeCompte)) {
                        System.out.println("Numero du compte : " + numeroDeCompte);
                        System.out.println("Type du compte : " + typeDeCompte);
                        System.out.println("Valeur initiale : " + valeur);
                        if (verificationCompteEpargne)
                            System.out.println("Taux d'epartne : " + tauxEpargne);

                        System.out.println("Pour retourner au menu, saisissez le chiffre [1], sinon sur n'importe quel autre chiffre pour quitter le programme");
                        choixRetourAuMenuOuQuitter = lectureClavier.nextInt();
                        if (choixRetourAuMenuOuQuitter != 1)
                            repeterProgramme = false;

                    } else {
                        System.out.println("Il n'existe pas de compte enregistre sous ce numero saisi");
                        System.out.println("Pour retourner au menu, saisissez le chiffre [1], sinon sur n'importe quel autre chiffre pour quitter le programme");
                        choixRetourAuMenuOuQuitter = lectureClavier.nextInt();
                        if (choixRetourAuMenuOuQuitter != 1)
                            repeterProgramme = false;
                    }
                    break;

                case 3:    // en attente d'apprendre pour programmer des ajouts de lignes comptables

                    System.out.println("Option non programmee");
                    System.out.println("Merci, pour retourner au menu, saisissez le chiffre [1], sinon sur n'importe quel autre chiffre pour quitter le programme");
                    choixRetourAuMenuOuQuitter = lectureClavier.nextInt();
                    if (choixRetourAuMenuOuQuitter != 1)
                        repeterProgramme = false;
                    break;

                case 4: // termine l'execution du programme

                    repeterProgramme = false;
                    break;

                case 5: //affiche une ligne explicative pour chaque option du menu principal

                    System.out.println("Menu 1. Cree un compte : Permet de creer un compte en saisissant les informations necessaires : Type de compte, Numero de compte, Valeur initiale, Taux d'epargne");
                    System.out.println("Menu 2. Afficher un compte : Permet de saisir un numero de compte pour y consulter son Type, sa Valeur initiale et son Taux d'epargne ");
                    System.out.println("Menu 3. Creer une ligne comptable : Permet d'ajouter une ligne comptable");
                    System.out.println("Menu 4. Sortir : Quitte le programme ");

                    System.out.println("Merci, pour retourner au menu, saisissez le chiffre [1], sinon sur n'importe quel autre chiffre pour quitter le programme");
                    choixRetourAuMenuOuQuitter = lectureClavier.nextInt();
                    if (choixRetourAuMenuOuQuitter != 1)
                        repeterProgramme = false;
                    break;

                default:
                    System.out.println("Impossible, ce choix de menu n'existe pas");
                    System.out.println("Merci, pour retourner au menu, saisissez le chiffre [1], sinon sur n'importe quel autre chiffre pour quitter le programme");
                    choixRetourAuMenuOuQuitter = lectureClavier.nextInt();
                    if (choixRetourAuMenuOuQuitter != 1)
                        repeterProgramme = false;
            }
        }
    }
}