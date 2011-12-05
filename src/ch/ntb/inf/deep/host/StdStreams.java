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

package ch.ntb.inf.deep.host;

import java.io.PrintStream;

public class StdStreams {
	public static PrintStream log = System.out; // logging
	public static PrintStream out = System.out; // std out
	public static PrintStream vrb = System.out; // verbose
	public static PrintStream err = System.err; // error messages
	
	
	public static void printIndent(int indentLevel, PrintStream pstream){
		indentLevel = indentLevel*3;
		while(indentLevel-- > 0) pstream.append(' ');
	}

	public static void vrbPrintIndent(int indentLevel){
		printIndent(indentLevel, vrb);
	}

}
