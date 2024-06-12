public class ConversorMoneda {
    private Moneda moneda;

    public ConversorMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String convertirUsdToArs(double cantidad) {
        return "El valor: " + cantidad + " [USD] " + "corresponde al valor final de ==> " + String.format("%.2f", cantidad * moneda.usdToArs()) + " [ARS]";
    }

    public String convertirArsToUsd(double cantidad) {
        return "El valor: " + cantidad + " [ARS] " + "corresponde al valor final de ==> " + String.format("%.2f", cantidad * moneda.arsToUsd()) + " [USD]";
    }

    public String convertirUsdToBrl(double cantidad) {
        return "El valor: " + cantidad + " [USD] " + "corresponde al valor final de ==> " + String.format("%.2f", cantidad * moneda.usdToBrl()) + " [BRL]";
    }

    public String convertirBrlToUsd(double cantidad) {
        return "El valor: " + cantidad + " [BRL] " + "corresponde al valor final de ==> " + String.format("%.2f", cantidad * moneda.brlToUsd()) + " [USD]";
    }

    public String convertirUsdToCop(double cantidad) {
        return "El valor: " + cantidad + " [USD] " + "corresponde al valor final de ==> " + String.format("%.2f", cantidad * moneda.usdToCop()) + " [COP]";
    }

    public String convertirCopToUsd(double cantidad) {
        return "El valor: " + cantidad + " [COP] " + "corresponde al valor final de ==> " + String.format("%.2f", cantidad * moneda.copToUsd()) + " [USD]";
    }
}
