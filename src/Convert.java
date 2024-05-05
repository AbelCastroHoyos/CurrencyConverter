import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase que establece las condiciones para el consumo de la API de exchangegenerate, armando en forma dinámica
 * y entrega una respuesta de acuerdo al consumo de la misma
 */
public class Convert {

    /**
     * Método que arma en forma dinámica la URL del endPoint a correspondiente al servicio a consumir
     * de acuerdo a los parametros suministrados y que dependen de Key del usuario y la opción seleccionada
     * en el menú de la aplicación. Se está usando el "pair" puesto que es el más adecuado para las condiciones
     * dadas para el problema.
     * Devuelve un objeto determinado por la clase Currency con los datos entregados por el servicio.
     * @param API_KEY
     * @param currencyFrom
     * @param currencyTo
     * @param amount
     * @return
     */
    public Currency convertTo(String API_KEY, String currencyFrom, String currencyTo, String amount){
        URI enpPoint = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+currencyFrom+"/"+currencyTo+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(enpPoint)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            //System.out.println(jsonResponse);
            new AuditWriter(response.body(),amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(),Currency.class);
    }
}
