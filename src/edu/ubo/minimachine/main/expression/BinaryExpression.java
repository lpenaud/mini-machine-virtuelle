package edu.ubo.minimachine.main.expression;

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

	protected String toString(final String op) {
		return new StringBuilder("(").append(this.exprLeft.toString()).append(" ").append(op).append(" ")
				.append(this.exprRight.toString()).append(")").toString();
	}

	protected final Expression exprLeft;
	protected final Expression exprRight;
}
