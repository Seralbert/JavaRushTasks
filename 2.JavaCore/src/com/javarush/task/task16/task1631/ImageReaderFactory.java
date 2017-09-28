package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Admin on 03.04.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes){
            /*
            switch (imageTypes) {
                case BMP: return new BmpReader();
                case JPG: return new JpgReader();
                case PNG: return new PngReader();
                default:  throw new IllegalArgumentException("Неизвестный тип картинки");
            }
            */
        if(imageTypes == ImageTypes.BMP)return new BmpReader();
        else if (imageTypes == ImageTypes.JPG) return new JpgReader();
        else if (imageTypes == ImageTypes.PNG)return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
