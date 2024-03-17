import org.example.HomePage;
import org.testng.annotations.Test;


public class TestPage extends BasePage {

    HomePage homePage;

    @Test(priority=1)
    public void searchForHotel(){

        homePage = new HomePage(driver);
        homePage.searchHotel("Mehmet Efendi Konağı");
        //homePage.setDateForHotel();

    }
}