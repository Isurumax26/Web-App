package com.example.models;

import org.springframework.stereotype.Service;

@Service
public class Product {
	
	private int id;
	private double cartonPrice ;
	private int UnitsPerCarton;
	private int amount;
	
	
	public Product(int id, double carton, int units) {
		super();
		this.id = id;
		this.cartonPrice = carton;
		this.UnitsPerCarton = units;
	}
	
	
	
	public Product(int id) {
		setId(id);
	}
	
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		if(id == 1) {
			this.cartonPrice = 175;
			this.UnitsPerCarton = 20;
		}else if(id==2) {
			this.cartonPrice = 825;
			this.UnitsPerCarton = 5;
		}
	}
	public double getCartonPrice() {
		return cartonPrice;
	}
	public void setCartonPrice(double carton) {
		this.cartonPrice = carton;
	}
	public int getUnitsPerCarton() {
		return UnitsPerCarton;
	}
	public void setUnitsPerCarton(int unitsPerCarton) {
		UnitsPerCarton = unitsPerCarton;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}



	public double calPrice(int amount) {
		double total = 0.00;
		int numCarton = 0;
		//double cartonPrice = 0.00;  //default value
		int numUnits = 0 ;
		
		if(id == 1) {
			cartonPrice = 175;
			numUnits = 20;
		}
		else if (id == 2) {
			cartonPrice = 825;
			numUnits = 5;
		}
		
		while(amount > 0) {
			if(amount >= numUnits) {
				if(numCarton < 3) {
					total = total + cartonPrice;
					numCarton = numCarton + 1;
				}
				else if(numCarton >= 3){
					total = total + cartonPrice*0.9;
				}
				
				amount = amount - numUnits;
			}
			else {
				total = total + (cartonPrice / numUnits)*1.3;
				amount = amount - 1;
			}
		}
		
		return total;
	}
	

}
