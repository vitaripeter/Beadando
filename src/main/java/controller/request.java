package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modell.nehezseg;
import modell.recept;
import modell.xmlReader;
import modell.xmlSave;
import org.json.JSONArray;
import org.json.JSONObject;


@Path("resources")
public class request {
    
    @GET
    @Path("getAllrecept")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getrecept(){
        xmlReader olvaso = new xmlReader();
        JSONArray receptek = olvaso.olvas();
        return Response.ok(receptek.toString()).build();
    }
    
    @POST
    @Path("getAllrecept")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newrecept(String recept){
        JSONObject recept_json = new JSONObject(recept);
        recept ujrecept = new recept(recept_json.getString("nev"), recept_json.getString("szerzo"), recept_json.getString("hozzavalo"), recept_json.getString("leiras"), nehezseg.valueOf(recept_json.getString("nehezseg")));
        xmlSave iro = new xmlSave();
        iro.write(ujrecept);
    return Response.ok().build();
    }
    
}
