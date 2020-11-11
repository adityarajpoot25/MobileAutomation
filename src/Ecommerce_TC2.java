import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC2 extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement>driver =Capabilities();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
			driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Aditya Rajpoot");
			driver.hideKeyboard();
			driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))");
//			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
			int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
			for(int i=0;i<count;i++) {
			String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if(text.equalsIgnoreCase("Jordan 6 Rings")) {
				
				driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(i).click();
				break;
			}
			}
			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	String cart_Text=driver.findElementById("com.androidsample.generalstore:id/productName").getAttribute("text");
	if(cart_Text.equalsIgnoreCase("Jordan 6 Rings")) {
		System.out.println("Correct product is Added");
	}
	else {
		System.out.println("Incorrect product is added");
	}
	}

}
