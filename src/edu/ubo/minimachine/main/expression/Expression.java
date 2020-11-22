package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.visitor.Visitor;

public interface Expression {
	void accept(Visitor visitor);
}
