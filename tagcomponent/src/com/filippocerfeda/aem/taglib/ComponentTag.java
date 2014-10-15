package com.filippocerfeda.aem.taglib;

import static java.lang.String.format;
import static javax.servlet.jsp.PageContext.PAGE_SCOPE;

import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ComponentTag extends BodyTagSupport {

    private static final long serialVersionUID = -3053442348542612345L;
    private String logic;
    private String var;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ComponentTag.class);

    public ComponentTag() {

    }

    @Override
    public int doStartTag() throws JspException {
        try {
            Object component = instantiate(this.logic, pageContext);
            pageContext.setAttribute(var, component, PAGE_SCOPE);
        } catch (JspException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return EVAL_BODY_BUFFERED;
    }

    @SuppressWarnings("unchecked")
    private <T extends ComponentLogic> T instantiate(String logic,
            PageContext pageContext) throws JspException {
        
        try {
            Class<?> clazz = Class.forName(logic);
            Constructor<?> constructor = clazz.getConstructor();  
            return (T) constructor.newInstance();

        } 
        catch (Exception e) {
            throw new JspException(format(
                    "unable to create component block of  '%s'",
                    logic), e);
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        BodyContent bodyContent;
        JspWriter out;
        try {
            bodyContent = getBodyContent();
            out = bodyContent.getEnclosingWriter();
            out.print(bodyContent.getString());
        } catch (IOException ioe) {
            LOGGER.debug(ioe.getMessage());
        } finally {
            bodyContent = null;
            out = null;
        }
        return SKIP_BODY;
    }

    /**
     * @param var
     */
    public void setVar(String var) {
        this.var = var;
    }

    /**
     * @param model
     */
    public void setLogic(String logic) {
        this.logic = logic;
    }

}