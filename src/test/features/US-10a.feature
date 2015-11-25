Feature: El postulante puede agregar un link a su CV cuando se postula

Scenario: El postulante ingresa un link a su CV al postularse a una oferta
Given el postulante ha ingresado su nombre y un mail válido
When el postulante ingresa un link valido: https://www.linkedin.com/profile/view?id=AAMAABhp-akBJJDtLnfvsXb-3Ur2820svaUvhaU&trk=hp-identity-name
 a su CV And aplica para la oferta de trabajo
Then el ofertante recibió por mail los datos y el link al CV del postulante

Scenario: El postulante ingresa un link invalido a su CV al postularse a una oferta
Given el postulante ha ingresado su nombre y un mail válido
When el postulante ingresa un link invalido: https://ww.linkedin.com/profile/view?id=AAMAABhp-akBJJDtLnfvsXb-3Ur2820svaUvhaU&trk=hp-identity-name
 a su CV
Then el postulante recibe un mensaje de link invalido

Scenario: El postulante no ingresa un link a su CV al postularse a una oferta
Given el postulante ha ingresado su nombre y un mail válido
When el postulante no ingresa un link And aplica para la oferta de trabajo
Then el postulante no puede aplicar a la oferta