package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;

import java.text.ParseException;

public interface ICalculation {

    boolean execute(InputBook inputBook, OutputBook outputBook) throws ParseException;
}
