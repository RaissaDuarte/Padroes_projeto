package com.example.projeto1.command;

import java.util.List;

import com.example.projeto1.model.Mesa;
import com.example.projeto1.model.Pedido;
import com.example.projeto1.singleton.SistemaRestaurante;

public class ComandoEncerrarExpediente implements InterfaceCommand{

    private SistemaRestaurante sistemaRestaurante;
    private List<Mesa> limesas;
    private List<Pedido> lipedidos;

    public ComandoEncerrarExpediente(SistemaRestaurante sistemaRestaurante, List<Mesa> m, List<Pedido> p){
        this.sistemaRestaurante = sistemaRestaurante;
        this.limesas = m;
        this.lipedidos = p;
    }


    @Override
    public void executar() {
        sistemaRestaurante.encerrarExpediente(limesas, lipedidos);
    }
    
}
