package org.example.services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileService {
    public File convertJpgToPng(File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIO.write(bufferedImage,"png",new File("result.png"));

        return new File("result.png");
    }
}
