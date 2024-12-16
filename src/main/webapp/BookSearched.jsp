<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.lib.model.Model" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Search Result</title>
                <link rel="icon" type="icon" href="images/poland.png">
                <link rel="stylesheet" href="main.css">
                <link rel="stylesheet" href="BookSearched.css">
            </head>

            <body>
                <header>Public Library</header>
                <div class="outline">
                    <div class="BookSearched">
                        <div class="form-input">
                            <div class="title">
                                <h3>Available Books</h3>
                            </div>
                            <div class="form-items">
                                <table>
                                    <tr>
                                        <th>Book Id</th>
                                        <th>Book Name</th>
                                        <th>Author</th>
                                    </tr>
                                    <% List<Model> bsearch = (List<Model>) session.getAttribute("bsearch");

                                            if (bsearch != null && !bsearch.isEmpty()) {
                                            for (Model bsearch1 : bsearch) {
                                            %>

                                            <tr>
                                                <td>
                                                    <%= bsearch1.getBookid() %>
                                                </td>
                                                <td>
                                                    <%= bsearch1.getBname() %>
                                                </td>
                                                <td>
                                                    <%= bsearch1.getAuthor() %>
                                                </td>
                                            </tr>
                                            <% } } else { %>
                                                <tr>
                                                    <td colspan="3">No book details are available</td>
                                                </tr>
                                                <% } %>
                                </table>
                            </div>
                            <div class="buttons">
                                <button type="button" onclick="location.href='booksearch.html'">Back</button>
                            </div>
                        </div>
                    </div>
                </div>

            </body>

            </html>