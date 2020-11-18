package edu.ubo.minimachine.statement;

import edu.ubo.minimachine.expression.Expression;

public interface ProcCallStatement extends Statement {
	Expression getArgument();
}
