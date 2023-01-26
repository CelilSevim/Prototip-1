package Utils;

import ExcelUtilities.ExcelUtil;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Hook {

    public static String path = "src/test/java/excelUtilities/log2.xlsx";
    //public static String fileName = "log2.xlsx";
    public static String sheetName = "TestLog";

    @BeforeAll // senaryo başlamadan önce
    public static void beforeAll() throws IOException {
        ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList("SENARYO ADI","AÇIKLAMA","TARİH-SAAT")));
    }

    @Before //her adımıdan önce
    public void beforeHook(io.cucumber.java.Scenario scenario) throws IOException {
        ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Başladı", ExcelUtil.getCurrentTime())));
    }

    @After //her adımdan sonra
    public void afterHook(io.cucumber.java.Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            System.out.println("senaryo başarısız");
            ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Başarısız",ExcelUtil.getCurrentTime())));
        }else {
            System.out.println("senaryo başarılı");
            ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Başarılı",ExcelUtil.getCurrentTime())));
        }
        ExcelUtil.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),"Bitti",ExcelUtil.getCurrentTime())));
    }


}
