package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.visitor.Visitor;

public class MultiplicationExpression extends BinaryExpression {

	public MultiplicationExpression(final Expression exprLeft, final Expression exprRight) {
		super(exprLeft, exprRight);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.toString("×");
	}

}
