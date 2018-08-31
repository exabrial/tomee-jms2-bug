package com.github.exabrial;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class XACancellingException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
