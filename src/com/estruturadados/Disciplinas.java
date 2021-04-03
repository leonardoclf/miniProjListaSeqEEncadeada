package com.estruturadados;

import java.util.Scanner;

public class Disciplinas {

    private class No {
        private String nomeDisciplina;
        private int nota;
        private No proximo;

        public No (String nomeDisciplina, int nota) {
            this.nomeDisciplina = nomeDisciplina;
            this.nota = nota;
        }
    }

    private No primeiro;
    private No ultimo;
    private int tamanho = 1;

    // add no fim da lista
    public void addDisciplina(String nomeDisciplina, int nota) {
        No novoNo = new No(nomeDisciplina, nota);
        if (primeiro == null) {
            primeiro = ultimo = novoNo;
        }
        else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
            tamanho++;
        }
    }

    // exibir todas disciplinas
    public void exibirDisciplinas() {
        No atual = primeiro;
        while( atual != null ) {
            System.out.println("\nNome da disciplina: " + atual.nomeDisciplina);
            System.out.println("Nota: " + atual.nota + "\n");
            atual = atual.proximo;
        }
    }
    // metodo feito para criar uma lista disciplina com input do usuário
    public static Disciplinas criarDisciplinas() {
        boolean on = true;
        Disciplinas novaLista = new Disciplinas();
        Scanner leitorDisciplina = new Scanner(System.in);
        String escolha;
        String nota;
        String nomeDisciplina;

        while(on) {
            System.out.println("""
                    Digite
                    1 - Incluir nova disciplina 
                    2 - Finalizar inclusão de disciplinas 
                    """);
            escolha = leitorDisciplina.nextLine();

            switch (Integer.parseInt(escolha)) {
                case 1:
                    System.out.println("Digite o nome da disciplina");
                    nomeDisciplina = leitorDisciplina.nextLine();
                    System.out.println("Digite a nota");
                    nota = leitorDisciplina.nextLine();
                    novaLista.addDisciplina(nomeDisciplina, Integer.parseInt(nota));
                    break;
                case 2:
                    System.out.println("Finalizada adição de novas disciplinas");
                    on = false;
                default:
                    System.out.println("Escolha invalida");
            }
        }
        return novaLista;
    }
}
