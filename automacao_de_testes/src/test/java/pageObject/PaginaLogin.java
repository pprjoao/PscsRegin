package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin {
	private WebDriver driver;
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
	}

	String juceb = ".ba.gov.br";
	String AtualPage = "";
	
	public PaginaInicial logar(String userName, String userPassword) {
		realizaLogin(userName, userPassword);
		return new PaginaInicial(getDriver());
	}

	public void validaURL(String url) {

		AtualPage = getDriver().getCurrentUrl();
		if (url.contains(juceb)) {
			getDriver().findElement(By.id("_ctl0_MainContent_Button1")).click();
		} else {
			// nothing
			System.out.println("Não acessou a URL correta da JUCEB - Homolog");
		}
	}
	private WebDriver getDriver() {
		return this.driver;
	}
	private void realizaLogin(String userName, String userPassword) {


		getDriver().findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).clear();
		getDriver().findElement(By.id("_ctl0_MainContent_txtCPFCNPJ")).sendKeys(userName);
		getDriver().findElement(By.id("_ctl0_MainContent_txtSenha")).clear();
		getDriver().findElement(By.id("_ctl0_MainContent_txtSenha")).sendKeys(userPassword);

	}

}
