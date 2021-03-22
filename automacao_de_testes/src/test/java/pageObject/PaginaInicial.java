package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicial  {
	private WebDriver driver;
	public PaginaInicial(WebDriver driver) {
		this.driver =driver;
	}
	public WebDriver getDriver() {
		return this.driver;
	}
	public PaginaParametros acessaPaginaDeParametros() {
		getDriver().findElement(By.id("_ctl0_MainContent_btnEntrar")).click();
		return new PaginaParametros(getDriver());
		
		
	}
}