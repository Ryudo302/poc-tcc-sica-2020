package br.pucminas.tcc.sica.portal;

import java.util.Scanner;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }

    /*
     * Permite que a aplicação seja encerrada corretamente ao pressionar a tecla ENTER no console.
     * 
     * @see https://stackoverflow.com/a/54220104/3228529
     */
    @Bean
    public ApplicationRunner systemExitListener() {
        return args -> {
            if (args.getOptionValues("exitListener") != null) {
                System.out.println("Press Enter to exit application");
                new Scanner(System.in).nextLine();
                System.out.println("Exiting");
                System.exit(0);
            }
        };
    }
}
