package Preparation.PreparationModule1;

import java.io.File;
import java.io.IOException;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageDataReader {
	
	
	/**
	 * Method Description: This is the method which calls all the sub methods and gets the extracted Journey name and Completion date
	 */
	public static void extractDetailsFromImage() {
		// pass the image folder location in the constructor param
		File file = new File("./certificate_image");
		
		// store the list of files present in the folder into a File array to get the each file name for the prepareFileURL method param 
		File[] files = file.listFiles();
		System.out.println("Extracted RAW data string without processing: " +"\n"+ getImageURL(prepareFileURL(files[0].getName())));
		String extractedImageData = getImageURL(prepareFileURL(files[0].getName())).replace("\n", "");
		String journeyName = extractJourneyName(extractedImageData);
		String completionDate = extractJourneyCompletionDate(extractedImageData, journeyName);
		System.out.println("journey completion date: " + completionDate + " & " + "journeyname: " + journeyName);
	}

	/**
	 * Method description: this method creates a file directory location url,appends the filename to the file location directory
	 * @param filename
	 * @return url
	 */
	public static File prepareFileURL(String filename) {
		File url = new File(System.getProperty("user.dir") + "\\certificate_image\\" + filename);
//		System.out.println(url);
		return url;
	}

	/**
	 * Method Description: takes the file location of image as input and using
	 * Tesseract OCR Api extracts the image text. In the tessdata folder store the
	 * eng.traineddata file and pass the file location to setDatapath method
	 * Download the file from here: https://github.com/tesseract-ocr/tessdata
	 * Tess4j wrapper mvn repo:https://mvnrepository.com/artifact/net.sourceforge.tess4j/tess4j
	 * Dependency version used: 4.2.1
	 * @param stringurl
	 * @return String extracted image data
	 */
	public static String getImageURL(File stringurl) {
		String imageData = null;
		ITesseract instancedata = new Tesseract();
		instancedata.setDatapath("./tessdata");
		try {

			imageData = instancedata.doOCR(stringurl);

		} catch (TesseractException Texception) {
			System.out.println("error message" + " " + Texception.getMessage());
		}

		return imageData;
	}

	/**
	 * Method Description: This function does string manipulation and extracts the
	 * journey name from the raw image data.
	 * 
	 * @param rawstringdata
	 * @return String journey name
	 */
	public static String extractJourneyName(String rawstringdata) {
		String journeyName = rawstringdata.split("Completing")[1].split("]")[0];
		return journeyName;

	}

	/**
	 * Method Description: This function does string manipulation and extracts the
	 * JourneyCompletionDate from the extracted raw data.
	 * @param rawstring
	 * @param journeyName
	 * @return String JourneyCompletionDate
	 */
	public static String extractJourneyCompletionDate(String rawstring, String journeyName) {
		String journeyCompletionDate = rawstring.substring(rawstring.lastIndexOf(journeyName))
										.split("@")[1]
										.split(" ")[1].replaceAll("[A-Za-z]", "");
		return journeyCompletionDate;
	}

	public static void main(String... args) throws IOException, InterruptedException {
		extractDetailsFromImage();
	}

}
