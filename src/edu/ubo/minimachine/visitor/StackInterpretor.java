package edu.ubo.minimachine.visitor;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import edu.ubo.minimachine.Variable;
import edu.ubo.minimachine.expression.AdditionExpression;
import edu.ubo.minimachine.expression.DivisionExpression;
import edu.ubo.minimachine.expression.IntExpression;
import edu.ubo.minimachine.expression.MultiplicationExpression;
import edu.ubo.minimachine.expression.SubtractionExpression;
import edu.ubo.minimachine.expression.VariableExpression;
import edu.ubo.minimachine.statement.AssignmentStatement;
import edu.ubo.minimachine.statement.PrintLnStatement;

public class StackInterpretor implements Visitor {
	
	public StackInterpretor() {
		this(System.out);
	}
	
	public StackInterpretor(final PrintStream out) {
		this.stack = new ArrayDeque<>();
		this.variables = new HashMap<>();
		this.out = out;
	}
	
	@Override
	public void visit(final IntExpression expression) {
		stack.push(expression);
	}
	
	@Override
	public void visit(final AdditionExpression expression) {
		expression.getExprLeft().accept(this);
		expression.getExprRight().accept(this);
		final IntExpression intRight = stack.pop();
		final IntExpression intLeft = stack.pop();
		stack.push(new IntExpression(intLeft.getValue() + intRight.getValue()));
	}
	
	@Override
	public void visit(final DivisionExpression expression) {
		expression.getExprLeft().accept(this);
		expression.getExprRight().accept(this);
		final IntExpression right = stack.pop();
		final IntExpression left = stack.pop();
		stack.push(new IntExpression(left.getValue() / right.getValue()));
	}
	
	@Override
	public void visit(final MultiplicationExpression expression) {
		expression.getExprLeft().accept(this);
		expression.getExprRight().accept(this);
		stack.push(new IntExpression(stack.pop().getValue() * stack.pop().getValue()));
	}
	
	@Override
	public void visit(final SubtractionExpression expression) {
		expression.getExprLeft().accept(this);
		expression.getExprRight().accept(this);
		final IntExpression right = stack.pop();
		final IntExpression left = stack.pop();
		stack.push(new IntExpression(left.getValue() - right.getValue()));
	}
	
	@Override
	public void visit(final VariableExpression expression) {
		stack.push(variables.get(expression.getVariable()));
	}
	
	@Override
	public void visit(final AssignmentStatement statement) {
		statement.getRightHand().accept(this);
		variables.put(statement.getLeftHand(), stack.peek());
	}
	
	@Override
	public void visit(final PrintLnStatement statement) {
		statement.getArgument().accept(this);
		out.println(stack.pop().getValue());
	}
	
	public IntExpression result() {
		return stack.peek();
	}
	
	protected final Deque<IntExpression> stack;
	protected final Map<Variable, IntExpression> variables;
	protected final PrintStream out;
}
