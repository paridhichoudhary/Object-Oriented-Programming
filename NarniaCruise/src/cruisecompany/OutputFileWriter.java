/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruisecompany;

/**
 *Writes the file into a text file when given the path and string to load in it.
 * @author paridhichoudhary
 */
public class OutputFileWriter {
    
    /**
     *
     * @param filePath
     * @param outputString
     * @throws Exception
     */
    public void writeFile(String filePath, String outputString) throws Exception {
    java.io.File file = new java.io.File(filePath); //creates new file object
    if (file.exists()) {
      System.out.println("File already exists"); // Error Handling
    }

    // Create a file
    java.io.PrintWriter output = new java.io.PrintWriter(file); // If file does not exist, write it

    // Write formatted output to the file
    output.print(outputString);
    
    // Close the file
    output.close();
  }
    
}
