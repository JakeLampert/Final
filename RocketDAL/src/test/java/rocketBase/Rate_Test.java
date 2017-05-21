package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

@Test
public void test_excep() throws Exception {
	int size = RateDAL.getAllRates().size();
	assertTrue(size > 0);
	if (size <= 0){
		throw new Exception();
	}
}
}
