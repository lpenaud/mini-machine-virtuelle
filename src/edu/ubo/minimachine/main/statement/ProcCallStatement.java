package edu.ubo.minimachine.main.statement;

import edu.ubo.minimachine.main.expression.Expression;

public interface ProcCallStatement extends Statement {
	Expression getArgument();
}
