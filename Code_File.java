import javax.swing.JButton; // for buttons
import javax.swing.JFileChooser; // for choosing file
import javax.swing.JFrame; // setting up frame
import javax.swing.JOptionPane; // selecting the file
import javax.swing.JTextField; // text filed for key
import java.awt.FlowLayout; // box layout
import java.awt.Font; // font of the text
import java.io.File; // inputing the fil
import java.io.FileInputStream;  
import java.io.FileOutputStream;
public class ImageOperation {

    public static void operate(int key)
    {
        // Choosing the file

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
                                                   //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key); // using xor cipher algorithm
                // xor of previous key will return the previous value
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
                                                      //Actual Code starts from here
    public static void main(String[] args) {
        
      //  System.out.println("this is testing");

        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Times New Roman",Font.BOLD,25);
                                                                 //creating button
        JButton button=new JButton();
        button.setText("Open Image");
        button.setFont(font);

                                                              //creating text field

        JTextField textField=new JTextField(10);
        textField.setFont(font);

        
        button.addActionListener(e->{
           // System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());

        f.add(button);
        f.add(textField);
        f.setVisible(true);

    }
}
