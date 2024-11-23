package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class countScreenControl {

	//TextFields
	@FXML private TextField penniesField;
	@FXML private TextField nickelsField;
	@FXML private TextField dimesField;
	@FXML private TextField quartersField;
	@FXML private TextField rPenniesField;
	@FXML private TextField rNickelsField;
	@FXML private TextField rDimesField;
	@FXML private TextField rQuartersField;
	@FXML private TextField dollarField;
	@FXML private TextField twoDollarField;
	@FXML private TextField fiveDollarField;
	@FXML private TextField tenDollarField;
	@FXML private TextField twentyDollarField;
	@FXML private TextField fiftyDollarField;
	@FXML private TextField hundredDollarField;
	
	// Buttons
	@FXML private Button btnFinish;
	@FXML private Button btnClose;
	
	// Labels
	@FXML private Label lblPennies;
	@FXML private Label lblNickels;
	@FXML private Label lblDimes;
	@FXML private Label lblQuarters;
	@FXML private Label lblRPennies;
	@FXML private Label lblRNickels;
	@FXML private Label lblRDimes;
	@FXML private Label lblRQuarters;
	@FXML private Label lblDollar;
	@FXML private Label lblTwoDollar;
	@FXML private Label lblFiveDollar;
	@FXML private Label lblTenDollar;
	@FXML private Label lblTwentyDollar;
	@FXML private Label lblFiftyDollar;
	@FXML private Label lblHundredDollar;
	@FXML private Label lblDrawer;
	@FXML private Label lblCount;
	@FXML private Label lblDifference;
	
	//Logic variable definitions
	private double currentTotal = 0.00;
	private double difference = 0.00;
	private double totalPennies = 0.00;
	private double totalNickels = 0.00;
	private double totalDimes = 0.00;
	private double totalQuarters = 0.00;
	private double totalRPennies = 0.00;
	private double totalRNickels = 0.00;
	private double totalRDimes = 0.00;
	private double totalRQuarters = 0.00;
	private double totalDollars = 0.00;
	private double totalTwos = 0.00;
	private double totalFives = 0.00;
	private double totalTens = 0.00;
	private double totalTwenty = 0.00;
	private double totalFifty = 0.00;
	private double totalHundreds = 0.00;
	
	
	//Logic Methods
	private void calculate() {
		currentTotal = totalPennies + totalNickels + totalDimes + totalQuarters + totalRPennies + 
				totalRNickels + totalRDimes + totalRQuarters + totalDollars + totalTwos + totalFives +
				totalTens + totalTwenty + totalFifty + totalHundreds;
		difference = 250.00 - currentTotal;
		lblCount.setText("Count: $" + currentTotal);
		lblDifference.setText("Difference: $" + difference);
	}
	
	//FXML Linking methods
	@FXML
	private void penny() {
		try {
			totalPennies = Integer.parseInt(penniesField.getText()) * 0.01;
			lblPennies.setText("$" + totalPennies);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalPennies = 0.00;
			calculate();
		}
		
	}
	@FXML
	private void nickel() {
		try {
			totalNickels = Integer.parseInt(nickelsField.getText()) * 0.05;
			lblNickels.setText("$" + totalNickels);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalNickels = 0.00;
			calculate();
		}
	}
	@FXML
	private void dime() {
		try {
			totalDimes = Integer.parseInt(dimesField.getText()) * 0.10;
			lblDimes.setText("$" + totalDimes);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalDimes = 0.00;
			calculate();
		}
	}
	@FXML
	private void quarter() {
		try {
			totalQuarters = Integer.parseInt(quartersField.getText()) * 0.25;
			lblQuarters.setText("$" + totalQuarters);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalQuarters = 0.00;
			calculate();
		}
	}
	@FXML
	private void pennyRoll() {
		try {
			totalRPennies = Integer.parseInt(rPenniesField.getText()) * 0.50;
			lblRPennies.setText("$" + totalRPennies);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalRPennies = 0.00;
			calculate();
		}
	}
	@FXML
	private void nickelRoll() {
		try {
			totalRNickels = Integer.parseInt(rNickelsField.getText()) * 2.00;
			lblRNickels.setText("$" + totalRNickels);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalRNickels = 0.00;
			calculate();
		}
	}
	@FXML
	private void dimeRoll() {
		try {
			totalRDimes = Integer.parseInt(rDimesField.getText()) * 5.00;
			lblRDimes.setText("$" + totalRDimes);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalRDimes = 0.00;
			calculate();
		}
	}
	@FXML
	private void quarterRoll() {
		try {
			totalRQuarters = Integer.parseInt(rQuartersField.getText()) * 10.00;
			lblRQuarters.setText("$" + totalRQuarters);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalRQuarters = 0.00;
			calculate();
		}
	}
	@FXML
	private void dollar() {
		try {
			totalDollars = Integer.parseInt(dollarField.getText()) * 1.00;
			lblDollar.setText("$" + totalDollars);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalDollars = 0.00;
			calculate();
		}
	}
	@FXML
	private void twoDollar() {
		try {
			totalTwos = Integer.parseInt(twoDollarField.getText()) * 2.00;
			lblTwoDollar.setText("$" + totalTwos);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalTwos = 0.00;
			calculate();
		}
	}
	@FXML
	private void fiveDollar() {
		try {
			totalFives = Integer.parseInt(fiveDollarField.getText()) * 5.00;
			lblFiveDollar.setText("$" + totalFives);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalFives = 0.00;
			calculate();
		}
	}
	@FXML
	private void tenDollar() {
		try {
			totalTens = Integer.parseInt(tenDollarField.getText()) * 10.00;
			lblTenDollar.setText("$" + totalTens);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalTens = 0.00;
			calculate();
		}
	}
	@FXML
	private void twentyDollar() {
		try {
			totalTwenty = Integer.parseInt(twentyDollarField.getText()) * 20.00;
			lblTwentyDollar.setText("$" + totalTwenty);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalTwenty = 0.00;
			calculate();
		}
	}
	@FXML
	private void fiftyDollar() {
		try {
			totalFifty = Integer.parseInt(fiftyDollarField.getText()) * 50.00;
			lblFiftyDollar.setText("$" + totalFifty);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalFifty = 0.00;
			calculate();
		}
	}
	@FXML
	private void hundredDollar() {
		try {
			totalHundreds = Integer.parseInt(hundredDollarField.getText()) * 100.00;
			lblHundredDollar.setText("$" + totalHundreds);
			calculate();
			} 
		catch (Exception e) {
			System.out.println("Error: Non Number Entered");
			totalHundreds = 0.00;
			calculate();
		}
	}
	@FXML
	private void handleCloseButtonAction() {
		try {
			if (openingScreenControl.dayStarted == false) {
				Stage stage = (Stage) btnClose.getScene().getWindow();
				stage.setScene(Main.openingScreenScene);
				stage.show();
			}
			else {
				Stage stage = (Stage) btnClose.getScene().getWindow();
				stage.setScene(Main.backOfficeUIScene);
				stage.show();
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@FXML
	private void handleFinishButtonAction() {
		// Finalizes counting?
	}
	
}
