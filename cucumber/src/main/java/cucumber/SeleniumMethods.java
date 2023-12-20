package cucumber;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.http.cookie.SetCookie;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import bsh.Capabilities;

public class SeleniumMethods {
	
	WebDriver driver;
	WebElement element;
public  void test1() {
	driver.close();                      //to close current window
	driver.quit();                      //to close entire browser
	 element=driver.findElement(By.id("")); //to grab an one  element
	element.clear(); //to clear the text box
	element.click();
	element.findElement(null); // to grab one element from inside another element
	element.getAttribute("attribute"); //to get the attribute value of an element
	element.getCssValue("");// to get the CSS value from an element
	int x =element.getLocation().x; // to get the x axis and y axis coordinate
	 int h=element.getRect().height;//to get the height of a rectangle
	 element.getSize().getHeight(); 
	 element.getTagName();
	 element.getText(); // get text of an element
	 element.isDisplayed(); //to check an element is present or not
	 element.isSelected(); // to check a box is selected or not
	 element.isEnabled(); // to check a button is enabled or not
     element.sendKeys(null);// to type in a text box
     element.submit();//to click an element without a click method.
   
     
     
     
	List<WebElement> elements=driver.findElements(By.xpath("")); //to grab more than one elment
	elements.size();
driver.get("");                               //to navigate to URL
driver.getCurrentUrl();                     //to grab current page URL
driver.getPageSource();                     //to get source code of a page
driver.getTitle();                          //to get the title of a page
driver.getWindowHandle();                   // to get parent window
  Set<String> cwin=driver.getWindowHandles(); //to grab all the child window
  Options option= driver.manage();
  option.deleteAllCookies();       //to handle any cookie related action
  option.timeouts().implicitlyWait(20, TimeUnit.SECONDS);//
 
  Navigation nav= driver.navigate();
  nav.back();
  nav.forward();
  nav.refresh();
  nav.to("");
  
 TargetLocator loc= driver.switchTo();
 loc.frame(x);
 loc.frame("");
 loc.frame(element);
 loc.defaultContent();             //to go back to parent website
 loc.parentFrame();
 
 
 
 Alert A =loc.alert();
 A.accept();
 A.dismiss();
 A.sendKeys(null);
 A.getText();
 
 // Customized alert box could be handled like window based Popup.
 // If popup is window based then selenium cannot handle,we need robot API or we 
 //need auto IT tool or Sikulli.
 
 
	 
}
public void MouseMethod() {
	 Actions A = new Actions(driver); // mouse related actions.
	 A.click(element);
	 A.build().perform(); //any mouse related action need these 2(BUILD,PERFORM) 
     A.clickAndHold(element).build().perform();
     A.contextClick(element).build().perform(); //is used for Right click
     A.doubleClick(element).build().perform();  
     A.dragAndDrop(element, element).build().perform();
     A.dragAndDropBy(element, 100, 150).build().perform();
     A.keyDown(element, null).build().perform();
     A.keyDown(Keys.ARROW_DOWN).build().perform();
     A.moveToElement(element).build().perform(); //to hover over
     A.pause(20).release().build().perform();
     
}
public void iframe(String frameName) {
	List<WebElement> allframe= driver.findElements(By.tagName("iframe"));
	for(WebElement frame:allframe) {
		String frameValue=frame.getAttribute("class");
		if(frameValue.contains(frameName)) {
			driver.switchTo().frame(frameName);
		}
	}
	
}

public void deleteExpiredCookie(String CookieName) {
	Set<Cookie> allCookie= driver.manage().getCookies();
	for( Cookie oneCookie:allCookie) {
		String ac= oneCookie.getName();
		if( ac.equals(CookieName)){
			driver.manage().deleteCookieNamed(ac);
			
			
		}
	}
}
public void takeScreenshot() throws IOException {
	File f =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Files.copy(f, new File("path of the folder where you want to save"));
	
}




public void browserCapabilities() {
	
	ChromeOptions c =  new ChromeOptions();
	c.addArguments("xpi extention of any add on");
	ChromeDriver driver= new ChromeDriver(c);
}


public void multipleWindowHandles() {
	String pwin= driver.getWindowHandle();
	Actions ac=new Actions(driver);
	ac.contextClick(element).sendKeys(Keys.ARROW_DOWN)
	.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	Set<String> cwin= driver.getWindowHandles();
	for(String win:cwin) {
		if(!win.equals(pwin)) {
			driver.switchTo().window(win);
		}
		
	}
	driver.switchTo().defaultContent();        // muliple window handle
	
}
public void javaScriptHandle() {
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,1000)");
	js.executeScript("document.getElementById(\"myCheck\").click();");
	js.executeScript(" document.getElementById(\"textbox_1\").value=text_to_be_inserted;");
	js.executeScript("arguments[0].click()",element);
	js.executeScript("window.history.back();");
	waitForElement(element).click();;	
}

public WebElement waitForElement(WebElement ele) {
WebDriverWait wdw = new WebDriverWait(driver, 10);
wdw.until(ExpectedConditions.elementToBeClickable(ele));
return ele;
}
public void fluentWait() {
	Wait wait = new FluentWait(driver)
			.withTimeout(30,TimeUnit.SECONDS)
			.pollingEvery(5,TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);

			wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
			return driver.findElement(By.id("foo"));
			}
			});
	
}


















}
