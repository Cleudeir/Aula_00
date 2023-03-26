import java.net.URI; // import the URI class from the java.net package
import java.net.http.HttpClient; // import the HttpClient class from the java.net.http package
import java.net.http.HttpRequest; // import the HttpRequest class from the java.net.http package
import java.net.http.HttpResponse; // import the HttpResponse class from the java.net.http package
import java.net.http.HttpResponse.BodyHandlers; // import the BodyHandlers class from the java.net.http.HttpResponse package
import java.io.IOException; // import the IOException class from the java.io package

public class App {
    public static void main (String[] args) throws IOException, InterruptedException {
        // Define a URL to a JSON file stored on GitHub as a string variable called urlFake
        String urlFake = "https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json";
        
        // Define a URL to a movie database API endpoint as a string variable called url, and append an API key and language parameter using the System.getenv() method to retrieve an environment variable
        String url = "https://api.themoviedb.org/3/trending/all/week?api_key=" + System.getenv("API_KEY_TMDB") + "&language=pt-BR";
        
        // Create a new instance of the HttpClient class
        HttpClient client = HttpClient.newHttpClient();
        
        // Create a new instance of the HttpRequest class by calling the newBuilder() method and passing in the URI of the movie database API endpoint, then setting the HTTP method to GET
        HttpRequest req = HttpRequest.newBuilder(URI.create(url)).GET().build();
        
        // Send the HTTP request to the API endpoint using the HttpClient.send() method and passing in the HttpRequest object and a BodyHandlers.ofString() instance to specify that the response body should be returned as a string
        HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
        
        // Store the response body as a string variable called json
        String json = resp.body();
        
        // Print the value of the json variable to the console
        System.out.println(json);
    }
}
