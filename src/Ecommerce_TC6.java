import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_TC6 extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement>driver =Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("android:id/text1").click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Aditya Rajpoot");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 1 Mid SE\"))");
			int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
			for(int i=0;i<count;i++) {
			String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if(text.equalsIgnoreCase("Air Jordan 1 Mid SE")) {
				
				driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(i).click();
				break;
			}
			}
					
			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
			Thread.sleep(10000);
	
	TouchAction t= new TouchAction(driver);
	WebElement discountEmailCheckbox= driver.findElementByClassName("android.widget.CheckBox");
	t.tap(tapOptions().withElement(element(discountEmailCheckbox))).perform();
		
	driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	Thread.sleep(7000);
	Set<String>contexts=driver.getContextHandles();
	for(String contextNames: contexts) {
		System.out.println(contextNames);
	}
	//Need to change ChromeDriver version
	
	driver.context("WEBVIEW_com.androidsample.generalstore");

	driver.findElement(By.name("q")).sendKeys("hello");

	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	driver.pressKey(new KeyEvent(AndroidKey.BACK));

	driver.context("NATIVE_APP");
	}
	
	
}
