import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortWordLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String fileName;


        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        try {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                fileName = selectedFile.getPath();

                List<String> shortWords = new ArrayList<>();


                Filter filter = new ShortWordFilter();


                try (Scanner in = new Scanner(selectedFile)) {
                    in.useDelimiter("\\W+");

                    while (in.hasNext()) {
                        String word = in.next();
                        if (filter.accept(word)) {
                            shortWords.add(word);
                        }
                    }

                    System.out.println("Short words from the file " + fileName + ":");
                    for (String word : shortWords) {
                        System.out.println(word);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + fileName);
                    e.printStackTrace();
                }
            } else {
                System.out.println("No file selected. Program terminated.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
