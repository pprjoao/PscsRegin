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
import java.net.MalformedURLException;
import java.net.URL;

public class AlterarNomeEmpresarialTest {
	//String urlBase = "http://redesim.jucepe.pe.gov.br";
	
	String urlBase = "http://200.187.18.147";
	String urlPath = "/RequerimentoUniversal/";
	String urlDir = urlBase + urlPath;
	String urlPagina = "NovoLogin.aspx";
	String url = urlDir + urlPagina;
	
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.findElement(By.id("_ctl0_MainContent_Button1")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031090");
		driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();
		// String expectedURL =
		// "http://200.187.18.147/RequerimentoUniversal/Principal.aspx";
		urlPagina = "Principal.aspx";
		String expectedURL = urlDir + urlPagina;
		assertEquals(expectedURL, currentURL);
	
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
	  public void alterarNomeEmpresarialTest() throws InterruptedException {
		  urlPath = "/regin.externo/";
		  urlPagina = "ViabilidadeOpcaoV4.aspx";
		  urlDir = urlBase + urlPath;
		  url = urlDir + urlPagina;
		  
	    driver.get(url);
	    Thread.sleep(3000);
	    driver.findElement(By.id("drpListaMucinicpios")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("drpListaMucinicpios"));
	      dropdown.findElement(By.xpath("//option[. = 'MADRE DE DEUS']")).click();
	    }
	    driver.findElement(By.id("drpListaMucinicpios")).click();
	    driver.findElement(By.id("drpListaOpcoes")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("drpListaOpcoes"));
	      dropdown.findElement(By.xpath("//option[. = 'JUNTA COMERCIAL DO ESTADO DA BAHIA']")).click();
	    }
	    driver.findElement(By.id("drpListaOpcoes")).click();
	    driver.findElement(By.id("chkNome")).click();
	    driver.findElement(By.id("txtNire")).click();
	    driver.findElement(By.id("txtNire")).click();
	    driver.findElement(By.id("txtNire")).sendKeys("29204834231");
	    driver.findElement(By.id("txtCnpj")).click();
	    driver.findElement(By.cssSelector("#divGrupoNireCnpj > .row")).click();
	    driver.findElement(By.id("txtCnpj")).click();
	    driver.findElement(By.id("txtCnpj")).sendKeys("90023802000100");
	    driver.findElement(By.cssSelector("#divGrupoNireCnpj > .row")).click();
	    driver.findElement(By.id("txtInscEstadual")).click();
	    driver.findElement(By.id("divGrupoInscCnpj")).click();
	    driver.findElement(By.id("btnEnviar")).click();
	    driver.findElement(By.id("Cpf")).click();
	    driver.findElement(By.id("Cpf")).sendKeys("16544605832");
	    driver.findElement(By.id("txtEmail")).click();
	    driver.findElement(By.id("txtEmail")).clear();
	    driver.findElement(By.id("txtEmail")).sendKeys("ppr.joao@gmail.com");
	    driver.findElement(By.id("txtIPTU")).click();
	    driver.findElement(By.id("txtIPTU")).sendKeys("0");
	    driver.findElement(By.id("txtArea")).sendKeys("10");
	    driver.findElement(By.cssSelector(".col-md-4:nth-child(3)")).click();
	    driver.findElement(By.id("btnProximaTab")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("btnProximatela2")).click();
	    driver.findElement(By.id("txtOpcao1")).click();
	    driver.findElement(By.id("txtOpcao1")).sendKeys("JOSE CARLOS DOCES E CIA LTDA");
	    driver.findElement(By.id("txtOpcao2")).sendKeys("JOSE CARLOS BAR E RESTARANTE LTDA");
	    driver.findElement(By.id("txtOpcao3")).sendKeys("JOSE CARLOS RESTAURANTE");
	    driver.findElement(By.id("btnProximatela1")).click();
	    {
	      WebElement element = driver.findElement(By.id("chkResponsabilidade"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("chkResponsabilidade")).click();
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.id("btnGrabar")).click();
	    assertThat(driver.findElement(By.id("divAvisosMensagem")).getText(), is("Opção 3 Natureza Jurídica de necessita que o Nome Empresarial possua LIMITADA, LIMITADA EM LIQUIDAÇÃO, LIMITADA EM RECUPERAÇÃO JUDICIAL, LTDA, LTDA EM LIQUIDAÇÃO ou LTDA EM RECUPERAÇÃO JUDICIAL ao final (Sem Ponto)"));
	    driver.findElement(By.id("txtOpcao3")).click();
	    driver.findElement(By.id("txtOpcao3")).sendKeys("JOSE CARLOS LOGISTICA EM TRANSPORTE LTDA");
	    driver.findElement(By.id("btnProximatela1")).click();
	    driver.findElement(By.id("btnGrabar")).click();
	    driver.findElement(By.id("divAvisosMensagem")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.id("lblMensagem"));
	      assert(elements.size() > 0);
	    }
	    vars.put("window_handles", driver.getWindowHandles());
	    driver.findElement(By.id("btnProArquivo")).click();
	    vars.put("win77", waitForWindow(2000));
	    vars.put("root", driver.getWindowHandle());
	    driver.switchTo().window(vars.get("win77").toString());
	    driver.findElement(By.cssSelector("table:nth-child(3) .dados")).click();
	    assertThat(driver.findElement(By.cssSelector("table:nth-child(3) .dados")).getText(), is("ALTERAÇÃO DO NOME EMPRESARIAL (FIRMA OU DENOMINAÇÃO)"));
	    driver.findElement(By.cssSelector("tr:nth-child(2) > .body")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.cssSelector(".body > strong"));
	      assert(elements.size() > 0);
	    }
	    driver.findElement(By.cssSelector("tr:nth-child(7) > .dados")).click();
	    driver.findElement(By.cssSelector("tr:nth-child(7) > .dados")).click();
	    driver.findElement(By.cssSelector("table:nth-child(23) > tbody")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.cssSelector("table:nth-child(23) tr:nth-child(1) > .tabela"));
	      assert(elements.size() > 0);
	    }
	    driver.close();
	    driver.switchTo().window(vars.get("root").toString());
	  }
	}
