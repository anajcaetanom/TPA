package org.example;

import org.example.cms.GeradorDeArquivosDeClientes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String nomeArquivo = "clientes";

        int quantidadeClientes = 2000000;

        // Instanciando o gerador
        GeradorDeArquivosDeClientes gerador = new GeradorDeArquivosDeClientes();

        // Gerar um grande dataset de clientes
        gerador.geraGrandeDataSetDeClientes(nomeArquivo, quantidadeClientes);
    }
}