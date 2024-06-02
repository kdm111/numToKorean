import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class numToKoreanFrame extends JFrame {
    JTextArea jta01;
    JTextArea jta02;

    private final String[] units = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    private final String[] tens = {"", "십", "백", "천", "만", "억"};

    public numToKoreanFrame() {
        jta01 = new JTextArea(10, 50);
        jta02 = new JTextArea(10, 50);

        JButton btnOk = new JButton("변환");
        JButton btnCancel = new JButton("취소");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setLayout(new GridLayout(1, 2, 10, 10));
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JScrollPane jsp01 = new JScrollPane(jta01);
        JScrollPane jsp02 = new JScrollPane(jta02);

        Map<Integer, String> digits = new HashMap<>();
        digits.put(1000000000, "억");
        digits.put(10000, "만");
        digits.put(1000, "천");
        digits.put(100, "백");
        digits.put(10, "십");

        Map<Integer, String> unitMap = new HashMap<>();
        unitMap.put(9, "구");
        unitMap.put(8, "팔");
        unitMap.put(7, "칠");
        unitMap.put(6, "육");
        unitMap.put(5, "오");
        unitMap.put(4, "사");
        unitMap.put(3, "삼");
        unitMap.put(2, "이");
        unitMap.put(1, "일");

        int[] subDigits = {1000, 100, 10, 1};

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jta01.getText().replaceAll("(\\n|\\t|\\s)", "");
                if (str.equals("0")) {
                    jta02.setText("영");
                } else {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int num = Integer.parseInt(str);

                        if (num >= 100000000) {
                            int b = num / 100000000;
                            num %= 100000000;
                            appendNumber(sb, b, digits, unitMap, subDigits);
                            sb.append("억");
                        }
                        if (num >= 10000) {
                            int b = num / 10000;
                            num %= 10000;
                            appendNumber(sb, b, digits, unitMap, subDigits);
                            sb.append("만");
                        }
                        appendNumber(sb, num, digits, unitMap, subDigits);
                        jta02.setText(sb.toString());
                    } catch (NumberFormatException ex) {
                        jta02.setText("Integer 범위만 써주세요");
                    }
                }
            }

            private void appendNumber(StringBuilder sb, int num, Map<Integer, String> digits, Map<Integer, String> unitMap, int[] subDigits) {
                for (int d : subDigits) {
                    if (num / d >= 1) {
                        if (num == 1) {
                            sb.append("일");
                            break ;
                        }
                        if (num / d != 1) {
                            sb.append(unitMap.get(num / d));
                        }
                        if (d != 1) {
                            sb.append(digits.get(d));
                        }
                        num %= d;
                    }
                }
            }
        });

        p1.add(jsp01);
        p1.add(jsp02);

        p2.add(btnOk);
        p2.add(btnCancel);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        setTitle("number to korean");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);
    }

    public static void main(String[] args) {
        new numToKoreanFrame();
    }
}
