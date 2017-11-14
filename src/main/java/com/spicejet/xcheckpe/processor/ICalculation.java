package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;

import java.text.ParseException;
import java.util.List;

public interface ICalculation {

    void execute(InputBook inputBook, OutputBook outputBook, List<OutputBook> outputBooks) throws ParseException;
}
