@bouletcorp
Feature: Verification des widgets - bouletcorp
  En tant que utilisateur je souhaite verifier les widgets du site Bouletcorp

  Scenario: Verification des widgets - bouletcorp
    Given je me rends sur "http://www.bouletcorp.com"
    When je clique sur Aleatoire
    Then la page a change
    And les widgets facebook, twitter et tumblr sont bien affiches
