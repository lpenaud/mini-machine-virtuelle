package edu.ubo.minimachine.expression;

public abstract class BinaryExpression implements Expression {

	public BinaryExpression(final Expression exprLeft, final Expression exprRight) {
		this.exprLeft = exprLeft;
		this.exprRight = exprRight;
	}
	
	public Expression getExprLeft() {
		return exprLeft;
	}
	
	public Expression getExprRight() {
		return exprRight;
	}

	protected final Expression exprLeft;
	protected final Expression exprRight;
}
