package edu.ubo.minimachine.main.statement;

import edu.ubo.minimachine.main.visitor.Visitor;

public interface Statement {
	void accept(Visitor visitor);
}
