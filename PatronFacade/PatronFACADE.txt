Patrón Facade - Facade Pattern

Facade es un patrón de diseño estructural que proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases.


Problema:
Trabajar con un amplio grupo de objetos que pertenecen a una sofisticada biblioteca, se debe inicializar todos los objetos , llevar registro de las dependencias, ejecutar los métodos en orden, etc...
Por lo tanto la lñogica de negocio de las clases se vería estrechamente acoplada a los detalles de las clases de terceros, haciéndola difícil de comprender y mantener.
Define una interfaz simplificada a un subsistema de objetos, pero no introduce ninguna nueva funcionalidad. El propio subsistema no conoce la fachada. Los objetos del subsistema pueden comunicarse directamente.

Solución:

Ocultar o simplificar la complejidad que pueda tener la aplicación, para que el cliente simplemente tenga
un punto de acceso muy facil y pueda utilizar el sistema si que sepa que hay dentro.
Tener una fachada resulta útil cuando tienes que integrar tu aplicación con una biblioteca sofisticada con decenas de funciones, de la cual sólo necesitas una pequeña parte.

Facade y Mediator tienen trabajos similares: ambos intentan organizar la colaboración entre muchas clases estrechamente acopladas.




