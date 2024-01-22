package com.example.projeto1.AbstractFactory;

import com.example.projeto1.model.Mesa;
import com.example.projeto1.model.Pedido;

public interface AbstractFactory {
    Mesa createMesa(int numero);
    Pedido createPedido(int mesa, String descricao);
}
