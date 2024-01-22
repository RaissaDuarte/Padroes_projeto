package com.example.projeto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.projeto1.AbstractFactory.AbstractFactory;
import com.example.projeto1.AbstractFactory.RestauranteFactory;
import com.example.projeto1.Observer.Observador;
import com.example.projeto1.controler.PedidoController;
import com.example.projeto1.singleton.SistemaRestaurante;



@SpringBootApplication
public class Projeto1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
		
		AbstractFactory factory = new RestauranteFactory();
		SistemaRestaurante sistemaRestaurante = new SistemaRestaurante(factory);
		
		PedidoController pedidoController = new PedidoController(sistemaRestaurante, factory);
		Observador observador = new Observador();
        pedidoController.registrarObservador(observador);

	}

}
