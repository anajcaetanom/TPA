package org.example;

import org.example.cms.ClienteGUI2;
import org.example.cms.GeradorDeArquivosDeClientes;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String menu = """
                1. Gerar novo arquivo de clientes.
                2. Pesquisar cliente.
                
                Insira uma opção:
                """;
        System.out.println(menu);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Digite o nome do arquivo: ");
                String nomeArquivo = scanner.next();

                System.out.println("Digite a quantidade de clientes para gerar: ");
                int qtdClientes = scanner.nextInt();

                // Instanciando o gerador
                GeradorDeArquivosDeClientes gerador = new GeradorDeArquivosDeClientes();

                // Gerar um grande dataset de clientes
                gerador.geraGrandeDataSetDeClientes(nomeArquivo, qtdClientes);

                break;

            case 2:
                SwingUtilities.invokeLater(() -> {
                    ClienteGUI2 gui = new ClienteGUI2();
                    gui.setVisible(true);
                });
        }




    }
}