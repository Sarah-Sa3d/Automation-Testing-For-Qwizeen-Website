package LoginPage;

import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class loginPageFirstNameTests extends BaseTests {


    @Test ( priority = 1, description = "Verify that user cannot enter empty first name" )
    public void testLogin_FirstName_Empty( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String firstName_Status = login.getFirstNameStatus( );
        System.out.println( "firstName_Status: >>> " + firstName_Status );
        assertTrue( firstName_Status.contains( "First Name Is Required" ) , "Empty FirstName Not Fine" );

    }

    @Test ( priority = 2, description = "Verify that user can enter first name with valid length characters" )
    public void testLogin_FirstName_acceptsOnlyChars( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "Abd Allah Mohammed" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean firstName_Status = login.getFirstNameStatus_FoundOrNot( );
        System.out.println( "firstName_Status: >>> " + firstName_Status );
        assertFalse( firstName_Status , "FirstName Accept Only Chars Not Fine" );
    }

    @Test ( priority = 3, description = "Verify that the first name cannot accept invalid characters [special characters, numbers, etc.]", dataProvider = "invalidFirstNameData" )
    public void testLogin_FirstName_InvalidCharacters(String invalidFirstName) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( invalidFirstName );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String firstName_Status = login.getFirstNameStatus( );
        System.out.println( "firstName_Status: >>> " + firstName_Status +" : " +invalidFirstName );
        assertTrue( firstName_Status.contains( "First Name Is Not Valid" ) , "First Name with invalid characters should not be allowed: " + invalidFirstName );
    }


    @Test ( priority = 5, description = "Verify that user cannot enter first name with minimum length 1 characters" )
    public void testLogin_FirstName_less_minimum_length_1char( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "A" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String firstName_Status = login.getFirstNameStatus( );
        System.out.println( "firstName_Status: >>> " + firstName_Status );
        assertTrue( firstName_Status.contains( "First Name Should Contain At Least 2 Character" ) , "Minimum Chars for FirstName Not Fine [1 Char] " );

    }

    @Test ( priority = 6, description = "Verify that user can enter first name with minimum length 2 characters" )
    public void testLogin_FirstName_equal_minimum_length_2char( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "AB" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean firstName_Status = login.getFirstNameStatus_FoundOrNot( );
        System.out.println( "firstName_Status: >>> " + firstName_Status );
        assertFalse( firstName_Status , "Minimum Chars for FirstName Not Fine [2 Char] " );

    }

    @Test ( priority = 7, description = "Verify that user cannot enter first name with length 3 characters" )
    public void testLogin_FirstName_less_minimum_length_3char( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "ABC" );

        login.entering_LastName( "LastName" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean firstName_Status = login.getFirstNameStatus_FoundOrNot( );
        System.out.println( "firstName_Status: >>> " + firstName_Status );
        assertFalse( firstName_Status , "Minimum Chars for FirstName Not Fine [3 Char] " );

    }


    @DataProvider ( name = "invalidFirstNameData" )
    public Object[][] invalidFirstNameData( ) {
        return new Object[][]{
                {"@John!"} ,    // Special characters
                {"John123"} ,   // Numbers
                //{"John Doe"},  // Space (if space is not allowed)
                {"John*Doe"} ,  // Mixed special characters
                {"123"} ,       // Only numbers
                {"!@#$%"} ,     // Only special characters
                //{" "},         // Only space
                {"Jo_hn"} ,     // Underscore
                {"Jo-hn"} ,     // Hyphen (if hyphen is not allowed)
                {"Jo.hn"} ,     // Dot (if dot is not allowed)
                {"Jo'n"} ,      // Apostrophe (if apostrophe is not allowed)
        };
    }


}
