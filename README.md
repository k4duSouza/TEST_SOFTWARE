# TEST_SOFTWARE � Smoke Test (Selenium) + Load Test (JMeter)

## Estrutura
- TEST/ ? projeto Maven com Selenium (Smoke Test)
- TEST_SOFTWARE.jmx ? plano do JMeter (Load Test)
- *.zip ? bin�rios (JMeter/Chromedriver) � opcionais

## Requisitos
- Java 11+ e Maven
- Chrome instalado

## Como rodar o Smoke Test (Selenium)
1. Abra a pasta TEST na sua IDE (IntelliJ, VS Code + Extens�es, etc).
2. Execute a classe src/test/java/base/BaseTest.java.
3. O teste abre https://the-internet.herokuapp.com, navega para **Frames** e valida a URL.

## Como rodar o Load Test (JMeter)
1. Abra o Apache JMeter.
2. Carregue TEST_SOFTWARE.jmx.
3. D� **Start** (?). Veja m�tricas no **Summary Report** (Average, Error %, Throughput).
4. CLI opcional:
   jmeter -n -t TEST_SOFTWARE.jmx -l results.jtl -e -o report

## Observa��es
- Smoke Test valida rapidamente se o sistema est� "de p�" ap�s o deploy.
- Load Test mede desempenho sob carga (usu�rios simult�neos).
