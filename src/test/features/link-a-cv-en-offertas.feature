Feature: El postulante puede agregar un link a su CV cuando se postula

Scenario: El postulante adjunta un link a su CV al postularse a una oferta

Given el postulante ha ingresado su nombre y un mail válido
When el postulante adjunta un link a su CV And aplica para la oferta de trabajo
Then el ofertante recibió por mail los datos y el link al CV del postulante