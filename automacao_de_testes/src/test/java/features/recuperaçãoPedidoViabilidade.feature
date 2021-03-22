# language: pt
@tag
Funcionalidade: Viabilidade
 

      
 Contexto: possibilidade de acessar o sistema
Dado que usu�rio possa acessar a tela de login do sistema

Esquema do Cen�rio: realizar login no sistema com usu�rios v�lidos
Quando informar um <Usuario> v�lido
E inserir uma <Senha> v�lida
Ent�o o sistema deve permitir a autentica��o do usu�rio
E exibir a mensagem <mensagem> de boas vindas ao usu�rio deve ser exibido

Exemplos:
| Usuario | Senha  | Mensagem       |
| "jorge" | "0001" | "Bem Vindo"    |
| "sonia" | "0004" | "bem Vindo"    |
| "jose"  | "0006" | "Bem Vindo"    |
