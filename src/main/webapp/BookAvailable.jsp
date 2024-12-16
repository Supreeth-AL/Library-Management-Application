<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lib.model.Model"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Available</title>
    <link rel="icon" type="icon" href="images/poland.png">
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="BookAvailable.css">
</head>

<body>
    <header>Public Library</header>
    <div class="outline">
        <div class="bookavailabel">
            <div class="form-input">
                <div class="title">
                    <h3>Available Book</h3>
                </div>
                <table>
                    <tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>author</th>
                        <th>copies</th>
                    </tr>
                    <%
                    List<Model> books = (List<Model>) session.getAttribute("books"); // Retrieve the staff list from session
            
                    if (books != null && !books.isEmpty()) {
                        for (Model book : books) {
                    %>

                    <tr>
                        <td>
                            <%=book.getBookid()%>
                        </td>
                        <td>
                            <%=book.getBname()%>
                        </td>
                        <td>
                            <%=book.getAuthor()%>
                        </td>
                        <td>
                            <%=book.getCopies()%>
                        </td>
                    </tr>
                    <%
                }
                } else {
                %>
                    <tr>
                                                <td colspan="4">No Books details are available</td>
                                            </tr>
                                            <%
                                        }
                                        %>


                </table>
            </div>

            <div class="buttons">
                <button onclick="location.href='Destop.html'" value="back">Back</button>
                <div class="addandremove">
                    <button onclick="location.href='addbooklibrary.html'" value="addbook">Add Book</button>

                    <button onclick="location.href='deletebooklibrary.html'" value="deletebook">Delete Book</button>
                </div>
            </div>
        </div>
    </div>

</body>

</html>