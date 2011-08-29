package org.codeexample.common;
import java.io.Serializable;
public class OverflowException extends RuntimeException
		implements Serializable {
	private static final long serialVersionUID = 1L;
	public OverflowException() {
		this("");
	}
	public OverflowException(String msg) {
		super(msg);
	}
	public OverflowException(NumberFormatException e) {
		super(e);
	}
}