package app.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calc")
@Produces(MediaType.APPLICATION_JSON)
public class CalcResource {

    @GET
    public Map<String, Object> calc(@QueryParam("a") Double a,
                                    @QueryParam("b") Double b,
                                    @QueryParam("op") String op) {

        Map<String, Object> out = new LinkedHashMap<String, Object>();

        if (a == null || b == null || op == null) {
            out.put("result", "error: provide a, b, op");
            return out;
        }

        Object ans;
        if ("add".equals(op)) ans = a + b;
        else if ("sub".equals(op)) ans = a - b;
        else if ("mul".equals(op)) ans = a * b;
        else if ("div".equals(op)) ans = (b != 0) ? (a / b) : "error: divide by zero";
        else ans = "unknown operation";

        out.put("result", ans);
        return out;
    }
}
