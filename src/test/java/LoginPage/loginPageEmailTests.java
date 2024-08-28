package LoginPage;

import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class loginPageEmailTests extends BaseTests {


    @Test ( priority = 1, description = "Verify that user cannot enter empty Email" )
    public void testLogin_Email_Empty( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String email_status = login.getEmail_Status( );
        System.out.println( "email_status: >>> " + email_status );
        assertTrue( email_status.contains( "Email Is Required" ) , "Empty Email Not Fine" );

    }

    @Test ( priority = 2, description = "Verify that user can enter Email with valid Format [ example@example.com ]" )
    public void testLogin_Email_AcceptsOnlyValidFormat( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean email_Status = login.getEmailStatus_FoundOrNot( );
        System.out.println( "email_Status: >>> " + email_Status );
        assertFalse( email_Status , "Email Valid Format Not Fine" );
    }

    @Test ( priority = 3, description = "Verify that user cannot enter with InValid Format [ QwizeenUser.com ]" )
    public void testLogin_Email_InValidFormat_withoutAT( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String email_status = login.getEmail_Status( );
        System.out.println( "email_status: >>> " + email_status );
        assertTrue( email_status.contains( "Email Is Not Valid" ) , "Email InValid Format without @ Not Fine" );
    }

    @Test ( priority = 4, description = "Verify that user cannot enter with InValid Format [ QwizeenUser@example ]" )
    public void testLogin_Email_InValidFormat_withoutDomain( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String email_status = login.getEmail_Status( );
        System.out.println( "email_status: >>> " + email_status );
        assertTrue( email_status.contains( "Email Is Not Valid" ) , "Email InValid Format without Domain Not Fine" );
    }



}
