// Java-программа для создания текстового редактора с использованием Java
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;



public class GGG extends JFrame implements ActionListener {
    // Текстовый компонент


    JEditorPane t;
    // Рамка
    JFrame f;

    // Конструктор
    GGG()
    {
        // Создать рамку
        f = new JFrame("Macrohard Wort");

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            // Настройка внешнего вида
            UIManager.setLookAndFeel("javax.swing.play.metal.MetalLookAndFeel");

            // Установить тему на океан
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }

        catch (Exception e) {
        }

        // Текстовый компонент
        t = new JEditorPane();

        // Создать строку меню
        JMenuBar mb = new JMenuBar();

        // Создать меню для меню
        JMenu m1 = new JMenu("File");

        // Создание пунктов меню
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");



        // Добавить слушателя действия
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);


        // Создать меню для меню
        JMenu m2 = new JMenu("Edit");

        // Создание пунктов меню
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");

        // Добавить слушателя действия
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);


        // Создать меню для меню
        JMenu m3 = new JMenu("Colour");

        // Создание пунктов меню
        JMenuItem mi7 = new JMenuItem("Red");
        JMenuItem mi8 = new JMenuItem("Blue");
        JMenuItem mi10 = new JMenuItem("Black");

        // Добавить слушателя действия
        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi10.addActionListener(this);

        m3.add(mi7);
        m3.add(mi8);
        m3.add(mi10);

        // Создать меню для меню
        JMenu m4 = new JMenu("Style");

        // Создание пунктов меню
        JMenuItem mi21 = new JMenuItem("Times New Roman");
        JMenuItem mi22 = new JMenuItem("Courier New");
        JMenuItem mi23 = new JMenuItem("Calibri");

        // Добавить слушателя действия
        mi21.addActionListener(this);
        mi22.addActionListener(this);
        mi23.addActionListener(this);

        m4.add(mi21);
        m4.add(mi22);
        m4.add(mi23);


        // Создать меню для меню
        JMenu m5 = new JMenu("Size");

        // Создание пунктов меню
        JMenuItem mi24 = new JMenuItem("10");
        JMenuItem mi25 = new JMenuItem("12");
        JMenuItem mi26 = new JMenuItem("14");

        // Добавить слушателя действия
        mi24.addActionListener(this);
        mi25.addActionListener(this);
        mi26.addActionListener(this);

        m5.add(mi24);
        m5.add(mi25);
        m5.add(mi26);



        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);


        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(500, 500);
        f.show();
    }


    /**
     * @param e
     *
     *
     */

    // Если кнопка нажата
    public void actionPerformed(ActionEvent e)
    {

        String s = e.getActionCommand();

        if (s.equals("cut")) {
            t.cut();
        }

        else if (s.equals("copy")) {
            t.copy();
        }

        else if (s.equals("paste")) {
            t.paste();
        }

        else if (s.equals("Save")) {
            // Создать объект класса JFileChooser
            JFileChooser j = new JFileChooser("f:");

            // Вызвать функцию ShowSaveDialog, чтобы показать диалог сохранения
            int r = j.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {

                // Установить метку на путь к выбранному каталогу
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {

                    // Создать файл писателя
                    FileWriter wr = new FileWriter(fi, false);

                    // Создать буферизованный писатель для записи
                    BufferedWriter w = new BufferedWriter(wr);

                    // Написать
                    w.write(t.getText());

                    w.flush();
                    w.close();

                }

                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }

            }

            // Если пользователь отменил операцию
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
        }

        else if (s.equals("Print")) {
            try {

                // распечатать файл
                t.print();
            }

            catch (Exception evt) {
                JOptionPane.showMessageDialog(f, evt.getMessage());
            }
        }

        else if (s.equals("Open")) {

            // Создать объект класса JFileChooser
            JFileChooser j = new JFileChooser("f:");

            // Вызвать функцию showsOpenDialog, чтобы показать диалоговое окно сохранения
            int r = j.showOpenDialog(null);

            // Если пользователь выбирает файл
            if (r == JFileChooser.APPROVE_OPTION) {

                // Установить метку на путь к выбранному каталогу
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {

                    // Строка
                    String s1 = "", sl = "";

                    // Чтец файлов
                    FileReader fr = new FileReader(fi);

                    // Буферный ридер
                    BufferedReader br = new BufferedReader(fr);

                    // нициализируем sl
                    sl = br.readLine();

                    // Взять ввод из файла
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }

                    // Установить текст
                    t.setText(sl);
                }

                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }

            // Если пользователь отменил операцию
            else
                JOptionPane.showMessageDialog(f, "Пользователь отменил операцию");
        }

        else if (s.equals("New")) {
            t.setText("");
        }
        // замена цвета текста
        else if (s.equals("Red")) {
            t.setForeground(Color.red);
        }
        else if (s.equals("Blue")) {
            t.setForeground(Color.blue);
        }
        else if (s.equals("Black")) {
            t.setForeground(Color.black);
        }


        //Замена размера текста
        else if (s.equals("10")) {
            t.setFont(t.getFont().deriveFont(10f));
        }
        else if (s.equals("12")) {
            t.setFont(t.getFont().deriveFont(12f));
        }
        else if (s.equals("14")) {
            t.setFont(t.getFont().deriveFont(14f));
        }


        //Замена шрифта
        else if (s.equals("Calibri")) {
           t.setFont(new java.awt.Font("Calibre", Font.ITALIC, 14));
        }
        else if (s.equals("Times New Roman")) {
            t.setFont(new java.awt.Font("Times New Roman", Font.ITALIC, 14));
        }
        else if (s.equals("Courier New")) {
            t.setFont(new java.awt.Font("Courier New", Font.ITALIC, 14));
        }
    }


    /**
     * @param args
     */
    // Основной класс
    public static void main(String args[])
    {
        GGG e = new GGG();
    }
}

