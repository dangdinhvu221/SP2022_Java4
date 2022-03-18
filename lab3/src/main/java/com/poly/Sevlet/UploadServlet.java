package com.poly.Sevlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/upload/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadFoder = request.getServletContext().getRealPath("/uploads");
        Path uploadPath = Paths.get(uploadFoder);
        System.out.println(uploadFoder);

        if(!Files.exists(uploadPath)) {
            Files.createDirectory(uploadPath);
        }

        Part partImg = request.getPart("image");
        String filename = Path.of(partImg.getSubmittedFileName()).getFileName().toString();

        Part partDoc = request.getPart("document");
        String document = Path.of(partDoc.getSubmittedFileName()).getFileName().toString();


        partImg.write(Paths.get(uploadPath.toString(), filename).toString());
        partDoc.write(Paths.get(uploadPath.toString(), document).toString());

        request.setAttribute("image", filename);
        request.setAttribute("document", document);

        request.getRequestDispatcher("view/upload/result.jsp").forward(request,response);
    }
}
