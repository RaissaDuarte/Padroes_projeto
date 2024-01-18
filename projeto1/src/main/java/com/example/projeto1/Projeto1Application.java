package com.example.projeto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Projeto1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);

	// //singleton
	// //garante que seja criada somente uma instancia do sistema do restaurante
	// //colocando a anotacao componente, e injetando aqui
		
    //     RestaurantSystem restaurantSystem = new RestaurantSystem();

	// 	Table m1 = new Table(1);
	// 	restaurantSystem.addTable(m1);

	// 	Order p1 = new Order(m1, "Pizza media, sabor chocolate");
	// 	restaurantSystem.addOrder(p1);

	

	}

}
