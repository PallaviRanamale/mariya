package app.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("si")
@Produces(MediaType.APPLICATION_JSON)
public class SIResource {

    @GET
    public Map<String, Object> si(@QueryParam("p") Double p,
                                  @QueryParam("r") Double r,
                                  @QueryParam("t") Double t) {
        Map<String, Object> out = new LinkedHashMap<String, Object>();
        if (p == null || r == null || t == null) {
            out.put("simple_interest", "error: provide p, r, t");
            return out;
        }
        out.put("simple_interest", (p * r * t) / 100.0);
        return out;
    }
}
