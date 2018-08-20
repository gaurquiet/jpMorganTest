package com.jpmorgan.receiver;

import com.jpmorgan.dao.DataService;
import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class InstructionReceiver {
	private DataService dataService;
	private InstructionValidator validator;
	private InstructionAssembler assembler;
	
	/**
	 * @param instruction
	 * @throws Exception
	 */
	public void receiveInstruction(Instruction instruction) throws Exception{
		validator.validate(instruction);
		assembler.assemble(instruction);
		dataService.addInstruction(instruction);
	}
	
	/**
	 * @param dataService
	 */
	public void setDataService(DataService dataService){
		this.dataService = dataService;
	}
	
	/**
	 * @param validator
	 */
	public void setValidatorService(InstructionValidator validator){
		this.validator = validator;
	}
	
	/**
	 * @param assembler
	 */
	public void setAssemblerService(InstructionAssembler assembler){
		this.assembler = assembler;
	}
	
	/**
	 * @param dataService
	 * @param validator
	 * @param assembler
	 */
	public InstructionReceiver(DataService dataService, InstructionValidator validator, InstructionAssembler assembler){
		this.dataService = dataService;
		this.validator = validator;
		this.assembler = assembler;
	}
}
