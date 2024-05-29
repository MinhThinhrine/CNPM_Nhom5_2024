package vn.edu.hcmuaf.fit.bookingcoffeetable.json;

import com.google.gson.Gson;
import vn.edu.hcmuaf.fit.bookingcoffeetable.bean.Table;
import vn.edu.hcmuaf.fit.bookingcoffeetable.paging.PageRequest;
import vn.edu.hcmuaf.fit.bookingcoffeetable.service.TableService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "table-json", urlPatterns = {"/tables"}, initParams = {
        @WebInitParam(name = "page-index", value = "1"),
        @WebInitParam(name = "per-page", value = "9")
})
public class TableAPI extends HttpServlet {
    private TableService tableService;
    private List<Table> tables;
    private String json;
    private double fromPrice = 0, toPrice = 100;
    int pageIndexNum = 1;
    int perPageNum = 9;

    int count = 0;



    PageRequest pageRequest = null;

    public TableAPI() {
        tableService = TableService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String countNum = request.getParameter("count");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");

        try {

            if (countNum != null && !countNum.equals("")) {
                count = Integer.parseInt(countNum);
            }


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(startTime + " " + endTime);

        // findTable(startTime, endTime, count)
        // Lấy danh sách tables từ TableService qua phương thức getTables(startTime, endTime, count)
        tables = tableService.getTables(startTime, endTime, count);

        if (tables != null) {
            json = new Gson().toJson(tables);
            PrintWriter out = response.getWriter();
            try {
                out.println(json);
            } finally {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
