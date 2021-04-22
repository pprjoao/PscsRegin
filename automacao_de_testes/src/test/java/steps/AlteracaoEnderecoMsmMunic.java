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

public class AlteracaoEnderecoMsmMunic {
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
	public void alteracaoEnderecoMsmMunic() throws InterruptedException {
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("_ctl0_MainContent_btnViabilidade")).click();
		vars.put("win7149", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win7149").toString());
		
		driver.findElement(By.id("drpListaMucinicpios")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpListaMucinicpios"));
			dropdown.findElement(By.xpath("//option[. = 'MADRE DE DEUS']")).click();
		}
		driver.findElement(By.id("drpListaMucinicpios")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpListaOpcoes"));
			dropdown.findElement(By.xpath("//option[. = 'JUNTA COMERCIAL DO ESTADO DA BAHIA']")).click();
		}
		driver.findElement(By.id("drpListaOpcoes")).click();
		driver.findElement(By.id("chkAltOrgRegConv")).click();
		driver.findElement(By.id("chkAtividade")).click();
		driver.findElement(By.id("chkTipoUnidade")).click();
		driver.findElement(By.id("chkFormaAtuacao")).click();
		driver.findElement(By.id("chkEndereco")).click();
		driver.findElement(By.id("chkPerguntaSocio")).click();
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("29204834231");
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("90.023.802/0001-00");
		driver.findElement(By.id("btnEnviar")).click();
		driver.findElement(By.id("chkMunicipio")).click();
		driver.findElement(By.id("chkUF")).click();
		driver.findElement(By.id("chkMunicipio")).click();
		driver.findElement(By.id("btnEnviar")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).sendKeys("16544605832");
		driver.findElement(By.id("txtNome")).click();
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("ppr.joao@gmail.com");
		driver.findElement(By.id("txtIPTU")).click();
		driver.findElement(By.id("txtIPTU")).sendKeys("0");
		driver.findElement(By.id("txtArea")).sendKeys("10");
		driver.findElement(By.id("drpTipoRegistro")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpTipoRegistro"));
			dropdown.findElement(By.xpath("//option[. = 'Empresario Individual']")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("drpnaturezaJuridica")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpnaturezaJuridica"));
			dropdown.findElement(By.xpath("//option[. = 'Empresário (Individual)']")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("ChkLstTipoUnidade_6")).click();
		//driver.findElement(By.cssSelector("#ChkLstFormaAtuacao tr:nth-child(2)")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ChkLstFormaAtuacao_7")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnPesquizar")).click();
		vars.put("win5171", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win5171").toString());
		driver.findElement(By.id("District")).click();
		{
			WebElement dropdown = driver.findElement(By.id("District"));
			dropdown.findElement(By.xpath("//option[. = 'CENTRO']")).click();
		}
		driver.findElement(By.id("District")).click();
		{
			WebElement dropdown = driver.findElement(By.id("StreetType"));
			dropdown.findElement(By.xpath("//option[. = 'RUA']")).click();
		}
		driver.findElement(By.id("StreetType")).click();
		driver.findElement(By.id("StreetName")).click();
		{
			WebElement dropdown = driver.findElement(By.id("StreetName"));
			dropdown.findElement(By.xpath("//option[. = 'DAS MALVINAS']")).click();
		}
		driver.findElement(By.id("StreetName")).click();
		driver.findElement(By.id("btnRetorna")).click();
		driver.switchTo().window(vars.get("root").toString());
		driver.findElement(By.id("txtNumero")).sendKeys("100");
		driver.findElement(By.id("txtReferencia")).click();
		driver.findElement(By.id("txtReferencia")).sendKeys("posto de gasolina");
		driver.findElement(By.cssSelector(".fonte1")).click();
		
		
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("CpfSocio")).clear();
		driver.findElement(By.id("CpfSocio")).sendKeys("822.727.001-87");
		driver.findElement(By.cssSelector("fieldset > .row:nth-child(3)")).click();
		js.executeScript("window.scrollTo(0,777.7777709960938)");
		driver.findElement(By.id("btnInsertSocio")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnProximatela2")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".headerTabelaEventos")).click();
		driver.findElement(By.id("txtOpcao1")).click();
		driver.findElement(By.id("txtOpcao1")).sendKeys("TESTE1");
		driver.findElement(By.id("txtOpcao2")).sendKeys("TESTE2");
		driver.findElement(By.id("txtOpcao3")).sendKeys("TESTE3");
		driver.findElement(By.id("txtObjeto")).click();
		driver.findElement(By.id("txtObjeto")).sendKeys(
				"TRANSPORTE RODOVIARIO COLETIVO DE PASSAGEIROS, SOB REGIME DE FRETAMENTO, INTERMUNICIPAL, INTERESTADUAL E INTERNACIONAL, TRANSPORTE RODOVIARIO DE CARGA, EXCETO PRODUTOS PERIGOSOS E MUDANCAS, INTERMUNICIPAL, INTERESTADUAL E INTERNACIONAL\\nRESTAURANTE");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("txtCodActiEcon")).click();
		driver.findElement(By.id("txtCodActiEcon")).sendKeys("5611201");
		driver.findElement(By.id("btnBuscarCNAE")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("drpTipoAtividade")).click();
		{
			WebElement dropdown = driver.findElement(By.id("drpTipoAtividade"));
			dropdown.findElement(By.xpath("//option[. = 'PRINCIPAL']")).click();
		}
		driver.findElement(By.id("drpTipoAtividade")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnInsertAtividade")).click();
		{
			WebElement element = driver.findElement(By.id("btnProximatela1"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.id("btnProximatela1")).click();
		driver.findElement(By.id("chkResponsabilidade")).click();
		driver.findElement(By.id("btnGrabar")).click();
		driver.findElement(By.id("Form1")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("lblMensagem"));
			assert (elements.size() > 0);
		}
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnProArquivo")).click();
		vars.put("win3054", waitForWindow(2000));
		driver.switchTo().window(vars.get("win3054").toString());
	}
}
