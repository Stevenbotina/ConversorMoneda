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
