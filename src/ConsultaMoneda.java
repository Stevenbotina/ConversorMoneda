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
