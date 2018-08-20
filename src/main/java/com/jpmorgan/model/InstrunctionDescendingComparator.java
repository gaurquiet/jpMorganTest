package com.jpmorgan.model;

import java.util.Comparator;

/**
 * @author Anu
 *
 */
public class InstrunctionDescendingComparator implements Comparator{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object obj0, Object obj1) {
		Instruction arg0 = (Instruction)obj0;
		Instruction arg1 = (Instruction)obj1;
		if (arg0.getInstructionAmountInUSD() > arg1.getInstructionAmountInUSD()){
			return -1;
		} else if(arg0.getInstructionAmountInUSD() < arg1.getInstructionAmountInUSD()){
			return 1;
		} else {
			return 0;
		}
	}

}
