# language: pt
@tag
Funcionalidade: Pedido de viabilidade primeiro estabelecimento
  Realizar a Viabilidade de primeiro estabelecimentoMatriz

  @tag1
  Cenario: Viabilidade de Matriz na junta
    Dado eu estou logado no regin da Bahia
    E quero realizar um Pedido de Viabilidade no municipio de "ALAGOINHAS"
    E quero que seja hologada pela "Junta Comercial do Estado da Bahia" 
    Quando Seleciono a op��o "Inscri��o de primeiro estabelecimento (Matriz)"
    E clico sobre o bot�o Avan�ar
    Entao vejo o evento Inscri��o de primeiro estabelecimento
    E vejo as campos para preechimento dos dados do Solicitante e Pessoa Juridica, Endere�o da pessoa Juridica
    E valido se as guias dados do Solicitante e Pessoa Juridica, QSA, empresarial, Objeto Social, Cnae e informa��es complementares 
