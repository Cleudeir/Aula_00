import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;

public class App {
    public static void main (String[] args) throws IOException, InterruptedException {
        String urlFake = "https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json"
        String url = "https://api.themoviedb.org/3/trending/all/week?api_key=" + System.getenv("API_KEY_TMDB") + "&language=pt-BR";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
    }
  }