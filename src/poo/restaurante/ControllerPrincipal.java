package poo.restaurante;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerPrincipal {


    @FXML
    private ComboBox<?> comboBoxOcupadas; // seleciona  as ocupadas

    @FXML
    private ComboBox<String> comboBoxGarcom; //seleciona  os garcons


    @FXML
    private ListView<Mesa> listViewOcupadas; //lista as  ocupadas

    @FXML
    private ListView<Mesa> listViewReservadas; //lista as ocupadas

    @FXML
    private ListView<Mesa> listViewLivres; // lista as livres




    private ObservableList<Mesa> obsMesas; //observa as mesas no geral
    private ObservableList<Mesa> obsMesasOcupadas;//observa as ocupadas



    private FachadaMesas mesas = new FachadaMesas();



    @FXML
    private Button botaoDesocuparMesa; //

    @FXML
    private Button botaoAbrirMesa; // abre a mesa

    @FXML
    private Button botaoReservarMesa; //reserva a mesa

    @FXML
    private ComboBox<?> comboBoxPedidos; // seleciona os pedidos


    private static ArrayList<ObsMudaTela> ouvintes = new ArrayList<ObsMudaTela>();

    public static interface ObsMudaTela {
        void mudaTela(Object objetoQualquer);
    }

    public static void addMudaTela(ObsMudaTela novoOuvinte) {
        ouvintes.add(novoOuvinte);
    }

    public static void notificaOuvintes(Object dado) {
        for (ObsMudaTela o : ouvintes) {
            o.mudaTela(dado);
        }
    }






    @FXML
    public void initialize() {
        carregandoMesas();

    }

// cria as mesas
    public void carregandoMesas() {
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);


//        System.out.println("TESTES -> "+mesa1.getComanda().pedidos[0].garcom.getNome());

// define as mesas como livres
        mesas.mesasLivres.add(mesa1);
        mesas.mesasLivres.add(mesa2);
        mesas.mesasLivres.add(mesa3);
        mesas.mesasLivres.add(mesa4);


        obsMesas = FXCollections.observableArrayList(mesas.mesasLivres); // cria a colecao e observa as mesas livres
        obsMesasOcupadas = FXCollections.observableArrayList(mesas.mesasLivres); //  cria a colecao de mesas oocupadas

        listViewLivres.setItems(obsMesas); // seta as mesas livres
        listViewOcupadas.setItems(obsMesas); // seta as mesas ocuppadas

    }
    @FXML
    void imprime(ActionEvent event) {
//
//        System.out.println("teste");
//        Mesa objMesa = listViewLivres.getSelectionModel().getSelectedItem();
//        listViewLivres.getSelectionModel().clearSelection();
//
//        mesas.remove(objMesa);
//
//        System.out.println(mesasOcupadas.isEmpty());
//
//        mesasOcupadas.add(objMesa);
//
//
//        obsMesas = FXCollections.observableArrayList(mesas);
//        obsMesasOcupadas = FXCollections.observableArrayList(mesas);
//
////        listViewLivres.setItems(obsMesas);
////        listViewOcupadas.setItems(obsMesasOcupadas);
//
//
    } // desocupa a mesa
    @FXML
    void desocupar(ActionEvent event){
        Mesa m = listViewOcupadas.getSelectionModel().getSelectedItem() ; // cria um objeto mesa m
        if (m == null) return;
        m.setEstaLivre(true);// seta m como livre
        listViewLivres.getItems().add(m);
        listViewOcupadas.getItems().remove(m); // remove m das mesas ocupadas


    }
    // ocupa uma mesa
    @FXML
    void ocupar(ActionEvent event){
        Mesa m = listViewOcupadas.getSelectionModel().getSelectedItem() ;
        if (m == null) return;
        m.setEstaOcupado(true); //seta m como ocupada
        listViewOcupadas.getItems().add(m);
        listViewLivres.getItems().remove(m); // remove m das mesas livres


    }

    @FXML

    public void abrirMesa(ActionEvent event) throws IOException {
//        Stage stage1 = (Stage) botaoAbrirMesa.getScene().getWindow();
//        stage1.close();


        FXMLLoader load = new FXMLLoader(this.getClass().getResource("view/Comanda.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        System.out.println(listViewLivres.getSelectionModel().getSelectedItem());

        notificaOuvintes(listViewLivres.getSelectionModel().getSelectedItem());
        stage.show();
    }


}
