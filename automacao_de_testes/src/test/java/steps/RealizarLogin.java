package steps;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObject.PaginaBase;
import pageObject.PaginaInicial;
import pageObject.PaginaLogin;
import pageObject.PaginaParametros;

public class RealizarLogin {

	protected PaginaBase paginaBase;
	// = new PaginaBase(getDriver());
	protected PaginaLogin paginaLogin;
	protected PaginaInicial paginaInicial;
	protected PaginaParametros paginaParametros;
	protected String AtualPage=""; 

	
	public RealizarLogin() {
		
		paginaBase = PaginaBase.getInstance();
			// TODO Auto-generated constructor stub	
	}
	
	@Dado("^que usuario possa acessar a tela de login do sistema \"([^\"]*)\"$")
	public void que_usuario_possa_acessar_a_tela_de_login_do_sistema(String url) {
		System.out.println("//--"+url);
		try {
		this.paginaBase=  PaginaBase.getInstance();
		this.paginaLogin = new PaginaLogin(paginaBase.getDriver());	   
		this.paginaBase.navegateTo(url);
		this.paginaLogin.validaURL(url);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Quando("^informar um usuario \"([^\"]*)\"  e senha \"([^\"]*)\" valida$")
	public void informar_um_usuario_e_senha_valida(String userName, String userPassword) throws Throwable {
		this.paginaInicial = paginaLogin.logar(userName, userPassword);
	}
	
	@Entao("^o sistema deve permitir a autenticacao do usuario$")
	public void o_sistema_deve_permitir_a_autentica_o_do_usuario() throws Throwable {
		this.paginaParametros = paginaInicial.acessaPaginaDeParametros();
	}
	
	@Entao("^a mensagem de \"([^\"]*)\" do usuario deve ser exibido$")
	public void a_messagem_de_do_usuario_deve_ser_exibido(String wellcomeMessage) throws Throwable {
		try {
			
		Assert.assertEquals(wellcomeMessage, this.paginaParametros.obterValorParametro("//*[@id='_ctl0_labelNome']"));
		
		} catch (Exception e) {
			paginaBase.closeAlertErro();	
		}
		
		}
	
}