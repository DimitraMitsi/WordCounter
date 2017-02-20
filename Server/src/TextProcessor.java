import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextProcessor {

	private static final String FILEPATH = "islands_in_the_stream.txt";

	public static String readText() throws FileNotFoundException {
		String thisLine = null;
		StringBuffer finalText = new StringBuffer();
		try {
			File file = new File(FILEPATH);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			while ((thisLine = br.readLine()) != null) {
				finalText.append(" ");
				finalText.append(thisLine);
				finalText.append(" ");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		return finalText.toString();
	}
}
