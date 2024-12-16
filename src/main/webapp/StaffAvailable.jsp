<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.lib.model.Model" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Staffs Details</title>
                <link rel="icon" type="icon" href="images/poland.png">
                <link rel="stylesheet" href="main.css">
                <link rel="stylesheet" href="StaffAvailabel.css">
            </head>

            <body>
                <header>Public Library</header>
                <div class="outline">
                    <div class="StaffAvailabel">
                        <div class="form-input">
                            <div class="title">
                                Staff Details
                            </div>

                            <div class="form-item">
                                <table>
                                    <tr>
                                        <th>Staff ID</th>
                                        <th>Staff Name</th>
                                        <th>Email</th>
                                        <th>Address</th>
                                        <th>Phone no</th>
                                    </tr>
                                    <% List<Model> staffs = (List<Model>) session.getAttribute("staffs");

                                            if (staffs != null && !staffs.isEmpty()) {
                                            for (Model staff : staffs) {
                                            %>

                                            <tr>
                                                <td>
                                                    <%= staff.getStaffid() %>
                                                </td>
                                                <td>
                                                    <%= staff.getSname() %>
                                                </td>
                                                <td>
                                                    <%= staff.getSemail() %>
                                                </td>
                                                <td>
                                                    <%= staff.getSaddress() %>
                                                </td>
                                                <td>
                                                    <%= staff.getSphoneno() %>
                                                </td>
                                            </tr>
                                            <% } } else { %>
                                                <tr>
                                                    <td colspan="5">No Staff deatails is available</td>
                                                </tr>
                                                <% } %>
                                </table>
                            </div>
                            <div class="buttons">
                                <button onclick="location.href='Destop.html'" value="back">Back</button>
                                <div class="addandremove">
                                    <button onclick="location.href='addstaff.html'" value="addstaff">Add Staff</button>

                                    <button onclick="location.href='removestaff.html'" value="deletestaff">Delete
                                        Staff</button>
                                </div>
                            </div>
                        </div>
                    </div>

            </body>

            </html>