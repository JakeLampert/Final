package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for(RateDomainModel rdm : rates){
			if(rdm.getiMinCreditScore() <= GivenCreditScore)
				dInterestRate = rdm.getdInterestRate();
			else
				break;
		}
		if (dInterestRate == 0)
			throw new RateException();
		return dInterestRate;
		
		
	}

	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
