package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TesteMagazineLuiza {

    public MagazineLuiza magazineLuiza;

    @BeforeEach
    public void init(){
        magazineLuiza = new MagazineLuiza();
        System.setProperty("webdrive.chrome.drive", "C:\\Windows\\chromedriver.exe");
    }

    @Test
    public void testeBuscaProduto_quandoBuscarPorProduto_entaoExibirNomeDoProdutoBuscado(){
       String esperado = "iPhone 14";
       magazineLuiza.pesquisarPorItem(esperado);
       magazineLuiza.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement titulo = magazineLuiza.getTituloProdutos();
       String resultado = titulo.getText();
       assertEquals(esperado, resultado);
     }

    @Test
    public void testeCarrinho_quandoClicarNoIconeDoCarrinho_abrirPaginaCarrinho(){
       WebElement carrinho = magazineLuiza.getCarrinho();
       carrinho.click();
       magazineLuiza.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement tituloCarrinho= magazineLuiza.verificacaoCarrinho();
       String esperado= "Sacola";
       String resultado = tituloCarrinho.getText();
       assertEquals(esperado, resultado);
    }

    @Test
    public void testeCarrinho_quandoSessaoIniciada_carrinhoVazio(){
        WebElement quantidadeItensCarrinho = magazineLuiza.getQuantidadeItensCarrinho();
        String resultado = quantidadeItensCarrinho.getText();
        String esperado = "0";
        assertEquals(esperado, resultado);
    }



}
