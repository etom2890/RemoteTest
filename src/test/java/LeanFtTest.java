import com.hp.lft.sdk.mobile.Device;
import com.hp.lft.sdk.mobile.DeviceDescription;
import com.hp.lft.sdk.web.*;
import org.testng.annotations.*;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {
    public static Browser browser;
    @BeforeClass
    public void beforeClass() throws Exception {
    }

    @AfterClass
    public void afterClass() throws Exception {
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
    }

    @AfterMethod
    public void afterMethod() throws Exception {
    }

    @AfterTest
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    private static void globalTearDown() throws GeneralLeanFtException {
        SrfLab.releaseEnvironment(browser);
    }

    @Test
    public void test() throws GeneralLeanFtException , GeneralReplayException{

        DeviceDescription dd = new DeviceDescription();
        dd.setOsType("Android"); //or: dd.set("osType", "Android")
        dd.setOsVersion("9"); //or: dd.set("osVersion", "5.02")
        dd.set("Test_Name", "LeanFT Android mobile test");
        dd.setId("354a4c4243303098");
        Device device = SrfLab.lockDevice(dd);
        browser = BrowserFactory.launch(BrowserType.CHROME, device);
        browser.navigate("boxycharm.com");

        Link sUBSCRIBELink = browser.describe(Link.class, new LinkDescription.Builder()
                .accessibilityName("")
                .innerText("SUBSCRIBE")
                .role("")
                .tagName("A")
                .index(1).build());
        sUBSCRIBELink.click();

        browser.close();
    }

}