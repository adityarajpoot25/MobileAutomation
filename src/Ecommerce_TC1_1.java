import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC1_1 extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement>driver =Capabilities();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
//		WebElement country=	driver.findElementByXPath("//android.widget.TextView[@text='India'");
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
			driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
			driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String toastMessage	=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(toastMessage);
		
	}

}
