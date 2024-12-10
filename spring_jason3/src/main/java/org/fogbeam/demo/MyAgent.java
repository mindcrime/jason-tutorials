package org.fogbeam.demo;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jason.asSemantics.Agent;
import jason.asSemantics.Event;

@Component
public class MyAgent extends Agent
{
	@Autowired
	MyService myService;
	
	@Override
	public Event selectEvent( Queue<Event> events )
	{
		System.out.println( "from myService: " + myService.getData());
		
		return super.selectEvent( events );
	}
}
