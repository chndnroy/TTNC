package satguru.generic;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

public class FullpageScreenshot {
	public static void takescreenshot(WebDriver driver) throws Exception {
		Date d = new Date();

		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		File a = new File("/home/ttuser10/Desktop/testShots/" + d + ".png");
		ImageIO.write(s.getImage(), "PNG", a);
		

	}

}