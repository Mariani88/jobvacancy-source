Feature: el usuario administrador ve la cantidad total de ofertas publicadas

Scenario: El administrador ve la cantidad histórica de ofertas luego de crear la primer oferta
Given administrador logueado And cantidad históricas de ofertas es 0
When se crea una oferta
Then la cantidad histórica de ofertas es 1

Scenario: El administrador ve la cantidad histórica de ofertas luego de eliminar una oferta
Given administrador logueado And cantidad históricas de ofertas es 2
When se elimina una oferta
Then la cantidad histórica de ofertas es 1