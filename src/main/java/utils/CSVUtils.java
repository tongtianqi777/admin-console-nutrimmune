package utils;

import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils <BeanCSV> {

    public List<BeanCSV> readCSV(MultipartFile file, CellProcessor[] processors, Class beanCSVClass, List<String> errors) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
            errors.add("A problem occurred when we tried to open the file, please check the correctness of the file completeness.");
        }

        ICsvBeanReader beanReader = null;
        List<BeanCSV> beanCSVs = new ArrayList<BeanCSV>();

        try {
            beanReader = new CsvBeanReader(new InputStreamReader(inputStream), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = beanReader.getHeader(true);

            BeanCSV beanCSV;

            while ((beanCSV = (BeanCSV) beanReader.read(beanCSVClass, header, processors)) != null) {
                beanCSVs.add(beanCSV);
            }

        } catch (Exception e) {
            e.printStackTrace();
            errors.add("A problem occurred when we tried to parse the csv data, please verify the correctness of the data format.");

        } finally {
            if (beanReader != null) {
                try {
                    beanReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    errors.add("A problem occurred when we tried to close the file, please check the correctness of the file completeness.");
                }

            }
        }

        return beanCSVs;
    }

}
