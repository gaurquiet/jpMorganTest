package com.jpmorgan.model;

import java.util.Date;

/**
 * @author Anu
 *
 */
public class Instruction{
	private String entity;
	private String instructionType;
	private float agreedFx;
	private String currency;
	private Date instructionDate;
	private Date settlementDate;
	private Date updatedSettlementDate;
	private int units;
	private float pricePerUnit;
	private double instructionAmountInUSD;
	private String weekDay;
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getInstructionType() {
		return instructionType;
	}
	public void setInstructionType(String instructionType) {
		this.instructionType = instructionType;
	}
	public float getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(float agreedFx) {
		this.agreedFx = agreedFx;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public float getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getInstructionAmountInUSD() {
		return this.instructionAmountInUSD;
	}
	public void setInstructionAmountInUSD(double instructionAmountInUSD) {
		this.instructionAmountInUSD = instructionAmountInUSD;
	}

	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	
	public Date getUpdatedSettlementDate() {
		return updatedSettlementDate;
	}
	public void setUpdatedSettlementDate(Date updatedSettlementDate) {
		this.updatedSettlementDate = updatedSettlementDate;
	}
	@Override
	public String toString() {
		return "Instruction [entity=" + entity + ", instructionType=" + instructionType + ", agreedFx=" + agreedFx
				+ ", currency=" + currency + ", instructionDate=" + instructionDate + ", settlementDate="
				+ settlementDate + ", updatedSettlementDate=" + updatedSettlementDate + ", units=" + units
				+ ", pricePerUnit=" + pricePerUnit + ", instructionAmountInUSD=" + instructionAmountInUSD + ", weekDay="
				+ weekDay + "]";
	}

}
