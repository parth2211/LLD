package com.lldprojects.splitwise;

import com.lldprojects.splitwise.commands.RegisterUserCommand;
import com.lldprojects.splitwise.commands.UpdateUserCommand;
import com.lldprojects.splitwise.commands.registry.CommandRegistryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    @Autowired
    CommandRegistryImpl commandRegistry;

    @Autowired
    RegisterUserCommand registerUserCommand;

    @Autowired
    UpdateUserCommand updateUserCommand;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        commandRegistry.addCommand(registerUserCommand);
        commandRegistry.addCommand(updateUserCommand);

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your new input");
            String command = sc.nextLine();

            commandRegistry.execCommand(command);
        }
    }
}
