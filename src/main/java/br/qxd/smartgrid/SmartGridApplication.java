package br.qxd.smartgrid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import br.qxd.smartgrid.api.controller.ConsumoController;

@SpringBootApplication
@ComponentScan(value={"br.qxd.smartgrid","br.qxd.smartgrid.service","br.qxd.smartgrid.repository","br.qxd.smartgrid.api.controller"})
public class SmartGridApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartGridApplication.class, args);
	}
}
