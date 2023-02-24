package week1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CongTruNhanChia extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel panelNorth, panelWest, panelCenter, panelSouth, panelMath, blueBox, redBox, yellowBox;
	JLabel lblTitle, lblNhapA, lblNhapB, lblKQ;
	JButton btGiai, btXoa, btThoat;
	JTextField txtA, txtB, txtKQ;
	JRadioButton rbtPlus, rbtMinus, rbtMultiply, rbtDivine;
	ButtonGroup groupButtonMath;

	public CongTruNhanChia() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);

		createGui();
	}

	private void createGui() {

		add(panelNorth = new JPanel(), BorderLayout.NORTH);
		panelWest.add(lblTitle = new JLabel("Cộng Trừ Nhân Chia"));
		lblTitle.setFont(new Font(null, Font.BOLD, 24));
		lblTitle.setForeground(Color.blue);

		add(panelWest = new JPanel(), BorderLayout.WEST);
		panelWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		panelWest.setLayout(new GridLayout(7, 1, 0, 10));
		panelWest.setBackground(Color.decode("#c8c4c4"));
		panelWest.setPreferredSize(new Dimension(100, 100));
		panelWest.add(btGiai = new JButton("Giải"));
		btGiai.setMnemonic(KeyEvent.VK_G);
		panelWest.add(btXoa = new JButton("Xóa"));
		btXoa.setMnemonic(KeyEvent.VK_X);
		panelWest.add(btThoat = new JButton("Thoát"));
		btThoat.setMnemonic(KeyEvent.VK_T);

		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		panelCenter.setLayout(null);
		panelCenter.setBorder(BorderFactory.createTitledBorder("Tính Toán"));

		int x = 50, y = 20, width = 250, height = 30;
		panelCenter.add(lblNhapA = new JLabel("Nhập a:"));
		lblNhapA.setBounds(x, y, width, height);
		y += 40;
		panelCenter.add(lblNhapB = new JLabel("Nhập b:"));
		lblNhapB.setBounds(x, y, width, height);

		x += 50;
		y = 20;
		panelCenter.add(txtA = new JTextField());
		txtA.setBounds(x, y, width, height);
		y += 40;
		panelCenter.add(txtB = new JTextField());
		txtB.setBounds(x, y, width, height);

		panelCenter.add(panelMath = new JPanel());
		panelMath.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		y += 40;
		panelMath.setBounds(x, y, width, 100);

		panelMath.add(rbtPlus = new JRadioButton("Cộng"));
		panelMath.add(rbtMinus = new JRadioButton("Trừ"));
		panelMath.add(rbtMultiply = new JRadioButton("Nhân"));
		panelMath.add(rbtDivine = new JRadioButton("Chia"));
		panelMath.setLayout(new GridLayout(2, 2));
		groupButtonMath = new ButtonGroup();
		groupButtonMath.add(rbtPlus);
		groupButtonMath.add(rbtMinus);
		groupButtonMath.add(rbtMultiply);
		groupButtonMath.add(rbtDivine);

		panelCenter.add(lblKQ = new JLabel("Kết quả:"));
		x -= 50;
		y += 120;
		lblKQ.setBounds(x, y, width, height);
		panelCenter.add(txtKQ = new JTextField());
		x += 50;
		txtKQ.setEditable(false);
		txtKQ.setBounds(x, y, width, height);


		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBackground(Color.decode("#ffacac"));
		panelSouth.setPreferredSize(new Dimension(100, 50));

		panelSouth.add(blueBox = new JPanel());
		blueBox.setBackground(Color.blue);
		blueBox.setPreferredSize(new Dimension(30, 20));
		panelSouth.add(redBox = new JPanel());
		redBox.setBackground(Color.red);
		redBox.setPreferredSize(new Dimension(30, 20));
		panelSouth.add(yellowBox = new JPanel());
		yellowBox.setBackground(Color.yellow);
		yellowBox.setPreferredSize(new Dimension(30, 20));


		btGiai.addActionListener(this);
		btXoa.addActionListener(this);
		btThoat.addActionListener(this);
	}

	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btThoat) {
			System.exit(0);
		} else if (o == btXoa) {
			txtA.setText("");
			txtB.setText("");
			groupButtonMath.clearSelection();
			txtKQ.setText("");
			txtA.requestFocus();
		} else if (o == btGiai) {
			if (!isNum(txtA)) {
				focus(txtA);
			} else if (!isNum(txtB)) {
				focus(txtB);
			} else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());

				if (rbtPlus.isSelected()) {
					txtKQ.setText("" + (a + b));
				} else if ( rbtMinus.isSelected()) {
					txtKQ.setText("" + (a - b));
				} else if (rbtMultiply.isSelected()) {
					txtKQ.setText("" + (a * b));
				} else if (rbtDivine.isSelected()) {
					txtKQ.setText("" + ((double) a / b));
				}
			}
		}

	}

	private boolean isNum(JTextField text) {
		try {
			Integer.parseInt(text.getText());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void focus(JTextField txt) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
		txt.selectAll();
		txt.requestFocus();
	}
}
