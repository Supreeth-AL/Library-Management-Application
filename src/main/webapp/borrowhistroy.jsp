<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lib.model.Model"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Borrow books from Library</title>
    <link rel="icon" type="icon" href="images/poland.png">
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="borrowhistroy.css">
</head>

<body>
    <header>Public Library</header>
    <div class="outline">
        <div class="borrowhistroy">
            <div class="form-input">
                <div class="title">
                    <h3>Book are available in section</h3>
                </div>
                <div class="form-items">
                    <table>
                        <tr>
                            <th>Book ID</th>
                            <th>Book Name</th>
                            <th>Author</th>
                            <th>Borrow Date</th>
                        </tr>
                        <%
                        List<Model> borrowhistorys = (List<Model>) session.getAttribute("borrowhistorys");

                            if (borrowhistorys != null && !borrowhistorys.isEmpty()) {
                                for (Model borrowhistory : borrowhistorys) {
                            %>

                        <tr>
                            <td><%=borrowhistory.getBorBookId()%></td>
                            <td><%=borrowhistory.getBorBookname()%></td>
                            <td><%=borrowhistory.getBorAuthor()%></td>
                            <td><%=borrowhistory.getBorHistory()%></td>
                        </tr>
                        <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="4">No borrow history details are available</td>
                </tr>
                <%
                }
                %>
                    </table>
                </div>
                <div class="buttons">
                    <button type="button" onclick="location.href='manage.html'">Back</button>
                </div>
            </div>
        </div>
    </div>

</body>

</html>