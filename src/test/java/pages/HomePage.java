package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseClass {

    public boolean isLinksPresent(String make, String style, String search) {
        WebElement isMake = locateElement("xpath", "//div[@class='display-inline-block']//button[text()='Browse by Make']");
        WebElement isStyle = locateElement("xpath", "//div[@class='display-inline-block']//button[text()='Browse by Style']");
        WebElement isAdvanceSearch = locateElement("xpath", "//div[@class='display-inline-block']//a[text()='Advanced Search']");

        if((isMake != null) && (isStyle!= null) && (isAdvanceSearch != null )){
            System.out.println("Element is Present");
                return true;
        }else{
            System.out.println("Element is Absent");
            return false;
        }
    }

    public boolean isButtonPresent(String search) {
        WebElement isButton = locateElement("xpath", "//button[@id=\"search\"]");
//        Select select = new Select(driver.findElement(By.xpath("//select")));
//        WebElement option = select.getFirstSelectedOption();
//        String defaultItem = option.getText();
//
//        String selectedOption = new Select(driver.findElement(By.xpath("//div[@class='form-group']//select"))).getFirstSelectedOption().getText();

        if((isButton != null)){
            System.out.println("Element is Present");
            return true;
        }else{
            System.out.println("Element is Absent");
            return false;
        }
    }

    public boolean isDropdownPresent(String makeCode, String modelCode) {
        WebElement isMakeCode = locateElement("xpath", "(//div[@class='form-group']//select)[1]");
        WebElement isModelCode = locateElement("xpath", "(//div[@class='form-group']//select)[2]");

        if((isMakeCode != null) && (isModelCode!= null)){
            System.out.println("Element is Present");
            return true;
        }else{
            System.out.println("Element is Absent");
            return false;
        }
    }

    public void advanceClick(String advSearch){
        click(locateElement("xpath", "//button[@id='search']"));
    }

    public void enterZip(String value, String ele){
        type(locateElement("xpath", "//input[@id='zip48577207']"), value);
    }

    public void clickCheck(String ele){
        switch (ele){
            case ("Certified") :
                WebElement eleCheck = locateElement("xpath", "(//div[@class='input-label'])[3]");
                click(eleCheck);
                break;
            case ("Convertible") :
                WebElement eleCheck1 = locateElement("xpath", "(//div[@class='input-label'])[4]");
                click(eleCheck1);
                break;
            case ("Sedan") :
                WebElement eleCheck2 = locateElement("xpath", "(//div[@class='input-label'])[7]");
                click(eleCheck2);
                break;
        }
    }

    public void yearDrop(String eleFrom, String valFrom, String eleTo, String valTo){
        try {
            Select fromYear = new Select(locateElement("name", "startYear"));
            fromYear.selectByValue(valFrom);
            Select toYear = new Select(locateElement("name", "endYear"));
            toYear.selectByValue(valTo);
        } catch (Exception  e) {
        }
    }

    public void updateMake(String vehMake){
        try {
            Select make = new Select(locateElement("id", "1970425032"));
            make.selectByValue(vehMake);
        } catch (Exception  e) {
        }
    }

    public void clickButton(String value){
//        click(locateElement("xpath", "//button[@type='submit']"));
        click(locateElement("xpath", "//button[text() = value]"));
    }
}
