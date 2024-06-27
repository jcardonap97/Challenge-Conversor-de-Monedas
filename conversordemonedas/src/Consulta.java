import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Consulta {

    public Moneda buscaMoneda (String codigoMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/63bc1f61132b0117cf0d6efe/latest/" + codigoMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            String result = jsonObject.get("result").getAsString();
            String baseCode = jsonObject.get("base_code").getAsString();
            JsonObject conversionRatesJson = jsonObject.get("conversion_rates").getAsJsonObject();
            Map<String, Double> conversionRates = new Gson().fromJson(conversionRatesJson, Map.class);


            return new Moneda(result, baseCode, conversionRates);

        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda solicitada");
        }
    }
}
