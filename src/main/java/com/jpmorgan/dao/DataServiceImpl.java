package com.jpmorgan.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class DataServiceImpl implements DataService {

	private Map<Date, List<Instruction>> instructionMap = new HashMap<Date, List<Instruction>>();
	private Map<String, List<Instruction>> instructionMapWithStringKey = new HashMap<String, List<Instruction>>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	
	/**
	 * @param instruction
	 */
	public void addInstructionWithStringKey(Instruction instruction) {
		if(instructionMapWithStringKey.get(sdf.format(instruction.getUpdatedSettlementDate())) == null){
			instructionMapWithStringKey.put(sdf.format(instruction.getUpdatedSettlementDate()), new ArrayList<Instruction>());
		} 
		instructionMapWithStringKey.get(sdf.format(instruction.getUpdatedSettlementDate())).add(instruction);
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.dao.DataService#addInstruction(com.jpmorgan.model.Instruction)
	 */
	public void addInstruction(Instruction instruction) {
		if(instructionMap.get(instruction.getUpdatedSettlementDate()) == null){
			instructionMap.put(instruction.getUpdatedSettlementDate(), new ArrayList<Instruction>());
		} 
		instructionMap.get(instruction.getUpdatedSettlementDate()).add(instruction);
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.dao.DataService#getAllInstructionsList()
	 */
	public List<Instruction> getAllInstructionsList() {
		List<Instruction> instructionList = new ArrayList<Instruction>();
		for(List<Instruction> insList:instructionMap.values()){
			instructionList.addAll(insList);
		}
		return instructionList;
		 
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.dao.DataService#getAllInstructionsMap()
	 */
	public Map<Date, List<Instruction>> getAllInstructionsMap() {
		return instructionMap;
	}

	/**
	 * @param date
	 * @return
	 */
	public List<Instruction> getAllInstructionsByGivenDateFromStringKey(Date date) {
		return instructionMapWithStringKey.get(sdf.format(date));
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.dao.DataService#getAllInstructionsByGivenDate(java.util.Date)
	 */
	public List<Instruction> getAllInstructionsByGivenDate(Date date) {
		return instructionMap.get(date);
	}

}
