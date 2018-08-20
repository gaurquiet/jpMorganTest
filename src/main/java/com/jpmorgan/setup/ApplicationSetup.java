package com.jpmorgan.setup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.jpmorgan.dao.DataService;
import com.jpmorgan.dao.DataServiceImpl;
import com.jpmorgan.model.Instruction;
import com.jpmorgan.receiver.InstructionAssembler;
import com.jpmorgan.receiver.InstructionReceiver;
import com.jpmorgan.receiver.InstructionValidator;
import com.jpmorgan.report.ReportGenerator;

/**
 * @author Anu
 *
 */
public class ApplicationSetup {
	private DataService dataService;
	private ReportGenerator reportGenerator;
	private InstructionReceiver instructionReceiver;

	/**
	 * @param args
	 */
	public static void main(String[] args){
		ApplicationSetup app = new ApplicationSetup();
		app.dataService = new DataServiceImpl();
		app.instructionReceiver = new InstructionReceiver(app.dataService, new InstructionValidator(), new InstructionAssembler());
		app.reportGenerator = new ReportGenerator(app.dataService);

		BufferedReader br = null;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :");
				String input = br.readLine();

				if ("1".equals(input)) {
					Instruction instruction = new Instruction();
					System.out.println("Add entity name:");
					instruction.setEntity(br.readLine());

					System.out.println("Add instruction type (B for Buy and S for Sell):");
					instruction.setInstructionType(br.readLine());

					System.out.println("Add agreed Fx:");
					instruction.setAgreedFx(Float.parseFloat(br.readLine()));

					System.out.println("Add 3 digit currency code:");
					instruction.setCurrency(br.readLine());

					System.out.println("Add instruction date (dd-mm-yyyy):");
					instruction.setInstructionDate(myFormat.parse(br.readLine()));

					System.out.println("Add settlement date (dd-mm-yyyy):");
					instruction.setSettlementDate(myFormat.parse(br.readLine()));

					System.out.println("Add units!");
					instruction.setUnits(Integer.parseInt(br.readLine()));

					System.out.println("Add price per unit!");
					instruction.setPricePerUnit(Float.parseFloat(br.readLine()));

					System.out.println(instruction);
					app.instructionReceiver.receiveInstruction(instruction);
					System.out.println(instruction);

				} else if("2".equals(input)){
					System.out.println("Enter 1 for report on a date, enter 2 to get complete report:");
					String reportInput = br.readLine();
					if("1".equals(reportInput)){
						System.out.println("Enter date  (dd-mm-yyyy):");
						Date reportDate = myFormat.parse(br.readLine());
						app.reportGenerator.generateReportForDate(reportDate);
					} else if("2".equals(reportInput)){
						app.reportGenerator.generateCompleteReport();
					} else {
						System.out.println("Thanks for using application !! Good bye !! Exit!");
						System.exit(0);
					}

				} else if("3".equals(input)){
					System.out.println("Thanks for using application !! Good bye !! Exit!");
					System.exit(0);
				} else {
					System.out.print("Wrong input !! : ");
					System.out.print("Enter 1 to submit an Instruction, 2 to generate the report, 3 to exit :");
				}

				System.out.println("-----------\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception exp){
			exp.printStackTrace();
		} finally {


			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
