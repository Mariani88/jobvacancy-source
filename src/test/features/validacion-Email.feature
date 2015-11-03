Feature: El usurio debe ingresar un email valido al postularse.

Background: existe una oferta de trabajo
Given existe una oferta de trabajo

Scenario: El postulante ingresa un mail valido al postularse
When usuario ingresa mail valido hola@hotmail.com
Then se guarda nombre y el mail del usuario

Scenario: El postulante ingresa un mail invalido al postularse
When postulante ingresa mail invalido hola@hotmailcom
Then pagina informa mail invalido