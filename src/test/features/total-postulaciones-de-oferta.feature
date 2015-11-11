Feature: el oferente puede ver la cantidad total de postulaciones a su oferta


Scenario: Un usuario se postula a la oferta

Given la cantidad de postulaciones de la oferta X es 5
When un usuario se postula a la oferta X
Then la cantidad de postulaciones a la oferta X es 6