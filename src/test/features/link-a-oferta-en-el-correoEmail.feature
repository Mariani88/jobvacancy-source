Feature: el oferente recibe el correo al tener una postulacion a su oferta, con el link a dicha oferta

Scenario: Llega un mail al ofertante

Given un usuario se postula a la oferta
When el usuario ingresa sus datos And envía la postulacion
Then llega un mail al ofertante con el link a la oferta que se postulo el usuario