package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    String actualUsername;
    String email;
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();




    @Given("the user logged in  {string} and {string}")
    public void the_user_logged_in_and(String email, String password) {
       loginPage.login(email,password);

        this.email=email;
    }
    @When("user gets username  from user fields")
    public void user_gets_username_from_user_fields() {
        BrowserUtil.waitForVisibility(dashBoardPage.accountHolderName,2);

        actualUsername = dashBoardPage.accountHolderName.getText();
        System.out.println("actualUsername = " + actualUsername);


    }
    @Then("the username should be same with database")
    public void the_username_should_be_same_with_database() {


        String query = "select full_name\n" +
                "from users\n" +
                "where email = '"+email+"'";
        DB_Util.runQuery(query);
        String expectedUsername = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUsername = " + expectedUsername);

        Assert.assertEquals(expectedUsername,actualUsername);


    }
}
