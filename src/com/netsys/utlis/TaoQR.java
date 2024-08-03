package com.netsys.utlis;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TaoQR {
    private static final String QR_CODE_IMAGE_PATH = "D:\\HOCTAP\\QR_QLN\\MKH_";

    // Tạo mã QR cho mã khách hàng
    public static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    // Tạo tất cả mã QR cho khách hàng trong cơ sở dữ liệu
    public static void generateAllQRCodes() {
        String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=qlqn1;encrypt=true;trustServerCertificate=true;";
        String jdbcUsername = "sa";
        String jdbcPassword = "123";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            String fetchCustomersSQL = "SELECT makh FROM khachhang";
            PreparedStatement fetchCustomersStmt = connection.prepareStatement(fetchCustomersSQL);
            ResultSet resultSet = fetchCustomersStmt.executeQuery();

            // Chuẩn bị SQL cho việc chèn hoặc cập nhật đường dẫn mã QR
            String insertOrUpdateQRCodeSQL = "IF EXISTS (SELECT 1 FROM ma_qr WHERE makh = ?) " +
                                              "UPDATE ma_qr SET qr_path = ? WHERE makh = ? " +
                                              "ELSE " +
                                              "INSERT INTO ma_qr (makh, qr_path) VALUES (?, ?)";
            PreparedStatement insertOrUpdateQRCodeStmt = connection.prepareStatement(insertOrUpdateQRCodeSQL);

            while (resultSet.next()) {
                String maKhachHang = resultSet.getString("makh");
                String qrCodeFilePath = QR_CODE_IMAGE_PATH + maKhachHang + ".png";

                // Tạo mã QR mới
                generateQRCodeImage(maKhachHang, 100, 100, qrCodeFilePath);
                System.out.println("Mã QR cho " + maKhachHang + " đã được tạo và lưu tại: " + qrCodeFilePath);

                // Chèn hoặc cập nhật đường dẫn mã QR vào cơ sở dữ liệu
                insertOrUpdateQRCodeStmt.setString(1, maKhachHang);
                insertOrUpdateQRCodeStmt.setString(2, qrCodeFilePath);
                insertOrUpdateQRCodeStmt.setString(3, maKhachHang);
                insertOrUpdateQRCodeStmt.setString(4, maKhachHang);
                insertOrUpdateQRCodeStmt.setString(5, qrCodeFilePath);
                insertOrUpdateQRCodeStmt.executeUpdate();
            }

            System.out.println("Quá trình tạo tất cả mã QR hoàn thành.");
        } catch (SQLException | WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    // Tạo hoặc cập nhật mã QR theo mã khách hàng
    public static void generateOrUpdateQRCodeForCustomer(String maKhachHang) {
        String qrCodeFilePath = QR_CODE_IMAGE_PATH + maKhachHang + ".png";
        File qrCodeFile = new File(qrCodeFilePath);

        try {
            // Nếu file mã QR đã tồn tại, xóa file cũ
            if (qrCodeFile.exists()) {
                qrCodeFile.delete();
            }

            // Tạo mã QR mới
            generateQRCodeImage(maKhachHang, 100, 100, qrCodeFilePath);
            System.out.println("Mã QR cho " + maKhachHang + " đã được tạo và lưu tại: " + qrCodeFilePath);

            // Cập nhật vào cơ sở dữ liệu
            updateQRCodePathInDatabase(maKhachHang, qrCodeFilePath);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateQRCodePathInDatabase(String maKhachHang, String qrCodeFilePath) {
        String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=qlqn1;encrypt=true;trustServerCertificate=true;";
        String jdbcUsername = "sa";
        String jdbcPassword = "123";

        String insertOrUpdateQRCodeSQL = "IF EXISTS (SELECT 1 FROM ma_qr WHERE makh = ?) " +
                                          "UPDATE ma_qr SET qr_path = ? WHERE makh = ? " +
                                          "ELSE " +
                                          "INSERT INTO ma_qr (makh, qr_path) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement insertOrUpdateQRCodeStmt = connection.prepareStatement(insertOrUpdateQRCodeSQL)) {

            insertOrUpdateQRCodeStmt.setString(1, maKhachHang);
            insertOrUpdateQRCodeStmt.setString(2, qrCodeFilePath);
            insertOrUpdateQRCodeStmt.setString(3, maKhachHang);
            insertOrUpdateQRCodeStmt.setString(4, maKhachHang);
            insertOrUpdateQRCodeStmt.setString(5, qrCodeFilePath);
            insertOrUpdateQRCodeStmt.executeUpdate();

            System.out.println("Đường dẫn mã QR đã được cập nhật trong cơ sở dữ liệu.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo tất cả mã QR
        generateAllQRCodes();

//        // Hoặc tạo/ cập nhật mã QR cho mã khách hàng cụ thể
//        // generateOrUpdateQRCodeForCustomer("MKH001"); // Thay "MKH001" bằng mã khách hàng cần tạo/ cập nhật
    }
}
