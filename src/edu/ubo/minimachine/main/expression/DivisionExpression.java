package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.visitor.Visitor;

public class DivisionExpression extends BinaryExpression {

	public DivisionExpression(final Expression exprLeft, final Expression exprRight) {
		super(exprLeft, exprRight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.toString("/");
	}

}
