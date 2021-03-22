package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginaBase {
	 
	public  WebDriver driver;

		private static PaginaBase instance;
		
		public static  PaginaBase getInstance() {
			if(instance==null) {
				instance = new PaginaBase();
			}
			return instance;
		}
		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}
		
	protected PaginaBase() {
		System.setProperty("webdriver.chrome.driver", "../automacao_de_testes/src/driver/chromedriver.exe");		
		this.driver = new ChromeDriver();
		
	}

	public void navegateTo(String url) {
		
		getDriver().navigate().to(url);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void closeAlertErro() {
		Alert erroAlert = driver.switchTo().alert(); 
		String alertText = erroAlert.getText(); 
		System.out.println("A mensagem é: " + alertText); 
		erroAlert.accept(); 
	}
	public void closeNavegator() {
		getDriver().close();
	}
}
