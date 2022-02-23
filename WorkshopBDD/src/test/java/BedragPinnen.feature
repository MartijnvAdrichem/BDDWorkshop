## language: nl


#  LET OP: Hele feature staat in comments zodat dit geen compile fouten gaat geven later
#  Je kan deze gebruiken als voorbeeld


#Functionaliteit: Het pinnen met een betaalpas
#  Om mijn aankopen te kunnen betalen
#  Als klant
#  Wil ik kunnen pinnen met mijn bankpas
#
#  Achtergrond:
#    Gegeven een pinpas met de pincode 1234 en een saldo van 100 euro
#
#  Scenario: pinnen met voldoende saldo gaat goed
#    Gegeven een pinpas met de pincode 1234 en een saldo van 100 euro
#    Als de klant een bedrag pint voor 50 euro en pincode 1234 invoert
#    Dan wordt het bedrag afgeschreven en staat er nog 50 euro op de pinpas
#
#  Scenario: pinnen met onvoldoende saldo geeft een foutmelding
#    Gegeven een pinpas met de pincode 1234 en een saldo van 100 euro
#    Als de klant een bedrag pint voor 200 euro en de pincode 1234 invoert
#    Dan wordt het bedrag niet afgeschreven en wordt er Onvoldoende Saldo getoond
#
#  Scenario: een pinpas die negatief mag staan kan tot negatief bedrag pinnen
#    Gegeven een pinpas met de pincode 1234 en een saldo van 100 euro
#    En de rekening mag negatief staan
#    Als de klant een bedrag pint voor 200 euro en de pincode 1234 invoert
#    Dan wordt het bedrag afgeschreven en staat er nog -100 euro op de pinpas
#
#  Scenario: pinnen met een verkeerde pincode geeft een foutmelding
#    Gegeven een pinpas met de pincode 1234 en een saldo van 100 euro
#    Als de klant een bedrag pint voor 200 euro en de pincode 2564 invoert
#    Dan Wordt het bedrag niet afgeschreven en wordt er Incorrecte Code getoond
#
#  Abstract Scenario: pinnen in de nacht mag niet
#    Gegeven een pinpas met de pincode 1234 en een saldo van 100 euro
#    En de pinpas mag niet gebruikt worden tussen 01:00 en 06:30
#    Als de klant om <tijd> bedrag pint voor 10 euro en de pincode 1234 invoert
#    Dan Wordt het bedrag <succes> afgeschreven
#
#    Voorbeelden:
#      | tijd  | succes |
#      | 00:59 | wel    |
#      | 01:00 | niet   |
#      | 06:30 | niet   |
#      | 06:31 | wel    |
#
#  Scenario: Alle pinpassen kunnen van een afstand geblokkeerd worden
#    Gegeven de volgende pinpassen:
#      | voornaam | achternaam   | postcode | huisnummer |
#      | Martijn  | van Adrichem | 1234AB   | 1          |
#      | Vincent  | Spijkers     | 4321BA   | 99         |
#    Als alle bekende pinpassen worden geblokkeerd
#    Dan zijn de volgende pinpassen geblokkeerd:
#      | naam                |
#      | Martijn van Adichem |
#      | Vincent Spijkers    |