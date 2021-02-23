package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ResultPage;

public class ResultSteps {

    private final ResultPage resultPage = new ResultPage();

    @Then("^I see listings in the result page$")
    public void listResults() throws Throwable {
        String title = "Certified BMW Convertibles for Sale in Alpharetta, GA (with Photos) - Autotrader";
        resultPage.verifyResultTitle(title);
    }

    @And("^verify I see only \"([^\"]*)\" cars and print number of cars listed$")
    public void onlyMakeList(String brand) throws Throwable {
        resultPage.verifyOnlyBrand(brand);
        resultPage.logTotalListings();
        resultPage.closeActiveBrowser();
        resultPage.closeAllBrowsers();
    }
}
