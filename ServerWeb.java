
package serverweb;

import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;




public class ServerWeb {
    
    private static int temperature_courante;
    private static int temperature_chauffage = 20;
    private static boolean etat_radiateur;
    
    public static void main(String[] args) {
        
        
        post("/thermometre", new Route(){
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                
                temperature_courante = Integer.parseInt(rqst.queryParams("temperature"));
                
                if(temperature_courante > temperature_chauffage)
                {
                    etat_radiateur = false;
                }
                
                else{
                    etat_radiateur = true;
                }
                
                return "Bien";
                
            }
            
        });
        
        
        get("/radiateur", new Route(){
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                
                return "{\"radiateur\":"+etat_radiateur+"}";
                
            }
            
        });
        
        post("/smartphone", new Route(){
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                
                temperature_chauffage = Integer.parseInt(rqst.queryParams("chauffage"));
                
                if(temperature_courante > temperature_chauffage)
                {
                    etat_radiateur = false;
                }
                
                else{
                    etat_radiateur = true;
                }
                
                return "Bien";
                
            }
            
        });
        
        get("/smartphone", new Route(){
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                
                return "{\"temperature_courante\":"+temperature_courante+"}";
                
            }
            
        });
        
        
    }
    
}
