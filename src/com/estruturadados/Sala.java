package com.estruturadados;

import java.util.Scanner;

public class Sala {

    private int alunoContador;
    public Aluno[] alunos;

    public Sala() {
        alunos = new Aluno[60];
        alunoContador = 0;
    }

    public int addAluno() {

        if (alunoContador == 60) {
            System.out.println("Sala cheia");
            return -1;
        }

        Scanner leitorAluno = new Scanner(System.in);
        int novoRGM;
        Disciplinas novaLista;

        System.out.println("Digite o rgm em ordem crescente da sala");
        novoRGM = leitorAluno.nextInt();

        novaLista = Disciplinas.criarDisciplinas();

        //add no array
        Aluno novoAluno = new Aluno(novoRGM, novaLista);
        alunos[alunoContador++] = novoAluno;
        return 1;
    }

    public int removerAluno(int rgm) {

        if (alunoContador == 0) {
            System.out.println("Lista vazia");
            return -1;
        }

        int index;
        boolean deletou = false;

        if (alunos[alunoContador - 1].getRgm() == rgm) {
            deletou = true;
            alunoContador--;
        } else {
            index = buscarAluno(rgm);
            if (index > -1) {
                for (int i = index; i < alunoContador; i++) {
                    alunos[i] = alunos[++i];
                }
                alunoContador--;
                deletou = true;
            }
        }
        if (deletou) {
            exibirAlunos();
        } else {
            System.out.println("não existe esse rgm");
        }
        return 1;
    }

    public int buscarAluno(int rgm) {
        int inicioBusca = 0;
        int fimBusca = alunoContador;
        while (inicioBusca <= fimBusca) {
            int meio = inicioBusca + (fimBusca - inicioBusca) / 2;

            if (alunos[meio].getRgm() == rgm) {
                exibirAluno(meio);
                return meio;
            }

            if (alunos[meio].getRgm() < rgm) {
                inicioBusca = meio + 1;
            } else
                fimBusca = meio - 1;

        }
        System.out.println("Nao existe");
        return -1;
    }

    public void exibirAlunos() {
        for (int i = 0; i < alunoContador; i++) {
            System.out.println("--------");
            System.out.println("Aluno " + (i + 1));
            System.out.println("RGM: " + alunos[i].getRgm());
            alunos[i].getDisciplinasCadastradas().exibirDisciplinas();
            System.out.println("--------");
        }
    }

    private void exibirAluno(int index) {
        System.out.println("--------");
        System.out.println("Existe aluno!");
        System.out.println("RGM: " + alunos[index].getRgm());
        alunos[index].getDisciplinasCadastradas().exibirDisciplinas();
        System.out.println("--------");
    }

    public void montarSala() {
        boolean app = true;
        String rgmProcurado;
        Scanner leitorEscolha = new Scanner(System.in);

        while (app) {
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
            String escolha = leitorEscolha.nextLine();
            switch (Integer.parseInt(escolha)) {
                case 1:
                    addAluno();
                    break;
                case 2:
                    exibirAlunos();
                    break;
                case 3:
                    System.out.println("Digite o rgm do aluno");
                    rgmProcurado = leitorEscolha.nextLine();
                    buscarAluno(Integer.parseInt(rgmProcurado));
                    break;
                case 4:
                    System.out.println("Digite o rgm do aluno");
                    rgmProcurado = leitorEscolha.nextLine();
                    removerAluno(Integer.parseInt(rgmProcurado));
                    break;
                case 5:
                    System.out.println("Fim do programa");
                    app = false;
                    break;
                default:
                    System.out.println("Opção invalida\n");
            }
        }
    }
}
