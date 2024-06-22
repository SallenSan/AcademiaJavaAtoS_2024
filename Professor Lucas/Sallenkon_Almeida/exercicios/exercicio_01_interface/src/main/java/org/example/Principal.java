package org.example;

import org.example.interfaces.Mensagem;

public class Principal extends Mensagem {
    private static final String MENSAGEM_A = "Cuide bem dos animais";

    @Override
    public void exibeMensagemA() {
        System.out.println(MENSAGEM_A);

    }

    @Override
    public void exibeMensagemB(String mensagemB) {
        System.out.println(mensagemB);

    }
}
