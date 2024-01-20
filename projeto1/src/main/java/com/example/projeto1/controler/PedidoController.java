package com.example.projeto1.controler;

import com.example.projeto1.model.Pedido;
import com.example.projeto1.singleton.SistemaRestaurante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class PedidoController {
    
    private final SistemaRestaurante sistemaRestaurante;
    private List<Pedido> listpedidos = new ArrayList<>();


        public PedidoController(SistemaRestaurante sistemaRestaurante) {
        this.sistemaRestaurante = sistemaRestaurante;
    }

    @GetMapping("/pedidos")
    public String telaPedidos(Model model) {
        //model.addAttribute("mesas", mesaControler.getTodasMesas());
        model.addAttribute("pedido", new Pedido(0, "")); 
        model.addAttribute("listpedidos", listpedidos);
        return "TelaPedidos";
    }

    @PostMapping("/adicionarPedido")
    public String adicionarPedido(@ModelAttribute("pedido") Pedido pedido) {
        Pedido newPedido = new Pedido(pedido.getMesa(), pedido.getPedido());
        listpedidos.add(newPedido);
        System.out.println("Pedido realizado: " + newPedido.getPedido());
        System.out.println("lista: " + listpedidos.toString());

        return "redirect:/home";

    }

    public List<Pedido> getPedidos(){
        return listpedidos;
    }

    public void limparPedidos(){
        listpedidos.clear();
        System.out.println("Pedidos reicializados!" + listpedidos);
    }
}
