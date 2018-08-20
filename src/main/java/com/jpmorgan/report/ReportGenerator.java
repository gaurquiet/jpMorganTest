package com.jpmorgan.report;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.jpmorgan.dao.DataService;
import com.jpmorgan.model.Instruction;
import com.jpmorgan.model.InstrunctionDescendingComparator;

/**
 * @author Anu
 *
 */
public class ReportGenerator {
	private DataService dataService;

	/**
	 * 
	 */
	public void generateCompleteReport(){
		List<Instruction> instructions = dataService.getAllInstructionsList();
		Collections.sort(instructions, new InstrunctionDescendingComparator());
		headerPrinter();
		for(Instruction ins: instructions){
			instructionPrinter(ins);
		}
		printStraightLine();
	}

	/**
	 * @param date
	 */
	public void generateReportForDate(Date date){
		List<Instruction> instructions = dataService.getAllInstructionsByGivenDate(date);
		Collections.sort(instructions, new InstrunctionDescendingComparator());
		System.out.println("Incoming amount on date " + date + " : " + getTotalAmountByType(instructions, "S"));
		System.out.println("Outgoing amount on date " + date + " : " + getTotalAmountByType(instructions, "B"));
		headerPrinter();
		for(Instruction ins: instructions){
			instructionPrinter(ins);
		}
		printStraightLine();
	}

	/**
	 * 
	 */
	private void headerPrinter(){
		printStraightLine();
		System.out.print(String.format("%-10s" , "|Entity "));
		System.out.print(String.format("%-11s" , "|Buy/Sell "));
		System.out.print(String.format("%-15s" , "|Agreed Fx "));
		System.out.print(String.format("%-15s" , "|Currency "));
		System.out.print(String.format("%-30s" , "|Instruction Date "));
		System.out.print(String.format("%-30s" , "|Settelement Date "));
		System.out.print(String.format("%-40s" , "|Updated Settelement Date "));
		System.out.print(String.format("%-10s" , "|Units "));
		System.out.print(String.format("%-20s" , "|Price per Unit "));
		System.out.println(String.format("%-30s" , "|Total Value in USD "));
		printStraightLine();
	}

	/**
	 * @param ins
	 */
	private void instructionPrinter(Instruction ins){
		System.out.print(String.format("%-10s" , "|" + ins.getEntity()));
		System.out.print(String.format("%-11s" , "|" + ins.getInstructionType()));
		System.out.print(String.format("%-15s" , "|" + ins.getAgreedFx()));
		System.out.print(String.format("%-15s" , "|" + ins.getCurrency()));
		System.out.print(String.format("%-30s" , "|" + ins.getInstructionDate()));
		System.out.print(String.format("%-30s" , "|" + ins.getSettlementDate()));
		System.out.print(String.format("%-40s" , "|" + ins.getUpdatedSettlementDate()));
		System.out.print(String.format("%-10s" , "|" + ins.getUnits()));
		System.out.print(String.format("%-20s" , "|" + ins.getPricePerUnit()));
		System.out.println(String.format("%-30s" , "|" + ins.getInstructionAmountInUSD()));
	}

	/**
	 * @param instructions
	 * @param type
	 * @return
	 */
	private double getTotalAmountByType(List<Instruction> instructions, String type){
		double totalAmount = 0.0;
		for(Instruction ins: instructions){
			if(ins.getInstructionType().equalsIgnoreCase(type)){
				totalAmount = totalAmount + ins.getInstructionAmountInUSD();
			}
		}
		return totalAmount;
	}

	/**
	 * @param dataService
	 */
	public void bindDataService(DataService dataService){
		this.dataService = dataService;
	}

	/**
	 * @param dataService
	 */
	public ReportGenerator(DataService dataService){
		this.dataService = dataService;
	}
	
	/**
	 * 
	 */
	private void printStraightLine(){
		System.out.print("_______________________________________________________________________________________________________________________________________");
		System.out.println("_______________________________________________________________________________________________________________________________________");
	}

}
