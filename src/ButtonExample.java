import com.netsys.dao.MayTinhDao;
import com.netsys.entity.mayTinh;
import com.netsys.gd.BookPCJDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        List<mayTinh> List=new MayTinhDao().selectAll();
        // Tạo danh sách các nút
        List<JButton> but = new ArrayList<>();
        but.add(new JButton("1"));
        but.add(new JButton("2"));
        but.add(new JButton("3"));
        
        // Gán sự kiện click cho từng nút
        List<mayTinh> listmt=new MayTinhDao().selectAll();
        int i=0;
        for (JButton button : but) {
            final int c=0;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BookPCJDialog book=new BookPCJDialog(null,true);
                    
                     book.setVisible(true);
                     for(mayTinh mt:listmt){
                        if(button.getText().equalsIgnoreCase(mt.getTenmt()))
                        book.loadtt(mt.getMamt());
                   
                    }
                    
                }
            });
            frame.add(button); // Thêm nút vào khung
        }

        frame.setLayout(null); // Thiết lập layout
        int yPosition = 20; // Vị trí Y ban đầu
        for (JButton button : but) {
            button.setBounds(50, yPosition, 200, 30); // Thiết lập kích thước và vị trí
            yPosition += 40; // Cập nhật vị trí Y cho nút tiếp theo
        }

        frame.setVisible(true); // Hiển thị khung
    }
}
