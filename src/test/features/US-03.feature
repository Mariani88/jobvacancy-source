Feature: Como oferente quiero definir una fecha de validez de cada oferta

Scenario: El oferente ingresa una fecha valida
Given el oferente presiona create new offer y llena todos los campos
When llena el campo "expiration date" con fecha valida
Then una nueva oferta es creada

Scenario: El oferente ingresa una fecha invalida
Given el oferente presiona create new offer y llena todos los campos
When llena el campo "expiration date" con fecha invalida
Then un cartel de "invalid date" es devuelto

Scenario: El oferente ingresa una fecha valida pero vieja
Given el oferente presiona create new offer y llena todos los campos
When llena el campo "expiration date" con fecha valida pero anterior a la actual
Then un cartel de "you must enter a actual date"