package edu.ubo.minimachine.test.visitor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ubo.minimachine.main.Variable;
import edu.ubo.minimachine.main.expression.*;
import edu.ubo.minimachine.main.statement.AssignmentStatement;
import edu.ubo.minimachine.main.statement.PrintLnStatement;
import edu.ubo.minimachine.main.statement.Statement;
import edu.ubo.minimachine.main.visitor.StackInterpretor;
import edu.ubo.minimachine.test.utils.TestOutputStream;

class StackInterpretorTest {
	@BeforeEach
	void setUp() {
		outputStream = new TestOutputStream();
		interpretor = new StackInterpretor(new PrintStream(outputStream));
	}

	@Test
	void testInt() {
		final Expression e1 = new IntExpression(1);
		e1.accept(interpretor);
		assertTrue(interpretor.result() instanceof IntExpression);
		final IntExpression ie = interpretor.result();
		assertEquals(1, ie.getValue());
		assertEquals(1, interpretor.stackSize());
	}

	@Test
	void testAddition() {
		final Expression e1 = new IntExpression(3);
		final Expression e2 = new IntExpression(4);
		final Expression addition = new AdditionExpression(e1, e2);
		addition.accept(interpretor);
		assertTrue(interpretor.result() instanceof IntExpression);
		final IntExpression ie = interpretor.result();
		assertEquals(ie.getValue(), 7);
		assertEquals(1, interpretor.stackSize());
	}

	@Test
	void testSubtraction() {
		final Expression e1 = new IntExpression(5);
		final Expression e2 = new IntExpression(3);
		final Expression subtraction = new SubtractionExpression(e1, e2);
		subtraction.accept(interpretor);
		final IntExpression ie = interpretor.result();
		assertEquals(2, ie.getValue());
		assertEquals(1, interpretor.stackSize());
	}

	@Test
	void testDivision() {
		final Expression e1 = new IntExpression(8);
		final Expression e2 = new IntExpression(4);
		final Expression division = new DivisionExpression(e1, e2);
		division.accept(interpretor);
		final IntExpression ie = interpretor.result();
		assertEquals(2, ie.getValue());
		assertEquals(1, interpretor.stackSize());
	}

	@Test
	void testMultiplication() {
		final Expression e1 = new IntExpression(4);
		final Expression e2 = new IntExpression(3);
		final Expression multiplication = new MultiplicationExpression(e1, e2);
		multiplication.accept(interpretor);
		final IntExpression ie = interpretor.result();
		assertEquals(ie.getValue(), 12);
		assertEquals(1, interpretor.stackSize());
	}

	@Test
	void testVariable() {
		final Variable v1 = new Variable("v1");
		final Variable v2 = new Variable("v2");
		newVariable(4, v1, new IntExpression(4));
		newVariable(5, v2, new AdditionExpression(new VariableExpression(v1), new IntExpression(1)));
	}

	@Test
	void testPrintln() {
		final Variable v1 = new Variable("v1");
		newVariable(6, v1, new MultiplicationExpression(new IntExpression(2), new IntExpression(3)));
		printLn("7", new AdditionExpression(new VariableExpression(v1), new IntExpression(1)));
	}

	protected void newVariable(final int expected, final Variable variable, final Expression value) {
		final Statement assignment = new AssignmentStatement(variable, value);
		final Expression actual = new VariableExpression(variable);

		assignment.accept(interpretor);
		actual.accept(interpretor);
		assertEquals(expected, interpretor.result().getValue());
		assertEquals(1, interpretor.stackSize());

		// Clean stack to remove not used value in stack due to the equal test
		interpretor.cleanStack();
	}

	protected void printLn(final String expected, final Expression expression) {
		final Statement printLn = new PrintLnStatement(expression);
		printLn.accept(interpretor);
		assertEquals(expected, outputStream.toString());
		assertEquals(0, interpretor.stackSize());
	}

	protected StackInterpretor interpretor;
	protected TestOutputStream outputStream;
}
