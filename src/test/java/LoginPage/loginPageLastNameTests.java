package LoginPage;

import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class loginPageLastNameTests extends BaseTests {


    @Test ( priority = 1, description = "Verify that user cannot enter empty Last name" )
    public void testLogin_LastName_Empty( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String lastName_Status = login.getLastName_Status( );
        System.out.println( "lastName_Status: >>> " + lastName_Status );
        assertTrue( lastName_Status.contains( "Last Name Is Required" ) , "Empty LastName Status Not Fine" );

    }

    @Test ( priority = 2, description = "Verify that user can enter last name with valid length characters" )
    public void testLogin_LastName_acceptsOnlyChars( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "Abd Allah Mohammed" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean lastName_Status = login.getLastNameStatus_FoundOrNot( );
        System.out.println( "lastName_Status: >>> " + lastName_Status );
        assertFalse( lastName_Status , "LastName Accept Only Chars Not Fine" );
    }

    @Test ( priority = 3, description = "Verify that the first name cannot accept invalid characters [special characters, numbers, etc.]", dataProvider = "invalidLastNameData" )
    public void testLogin_LastName_InvalidCharacters(String invalidLastName) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( invalidLastName );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String lastName_Status = login.getLastName_Status( );
        System.out.println( "lastName_Status: >>> " + lastName_Status + " : " +  invalidLastName );
        assertTrue( lastName_Status.contains( "Last Name Is Not Valid" ) , "Last Name with invalid characters should not be allowed: " + invalidLastName );
    }

    @Test ( priority = 5, description = "Verify that user cannot enter Last name with less minimum length 1 characters" )
    public void testLogin_LastName_less_minimum_length_1char( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "A" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        String lastName_Status = login.getLastName_Status( );
        System.out.println( "lastName_Status: >>> " + lastName_Status );
        assertTrue( lastName_Status.contains( "Last Name Should Contain At Least 2 Character" ) , "Minimum Chars for LastName Not Fine [1 Char] " );

    }


    @Test ( priority = 6, description = "Verify that user cannot enter first name with minimum length 2 characters" )
    public void testLogin_LastName_less_minimum_length_2char( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "AB" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean lastName_Status = login.getLastNameStatus_FoundOrNot( );
        System.out.println( "lastName_Status: >>> " + lastName_Status );
        assertFalse( lastName_Status , "LastName Accept Only Chars Not Fine [2 Char] " );

    }

    @Test ( priority = 7, description = "Verify that user cannot enter first name with minimum length 3 characters" )
    public void testLogin_LastName_less_minimum_length_3char( ) {

        LoginPage login = new LoginPage( driver ).entering_FirstName( "FirstName" );

        login.entering_LastName( "ABC" );
        login.entering_Email( "QwizeenUser@example.com" );
        login.entering_Password( "P@ssw0rd" );
        login.entering_ConfirmPassword( "P@ssw0rd" );
        login.clickSubmit( );

        Boolean lastName_Status = login.getLastNameStatus_FoundOrNot( );
        System.out.println( "lastName_Status: >>> " + lastName_Status );
        assertFalse( lastName_Status , "LastName Accept Only Chars Not Fine [3 Char] " );

    }


    @DataProvider ( name = "invalidLastNameData" )
    public Object[][] invalidLastNameData( ) {
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
