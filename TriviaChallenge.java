import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class TriviaChallenge {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to trivia challenge!");

        String url = "https://opentdb.com/api.php?amount=10&category=23&difficulty=medium&type=multiple";

        retrieveData(url);
    }
    public static void  retrieveData(String url)throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            System.out.println("Request successful!");
            System.out.println(response.body());
        } else {
            System.out.println("Request unsuccessful!");
        }
    }
}
