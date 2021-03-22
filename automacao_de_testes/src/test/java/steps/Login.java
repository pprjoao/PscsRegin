package steps;

import org.junit.Test;



import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class Login {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  String url="http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx";
  String junta="http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx";
  String currentURL;
  String expectedURL;
  @Before
  public void initialize() {
	  System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
	driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    
    driver.manage().deleteAllCookies();
   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	driver.manage().window().maximize();
   	
    driver.get(url);

    
  }
  @After
  public void fechar() {
    driver.quit();
  }
  @Test
  public void loginfail() throws InterruptedException {
	  
	  if(url.equals(junta)) {
    driver.findElement(By.id("_ctl0_MainContent_Button1")).click();
	  }
    driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).click();
    driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
    driver.findElement(By.id("_ctl0_MainContent_txtSenha")).click();
    driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031091");
    driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
    
    driver.switchTo().alert().accept();
    
    currentURL= driver.getCurrentUrl();
    System.out.println("A pagina atual é : " + currentURL);
    expectedURL = "http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx";
    
    assertEquals(currentURL, expectedURL);
    
  }
  @Test
  public void loginsucess() throws InterruptedException {
	  
	  if(url.equals(junta)) {
    driver.findElement(By.id("_ctl0_MainContent_Button1")).click();
	  }
    driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).click();
    driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
    driver.findElement(By.id("_ctl0_MainContent_txtSenha")).click();
    driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031090");
    driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
    Thread.sleep(3000);
    String currentURL= driver.getCurrentUrl();
    String expectedURL = "http://200.187.18.147/RequerimentoUniversal/Principal.aspx";
    assertEquals(currentURL, expectedURL);
    
  
    
  }
  
}