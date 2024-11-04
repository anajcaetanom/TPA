package org.example;

import com.github.javafaker.Faker;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();

        String arquivo = "alunos.bin";
        int qtdAlunos = random.nextInt(100) + 1;

        try (DataOutputStream out = new DataOutputStream (
                new FileOutputStream(arquivo)))
        {
            for (int i = 0; i < qtdAlunos; i++) {
                Aluno aluno = new Aluno(faker.name().fullName());
                aluno.setMatricula(faker.idNumber().valid());
                aluno.setNota(random.nextInt(101));
                aluno.setFrequencia(random.nextInt(101));

                out.writeUTF(aluno.getNome());
                out.writeUTF(aluno.getMatricula());
                out.writeUTF(Integer.toString(aluno.getNota()));
                out.writeUTF(Integer.toString(aluno.getFrequencia()));
            }

            System.out.println("Total de alunos: " + qtdAlunos);
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}