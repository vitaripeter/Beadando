package modell;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class xmlSave {
    public void write(recept ujrecept) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File("C:\\Users\\Dell\\Desktop\\IEXSL1_Beadando\\src\\main\\resources\\recepies.xml");
            Document doc = db.parse(f);
            doc.normalize();
            
            Element root = doc.getDocumentElement();
            Element recept = doc.createElement("recept");
            root.appendChild(recept);
            
            Element nev = doc.createElement("nev");
            Element szerzo = doc.createElement("szerzo");
            Element hozzavalo = doc.createElement("hozzavalo");
            Element leiras = doc.createElement("leiras");
            Element nehezseg = doc.createElement("nehezseg");
            
            nev.setTextContent(ujrecept.getNev());
            szerzo.setTextContent (ujrecept.getSzerzo());
            hozzavalo.setTextContent(ujrecept.getHozzavalo());
            leiras.setTextContent(ujrecept.getLeiras());
            nehezseg.setTextContent(ujrecept.getNehezseg().toString());
            
            recept.appendChild(nev);
            recept.appendChild(szerzo);
            recept.appendChild(hozzavalo);
            recept.appendChild(leiras);
            recept.appendChild(nehezseg);
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            
            t.transform(source, result);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
