package group13;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApprovalController{

    AttorneyForm form = null;

    @FXML
    public Label address;

    @FXML
    public Label attorneyFirm;

    @FXML
    public Label attorneyName;

    @FXML
    public Label formid;

    @FXML
    public Label immid;

    @FXML
    public Label name;

    @FXML
    public Button help;

    @FXML
    public Button nextForm;

    @FXML
    public Label phoneNum;

    @FXML
    public Label status;

    public TextField comment;

    @FXML
    public void btnOKClicked(ActionEvent event){
        form = Workflow.getNextApproval();
        if(form == null){
            
            formid.setText("Empty");
            status.setText("Empty");
            address.setText("Empty");
            name.setText("Empty");
            attorneyName.setText("Empty");
            attorneyFirm.setText("Empty");
            phoneNum.setText("Empty");
            immid.setText("Empty");
            comment.setText("Empty");
        }
        else{ 
            formid.setText(""+form.formId);
            status.setText(""+form.status);
            address.setText(form.address);
            name.setText(form.name);
            attorneyName.setText(form.attorneyName);
            attorneyFirm.setText(form.attorneyFirm);
            phoneNum.setText(""+form.phoneNum);
            immid.setText(""+form.immId);
            String comments = "";
            for(int i = 0; i < form.comments.size(); i++){
                comments += form.comments.get(i) + " ";
            }
            comment.setText(comments);
        }
    }

    public void approve(ActionEvent event){
        System.out.println("APPROVED! =)");
    }

    public void reject(ActionEvent event){
        if(form != null){
            form.addComment(comment.getText());
            System.out.println("REJCTED! =(");
            form.sendToWf(1);
        }
    }

    @FXML
    void onHelp(ActionEvent e) throws InterruptedException{
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(this.getClass().getResource("HelpScreen.fxml"));

            Parent parent = loader.load();

            // Show the scene containing the root layout.
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setTitle("Help ");
            stage.setScene(scene);
            stage.show();
           
            
        } catch (IOException f) {
            f.printStackTrace();
        }
    }
}
