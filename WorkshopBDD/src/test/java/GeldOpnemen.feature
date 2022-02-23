# language: nl

Functionaliteit: Geld opnemen bij een geldautomaat
  om genoeg contant geld op zak te hebben
  als klant
  wil ik geld op kunnen nemen

  Achtergrond:
    Gegeven een rekening met een saldo van 200 euro en een pincode van 1234

  Abstract Scenario: Geld opnemen met voldoende saldo gaat goed
    Gegeven een geldautomaat met een voorraad van 250 euro
    Als de klant <bedrag> euro opneemt bij de geldautomaat en pincode 1234 invoert
    Dan krijgt de klant de volgende briefjes geld:
    | briefjesVan10 | <briefjesVan10> |
    | briefjesVan20 | <briefjesVan20> |
    | briefjesVan50 | <briefjesVan50> |

    Voorbeelden:
      | bedrag | briefjesVan10 | briefjesVan20 | briefjesVan50 |
      | 100    | 0             | 0             | 2             |
      | 90     | 0             | 2             | 1             |
      | 60     | 1             | 0             | 1             |
      | 30     | 1             | 1             | 0             |
      | 20     | 0             | 1             | 0             |
      | 10     | 1             | 0             | 0             |


  Scenario: Geld opnemen terwijl de automaat geen voorraad heeft geeft een foutmelding
    Gegeven een geldautomaat met een voorraad van 50 euro
    Als de klant 100 euro opneemt bij de geldautomaat en pincode 1234 invoert
    Dan wordt de foutmelding "Geen voorraad" getoond

  Scenario: Geld opnemen met onvoldoende saldo geeft een foutmelding
    Gegeven een geldautomaat met een voorraad van 500 euro
    Als de klant 300 euro opneemt bij de geldautomaat en pincode 1234 invoert
    Dan wordt de foutmelding "Onvoldoende Saldo" getoond

  Scenario: Geld opnemen met een ongeldige pincode geeft een foutmelding
    Gegeven een geldautomaat met een voorraad van 200 euro
    Als de klant 300 euro opneemt bij de geldautomaat en pincode 4321 invoert
    Dan wordt de foutmelding "Pincode Onjuist" getoond


  Abstract Scenario: Geld opnemen met een ongeldig bedrag geeft een foutmelding
    Gegeven een geldautomaat met een voorraad van 200 euro
    Als de klant <bedrag> euro opneemt bij de geldautomaat en pincode 1234 invoert
    Dan wordt de foutmelding "Onjuist gekozen bedrag" getoond

    Voorbeelden:
      | bedrag |
      | 0      |
      | 7      |
      | 11     |