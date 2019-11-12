package miscelleneous;

import java.util.ArrayList;

import miscelleneous.SolveExpression.Term.Operator;

public class SolveExpression {
	double compute(String sequence) {
		 ArrayList<Term> terms = Term.parseTermSequence(sequence);
		 if (terms == null) return Integer.MIN_VALUE;
		 double result = 0;
		 Term processing= null;
		 for (int i= 0; i < terms.size(); i++) {




		Term current= terms.get(i);
		Term next= i + 1 < terms.size() ? terms.get(i + 1):null;
		 processing= collapseTerm(processing, current);
		 
		 if (next== null || next.getOperator() == Operator.ADD
		 || next.getOperator() == Operator.SUBTRACT) {
		 result= applyOp(result, processing.getOperator(), processing.getNumber());
		 processing= null;
		 }
		 }

		 return result;
		 }

		 /* Collapse two terms together using the operator in secondary and the numbers
		 * from each. */
		 Term collapseTerm(Term primary, Term secondary) {
		 if (primary== null) return secondary;
		 if (secondary== null) return primary;

		 double value= applyOp(primary.getNumber(), secondary.getOperator(),
		 secondary.getNumber());
		 primary.setNumber(value);
		 return primary;
		 }

		 double applyOp(double left, Operator op, double right) {
		 if (op== Operator.ADD) return left+ right;
		 else if (op Operator.SUBTRACT) return left - right;
		 else if (op== Operator.MULTIPLY) return left * right;
		 else if (op== Operator.DIVIDE) return left/ right;
		 else return right;
		 }

		static class Term {
		 public enum Operator {
		 ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
		 }

		 private double value;
		 private Operator operator= Operator.BLANK;

		 public Term(double v, Operator op) {
		 value= v;
		 operator= op;
		 }

		 public double getNumber() { return value;}
		 public Operator getOperator() { return operator; }
		 public void setNumber(double v) {value= v;}

		 /* Parses arithmetic sequence into a list of Terms. For example, 3-5*6 becomes
		S26 Cracking the Coding Interview, 6th Edition
		Solutions to Chapter 16 I Moderate
		 * something like: [{BLANK,3}, {SUBTRACT, 5}, {MULTIPLY, 6}}.
		 * If improperly formatted, returns null. */
		 public static ArrayList<Term> parseTermSequence(String sequence) {
		 /* Code can be found in downloadable solutions. */
		 }
		 }
	

}
