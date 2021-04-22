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

public class CancelamentoViabilidadeTest {
	String urlBase = "http://200.187.18.147";
	String urlDir = urlBase + "/RequerimentoUniversal/";
	String urlPagina = "NovoLogin.aspx";
	String url = urlDir + urlPagina;
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println(url);
		driver.get(url);
		// driver.get(url);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		if (urlBase.contains(urlBase))
			driver.findElement(By.id("_ctl0_MainContent_Button1")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys("14397569703");
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).click();
		driver.findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys("031090");
		driver.findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentURL = driver.getCurrentUrl();
		// String expectedURL =
		// "http://regin.juceb.ba.gov.br/requerimentoUniversal/NovoLogin.aspx";
		// String expectedURL
		// ="http://200.187.18.147/RequerimentoUniversal/Principal.aspx";
		urlPagina = "Principal.aspx";
		String expectedURL = urlDir + urlPagina;
		assertEquals(expectedURL, currentURL);
		
	
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void cancelamentoViabilidadeTest() {
		//driver.findElement(By.id("_ctl0_MainContent_Button2")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("_ctl0_MainContent_Button2")).click();
		vars.put("win3547", waitForWindow(2000));
		driver.switchTo().window(vars.get("win3547").toString());
		driver.findElement(By.id("txtProtocolo")).click();
		driver.findElement(By.id("txtProtocolo")).sendKeys("BAP2100003444");
		driver.findElement(By.id("btnBuscar")).click();
		driver.findElement(By.cssSelector("tr > .dados")).click();
		assertThat(driver.findElement(By.cssSelector("li")).getText(), is("CNPJ/CPF e Protocolo são obrigatórios"));
		driver.findElement(By.id("txtProtocolo")).click();
		driver.findElement(By.id("txtProtocolo")).clear();
		driver.findElement(By.id("btnBuscar")).click();
		driver.findElement(By.cssSelector("li")).click();
		
		driver.findElement(By.id("Cpf")).sendKeys("14397569703");
		assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Protocolo obrigatório"));
		driver.findElement(By.id("txtProtocolo")).click();
		driver.findElement(By.id("txtProtocolo")).clear();
		driver.findElement(By.id("txtProtocolo")).sendKeys("CNPJ/CPF e Protocolo são obrigatórios");
		driver.findElement(By.id("btnBuscar")).click();
		driver.findElement(By.cssSelector("li")).click();
		driver.findElement(By.id("txtProtocolo")).click();
		{
			WebElement element = driver.findElement(By.id("txtProtocolo"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Protocolo não existe"));
		driver.findElement(By.id("txtProtocolo")).clear();
		driver.findElement(By.id("txtProtocolo")).sendKeys("BAP2100003444");
		driver.findElement(By.id("Cpf")).click();
		driver.findElement(By.id("Cpf")).clear();
		driver.findElement(By.id("Cpf")).sendKeys("143.975.697-03");
		driver.findElement(By.id("btnBuscar")).click();
		assertThat(driver.findElement(By.cssSelector("li")).getText(), is("CNPJ/CPF não confere com esse protocolo"));
		
		driver.findElement(By.cssSelector("li")).click();
		driver.findElement(By.cssSelector("tr:nth-child(2)")).click();
		driver.findElement(By.id("Cpf")).clear();
		driver.findElement(By.id("Cpf")).sendKeys("165.446.058-32");
		driver.findElement(By.id("btnBuscar")).click();
		driver.findElement(By.id("Label2")).click();
		assertThat(driver.findElement(By.id("Label2")).getText(), is("Motivo"));
		driver.findElement(By.cssSelector(".tabela tr:nth-child(1) > .tabela")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("txtObservacao"));
			assert (elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("btnCancelar"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.id("txtObservacao")).click();
		driver.findElement(By.id("txtObservacao")).click();
		driver.findElement(By.id("txtObservacao")).sendKeys("Cancelamento teste 140421");
		driver.findElement(By.id("txtObservacao")).click();
		driver.findElement(By.id("btnCancelar")).click();
		//driver.switchTo().alert().dismiss();
		//driver.switchTo().alert().accept();
		//driver.close();
	}
}
