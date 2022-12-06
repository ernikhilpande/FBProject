package com.TestScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Acitime.pom.HomePage;
import com.Acitime.pom.LoginPage;
import com.Actitime.GenericLibrary.Baseclass;

@Listeners(com.Actitime.GenericLibrary.ListnerImplementation.class)


public class CustomerCreated extends Baseclass {
	
	@Test
	public void run() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.friends();
	
	}
	

}
