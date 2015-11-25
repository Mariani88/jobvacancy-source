Feature: El usuario puede crear una oferta a partir de otra existente

Scenario: El oferente crea una nueva oferta de trabajo a partir de una oferta ya existente

Given un oferente esta logueado en la aplicación And tiene una oferta creada
When cliquea el botón "Duplicate" en su oferta de trabajo And edita los campos And guarda la nueva oferta.
Then se creo una nueva oferta.