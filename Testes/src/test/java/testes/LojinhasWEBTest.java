package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LojinhasWEBTest {


    private WebDriver browser;
    @Before
    public void setUp(){
        //set up
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver");
        browser = new ChromeDriver();
        browser.get("http://165.227.93.41/lojinha-web");

        //Login on page (user + pwd)
        browser.findElement(By.cssSelector("#usuario")).sendKeys("admin"); // procura elemento dento do navegador
        browser.findElement(By.id("senha")).sendKeys("admin");
        browser.findElement(By.cssSelector(".btn")).click();
    }
    @Test
    public void testValidarDadosDeUmProduto(){

        //Access product PS4
        browser.findElements(By.linkText("PS4")).get(0).click();

        //Validation Prodcut name and first component
        String produtonome = browser.findElement(By.cssSelector("#produtonome")).getAttribute("value");
        Assert.assertEquals("PS4", produtonome);
        String componentenome = browser.findElements(By.cssSelector(".title")).get(0).getText();
        Assert.assertEquals("Lojinha controle", componentenome);


    }

    @Test
    public void testAdicionarUmNovoProduto(){

        // Click on button to Add a  newproduct
        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        // Fill up data of product
        browser.findElement(By.id("produtonome")).sendKeys("PS10");
        browser.findElement(By.id("produtovalor")).sendKeys("35000");
        browser.findElement(By.id("produtocores")).sendKeys("Azul, Verde");
        browser.findElements(By.cssSelector(".btn")).get(0).click();
        // Validate Added product message
        String messageProductAdded = browser.findElement(By.cssSelector(".toast")).getText();
        Assert.assertEquals("Produto adicionado com sucesso", messageProductAdded);

    }

    @After
    public void tearDOwn(){
        //Close browser
        browser.quit();
    }
}
