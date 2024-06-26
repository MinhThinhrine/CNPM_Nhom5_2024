package vn.edu.hcmuaf.fit.bookingcoffeetable.controller.admin;

import vn.edu.hcmuaf.fit.bookingcoffeetable.service.ProductService;
import vn.edu.hcmuaf.fit.bookingcoffeetable.service.ReservationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "DashBoardController", value = "/admin/dashboard")
public class DashBoardController extends HttpServlet {
    ReservationService reservationService;
    ProductService productService;

    public DashBoardController() {
        reservationService = ReservationService.getInstance();
        productService = ProductService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationCount = reservationService.count();
        double cost = reservationService.getTotalPrice();
        int seatCount = reservationService.getPeople();
        int totalProduct = Integer.parseInt(productService.totalItem());

        request.setAttribute("reservationCount", reservationCount);
        request.setAttribute("cost", cost);
        request.setAttribute("seatCount", seatCount);
        request.setAttribute("totalProduct", totalProduct);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/home.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
