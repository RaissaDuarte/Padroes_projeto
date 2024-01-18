package com.example.projeto1.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.projeto1.model.Mesa;
import com.example.projeto1.model.Pedido;
import com.example.projeto1.singleton.SistemaRestaurante;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class MesaControler {
    
    private final SistemaRestaurante sistemaRestaurante;
    private List<Mesa> listmesas = new ArrayList<>();

    @Autowired
    private PedidoController pedidoController;


    public MesaControler(SistemaRestaurante sistemaRestaurante, List<Mesa> mesas, PedidoController pedidoController) {
        this.sistemaRestaurante = sistemaRestaurante;
        this.listmesas = mesas;
        this.pedidoController = pedidoController;
    }

@GetMapping("/home")
public String TelaMesas(Model model) {
    model.addAttribute("mesas", listmesas);
        return "TelaMesas";
}

@PostMapping("/createTable")
    public String createTable(@RequestParam int numero) {
        Mesa newMesa = new Mesa(numero);
        listmesas.add(newMesa);
        return "redirect:/home";
    }

    @GetMapping("/toggleTableStatus/{numero}")
    public String toggleTableStatus(@PathVariable int numero, Model model) {
        for (Mesa mesa : listmesas) {
            if (mesa.getNumero() == numero) {
                mesa.setDisponibilidade(!mesa.disponibilidade());
                break;
            }
        }
        model.addAttribute("mesas", listmesas);
        return "redirect:/home";
    }

    public List<Mesa> getTodasMesas(){
        return listmesas;
    }

    // @PostMapping("/adicionarPedido")
    // public String adicionarPedido(@ModelAttribute Pedido pedido) {
    //     int numeroMesa = pedido.getMesa();

    //     for (Mesa mesa : listmesas) {
    //         if (mesa.getNumero() == numeroMesa) {
    //             mesa.addPedido(pedido);
    //             break;
    //         }
    //     }

    //     return "redirect:/home";
    // }

}