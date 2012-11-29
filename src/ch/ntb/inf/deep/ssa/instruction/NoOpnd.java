/*
 * Copyright (c) 2011 NTB Interstate University of Applied Sciences of Technology Buchs.
 *
 * http://www.ntb.ch/inf
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * 
 * Contributors:
 *     NTB - initial implementation
 * 
 */

package ch.ntb.inf.deep.ssa.instruction;

import ch.ntb.inf.deep.cgPPC.RegAllocator;
import ch.ntb.inf.deep.classItems.StdConstant;
import ch.ntb.inf.deep.classItems.StringLiteral;
import ch.ntb.inf.deep.host.StdStreams;
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(result.n + ": ");
		sb.append("NoOpnd["+ scMnemonics[ssaOpcode]+"] ");
		if (ssaOpcode == sCloadConst) 
			if (result.constant instanceof StdConstant) {
				StdConstant constant = (StdConstant)result.constant;
				if (constant.name == null) {
					sb.append(constant.valueH);
				} else {
					long value = ((long)(constant.valueH)<<32) | (constant.valueL&0xFFFFFFFFL);
					char category = constant.type.name.charAt(0);
					if (category == 'I') 
						sb.append(constant.valueH);
					else if (category == 'J') 
						sb.append(value);
					else if (category == 'F') 
						sb.append(Float.toString(Float.intBitsToFloat(constant.valueH)));
					else
						sb.append(Double.longBitsToDouble(value));
				}
				sb.append(" (" + result.typeName() + ")");
			} else {
				StringLiteral str = (StringLiteral)result.constant;
				if (str != null) sb.append("\"" + str.string + "\"");
				else sb.append("null");
				sb.append(" (" + result.typeName() + ")");
			}
		else
			sb.append("(" + result.typeName() + ")");
		if (result.index != -1) sb.append(", index=" + result.index);
		if (result.join != null) {
			sb.append(", join=[" + result.index + "(");
			SSAValue join = RegAllocator.joins[result.index];
			int i = 0;
			while (join != null && join != result.join) {
				i++;
				join = join.next;
			}
			sb.append(i + ")]");
		} else {
			sb.append(", end=" + result.end);
			if (result.reg != -1) {
				if (result.nonVol) sb.append(", nonVol"); else sb.append(", vol");
			}
			if (result.regLong != -1) sb.append(", regLong=" + result.regLong);
			if (result.reg != -1) sb.append(", reg=" + result.reg);
			if (result.regGPR1 != -1) sb.append(", regAux1=" + result.regGPR1);
		}
		return sb.toString();
	}
}
