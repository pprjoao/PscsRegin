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

public class AlteracaoAtividEconomicTest {

	String urlBase = "http://200.187.18.147";
	String urlDir = urlBase + "/RequerimentoUniversal/";
	String urlPagina = "NovoLogin.aspx";
	String url = urlDir + urlPagina;
	String msgReceita="Comunicação com a Receita Federal do Brasil fora do ar, tente novamente mais tarde Unable to connect to the remote server SoapException";
	String msgCNPJinvalid="RFB: 99 - CNPJ NAO ENCONTRADO NA BASE";
	String msgNatJurOrgRegDifereRFB= "Natureza Jurídica cadatrada no Órgão de Registro";
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println(url);
		driver.get(url);
		//driver.get(url);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		if(urlBase.contains(urlBase))
		driver.findElement(By.id("_ctl0_MainContent_Button1")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031090");
		driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		// String expectedURL = "http://regin.juceb.ba.gov.br/requerimentoUniversal/NovoLogin.aspx";
		// String expectedURL ="http://200.187.18.147/RequerimentoUniversal/Principal.aspx";
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
	public void alteracaoAtividEconomicTest() throws InterruptedException {	
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
		driver.findElement(By.id("chkAtividade")).click();
		driver.findElement(By.id("txtNire")).click();
		driver.findElement(By.id("txtNire")).sendKeys("29204834231");
		driver.findElement(By.id("txtCnpj")).click();
		driver.findElement(By.id("txtCnpj")).sendKeys("90.023.802/0001-00");
		driver.findElement(By.id("btnEnviar")).click();
		//String msg=driver.findElement(By.id("divAvisosMensagem")).getText();
		/*if(!msg.isEmpty()) {
		if(msg.equals(msgReceita)) {
			System.out.println(msg);
			}
		else if(msg.equals(msgCNPJinvalid)){
			System.out.println(msg);
			driver.findElement(By.id("txtCnpj")).click();
			driver.findElement(By.id("txtCnpj")).clear();
			driver.findElement(By.id("txtCnpj")).sendKeys("13.574.983/0001-11");
			driver.findElement(By.id("btnEnviar")).click();
		}
		else if(msg.contains(msgNatJurOrgRegDifereRFB)) {
			System.out.println(msg);
			driver.findElement(By.id("txtCnpj")).click();
			driver.findElement(By.id("txtCnpj")).clear();
			driver.findElement(By.id("txtCnpj")).sendKeys("15.193.923/0001-84");
			driver.findElement(By.id("btnEnviar")).click();
			
		}
		}
		*/
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).sendKeys("16544605832");
		driver.findElement(By.id("txtNome")).click();
		driver.findElement(By.id("txtEmail")).click();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtEmail")).sendKeys("ppr.joao@gmail.com");
		driver.findElement(By.id("txtIPTU")).click();
		driver.findElement(By.id("txtIPTU")).sendKeys("0");
		driver.findElement(By.id("txtArea")).sendKeys("10");
		driver.findElement(By.id("btnProximaTab")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnProximatela2")).click();
		driver.findElement(By.cssSelector(".headerTabelaEventos")).click();
		driver.findElement(By.id("txtObjeto")).click();
		driver.findElement(By.id("txtObjeto")).sendKeys(
				"TRANSPORTE RODOVIARIO COLETIVO DE PASSAGEIROS, SOB REGIME DE FRETAMENTO, INTERMUNICIPAL, INTERESTADUAL E INTERNACIONAL, TRANSPORTE RODOVIARIO DE CARGA, EXCETO PRODUTOS PERIGOSOS E MUDANCAS, INTERMUNICIPAL, INTERESTADUAL E INTERNACIONAL\\nRESTAURANTE");
		driver.findElement(By.id("ListCNAE_DeleteFilial_1")).click();
		Thread.sleep(2000);
		//alert confirma exclusao clicar em ok
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.id("txtCodActiEcon")).click();
		driver.findElement(By.id("txtCodActiEcon")).sendKeys("4930202");
		driver.findElement(By.id("btnBuscarCNAE")).click();
		Thread.sleep(2000);

		
		{
			WebElement dropdown = driver.findElement(By.id("drpTipoAtividade"));
			
			dropdown.findElement(By.xpath("//option[. = 'SECUNDARIA']")).click();
		}
		
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
		driver.findElement(By.cssSelector("table:nth-child(8) tr:nth-child(1) > .tabela")).click();
		assertThat(driver.findElement(By.cssSelector("table:nth-child(8) tr:nth-child(1) > .tabela")).getText(),
				is("NIRE: 29204834231"));
		driver.findElement(By.cssSelector("table:nth-child(8) tr:nth-child(2) > .tabela")).click();
		driver.findElement(By.cssSelector("table:nth-child(8) tr:nth-child(2) > .tabela")).click();
		assertThat(driver.findElement(By.cssSelector("table:nth-child(8) tr:nth-child(2) > .tabela")).getText(),
				is("CNPJ: 90023802000100"));
		driver.findElement(By.cssSelector("tr:nth-child(4) > .tabela")).click();
		assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .tabela")).getText(),
				is("NIRE DA MATRIZ: 29204834231"));
		driver.findElement(By.cssSelector("table:nth-child(8) tr:nth-child(7) > .dados")).click();
		driver.findElement(By.cssSelector("tr:nth-child(7) > .dados")).click();
		driver.findElement(By.cssSelector("table:nth-child(3) .dados")).click();
		assertThat(driver.findElement(By.cssSelector("table:nth-child(3) .dados")).getText(),
				is("ALTERAÇÃO DE ATIVIDADES ECONÔMICAS (PRINCIPAL E SECUNDÁRIAS)"));
		driver.close();
	}
}
