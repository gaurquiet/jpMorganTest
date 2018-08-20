package com.jpmorgan.receiver;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

import com.jpmorgan.model.Instruction;

/**
 * @author Anu
 *
 */
public class InstructionAssemblerTest {
	InstructionAssembler subject = new InstructionAssembler();

	/**
	 * 
	 */
	@Test
	public void testAssemble(){
		Instruction value = mock(Instruction.class);
		when(value.getPricePerUnit()).thenReturn(100.25F);
		when(value.getUnits()).thenReturn(200);
		when(value.getAgreedFx()).thenReturn(0.5F);
		when(value.getSettlementDate()).thenReturn(new Date());
		when(value.getCurrency()).thenReturn("GBP");
		when(value.getWeekDay()).thenReturn("Sat");
		subject.assemble(value);
		verify(value, atLeast(2)).getSettlementDate();
	}

	/**
	 * 
	 */
	@Test
	public void testCalculateInstructionAmountInUSD(){
		Instruction value = new Instruction();
		value.setPricePerUnit(100.25F);
		value.setUnits(200);
		value.setAgreedFx(0.5F);
		subject.calculateInstructionAmountInUSD(value);
		assertEquals(10025.00F, value.getInstructionAmountInUSD(),0.0F);
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void testAdjustSettlementDateForSaturdayForSGP() throws ParseException{
		Instruction value = new Instruction();
		value.setSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("02-01-2016"));
		value.setCurrency("SGP");
		subject.adjustSettlementDate(value);
		assertEquals("04-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(value.getUpdatedSettlementDate()));
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void testAdjustSettlementDateForSundayForSGP() throws ParseException{
		Instruction value = new Instruction();
		value.setSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("03-01-2016"));
		value.setCurrency("SGP");
		subject.adjustSettlementDate(value);
		assertEquals("04-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(value.getUpdatedSettlementDate()));
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void testAdjustSettlementDateForMondayForSGP() throws ParseException{
		Instruction value = new Instruction();
		value.setSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("04-01-2016"));
		value.setCurrency("SGP");
		subject.adjustSettlementDate(value);
		assertEquals("04-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(value.getUpdatedSettlementDate()));
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void testAdjustSettlementDateForThursdayForAED() throws ParseException{
		Instruction value = new Instruction();
		value.setSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("07-01-2016"));
		value.setCurrency("AED");
		subject.adjustSettlementDate(value);
		assertEquals("07-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(value.getUpdatedSettlementDate()));
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void testAdjustSettlementDateForFridayForAED() throws ParseException{
		Instruction value = new Instruction();
		value.setSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("08-01-2016"));
		value.setCurrency("AED");
		subject.adjustSettlementDate(value);
		assertEquals("10-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(value.getUpdatedSettlementDate()));
	}
	
	/**
	 * @throws ParseException
	 */
	@Test
	public void testAdjustSettlementDateForSaturdayForAED() throws ParseException{
		Instruction value = new Instruction();
		value.setSettlementDate(new SimpleDateFormat("dd-mm-yyyy").parse("09-01-2016"));
		value.setCurrency("AED");
		subject.adjustSettlementDate(value);
		assertEquals("10-01-2016", new SimpleDateFormat("dd-mm-yyyy").format(value.getUpdatedSettlementDate()));
	}
}
