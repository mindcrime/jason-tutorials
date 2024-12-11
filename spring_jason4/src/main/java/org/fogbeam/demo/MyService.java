package org.fogbeam.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class MyService
{
	public String getData()
	{
		return "Some Random Data";
	}
	
	public String getErrorMessage()
	{
		return "Yo, that don't work, dawg!";
	}
	
	public String getRandomData( int len )
	{
		return RandomStringUtils.randomAlphanumeric( len );
	}
}
