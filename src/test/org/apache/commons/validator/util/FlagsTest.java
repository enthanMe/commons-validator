/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//validator/src/test/org/apache/commons/validator/util/FlagsTest.java,v 1.4 2004/01/17 17:32:28 dgraham Exp $
 * $Revision: 1.4 $
 * $Date: 2004/01/17 17:32:28 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003-2004 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names, "Apache", "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.commons.validator.util;

import junit.framework.TestCase;

/**
 * Test the Flags class.
 */
public class FlagsTest extends TestCase {

	/**
	 * Declare some flags for testing.
	 */
	private static final long LONG_FLAG = 1;
	private static final long LONG_FLAG_2 = 2;
	private static final int INT_FLAG = 4;

	/**
	 * Constructor for FlagsTest.
	 */
	public FlagsTest(String name) {
		super(name);
	}

	public void testHashCode() {
		Flags f = new Flags(45);
		assertEquals(f.hashCode(), 45);
	}

	public void testGetFlags() {
		Flags f = new Flags(45);
		assertEquals(f.getFlags(), 45);
	}

	public void testIsOnOff() {
		Flags f = new Flags();
		f.turnOn(LONG_FLAG);
		f.turnOn(INT_FLAG);
		assertTrue(f.isOn(LONG_FLAG));
		assertTrue(!f.isOff(LONG_FLAG));

		assertTrue(f.isOn(INT_FLAG));
		assertTrue(!f.isOff(INT_FLAG));

		assertTrue(f.isOff(LONG_FLAG_2));
	}

	public void testTurnOnOff() {
	}

	public void testTurnOff() {
	}

	public void testTurnOffAll() {
		Flags f = new Flags(98432);
		f.turnOffAll();
		assertEquals(0, f.getFlags());
	}
    
    public void testClear() {
        Flags f = new Flags(98432);
        f.clear();
        assertEquals(0, f.getFlags());
    }

	public void testTurnOnAll() {
		Flags f = new Flags();
		f.turnOnAll();
		assertEquals(Long.MAX_VALUE, f.getFlags());
	}

	/**
	 * Test for Object clone()
	 */
	public void testClone() {
	}

	/**
	 * Test for boolean equals(Object)
	 */
	public void testEqualsObject() {
	}

	/**
	 * Test for String toString()
	 */
	public void testToString() {
		Flags f = new Flags();
		String s = f.toString();
		assertEquals(64, s.length());

		f.turnOn(INT_FLAG);
		s = f.toString();
		assertEquals(64, s.length());

		assertEquals(
			"0000000000000000000000000000000000000000000000000000000000000100",
			s);
	}

}