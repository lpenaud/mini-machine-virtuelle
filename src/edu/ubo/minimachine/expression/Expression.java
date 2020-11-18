package edu.ubo.minimachine.expression;

import edu.ubo.minimachine.visitor.Visitor;

public interface Expression {
	void accept(Visitor visitor);
}
