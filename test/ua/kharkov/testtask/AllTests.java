package ua.kharkov.testtask;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.kharkov.testtask.connection.DBConnectionTest;
import ua.kharkov.testtask.customtags.CurrentYearTest;
import ua.kharkov.testtask.dao.UserDAOTest;
import ua.kharkov.testtask.dao.entity.UserTest;
import ua.kharkov.testtask.servlets.EditMockitoTest;
import ua.kharkov.testtask.servlets.RefreshEditDeleteMockitoTest;
import ua.kharkov.testtask.servlets.filter.IndexPageFilterMockitoTest;

@RunWith(Suite.class)
@SuiteClasses({ DBConnectionTest.class, UserDAOTest.class, UserTest.class, RefreshEditDeleteMockitoTest.class, EditMockitoTest.class, CurrentYearTest.class, IndexPageFilterMockitoTest.class })
public class AllTests {

}
