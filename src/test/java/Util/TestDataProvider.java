package Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;









import Base.TestBase;

public class TestDataProvider {
	
		
		@DataProvider(name="Vernons_Core_SUITEDataProvider")
		public static Object[][]getDataCORE_SUITE(Method m) throws FileNotFoundException{
			TestBase.init();
			//System.out.println(TestBase.prop.getProperty("xlsFileLocation"));
			Xls_Reader xls1 = new Xls_Reader(TestBase.Config.getProperty("xlsFileLocation")+Constant.First_Suite+".xlsx");

			Object[][] obj = TestUtil.getData(m.getName(), xls1); 
			return obj;
		}
		
	/*	@DataProvider(name="CasinoDataProvider")
		public static Object[][]getDataCasino(Method m) throws FileNotFoundException{
			TestBase.init();
			Xls_Reader xls1 = new Xls_Reader(TestBase.Config.getProperty("xlsFileLocation")+Constant.SECOND_SUITE+".xlsx");

			return TestUtil.getData(m.getName(), xls1);
		}
		*/
		@DataProvider(name="CashierDataProvider")
		public static Object[][]getDataCashier(Method m) throws FileNotFoundException{
			TestBase.init();
			Xls_Reader xls1 = new Xls_Reader(TestBase.Config.getProperty("xlsFileLocation")+Constant.Money_Section+".xlsx");

			return TestUtil.getData(m.getName(), xls1);
	}


}