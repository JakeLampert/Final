package exceptions;

import java.io.Serializable;

import rocketDomain.RateDomainModel;

public class RateException extends Exception implements Serializable {
	private RateDomainModel rdm;
	private double GivenCreditScore;
	private double GivenIncome;

	
	public double getGivenCreditScore() {
		return GivenCreditScore;
	}
	public double getGivenIncome() {
		return GivenIncome;
	}
	public RateDomainModel getRdm() {
		return rdm;
	}
	public RateException(){
		
	}
	public RateException(RateDomainModel rdm){
		this();
		this.rdm = rdm;
	}
	public RateException(RateDomainModel rdm, double gcs, double gi){
		this();
		this.rdm =rdm;
		this.GivenCreditScore= gcs;
		this.GivenIncome = gi;	
		
	}
	public RateException(double gcs, double gi){
		this();
		this.GivenCreditScore= gcs;
		this.GivenIncome = gi;

	}
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
