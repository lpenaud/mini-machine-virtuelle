package edu.ubo.minimachine.main.visitor;

import edu.ubo.minimachine.main.expression.*;
import edu.ubo.minimachine.main.statement.AssignmentStatement;
import edu.ubo.minimachine.main.statement.PrintLnStatement;

public interface Visitor {
	default void visit(IntExpression expression) {
		throw new UnsupportedOperationException();
	}

	default void visit(MultiplicationExpression expression) {
		throw new UnsupportedOperationException();
	}
	
	default void visit(AdditionExpression expression) {
		throw new UnsupportedOperationException();
	}
	
	default void visit(SubtractionExpression expression) {
		throw new UnsupportedOperationException();
	}
	
	default void visit(DivisionExpression expression) {
		throw new UnsupportedOperationException();
	}
	
	default void visit(VariableExpression expression) {
		throw new UnsupportedOperationException();
	}
	
	default void visit(AssignmentStatement statement) {
		throw new UnsupportedOperationException();
	}
	
	default void visit(PrintLnStatement statement) {
		throw new UnsupportedOperationException();
	}
}
