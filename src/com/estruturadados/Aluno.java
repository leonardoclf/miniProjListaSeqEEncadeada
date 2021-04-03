package com.estruturadados;

public class Aluno {

    private int rgm;
    private Disciplinas disciplinasCadastradas;

    public Aluno(int rgm, Disciplinas disciplinasCadastradas) {
        this.rgm = rgm;
        this.disciplinasCadastradas = disciplinasCadastradas;
    }

    public int getRgm() {
        return rgm;
    }

    public Disciplinas getDisciplinasCadastradas() {
        return disciplinasCadastradas;
    }

}
