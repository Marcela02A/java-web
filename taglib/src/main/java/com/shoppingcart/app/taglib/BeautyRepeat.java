package com.shoppingcart.app.taglib;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BeautyRepeat extends SimpleTagSupport {
	private int beauty_;

	public void setBeauty(int beauty_) {
		this.beauty_ = beauty_;
	}

	@Override
	public void doTag() throws JspException, IOException {
		for (int i = 0; i < beauty_; i++) {
			getJspBody().invoke(null);
		}
	}
}
