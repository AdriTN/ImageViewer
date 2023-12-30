package software.ulpgc.imageviewer.mocks;

import software.ulpgc.imageviewer.Image;
import software.ulpgc.imageviewer.ImageLoader;

import java.util.Arrays;
import java.util.List;

public class MockImageLoader implements ImageLoader {
    private final List<String> imagePaths = Arrays.asList(
            "\\Users\\adrii\\Downloads\\foto.jpg",
            "\\Users\\adrii\\Downloads\\foto2.jpg",
            "\\Users\\adrii\\Downloads\\foto3.jpg",
            "\\Users\\adrii\\Downloads\\foto4.jpg"
            // Agrega más rutas de imágenes según sea necesario
    );
    private int currentIndex = 0;

    @Override
    public Image load() {
        return new Image() {
            @Override
            public String id() {
                return imagePaths.get(currentIndex);
            }

            @Override
            public Image next() {
                currentIndex = (currentIndex + 1) % imagePaths.size();
                return this;
            }

            @Override
            public Image prev() {
                currentIndex = (currentIndex - 1 + imagePaths.size()) % imagePaths.size();
                return this;
            }
        };
    }
}
