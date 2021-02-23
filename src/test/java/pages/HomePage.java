package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseClass {

    public boolean isLinksPresent(String make, String style, String search) {
        WebElement isMake = locateElement("xpath", "//button[contains(text(), 'Browse By Make')]");
        WebElement isStyle = locateElement("xpath", "//button[contains(text(), 'Browse by Style')]");
        WebElement isAdvanceSearch = locateElement("xpath", "//a[@href='/cars-for-sale/advanced-search')]");

        if((isMake != null) && (isStyle!= null) && (isAdvanceSearch != null )){
            System.out.println("Element is Present");
                return true;
        }else{
            System.out.println("Element is Absent");
            return false;
        }
    }

    public boolean isButtonPresent(String search) {
        WebElement isButton = locateElement("id", search);

        if((isButton != null)){
            System.out.println("Element is Present");
            return true;
        }else{
            System.out.println("Element is Absent");
            return false;
        }
    }

    public boolean isDropdownPresent(String makeCode, String modelCode) {
        WebElement isMakeCode = locateElement("xpath", "//*[text() = makeCode]");
        WebElement isModelCode = locateElement("xpath", "//*[text() = modelCode]");

        if((isMakeCode != null) && (isModelCode!= null)){
            System.out.println("Element is Present");
            return true;
        }else{
            System.out.println("Element is Absent");
            return false;
        }
    }

    public void advanceClick(String advSearch){
        click(locateElement("link", advSearch));
    }

    public void enterZip(String value, String ele){
        type(locateElement("xpath", "//span[text() = ele]"), value);
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
