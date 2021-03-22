# language: pt

@RealizarLogin
Funcionalidade: RealizarLogin
Para validar a autenticacao no sistema de Regin Universal
Como usuario valido do sistema
Eu quero logar e validar a mensagem de boas vindas.


#Cenario: realizar login no sistema Regin com usuario e senha validos
#Dado que usuario possa acessar a tela de login do sistema "http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx" 
#Quando informar um usuario "76100065304"  e senha "031090" valida 
#Entao o sistema deve permitir a autenticacao do usuario
#E a mensagem de "Bem Vindo(a), JOAO MARCELO P PROSA !" do usuario deve ser exibido

Esquema do Cenario: realizar login no sistema Regin com usuario e senha validos
Dado que usuario possa acessar a tela de login do sistema "http://200.187.18.147/requerimentoUniversal/NovoLogin.aspx" 
Quando informar um usuario <userName>  e senha <userPassword> valida 
Entao o sistema deve permitir a autenticacao do usuario
E a mensagem de <wellcomeMessage> do usuario deve ser exibido

Exemplos:
|						userName							| 		userPassword		| 					wellcomeMessage							|
|					"76100065304"						|				"031090"			|	"Bem Vindo(a), JOAO MARCELO P PROSA !"|

