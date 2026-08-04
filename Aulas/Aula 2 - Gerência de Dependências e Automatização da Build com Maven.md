- Requeriment.txt = Gerenciamento de dependência
- Dependência = algo fora do código sendo chamado nele (é um código externo, como uma biblioteca, pacote ou framework, que o seu sistema precisa para funcionar)
- Build/empacotamento do projeto = Executável do projeto para o usuário usar
	- Mas o software tem dependencias, o software precisa delas. Elas também serão "buildadas"
- Pacote para instalação em Java = Jar (Java ARchive)
- Empacotar um software envolve transformá-lo em um arquivo executável, mas vai além disso. O processo reúne o código-fonte, as dependências, as bibliotecas e os recursos visuais em um formato coeso e pronto para distribuição, facilitando a instalação ou a execução direta do programa em outras máquinas
- .APK código buildado para executar no Android
### Automatizar o empacotamento
- Automatizar build
- Depende da tecnologia 
- Java usa Maven, JS usa node JS, Android Gradle,etc
- Intellij tem o maven
- Gerenciar dependências e fazer a build
- Para achar dependências [clique aqui](https://mvnrepository.com/) (é onde se encontram as bibliotecas, frameworks, ferramentas e qualquer outro software que desejamos utilizar em nossas próprias soluções)
- GSON: Biblioteca capaz de converter instâncias Java para objetos JSON
- Tem que ter um arquivo chamado `pom.xml`
	- Nesse arquivo fica tudo que precisamos que o Maven cuide para a build automatizada do nosso projeto. Inclusive a gerência das dependências
	- groupId -> Identificação da empresa, ou grupo de projetos. Segue a convenção para nomear pacotes em Java 
	- artifactId -> Identificação do projeto 
	- version -> Versão do projeto
	- As dependencias vão ficar em: 
	![[Captura de Tela 2026-08-04 às 18.18.56.png]]
	- Instruções da build fica em:
	![[Captura de Tela 2026-08-04 às 18.19.43.png]]
	- Exemplo:
	```xml
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>br.inatel.cdg</groupId>
  <artifactId>aula1-maven</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>Aula 1 - Maven</name>
  <description>Criando uma aplicaçao com Maven para converter instâncias em JSON</description>

  <dependencies>
	  <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
	  <dependency>
		  <groupId>com.google.code.gson</groupId>
		  <artifactId>gson</artifactId>
		  <version>2.9.0</version>
	  </dependency>

  </dependencies>

  <build>
  	<plugins>
  		<plugin>
  			<artifactId>maven-compiler-plugin</artifactId>
  			<version>3.8.1</version>
  			<configuration>
  				<source>1.8</source>
				<target>1.8</target>  			
  			</configuration>
  		</plugin>
  		<plugin>
			<artifactId>maven-assembly-plugin</artifactId>
			<version>3.3.0</version> 
			<configuration>
				<archive>
					<manifest>
						<mainClass>br.inatel.cdg.Main</mainClass>
					</manifest>
				</archive>
				<finalName>aula-1-maven</finalName>
				<appendAssemblyId>false</appendAssemblyId>
				<descriptorRefs>
					<descriptorRef>jar-with-dependencies</descriptorRef>
				</descriptorRefs>
			</configuration>			
  			<executions>
  				<execution>
  					<phase>package</phase>
  					<goals>
  						<goal>single</goal>
  					</goals>
  				</execution>
  			</executions>
  		</plugin>
  	</plugins>
  </build>

</project>
	```
	- Quando executa o projeto aparece External libraries: Onde ficam todas as dependências externas
	- Observe que o XML que colocamos não é a biblioteca GSON propriamente dita. O que ele representa são instruções para o Maven, de fato, fazer o download da biblioteca para nós (Conceito de gerenciamento de dependências)
### Build
- Comando mvn package:
	- Compilar o projeto 
	- Executar os testes de unidade (que estiverem em src/main/test) 
	- Gerar o jar (e colocar no diretório target, mas não será um executável)
	- O comando deve ser executado na raiz
	- Cria o jar na pasta target
- Separar testes, eles não tem que ir pro cliente, ele ocupa espaço (não é empacotado junto)
