package edu.ubo.minimachine.visitor;

import edu.ubo.minimachine.expression.*;
import edu.ubo.minimachine.statement.AssignmentStatement;
import edu.ubo.minimachine.statement.PrintLnStatement;

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
