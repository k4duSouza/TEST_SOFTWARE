package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TEST_LOG {
    private WebDriver driver;
    private final String EMAIL = "testeaula1@gmail.com";
    private final String SENHA = "teste123";
    private final String NOVO_NOME = "teste1";

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // 1. Acessar a página de login
            driver.get("https://bes.slcardu.com/");

            // Pausa de 3 segundos na tela de login
            System.out.println("Aguardando 3 segundos na tela de login...");
            Thread.sleep(3000);

            // 2. Preencher e-mail
            WebElement emailField = driver.findElement(By.name("text-email"));
            emailField.sendKeys(EMAIL);
            Thread.sleep(1000);

            // 3. Preencher senha
            WebElement senhaField = driver.findElement(By.name("text-password"));
            senhaField.sendKeys(SENHA);
            Thread.sleep(1000);

            // 4. Clicar no botão de login
            WebElement loginBtn = driver.findElement(By.cssSelector("button.botao"));
            loginBtn.click();
            Thread.sleep(1000);

            // Aguardar carregamento da próxima página
            System.out.println("Aguardando carregamento após login...");
            Thread.sleep(3000);

            // 5. Clicar em "Listar Dados"
            System.out.println("Clicando em 'Listar Dados'...");
            WebElement listarDadosBtn = driver.findElement(By.cssSelector("a.btn-listar-dados"));
            listarDadosBtn.click();
            Thread.sleep(1000);

            System.out.println("Aguardando carregamento dos dados...");
            Thread.sleep(2000);

            // 6. Clicar em "Alterar Nome" no header
            System.out.println("Clicando em 'Alterar Nome' no header...");
            WebElement alterarNomeBtn = driver.findElement(By.xpath("//a[contains(@href, 'alterar_nome') or contains(text(), 'Alterar Nome')]"));
            alterarNomeBtn.click();
            Thread.sleep(1000);

            System.out.println("Aguardando carregamento do formulário de alteração...");
            Thread.sleep(1000);

            // 7. Preencher novo nome
            System.out.println("Preenchendo novo nome...");
            WebElement nomeField = driver.findElement(By.name("text-nome-novo"));
            nomeField.clear();
            Thread.sleep(1000);
            nomeField.sendKeys(NOVO_NOME);
            Thread.sleep(1000);

            // 8. Confirmar alteração
            System.out.println("Confirmando alteração...");
            WebElement confirmarBtn = driver.findElement(By.xpath("//button[contains(text(), 'CONFIRMAR ALTERAÇÃO')]"));
            confirmarBtn.click();
            Thread.sleep(1000);

            System.out.println("Aguardando confirmação da alteração...");
            Thread.sleep(1000);


            // 9. Fazer logout para voltar à tela de login
            System.out.println("Fazendo logout...");
            WebElement logoutBtn = driver.findElement(By.cssSelector("a.btn-logout"));
            logoutBtn.click();
            Thread.sleep(3000);

            // Validação final - verificar se voltou para a tela de login
            if (driver.findElements(By.name("text-email")).size() > 0) {
                System.out.println("✅ Smoke Test passou! Fluxo completo executado com sucesso.");
            } else {
                System.out.println("⚠️  Teste executado, mas não retornou à tela de login. URL atual: " + driver.getCurrentUrl());
            }

            // Pausa final antes de fechar
            System.out.println("Aguardando 5 segundos antes de fechar...");
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("❌ Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        new TEST_LOG().setUp();
    }
}