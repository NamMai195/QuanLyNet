import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallStoredProcedures {
    public static void main(String[] args) {
         String url="jdbc:sqlserver://localhost:1433;databaseName=qlqn1;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String password = "123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Gọi các stored procedure
            callStoredProcedure(conn, "sp_PlayHoursByDay");
            callStoredProcedure(conn, "sp_PlayHoursByMonth");
            callStoredProcedure(conn, "sp_PlayHoursByYear");
            callStoredProcedure(conn, "sp_FoodSoldByDay");
            callStoredProcedure(conn, "sp_FoodSoldByMonth");
            callStoredProcedure(conn, "sp_FoodSoldByYear");
            callStoredProcedure(conn, "sp_RevenueByDay");
            callStoredProcedure(conn, "sp_RevenueByMonth");
            callStoredProcedure(conn, "sp_RevenueByYear");
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
    }

    private static void callStoredProcedure(Connection conn, String procedureName) {
        try (CallableStatement stmt = conn.prepareCall("{call " + procedureName + "}")) {
            boolean hasResultSet = stmt.execute();
            
            // Xử lý kết quả trả về
            if (hasResultSet) {
                try (ResultSet rs = stmt.getResultSet()) {
                    while (rs.next()) {
                        // Thay đổi để phù hợp với kết quả trả về của từng procedure
                        if (procedureName.equals("sp_PlayHoursByDay")) {
                            System.out.printf("Day: %s, Total Hours: %.2f, Min Hours: %.2f, Max Hours: %.2f, Avg Hours: %.2f%n",
                                              rs.getDate("Day"),
                                              rs.getDouble("TotalHours"),
                                              rs.getDouble("MinHours"),
                                              rs.getDouble("MaxHours"),
                                              rs.getDouble("AvgHours"));
                        }
                        // Thêm điều kiện cho các stored procedure khác
                        // ...
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
