package poly.importExcel;


import poly.DAO.ProductsDAO;
import poly.Entity.Products;
import poly.Utils.ReadExcel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet(name = "importExcelServlet", value = "/importExcelServlet")
public class importExcelServlet extends HttpServlet {
    ProductsDAO productsDAO;

    public importExcelServlet() {
        productsDAO = new ProductsDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            File dir = new File("/uploadImport");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("file_import");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            String absolute = photoFile.getAbsolutePath();
            List<Products> list = ReadExcel.readExcel(absolute);
            System.out.println(absolute);
            productsDAO.insertExcel(list);
            System.out.println("OK");
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/assignmentJava4_v1_war_exploded/ProductServlet");

    }
}
