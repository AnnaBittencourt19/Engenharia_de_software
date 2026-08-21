- Um teste de uma classe que chama várias classes/ tem dependências, tem que usar mock pq se adicionar essas dependências será um teste de integração (sai do escopo)
- Mock: Imitação do que seriam as respostas 
- Objeto mock: instância que imita o real de forma controlada
- Coisas externas também podem podem ter objetos mock
- Fazer código, testar, fazer mock, dependências, etc, etc
- 
![[Captura de Tela 2026-08-18 às 18.03.10.png]]
	- Instância outra classe, esse código foi feito sem pensar em testes
	- Variável gs não está acessível
	- Não tem como acessar ela fora do método
	- INJEÇÃO DE DEPENDÊNCIA: 
		- Construtor (ao instanciar uma classe o construtor é chamado, ao passar um parametro para o construtor conseguimos flexibilizar a classe) (passa o parametro fora do método)(objeto fake e real podem ser usados: flexibilização). Estudar melhor isso
		- Main representa o que o cliente faria no código
		- O código deve estar preparado para o teste
		- Também pode usar setter e método para injetar
- Quando existe um servidor remoto (para teste unitário): Ao incluir a busca no servidor saimos do escopo do teste unitário então:
![[Captura de Tela 2026-08-18 às 18.22.33.png]]
	- Quer testar o buscaInimigo() 
	- Se uma classe está preparada para ser testada (SABER VISUALIZAR QUANDO UMA CLASSE ESTÄ PREPARADA PARA SER TESTADA)
- @Before: Executado antes do teste