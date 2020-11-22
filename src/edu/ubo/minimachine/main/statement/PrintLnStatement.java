package edu.ubo.minimachine.main.statement;

import edu.ubo.minimachine.main.expression.Expression;
import edu.ubo.minimachine.main.visitor.Visitor;

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
