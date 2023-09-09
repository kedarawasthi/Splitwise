package com.splitwise;

import com.splitwise.commands.Command;
import com.splitwise.commands.CommandRegistry;
import com.splitwise.exceptions.InvalidCommandException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("Awaiting user input");
			String input=sc.nextLine();
			Optional<Command> optionalCommand= CommandRegistry.getInstance().get(input);
			if(optionalCommand.isEmpty()){
				System.out.println("Invalid Command, Try again");
				continue;
			}
			Command command=optionalCommand.get();
			try{
				command.validateAndExecute(input);
			}
			catch(InvalidCommandException e){
				System.out.println("Caught Invalid Command Exception " + e.getMessage());
			}
		}
	}
}
