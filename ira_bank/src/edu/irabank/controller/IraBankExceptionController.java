package edu.irabank.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.security.access.AccessDeniedException;

@ControllerAdvice
public class IraBankExceptionController {
	
	// Logger for checking the errors.
	public static final Logger logger = Logger.getLogger(IraBankExceptionController.class);
	
	// Add as many as classes
	@ExceptionHandler(value = 
			{
			Exception.class, 
			NullPointerException.class,
		    NoSuchRequestHandlingMethodException.class, 
		    RuntimeException.class,
		    ResourceAccessException.class,
		    AccessDeniedException.class,
		    ConstraintViolationException.class}
			)
    public ModelAndView globalErrorHandler(ModelMap model, HttpServletRequest request, Exception e) {
            logger.error(e.getStackTrace());
            return new ModelAndView("common/Exception",model);
	}
}
