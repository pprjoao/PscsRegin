package steps;

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

public class Viabilidade_Pedido_MatrizSteps {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  String url="http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx";
  String juceb="http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx";
  
  String currentURL= "";
  String expectedURL = "http://200.187.18.147/requerimentoUniversal/Principal.aspx";
  String atualTitle="";
  String popupHandle = null;
  
  
  @Before
  public void setUp() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
    driver.get("http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx");
   	Login logar=new Login();
   	logar.initialize();
   	logar.loginsucess();
    currentURL= driver.getCurrentUrl();
   	//fazer a espera por variaveis


      
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void criarMatriz() throws InterruptedException {
	  
	  driver = new ChromeDriver();
	   
	  driver.get(url);
	  Thread.sleep(2000);
	currentURL=driver.getCurrentUrl();
	if(currentURL.contentEquals(expectedURL)) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// link Sair
			//driver.findElement(By.id("_ctl0_HyperLinkSair")).click();
			
			
			Assert.assertEquals(expectedURL, currentURL);
			String nameWindow2 = driver.manage().window().toString();
			System.out.println(nameWindow2);
			System.out.println("name of Second window");
			
			driver.findElement(By.id("_ctl0_MainContent_btnAcompanhaViabilidade")).click();
			
			driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
			String nameWindow3 = driver.manage().window().toString();
			System.out.println(nameWindow3);
			System.out.println("name of Second window");
			
			System.out.println("Test Passed!! Sucess!!");
			System.out.println(currentURL);
			System.out.println(expectedURL);
			
		}
		else {
			System.out.println("Test Failed! - URL expected invalid!!");
			System.out.println(currentURL);
			System.out.println(expectedURL);
		}
		atualTitle=driver.getTitle();
	System.out.println("@Before, @After and @Test - Inicio, Fim e o Meio");
	System.out.println(atualTitle);
	/*
	String parent = driver.getWindowHandle();

  Set<String> pops=driver.getWindowHandles();
  {
      driver.switchTo().window(popupHandle);
      
	
	String winHandleBefore = driver.getWindowHandle();
	 */
  // Switch to new window opened

  for (String winHandle : driver.getWindowHandles()) {
      driver.switchTo().window(winHandle);
      System.out.println(winHandle);
  }

  // Perform the actions on new window


  /*driver.findElement(By.id("edit-name")).clear();
  WebElement userName = driver.findElement(By.id("edit-name"));
  userName.clear();
  */
  try
  {
  		
  	String popup = driver.getWindowHandle();
  	driver.switchTo().window(popup);
  	
  	WebDriverWait myWaitVar = new WebDriverWait(driver,10);
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpListaMucinicpios")));
  		driver.findElement(By.id("drpListaMucinicpios")).click();
  	
  		//driver.findElement(By.id("drpListaMucinicpios")));
  		Select drpdwnMunicipio = new Select(driver.findElement(By.id("drpListaMucinicpios")));
  		//drpdwnMunicipio.getFirstSelectedOption();
  		//drpdwnMunicipio.selectByIndex(7);
  		drpdwnMunicipio.selectByVisibleText("ALAGOINHAS");
  	
  		Select drpdwnOrgRegistro = new Select(driver.findElement(By.id("drpListaOpcoes")));
  		//drpdwnOrgRegistro.getFirstSelectedOption();
  		//drpdwnOrgRegistro.selectByIndex(1);   	
  		drpdwnOrgRegistro.selectByVisibleText("JUNTA COMERCIAL DO ESTADO DA BAHIA");
  	
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("rdoSimDocumentoRegistrado")));
  		driver.findElement(By.id("rdoNaoDocumentoRegistrado")).click();
  	
  		driver.findElement(By.id("chkEmpresa")).click();
  		driver.findElement(By.id("btnEnviar")).click();
  	
  		//next page
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtProtocolo")));
  	
  		driver.findElement(By.id("txtIPTU")).sendKeys("0");
  		driver.findElement(By.id("txtArea")).sendKeys("0");
   	
  		driver.findElement(By.id("drpEnviaSefaz")).click();
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpTipoRegistro")));
 
  	Select drpdwnEnviaSefaz =new Select (driver.findElement(By.name("drpEnviaSefaz")));
  	drpdwnEnviaSefaz.selectByVisibleText("NÃO");

  		Thread.sleep(3000);

  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'drpTipoRegistro')]")));

  	Select drpdwnTipoRegistro = new Select (driver.findElement(By.xpath("//*[contains(@id,'drpTipoRegistro')]")));
  	
  		drpdwnTipoRegistro.selectByVisibleText("Empresario Individual");

  		Thread.sleep(3000);
 	
		
  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@value,'2135')]")));
  	
  	Select drpdwnNaturezaJuridica = new Select(driver.findElement(By.xpath("//*[contains(@id,'drpnaturezaJuridica')]")));
  	
  		drpdwnNaturezaJuridica.selectByIndex(1);
  	
  	Thread.sleep(3000);
  	Select drpdwnTipoUnidade = new Select(driver.findElement(By.xpath("//*[contains(@id,'drpTipoUnidade')]")));
  	
  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		drpdwnTipoUnidade.selectByIndex(0);
  	
  	driver.findElement(By.id("ChkLstFormaAtuacao_0")).click();
  	Thread.sleep(500);
  	
  	
  	/*
  	driver.findElement(By.id("btnPesquizar")).click();
  	
  	System.out.println("Esperei carregar a Nova pagina Busca3");
  	
  	Thread.sleep(3000);
  	
  	System.out.println("Espera pagina carregar");
  	
  		atualTitle = driver.getTitle();
  	System.out.println(popup);
  	
  	Thread.sleep(3000);
  	
  	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'District')]")));
			currentURL = driver.getCurrentUrl();  
			expectedURL ="http://regin.jucepa.pa.gov.br/regin.externo/EnderecoBusca3.aspx?Pagina=viabilidadepedidoalteracaov4.aspx&idMunicipio=4278";
		
  	System.out.println(currentURL);
		
	    	Select drpdwnDistrict = new Select(driver.findElement(By.xpath("//*[contains(@id,'District')]")));
	    		drpdwnDistrict.selectByVisibleText("AEROPORTO (MOSQUEIRO)");
	    		// click link fluxo alteracao cadastro user
	    		//driver.findElement(By.id("_ctl0_A3")).click();
				// link Sair
			driver.findElement(By.id("_ctl0_HyperLinkSair")).click();
	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/		
  	String cep = "66814133";
  	driver.findElement(By.id("Zip")).click();		
  	driver.findElement(By.id("Zip")).sendKeys(cep);
	    		driver.findElement(By.id("btnBuscarEndereco")).click();
	    		driver.findElement(By.id("txtNumero")).sendKeys("100");
	    		driver.findElement(By.id("txtReferencia")).sendKeys("Posto");
	    		driver.findElement(By.id("btnMostrarMapa")).click();
	    		String homePage = driver.getWindowHandle();
	    		System.out.println("home page"+ homePage);
	    		Thread.sleep(5000);
	    		

	    		//String homePage = driver.getWindowHandle();
	    		
	    		Set<String> windows = driver.getWindowHandles();
	    		System.out.println(windows.size());
	    		 Point position = driver.manage().window().getPosition();
	    		 System.out.println(position);
	    		 
	    		 
	    		 for (String winHandle : driver.getWindowHandles()) {
	    		        driver.switchTo().window(winHandle);
	    		        System.out.println(winHandle);
	    		    }
	    		
	    		driver.findElement(By.id("btn-confirma-topo")).click();
	    		Thread.sleep(1000);
	    		driver.switchTo().window(homePage);
	    		driver.findElement(By.id("btnProximaTab")).click();
	    		driver.findElement(By.id("CpfSocio")).sendKeys("14397569703");
	    		
	    		driver.findElement(By.id("txtNomeSocio")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.id("btnInsertSocio")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.id("btnProximatela2")).click();
	    		
	    		driver.findElement(By.id("txtOpcao1")).sendKeys("JOAO MARCELO PASCOA PIRES DA ROSA");
	    		driver.findElement(By.id("txtOpcao2")).sendKeys("JOAO MARCELO PASCOA P DA ROSA");
	    		driver.findElement(By.id("txtOpcao3")).sendKeys("JOAO MARCELO P P DA ROSA");
	    		
	    		driver.findElement(By.id("txtCodActiEcon")).sendKeys("8650007");
	    		driver.findElement(By.id("btnBuscarCNAE")).click();
	    		
	    		Thread.sleep(3000);
	    		String txt_descCNAE = driver.findElement(By.id("txtDescActiEcon")).getText();
	    		System.out.println(txt_descCNAE);
	    		Thread.sleep(1000);
	    		driver.findElement(By.id("txtObjeto")).sendKeys("ATIVIDADES DE TERAPIA DE NUTRIÇÃO ENTERAL E PARENTERAL");
	    		Thread.sleep(1000);
	    		Select drpdwnTipoAtividade =new Select (driver.findElement(By.id("drpTipoAtividade")));	        	
	    		
	    		drpdwnTipoAtividade.selectByIndex(1);
	    		driver.findElement(By.id("btnInsertAtividade")).click();
	    		driver.findElement(By.id("btnProximatela1")).click();
	    		
	    		//Proxima Etapa
	    		Select drpdwngenControl_170 =new Select (driver.findElement(By.id("genControl_170-34847236000180")));	        	
	    		drpdwngenControl_170.selectByIndex(1);
	    		
	    		//Último dos Moicanos
	    		
	    		Select genControl_171 =new Select (driver.findElement(By.id("genControl_171-34847236000180")));	        	
	    		genControl_171.selectByIndex(1);
	    		
	    		Select genControl_172 =new Select (driver.findElement(By.id("genControl_172-34847236000180")));	        	
	    		genControl_172.selectByIndex(1);
	    		
	    		
	    		
	    		
	    		driver.findElement(By.id("chkResponsabilidade")).click();
	    		
	    		Select ddlRegistroAutomatico =new Select (driver.findElement(By.id("ddlRegistroAutomatico")));	        	
	    		ddlRegistroAutomatico.selectByIndex(1);
	    		
	    		//driver.findElement(By.id("btnGrabar")).click();
	    		
	    		
	    						Assert.assertEquals(expectedURL, currentURL);
			
			System.out.println(currentURL);
			System.out.println(expectedURL);
	    
	System.out.println("@Before, @After and @Test - Inicio, Fim e o Meio");
	System.out.println(atualTitle);
	
      //driver.quit();
  }

  catch(Exception e)
  {
      e.printStackTrace();
      System.out.println("not close");
              }

            //driver.switchTo().window(winHandleBefore);
      //driver.close();
      
		
		
	}
}