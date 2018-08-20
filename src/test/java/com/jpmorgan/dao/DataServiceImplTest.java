package com.jpmorgan.dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class DataServiceImplTest {

	DataServiceImpl subject = new DataServiceImpl();
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void addInstructionAndGetAllInstructionsByGivenDateTest() throws ParseException{
		Instruction value = new Instruction();
		value.setUpdatedSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("02-01-2016"));
		value.setCurrency("SGP");
		subject.addInstruction(value);
		List<Instruction> retreivedInstructions = subject.getAllInstructionsByGivenDate(value.getUpdatedSettlementDate());
		assertNotNull(retreivedInstructions);
		assertEquals(1, retreivedInstructions.size());
		assertEquals("02-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(retreivedInstructions.get(0).getUpdatedSettlementDate()));
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void addInstructionByStringAndGetAllInstructionsByGivenDateStringTest() throws ParseException{
		Instruction value = new Instruction();
		value.setUpdatedSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("02-01-2016"));
		value.setCurrency("SGP");
		subject.addInstructionWithStringKey(value);
		List<Instruction> retreivedInstructions = subject.getAllInstructionsByGivenDateFromStringKey(value.getUpdatedSettlementDate());
		assertNotNull(retreivedInstructions);
		assertEquals(1, retreivedInstructions.size());
		assertEquals("02-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(retreivedInstructions.get(0).getUpdatedSettlementDate()));
	}
}
