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

public class AlterarOrgaoRegistroEnderecoTestMsg {

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
		 urlPath = "/RequerimentoUniversal/";
		 urlDir = urlBase + urlPath;
		 urlPagina = "Principal.aspx";
		 url = urlDir + urlPagina;
		String expectedURL = url;
		assertEquals(expectedURL, currentURL);
		driver.findElement(By.id("_ctl0_MainContent_btnAcompanhaViabilidade")).click();
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
	public void alterarOrgaoRegistroEnderecoTestMsg() throws InterruptedException {
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
		vars.put("win671", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win671").toString());
		{
			WebElement dropdown = driver.findElement(By.id("drpListaMucinicpios"));
			Thread.sleep(3000);
			dropdown.findElement(By.xpath("//option[. = 'MADRE DE DEUS']")).click();
		}
		driver.findElement(By.id("drpListaOpcoes")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpListaOpcoes"));
			dropdown.findElement(By.xpath("//option[. = 'JUNTA COMERCIAL DO ESTADO DA BAHIA']")).click();
		}
		driver.findElement(By.id("chkAltOrgRegConv")).click();
		driver.findElement(By.id("chkEndereco")).click();
		driver.findElement(By.id("chkUF")).click();
		driver.findElement(By.id("drpUF")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpUF"));
			dropdown.findElement(By.xpath("//option[. = 'SC']")).click();
		}
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("divGrupoInscCnpj")).click();
		driver.findElement(By.id("btnEnviar")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("123456");
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("04247200000102");
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).sendKeys("16544605832");
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("alobianco@pscs.com.br");
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela2")).click();
		js.executeScript("window.scrollTo(0,901)");
		js.executeScript("window.scrollTo(0,1378)");
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtArea")).click();
		driver.findElement(By.id("txtArea")).sendKeys("50");
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela2")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("drpTipoRegistro")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpTipoRegistro"));
			dropdown.findElement(By.xpath("//option[. = 'Empresario Individual']")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela2")).click();
		js.executeScript("window.scrollTo(0,2)");
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("drpnaturezaJuridica")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpnaturezaJuridica"));
			dropdown.findElement(By.xpath("//option[. = 'Empresário (Individual)']")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela2")).click();
		js.executeScript("window.scrollTo(0,3)");
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtIPTU")).click();
		driver.findElement(By.id("txtIPTU")).sendKeys("1234567");
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnPesquizar")).click();
		vars.put("win2438", waitForWindow(2000));
		driver.switchTo().window(vars.get("win2438").toString());
		driver.findElement(By.id("District")).click();
		{
			WebElement dropdown = driver.findElement(By.id("District"));
			dropdown.findElement(By.xpath("//option[. = 'CENTRO']")).click();
		}
		driver.findElement(By.id("StreetType")).click();
		{
			WebElement dropdown = driver.findElement(By.id("StreetType"));
			dropdown.findElement(By.xpath("//option[. = 'PRACA']")).click();
		}
		{
			WebElement dropdown = driver.findElement(By.id("StreetName"));
			dropdown.findElement(By.xpath("//option[. = 'PEDRO GOMES']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("StreetName"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("StreetName"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("StreetName"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.id("btnRetorna")).click();
		driver.switchTo().window(vars.get("win671").toString());
		driver.findElement(By.id("txtNumero")).click();
		driver.findElement(By.id("txtNumero")).sendKeys("2");
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("CpfSocio")).clear();
		driver.findElement(By.id("CpfSocio")).sendKeys("16544605832");
		driver.findElement(By.id("txtNomeSocio")).click();
		driver.findElement(By.id("btnInsertSocio")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnProximatela2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnProximatela1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtOpcao1")).click();
		driver.findElement(By.id("txtOpcao1")).sendKeys("JOAO BAR E RESTAURANTE");
		driver.findElement(By.id("txtOpcao2")).click();
		driver.findElement(By.id("txtOpcao2")).sendKeys("JOAO RESTAURANTE E BOITE");
		driver.findElement(By.id("txtOpcao3")).click();
		driver.findElement(By.id("txtOpcao3")).sendKeys("JOAO BOITE E RESTAURANTE");
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtObjeto")).click();
		driver.findElement(By.id("txtObjeto")).sendKeys("RESTAURANTE");
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("chkResponsabilidade")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("lblMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("lblMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector("#divMsgError > span")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnProArquivo")).click();
		vars.put("win1992", waitForWindow(2000));
		driver.switchTo().window(vars.get("win1992").toString());
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("table:nth-child(3) tr:nth-child(4) > .dados")).click();
		{
			List<WebElement> elements = driver
					.findElements(By.cssSelector("table:nth-child(3) tr:nth-child(4) > .dados"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector(".dados:nth-child(4)")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".dados:nth-child(4)"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector("table:nth-child(11) .dados")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("table:nth-child(11) .dados"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector("table:nth-child(23) tr:nth-child(3) > .dados:nth-child(3)")).click();
		{
			List<WebElement> elements = driver
					.findElements(By.cssSelector("table:nth-child(23) tr:nth-child(3) > .dados:nth-child(3)"));
			assert (elements.size() > 0);
		}
		driver.close();
		driver.switchTo().window(vars.get("win671").toString());
		driver.close();
		driver.switchTo().window(vars.get("root").toString());
		driver.close();
	}
}
