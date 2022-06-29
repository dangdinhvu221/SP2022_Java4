package poly.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import poly.Entity.Category;
import poly.Entity.Products;
import poly.Entity.Supplier;

public class ReadExcel {
    public static final int COLUMN_INDEX_NAME = 0;
    public static final int COLUMN_INDEX_CATEGORY = 1;
    public static final int COLUMN_INDEX_SUPPLIER = 2;
    public static final int COLUMN_INDEX_QUANTITY = 3;
    public static final int COLUMN_INDEX_PRICE = 4;
    public static final int COLUMN_INDEX_COLOR = 5;
    public static final int COLUMN_INDEX_SIZE = 6;
    public static final int COLUMN_INDEX_IMAGE = 7;
    public static final int COLUMN_INDEX_DES = 8;

    public static void main(String[] args) throws IOException {
        final String excelFilePath = "D:/Book1.xlsx";
        final List<Products> books = readExcel(excelFilePath);
        for (Products book : books) {
            System.out.println(book.getNameProduct());
        }
    }

    public static List<Products> readExcel(String excelFilePath) throws IOException {
        List<Products> listBooks = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(excelFilePath);

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        for (Row nextRow : sheet) {
            //note
//            if (nextRow.getRowNum() == 0) {
//                // Ignore header
//                continue;
//            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            Products book = new Products();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_NAME:
//                        book.setNameProduct((String) getCellValue(cell));
//                        break;
                    case COLUMN_INDEX_CATEGORY:
//                        Category c = new Category();
//                        c.setId(new BigDecimal((Integer) cellValue).intValue());
//                        book.setCategoryByCategoryId(c);
//                        break;
                    case COLUMN_INDEX_SUPPLIER:
                        Supplier s = new Supplier();
                        s.setId(new BigDecimal((Integer) cellValue).intValue());
                        book.setSupplierBySupplierId(s);
                        break;
                    case COLUMN_INDEX_PRICE:
                        book.setPrice(new BigDecimal((Integer) cellValue).intValue());
                        break;

                    case COLUMN_INDEX_IMAGE:
                        book.setImageProduct((String) getCellValue(cell));
                        break;

                    case COLUMN_INDEX_SIZE:
                        book.setSize((String) getCellValue(cell));
                        break;

                    case COLUMN_INDEX_COLOR:
                        book.setColor((String) getCellValue(cell));
                        break;

                    case COLUMN_INDEX_DES:
                        book.setDescription((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_QUANTITY:
                        book.setQuantity(new BigDecimal((Integer) cellValue).intValue());
                        break;
                    default:
                        break;
                }

            }
            listBooks.add(book);
        }

        workbook.close();
        inputStream.close();

        return listBooks;
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            default:
                break;
        }

        return cellValue;
    }
}
