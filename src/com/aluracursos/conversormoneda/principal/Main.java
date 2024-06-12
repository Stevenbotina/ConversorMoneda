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
