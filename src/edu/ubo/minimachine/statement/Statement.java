package edu.ubo.minimachine.statement;

import edu.ubo.minimachine.visitor.Visitor;

public interface Statement {
	void accept(Visitor visitor);
}
