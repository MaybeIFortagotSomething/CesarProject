package fr.dinasty.cesar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import java.nio.charset.StandardCharsets;

public class Main {
    private static final int NB = 42;
    public static void main(String[] args) throws IOException {
        String[] dataPicture = {"/home/dinasty/Work/Python/CesarProject/1.jpg"};
        StringBuilder stringBuilder = new StringBuilder();
        for(String name: dataPicture)
        {
            try
            {
                BufferedImage bufferedImage = ImageIO.read(new File(name));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                byte[] data = byteArrayOutputStream.toByteArray();

                String s = new String(data, StandardCharsets.ISO_8859_1);
                for(int i = 0; i< data.length;i++)
                {
                    stringBuilder.append((char)(((int)s.charAt(i)+NB)%256));
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            stringBuilder.append("\n");
        }
        File file = new File("encryptedData.enc");
        final FileWriter fileWriter;
        try
        {
            if(!file.exists())
                file.createNewFile();
            fileWriter = new FileWriter(file);
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
