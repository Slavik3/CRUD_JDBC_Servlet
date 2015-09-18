package ua.kharkov.testtask.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kharkov.testtask.servlets.Edit;
import static org.mockito.Mockito.*;

public class EditMockitoTest extends TestCase {

	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;

	@Mock
	RequestDispatcher rd;	

	@Before
	protected void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Save");
		when(request.getParameter("id")).thenReturn("2");		
		when(request.getParameter("name")).thenReturn("Amity");
		when(request.getParameter("surname")).thenReturn("Spencer");
		when(request.getParameter("email")).thenReturn("aspencer@gmail.com");
		when(request.getParameter("birthday")).thenReturn("2000-09-04");
		when(request.getParameter("amountOfMoney")).thenReturn("100000");
		when(request.getParameter("address")).thenReturn("204 N Market St Maryville, MO 64468");		
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new Edit().doGet(request, response);
	}
	
	@Test
	public void testAdd() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Add");
		when(request.getParameter("id")).thenReturn("2");		
		when(request.getParameter("name")).thenReturn("Amity");
		when(request.getParameter("surname")).thenReturn("Spencer");
		when(request.getParameter("email")).thenReturn("aspencer@gmail.com");
		when(request.getParameter("birthday")).thenReturn("2000-09-04");
		when(request.getParameter("amountOfMoney")).thenReturn("100000");
		when(request.getParameter("address")).thenReturn("204 N Market St Maryville, MO 64468");		
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new Edit().doGet(request, response);	
	}
	
	@Test
	public void testCancel() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Cancel");
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new Edit().doGet(request, response);	
	}

}
