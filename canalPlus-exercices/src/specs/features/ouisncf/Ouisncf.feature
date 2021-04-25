@ouisncf
Feature: Chercher billet - ouisncf
  En tant que utilisateur je souhaite chercher un billet de train sur le site Ouisncf

  Scenario: Chercher billet - ouisncf
    Given je souhaite me rendre sur le site ouisncf "https://www.oui.sncf/"
    When je recherche un billet de train entre "Paris (toutes gares intramuros)" et "Toulouse Matabiau (Occitanie)" pour le "24/11" a "16h"
    Then le train de "15h52" "MONTPARNASSE 1 ET 2" est bien affiche
