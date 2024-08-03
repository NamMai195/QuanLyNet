package com.netsys.dao;

import com.netsys.utlis.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Thống kê số giờ chơi theo ngày
    public List<Object[]> getPlayHoursByDay() {
        String sql = "{CALL sp_PlayHoursByDay}";
        String[] cols = {"Day", "TotalHours", "MinHours", "MaxHours", "AvgHours"};
        return getListOfArray(sql, cols);
    }

    // Thống kê số giờ chơi theo tháng
    public List<Object[]> getPlayHoursByMonth() {
        String sql = "{CALL sp_PlayHoursByMonth}";
        String[] cols = {"Year", "Month", "TotalHours", "MinHours", "MaxHours", "AvgHours"};
        return getListOfArray(sql, cols);
    }

    // Thống kê số giờ chơi theo năm
    public List<Object[]> getPlayHoursByYear() {
        String sql = "{CALL sp_PlayHoursByYear}";
        String[] cols = {"Year", "TotalHours", "MinHours", "MaxHours", "AvgHours"};
        return getListOfArray(sql, cols);
    }

    // Thống kê lượng mua sản phẩm theo ngày
    public List<Object[]> getFoodSoldByDay() {
        String sql = "{CALL sp_FoodSoldByDay}";
        String[] cols = {"Day", "TotalFoodSold", "MinFoodSold", "MaxFoodSold", "AvgFoodSold"};
        return getListOfArray(sql, cols);
    }

    // Thống kê lượng mua sản phẩm theo tháng
    public List<Object[]> getFoodSoldByMonth() {
        String sql = "{CALL sp_FoodSoldByMonth}";
        String[] cols = {"Year", "Month", "TotalFoodSold", "MinFoodSold", "MaxFoodSold", "AvgFoodSold"};
        return getListOfArray(sql, cols);
    }

    // Thống kê lượng mua sản phẩm theo năm
    public List<Object[]> getFoodSoldByYear() {
        String sql = "{CALL sp_FoodSoldByYear}";
        String[] cols = {"Year", "TotalFoodSold", "MinFoodSold", "MaxFoodSold", "AvgFoodSold"};
        return getListOfArray(sql, cols);
    }

    // Thống kê doanh thu theo ngày
    public List<Object[]> getRevenueByDay() {
        String sql = "{CALL sp_RevenueByDay}";
        String[] cols = {"Day", "TotalPCRevenue", "TotalFoodRevenue", "TotalRevenue", 
                         "MinPCRevenue", "MaxPCRevenue", "AvgPCRevenue", 
                         "MinFoodRevenue", "MaxFoodRevenue", "AvgFoodRevenue"};
        return getListOfArray(sql, cols);
    }

    // Thống kê doanh thu theo tháng
    public List<Object[]> getRevenueByMonth() {
        String sql = "{CALL sp_RevenueByMonth}";
        String[] cols = {"Year", "Month", "TotalPCRevenue", "TotalFoodRevenue", "TotalRevenue", 
                         "MinPCRevenue", "MaxPCRevenue", "AvgPCRevenue", 
                         "MinFoodRevenue", "MaxFoodRevenue", "AvgFoodRevenue"};
        return getListOfArray(sql, cols);
    }

    // Thống kê doanh thu theo năm
    public List<Object[]> getRevenueByYear() {
        String sql = "{CALL sp_RevenueByYear}";
        String[] cols = {"Year", "TotalPCRevenue", "TotalFoodRevenue", "TotalRevenue", 
                         "MinPCRevenue", "MaxPCRevenue", "AvgPCRevenue", 
                         "MinFoodRevenue", "MaxFoodRevenue", "AvgFoodRevenue"};
        return getListOfArray(sql, cols);
    }
}
