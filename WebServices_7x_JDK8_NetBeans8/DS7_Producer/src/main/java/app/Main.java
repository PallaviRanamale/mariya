package app;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
    public static final String BASE_URI = "http://0.0.0.0:5000/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("app.resources");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println("DS 7.x Producer started at " + BASE_URI);
        System.out.println("Try these endpoints:");
        System.out.println("  7.1  http://localhost:5000/calc?a=10&b=4&op=add");
        System.out.println("  7.2  http://localhost:5000/si?p=1000&r=5&t=2");
        System.out.println("  7.3  http://localhost:5000/hello?name=Alice");
        System.out.println("  7.4/7.5  http://localhost:5000/miles_to_km?miles=10");
        System.out.println("Press ENTER to stop...");
        System.in.read();
        server.shutdownNow();
    }
}
