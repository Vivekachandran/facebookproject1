package org.helper.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions an;
	public static Alert alt;
	public static JavascriptExecutor js;
	//Browser Launch
	public static void BrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}
	//Maximize Window
	public static void MaximizeWindow() {
		driver.manage().window().maximize();

	}
	//webdriver Methods
	//get url
	public static void  Url(String url) {
		driver.get(url);

	}
	
	//get Title
	public static void UrlTitle() {
		String title = driver.getTitle();
        System.out.println(title);
	}
	
	//get current Url
	public static void CurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
	}
	//close
	public static void close() {
		driver.close();

	}
	//quit
	public static void quit() {
		driver.quit();

	}
	
	//web elements method
	//send keys
	
	public static void sendText(String text ,WebElement ref ) {
		ref.sendKeys(text);

	}
	
	//click
	
	public static void clickBox(WebElement button) {
		button.click();
		
    }
	
	//gettext
	
	public static void pageText(WebElement txt) {
		String text = txt.getText();
		System.out.println(text);
    }
	
	//getattribute
	public static void pageAttribute( String txt,WebElement atr) {
		String attribute = atr.getAttribute(txt);
        System.out.println(attribute);
	}
	
	
	//ACTIONS
	//move to element
	
	public static void moveElement(WebElement ref) {
	 an=new Actions(driver);
      an.moveToElement(ref).perform();
	}
	
	//drag and drop
	
	public static void dragdrop(WebElement src,WebElement tgt) {
		an=new Actions(driver);
		an.dragAndDrop(src, tgt).perform();
	}
	
	//double click
	
	public static void doubleClick(WebElement wbel) {
		an=new Actions(driver);
		an.doubleClick(wbel).perform();

	}
	//context click
	public static void contextClick(WebElement wbel) {
		an=new Actions(driver);
        an.contextClick(wbel).perform();
	} 
	
	//Alert
	//accept
	public static void acceptAlert() {
		alt=driver.switchTo().alert();
       alt.accept();
	}
	
	//dismiss
	public static void dismissAlert() {
	alt=driver.switchTo().alert();
    alt.dismiss();
    }
	
	//sendkeys
	
	public static void passTxt(String text) {
		alt=driver.switchTo().alert();
        alt.sendKeys(text);
	}
	
	//gettext
	public static void getAlert() {
		alt=driver.switchTo().alert();
        String text = alt.getText();
        System.out.println(text);
	}
	
	//Take Screenshot

	public static void screenShots(String despath) throws IOException {
      TakesScreenshot ts = (TakesScreenshot)driver;
       File image = ts.getScreenshotAs(OutputType.FILE);
       File des = new File(despath);
       FileUtils.copyFile(image, des);
	}
	
	//Javascript Executor
	//sendkeys
	public static void sendText( WebElement ele,String txt ) {
	js=(JavascriptExecutor)driver;
    js.executeAsyncScript("arguments[0].setAttribute('value','txt')",ele ); 
	}
	
	//click
	public static void click(WebElement login) {
		js=(JavascriptExecutor)driver;	
        js.executeScript("arguments[0].click()", login);
	}
	
	//retrieve the text
	public static void attributeGetting(WebElement ref) {
		js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')",ref );

	}
	//scroll page
	public static void pageScroll(WebElement scroll) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView", scroll);

	}
	
	
	//Frames
	//id
	public static void frameid(String id) {
		driver.switchTo().frame(id);

	}
	//name
	public static void frameName(String name) {
		driver.switchTo().frame(name);

	}
	public static void frameElement(WebElement wbel) {
		driver.switchTo().frame(wbel);

	}
	public static void frameIndex(int index) {
       driver.switchTo().frame(index);

	}
	//parent frame
	public static void switchParent() {
		driver.switchTo().parentFrame();

	}
	//default content
	public static void switchDefault() {
		driver.switchTo().defaultContent();

	}
	
	//WINDOWS HANDLING
	//Switch url
	public static void switchUrl(String url) {
		driver.switchTo().window(url);

	}
	//parent id
	public static void switchParentid() {
		String parentid = driver.getWindowHandle();
        System.out.println(parentid);
	}
	
	//all window id
	
	public static void allWindow(int index) {
	    Set<String> allid = driver.getWindowHandles();
	    List<String> l= new ArrayList<String>();
	    l.addAll(allid);
        driver.switchTo().window(l.get(index));
	}
	
	//WAITS
	//IMPLICIT WAIT
	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}
	//EXPLICIT WAIT
	//elements to be selected
	public static void selectElementsWait(long sec, WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver,sec);
        w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	//FLUENT WAIT
	//alert is present
	public static void fluentsyn(long millisec,long pollisec) {
		FluentWait<WebDriver>f=new FluentWait<WebDriver>(driver).
		withTimeout(Duration.ofMillis(millisec)).pollingEvery
		(Duration.ofSeconds(pollisec)).ignoring(Throwable.class);
      f.until(ExpectedConditions.alertIsPresent());
	}
	
	//SELECT CLASS
	//select by index
	public static void indexSelect(WebElement webele, int index) {
		Select s=new Select(webele);
        s.selectByIndex(index);
	}
	
	//select by visible text
	
	public static void textVisible(WebElement webele,String txt) {
		Select s=new Select(webele);
        s.selectByVisibleText(txt);
	}
	
	//select by value
	public static void valueSelect(WebElement webele,String data) {
		Select s=new Select(webele);
        s.selectByValue(data);
	}
	
	//ismultiple
	public static void multiple(WebElement webele) {
		Select s=new Select(webele);
        s.isMultiple();
        
	}
	
	//get options
	
	public static void optionGetting(WebElement webele) {
		Select s=new Select(webele);
        s.getOptions();
	}
	
	//get all selected options
	
	public static void allOption(WebElement webele) {
		Select s=new Select(webele);
        s.getAllSelectedOptions();
        
	}
	//get first selected options 
	public static void selectFirst(WebElement webele) {
		Select s=new Select(webele);
        s.getFirstSelectedOption();
	}
	//deselect by index
	public static void indexDeselect(int index,WebElement webele) {
		Select s=new Select(webele);
		s.deselectByIndex(index);

	}
	
	//deselect by visible text
	public static void textDeselect(String txt,WebElement webele) {
		Select s=new Select(webele);
        s.deselectByVisibleText(txt);
	}
	//deselect by value
	public static void valueDeselect(String txt,WebElement webele) {
		Select s=new Select(webele);
        s.deselectByValue(txt);
	}
	//deselect all
	
	public static void allDeselect(WebElement webele) {
		Select s=new Select(webele);
        s.deselectAll();
	}
	
	//WEB TABLE
	// retrieve the data
	
	public static void dataTable(WebElement ref) {
		String text = ref.getText();
        System.out.println(text);
	}
	
	//to retrieve particular data
	
	public static void particularData(WebElement table,int rowposition,int columnposition) {
	    List<WebElement> allrows = table.findElements(By.tagName("tr"));
        WebElement row = allrows.get(rowposition);
        List<WebElement> datas = row.findElements(By.tagName("td"));
        WebElement pardata = datas.get(columnposition);
        String text = pardata.getText();
        System.out.println(text);
	}
	
	//display heading 
	
	public static void tableHeading(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement firstrow = rows.get(0);
        List<WebElement> headingrow =firstrow.findElements(By.tagName("th"));
        for(int i=0;i<headingrow.size();i++) {
        	WebElement headingdata = headingrow.get(i);
        	System.out.println(headingdata.getText());
        	
      }
	}
	
	//display table
	
	public static void displayTable(WebElement table) {
		
      List<WebElement> allrows = table.findElements(By.tagName("tr"));
      for(int i=0;i<allrows.size();i++) {
    	  WebElement row = allrows.get(i);
    	  
    	  
       List<WebElement> heading = row.findElements(By.tagName("th"));	  
    	for (int j=0;j<heading.size();j++) {
    		WebElement headdata = heading.get(j);
    		System.out.println(headdata.getText());
    	}
    	
    	 List<WebElement> data = row.findElements(By.tagName("td"));
    	for(int k=0; k<data.size();k++) {
    		WebElement alldata = data.get(k);
    		System.out.println(alldata.getText());
    	}
      }
	}
	
	
	
	public static void createExcel(int crerow ,int crecell,String setdata ) throws IOException  {
		File f=new File("C:\\Users\\Viveka\\eclipse-workspace\\MavenText\\Excel datas\\file.xlsx");
		Workbook w=new XSSFWorkbook();
		Sheet s=w.createSheet("sample");
		Row r=s.createRow(crerow);
		Cell c=r.createCell(crecell);
		c.setCellValue(setdata);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		

	}
	 public static void createCell(int getrow ,int crecell,String setdata) throws IOException {
		 File f=new File("C:\\Users\\Viveka\\eclipse-workspace\\MavenText\\Excel datas\\file.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheet("sample");
		Row r=s.getRow(getrow);
		Cell c=r.createCell(crecell);
		c.setCellValue(setdata);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);

	}
	 
	
	 public static void createRow(int crerow,int crecell,String setdata) throws IOException {
		 File f=new File("C:\\Users\\Viveka\\eclipse-workspace\\MavenText\\Excel datas\\file.xlsx");
			FileInputStream fis=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fis);
			Sheet s=w.getSheet("sample");
			Row r=s.createRow(crerow);
			Cell c=r.createCell(crecell);
			c.setCellValue(setdata);
			FileOutputStream fos=new FileOutputStream(f);
			w.write(fos);
		

	}
	 
	 
	 public static void readExcel(int getsheet,int getrow,int getcell) throws IOException {
		 File f=new File("C:\\Users\\Viveka\\eclipse-workspace\\MavenText\\Excel datas\\email.xlsx");
			
			FileInputStream fis= new FileInputStream(f);
			
			Workbook w=new XSSFWorkbook(fis);
			
			Sheet mysheet = w.getSheetAt(getsheet);
			Row r = mysheet.getRow(getrow);
			Cell c = r.getCell(getcell);
			int cell = c.getCellType();
			
			if (cell==1) {
				String value = c.getStringCellValue();
				System.out.println(value);
				
			} else if(DateUtil.isCellDateFormatted(c)){
				
			Date dateCell = c.getDateCellValue();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			String value = sdf.format(dateCell);
			System.out.println(value);
			
				
			}else {
				double numericCell = c.getNumericCellValue();
				long l=(long)numericCell;
				String value = String.valueOf(l);
				System.out.println(value);
			}
			}
		
			
	
	

}
