package ua.kharkov.testtask.servlets.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kharkov.testtask.servlets.filter.IndexPageFilter;
import static org.mockito.Mockito.*;

public class IndexPageFilterMockitoTest extends TestCase {

	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	FilterChain chain;
	
	@Mock
	FilterConfig fc;	

	@Mock
	RequestDispatcher rd;

	@Before
	protected void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRefresh() throws ServletException, IOException {
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new IndexPageFilter().destroy();
		new IndexPageFilter().doFilter(request, response, chain);	
		new IndexPageFilter().init(fc);
		verify(rd).forward(request, response);
	}

}
