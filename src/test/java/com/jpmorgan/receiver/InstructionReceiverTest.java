package com.jpmorgan.receiver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.jpmorgan.dao.DataService;
import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class InstructionReceiverTest {
	@Mock
	private DataService dataService;
	@Mock
	private InstructionValidator validator;
	@Mock
	private InstructionAssembler assembler;
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	public InstructionReceiver receiver;
	
	/**
	 * @throws Exception
	 */
	@Test
	public void receiveInstructionTest() throws Exception{
		Instruction value = mock(Instruction.class);
		receiver = new InstructionReceiver(dataService, validator, assembler);
		receiver.receiveInstruction(value);
		verify(dataService).addInstruction(value);
		verify(validator).validate(value);
		verify(assembler).assemble(value);
	}
}
