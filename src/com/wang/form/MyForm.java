package com.wang.form;

import javax.servlet.ServletRequest;
import java.util.logging.Logger;

public interface MyForm {
    public static Logger logger = Logger.getLogger("MyForm");
    public FormResult validate(ServletRequest servletRequest);
}
