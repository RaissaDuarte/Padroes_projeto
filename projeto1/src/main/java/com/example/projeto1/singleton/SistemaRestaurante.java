package com.example.projeto1.singleton;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.projeto1.model.Pedido;
import com.example.projeto1.model.Mesa;

@Component
public class SistemaRestaurante {
    private Map<Integer, Pedido> orders;
    private Map<Integer, Mesa> tables;

    public SistemaRestaurante() {
        this.orders = new HashMap<>();
        this.tables = new HashMap<>();
    }

    public void addOrder(Pedido order) {
        orders.put(order.getId(), order);
        // Lógica para processar o novo pedido
    }

    public void addTable(Mesa table) {
        tables.put(table.getNumero(), table);
        // Lógica para processar a nova mesa
    }

}
