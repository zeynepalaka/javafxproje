package application;

import java.util.Optional;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable{

    @FXML
    private TableView<sınıf> tablo1;

    @FXML
    private TableColumn<sınıf, String> ad;

    @FXML
    private TableColumn<sınıf, String> memleket;

    @FXML
    private TableColumn<sınıf, String> meslek;

    @FXML
    private TableColumn<sınıf, String> cinsiyet;

    @FXML
    private TableColumn<sınıf, Double> ates;

    @FXML
    private TableColumn<sınıf, String> teshis;

    @FXML
    private Button btnekle;

    @FXML
    private Button btnguncelle;

    @FXML
    private Button btnsil;

    @FXML
    private Button btnsorgula;

    @FXML
    private Slider slider;

    @FXML
    private CheckBox checkdurum;

    @FXML
    private Label labeldeger;

    @FXML
    private TextField textfied;

    @FXML
    private ComboBox< String> combobox;

    @FXML
    private RadioButton rdmemur;

    @FXML
    private RadioButton rdkadın;

    @FXML
    private ToggleGroup cnsyt;

    @FXML
    private RadioButton rderkek;

    @FXML
    private RadioButton rdemekli;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rdisci;

    @FXML
    private RadioButton rdogrenci;

    @FXML
    void event_ekle(ActionEvent event) {
    	ObservableList<Object> veriler=FXCollections.observableArrayList();
    	String hastaadi=textfied.getText();
    	String sehir=combobox.getSelectionModel().getSelectedItem();
    	String isci=null;
    	if(rdogrenci.isSelected())
    	{
    		isci="Öğrenci";
    	}
    	if(rdisci.isSelected())
    	{
    		isci="İşçi";
    	}
    	if(rdemekli.isSelected())
    	{
    		isci="Emekli";
    	}
    	if(rdmemur.isSelected())
    	{
    		isci="Memur";
    	}
    	
    	String cins=null;
    	if(rderkek.isSelected())
    	{
    		cins="Erkek";
    	}
    	if(rdkadın.isSelected())
    	{
    		cins="Kadın";
    	}
    	Double atesderece=slider.getValue();
    	String sonuc=null;
    	if(checkdurum.isSelected())
    	{
    		sonuc="Pozitif";
    	}
    	else 
    	{
    		sonuc="Negatif";
    	}
    	
    	veriler.add(new sınıf(hastaadi,sehir,isci,cins,atesderece,sonuc));
    	tablo1.getItems().addAll( veriler);
    	ad.setText(" ");
    	combobox.setValue(null);
    	slider.setValue(36.4);
    	labeldeger.setText("0.0");
    	//onay kutusu
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText("Ekleme İşlemi Başarılı :) ");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		Optional<ButtonType> result = alert.showAndWait();
    	
    
    }
    @FXML
    void event_guncelle(ActionEvent event) {
    	
    	sınıf sınıf = new sınıf();
	    sınıf= (sınıf) tablo1.getItems().get(tablo1.getSelectionModel().getSelectedIndex());
		
		String ad1 = ad.getText();
		String memleket1 = combobox.getSelectionModel().getSelectedItem();
		RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
		String meslek = selectedRadioButton.getText();
		RadioButton selectedRadioButton1 = (RadioButton) cnsyt.getSelectedToggle();
		String cinsiyet = selectedRadioButton1.getText();
		Double ates = Double.parseDouble(labeldeger.getText());

		String durum1=null;
		if (checkdurum.isSelected()) {
			durum1 = "virüslü";
		} else {
			durum1 = "virüs değil";
		}
		sınıf kk = new sınıf(ad1, memleket1, meslek,cinsiyet , ates, durum1);
		int sira = tablo1.getSelectionModel().getSelectedIndex();
		tablo1.getItems().set(sira, kk);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText("Güncelleme İşlemi");
		alert.setContentText("Emin misiniz?");
		ButtonType buttonTypeOne = new ButtonType("Güncelle");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
		Optional<ButtonType> result = alert.showAndWait();
	}

    

    @FXML
    void event_sil(ActionEvent event) {
    	ObservableList<sınıf> secilenKayit, tumKayitlar;
		tumKayitlar = tablo1.getItems();
		secilenKayit = tablo1.getSelectionModel().getSelectedItems();
		secilenKayit.forEach(tumKayitlar::remove);
		//onay kutusu
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText("Silme İşlemi");
		alert.setContentText("Emin misiniz?");
		ButtonType buttonTypeOne = new ButtonType("Sil");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
		Optional<ButtonType> result = alert.showAndWait();
    }

    @FXML
    void event_sorgula(ActionEvent event) {
    	double toplam=0;
        int sayi=0;
        double ortalama=0;
        for(sınıf per : tablo1.getItems())
        {
       	 if(per.getMemleket().equalsIgnoreCase(combobox.getSelectionModel().getSelectedItem()) && per.getTeshis().equalsIgnoreCase("virüs taşıyor"))
       	 {
       		 toplam+=per.getAtes();
       		 ++sayi;
       	 }
        }

    }
    @FXML
    void event_mouseclick(MouseEvent event) {
    	sınıf sınıf=new sınıf();
    	sınıf=(sınıf)
    	tablo1.getItems().get(tablo1.getSelectionModel().getSelectedIndex());
    	ad.setText(sınıf.getAd());
    	combobox.setValue(sınıf.getMemleket());
    	if(sınıf.getCinsiyet().equals("Erkek"))
    	{
    		rderkek.setSelected(true);
    	}
    	if(sınıf.getCinsiyet().equals("Kadın"))
    	{
    		rdkadın.setSelected(true);
    	}
    	if(sınıf.getTeshis().equals("Pozitif"))
    	{
    		checkdurum.setSelected(true);
    	}
    	else 
    	{
    		checkdurum.setSelected(false);
    	}
    	if(sınıf.getMeslek().equals("Öğrenci"))
    	{
    		rdogrenci.setSelected(true);
    	}
    	else if(sınıf.getMeslek().equals("İşçi"))
    	{
    		rdisci.setSelected(true);
    	}
    	else if(sınıf.getMeslek().equals("Emekli"))
    	{
    		rdemekli.setSelected(true);
    	}
    	else if(sınıf.getMeslek().equals("Memur"))
    	{
    		rdmemur.setSelected(true);
    	}
    	slider.setValue(sınıf.getAtes());
    	labeldeger.setText(sınıf.getAtes().toString());
    }
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
	
		
		// TODO Auto-generated method stub
		ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
		memleket.setCellValueFactory(new PropertyValueFactory<>("memleket"));
		meslek.setCellValueFactory(new PropertyValueFactory<>("meslek"));
		cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
		ates.setCellValueFactory(new PropertyValueFactory<>("ates"));
		teshis.setCellValueFactory(new PropertyValueFactory<>("teshis"));
		combobox.getItems().addAll("Hatay", "Ankara", "Istanbul", "Gaziantep", "Adana");
		slider.valueProperty().addListener((obs, OldValue, newValue) -> {

			labeldeger.setText(newValue.toString());
		});
		
	}
    
    
  
 
    }
    
