import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC3 extends Base {

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
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))");
			int count1=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
			for(int i=0;i<count1;i++) {
			String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if(text.equalsIgnoreCase("Jordan 6 Rings")) {
				
				driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(i).click();
				break;
			}
			}
			
			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
			Thread.sleep(10000);
int count3= driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
double sum=0;
for(int j=0;j<count;j++) {
	String amount=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(j).getText();
	double amount1=getAmount(amount);
	sum= sum+amount1;
	System.out.println(sum);
}


		
	String total=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
	double totalValue=getAmount(total);
	System.out.println(totalValue);
	}
	
	public static double getAmount(String value) {
		value=value.substring(1);
		double amountValue=Double.parseDouble(value);
		return amountValue;
	}

}
