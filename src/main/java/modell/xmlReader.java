package modell;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class xmlReader {
        public JSONArray olvas() {
        JSONArray receptek = new JSONArray();
        
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File("C:\\Users\\Dell\\Desktop\\IEXSL1_Beadando\\src\\main\\resources\\recepies.xml");
            Document doc = db.parse(f);
            doc.normalize();
            
            NodeList nodeList = doc.getElementsByTagName("recept");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element el = (Element) nodeList.item(i);
                JSONObject recept = new JSONObject();
                
                    String nev = el.getElementsByTagName("nev").item(0).getTextContent();
                    String szerzo = el.getElementsByTagName("szerzo").item(0).getTextContent();
                    String hozzavalo = el.getElementsByTagName("hozzavalo").item(0).getTextContent();
                    String leiras = el.getElementsByTagName("leiras").item(0).getTextContent();
                    String nehezseg = el.getElementsByTagName("nehezseg").item(0).getTextContent();
                    
                    
                    recept.put("nev", nev);
                    recept.put("szerzo", szerzo);
                    recept.put("hozzavalo", hozzavalo);
                    recept.put("leiras", leiras);
                    recept.put("nehezseg", nehezseg);
                    
                    
                receptek.put(recept);
            }
         
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
            System.out.println(receptek);
        return receptek;
    }
    
}
