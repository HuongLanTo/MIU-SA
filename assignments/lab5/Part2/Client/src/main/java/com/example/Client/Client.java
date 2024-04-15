package com.example.Client;

import com.example.Client.cart.service.dto.CartDTO;
import com.example.Client.cart.service.dto.ProductDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Client implements CommandLineRunner {
	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String productUrl = "http://localhost:8080/products";
		String cartUrl = "http://localhost:8080/carts";
		try {
			// add Product1
			restTemplate.postForLocation(productUrl, new ProductDTO(1L, "Tape", 12.0));
			// add Product2
			restTemplate.postForLocation(productUrl, new ProductDTO(2L, "Chair", 11.0));

			ProductDTO productDTO1 = restTemplate.getForObject(productUrl + "/{productNumber}", ProductDTO.class, 1L);
			ProductDTO productDTO2 = restTemplate.getForObject(productUrl + "/{productNumber}", ProductDTO.class, 2L);
			System.out.println("---------------- GET PRODUCT1 & PRODUCT2 ------------------------");
			System.out.println(productDTO1);
			System.out.println(productDTO2);
			System.out.println("-----------------------------------------------------------------");


			// add to cart 1
			restTemplate.postForLocation(cartUrl + "/{cartId}/{productNumber}/{quantity}", null, 1L, 1L, 10);
			CartDTO cartDTO = restTemplate.getForObject(cartUrl + "/{cartId}", CartDTO.class, 1L);
			System.out.println("-------------------------- CART ---------------------------------");
			cartDTO.print();
			System.out.println("-----------------------------------------------------------------");

			// increase quantity of product1 in cart
			restTemplate.postForLocation(cartUrl + "/{cartId}/{productNumber}/{quantity}", null, 1L, 1L, 20);
			cartDTO = restTemplate.getForObject(cartUrl + "/{cartId}", CartDTO.class, 1L);
			System.out.println("-------------------------- CART ---------------------------------");
			cartDTO.print();
			System.out.println("-----------------------------------------------------------------");

			// add product not existed to cart1 => Print to the console the problem
//			restTemplate.postForLocation(cartUrl + "/{cartId}/{productNumber}/{quantity}", null, 1L, 3L, 10);
//			cartDTO = restTemplate.getForObject(cartUrl + "/{cartId}", CartDTO.class, 1L);
//			System.out.println("-------------------------- CART ---------------------------------");
//			cartDTO.print();
//			System.out.println("-----------------------------------------------------------------");

			// change product1 price
			restTemplate.postForLocation(productUrl, new ProductDTO(1L, "Tape", 16.0));
			productDTO1 = restTemplate.getForObject(productUrl + "/{productNumber}", ProductDTO.class, 1L);
			System.out.println("----------------------- GET PRODUCT1 ----------------------------");
			System.out.println(productDTO1);
			System.out.println("-----------------------------------------------------------------");

			cartDTO = restTemplate.getForObject(cartUrl + "/{cartId}", CartDTO.class, 1L);
			System.out.println("-------------------------- CART ---------------------------------");
			cartDTO.print();
			System.out.println("-----------------------------------------------------------------");
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
