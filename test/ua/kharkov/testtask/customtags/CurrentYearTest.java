package ua.kharkov.testtask.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.junit.Test;
import org.mockito.Mockito;

import ua.kharkov.testtask.customtags.CurrentYear;

public class CurrentYearTest {	
	
	@Test
	public void test() throws JspException, IOException {
		CurrentYear cy = new CurrentYear();         
        PageContext pageContext = Mockito.mock(PageContext.class);  
        JspWriter jspWriter = Mockito.mock(JspWriter.class);  
        Mockito.when( pageContext.getOut() ).thenReturn(jspWriter);  
        cy.setJspContext(pageContext);  
        cy.doTag();  
	}	
	
}
