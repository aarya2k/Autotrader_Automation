package pages;

import base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends BaseClass {

    public void verifyResultTitle(String title){
        verifyExactTitle(title);
    }

    public void verifyOnlyBrand(){
        String brandCount = driver.findElement(By.xpath("(//div[@class='input-label']//span[@class=\"text-nowrap\"])[11]")).getText();
        String brandName = driver.findElement(By.xpath("(//div[@class='input-label'])[11]")).getText();
        String originalListingCount = String.valueOf(driver.findElements(By.xpath("//div[@data-cmp='loadingIndicator']//div//div[@data-cmp='inventoryListing")).size());
        Assert.assertEquals("Only "+ brandName +" cars are displayed", brandCount, originalListingCount);
    }

    public void logTotalListings(){
        int alphaListingCount = driver.findElements(By.xpath("//div[@data-cmp='alphaShowcase']']")).size();
        int adListingCount = driver.findElements(By.xpath("//div[@data-cmp='inventorySpotlightListing']")).size();
        int originalListingCount = driver.findElements(By.xpath("//div[@data-cmp='loadingIndicator']//div//div[@data-cmp='inventoryListing")).size();
        System.out.println("-------Logging in the console-------");
        System.out.println("Total Cars Listed in results page: " + (alphaListingCount + adListingCount + originalListingCount));
        System.out.println("Original Listing without Featured/Sponsored: " + (originalListingCount));
        System.out.println("Cars Listed as Featured/Sponsored: " + (alphaListingCount + adListingCount));

    }

}
