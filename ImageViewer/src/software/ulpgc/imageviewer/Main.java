package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.mocks.MockImageLoader;
import software.ulpgc.imageviewer.real.GUIImageDisplay;
import software.ulpgc.imageviewer.real.ImagePresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static ImageLoader imageLoader;
    private static ImagePresenter presenter;
    private static ImageDisplay imageDisplay;
    private static Image currentImage;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        imageLoader = new MockImageLoader(); // Utilizamos el cargador de imágenes mock
        imageDisplay = new GUIImageDisplay(); // Utilizamos la visualización gráfica
        presenter = new ImagePresenter(imageDisplay); // Creamos un ImagePresenter

        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(600, 400)); // Tamaño estándar
        // frame.setResizable(true); // La ventana es redimensionable por defecto

        JPanel imagePanel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentImage = currentImage.prev(); // Cambiamos a la imagen anterior
                updateImageLabel(imageLabel, currentImage); // Mostramos la nueva imagen
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentImage = currentImage.next(); // Cambiamos a la siguiente imagen
                updateImageLabel(imageLabel, currentImage); // Mostramos la nueva imagen
            }
        });

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        frame.add(imagePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        currentImage = imageLoader.load(); // Cargamos la primera imagen
        presenter.show(currentImage); // Mostramos la imagen actual

        updateImageLabel(imageLabel, currentImage); // Mostramos la imagen en la interfaz
    }

    private static void updateImageLabel(JLabel label, Image image) {
        if (image != null) {
            // Actualiza el label con la nueva imagen si no es null
            label.setIcon(new ImageIcon(((GUIImageDisplay) imageDisplay).loadImageFromFile(image.id())));
        }
    }
}
