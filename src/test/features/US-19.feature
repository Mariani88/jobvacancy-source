Feature: Como dueño del sitio, quiero que las ofertas sean desactivadas al
 pasar un mes de su publicacion, para mantener en vista las mas actuales.

Scenario: una oferta supera en un mes su fecha de creacion
Given hay una oferta de trabajo publicada
When la fecha actual supera en un mes a la fecha de publicacion de la oferta
Then la oferta es desactivada.