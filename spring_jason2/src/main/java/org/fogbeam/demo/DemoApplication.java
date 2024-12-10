package org.fogbeam.demo;

import java.rmi.RemoteException;

import org.fogbeam.demo.spring.RunSpringMAS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jason.infra.local.LocalRuntimeServices;
import jason.runtime.RuntimeServicesFactory;

@SpringBootApplication
@ComponentScan(basePackages = "org.fogbeam")
@Configuration
public class DemoApplication implements CommandLineRunner
{
	
	@Autowired
	private ApplicationContext appContext;		
	
	
	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args );
	}

	@Override
	public void run( String... args ) throws Exception
	{
		System.out.println( "Demo Application" );
		
		// /MyAgentArch agent = new MyAgentArch();
		RunSpringMAS runMAS = new RunSpringMAS();

		appContext.getAutowireCapableBeanFactory().autowireBeanProperties( runMAS,
			    AutowireCapableBeanFactory.AUTOWIRE_NO, false);
        		
		runMAS.init(args);
		runMAS.registerMBean();
		runMAS.registerInRMI();
		runMAS.registerWebMindInspector();
		runMAS.create();
		runMAS.start();
		runMAS.waitEnd();
		runMAS.finish(0, true, 0);
		
		
		System.out.println("\n*******************************************\n\ndone");        
	}
	
}
