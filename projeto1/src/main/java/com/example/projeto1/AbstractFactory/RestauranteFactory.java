package com.example.projeto1.AbstractFactory;

import org.springframework.stereotype.Component;

import com.example.projeto1.model.Mesa;
import com.example.projeto1.model.Pedido;

@Component
public class RestauranteFactory implements AbstractFactory{

    @Override
    public Mesa createMesa(int numero) {
        return new Mesa(numero);
    }

    @Override
    public Pedido createPedido(int mesa, String descricao) {
        return new Pedido(mesa, descricao);
    }
    
}
