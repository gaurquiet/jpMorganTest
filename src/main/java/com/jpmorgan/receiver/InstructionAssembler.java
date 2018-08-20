package com.jpmorgan.receiver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class InstructionAssembler {
	Calendar cal = Calendar.getInstance();
	
	/**
	 * @param instruction
	 * @return
	 */
	public Instruction assemble(Instruction instruction){

		calculateInstructionAmountInUSD(instruction);
		adjustSettlementDate(instruction);
		return instruction;
	}
	
	/**
	 * @param instruction
	 */
	public void calculateInstructionAmountInUSD(Instruction instruction){
		instruction.setInstructionAmountInUSD(instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx());
	}
	
	/**
	 * @param instruction
	 */
	public void adjustSettlementDate(Instruction instruction){
		
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
		instruction.setWeekDay(simpleDateformat.format(instruction.getSettlementDate()));
		
		cal.setTime(instruction.getSettlementDate());
		

		if(instruction.getCurrency().equalsIgnoreCase("AED") || instruction.getCurrency().equalsIgnoreCase("SAR") ){
			if(instruction.getWeekDay().equals("Fri")){
				cal.add(Calendar.DATE, 2);
				instruction.setUpdatedSettlementDate(cal.getTime());
			} else if (instruction.getWeekDay().equals("Sat")){
				cal.add(Calendar.DATE, 1);
				instruction.setUpdatedSettlementDate(cal.getTime());
			} else {
				instruction.setUpdatedSettlementDate(instruction.getSettlementDate());
			}
		} else {
			if(instruction.getWeekDay().equals("Sat")){
				cal.add(Calendar.DATE, 2);
				instruction.setUpdatedSettlementDate(cal.getTime());
			} else if (instruction.getWeekDay().equals("Sun")){
				cal.add(Calendar.DATE, 1);
				instruction.setUpdatedSettlementDate(cal.getTime());
			} else {
				instruction.setUpdatedSettlementDate(instruction.getSettlementDate());
			}
		}
	}
}
