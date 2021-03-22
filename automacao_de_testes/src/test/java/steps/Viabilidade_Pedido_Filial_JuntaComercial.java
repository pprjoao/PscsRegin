package steps;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

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
import java.net.MalformedURLException;
import java.net.URL;

public class Viabilidade_Pedido_Filial_JuntaComercial {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  String url;
  String currentURL= "";
  String expectedURL = "http://200.187.18.147/requerimentoUniversal/Principal.aspx";
  String atualTitle="";
  
  @Before
  public void setUp() throws InterruptedException {
	  url="http://200.187.18.147/requerimentoUniversal/Principal.aspx";
	  System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver_87.exe");
	  driver =new ChromeDriver();
    driver.get("http://200.187.18.147/requerimentoUniversal/Principal.aspx");
   	Login logar=new Login();
   	//logar.initialize();
   	//logar.loginsucess();
    
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void criarFilial() {
    
    driver.manage().window().maximize();
    driver.get(url);
    
    driver.findElement(By.id("_ctl0_MainContent_btnAcompanhaViabilidade")).click();
    driver.findElement(By.cssSelector(".main")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
    vars.put("win5953", waitForWindow(2000));
    driver.switchTo().window(vars.get("win5953").toString());
    driver.findElement(By.id("drpListaMucinicpios")).click();
    {
      WebElement dropdown = driver.findElement(By.id("drpListaMucinicpios"));
      dropdown.findElement(By.xpath("//option[. = 'ALAGOINHAS']")).click();
    }
    driver.findElement(By.id("drpListaMucinicpios")).click();
    driver.findElement(By.id("drpListaOpcoes")).click();
    {
      WebElement dropdown = driver.findElement(By.id("drpListaOpcoes"));
      dropdown.findElement(By.xpath("//option[. = 'JUNTA COMERCIAL DO ESTADO DA BAHIA']")).click();
    }
    driver.findElement(By.id("drpListaOpcoes")).click();
    driver.findElement(By.id("chkFilial")).click();
    driver.findElement(By.id("rdnPossueMatrizSim")).click();
    driver.findElement(By.id("txtNireMatriz")).click();
    driver.findElement(By.id("txtNireMatriz")).sendKeys("29204834192");
    driver.findElement(By.id("txtCnpjMatriz")).click();
    driver.findElement(By.id("txtCnpjMatriz")).sendKeys("90.023.765/0001-30");
    driver.findElement(By.id("btnEnviar")).click();
    js.executeScript("window.scrollTo(0,13)");
    driver.findElement(By.id("Cpf")).click();
    driver.findElement(By.id("Cpf")).sendKeys("127.850.048-09");
    driver.findElement(By.id("txtEmail")).click();
    driver.findElement(By.id("txtEmail")).click();
    driver.findElement(By.id("txtEmail")).sendKeys("jpascoa@pscs.com.br");
    driver.findElement(By.id("txtIPTU")).click();
    driver.findElement(By.id("txtIPTU")).sendKeys("0");
    driver.findElement(By.id("txtArea")).sendKeys("0112");
    driver.findElement(By.id("drpEnviaSefaz")).click();
    {
      WebElement dropdown = driver.findElement(By.id("drpEnviaSefaz"));
      dropdown.findElement(By.xpath("//option[. = 'SIM']")).click();
    }
    driver.findElement(By.id("drpEnviaSefaz")).click();
    driver.findElement(By.cssSelector("#painelEndereco > fieldset")).click();
    driver.findElement(By.id("btnBuscarEndereco")).click();
    driver.findElement(By.id("txtNumero")).click();
    driver.findElement(By.id("txtNumero")).sendKeys("100");
    driver.findElement(By.cssSelector("fieldset > .row:nth-child(4)")).click();
    js.executeScript("window.scrollTo(0,1399)");
    driver.findElement(By.id("btnFilialComplemento")).click();
    {
      WebElement element = driver.findElement(By.id("btnFilialComplemento"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("ddlCompl01")).click();
    {
      WebElement dropdown = driver.findElement(By.id("ddlCompl01"));
      dropdown.findElement(By.xpath("//option[. = 'ANEXO']")).click();
    }
    driver.findElement(By.id("ddlCompl01")).click();
    driver.findElement(By.id("txtCompl01")).click();
    driver.findElement(By.id("txtCompl01")).sendKeys("91");
    driver.findElement(By.id("btnComplementoOkay")).click();
    driver.findElement(By.id("txtReferencia")).click();
    driver.findElement(By.id("txtReferencia")).sendKeys("posto de gasolina");
    driver.findElement(By.id("Zip")).click();
    driver.findElement(By.id("Zip")).click();
    driver.findElement(By.id("Zip")).sendKeys("48005240");
    driver.findElement(By.id("btnBuscarEndereco")).click();
    driver.findElement(By.id("txtNumero")).click();
    driver.findElement(By.id("txtNumero")).sendKeys("100");
    driver.findElement(By.id("txtReferencia")).click();
    driver.findElement(By.id("txtReferencia")).sendKeys("posto de gasolina");
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.id("btnMostrarMapa")).click();
    vars.put("win2615", waitForWindow(2000));
    driver.switchTo().window(vars.get("win2615").toString());
    driver.findElement(By.cssSelector("body")).click();
    assertEquals("TRAVESSA ALAMEDA DAS ALGAROBAS, 100, ALAGOINHAS VELHA, ALAGOINHAS, BA, BRASIL", driver.findElement(By.id("lblEndereco")).getText());
    driver.findElement(By.id("btn-confirma-topo")).click();
  }
  
}