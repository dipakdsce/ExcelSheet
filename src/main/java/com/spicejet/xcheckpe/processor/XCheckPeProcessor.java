package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class XCheckPeProcessor {

    private XCheckPeFileReader xCheckPeFileReader;
    private XCheckPeFileWriter xCheckPeFileWriter;
    private XCheckPeCalculation xCheckPeCalculation;

    public XCheckPeProcessor(XCheckPeFileReader xCheckPeFileReader, XCheckPeFileWriter xCheckPeFileWriter,
                             XCheckPeCalculation xCheckPeProcessor) {
        this.xCheckPeFileReader = xCheckPeFileReader;
        this.xCheckPeFileWriter = xCheckPeFileWriter;
        this.xCheckPeCalculation = xCheckPeProcessor;
    }

    public void execute() throws IOException {
        Set<InputBook> inputBooks = xCheckPeFileReader.readFile();
        List<OutputBook> outputBooks = xCheckPeCalculation.calculation(inputBooks);
        xCheckPeFileWriter.writeFile(outputBooks, xCheckPeFileReader.getFileName());

    }
}
