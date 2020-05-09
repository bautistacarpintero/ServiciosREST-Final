# Programación Orientada a Servicios
#### Trabajo final de catedra


#### Contexto
El puntaje condición corporal es un valor numérico entre 1 y 9 que es asignado a una vaca por
un veterinario experto mientras las vacas son ordeñadas o pasan por una manga. El puntaje de
condición corporal es un indicador que estima la grasa corporal almacenada y el balance
energético acumulado de las vacas. Este indicador influye en la producción de leche,
reproducción y salud de vacas destinadas a la producción láctea o la producción de carne. En
este sentido, el ISISTAN ha desarrollado, mediante una beca doctoral, un sistema de
estimación de la condición corporal utilizando imágenes del lomo de una vaca a la cual se pasa
por un proceso de estimación. Este “proceso de estimación” utiliza una reconocida técnica de
predicción basada en imágenes llama deep learning. El objetivo de este trabajo es utilizar los
conceptos de Web Services, tanto SOAP (parcial de la materia) como REST (final de la
materia), y el conocimiento tecnológico adquiridos en la cátedra para generar un sistema que
permita administrar los valores predichos por el sistema de estimación de la condición corporal.

#### Casos de Uso (iniciales)
* Un sistema de IA ingresa agrega una bcs de un animal (mockeado).
* Un usuario de de alta un animal.
* Un usuario asocia un animal a un rodeo.
* Un usuario obtiene toda la información de un animal, entre ellos el último bcs.
* Un usuario obtiene toda la información de un rodeo, entre ellos el bsc promedio
* Un usuario configura una alerta para un determinado animal.
* Un usuario configura una alerta para un determinado rodeo.

#
> *En desarrollo*
