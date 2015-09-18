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

import ua.kharkov.testtask.servlets.RefreshEditDelete;
import static org.mockito.Mockito.*;

public class RefreshEditDeleteMockitoTest extends TestCase {

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
	public void testRefresh() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Refresh");
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new RefreshEditDelete().doGet(request, response);
		verify(rd).forward(request, response);
	}
	
	@Test
	public void testDelete() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Delete");
		String[] userId = {"1"};
		when(request.getParameterValues("userId")).thenReturn(userId);
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new RefreshEditDelete().doGet(request, response);
	}
	
	@Test
	public void testDeleteElse() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Delete");
		String[] userId = null;
		when(request.getParameterValues("userId")).thenReturn(userId);
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new RefreshEditDelete().doGet(request, response);
	}
	
	
	
	@Test
	public void testEdit_() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Edit");
		String[] userId = null;
		when(request.getParameterValues("userId")).thenReturn(userId);
		when(request.getRequestDispatcher("edit.jsp")).thenReturn(rd);
		new RefreshEditDelete().doGet(request, response);
		verify(rd).forward(request, response);
	}
	
	@Test
	public void testEdit() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Edit");
		String[] userId = {"1", "2"};
		when(request.getParameterValues("userId")).thenReturn(userId);
		when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);
		new RefreshEditDelete().doGet(request, response);
	}
	
	@Test
	public void testEdit2() throws ServletException, IOException {
		when(request.getParameter("action")).thenReturn("Edit");
		String[] userIds = {"1"};
		String userId = "1";
		when(request.getParameterValues("userId")).thenReturn(userIds);
		when(request.getParameter("userId")).thenReturn(userId);
		when(request.getRequestDispatcher("edit.jsp")).thenReturn(rd);
		new RefreshEditDelete().doGet(request, response);
	}	
	

}
