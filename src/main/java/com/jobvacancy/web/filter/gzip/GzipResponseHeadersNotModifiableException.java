package com.jobvacancy.web.filter.gzip;

import javax.servlet.ServletException;

public class GzipResponseHeadersNotModifiableException extends ServletException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8277145691292232815L;

	public GzipResponseHeadersNotModifiableException(String message) {
        super(message);
    }
}
