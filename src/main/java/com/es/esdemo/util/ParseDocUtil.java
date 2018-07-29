package com.es.esdemo.util;

import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;

public class ParseDocUtil {

    public static String getTextFromWord(File file) throws Exception{
        String result = null;
        FileInputStream fis = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fis = new FileInputStream(file);
            //@SuppressWarnings("resource")
            WordExtractor wordExtractor = new WordExtractor(fis);
            //result = wordExtractor.getText();
            /*String[] commentsText = wordExtractor.getCommentsText();*/
/*
            for (int i = 0; i < commentsText.length; i++) {
                stringBuffer.append(commentsText[i]+"+");
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }
}
