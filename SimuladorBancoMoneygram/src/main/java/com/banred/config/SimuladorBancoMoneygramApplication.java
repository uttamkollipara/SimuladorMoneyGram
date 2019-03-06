package com.banred.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * The Class SimuladorCardmarteApplication.
 */
@ComponentScan({"com.banred","org.tempuri"})
@SpringBootApplication
@AutoConfigurationPackage
public class SimuladorBancoMoneygramApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SimuladorBancoMoneygramApplication.class, args);
	}
}
