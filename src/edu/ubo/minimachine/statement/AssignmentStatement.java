package edu.ubo.minimachine.statement;

import edu.ubo.minimachine.Variable;
import edu.ubo.minimachine.expression.Expression;
import edu.ubo.minimachine.visitor.Visitor;

public class AssignmentStatement implements Statement {
	
	public AssignmentStatement(final Variable leftHand, final Expression rightHand) {
		this.leftHand = leftHand;
		this.rightHand = rightHand;
	}
	
	public Variable getLeftHand() {
		return leftHand;
	}
	
	public Expression getRightHand() {
		return rightHand;
	}
	
	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
	
	protected final Variable leftHand;
	protected final Expression rightHand;
}
