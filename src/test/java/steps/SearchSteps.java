package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ResultPage;

public class SearchSteps {

    private final HomePage homePage = new HomePage();
    private final ResultPage resultPage = new ResultPage();

    @Given("^I navigate to \"([^\"]*)\"$")
    public void goto_url(String url) throws Throwable {
        homePage.launchBrowser();
    }

    @When("^I verify the links \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyLinks(String make, String style, String advanceSearch) throws Throwable {
        Assert.assertTrue(homePage.isLinksPresent(make, style, advanceSearch));
    }

    @And("^I verify the buttons \"([^\"]*)\"$")
    public void verifyButton(String search) throws Throwable {
        Assert.assertTrue(homePage.isButtonPresent(search));
    }

    @And("^I verify the dropdowns \"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyDropdowns(String makeCode, String modelCode) throws Throwable {
        Assert.assertTrue(homePage.isDropdownPresent(makeCode, modelCode));
    }

    @Then("^I click on \"([^\"]*)\"$")
    public void advanceClick(String arg1) throws Throwable {
        homePage.advanceClick(arg1);
    }

    @And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" text box$")
    public void enterZipcode(String zipValue, String zipElement) throws Throwable {
        homePage.enterZip(zipValue, zipElement);
    }

    @And("^I select \"([^\"]*)\" check box under \"([^\"]*)\"$")
    public void clickCheckBox(String ele, String eleUnder) throws Throwable {
        homePage.clickCheck(ele);
    }

    @And("^I update \"([^\"]*)\" drop down as \"([^\"]*)\" and \"([^\"]*)\" drop down as \"([^\"]*)\"$")
    public void updateYearDropDown(String eleFrom, String valFrom, String eleTo, String valTo) throws Throwable {
        homePage.yearDrop(eleFrom, valFrom, eleTo, valTo);
    }

    @And("^I select \"([^\"]*)\" as \"([^\"]*)\" under Make, Model & Trim section$")
    public void updateMake(String arg1, String vehMake) throws Throwable {
        homePage.updateMake(vehMake);
    }

    @And("^I click on \"([^\"]*)\" button$")
    public void i_click_on_button(String search) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickButton(search);
    }
}
