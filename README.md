# Proyecto-1
UVG Algoritmos y Estructuras de Datos (2022) | Proyecto 1 Interprete LISP

Link en Trello: https://trello.com/b/GUhPR2aI/proyecto-1

[Guía Proyecto 1.pdf](https://github.com/jazurdia/Proyecto-1/files/8338177/Proyecto1.2.pdf)

Autores: 
  Diego Alejandro Morales, 
  Maria Marta Ramírez, 
  Javier Alejandro Azurdia.
  
 Este Proyecto pretende construir un intérprete de LISP básico, poniendo a prueba los conocimientos adquiridos en el curso de Algoritmos y Estructuras de datos. 

  El programa puede:
  - Hacer operaciones simples en formato LISP
  - Puede utilizar variables
  - Puede declarar y ejecutar funciones simples. 

 
 Las siguientes son las restricciones del programa:
 - El programa únicamente acepta operaciones con el siguiente formato: ("signo u operando" "número o variable "numero o variable"), de acuerdo con la estructura de LISP. 
 - El programa no acepta operaciones complejas (con más de un par de paréntesis).
 - El programa requiere que, al operar 2 variables, estas se instancien antes de realizar dicha operación. 
 - Para declarar una función, se debe hacer de la siguiente forma:
    - (defun nombre_funcion (variable) (signo variable/numero variable/numero))