package edu.ubo.minimachine.tests.utils;

import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream extends OutputStream {

	public TestOutputStream() {
		this.builder = new StringBuilder();
	}

	@Override
	public void write(int b) throws IOException {
		this.builder.append(Character.toString(b));
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		this.builder.append(new String(b, off, len));
	}
	
	@Override
	public String toString() {
		return builder.toString().trim();
	}

	protected final StringBuilder builder;
}
