package steps;

import java.security.KeyStoreSpi;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@SuppressWarnings("deprecation")
public class MatrizSteps{

public static void main(String[] args) {
	String expectedURL="http://regin.jucepa.pa.gov.br/requerimentoUniversal/Principal.aspx";
	String atualTitle="";
	//String cpf="1439769703";
	//String pwd="031090";
	

	/*
	System.setProperty("webdriver.gecko.driver", "..\\src\\driver\\geckrodriver_026.exe");

    WebDriver driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.get("https://www.google.com.br/");
    
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver(capabilities);
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
    
    */
	
    System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver_87.exe");
    
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	
	ChromeOptions opts = new ChromeOptions();
	opts.addArguments("start-maximized");
	capabilities.setCapability(ChromeOptions.CAPABILITY, opts);
	
	/*WebDriver Cdriver = new ChromeDriver(capabilities);
	Cdriver.manage().deleteAllCookies();
	Cdriver.get("http://www.google.com");
	System.out.println(Cdriver.getTitle());
	*/
	
    WebDriver driver = new ChromeDriver(capabilities);
    driver.manage().deleteAllCookies();
   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	driver.manage().window().maximize();
   	driver.get("http://regin.jucepa.pa.gov.br/requerimentoUniversal/NovoLogin.aspx");
	String nameWindow = driver.manage().window().toString();
	System.out.println(nameWindow);
	System.out.println("name of first window");
	
	
		
	//Declaração do Botão fechar
	
		//WebElement btnClsFrstMsgLogin = driver.findElement(By.id("_ctl0_MainContent_Button1")); 
		//btnClsFrstMsgLogin.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031090");
		/*
		WebElement txtUser = driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ"));	
		txtUser.sendKeys(cpf);
			pwd.sendKeys(pwd);
*/
		//driver.findElement(By.xpath("//*[@id='_ctl0_MainContent_btnBrasilCidadao']")).click();
		//input[@type="submit" AND @id="_ctl0_MainContent_btnEntrar"]
		driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
	
		atualTitle = driver.getTitle();
		String currentURL = driver.getCurrentUrl();  
		
		if(currentURL.contentEquals(expectedURL)) {
			// click link fluxo alteracao cadastro user
			//driver.findElement(By.id("_ctl0_A3")).click();

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
    		drpdwnMunicipio.selectByVisibleText("BELÉM");
    	
    		Select drpdwnOrgRegistro = new Select(driver.findElement(By.id("drpListaOpcoes")));
    		//drpdwnOrgRegistro.getFirstSelectedOption();
    		//drpdwnOrgRegistro.selectByIndex(1);   	
    		drpdwnOrgRegistro.selectByVisibleText("JUNTA COMERCIAL DO ESTADO DO PARA");
    	
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