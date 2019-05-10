package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WizytyData {
    private final StringProperty idWizyta;
    private final StringProperty idPacjentaWizyta;
    private final StringProperty idLekarzaWizyta;
    private final StringProperty pokojWizyta;
    private final StringProperty czyZakonczonyWizyta;
    private final StringProperty czasWizyta;

    public WizytyData(String idWizyta, String idPacjentaWizyta, String idLekarzaWizyta, String pokojWizyta, String czyZakonczonyWizyta, String czasWizyta) {
        this.idWizyta = new SimpleStringProperty(idWizyta);
        this.idPacjentaWizyta = new SimpleStringProperty(idPacjentaWizyta);
        this.idLekarzaWizyta = new SimpleStringProperty(idLekarzaWizyta);
        this.pokojWizyta = new SimpleStringProperty(pokojWizyta);
        this.czyZakonczonyWizyta = new SimpleStringProperty(czyZakonczonyWizyta);
        this.czasWizyta = new SimpleStringProperty(czasWizyta);
    }

    public String getIdWizyta() {
        return idWizyta.get();
    }

    public void setIdWizyta(String idWizyta) {
        this.idWizyta.set(idWizyta);
    }

    public StringProperty idWizytaProperty() {
        return idWizyta;
    }

    public String getIdPacjentaWizyta() {
        return idPacjentaWizyta.get();
    }

    public void setIdPacjentaWizyta(String idPacjentaWizyta) {
        this.idPacjentaWizyta.set(idPacjentaWizyta);
    }

    public StringProperty idPacjentaWizytaProperty() {
        return idPacjentaWizyta;
    }

    public String getIdLekarzaWizyta() {
        return idLekarzaWizyta.get();
    }

    public void setIdLekarzaWizyta(String idLekarzaWizyta) {
        this.idLekarzaWizyta.set(idLekarzaWizyta);
    }

    public StringProperty idLekarzaWizytaProperty() {
        return idLekarzaWizyta;
    }

    public String getPokojWizyta() {
        return pokojWizyta.get();
    }

    public void setPokojWizyta(String pokojWizyta) {
        this.pokojWizyta.set(pokojWizyta);
    }

    public StringProperty pokojWizytaProperty() {
        return pokojWizyta;
    }

    public String getCzyZakonczonyWizyta() {
        return czyZakonczonyWizyta.get();
    }

    public void setCzyZakonczonyWizyta(String czyZakonczonyWizyta) {
        this.czyZakonczonyWizyta.set(czyZakonczonyWizyta);
    }

    public StringProperty czyZakonczonyWizytaProperty() {
        return czyZakonczonyWizyta;
    }

    public String getCzasWizyta() {
        return czasWizyta.get();
    }

    public void setCzasWizyta(String czasWizyta) {
        this.czasWizyta.set(czasWizyta);
    }

    public StringProperty czasWizytaProperty() {
        return czasWizyta;
    }
}
