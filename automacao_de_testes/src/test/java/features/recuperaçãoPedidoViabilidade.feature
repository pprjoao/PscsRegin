# language: pt
@tag
Funcionalidade: Viabilidade
 

      
 Contexto: possibilidade de acessar o sistema
Dado que usuário possa acessar a tela de login do sistema

Esquema do Cenário: realizar login no sistema com usuários válidos
Quando informar um <Usuario> válido
E inserir uma <Senha> válida
Então o sistema deve permitir a autenticação do usuário
E exibir a mensagem <mensagem> de boas vindas ao usuário deve ser exibido

Exemplos:
| Usuario | Senha  | Mensagem       |
| "jorge" | "0001" | "Bem Vindo"    |
| "sonia" | "0004" | "bem Vindo"    |
| "jose"  | "0006" | "Bem Vindo"    |
