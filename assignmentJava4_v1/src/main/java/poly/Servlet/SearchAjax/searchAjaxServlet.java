package poly.Servlet.SearchAjax;

import poly.DAO.CategoriesDAO;
import poly.DAO.UsersDAO;
import poly.Entity.Category;
import poly.Entity.Users;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchAjaxServlet", value = "/searchAjaxServlet")
public class searchAjaxServlet extends HttpServlet {
    private UsersDAO dao;

    public searchAjaxServlet() {
        dao = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String key = request.getParameter("search");
        List<Users> list = dao.findKeyword(key);
        request.setAttribute("ListCategory", list);
        PrintWriter out = response.getWriter();
//        request.setAttribute("tableUsers", "/views/admin/ManagerUser/tableUser.jsp");
//        for (Users u : list) {
//            String gender = u.getGender() == true?"Male":"Female";
//            String role = u.getRole() == true?"Admin":"User";
//            String status = u.getStatus() == true?"Online":"Offline";
//
//            out.println("<div class=\" table-responsive\">\n" +
//                    "    <table class=\"table table-bordered table-hover sortable\">\n" +
//                    "        <thead class=\"table-dark\">\n" +
//                    "        <tr>\n" +
//                    "            <th>Username</th>\n" +
//                    "            <th>FullName</th>\n" +
//                    "            <th>Email</th>\n" +
//                    "            <th>Address</th>\n" +
//                    "            <th>Phone Number</th>\n" +
//                    "            <th>Gender</th>\n" +
//                    "            <th>Birth Day</th>\n" +
//                    "            <th>Role</th>\n" +
//                    "            <th>Avatar</th>\n" +
//                    "            <th>Status</th>\n" +
//                    "            <th colspan=\"2\">Manipulation</th>\n" +
//                    "        </tr>\n" +
//                    "        </thead>\n" +
//                    "        <tbody id=\"content\">\n" +
//                    "        <c:forEach items=\"${listUsers}\" var=\"user\">\n" +
//                    "            <tr>\n" +
//                    "                <td>"+u.getUsername()+"</td>\n" +
//                    "                <td>"+u.getFullName()+"</td>\n" +
//                    "                <td>"+u.getEmail()+"</td>\n" +
//                    "                <td>"+u.getAddress()+"</td>\n" +
//                    "                <td>"+u.getPhone()+"</td>\n" +
//                    "                <td>"+gender+"</td>\n" +
//                    "                <td>"+u.getCreated()+"</td>\n" +
//                    "                <td>"+role+"</td>\n" +
//                    "                <td><img src=\"uploads/"+u.getAvatar()+"\" class=\"img-thumbnail rounded\" width=\"50px\" height=\"50px\"\n" +
//                    "                         alt=\"\"></td>\n" +
//                    "                <td>"+status+"</td>\n" +
//                    "                <td>\n" +
//                    "                    <a href=\"AdminServlet/editUser\"\n" +
//                    "                       class=\"btn btn-outline-secondary fw-bold\">Edit</a>\n" +
//                    "                </td>\n" +
//                    "                <td>\n" +
//                    "                    <button type=\"button\"\n" +
//                    "                            class=\"btn btn-outline-danger fw-bold \" id=\"deleteUser\" onclick=\"alertWarningDelete()\">\n" +
//                    "                        Delete\n" +
//                    "                    </button>\n" +
//                    "                </td>\n" +
//                    "            </tr>\n" +
//                    "            <script>\n" +
//                    "                var alertWarningDelete = document.querySelector(\"#deleteUser\");\n" +
//                    "                alertWarningDelete = function () {\n" +
//                    "                    Swal.fire({\n" +
//                    "                        title: 'Warning?',\n" +
//                    "                        text: \"Do you want to delete this user?!\",\n" +
//                    "                        icon: 'warning',\n" +
//                    "                        showCancelButton: true,\n" +
//                    "                        confirmButtonColor: '#3085d6',\n" +
//                    "                        cancelButtonColor: '#dd3333',\n" +
//                    "                        confirmButtonText: '<a href=\"AdminServlet/deleteUser?id=${user.id}\" class = \"text-light\">Yes, Delete it!</a>'\n" +
//                    "                    })\n" +
//                    "                }\n" +
//                    "            </script>\n" +
//                    "        </c:forEach>\n" +
//                    "        </tbody>\n" +
//                    "    </table>\n" +
//                    "</div>");
//        }
//        request.setAttribute("views", "/views/admin/ManagerCategory/tableCategory.jsp");
//        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
//            response.sendRedirect("/assignmentJava4_v1_war_exploded/AdminServlet/searchUser");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void doSearchUser(HttpServletRequest request, HttpServletResponse response) {

    }
}
