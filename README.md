# CRUD_JDBC_Servlet
-	Take any DBMS which you familiar with (MySQL, PostgreSQL, FireBird).
-	Create a table with several columns with different types including char, varchar, numeric, date, etc.
-	Fill the table with some data
-	Use your favorite IDE to create a web-application. Eclipse IDE is preferred.
-	Use your favorite application server as a runtime for your application. Use your favorite technique to access DB from your application – JDBC/JPA/Hibernate/SpringORM or something else. To access the DB use an application server’s connection pool.
-	Create page in JSP or JSF technology (Struts or Spring MVC is possible too) with datagrid and three buttons “refresh”,  “edit”, “delete”
o	by page opening the datagrip should be filled with data from DB
o	the datagrid should contain checkboxes for every rows to provide multiple selection of datagrid’s rows
o	by clicking button  “refresh” the application should reload the data from DB in page’s datagrip
o	by clicking button  “delete” the application should delete all data rows selected in the datagrid and  refresh the datagrip with actual content 
o	by clicking button “edit” another page should be opened to edit data selected in the grid or add new data in the DB table
	if more than one rows were selected show the popup window with a message like “please select just one row to be edited”
	if not any row is selected the edit page should be opened without button “Save” showing.
	If exactly one row is selected the edit page should be opened without button “Add” showing.
-	Edit page should contain several controls to edit selected row and three buttons “Add”, “Save” and “Cancel”
o	by clicking button “Save” the edit page should be closed, changed data should be updated in DB and first page should be shown with refreshed data.
o	by clicking button “Add” the edit page should be closed, data should be added in DB and first page should be shown with refreshed data.
o	by clicking “Cancel” button the edit page should be closed and first page should be shown with refreshed data.
-	Use ant build script to create war-file to be deployed
-	
A plus is:
- use of some components library
- use of custom taglibs 
- use of spring framework is plus
- use of Ajax technology
- applying CSS 

