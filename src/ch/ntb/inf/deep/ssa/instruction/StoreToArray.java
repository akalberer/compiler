package ch.ntb.inf.deep.ssa.instruction;

import ch.ntb.inf.deep.ssa.SSAValue;

public class StoreToArray extends SSAInstruction {

	public StoreToArray(int opCode, SSAValue arrayref, SSAValue index, SSAValue value){
		ssaOpcode = opCode;
		operands = new SSAValue[]{arrayref, index, value};
	}

	public StoreToArray(int opCode){
		ssaOpcode = opCode;
	}
	
	@Override
	public SSAValue[] getOperands() {
		return operands;
	}

	@Override
	public void setOperands(SSAValue[] operands) {
		if (operands.length == 3) {
			this.operands = operands;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void print(int level) {
		for (int i = 0; i < level*3; i++)System.out.print(" ");
		System.out.print(result.n + ": ");
		System.out.print("StoreToArray["+ scMnemonics[ssaOpcode]+"] {"+ operands[0].n + ", " + operands[1].n + ", " + operands[2].n+"}");
		System.out.print(" (" + result.typeName() + ")");
		System.out.print(",   end=" + result.end);
		if (result.index != -1) System.out.print(", index=" + result.index);
		if (result.reg != -1) System.out.print(", reg=" + result.reg);
		if (result.regLong != -1) System.out.print(", regLong=" + result.regLong);
		if (result.join != null) System.out.print(", join={" + result.join.n + "}");
		System.out.println();
	}

}
