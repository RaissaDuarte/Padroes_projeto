package com.example.projeto1.command;

public class Invoker {
    private InterfaceCommand comando;

    public void setComando(InterfaceCommand comando) {
        this.comando = comando;
    }

    public void executarComando() {
        if (comando != null) {
            comando.executar();
        }
    }
}
