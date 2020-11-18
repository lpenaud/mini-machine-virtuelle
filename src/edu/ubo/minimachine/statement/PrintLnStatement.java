package edu.ubo.minimachine.statement;

import edu.ubo.minimachine.expression.Expression;
import edu.ubo.minimachine.visitor.Visitor;

public class PrintLnStatement implements ProcCallStatement {

	public PrintLnStatement(final Expression argument) {
		this.argument = argument;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Expression getArgument() {
		return argument;
	}

	protected final Expression argument;
}
