package LoginPage;

import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class loginPagePasswordTests extends BaseTests {


    @Test ( priority = 1, description = "Verify that user cannot enter empty Confirmation Password" )
    public void testLogin_Password_Empty( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String passwordStatus = login.getPassword_Status();
        System.out.println( "passwordStatus: >>> " + passwordStatus );
        assertTrue( passwordStatus.contains( "Password Is Required" ) , "Empty Password Not Fine" );

    }



}
