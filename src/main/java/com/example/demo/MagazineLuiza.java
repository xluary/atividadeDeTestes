package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MagazineLuiza extends Page{

    public MagazineLuiza(){
        super();
        driver.get("http:www.magazineluiza.com.br");
        driver.manage().window().minimize();
    }

    public WebElement getCarrinho(){
       return driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[1]/div[2]/header/div/div[2]/a[2]"));
    }

    public WebElement verificacaoCarrinho(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]"));
    }

    public WebElement getQuantidadeItensCarrinho(){
        return driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[1]/div[2]/header/div/div[2]/a[2]/div/button/div[2]"));
    }

    public WebElement getSearchBar(){
        return driver.findElement(By.id("input-search"));
    }

    public void pesquisarPorItem(String nomeDoItem){
        WebElement campoDePesquisa = getSearchBar();
        campoDePesquisa.clear();
        campoDePesquisa.sendKeys(nomeDoItem);
        campoDePesquisa.submit();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public WebElement getTituloProdutos(){
        return driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[4]/div[1]/div/h1"));
    }




}
