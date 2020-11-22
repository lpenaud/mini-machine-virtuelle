package edu.ubo.minimachine.main.statement;

import edu.ubo.minimachine.main.Variable;
import edu.ubo.minimachine.main.expression.Expression;
import edu.ubo.minimachine.main.visitor.Visitor;

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
