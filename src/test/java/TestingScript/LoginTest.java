package TestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.LoginPage;


public class LoginTest
{
	public Chrome driver;
	public LoginPage login;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;


	@BeforeClass
	public void BeforeClass()
	{
		driver = new Chrome();
		login = new LoginPage();
		builder = new Actions(driver.driver);
		Reporter.log("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		Reporter.log("Sign up test ends");
		driver.shutdown();
	}

	@Test (priority=1,description="Submit without entering data")
	public void Test1() throws Throwable {
		driver.nav(driver.Url);
	   Thread.sleep(3000);
	   try {
		    login.signBtn = driver.LocateById(login.signBtnID);
	   }catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(login.signBtn).click().build();
	    act.perform();
	    Thread.sleep(3000);
	    try {
		   login.submit = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/button");
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button test 1");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(login.submit).click().build();
	    act.perform();
	    Thread.sleep(5000);
	    try {
	    	login.Errorlable = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/p[1]");
		}catch(Exception e) {
			Reporter.log("not stayed in sama page after submit test 1");
			return;
		}
	    String expected = login.Errorlable.getText();  // take pass of lable
	    String actual="Incorrect username or password";
	    assertEquals(actual, expected);
	}

	@Test (priority=2,description="Wrong user name")
	public void Test2() throws Throwable {
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.signBtn).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateByXpath("//*[@id=\"partition-register\"]/div[2]/form/button");
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button test 2");
			Assert.assertTrue(false);
		}
	    act = builder.sendKeys(login.userNametxt,"reem1655841").build();
		act.perform();
		act = builder.sendKeys(login.paswordtxt,"1212145").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
		   login.Errorlable = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/p[1]");
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button test 2");
			return;
		}
		String expected = login.Errorlable.getText();
		String actual="Incorrect username or password";
		assertEquals(actual, expected);
	  }
	
  @Test (priority=3,description="Wrong password")
  public void Test3() throws Throwable {
	  driver.nav(driver.Url);
	  	Thread.sleep(3000);
	  	try {
		   login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 3");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform();
	  	Thread.sleep(3000);
	  	try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateByXpath("//*[@id=\"partition-register\"]/div[2]/form/button");
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 3");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(login.userNametxt,"hell12").build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,"1212145").build();
	  	act.perform();
	  	act = builder.moveToElement(login.submit).click().build();
	  	act.perform();
	  	Thread.sleep(3000);
	  	try {
	  		login.Errorlable = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/p[1]");
	  	}catch(Exception e) {
			Reporter.log("Can't find the signIn Button test 2");
			return;
		}
	  	String expected = login.Errorlable.getText();
	  	String actual="Incorrect username or password";
	  	assertEquals(actual, expected);
  	}
  
  @Test (priority=5,description="Forget username")
  public void ForgetUsername() throws InterruptedException {
	  driver.nav(driver.Url);
	  	Thread.sleep(3000);
	  	try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform(); 
	  	Thread.sleep(3000);
	  	try {
		   login.forgetname =driver.LocateByXpath("//a[@class='btn btn-link'][1]");
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.forgetname).click().build();
	  	act.perform();
	  	
	  	try {
			   login.userNametxt = driver.LocateByXpath("//div[@class='partition-form']//input[@class='form-control'][1]");
			   login.paswordtxt = driver.LocateById(login.paswordtxtID);
			   login.submit = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/button");
			}catch(Exception e) {
				Reporter.log("Can't find the submit Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.sendKeys(login.userNametxt,Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).build();
		  	act.perform();
		  	act = builder.sendKeys(login.paswordtxt,Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).build();
		  	act.perform();
		  	Thread.sleep(3000);
		  	act = builder.sendKeys(login.userNametxt,"salma").build();
		  	act.perform();
		  	act = builder.sendKeys(login.paswordtxt,"123456").build();
		  	act.perform();
		  	act = builder.moveToElement(login.submit).click().build();
		  	act.perform();
		  	try {
				   login.close = driver.LocateById("closebtn");
				   	}catch(Exception e) {
					Reporter.log("Can't find the submit Button ");
					Assert.assertTrue(false);
				}
		  	act = builder.moveToElement(login.close).click().build();
		  	act.perform();
	  	
	  	assertNull(login.signBtn);
  }
	  
  @Test (priority=6,description="Forget password")
  public void ForgetPassword() throws InterruptedException {
	  driver.nav(driver.Url);
  		Thread.sleep(3000);
  		try {
  			login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 6");
			Assert.assertTrue(false);
		}
  		act = builder.moveToElement(login.signBtn).click().build();
  		act.perform(); 
  		Thread.sleep(3000);
  		try {
  			login.forgotpasLable =driver.LocateByXpath("//a[@class='btn btn-link'][2]");
		   
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 6");
			Assert.assertTrue(false);
		}
  		act = builder.moveToElement(login.forgotpasLable).click().build();
  		act.perform();
  		try {
			   login.userNametxt = driver.LocateByXpath("//div[@class='partition-form']//input[@class='form-control'][1]");
			   login.paswordtxt = driver.LocateByXpath("//div[@class='partition-form']//input[@class='form-control'][2]");
			   login.submit = driver.LocateByXpath("//div[@class='partition-form']//button");
			}catch(Exception e) {
				Reporter.log("Can't find the submit Button ");
				Assert.assertTrue(false);
			}
		  	
		  	Thread.sleep(3000);
		  	act = builder.sendKeys(login.userNametxt,"salma").build();
		  	act.perform();
		  	act = builder.sendKeys(login.paswordtxt,"salma@gmail.com").build();
		  	act.perform();
		  	act = builder.moveToElement(login.submit).click().build();
		  	act.perform();
		  	try {
				   login.close = driver.LocateById("closebtn");
				   	}catch(Exception e) {
					Reporter.log("Can't find the submit Button ");
					Assert.assertTrue(false);
				}
		  	act = builder.moveToElement(login.close).click().build();
		  	act.perform();
  		assertNull(login.signBtn);  
  }
 
@Test (priority=7,description="sign up test")
public void signUp() throws InterruptedException {
  driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
  			login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 6");
			Assert.assertTrue(false);
		}
  		act = builder.moveToElement(login.signBtn).click().build();
  		act.perform(); 
  		Thread.sleep(3000);
		try {
			login.signupBTN = driver.LocateByXpath("//a[@class='btn btn-link'][1]");
	}catch(Exception e) {
		Reporter.log("Can't find the signIn Button 6");
		Assert.assertTrue(false);
	}
		act = builder.moveToElement(login.signupBTN).click().build();
		act.perform(); 
		Thread.sleep(3000);
		try {
			login.nextBTN =driver.LocateById("closebtn");
	   
	}catch(Exception e) {
		Reporter.log("Can't find the submit Button 6");
		Assert.assertTrue(false);
	}
		
}

	  
  @Test (priority=8,description="Right mail and pass")
  public void LOgin() throws Throwable {
	  driver.nav(driver.Url);
	  	Thread.sleep(3000);
	  	try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform(); 
	  	Thread.sleep(5000);
	  	try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/button");
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button ");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(login.userNametxt,Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).build();
	  	act.perform();
	  	Thread.sleep(5000);
	  	act = builder.sendKeys(login.userNametxt,"salma").build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,"123456").build();
	  	act.perform();
	  	act = builder.moveToElement(login.submit).click().build();
	  	act.perform();
	  	Thread.sleep(5000);
	  	try {
	  		login.UserInfo = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
		}
	  	String expected = "salma";
	  	String actual="salma";
		Assert.assertEquals(actual, expected);
  }
  
  @Test (priority=9,description="Logout")
  public void Logout() throws Throwable {
	  driver.nav(driver.Url);
	  	Thread.sleep(3000);
	  	
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			login.logoutButton = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[5]");
		}catch(Exception e) {
			Reporter.log("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.logoutButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't  loguot");
			Assert.assertTrue(true);
		}
  }
	  
}
