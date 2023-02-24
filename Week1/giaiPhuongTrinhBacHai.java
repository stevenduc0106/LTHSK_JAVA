package week1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class giaiPhuongTrinhBacHai extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton buttonGiai;
	private JButton buttonXoaRong;
	private JButton buttonThoat;
	private JTextField txtA = new JTextField();
	private JTextField txtB = new JTextField();
	private JTextField txtC = new JTextField();
	private JTextField KQ = new JTextField();
	

	public giaiPhuongTrinhBacHai() {
		setTitle("^.^");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createGUI();
	}

	private void createGUI() {
		JPanel panelNorth;
		add(panelNorth = new JPanel(), BorderLayout.NORTH);
		panelNorth.setBackground(Color.CYAN);
		JLabel lblTieuDe;
		panelNorth.add(lblTieuDe = new JLabel("Giải Phương Trình Bậc Hai"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));

		JPanel panelCenter;
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		panelCenter.setLayout(null);// Absolute layout

		JLabel lblNhapA, lblNhapB, lblNhapC, lblKetQua;
		panelCenter.add(lblNhapA = new JLabel("Nhập a: "));
		int x = 30, y = 30, width = 100, height = 30;
		lblNhapA.setBounds(x, y, width, height);

		panelCenter.add(lblNhapB = new JLabel("Nhập b: "));
		y += 50;
		lblNhapB.setBounds(x, y, width, height);

		panelCenter.add(lblNhapC = new JLabel("Nhập c: "));
		y += 50;
		lblNhapC.setBounds(x, y, width, height);

		panelCenter.add(lblKetQua = new JLabel("Kết Quả: "));
		y += 50;
		lblKetQua.setBounds(x, y, width, height);

		panelCenter.add(txtA = new JTextField());
		x += 100;
		y = 40;
		width = 300;
		txtA.setBounds(x, y, width, height);

		panelCenter.add(txtB = new JTextField());
		y += 50;
		txtB.setBounds(x, y, width, height);

		panelCenter.add(txtC = new JTextField());
		y += 50;
		txtC.setBounds(x, y, width, height);

		panelCenter.add(KQ = new JTextField());
		y += 50;
		KQ.setBounds(x, y, width, height);
		KQ.setEditable(false);

		JPanel panelSouth;
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chọn Tác Vụ"));
		panelSouth.add(buttonGiai = new JButton("Giải"));
		panelSouth.add(buttonXoaRong = new JButton("Xóa rỗng"));
		panelSouth.add(buttonThoat = new JButton("Thoát"));
		
		buttonGiai.addActionListener(this);
		buttonXoaRong.addActionListener(this);
		buttonThoat.addActionListener(this);
		

	}

	public static void main(String[] args) {
		new giaiPhuongTrinhBacHai().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonThoat)) {
			System.exit(0);
		} else if(o.equals(buttonXoaRong)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			KQ.setText("");
			txtA.requestFocus();
		} else if(o.equals(buttonGiai)) {
			if(!isInt(txtA)) {
				focus(txtA);
			} else if(!isInt(txtB)) {
				focus(txtB);
			} else if(!isInt(txtC)) {
				focus(txtC);
			} else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				int c = Integer.parseInt(txtC.getText());
				if(a == 0) {
					giaiPhuongTrinhBac1(b,c);
				} else {
					float delta = b*b-4*a*c;
					if(delta < 0 ) {
						KQ.setText("Vo Nghiem.");
					} else if(delta == 0) {
						KQ.setText("Nghiem Kep x1 = x2 =" + (-b/2*(float)a));
					} else {
						KQ.setText("Co 2 Nghiem x1 = "+ ((-b + Math.sqrt(delta)) / (2 * (float) a))+",x2 = " +((-b + Math.sqrt(delta)) / (2 * (float) a)));
					}
				}
			}
		}
		
	}
	private void focus(JTextField N) {
		N.selectAll();
		N.requestFocus();
		
	}

	void giaiPhuongTrinhBac1(int a , int b) {
		if(a!=0) {
			KQ.setText("Nghiem x = " + (-b / (float) a));
		} else if( b == 0 ) {
			KQ.setText("Vo So Nghiem");
		}else 
			KQ.setText("Vo Nghiem");
	}
	
	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		}catch(NumberFormatException ex) {
			result = false;
		}
		return result;
	}
	
}