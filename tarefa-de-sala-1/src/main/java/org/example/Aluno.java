package org.example;

public class Aluno {

    public String nome;
    public String matricula;
    public int nota;
    public int frequencia;

    public Aluno(String nome2) {
        this.setNome(nome2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public void printNome(Aluno a) {
        System.out.println("nome do Aluno:"+ a.getNome());
    }
}
