# language: pt
@tag
Funcionalidade: Nome empresarial, ObjetoSocialCnae
   A fim validar as informações sobre do pedido de viabilidade de empresa 
   E "nome empresarial","Objeto social" e "cnae"
   Como usuário logado no na plataforma e realizando Pedido de Viabilidade "matriz"
   Eu Validar o "nome", "objeto social" e "CNAE"
  
  Contexto: Dado eu estou logado no Regin
    E quero realizar um Pedido de Viabilidade de Matriz no Estado
    E quero que seja avaliada pela Junta comercial do Estado
    
    Cenario: Solicitacao do Nome,Objeto e Cnae
    Quando eu solicito envio Nome empresarial
    E envio Objeto
    E envio Cnae
    Entao valido o Cnae com o Objeto
    E valido o Nome empresarial

 # Esquema do Cenario: Solicitar Pedido Viabilidade de uma Matriz
  #  Dado eu estou logado no regin requerimentoUniversal <url>
   # Quando eu entro com <cpf> e senha <pwd>
    #Entao sistema deve logar e exibir mensagem <status> "Boas Vindas"

    #Exemplos: 
     # |                              url                              |     cpf       |     pwd      |     status  |
     # |http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx     |   14397569703 |     031090   |  success    |
     # |http://200.187.18.147/requerimentoUniversal/Principal.aspx     |   76100012344 |     031090   |    Fail     |