package software.ulpgc.imageviewer.real;

import software.ulpgc.imageviewer.ImageDisplay;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GUIImageDisplay implements ImageDisplay {
    private JFrame frame;
    private JLabel imageLabel;

    public GUIImageDisplay() {
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(400, 300); // Tamaño inicial de la ventana
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void paint(String id, int offset) {
        // Lógica para cargar y mostrar la imagen en la interfaz gráfica
        BufferedImage image = loadImageFromFile(id); // Suponiendo que id es la ruta de la imagen
        if (image != null) {
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(
                    imageLabel.getWidth(), -1,0));
            imageLabel.setIcon(imageIcon);
        }
    }

    @Override
    public int getWidth() {
        return imageLabel.getWidth();
    }

    @Override
    public void clear() {
        imageLabel.setIcon(null);
    }

    @Override
    public void on(Shift shift) {
        // Implementación para manejar el desplazamiento de imágenes en la interfaz gráfica
    }

    @Override
    public void on(Released released) {
        // Implementación para manejar la liberación del desplazamiento en la interfaz gráfica
    }

    // Método simulado para cargar una imagen desde el sistema de archivos
    public BufferedImage loadImageFromFile(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

