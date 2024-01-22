package com.example.projeto1.Observer;

import com.example.projeto1.model.Pedido;

public class Observador implements Observer{

    @Override
    public void informarPedido(Pedido novoPedido) {
        System.out.println("Novo pedido realizado: "+ novoPedido.getPedido()+ "para a mesa: "+novoPedido.getMesa());
    }
    
}
