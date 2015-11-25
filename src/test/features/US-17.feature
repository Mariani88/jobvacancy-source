Feature: el oferente recibe un mail en formato HTML para presionar los link y ser redirigido

Scenario: Llega un mail al ofertante

Given un usuario se postula a la oferta
When el usuario ingresa sus datos And envía la postulacion
Then llega un mail al ofertante con el link a la oferta que 
se postulo el usuario, lo cliquea y lo dirige.
