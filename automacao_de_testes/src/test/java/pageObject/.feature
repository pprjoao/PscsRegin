# language: pt
@tag
Funcionalidade: Viabilidade
  Realizar a Viabilidade de primeiro estabelecimento(Matriz ou Filial)

  @tag1
  Cenario: Viabilidade de Matriz na junta
    Dado eu estou logado no regin
    E quero realizar um "Pedido de Viabilidade de Matriz" no estado da Bahia
    E quero que seja avaliada pela "Junta comercial do Estado da Bahia"
    Quando eu solicito envio "Dados do Solicitante" 
    E envio "ObjetoSocial"
    E envio "Informacoes complementares"
    Entao Eu valido as o Relatório

  @tag2
  Esquema do Cenario: Title of your scenario outline
    Dado I want to write a step with <name>
    Quando I check for the <value> in step
    Entao I verify the <status> in step

    Exemplos: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
