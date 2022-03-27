import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class hController implements Initializable{

    @FXML
    private Button btnEnter;

    @FXML
    private TextField inputBox;

    @FXML
    private Label lblOutput;

    @FXML
    void handleButton(ActionEvent event) {
    	try {
    	Hamming h = new Hamming(inputBox.getText());
    	lblOutput.setText("The codified value of " +  h.getUnCodified()  + " is: "+  h.toString());
    	lblOutput.setVisible(true);
    	} catch (IllegalArgumentException e) {
    		lblOutput.setText("Entered value is not valid, retry");
    		lblOutput.setVisible(true);
    	}
    }

	public void initialize(URL location, ResourceBundle resources) {
		lblOutput.setVisible(false);
		
	}
	
	public class Hamming {
	    /**
	     * OVERVIEW: 
	     * The istances in this class represent a sequence of bits in binary codified in Hamming code(7, 4)
	     * 
	     * This type of hamming code provides 3 check bts for every 4 data bits.
	     * In general: a hamming code of minimal distance of \delta:
	     *             |\delta-1| = detectable errors
	     *             |\delta-1 / 2| = detectable and correctable errors
	     * 
	     * 
	     * Quote:
	     * "In coding theory, Hamming(7,4) is a linear error-correcting code that encodes four bits of 
	     * data into seven bits by adding three parity bits. It is a member of a larger family of Hamming 
	     * codes, but the term Hamming code often refers to this specific code that Richard W. Hamming 
	     * introduced in 1950. At the time, Hamming worked at Bell Telephone Laboratories and was frustrated
	     * with the error-prone punched card reader, which is why he started working on error-correcting codes."
	     * @link https://en.wikipedia.org/wiki/Hamming(7,4)
	     * 
	     * AF: ("codified") 
	     *     codified[0] &&  ... && codified[n-1]
	     * 
	     * IR:  uncodified != null && 
	     *      (uncodified[i] with i = n) where n = uncodified.length
	     *          uncodified[i] == "0" || uncodified[i] == "1" &&
	     *      codified != null && 
	     *      (codified[i] with i = n) where n = codified.length
	     *          codified[i] == "0" || codified[i] == "1" &&
	     *      
	     *      
	     */



	    private int[] uncodified;
	    private int[] codified;

	    /**
	     * Istantiates a new Hamming element, and codifies it into a a (7,4) codified Hamming Code
	     * @param input String of bits to codify
	     */
	    public Hamming(String input){
	        if (input.length() != 4) throw new IllegalArgumentException("The input string cannot be of length != 4");

	        String[] s = input.split("");

	        uncodified = new int[input.length()];
	        int i = 0;
	        for (String c : s){
	            if (!c.equals("0") && !c.equals("1")) throw new IllegalArgumentException("The values inside a pre-codified message cannot contain characters different from 0 and 1");
	            uncodified[i] = Integer.valueOf(c);
	            i++;
	        } 
	        codifyIntoHamming();
	        assert repOk();
	    }

	    /**
	     * 
	     */
	    private void codifyIntoHamming() {
	        codified = new int[uncodified.length + 3];
	        codified[0] = (uncodified[0] + uncodified[1] + uncodified[3]) % 2;
	        codified[1] = (uncodified[0] + uncodified[2] + uncodified[3]) % 2;
	        codified[3] = (uncodified[1] + uncodified[2] + uncodified[3]) % 2;
	        codified[2] = uncodified[0];
	        codified[4] = uncodified[1];
	        codified[5] = uncodified[2];
	        codified[6] = uncodified[3];
	        assert repOk();
	    }

	    /**
	     * 
	     * @return true if IR is preserved, false otherwise
	     */
	    public boolean repOk(){
	        if (uncodified == null) return false;
	            for (int n : uncodified){
	                if (n != 0 && n != 1){
	                    return false;
	                }
	            }
	            if (codified == null) return false;
	            for (int n : codified){
	                if (n != 0 && n != 1){
	                    return false;
	                }
	            }


	            return true;
	    }

	    /**
	     * Returns a (7, 4) codified in Hamming Code sequence of a previously istantiated sequence of bits
	     */
	    public String getCodified() {
	        return toString();
	    }
	    
	    public String getUnCodified() {
	    	String output = "";
	    	for (int n : uncodified) {
	    		output = output + n;
	    	}
	    	return output;
	    }

	    @Override
	    public String toString() {
	        String output = "";
	        for (int n : codified){
	            output = output + n;
	        }
	        return output;
	    }
	}

	
}



