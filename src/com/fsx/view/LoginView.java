package com.fsx.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Author:   青铜大佬
 * Date:     2021/2/10 12:04
 */
public class LoginView {
    //管理员账号密码
    private static final String USERNAME = "root";       //管理员账号
    private static final String PASSWORD = "123456";     //管理员密码
    final static int WIDTH = 500;
    final static int HEIGHT = 300;
    private static JTextField username;
    private static JPasswordField password;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        //创建窗口对象
        JFrame jf = new JFrame("ATM");
        //设置图标
        ImageIcon imageIcon = new ImageIcon("src\\image\\left_top.jpg");
        jf.setIconImage(imageIcon.getImage());
        //获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        //设置窗体位置，大小
        jf.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
        //设置窗体关闭
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗口不可改变
        jf.setResizable(false);
        //设置布局
        jf.setLayout(new FlowLayout());
        //设置组件并添加组件
        JLabel jLabel = new JLabel("欢迎使用·青铜大佬·的ATM取款机");
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(jLabel);

        JLabel jl1 = new JLabel("管理员账号");
        username = new JTextField("root", 15);
        Box box1 = Box.createHorizontalBox();
        box1.add(jl1);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(username);

        JLabel jl2 = new JLabel("管理员密码");
        password = new JPasswordField("123456", 15);
        password.setEchoChar('*'); // 设置回显字符
        Box box2 = Box.createHorizontalBox();
        box2.add(jl2);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(password);

        JButton btn = new JButton("登录");
        Box box3 = Box.createHorizontalBox();
        box3.add(btn);

        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(50));
        box.add(horizontalBox);
        box.add(Box.createVerticalStrut(50));
        box.add(box1);
        box.add(Box.createVerticalStrut(10));
        box.add(box2);
        box.add(Box.createVerticalStrut(20));
        box.add(box3);

        jf.add(box);
        //设置窗体可见
        jf.setVisible(true);
        //设置按钮的点击事件
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (adminOperation()) {
                    //释放当前窗口资源
                    jf.dispose();
                    //打开另一个窗口
                    new MainView();
                } else {
                    JOptionPane.showMessageDialog(
                            jf,
                            "身份验证失败！",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    //管理员身份认证
    public static boolean adminOperation() {
        //获取管理员账号
        String userName = username.getText();
        //获取管理员密码
        String passWord = String.valueOf(password.getPassword());
        //验证管理员
        return USERNAME.equals(userName) && PASSWORD.equals(passWord);
    }
}
