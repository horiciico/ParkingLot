package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CarDTO;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<CarDTO> cars = carsBean.findAllCars();
        request.setAttribute("cars", cars);

        request.setAttribute("numberOfFreeParkingSpots", 10);
        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] carIdStrings = request.getParameterValues("car_ids");
        if (carIdStrings != null) {
            List<Long> ids = new ArrayList<>();
            for (String idStr : carIdStrings) {
                ids.add(Long.parseLong(idStr));
            }
            carsBean.deleteCarsByIds(ids);
        }

        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}
