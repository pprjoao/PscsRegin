# language: pt
@tag
Funcionalidade: Entrada de dados do Solicitante
  Realizar a Viabilidade de primeiro estabelecimento(Matriz ou Filial)

Contexto: Dado eu estou logado no regin
    E quero realizar um "Pedido de Viabilidade de Matriz" no estado da Bahia
    E quero que seja avaliada pela "Junta comercial do Estado da Bahia"
    
  @tag1
  Cenario: Inserir dados do Solicitante
    Quando eu solicito envio "Dados do Solicitante" 
    E envio "ObjetoSocial"
    E envio "Informacoes complementares"
    Entao valido as informacoes
    
    @tag2
    Cenario: Solicitacao do Nome,Objeto e Cnae
    Quando eu solicito envio Nome empresarial
    E envio "Objeto"
    E envio Cnae
    Entao valido o Cnae com o Objeto
    E valido o Nome empresarial
    
    @tag3
    Cenario: Inserir Informacoes complementares
    Quando Aceito os termos
    E envio o Pedido de Viabilidade
    Entao valido o numero do protocolo do pedido
    E valido o relatorio de pedido gerado

