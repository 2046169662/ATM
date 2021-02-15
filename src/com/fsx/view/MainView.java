package com.fsx.view;

import com.fsx.model.Card;
import com.fsx.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Author:   青铜大佬
 * Date:     2021/2/10 13:02
 */
public class MainView {
    private static HashMap<String, User> map = null;
    final static int WIDTH = 500;
    final static int HEIGHT = 300;
    //获取用户屏幕尺寸
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int sw = screenSize.width;
    int sh = screenSize.height;
    //设置图标
    ImageIcon imageIcon = new ImageIcon("src\\image\\left_top.jpg");

    //创建对象时执行此处，判断资源文件是否存在
    static {
        //创建对象输入流
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\Program Files (x86)\\ATM_resource\\data.dat"));
            Object o = ois.readObject();
            map = (HashMap) o;
        } catch (IOException | ClassNotFoundException e) {
            //文件不存在时，创建文件
            File file = new File("D:\\Program Files (x86)\\ATM_resource\\data.dat");
            file.getParentFile().mkdirs();
            try {
                if (file.createNewFile()) {
                    map = new HashMap<>();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public MainView() {
        //创建系统主窗口
        JFrame jf = new JFrame("首页");
        //设置主窗口图标
        jf.setIconImage(imageIcon.getImage());
        //设置主窗口位置
        jf.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);
        JButton btn1 = new JButton("开户");
        JButton btn2 = new JButton("查询");
        JButton btn3 = new JButton("取钱");
        JButton btn4 = new JButton("存钱");
        JButton btn5 = new JButton("转账");
        Box box1 = Box.createHorizontalBox();
        box1.add(btn1);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(btn2);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(btn3);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(btn4);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(btn5);
        JButton btn6 = new JButton("改密");
        JButton btn7 = new JButton("激活");
        JButton btn8 = new JButton("冻结");
        JButton btn9 = new JButton("退出");
        Box box2 = Box.createHorizontalBox();
        box2.add(btn6);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(btn7);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(btn8);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(btn9);
        Box box = Box.createVerticalBox();
        box.add(box1);
        box.add(Box.createVerticalStrut(20));
        box.add(box2);
        jf.add(box);
        JTextArea ta = new JTextArea(10, 40);
        jf.add(ta);

        //开户
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf1 = new JFrame("开户");
                jf1.setIconImage(imageIcon.getImage());
                jf1.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf1.setLayout(new FlowLayout());
                jf1.setVisible(true);
                jf1.setResizable(false);
                JLabel jl1 = new JLabel("姓　　名");
                JTextField username = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(username);
                JLabel jl2 = new JLabel("身份证件");
                JTextField idCard = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(idCard);
                JLabel jl3 = new JLabel("联系方式");
                JTextField phone = new JTextField(20);
                Box box3 = Box.createHorizontalBox();
                box3.add(jl3);
                box3.add(Box.createHorizontalStrut(10));
                box3.add(phone);
                JLabel jl4 = new JLabel("密　　码");
                JPasswordField password = new JPasswordField(20);
                password.setEchoChar('*');
                Box box4 = Box.createHorizontalBox();
                box4.add(jl4);
                box4.add(Box.createHorizontalStrut(10));
                box4.add(password);
                JLabel jl5 = new JLabel("确定密码");
                JPasswordField password2 = new JPasswordField(20);
                password2.setEchoChar('*');
                Box box5 = Box.createHorizontalBox();
                box5.add(jl5);
                box5.add(Box.createHorizontalStrut(10));
                box5.add(password2);
                JButton btn = new JButton("注册");
                Box box6 = Box.createHorizontalBox();
                box6.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                box.add(Box.createVerticalStrut(10));
                box.add(box4);
                box.add(Box.createVerticalStrut(10));
                box.add(box5);
                box.add(Box.createVerticalStrut(10));
                box.add(box6);
                jf1.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf1.dispose();
                        jf.setVisible(true);
                        String userName = username.getText().trim();
                        String idCards = idCard.getText().trim();
                        String phones = phone.getText().trim();
                        String idPsw = String.valueOf(password.getPassword());
                        String idPsw2 = String.valueOf(password2.getPassword());
                        if (!idPsw.equals(idPsw2)) {
                            ta.setText("密码不一致!");
                        } else {
                            String cardId = cardID();
                            ta.setText("您的卡号是：" + cardId);
                            Card card = new Card(cardId, idPsw);
                            User user = new User(userName, idCards, phones, card);
                            map.put(cardId, user);
                        }
                    }
                });
            }
        });

        //查询
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf2 = new JFrame("查询");
                jf2.setIconImage(imageIcon.getImage());
                jf2.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf2.setLayout(new FlowLayout());
                jf2.setVisible(true);
                jf2.setResizable(false);
                JLabel jl1 = new JLabel("请输入银行卡号");
                JTextField card = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                JLabel jl2 = new JLabel("请输入你的密码");
                JTextField password = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(password);
                JButton btn = new JButton("查询");
                Box box3 = Box.createHorizontalBox();
                box3.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                jf2.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf2.dispose();
                        jf.setVisible(true);
                        String cardId = card.getText().trim();
                        User user = map.get(cardId);
                        if (null != user && user.getCard().isCardStatus()) {
                            String psw = password.getText().trim();
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                ta.setText("卡号：" + user.getCard().getCardId() + "\t\t余额：" + user.getCard().getCardmoney());
                            } else {
                                ta.setText("密码错误");
                            }
                        } else {
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //取款
        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf3 = new JFrame("取款");
                jf3.setIconImage(imageIcon.getImage());
                jf3.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf3.setLayout(new FlowLayout());
                jf3.setVisible(true);
                jf3.setResizable(false);
                JLabel jl1 = new JLabel("请输入银行卡号");
                JTextField card = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                JLabel jl2 = new JLabel("请输入你的密码");
                JTextField password = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(password);
                JLabel jl3 = new JLabel("请输入取款金额");
                JTextField money = new JTextField(20);
                Box box3 = Box.createHorizontalBox();
                box3.add(jl3);
                box3.add(Box.createHorizontalStrut(10));
                box3.add(money);
                JButton btn = new JButton("取款");
                Box box4 = Box.createHorizontalBox();
                box4.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                box.add(Box.createVerticalStrut(10));
                box.add(box4);
                jf3.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf3.dispose();
                        jf.setVisible(true);
                        String cardId = card.getText().trim();
                        double money1 = Double.parseDouble(money.getText().trim());
                        User user = map.get(cardId);
                        if (null != user && user.getCard().isCardStatus()) {
                            String psw = password.getText().trim();
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                //得到该用户上次的金额
                                double cardmoney = user.getCard().getCardmoney();
                                double newCardmoney = cardmoney - money1;
                                if (newCardmoney < 0) {
                                    ta.setText("卡内余额不足！\n您的余额为 " + user.getCard().getCardmoney());
                                }
                                //修改用户账号上的金额
                                user.getCard().setCardmoney(cardmoney - money1);
                                ta.setText("卡号：" + user.getCard().getCardId() + "\t\t余额：" + user.getCard().getCardmoney());
                            } else {
                                ta.setText("密码错误");
                            }
                        } else {
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //存款
        btn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf4 = new JFrame("存款");
                jf4.setIconImage(imageIcon.getImage());
                jf4.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf4.setLayout(new FlowLayout());
                jf4.setVisible(true);
                jf4.setResizable(false);
                JLabel jl1 = new JLabel("请输入银行卡号");
                JTextField card = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                JLabel jl2 = new JLabel("请输入你的密码");
                JTextField password = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(password);
                JLabel jl3 = new JLabel("请输入取款金额");
                JTextField money = new JTextField(20);
                Box box3 = Box.createHorizontalBox();
                box3.add(jl3);
                box3.add(Box.createHorizontalStrut(10));
                box3.add(money);
                JButton btn = new JButton("存款");
                Box box4 = Box.createHorizontalBox();
                box4.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                box.add(Box.createVerticalStrut(10));
                box.add(box4);
                jf4.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf4.dispose();
                        jf.setVisible(true);
                        String cardId = card.getText().trim();
                        double money1 = Double.parseDouble(money.getText().trim());
                        User user = map.get(cardId);
                        if (null != user && user.getCard().isCardStatus()) {
                            String psw = password.getText().trim();
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                double cardmoney = user.getCard().getCardmoney();
                                user.getCard().setCardmoney(cardmoney + money1);
                                ta.setText("卡号：" + user.getCard().getCardId() + "\t\t余额：" + user.getCard().getCardmoney());
                            } else {
                                ta.setText("密码错误");
                            }
                        } else {
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //转账
        btn5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf5 = new JFrame("转账");
                jf5.setIconImage(imageIcon.getImage());
                jf5.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf5.setLayout(new FlowLayout());
                jf5.setVisible(true);
                jf5.setResizable(false);
                JLabel jl1 = new JLabel("请输入银行卡号");
                JTextField card = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                JLabel jl2 = new JLabel("　请输入收款人");
                JTextField card2 = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(card2);
                JLabel jl3 = new JLabel("请输入你的密码");
                JTextField password = new JTextField(20);
                Box box3 = Box.createHorizontalBox();
                box3.add(jl3);
                box3.add(Box.createHorizontalStrut(10));
                box3.add(password);
                JLabel jl4 = new JLabel("请输入转账金额");
                JTextField money = new JTextField(20);
                Box box4 = Box.createHorizontalBox();
                box4.add(jl4);
                box4.add(Box.createHorizontalStrut(10));
                box4.add(money);
                JButton btn = new JButton("转账");
                Box box5 = Box.createHorizontalBox();
                box5.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                box.add(Box.createVerticalStrut(10));
                box.add(box4);
                box.add(Box.createVerticalStrut(10));
                box.add(box5);
                jf5.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf5.dispose();
                        jf.setVisible(true);
                        String cardId = card.getText().trim();
                        String cardID = card2.getText().trim();
                        double money1 = Double.parseDouble(money.getText().trim());
                        User user = map.get(cardId);
                        User user2 = map.get(cardID);
                        if (null != user && user.getCard().isCardStatus()) {
                            String psw = password.getText().trim();
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                if (null != user2 && user2.getCard().isCardStatus()) {
                                    double cardmoney1 = user.getCard().getCardmoney();
                                    double cardmoney2 = user2.getCard().getCardmoney();
                                    user.getCard().setCardmoney(cardmoney1 - money1);
                                    user2.getCard().setCardmoney(cardmoney2 + money1);
                                    ta.setText("转账成功！\n卡号：" + user.getCard().getCardId() + "\t\t余额：" + user.getCard().getCardmoney());
                                } else {
                                    ta.setText("对方账户异常");
                                }
                            } else {
                                ta.setText("密码错误");
                            }
                        } else {
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //修改密码
        btn6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf6 = new JFrame("修改密码");
                jf6.setIconImage(imageIcon.getImage());
                jf6.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf6.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf6.setLayout(new FlowLayout());
                jf6.setVisible(true);
                jf6.setResizable(false);
                JLabel jl1 = new JLabel("请输入银行卡号");
                JTextField card = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                JLabel jl2 = new JLabel("请输入你的密码");
                JTextField password = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(password);
                JLabel jl3 = new JLabel("请输入新的密码");
                JTextField newPassword = new JTextField(20);
                Box box3 = Box.createHorizontalBox();
                box3.add(jl3);
                box3.add(Box.createHorizontalStrut(10));
                box3.add(newPassword);
                JButton btn = new JButton("修改密码");
                Box box4 = Box.createHorizontalBox();
                box4.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                box.add(Box.createVerticalStrut(10));
                box.add(box4);
                jf6.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf6.dispose();
                        jf.setVisible(true);
                        String cardId = card.getText().trim();
                        User user = map.get(cardId);
                        if (null != user && user.getCard().isCardStatus()) {
                            String psw = password.getText().trim();
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                user.getCard().setCardPasswd(newPassword.getText().trim());
                                ta.setText("修改成功");
                            } else {
                                ta.setText("密码错误");
                            }
                        } else {
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //激活
        btn7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setVisible(false);
                JFrame jf7 = new JFrame("激活");
                jf7.setIconImage(imageIcon.getImage());
                jf7.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                jf7.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jf7.setLayout(new FlowLayout());
                jf7.setVisible(true);
                jf7.setResizable(false);
                JLabel jl1 = new JLabel("请输入银行卡号");
                JTextField card = new JTextField(20);
                Box box1 = Box.createHorizontalBox();
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                JLabel jl2 = new JLabel("请输入你的密码");
                JTextField password = new JTextField(20);
                Box box2 = Box.createHorizontalBox();
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(password);
                JButton btn = new JButton("激活");
                Box box3 = Box.createHorizontalBox();
                box3.add(btn);
                Box box = Box.createVerticalBox();
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                jf7.add(box);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jf7.dispose();
                        jf.setVisible(true);
                        String cardId = card.getText().trim();
                        User user = map.get(cardId);
                        if (null != user) {
                            String psw = password.getText().trim();
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                if (user.getCard().isCardStatus()) {
                                    ta.setText("此卡未冻结");
                                } else {
                                    user.getCard().setCardStatus(true);
                                    ta.setText("激活成功！");
                                }
                            } else {
                                ta.setText("密码错误");
                            }
                        } else {
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //冻结
        btn8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //隐藏主窗口
                jf.setVisible(false);
                //创建一个新的窗口对象
                JFrame jf8 = new JFrame("冻结");
                //设置窗口图标
                jf8.setIconImage(imageIcon.getImage());
                //设置窗口位置
                jf8.setBounds((sw - WIDTH) / 2, (sh - HEIGHT) / 2, WIDTH, HEIGHT);
                //设置窗口可关闭
                jf8.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //设置窗口布局【流式布局】
                jf8.setLayout(new FlowLayout());
                //设置当前窗口可见
                jf8.setVisible(true);
                //设置窗口不可改变
                jf8.setResizable(false);
                //创建一个标签
                JLabel jl1 = new JLabel("请输入银行卡号");
                //创建一个输入框
                JTextField card = new JTextField(20);
                //创建一个盒子
                Box box1 = Box.createHorizontalBox();
                //将标签和输入框添加到盒子中
                box1.add(jl1);
                box1.add(Box.createHorizontalStrut(10));
                box1.add(card);
                //创建一个标签
                JLabel jl2 = new JLabel("请输入你的密码");
                //创建一个密码输入框
                JTextField password = new JTextField(20);
                //创建一个盒子
                Box box2 = Box.createHorizontalBox();
                //将标签和密码输入框添加到盒子中
                box2.add(jl2);
                box2.add(Box.createHorizontalStrut(10));
                box2.add(password);
                //创建一个按钮
                JButton btn = new JButton("冻结");
                //创建一个盒子
                Box box3 = Box.createHorizontalBox();
                //将按钮添加到盒子中
                box3.add(btn);
                //创建一个大盒子【垂直】
                Box box = Box.createVerticalBox();
                //将上面的小盒子添加到大盒子中去
                box.add(box1);
                box.add(Box.createVerticalStrut(10));
                box.add(box2);
                box.add(Box.createVerticalStrut(10));
                box.add(box3);
                //将大盒子添加到新窗口中去
                jf8.add(box);
                //设置按钮的点击事件
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //释放当前窗口资源
                        jf8.dispose();
                        //设置主窗口可见
                        jf.setVisible(true);
                        //获取用户输入的银行卡号
                        String cardId = card.getText().trim();
                        //通过用户卡号查找用户
                        User user = map.get(cardId);
                        //判断用户是否存在
                        if (null != user) {
                            //获取用户输入的密码
                            String psw = password.getText().trim();
                            //判断密码是否正确
                            if (user.getCard().getCardPasswd().equals(psw)) {
                                //判断卡的状态
                                if (!user.getCard().isCardStatus()) {
                                    //在主窗口显示
                                    ta.setText("此卡未激活");
                                } else {
                                    //设置此卡的状态
                                    user.getCard().setCardStatus(false);
                                    //在主窗口显示
                                    ta.setText("冻结成功！");
                                }
                            } else {
                                //在主窗口显示
                                ta.setText("密码错误");
                            }
                        } else {
                            //在主窗口显示
                            ta.setText("用户异常");
                        }
                    }
                });
            }
        });

        //退出系统
        btn9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //释放窗口资源
                    jf.dispose();
                    //创建读入对象流
                    ObjectOutputStream osw = new ObjectOutputStream(new FileOutputStream("D:\\Program Files (x86)\\ATM_resource\\data.dat"));
                    //将map对象写入文件中
                    osw.writeObject(map);
                    //关闭对象流
                    osw.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });
    }

    //开户得到随机ID卡号
    public String cardID() {
        //创建一个容器
        StringBuffer sb = new StringBuffer();
        //创建随机数对象
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            //将生成的数据添加到容器中
            sb.append(r.nextInt(10));
        }
        //转换成字符串
        String cardId = String.valueOf(sb);
        //如果随机生成的账号已存在，重新生成
        if (map.get(cardId) != null) {
            cardID();
        }
        //返回字符串
        return cardId;
    }
}