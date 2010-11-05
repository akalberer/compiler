package ch.ntb.inf.deep.ssa.instruction;

import ch.ntb.inf.deep.classItems.Constant;
import ch.ntb.inf.deep.ssa.SSAValue;

public class NoOpnd extends SSAInstruction {
	
	public NoOpnd(int opcode){
		ssaOpcode = opcode;		
	}

	@Override
	public SSAValue[] getOperands() {
		return null;
	}

	@Override
	public void setOperands(SSAValue[] operands) {
		//return immediately
	}
	@Override
	public void print(int level) {
		for (int i = 0; i < level*3; i++)System.out.print(" ");
		System.out.print(result.n + ": ");
		System.out.print("NoOpnd["+ scMnemonics[ssaOpcode]+"] ");
		if (ssaOpcode == sCloadConst) 
			if (result.constant instanceof Constant) {
		//		((Constant)result.constant).printConstVal((Constant)result.constant, 23, 34);
				Constant constant = (Constant)result.constant;
				long value = ((long)(constant.valueH)<<32) | (constant.valueL&0xFFFFFFFFL);
				char category = constant.name.charAt(0);
				if (category == 'F') 
					System.out.print(Float.toString(Float.intBitsToFloat(constant.valueH)));
				else
					System.out.print(Double.longBitsToDouble(value));
				System.out.print(" (" + result.typeName() + ")");
			} else 
				System.out.print(result.constant + " (" + result.typeName() + ")");
		else
			System.out.print("(" + result.typeName() + ")");
		System.out.print(",   end=" + result.end);
		if (result.index != -1) System.out.print(", index=" + result.index);
		if (result.regLong != -1) System.out.print(", regLong=" + result.regLong);
		if (result.reg != -1) System.out.print(", reg=" + result.reg);
		if (result.join != null) System.out.print(", join={" + result.join.n + "}");
		System.out.println();
	}
}
