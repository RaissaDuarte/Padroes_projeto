package com.example.projeto1.TemplateMethod;

import com.example.projeto1.model.Pedido;

public abstract class PedidoTemplate {

    public final void realizarPedido(Pedido pedido) {
        fazerPedido(pedido);
        informarPedido(pedido);
        confirmarPedido(pedido);
    }

    protected abstract void fazerPedido(Pedido pedido);

    protected abstract void informarPedido(Pedido pedido);

    protected abstract void confirmarPedido(Pedido pedido);
}
