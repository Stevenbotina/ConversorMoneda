import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese la opción de conversión de moneda que desea:");
        System.out.println("1. Dólar a Peso argentino");
        System.out.println("2. Peso argentino a Dólar");
        System.out.println("3. Dólar a Real brasileño");
        System.out.println("4. Real brasileño a Dólar");
        System.out.println("5. Dólar a Peso colombiano");
        System.out.println("6. Peso colombiano a Dólar");
        System.out.println("7. Salir");

        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Moneda moneda = consultaMoneda.moneda("USD");
        ConversorMoneda conversorMoneda = new ConversorMoneda(moneda);
        try {
            int opcion = Integer.parseInt(lectura.nextLine());
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
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número");
        }
    }
}
