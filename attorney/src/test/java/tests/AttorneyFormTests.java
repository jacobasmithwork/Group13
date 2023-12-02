package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.*;

import group13.AttorneyForm;
import group13.Workflow;

public class AttorneyFormTests {
    AttorneyForm af;

    @Before
    public void setUp() {
        af = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", "Cool Guy Firm", 123, 8042413788L); // without 'L', treated as int.
    }

    @After
    public void cleanUp() {
        try{
            af.removeFromDb();
        }
        catch(Exception e){
            
        }
    }

    @Test
    public void testGetters() {
        assertEquals(af.getName(), "Bob");
        assertEquals(af.getAddress(), "5503 Main Street");
        assertEquals(af.getAttorneyName(), "Jim Smith");
        assertEquals(af.getImmId(), 123);
        assertEquals(af.getPhoneNum(), 8042413788L);
    }

    @Test
    public void testSetters() {
        af.setName("Andre");
        af.setAddress("4122 Ox Drive");
        af.setAttorneyName("Blanche Diaz");
        af.setImmId(321);
        af.setPhoneNum(7744237844L);

        assertEquals(af.getName(), "Andre");
        assertEquals(af.getAddress(), "4122 Ox Drive");
        assertEquals(af.getAttorneyName(), "Blanche Diaz");
        assertEquals(af.getImmId(), 321);
        assertEquals(af.getPhoneNum(), 7744237844L);
    }

    @Test
    public void testSendToWf() {
        af.sendToWf(1);
        assertTrue("Did not add to review workflow.", Workflow.getReviewQueue().getLast() == af.formId);

        af.sendToWf(2);
        assertTrue("Did not add to approval workflow.", Workflow.getApproveQueue().getLast() == af.formId);
    }

    @Test(expected = NullPointerException.class) // Should throw NullPointerException
    public void testNullSendToWf() {
        af = null;
        af.sendToWf(1);
    }

    @Test
    public void getDb(){
        assertTrue("Didn't work", AttorneyForm.getDatabase() != null);
    }

    @Test
    public void testSendToDb() {
        int form = af.sendToDb();
        // Once DB implemented, replace 'false' with DB.contains(formId)or contains(af)
        assertTrue("Did not add to database", AttorneyForm.getForm(form) != null);
    }

    @Test
    public void testUpdateDb() {
        af.setPhoneNum(8039002322L);
        af.updateDb();
        // Once DB implemented, replace 'false' with DB.getForm(id).getPhoneNum ==
        // 8039002322L
        assertTrue("Did not add to database", AttorneyForm.getForm(af.getFormId()).getPhoneNum() == 8039002322L);
    }

    @Test
    public void testPurgeDb(){
        af.sendToDb();
        AttorneyForm.purgeDb();
<<<<<<< HEAD
        HashMap<Integer, AttorneyForm> database = AttorneyForm.getDatabase();
        assertEquals("Purge failed.", 0, database.size());
=======
        assertTrue("Did not purge database", AttorneyForm.getDatabase().size() == 0);
>>>>>>> 8d2649e3ab2a40d5dcf7f9ae287cd16b0cc15ed1
    }
}