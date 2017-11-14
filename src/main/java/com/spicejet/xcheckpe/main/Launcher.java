package com.spicejet.xcheckpe.main;

import com.spicejet.xcheckpe.processor.XCheckPeCalculation;
import com.spicejet.xcheckpe.processor.XCheckPeFileReader;
import com.spicejet.xcheckpe.processor.XCheckPeFileWriter;
import com.spicejet.xcheckpe.processor.XCheckPeProcessor;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) {
        XCheckPeFileReader xCheckPeFileReader = new XCheckPeFileReader();
        XCheckPeCalculation xCheckPeCalculation = new XCheckPeCalculation();
        XCheckPeFileWriter xCheckPeFileWriter = new XCheckPeFileWriter();

        try {
            XCheckPeProcessor xCheckPeProcessor =
                    new XCheckPeProcessor(xCheckPeFileReader, xCheckPeFileWriter, xCheckPeCalculation);
            xCheckPeProcessor.execute();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}