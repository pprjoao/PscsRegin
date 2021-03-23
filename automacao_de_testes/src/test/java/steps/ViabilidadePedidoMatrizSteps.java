package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ViabilidadePedidoMatrizSteps {
	
	@Dado("^eu estou logado no regin da Bahia$")
	public void eu_estou_logado_no_regin_da_Bahia() throws Throwable {
	  System.out.println("Im login on system");
	}

	@E("^quero realizar um Pedido de Viabilidade no municipio de \"([^\"]*)\"$")
	public void quero_realizar_um_Pedido_de_Viabilidade_no_municipio_de(String arg1) throws Throwable {
		System.out.println("im into viability order");
	}

	@E("^quero que seja hologada pela \"([^\"]*)\"$")
	public void quero_que_seja_hologada_pela(String junta) throws Throwable {
		System.out.println("Im login on system "+ junta);
	}

	@Quando("^Seleciono a op??o \"([^\"]*)\"$")
	public void seleciono_a_op_o(String matriz) throws Throwable {
		System.out.println("On system de "+ matriz);
	}

	@E("^clico sobre o bot?o Avan?ar$")
	public void clico_sobre_o_bot_o_Avan_ar() throws Throwable {
		System.out.println("Im here on button");
	}

	@Entao("^vejo o evento Inscri??o de primeiro estabelecimento$")
	public void vejo_o_evento_Inscri_o_de_primeiro_estabelecimento() throws Throwable {
		System.out.println("verify label");
	}

	@E("^vejo as campos para preechimento dos dados do Solicitante e Pessoa Juridica, Endere?o da pessoa Juridica$")
	public void vejo_as_campos_para_preechimento_dos_dados_do_Solicitante_e_Pessoa_Juridica_Endere_o_da_pessoa_Juridica() throws Throwable {
		System.out.println("verify Result");
	}

	@E("^valido se as guias dados do Solicitante e Pessoa Juridica, QSA, empresarial, Objeto Social, Cnae e informa??es complementares$")
	public void valido_se_as_guias_dados_do_Solicitante_e_Pessoa_Juridica_QSA_empresarial_Objeto_Social_Cnae_e_informa_es_complementares() throws Throwable {
		System.out.println("verify result02");
	}
}
