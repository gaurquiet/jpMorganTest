package com.jpmorgan.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 * This interface has methods to get and save data in database.
 */
public interface DataService {
	public void addInstruction(Instruction instruction);
	public List<Instruction> getAllInstructionsList() ;
	public List<Instruction> getAllInstructionsByGivenDate(Date date);
	public Map<Date, List<Instruction>> getAllInstructionsMap() ;
}
