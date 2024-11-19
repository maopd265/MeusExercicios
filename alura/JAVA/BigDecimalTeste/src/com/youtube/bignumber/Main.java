package com.youtube.bignumber;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=0.03;
		double b=0.04;
		double c=b-a;
		System.out.println(c);
		BigDecimal _a=new BigDecimal("0.03");
		BigDecimal _b=new BigDecimal("0.04");
		BigDecimal _c=_b.subtract(_a);
		System.out.println(_c);
		System.out.println(_a.add(_c));
		System.out.println(_a.multiply(new BigDecimal("100")));
		BigInteger numBigInt = new BigInteger("1231321");
		System.out.println(numBigInt.divide(new BigInteger("2")));
	}

}
