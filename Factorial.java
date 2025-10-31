import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Factorial extends Frame implements ActionListener {
    Label l1, l2;
    TextField txt1, txt2;
    Button b1;

    public Factorial() {
        setVisible(true);
        setSize(500, 500);
        setTitle("Factorial Program");
        setLayout(new FlowLayout());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        l1 = new Label("Enter any number:");
        l2 = new Label("The factorial is:");

        txt1 = new TextField(10);
        txt2 = new TextField(10);
        txt2.setEditable(false); // Optional: make output field read-only

        b1 = new Button("Compute");

        add(l1);
        add(txt1);
        add(l2);
        add(txt2);
        add(b1);

        b1.addActionListener(this);
    }

    public static void main(String[] args) {
        new Factorial();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                int value = Integer.parseInt(txt1.getText());
                int fact = factorial(value);
                txt2.setText(String.valueOf(fact));
            } catch (NumberFormatException ex) {
                txt2.setText("Invalid input");
            }
        }
    }

    int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}