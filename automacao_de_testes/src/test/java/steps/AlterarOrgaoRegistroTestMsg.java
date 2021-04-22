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

public class AlterarOrgaoRegistroTestMsg {
	String urlBase = "http://regin.jucesc.sc.gov.br";
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlBase + "/TesteHomologacao/requerimentoUniversal_homolog/NovoLogin.aspx");
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031090");
		driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();
		// String expectedURL =
		// "http://200.187.18.147/RequerimentoUniversal/Principal.aspx";
		String expectedURL = urlBase+"/TesteHomologacao/requerimentoUniversal_homolog/Principal.aspx";
		assertEquals( expectedURL, currentURL);
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
	public void alterarOrgaoRegistroTestMsg() {
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
		vars.put("win1265", waitForWindow(2000));
		driver.switchTo().window(vars.get("win1265").toString());
		driver.findElement(By.id("drpListaMucinicpios")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpListaMucinicpios"));
			dropdown.findElement(By.xpath("//option[. = 'MADRE DE DEUS']")).click();
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
		driver.findElement(By.id("chkAltOrgRegConv")).click();
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("123456");
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("04247200000102");
		driver.findElement(By.id("btnEnviar")).click();
		js.executeScript("window.scrollTo(0,159)");
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).sendKeys("16544605832");
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("alobianco@pscs.com.br");
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("btnProximatela2")).click();
		js.executeScript("window.scrollTo(0,13)");
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
		driver.findElement(By.id("btnProximatela2")).click();
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("drpTipoRegistro")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpTipoRegistro"));
			dropdown.findElement(By.xpath("//option[. = 'Empresario Individual']")).click();
		}
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("btnProximatela2")).click();
		driver.findElement(By.id("btnProximatela1")).click();
		js.executeScript("window.scrollTo(0,130)");
		driver.findElement(By.id("btnGrabar")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpnaturezaJuridica"));
			dropdown.findElement(By.xpath("//option[. = 'Empresário (Individual)']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("drpnaturezaJuridica"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("drpnaturezaJuridica"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("drpnaturezaJuridica"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("CpfSocio")).click();
		driver.findElement(By.id("CpfSocio")).sendKeys("16544605832");
		driver.findElement(By.id("txtNomeSocio")).click();
		driver.findElement(By.id("btnProximatela2")).click();
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtIPTU")).click();
		driver.findElement(By.id("txtIPTU")).sendKeys("1234567");
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("btnInsertSocio")).click();
		driver.findElement(By.id("btnProximatela2")).click();
		js.executeScript("window.scrollTo(0,137)");
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
		{
			WebElement element = driver.findElement(By.id("txtObjeto"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("txtObjeto"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("txtObjeto"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.id("txtObjeto")).click();
		driver.findElement(By.id("txtObjeto")).sendKeys("RESTAURANTE");
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("chkResponsabilidade")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divRFBMsg")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divRFBMsg"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.cssSelector("fieldset > div:nth-child(2)")).click();
		driver.findElement(By.cssSelector("td > .textoAjuda")).click();
	}
}
