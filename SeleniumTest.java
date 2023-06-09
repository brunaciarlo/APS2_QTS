package aps_2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author marcelo.soares
 */
public class SeleniumTest {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public SeleniumTest() {
    }
    
    @BeforeAll
    public static void setUp() {
         System.setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win32\\chromedriver.exe");
	        
        
         driver = new ChromeDriver();

        driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    
        namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
    @Test
    public void testTituloPaginaLogin(){
    	// arrange
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");      
    	String tituloExperado ="Trabalho 2-1"; 
        
    	// act, assert
    	Assert.assertEquals(tituloExperado, driver.getTitle());
    }
    
    @Test
    public void testNomeValido() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo endereco";
    	campoNome.sendKeys("Pedro");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    	
    }
    
    @Test
    public void testNomeInvalido() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo nome";
    	campoNome.sendKeys("");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    }
    
    @Test
    public void testEnderecoValido() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Selecione um valor para o campo sexo";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    	
    }
    
    @Test
    public void testEnderecoInvalido() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo endereco";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    }
    
    @Test
    public void testSexoValido() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement campoSexo = driver.findElement(By.id("sexo"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo idade, somente com numeros";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	campoSexo.sendKeys("Masculino");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    	
    }
    
    @Test
    public void testSexoInvalido() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement campoSexo = driver.findElement(By.id("sexo"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Selecione um valor para o campo sexo";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	campoSexo.sendKeys("...");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    }
    
    @Test
    public void testIdadeValida() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement campoSexo = driver.findElement(By.id("sexo"));
    	WebElement campoIdade = driver.findElement(By.id("idade"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	campoSexo.sendKeys("Masculino");
    	campoIdade.sendKeys("10");
    	submit.click();
    	
    	Alert alert = driver.switchTo().alert();
    	Assert.assertTrue(alert.getText().equals("Cadastro realizado com sucesso"));
    	alert.accept();
    	
    }
    
    @Test
    public void testIdadeInvalida() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement campoSexo = driver.findElement(By.id("sexo"));
    	WebElement campoIdade = driver.findElement(By.id("idade"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo idade, somente com numeros";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	campoSexo.sendKeys("Masculino");
    	campoIdade.sendKeys("");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    }
    
    @Test
    public void testIdadeNaoNumerica() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement campoSexo = driver.findElement(By.id("sexo"));
    	WebElement campoIdade = driver.findElement(By.id("idade"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo idade, somente com numeros";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	campoSexo.sendKeys("Masculino");
    	campoIdade.sendKeys("Abc");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    }
    
    @Test
    public void testIdadeNegativa() {
    	driver.get("C:\\Users\\fatec.senai\\Downloads\\trabalho2-1.html");
    	WebElement campoNome = driver.findElement(By.id("nome"));
    	WebElement campoEndereco = driver.findElement(By.id("endereco"));
    	WebElement campoSexo = driver.findElement(By.id("sexo"));
    	WebElement campoIdade = driver.findElement(By.id("idade"));
    	WebElement submit = driver.findElement(By.id("botao_somar"));
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	String resultadoEsperado = "Preencha o campo idade com valores acima de 0";
    	campoNome.sendKeys("Pedro");
    	campoEndereco.sendKeys("Av. Assis Brasil");
    	campoSexo.sendKeys("Masculino");
    	campoIdade.sendKeys("-10");
    	submit.click();
    	Assert.assertEquals(resultadoEsperado, resultado.getText());
    }
      
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    
}
