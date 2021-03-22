package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaParametros  {
	
	String juceb="http://200.187.18.147";
	private WebDriver driver;
	public PaginaParametros(WebDriver driver) {
		this.driver = driver;
		//super(driver);
	}
 public WebDriver getDriver() {
	 return driver;
 }
	public String obterValorParametro(String id) {
		return getDriver().findElement(By.xpath(id)).getText();
	}

	public void confirmarParametros() {
		getDriver().findElement(By.id("_ctl0_HyperLinkSair")).click();
	}

	public void closeAlert() {
		if(getDriver().getCurrentUrl().contains(juceb)) {
		WebElement btnClsFrstMsgLogin = getDriver().findElement(By.id("_ctl0_MainContent_Button1"));
		btnClsFrstMsgLogin.click();
		}
		else {
			//nothing
		}
	}
}
