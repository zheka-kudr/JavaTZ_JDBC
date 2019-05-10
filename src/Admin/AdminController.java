package Admin;

import Data.LekarzeData;
import Data.PacjenciData;
import Data.WizytyData;
import DbUtil.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    @FXML
    public TableColumn<LekarzeData, String> idLekarzaColumn;
    @FXML
    private TextField idPacjentaWizytaTextField;
    @FXML
    private TextField idLekarzaWizytaTextField;
    @FXML
    private TextField pokojWizytaTextField;
    @FXML
    private TextField czyZakonczoneWizytaTextField;
    @FXML
    private TextField czasWizytaTextField;
    @FXML
    private TableColumn<WizytyData, String> idWizytaColumn;
    @FXML
    private TableColumn<WizytyData, String> idPacjentaWizytaColumn;
    @FXML
    private TableColumn<WizytyData, String> idLekarzaWizytaColumn;
    @FXML
    private TableColumn<WizytyData, String> pokojWizytaColumn;
    @FXML
    private TableColumn<WizytyData, String> czyZakonczoneWizytaColumn;
    @FXML
    private TableColumn<WizytyData, String> czasWizytaColumn;
    @FXML
    private TextField imieLekarzaTextField;
    @FXML
    private TextField nazwiskoLekarzaTextField;
    @FXML
    private TextField specjalizacjaLekarzaTextField;
    @FXML
    private TableColumn<LekarzeData, String> imieLekarzaColumn;
    @FXML
    private TableColumn<LekarzeData, String> nazwiskoLekarzaColumn;
    @FXML
    private TableColumn<LekarzeData, String> specjalizacjaLekarzaColumn;


    @FXML
    private TextField imiePacjentaTextField;
    @FXML
    private TextField nazwiskoPacjentaTextField;

    @FXML
    private TableColumn<PacjenciData, String> idPacjentaColumn;
    @FXML
    private TableColumn<PacjenciData, String> imiePacjentaColumn;
    @FXML
    private TableColumn<PacjenciData, String> nazwiskoPacjentaColumn;

    @FXML
    private TableView<LekarzeData> lekarzeTableView;
    @FXML
    private TableView<PacjenciData> pacjenciTableView;
    @FXML
    private TableView<WizytyData> wizytyTableView;

    private ObservableList<LekarzeData> dataLekarze;
    private ObservableList<PacjenciData> dataPacjenci;
    private ObservableList<WizytyData> dataWizyty;

    @FXML
    private static void infoBox(String infoMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    //private String sql_wizyty = "SELECT * from wizyta";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void addLekarzData() {
        String sqlInsertLekarz = "Insert into main.lekarz(ID_Lekarz,Imie, Nazwisko, Specjalizacja) values (?,?,?,?)";
        try {
            Connection connection = DbConnection.connection;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertLekarz);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, this.imieLekarzaTextField.getText());
            preparedStatement.setString(3, this.nazwiskoLekarzaTextField.getText());
            preparedStatement.setString(4, this.specjalizacjaLekarzaTextField.getText());
            preparedStatement.execute();
            cleanLekarzTextFields();
            loadLekarzeData();
            infoBox("Lekarz został dodany");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadLekarzeData() {
        try {
            Connection conn = DbConnection.connection;
            this.dataLekarze = FXCollections.observableArrayList();
            assert conn != null;
            String sql_lekarze = "select * from main.lekarz";
            ResultSet rs = DbConnection.connection.createStatement().executeQuery(sql_lekarze);
            LekarzeData data_lekarze;
            while (rs.next()) {
                data_lekarze = new LekarzeData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                dataLekarze.add(data_lekarze);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.idLekarzaColumn.setCellValueFactory(new PropertyValueFactory<>("idLekarza"));
        this.imieLekarzaColumn.setCellValueFactory(new PropertyValueFactory<>("imieLekarza"));
        this.nazwiskoLekarzaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwiskoLekarza"));
        this.specjalizacjaLekarzaColumn.setCellValueFactory(new PropertyValueFactory<>("specjalizacjaLekarza"));
        this.lekarzeTableView.setItems(null);
        this.lekarzeTableView.setItems(this.dataLekarze);
        cleanLekarzTextFields();
    }

    @FXML
    void deleteLekarzData() {
        String sql_deleteLekarzeData = "delete from main.lekarz where main.lekarz.Imie ='" + imieLekarzaTextField.getText() + "' and main.lekarz.Nazwisko ='" + nazwiskoLekarzaTextField.getText() + "'";
        if (!imieLekarzaTextField.getText().equals("") && !nazwiskoLekarzaTextField.getText().equals("")) {
            try {
                Connection conn = DbConnection.connection;
                PreparedStatement ps;
                ps = conn.prepareStatement(sql_deleteLekarzeData);
                ps.execute();
                ps.close();
                cleanLekarzTextFields();
                loadLekarzeData();
                infoBox("Lekarz został usunięty");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void cleanLekarzTextFields() {
        this.imieLekarzaTextField.setText("");
        this.nazwiskoLekarzaTextField.setText("");
        this.specjalizacjaLekarzaTextField.setText("");
    }

    @FXML
    void addPacjentData() {
        String sqlInsertPacjent = "Insert into main.pacjenci(ID_pacjent,Imie, Nazwisko) values (?,?,?)";
        if (!imiePacjentaTextField.getText().equals("") && !nazwiskoPacjentaTextField.getText().equals("")) {
            try {
                Connection connection = DbConnection.connection;
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertPacjent);
                preparedStatement.setString(1, null);
                preparedStatement.setString(2, this.imiePacjentaTextField.getText());
                preparedStatement.setString(3, this.nazwiskoPacjentaTextField.getText());
                preparedStatement.execute();
                cleanPacjentTextFields();
                loadPacjenciData();
                infoBox("Pacjent został dodany");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            infoBox("Żle podałeś dane");
        }
    }

    @FXML
    void loadPacjenciData() {
        try {
            Connection conn = DbConnection.connection;
            this.dataPacjenci = FXCollections.observableArrayList();
            assert conn != null;
            String sql_pacjenci = "select * from pacjenci";
            ResultSet rs = DbConnection.connection.createStatement().executeQuery(sql_pacjenci);
            PacjenciData data_pacjenci;
            while (rs.next()) {
                data_pacjenci = new PacjenciData(rs.getString(1), rs.getString(2), rs.getString(3));
                dataPacjenci.add(data_pacjenci);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.idPacjentaColumn.setCellValueFactory(new PropertyValueFactory<>("idPacjenta"));
        this.imiePacjentaColumn.setCellValueFactory(new PropertyValueFactory<>("imiePacjenta"));
        this.nazwiskoPacjentaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwiskoPacjenta"));
        this.pacjenciTableView.setItems(null);
        this.pacjenciTableView.setItems(this.dataPacjenci);
        cleanPacjentTextFields();
    }

    @FXML
    void deletePacjentData() {
        String sql_deletePacjentData = "delete from main.pacjenci where main.pacjenci.Imie ='" + imiePacjentaTextField.getText() + "' and main.pacjenci.Nazwisko ='" + nazwiskoPacjentaTextField.getText() + "'";
        if (!imiePacjentaTextField.getText().equals("") && !nazwiskoPacjentaTextField.getText().equals("")) {
            try {
                Connection conn = DbConnection.connection;
                PreparedStatement ps;
                ps = conn.prepareStatement(sql_deletePacjentData);
                ps.execute();
                ps.close();
                cleanPacjentTextFields();
                loadPacjenciData();
                infoBox("Pacjent został usunięty");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            infoBox("Żle podałeś imie lub nazwisko");
        }
    }

    @FXML
    private void cleanPacjentTextFields() {
        this.imiePacjentaTextField.setText("");
        this.nazwiskoPacjentaTextField.setText("");
    }

    @FXML
    public void deleteWizytaData() {
        String sql_deleteWizytaData = "delete from main.wizyta where main.wizyta.ID_Lekarz ='" + idLekarzaWizytaTextField.getText() + "' and main.wizyta.ID_Pacjent ='" + idPacjentaWizytaTextField.getText() + "'";
        if (!idLekarzaWizytaTextField.getText().equals("") && !idPacjentaWizytaTextField.getText().equals("")) {
            try {
                Connection conn = DbConnection.connection;
                PreparedStatement ps;
                ps = conn.prepareStatement(sql_deleteWizytaData);
                ps.execute();
                ps.close();
                cleanWizytaTextFields();
                loadWizytaData();
                infoBox("Wizyta została usunięta");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            infoBox("Żle podałeś imie lub nazwisko");
        }
    }

    @FXML
    void addWizytaData() {
        String sqlInsertWizyta = "Insert into main.wizyta(ID_Wizyta,ID_Pacjent, ID_Lekarz,Pokoj,Czy_zakonczona,Czas) values (?,?,?,?,?,?)";
        if (!idLekarzaWizytaTextField.getText().equals("") && !idPacjentaWizytaTextField.getText().equals("")) {
            try {
                Connection connection = DbConnection.connection;
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertWizyta);
                preparedStatement.setString(1, null);
                preparedStatement.setString(2, this.idPacjentaWizytaTextField.getText());
                preparedStatement.setString(3, this.idLekarzaWizytaTextField.getText());
                preparedStatement.setString(4, this.pokojWizytaTextField.getText());
                preparedStatement.setString(5, this.czyZakonczoneWizytaTextField.getText());
                preparedStatement.setString(6, this.czasWizytaTextField.getText());
                preparedStatement.execute();
                cleanWizytaTextFields();
                loadWizytaData();
                infoBox("Wizyta została dodana");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            infoBox("Żle podałeś dane");
        }
    }

    @FXML
    void loadWizytaData() {
        String sql_wizyty = "SELECT ID_wizyta,ID_Pacjent ,ID_Lekarz ,Pokoj,Czy_zakonczona, Czas  FROM main.wizyta";

        try {
            Connection conn = DbConnection.connection;
            this.dataWizyty = FXCollections.observableArrayList();
            assert conn != null;
            ResultSet rs = DbConnection.connection.createStatement().executeQuery(sql_wizyty);
            WizytyData data_wizyty;
            while (rs.next()) {
                data_wizyty = new WizytyData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                dataWizyty.add(data_wizyty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.idWizytaColumn.setCellValueFactory(new PropertyValueFactory<>("idWizyta"));
        this.idPacjentaWizytaColumn.setCellValueFactory(new PropertyValueFactory<>("idPacjentaWizyta"));
        this.idLekarzaWizytaColumn.setCellValueFactory(new PropertyValueFactory<>("idLekarzaWizyta"));
        this.pokojWizytaColumn.setCellValueFactory(new PropertyValueFactory<>("pokojWizyta"));
        this.czyZakonczoneWizytaColumn.setCellValueFactory(new PropertyValueFactory<>("czyZakonczonyWizyta"));
        this.czasWizytaColumn.setCellValueFactory(new PropertyValueFactory<>("czasWizyta"));
        this.wizytyTableView.setItems(null);
        this.wizytyTableView.setItems(this.dataWizyty);
        cleanPacjentTextFields();
    }

    @FXML
    private void cleanWizytaTextFields() {
        this.idLekarzaWizytaTextField.setText("");
        this.pokojWizytaTextField.setText("");
        this.czyZakonczoneWizytaTextField.setText("");
        this.idPacjentaWizytaTextField.setText("");
        this.czasWizytaTextField.setText("");
    }
}
