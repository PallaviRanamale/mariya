package app.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("miles_to_km")
@Produces(MediaType.APPLICATION_JSON)
public class MilesResource {

    @GET
    public Map<String, Object> milesToKm(@QueryParam("miles") Double miles) {
        Map<String, Object> out = new LinkedHashMap<String, Object>();
        if (miles == null) {
            out.put("km", "error: provide miles");
            return out;
        }
        out.put("km", miles * 1.60934);
        return out;
    }
}
