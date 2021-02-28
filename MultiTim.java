import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MultiTim{
    JLabel label = new JLabel("Sekunden: 0");
    int s = 0;
    int score = 0;
    int delay = 1000;
    JLabel label2 = new JLabel("Score: 0");
    JButton button = new JButton("Start");
    JButton button2 = new JButton("KLICKEN!");
    JMenuBar bar = new JMenuBar();
    JMenu menu = new JMenu("Info");
    JMenuItem item = new JMenuItem("Version");
    public MultiTim(){
        JFrame frame = new JFrame("10s Klicker");
        JPanel panel = new JPanel(new GridLayout(2,2));
        frame.add(panel);
        frame.setJMenuBar(bar);
        bar.add(menu);
        menu.add(item);
        panel.add(label);
        panel.add(label2);
        panel.add(button);
        panel.add(button2);
        
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Version 1.0");           
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                start();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                klicken();       
            }
        });
        
        
        button2.setEnabled(false);
        frame.setPreferredSize(new Dimension(300, 150));
        frame.pack();
        frame.setVisible(true);
    }
    
    public void start(){
        score = 0;
        label.setText("Sekunden: 0");
        Timer timer = new Timer(delay, null);
        button2.setEnabled(true);
        button.setEnabled(false);
        timer.start();
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(s < 9 ){
                    s++;
                    label.setText("Sekunden: "+s);
                }
                else{
                    timer.stop();
                    label.setText("Sekunden: 10");
                    stop();
                }
            }
        });
    }
    
    public void klicken(){
        score++;
        label2.setText("Score: "+score);
    }
    
    public void stop(){
        button2.setEnabled(false);
        button.setEnabled(true);
        s = 0;
    }
}
