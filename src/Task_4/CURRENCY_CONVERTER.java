package Task_4;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.util.Map;
import java.util.Scanner;
public class CURRENCY_CONVERTER {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type currency to convert from");
        String convertFrom = scanner.nextLine().toUpperCase();
        System.out.println("Type currency to convert to");
        String convertTo = scanner.nextLine().toUpperCase();
        System.out.println("Type quantity to convert");
        double quantity = scanner.nextDouble();
        String baseUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_qlWtWdZxDzixeTirWj9MPc2YTUBGLbGByWjsWwYp&currencies=" + convertTo + "&base_currency=" + convertFrom;
        // Construct the full URL

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert response != null;
        String jsonResponse = response.body();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse JSON string into JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Access the 'data' field
            JsonNode dataNode = rootNode.get("data");

            Map<String, String> dataMap = objectMapper.convertValue(dataNode, new TypeReference<Map<String, String>>() {});

            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                double rate = Double.parseDouble(entry.getValue());
                System.out.println(quantity +" " + convertFrom + " = " + rate * quantity + " " + convertTo);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
