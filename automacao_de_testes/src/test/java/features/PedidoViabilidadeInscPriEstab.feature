# language: pt
@tag
Funcionalidade: Consulta - Pedido de Viabilidade Primeiro Estabelecimento
  Realizar a Viabilidade de primeiro estabelecimentoMatriz

  @tag1
  Cenario: Viabilidade de Matriz na junta
    Dado eu estou logado no regin
    E quero realizar um Pedido de Viabilidade de Matriz no Estado da "Bahia"
    E quero que seja avaliada pela instituicao "Junta comercial do Estado da Bahia"
    Quando entro com as informacoes validas 
    Entao verifico se gerou o protocolo
    E valido as informacoes no Relatório
