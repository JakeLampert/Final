package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			double rate = 0;
			try{
				rate = RateBLL.getRate(lq.getiCreditScore());
			} catch (RateException re){
				System.out.println("Given score too low");
			} catch(Exception e){
				throw e;
			}
			lq.setdPayment(RateBLL.getPayment(rate/12, 12*lq.getiTerm(), lq.getdAmount() - lq.getiDownPayment(), 0, false));
			
			try{
			if(lq.getdPayment() > .28*(lq.getIncome()/12)){
				RateException re = new RateException(lq.getiCreditScore(), lq.getIncome());
				sendToAll(re);
			}}catch(Exception e){
			throw e;
			}
			
			try{
			if(lq.getdPayment() > .36*(lq.getIncome()/12 + lq.getExpenses()/12)){
				RateException re = new RateException(lq.getIncome(), lq.getExpenses());
				sendToAll(re);
			}}catch(Exception e){
				throw e;
			}
			sendToAll(lq);
		}
	}
}
