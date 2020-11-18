package edu.ubo.minimachine.tests.visitor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ubo.minimachine.Variable;
import edu.ubo.minimachine.expression.*;
import edu.ubo.minimachine.statement.AssignmentStatement;
import edu.ubo.minimachine.statement.PrintLnStatement;
import edu.ubo.minimachine.statement.Statement;
import edu.ubo.minimachine.tests.utils.TestOutputStream;
import edu.ubo.minimachine.visitor.StackInterpretor;

class StackInterpretorTest {
	StackInterpretor interpretor;
	TestOutputStream outputStream;

	@BeforeEach
	void setUp() throws Exception {
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
	}
	
	@Test
	void testSubtraction() {
		final Expression e1 = new IntExpression(5);
		final Expression e2 = new IntExpression(3);
		final Expression subtraction = new SubtractionExpression(e1, e2);
		subtraction.accept(interpretor);
		final IntExpression ie = interpretor.result();
		assertEquals(2, ie.getValue());
	}
	
	@Test
	void testDivision() {
		final Expression e1 = new IntExpression(8);
		final Expression e2 = new IntExpression(4);
		final Expression division = new DivisionExpression(e1, e2);
		division.accept(interpretor);
		final IntExpression ie = interpretor.result();
		assertEquals(2, ie.getValue());
	}
	
	@Test
	void testMultiplication() {
		final Expression e1 = new IntExpression(4);
		final Expression e2 = new IntExpression(3);
		final Expression multiplication = new MultiplicationExpression(e1, e2);
		multiplication.accept(interpretor);
		final IntExpression ie = interpretor.result();
		assertEquals(ie.getValue(), 12);
	}
	
	@Test
	void testVariable() {
		final Variable v1 = new Variable("v1");
		final AssignmentStatement v1As = new AssignmentStatement(v1, new IntExpression(4));
		v1As.accept(interpretor);
		assertEquals(interpretor.result().getValue(), 4);
		final Variable v2 = new Variable("v2");
		final AssignmentStatement v2As = new AssignmentStatement(v2, new AdditionExpression(new VariableExpression(v1), new IntExpression(1)));
		v2As.accept(interpretor);
		assertEquals(5, interpretor.result().getValue());
		final Statement printLn = new PrintLnStatement(new AdditionExpression(new VariableExpression(v2), new IntExpression(1)));
		printLn.accept(interpretor);
		assertEquals("6", outputStream.toString());
	}

}
