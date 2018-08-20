package com.jpmorgan.receiver;

import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class InstructionValidator {
	/**
	 * @param instruction
	 * @throws Exception
	 */
	public void validate(Instruction instruction) throws Exception{
		if(!(instruction.getInstructionType().equalsIgnoreCase("B") || instruction.getInstructionType().equalsIgnoreCase("S"))){
			throw new Exception("Wrong entity type passed.. Entity type can be either B or S");
		}
	}
}
