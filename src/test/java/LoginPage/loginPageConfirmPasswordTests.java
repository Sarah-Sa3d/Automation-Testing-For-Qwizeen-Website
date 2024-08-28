package LoginPage;

import Pages.LoginPage;
import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class loginPageConfirmPasswordTests extends BaseTests {


    @Test ( priority = 1, description = "Verify that user cannot enter empty Password on Confirm Password " )
    public void testLogin_ConfirmPassword_Empty( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "" );
        login.clickSubmit( );

        String confirmPasswordStatus = login.getConfirmPassword_Status();
        System.out.println( "confirmPasswordStatus: >>> " + confirmPasswordStatus );
        assertTrue( confirmPasswordStatus.contains( "Confirm Password Is Required" ) , "Empty Confirm Password Not Fine" );

    }

    @Test ( priority = 1 , description = "Verify That User Can Enter Valid Matched Password" )
    @Severity( SeverityLevel.CRITICAL )
    public void testLogin_ConfirmPassword_MatchingPassword( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean confirmPasswordStatus_foundOrNot = login.getConfirmPasswordStatus_FoundOrNot( );
        System.out.println( "confirmPasswordStatus_foundOrNot: >>> " + confirmPasswordStatus_foundOrNot );
        assertFalse( confirmPasswordStatus_foundOrNot , "Matching Confirm Password with password Not Fine" );

    }


    @Test ( priority = 1, description = "Verify that user cannot enter empty Confirmation Password" )
    public void testLogin_ConfirmPassword_NotMatchPassword( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "XXXXXXXXX" );
        login.clickSubmit( );

        String confirmPasswordStatus = login.getConfirmPassword_Status();
        System.out.println( "confirmPasswordStatus: >>> " + confirmPasswordStatus );
        assertTrue( confirmPasswordStatus.contains( "Confirm Password Value Must Match Password" ) , "MisMatching Confirm Password Not Fine" );

    }

}
