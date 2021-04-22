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

public class AlterarEnderecoOutraUFTestMsg {
	String urlBase="http://200.187.18.147";
	private WebDriver driver;

	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlBase+"/requerimentoUniversal/NovoLogin.aspx");
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
		String expectedURL = urlBase+"/requerimentoUniversal/Principal.aspx";
		assertEquals(currentURL, expectedURL);
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
	public void alterarEnderecoOutraUFTestMsg() {
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
		vars.put("win9355", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win9355").toString());
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
		driver.findElement(By.id("chkEndereco")).click();
		driver.findElement(By.id("chkUF")).click();
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("90020358000179");
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("42600298595");
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.cssSelector("#divGrupoNireCnpj > .row")).click();
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("90020358000179");
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("42600298594");
		driver.findElement(By.id("btnEnviar")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpUF"));
			dropdown.findElement(By.xpath("//option[. = 'RN']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("drpUF"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("drpUF"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("drpUF"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("42600298595");
		driver.findElement(By.id("btnEnviar")).click();
		js.executeScript("window.scrollTo(0,106)");
		driver.findElement(By.id("txtIPTU")).click();
		driver.findElement(By.id("txtIPTU")).sendKeys("1234567");
		driver.findElement(By.id("txtArea")).click();
		driver.findElement(By.id("txtArea")).sendKeys("52");
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnPesquizar")).click();
		vars.put("win8902", waitForWindow(2000));
		driver.switchTo().window(vars.get("win8902").toString());
		{
			WebElement dropdown = driver.findElement(By.id("District"));
			dropdown.findElement(By.xpath("//option[. = 'CENTRO']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("District"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("District"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("District"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		{
			WebElement dropdown = driver.findElement(By.id("StreetType"));
			dropdown.findElement(By.xpath("//option[. = 'PRACA']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("StreetType"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("StreetType"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("StreetType"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
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
		driver.switchTo().window(vars.get("win9355").toString());
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("btnProximatela2")).click();
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).sendKeys("16544605832");
		driver.findElement(By.id("txtNome")).click();
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("ALOBIANCO@PSCS.COM.BR");
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("ALOBIANCO@PSCS.COM.BR");
		driver.findElement(By.id("Zip")).sendKeys("22793390");
		driver.findElement(By.id("Form1")).click();
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtIPTU")).click();
		driver.findElement(By.id("txtIPTU")).sendKeys("1234567");
		driver.findElement(By.cssSelector("#pnOutrosDados > .row:nth-child(1)")).click();
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtArea")).click();
		driver.findElement(By.id("txtArea")).sendKeys("52");
		driver.findElement(By.id("btnProximaTab")).click();
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnPesquizar")).click();
		vars.put("win445", waitForWindow(2000));
		driver.switchTo().window(vars.get("win445").toString());
		{
			WebElement dropdown = driver.findElement(By.id("District"));
			dropdown.findElement(By.xpath("//option[. = 'CENTRO']")).click();
		}
		{
			WebElement element = driver.findElement(By.id("District"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.id("District"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("District"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		{
			WebElement dropdown = driver.findElement(By.id("StreetType"));
			dropdown.findElement(By.xpath("//option[. = 'PRACA']")).click();
		}
		driver.findElement(By.id("StreetName")).click();
		{
			WebElement dropdown = driver.findElement(By.id("StreetName"));
			dropdown.findElement(By.xpath("//option[. = 'PEDRO GOMES']")).click();
		}
		driver.findElement(By.id("btnRetorna")).click();
		driver.switchTo().window(vars.get("win9355").toString());
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtNumero")).click();
		driver.findElement(By.id("txtNumero")).sendKeys("S/N");
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtOpcao2")).click();
		driver.findElement(By.id("txtOpcao2")).sendKeys("TESTE PA - EIRELI 1");
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtOpcao3")).click();
		driver.findElement(By.id("txtOpcao3")).sendKeys("TESTE PA - EIRELI 2");
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtOpcao2")).click();
		driver.findElement(By.id("txtOpcao2")).sendKeys("TESTE PA 2 - EIRELI ");
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("txtOpcao3")).click();
		driver.findElement(By.id("txtOpcao3")).sendKeys("TESTE PA 3 - EIRELI");
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("divAvisosMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("divAvisosMensagem"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("btnEmpresa")).click();
		driver.findElement(By.id("txtOpcao1")).click();
		driver.findElement(By.id("txtOpcao1")).sendKeys("TESTE PA - EIRELI EM RECUPERAÇÃO JUDICIAL");
		driver.findElement(By.id("btnInfo")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("chkResponsabilidade")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("lblMensagem")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("lblMensagem"));
			assert (elements.size() > 0);
		}
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnProArquivo")).click();
		vars.put("win9134", waitForWindow(2000));
		driver.switchTo().window(vars.get("win9134").toString());
		driver.findElement(By.cssSelector("table:nth-child(3) .dados")).click();
		assertThat(driver.findElement(By.cssSelector("table:nth-child(3) .dados")).getText(),
				is("ALTERAÇÃO DE ENDEREÇO ENTRE ESTADOS"));
		driver.findElement(By.cssSelector("table:nth-child(11) .dados")).click();
		assertThat(driver.findElement(By.cssSelector("table:nth-child(11) .dados")).getText(),
				is("PRACA PEDRO GOMES S/N - - CENTRO MADRE DE DEUS - BAHIA CEP: 42600000"));
		driver.close();
	}
}
