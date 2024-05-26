package NariveApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import NativeApp1.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//some tatic import for ctions
import static io.appium.java_client.touch.TapOptions.tapOptions;
//static import for long press
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//static import for element
import static io.appium.java_client.touch.offset.ElementOption.element;
//static import for time
import static java.time.Duration.ofSeconds;



//gestures - asiignment diffence bet ouch and tap
		//tap is a gesture and touch is a action class
//androidUiAutomator1 and 2:-----ui automator is a ui testing framwork comes from google to facilitate mobile automation on android devices/emulator
//and appium creates wrapper class onthe top o "UI automator" as UI automator2 driver to make android automation better/essier,ect
//recent app button (search on google)
public class APIDemos extends Capabilities {
	AndroidDriver<AndroidElement> driver;//we will use driver in the code which will define that by the use of android driver we can click on android element
	//androiddriver is class and androidelement is also class for specific element
	//driver is a variable which know that he has to interact with the ndroiddriver and androidelement
	@BeforeTest
public void bt() throws MalformedURLException {
	 driver=cap();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test(enabled = false)
public void writ() {
	System.out.println("dhanashree mobile opened");
	//driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
	//driver.findElement(MobileBy.AccessibilityId("Custom View")).click();
	//driver.pressKey(new KeyEvent(AndroidKey.BACK));//go to back window or page
	
	driver.findElement(MobileBy.AccessibilityId("Preference")).click();
	driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
	driver.findElement(MobileBy.id("android:id/checkbox")).click();
	//driver.findElement(MobileBy.xpath("//*[@test='WiFi setting']")).click();
	//here are 2 ways y which we can use text
	//next method is androidUIAutomator(search 1,2)
	//
	//we use UISelector() for selecting the attribute
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
}


  @Test(enabled = false)
  public void notification() {
  driver.openNotifications();
  driver.findElements(MobileBy.className("android.widget.Imageview")).get(2).click();
  }
 
@Test(enabled = false)
public void views() {
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	//if we want to scroll we want 3 things 1)UiAutomator 2)UiScrollable 3)UiSelector
	//if we want to scroll to a particular element then u have to use scrollIntoView
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
	
}
@Test(enabled = false)
public void clickable() {
	//if we want to check that elements are present or not then we use clickable and to check it is clickable we use
	//UiSelector()and AndroidUiAutomator
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	AndroidElement click = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"));
	System.out.println(click.getSize());
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
}
@Test(enabled = false)
public void swipe() {
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	driver.findElement(MobileBy.AccessibilityId("Date Widget")).click();
	driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
	AndroidElement date = driver.findElement(MobileBy.AccessibilityId("12"));
	AndroidElement date1 = driver.findElement(MobileBy.AccessibilityId("5"));
	
	TouchAction ta=new TouchAction(driver); 
	ta.longPress(longPressOptions().withElement(element(date)).withDuration(ofSeconds(5))).moveTo(element(date1)).release().perform();
}
@Test(enabled = false)
public void dragdrop() {
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
	//driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
	AndroidElement o1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
	AndroidElement o2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
	
	TouchAction ta=new TouchAction(driver); 
	ta.longPress(longPressOptions().withElement(element(o1)).withDuration(ofSeconds(5))).moveTo(element(o2)).release().perform();

	
}
@Test(enabled = false)
public void longpress() {
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
	driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
	AndroidElement o1 = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish Names\")"));
	
	TouchAction ta=new TouchAction(driver); 
	ta.longPress(longPressOptions().withElement(element(o1)).withDuration(ofSeconds(5))).release().perform();
}
@Test(enabled = true)
public void msg() {
	driver.findElement(MobileBy.AccessibilityId("OS")).click();
	driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
	 driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
	 driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
	 driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("hello dm");
	 driver.findElement(MobileBy.AccessibilityId("Send")).click();
	 driver.activateApp("com.google.android.apps.messaging");
	 String text = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		System.out.println(text);
		
		/*
		 * driver.activateApp("io.appium.android.apis"); driver.pressKey(new
		 * KeyEvent(AndroidKey.BACK)); driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 * driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 */driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		 driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			
}


}
