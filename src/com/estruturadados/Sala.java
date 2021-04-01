package com.estruturadados;

import java.util.Scanner;

public class Sala {

    private int alunoContador;
    public Aluno[] alunos;

    public Sala() {
        alunos = new Aluno[60];
    }

    public void addAluno() {}

    public void removerAluno() {}

    public void buscarAluno() {}

    public void exibirAluno() {}

    public void montarSala() {
        boolean app = true;
        Scanner leitorEscolha = new Scanner(System.in);

        while(app) {
            System.out.println("App de gerência de alunos");
            System.out.println("""
                    -- Menu -- 
                    1 - Adicionar novo aluno
                    2 - Mostrar todos os alunos
                    3 - Procurar aluno pelo RGM
                    4 - Remover um aluno pelo RGM
                    5 - Sair do programa
                    -- #### --
                    Escolha: 
                    """);
            int escolha = leitorEscolha.nextInt();
            switch(escolha) {
                case 1:
                    addAluno();
                    break;
                case 2:
                    exibirAluno();
                    break;
                case 3:
                    buscarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    System.out.println("Fim do programa");
                    app = false;
                    break;
                default:
                    System.out.println("Opção invalida\n");

            }
        }
        leitorEscolha.close();
    }

}
