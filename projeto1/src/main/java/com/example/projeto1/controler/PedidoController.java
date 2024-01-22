package com.example.projeto1.controler;

import com.example.projeto1.AbstractFactory.AbstractFactory;
import com.example.projeto1.Observer.Observer;
import com.example.projeto1.TemplateMethod.PedidoTemplate;
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
public class PedidoController extends PedidoTemplate{
    
    private final SistemaRestaurante sistemaRestaurante;
    private List<Pedido> listpedidos;
    private AbstractFactory abstractFactory;
    private List<Observer> observadores;


    public PedidoController(SistemaRestaurante sistemaRestaurante, AbstractFactory abstractFactory) {
        this.sistemaRestaurante = sistemaRestaurante;
        this.listpedidos = new ArrayList<>();
        this.abstractFactory = abstractFactory;
        this.observadores = new ArrayList<>();
    }

    @GetMapping("/pedidos")
    public String telaPedidos(Model model) {
        //model.addAttribute("mesas", mesaControler.getTodasMesas());
        model.addAttribute("pedido", new Pedido(0, "")); 
        model.addAttribute("listpedidos", listpedidos);
        return "TelaPedidos";
    }

    @PostMapping("/adicionarPedido")
    public String adicionarPedido(@ModelAttribute("pedido") Pedido tpedido) {
        // Pedido newPedido = abstractFactory.createPedido(pedido.getMesa(), pedido.getPedido());
        realizarPedido(tpedido);

        return "redirect:/home";

    }

    public List<Pedido> getPedidos(){
        return listpedidos;
    }

    public void limparPedidos(){
        listpedidos.clear();
        System.out.println("Pedidos reicializados!" + listpedidos);
    }

    public Pedido clonarPedido(int numeroMesa, String descricaoPedido) {
        Pedido original = abstractFactory.createPedido(numeroMesa, descricaoPedido);
        try {
            return original.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registrarObservador(Observer observador) {
        observadores.add(observador);
    }
    
    @Override
    protected void fazerPedido(Pedido essepedido) {
        int numeroMesa = essepedido.getMesa();
        String descricaoPedido = essepedido.getPedido();
        Pedido newPedido = clonarPedido(numeroMesa, descricaoPedido);
        listpedidos.add(newPedido);
        System.out.println("Pedido realizado: " + newPedido.getPedido());
        System.out.println("lista: " + listpedidos.toString());

    }

    @Override
    protected void informarPedido(Pedido essepedido) {
        for (Observer observador : observadores) {
            observador.informarPedido(essepedido);
        }
    }

    @Override
    protected void confirmarPedido(Pedido essepedido) {
        System.out.println("Pedido confirmado!!");
    }
}
