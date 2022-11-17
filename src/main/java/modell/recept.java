package modell;
public class recept {
    public String nev;
    public String szerzo;
    public String hozzavalo;
    public String leiras;
    public nehezseg nehezseg;

    public recept(String nev, String szerzo, String hozzavalo, String leiras, nehezseg nehezseg) {
        this.nev = nev;
        this.szerzo = szerzo;
        this.hozzavalo = hozzavalo;
        this.leiras = leiras;
        this.nehezseg = nehezseg;
    }
    
    public String getNev() {
        return nev;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getHozzavalo() {
        return hozzavalo;
    }

    public String getLeiras() {
        return leiras;
    }

    public nehezseg getNehezseg() {
        return nehezseg;
    }
    
    
    
    
}
