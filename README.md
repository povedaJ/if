# ifhttps://github.com/leocamachocr/ucr-if-3000


https://github.com/leocamachocr/ucr-if-3000/blob/main/poo/source/pom.xml


https://codeshare.io/789Bk1

mediacionJ1@

Resumen materia 1 EXAMEN
https://docs.google.com/document/d/1DqDsTHjAC7URpXNESHSm7Sp7GGPw6D-I/edit?usp=sharing&ouid=104321629709422678552&rtpof=true&sd=true



Resumen materia 2 EXAMEN
https://docs.google.com/document/d/1rBV5IOagyXKHmKz3VMjrGxwptAJXdT2i/edit?usp=sharing&ouid=104321629709422678552&rtpof=true&sd=true

Prueba práctica


Examen

(20 pts) Dado el siguiente código


record Place(
        String name,
        Integer visitorsAverage,
        String location
) {
}


Con base en esa estructura se tiene la siguiente lista:



List<Place> places = Arrays.asList(
           new Place("Ruinas de Ujarrás", 200, "Cartago"),
           new Place("Basílica de los Ángeles", 1000, "Cartago"),
           new Place("Museo de los Niños", 800, "San José"),
           new Place("Inbio Parque", 500, "Heredia"),
           new Place("Universidad Nacional", 3000, "Heredia"),
           new Place("Restaurante Maxi's", 80, "Limón"),
           new Place("Parque Marino", 350, "Puntarenas")
           );



1.1 (10 pts) Utilice Streams y expresiones lambda para crear una sentencia para obtener todos los lugares de Cartago.

List<Place> cartagoPlaces=places./*Implemente Streams y lambda aquí*/;

1.2 (10 pts) Utilice Streams y expresiones lambda para crear una sentencia que imprima (System.out.println(placeName)) los nombres de los lugares cuyo promedio de visitas es mayor a 500.
  
  --------------------------------------------------------------------------------------------------------
  
  (20 pts) Con respecto al código siguiente, cree dos métodos default para la interfaz TransactionService según los puntos 2.1 y 2.2

class Account {
    private String name;
    private Long balance;

    /*Asuma que existen los getters y setters de cada variable*/
}

interface TransactionService {
    Account debitTransaction(Account account, Long debit);

    Account creditTransaction(Account account, Long credit);
    /*Los métodos default van aquí*/
}


2.1 (5 pts) El primero se debe llamar `addition` y debe recibir como parámetros dos montos tipo Long, debe sumar el primer valor más el segundo valor.



2.2 (5 pts) El segundo se debe llamar `sustract` y debe recibir como parámetros dos montos tipo Long, debe restar el primer valor menos el segundo valor. Si el primer valor es mayor al primero, debe lanzar una excepción de tipo `RuntimeException`.



2.3 (10 pts)Complete la siguiente clase implementando los métodos para cada tipo de transacción. Debe realizar lo siguiente:



- Utilizar los métodos default creados en los puntos 2.2 y 2.3.

    - El método `addition` debe utilizarse en el método `debitTransaction`.

    - El método `sustract` debe utilizarse en el método `creditTransaction`.

- Retornar la instancia de la class Account con el monto sumado o restado según sea el caso.



class TransactionServiceImpl implements TransactionService {
    public Account debitTransaction(Account account, Long debit) {
        // su código va aquí
    }

    public Account creditTransaction(Account account, Long credit) {
        // su código va aquí
    }
}
        
        G/
        
        J/
        
  ---------------------------------------------------------------------------------------------------------------------------
  (30 pts) Utilizando Sockets realice dos aplicaciones una cliente y una servidora que indique si dos palabras son un palíndromo, considere lo siguiente:

    - La aplicación cliente debe enviar un mensaje a la aplicación servidora con las dos palabras.

    - El servidor debe evaluar las palabras y determinar si es un palíndromo o no. Este debe retornar "OK" si lo es y "NO" si no lo es.

    - El cliente debe recibir el mensaje e indicar la respuesta "Las palabras %s y %s si son un palíndromo" cuando lo sean y "Las palabras %s y %s no son un palíndromo" cuando no lo sean.

    - El servidor debe estar listo nuevamente para recibir la siguiente palabra.

    - La clase cliente debe verificar las siguientes palabras:

        - {arroz,zorra}: Si es.

        - {roma,amor}: No es.

        - {rata,atar}: Si es.

        - {animal,lamina}: Si es.

        - {dolo,lodo}: No es.



Consideraciones:



- Puede implementar tanto la aplicación cliente como la servidora en el mismo proyecto, solamente recuerde organizar bien su paquetería.

- Utilice Maven para la creación del proyecto.

- Utilice los puertos del 50001 al 50010.

- Considere las mayúsculas, minúsculas y caracteres con tilde como diferentes. De esta manera: A es diferente de a, é es diferente de e.

--------------------------------------------------------------------------------------------------------------------

(30 pts) Usted necesita programar un simulador de una torre de control aérea. Donde tiene que simular las entradas y salidas de aviones de un aeropuerto. La torre de control lleva el conteo de cuantos aviones hay en el aeropuerto en cada determinado momento. Así que cada vez que un avión aterrice deberá incrementar un contador. Asimismo, cuando un avión despegue debera decrementar el contador.

   Los aviones están constantemente entrando y saliendo del aeropuerto indefinidamente. Estos duran un tiempo aleatorio de 0 a 5 segundos en el aire y el mismo tiempo en el aeropuerto.

   Desarrolle una aplicación que simule este comportamiento, esta aplicación debe realizar lo siguiente:



- Cree una clase para la torre de control que lleve el contador de los aviones que se encuentran en el aeropuerto.

- Cree 10 aviones donde cada avión: por un tiempo aleatorio vuela y por otro tiempo aleatorio se queda en el aeropuerto. Este tiempo aleatorio lo puede simular utilizando el estado `sleep` de un hilo. Cada avión comienza estando en el aire.

- Ejecute 10 hilos, uno por cada avión para que ejecuten sus vuelos indefinidamente.

- Imprima una salida a pantalla cada vez que un avión entre o salga del aeropuerto, incluya el avión que sale o entra y  la cantidad de aviones en el aeropuerto en ese momento.



Consideraciones:

- Solamente un avión a la vez puede modificar el contador.

- Puede utilizar cualquier clase vista en clase referente al manejo de hilos
  -------------------------------------------------------------------------------------------------------------------------
