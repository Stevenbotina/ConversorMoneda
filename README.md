# 🪙 Conversor de Moneda 🪙

¡Te damos la bienvenida al Conversor de Moneda! Este software te permite realizar conversiones entre distintas monedas de forma rápida y sencilla, utilizando la API ExchageRate. 


## 🖥️ Instalación

1. Haz un clon de este repositorio en tu equipo local: <pre>git clone https://github.com/Stevenbotina/ConversorMoneda </pre> 
2. Abre el proyecto en tu IDE de preferencia.
3. Verifica que tienes Java instalado en tu sistema.

## 📁 Uso
Este proyecto unicamnete tiene como finalidad aprovar el Challenge Conversor de Monedas
por lo que las funcionalidad son muy limitadas.


## 🗒️ Estructura del Proyecto

#### Package Interacciones
- [Consulta Moneda](#consulta-moneda)
- [ConversorMoneda](#conversor-moneda)
- [Moneda](#moneda)

#### Package Principal
- [Main](#main)  

## Consulta Moneda

La clase ConsultaMoneda realiza solicitudes a la API de ExchangeRate para obtener las tasas de cambio actuales y devuelve un objeto Moneda con estas tasas.

````java

package com.aluracursos.conversormoneda.interacción;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda moneda(String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/232865021e5d92d1e1465823/latest/" + moneda);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder().uri(direccion).build();
        try {
            HttpResponse<String> response = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            double usdToArs = jsonObject.get("conversion_rates").getAsJsonObject().get("ARS").getAsDouble();
            double arsToUsd = 1 / usdToArs;
            double usdToBrl = jsonObject.get("conversion_rates").getAsJsonObject().get("BRL").getAsDouble();
            double brlToUsd = 1 / usdToBrl;
            double usdToCop = jsonObject.get("conversion_rates").getAsJsonObject().get("COP").getAsDouble();
            double copToUsd = 1 / usdToCop;

            return new Moneda(usdToArs, arsToUsd, usdToBrl, brlToUsd, usdToCop, copToUsd);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio");
        }
    }
}
````
## Conversor Moneda

La clase ConversorMoneda se encarga de realizar las conversiones de moneda utilizando las tasas de cambio obtenidas a través de un objeto Moneda. Cada método de esta clase toma una cantidad de dinero en una moneda específica y la convierte a otra moneda, utilizando las tasas de cambio correspondientes.

````java
  package com.aluracursos.conversormoneda.interacción;

public class ConversorMoneda {
    private Moneda moneda;

    public ConversorMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String convertirUsdToArs(double cantidad) {
        return "\nEl valor: " + cantidad
                + " [USD] " + "corresponde al valor final de ==> "
                + String.format("%.2f", cantidad * moneda.usdToArs())
                + " [ARS]\n";
    }

    public String convertirArsToUsd(double cantidad) {
        return "\nEl valor: " + cantidad
                + " [ARS] " + "corresponde al valor final de ==> "
                + String.format("%.2f", cantidad * moneda.arsToUsd())
                + " [USD]\n";
    }

    public String convertirUsdToBrl(double cantidad) {
        return "\nEl valor: " + cantidad
                + " [USD] " + "corresponde al valor final de ==> "
                + String.format("%.2f", cantidad * moneda.usdToBrl())
                + " [BRL]\n";
    }

    public String convertirBrlToUsd(double cantidad) {
        return "\nEl valor: " + cantidad + " [BRL] "
                + "corresponde al valor final de ==> "
                + String.format("%.2f", cantidad * moneda.brlToUsd())
                + " [USD]\n";
    }

    public String convertirUsdToCop(double cantidad) {
        return "\nEl valor: " + cantidad + " [USD] "
                + "corresponde al valor final de ==> "
                + String.format("%.2f", cantidad * moneda.usdToCop())
                + " [COP]\n";
    }

    public String convertirCopToUsd(double cantidad) {
        return "\nEl valor: " + cantidad + " [COP] "
                + "corresponde al valor final de ==> "
                + String.format("%.2f", cantidad * moneda.copToUsd())
                + " [USD]\n";
    }
}
````
## Moneda

 Moneda es un record que contiene las tasas de cambio entre diferentes monedas. Cada tasa de cambio es un campo del record y se inicializa al crear una instancia de Moneda. Estos campos son inmutables y se pueden acceder directamente.
 
````java
package com.aluracursos.conversormoneda.interacción;

public record Moneda(double usdToArs, double arsToUsd, 
                     double usdToBrl, double brlToUsd, 
                     double usdToCop, double copToUsd) {
}
````

## Main

La clase Main es la clase de entrada del programa. Crea instancias de ConsultaMoneda, Moneda y ConversorMoneda. Luego, en un bucle, muestra un menú al usuario para seleccionar una opción de conversión de moneda y realiza la conversión correspondiente. El bucle se ejecuta hasta que el usuario selecciona la opción para salir.

````java
package com.aluracursos.conversormoneda.principal;

import com.aluracursos.conversormoneda.interacción.ConsultaMoneda;
import com.aluracursos.conversormoneda.interacción.ConversorMoneda;
import com.aluracursos.conversormoneda.interacción.Moneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("****************************************");
            System.out.println("¡Bienvenido al conversor de moneda!");
            System.out.println("Ingrese la opción de conversión de moneda que desea:\n");
            System.out.println("1. Dólar a Peso argentino");
            System.out.println("2. Peso argentino a Dólar");
            System.out.println("3. Dólar a Real brasileño");
            System.out.println("4. Real brasileño a Dólar");
            System.out.println("5. Dólar a Peso colombiano");
            System.out.println("6. Peso colombiano a Dólar");
            System.out.println("7. Salir");
            System.out.println("****************************************\n");

            ConsultaMoneda consultaMoneda = new ConsultaMoneda();
            Moneda moneda = consultaMoneda.moneda("USD");
            ConversorMoneda conversorMoneda = new ConversorMoneda(moneda);
            try {
                opcion = Integer.parseInt(lectura.nextLine());
                if (opcion == 7) {
                    break;
                }
                System.out.println("Ingrese la cantidad que desea convertir:");
                double cantidad = Double.parseDouble(lectura.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println(conversorMoneda.convertirUsdToArs(cantidad));
                        break;
                    case 2:
                        System.out.println(conversorMoneda.convertirArsToUsd(cantidad));
                        break;
                    case 3:
                        System.out.println(conversorMoneda.convertirUsdToBrl(cantidad));
                        break;
                    case 4:
                        System.out.println(conversorMoneda.convertirBrlToUsd(cantidad));
                        break;
                    case 5:
                        System.out.println(conversorMoneda.convertirUsdToCop(cantidad));
                        break;
                    case 6:
                        System.out.println(conversorMoneda.convertirCopToUsd(cantidad));
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número");
            }
        }
        System.out.println("Saliendo...");
    }
}
````

## 🔎 Tecnologías Empleadas
- Java 🍵
- Gson 🔑

## 🌟 Funcionalidades
- Conversión de monedas
- Interfaz de usuario amigable
- Integración con API ExchageRate



## 📝 Licencia

Este proyecto está bajo la licencia MIT.

¡Gracias por utilizar el Conversor de Moneda WRH3! Espero que te sea útil y que tengas una excelente experiencia convirtiendo monedas. ¡Feliz conversión! 🚀✨

## Autores

1. Steven Danilo Gelpud
