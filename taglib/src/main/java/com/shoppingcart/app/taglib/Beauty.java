package com.shoppingcart.app.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Beauty extends SimpleTagSupport {
	
@Override
	public void doTag() throws JspException, IOException {
	
		 PageContext cntx= (PageContext)getJspContext();
		 cntx.getOut().write("Hello from this Tag");
		
	}	

}
