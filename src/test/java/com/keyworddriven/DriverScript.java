package com.keyworddriven;



import java.io.IOException;

public class DriverScript {
    public static void main(String[] args) throws IOException {
        String sPath="C:\\Users\\HP\\Desktop\\Keywords.xlsx";
        ExcelUtils.setExcelFile(sPath, "Sheet1");

        for (int iRow = 1; iRow<=7; iRow++)
        {
            String sActionKeyword=ExcelUtils.getCellData(iRow,0);
            if(sActionKeyword.equals("openBrowser"))
            {
                ActionKeywords.openBrowser();
            }
            else if (sActionKeyword.equals("navigate"))
            {
                ActionKeywords.navigate();
            }
            else if (sActionKeyword.equals("inputUsername"))
            {
                ActionKeywords.inputUsername();
            }
            else if (sActionKeyword.equals("clickNext"))
            {
                ActionKeywords.clickNext();
            }
            else if (sActionKeyword.equals("inputPassword"))
            {
                ActionKeywords.inputPassword();
            }
            else if (sActionKeyword.equals("clickSignin"))
            {
                ActionKeywords.clickSignin();
            }
            else if (sActionKeyword.equals("closeBrowser"))
            {
                ActionKeywords.closeBrowser();
            }
        }
    }
}
