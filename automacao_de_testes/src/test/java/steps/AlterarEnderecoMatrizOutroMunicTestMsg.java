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

public class AlterarEnderecoMatrizOutroMunicTestMsg {
	String urlBase = "http://200.187.18.147";
	String urlDir = urlBase + "/RequerimentoUniversal/";
	String urlPagina = "NovoLogin.aspx";
	String url = urlDir + urlPagina;
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlBase+urlDir+urlPagina);
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
		driver.findElement(By.id("_ctl0_MainContent_btnAcompanhaViabilidade")).click();
		Thread.sleep(2000);
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
	public void alterarEnderecoMatrizOutroMunicTestMsg() throws InterruptedException {
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
		vars.put("win7149", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win7149").toString());
		driver.findElement(By.id("drpListaMucinicpios")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpListaMucinicpios"));
			dropdown.findElement(By.xpath("//option[. = 'ALAGOINHAS']")).click();
		}
		{
			WebElement dropdown = driver.findElement(By.id("drpListaOpcoes"));
			dropdown.findElement(By.xpath("//option[. = 'JUNTA COMERCIAL DO ESTADO DA BAHIA']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("drpListaOpcoes"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("drpListaOpcoes"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("drpListaOpcoes"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.id("chkEndereco")).click();
		driver.findElement(By.id("chkMesmoUF")).click();
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("29204834231");
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("90023802000100");
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).sendKeys("16544605832");
		driver.findElement(By.id("txtNome")).click();
		driver.findElement(By.cssSelector("#pnlTab1 > fieldset > .row:nth-child(3)")).click();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtEmail")).sendKeys("PPR.JOAO@PSCS.COM.BR");
		driver.findElement(By.id("txtIPTU")).sendKeys("0");
		driver.findElement(By.id("txtArea")).sendKeys("1");
		
		vars.put("window_handles", driver.getWindowHandles());
	    driver.findElement(By.id("btnPesquizar")).click();
	    vars.put("win5171", waitForWindow(2000));
	    vars.put("root", driver.getWindowHandle());
	    driver.switchTo().window(vars.get("win5171").toString());
	   
	    {
	      WebElement dropdown = driver.findElement(By.id("District"));
	      dropdown.findElement(By.xpath("//option[. = 'CATU']")).click();
	    }
	    
	    driver.findElement(By.id("StreetType")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("StreetType"));
	      dropdown.findElement(By.xpath("//option[. = 'RUA']")).click();
	      
	    }
	    driver.findElement(By.id("StreetName")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("StreetName"));
	      dropdown.findElement(By.xpath("//option[. = 'CONSELHEIRO JUNQUEIRA - Compl: LOTEAMENTO HERMES DE CARVALHO QUADRA 07 LOTE 006']")).click();	      
	    }
	    driver.findElement(By.id("btnRetorna")).click();
	    
	    driver.switchTo().window(vars.get("win7149").toString());
		driver.findElement(By.id("txtNumero")).sendKeys("100");
		
		
		
		//vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnProximaTab")).click();
		//vars.put("win7200", waitForWindow(2000));
		//vars.put("root", driver.getWindowHandle());
		
		
		
		//vars.put("window_handles", driver.getWindowHandles());
		
		//vars.put("win7300", waitForWindow(2000));
		//vars.put("root", driver.getWindowHandle());
		
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela2")).click();
		
		driver.findElement(By.id("btnProximatela1")).click();
		
		driver.findElement(By.id("chkResponsabilidade")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("lblMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("lblMensagem"));
			assert (elements.size() > 0);
		}
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnProArquivo")).click();
		vars.put("win8364", waitForWindow(2000));
		driver.switchTo().window(vars.get("win8364").toString());
		driver.findElement(By.cssSelector("table:nth-child(3) .dados")).click();
		assertThat(driver.findElement(By.cssSelector("table:nth-child(3) .dados")).getText(),
				is("ALTERAÇÃO DE ENDEREÇO ENTRE MUNICÍPIOS DENTRO DO MESMO ESTADO"));
		driver.findElement(By.cssSelector("table:nth-child(11) .dados")).click();
		driver.close();
		driver.switchTo().window(vars.get("win7149").toString());
		driver.close();
	}
}
