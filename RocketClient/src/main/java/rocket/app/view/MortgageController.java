package rocket.app.view;



import javax.swing.ComboBoxEditor;

import eNums.eAction;
import exceptions.RateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML Label txtException;
	@FXML Label txtPayment;
	@FXML Label txtIR;
	@FXML TextField txtIncome;
	@FXML TextField txtExpense;
	@FXML TextField txtDWPM;
	@FXML TextField TxtTerm;
	@FXML ComboBoxEditor cbmCombo;
	
	
	
	private TextField txtNew;
	
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double roundoff = Math.round(Math.abs(lRequest.getdPayment())*100)/100.0;
		txtPayment.setGraphicTextGap(roundoff);
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
	}
	public void HandleRateException(RateException re){
		txtException.setText(re.getMessage());
	}
}
