package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LekarzeData {
    private final StringProperty idLekarza;
    private final StringProperty imieLekarza;
    private final StringProperty nazwiskoLekarza;
    private final StringProperty specjalizacjaLekarza;

    public LekarzeData(String idLekarza, String imieLekarza, String nazwiskoLekarza, String specjalizacjaLekarza) {
        this.idLekarza = new SimpleStringProperty(idLekarza);
        this.imieLekarza = new SimpleStringProperty(imieLekarza);
        this.nazwiskoLekarza = new SimpleStringProperty(nazwiskoLekarza);
        this.specjalizacjaLekarza = new SimpleStringProperty(specjalizacjaLekarza);
    }

    public String getIdLekarza() {
        return idLekarza.get();
    }

    public void setIdLekarza(String idLekarza) {
        this.idLekarza.set(idLekarza);
    }

    public StringProperty idLekarzaProperty() {
        return idLekarza;
    }

    public String getImieLekarza() {
        return imieLekarza.get();
    }

    public void setImieLekarza(String imieLekarza) {
        this.imieLekarza.set(imieLekarza);
    }

    public StringProperty imieLekarzaProperty() {
        return imieLekarza;
    }

    public String getNazwiskoLekarza() {
        return nazwiskoLekarza.get();
    }

    public void setNazwiskoLekarza(String nazwiskoLekarza) {
        this.nazwiskoLekarza.set(nazwiskoLekarza);
    }

    public StringProperty nazwiskoLekarzaProperty() {
        return nazwiskoLekarza;
    }

    public String getSpecjalizacjaLekarza() {
        return specjalizacjaLekarza.get();
    }

    public void setSpecjalizacjaLekarza(String specjalizacjaLekarza) {
        this.specjalizacjaLekarza.set(specjalizacjaLekarza);
    }

    public StringProperty specjalizacjaLekarzaProperty() {
        return specjalizacjaLekarza;
    }
}
