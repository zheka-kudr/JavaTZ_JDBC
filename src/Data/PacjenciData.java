package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PacjenciData {
    private final StringProperty idPacjenta;
    private final StringProperty imiePacjenta;
    private final StringProperty nazwiskoPacjenta;

    public PacjenciData(String idPacjenta, String imiePacjenta, String nazwiskoPacjenta) {
        this.idPacjenta = new SimpleStringProperty(idPacjenta);
        this.imiePacjenta = new SimpleStringProperty(imiePacjenta);
        this.nazwiskoPacjenta = new SimpleStringProperty(nazwiskoPacjenta);
    }

    public String getIdPacjenta() {
        return idPacjenta.get();
    }

    public void setIdPacjenta(String idPacjenta) {
        this.idPacjenta.set(idPacjenta);
    }

    public StringProperty idPacjentaProperty() {
        return idPacjenta;
    }

    public String getImiePacjenta() {
        return imiePacjenta.get();
    }

    public void setImiePacjenta(String imiePacjenta) {
        this.imiePacjenta.set(imiePacjenta);
    }

    public StringProperty imiePacjentaProperty() {
        return imiePacjenta;
    }

    public String getNazwiskoPacjenta() {
        return nazwiskoPacjenta.get();
    }

    public void setNazwiskoPacjenta(String nazwiskoPacjenta) {
        this.nazwiskoPacjenta.set(nazwiskoPacjenta);
    }

    public StringProperty nazwiskoPacjentaProperty() {
        return nazwiskoPacjenta;
    }
}
