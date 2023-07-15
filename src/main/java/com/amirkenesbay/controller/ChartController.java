package com.amirkenesbay.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ChartController {

    @GetMapping("/chart")
    public void generateChart(HttpServletResponse response) throws IOException {
        // Создайте набор данных для графика
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(20, "Series 1", "Category 2");
        dataset.addValue(30, "Series 1", "Category 3");
        dataset.addValue(40, "Series 1", "Category 4");
        dataset.addValue(50, "Series 1", "Category 5");

        // Создайте график с использованием набора данных
        JFreeChart chart = ChartFactory.createBarChart(
                "График",   // Заголовок графика
                "Категории",  // Метка оси X
                "Значения",  // Метка оси Y
                dataset  // Набор данных
        );

        // Сгенерируйте график в формате PNG и отправьте его в HttpServletResponse
        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
    }
}
