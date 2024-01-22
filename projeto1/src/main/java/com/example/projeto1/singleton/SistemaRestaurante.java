package com.example.projeto1.singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.projeto1.model.Pedido;
import com.example.projeto1.AbstractFactory.AbstractFactory;
import com.example.projeto1.controler.PedidoController;
import com.example.projeto1.model.Mesa;

@Component
public class SistemaRestaurante {
    private Map<Integer, Pedido> orders;
    private Map<Integer, Mesa> tables;
    private AbstractFactory factory;




    // public SistemaRestaurante() {
    //     this.orders = new HashMap<>();
    //     this.tables = new HashMap<>();
    // }

    public SistemaRestaurante(AbstractFactory factory) {
        this.factory = factory;
        this.orders = new HashMap<>();
        this.tables = new HashMap<>();
    }

    public void encerrarExpediente(List<Mesa> me, List<Pedido> pe){
        for(Mesa m: me){
            m.setDisponibilidade(true);
        }
        
        PedidoController pc = new PedidoController(this, factory);
        pc.limparPedidos();
    }

}
