package group13;
import java.io.IOException;

public class dummy {
    public static void main(String[] args){
        AttorneyForm A = new AttorneyForm("Mark Douglas", "4602 Chain Bridge Rd", "Violet Drake", "Cool Guy Firm", 904, 7266028841L, 9541);
        AttorneyForm B = new AttorneyForm("Shmerle Smoothie", "7832 Driveway Dr", "Charles Dude", "Cool Guy Firm", 712, 7035442594L, 7723);
        AttorneyForm C = new AttorneyForm("Jesser Pinkguy", "1234 ThisStreet Dr", "Mr Laywer Man", "Cool Guy Firm", 984, 4153467782L, 1235);
        AttorneyForm D = new AttorneyForm("Walt White", "308 Negra Arroyo Ln", "Saul Gman", "Cool Guy Firm", 143, 5051178987L, 8888);

        AttorneyForm[] formQueue = {A,B,C,D};

        for(AttorneyForm af : formQueue){
            int id = af.sendToWf(1);
            af.setFormId(id);
        }

        Workflow.printQueues();
        for(int i=0; i < formQueue.length; i++){
            int test = formQueue[i].formId;
            int id = Workflow.getNextReview().getFormId();
            System.out.println(("GetReviewQueue Error: mismatching formId: " + test +" : "+ id));
            formQueue[i].removeFromDb();
        }
        // AttorneyForm.purgeDb();
    }
}
