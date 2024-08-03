import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

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

public class QRCodeGenerator {

    // Thay đổi đường dẫn lưu mã QR tại đây
    private static final String QR_CODE_IMAGE_PATH = "/your/new/path/QR_";

    public static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=your_database;encrypt=true;trustServerCertificate=true";
        String jdbcUsername = "your_username";
        String jdbcPassword = "your_password";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            // Fetch customer codes from the khachhang table
            String fetchCustomersSQL = "SELECT makh FROM khachhang";
            PreparedStatement fetchCustomersStmt = connection.prepareStatement(fetchCustomersSQL);
            ResultSet resultSet = fetchCustomersStmt.executeQuery();

            // Prepare SQL for inserting QR code paths into ma_qr table
            String insertQRCodeSQL = "INSERT INTO ma_qr (makh, qr_path) VALUES (?, ?)";
            PreparedStatement insertQRCodeStmt = connection.prepareStatement(insertQRCodeSQL);

            while (resultSet.next()) {
                String maKhachHang = resultSet.getString("makh");
                String qrCodeFilePath = QR_CODE_IMAGE_PATH + maKhachHang + ".png";

                // Generate the QR code image
                generateQRCodeImage(maKhachHang, 350, 350, qrCodeFilePath);
                System.out.println("Mã QR cho " + maKhachHang + " đã được tạo và lưu tại: " + qrCodeFilePath);

                // Insert the QR code path into the ma_qr table
                insertQRCodeStmt.setString(1, maKhachHang);
                insertQRCodeStmt.setString(2, qrCodeFilePath);
                insertQRCodeStmt.executeUpdate();
            }

            System.out.println("Quá trình tạo và lưu mã QR hoàn thành.");
        } catch (SQLException | WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
