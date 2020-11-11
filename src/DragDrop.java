import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragDrop extends Base {

	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement>driver =Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click(); 
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click(); 
		WebElement source=	driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination=	driver.findElementsByClassName("android.view.View").get(1);
		TouchAction t= new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		
		
	}

}
