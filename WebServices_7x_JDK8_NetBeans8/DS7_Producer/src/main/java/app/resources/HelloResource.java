package app.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    @GET
    public Map<String, String> hello(@QueryParam("name") String name) {
        if (name == null || name.trim().isEmpty()) name = "Guest";
        Map<String, String> out = new LinkedHashMap<String, String>();
        out.put("message", "Hello " + name);
        return out;
    }
}
