package Controllers;

import Models.CSEDUPORTALUtils;
import Models.DATAHUB;
import Models.DBDATAGETTER;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {
    @FXML
    private  Button LoginScreenSignup;

    @FXML
    private TextField userRegistration;
    @FXML
    private PasswordField userPassword;
    @FXML
    private Button loginButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoginScreenSignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CSEDUPORTALUtils.changeScence(actionEvent,"SignupScreen.fxml","Sign Up",null);

            }
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!userRegistration.getText().equals("")){

                    CSEDUPORTALUtils.loginUser(actionEvent,userRegistration.getText(),userPassword.getText());
//                    System.out.println(DBDATAGETTER.getSemester().isEmpty());
                    DATAHUB.DataProvider();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Registration Can't Be Empty");
                    alert.show();
                }


            }
        });
    }


}
