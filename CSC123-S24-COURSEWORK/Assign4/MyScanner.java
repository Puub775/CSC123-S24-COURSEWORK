//Name: Pablo Conde 
//Email: pconde1@csudh.edu

import java.io.*;
import java.util.*;

/**
 * A utility class for reading info from input sources.
 * This class provides functionality similar to the built-in Scanner class in Java, 
 */

public class MyScanner {
	private BufferedReader read; 
    private StringTokenizer tokenize; 

    
    /**
     * Constructs a new MyScanner object that produces values scanned from the provided input .
     * @param source An InputStream to read input.
     */
    
    public MyScanner(InputStream source) {
        read = new BufferedReader(new InputStreamReader(source));
    }

    
    /**
     * Constructs a new MyScanner object that prints values scanned from the files.
     * @param source A File object to read input out of.
     * @throws FileNotFoundException If the file does not exist or is not found.
     */
    
    public MyScanner(File source) throws FileNotFoundException {
        read = new BufferedReader(new FileReader(source));
    }

    
    /**
     * Constructs a new MyScanner object that produces values scanned from the provided string.
     * @param source A String to read as input.
     */
    
    public MyScanner(String source) {
        read = new BufferedReader(new StringReader(source));
    }

    
    /**
     * Constructs a new MyScanner object that produces values scanned from the TokenizingReader.
     * @param source A TokenizingReader object to read input from.
     */
    
    public MyScanner(TokenizingReader source) {
        read = new BufferedReader(source);
    }


    
    /**
     * Finds and returns the next token (delimited element) in this scanner.
     * @return The next token as a String.
     * @throws NoSuchElementException If there is no more input to read.
     */
    
    public String next() {
        try {
            if (tokenize == null || !tokenize.hasMoreTokens()) {
                String line = read.readLine(); 
                if (line == null) {
                    throw new NoSuchElementException("There is nothing to be read anymore.");
                }
                tokenize = new StringTokenizer(line); 
            }
            return tokenize.nextToken(); 
        } catch (IOException e) {
            throw new NoSuchElementException("Error: " + e.getMessage());
        }
    }

    
    
    /**
     * Scans next token of the input as an int.
     * @return The int scanned from the input.
     * @throws NoSuchElementException If no more tokens are available to read.
     * @throws InputMismatchException If the token does not match the Integer regular expression,
     *         or does not match size.
     */
    
    public int nextInt() {
        return Integer.parseInt(next());
    }

    
    /**
     * Scans next token of the input as a double.
     * @return The double scanned from the input.
     * @throws NoSuchElementException If no more tokens are available to read.
     * @throws InputMismatchException If the next token does not match the Double regular expression,
     *         or does not match size.
     */
    
    public double nextDouble() {
        return Double.parseDouble(next());
    }

    
    /**
     * Scans next token of the input as a long.
     * @return The long scanned from the input.
     * @throws NoSuchElementException If no more tokens are available to read.
     * @throws InputMismatchException If the next token does not match the Long regular expression,
     *         or does not match size.
     */
    
    public long nextLong() {
        return Long.parseLong(next());
    }

    
    /**
     * Scans next token of the input as a float.
     * @return The float scanned from the input.
     * @throws NoSuchElementException If no more tokens are available to read.
     * @throws InputMismatchException If the next token does not match the Float regular expression,
     *         or does not match size.
     */
    
    public float nextFloat() {
        return Float.parseFloat(next());
    }
    
    /**
     * Scans next token of the input as a short.
     * @return The short scanned from the input.
     * @throws NoSuchElementException If no more tokens are available to read.
     * @throws InputMismatchException If the next token does not match the Short regular expression,
     *         or does not match size.
     */
    
    public short nextShort() {
        return Short.parseShort(next());
    }

    
    /**
     * Scans next token of the input as a byte.
     * @return The byte scanned from the input.
     * @throws NoSuchElementException If no more tokens are available to read.
     * @throws InputMismatchException If the next token does not match the Byte regular expression,
     *         or does not match size.
     */
    
    public byte nextByte() {
        return Byte.parseByte(next());
    }

    
    /**
     * Advances scanner past the current line and returns the input that was skipped.
     * This method returns the rest of the current line, excluding any line separator at the end.
     * The position is set to the beginning of the next line.
     * @return The string that was skipped.
     * @throws NoSuchElementException If no more lines are available read.
     */
    
    public String nextLine() {
        try {
            if (tokenize == null || !tokenize.hasMoreTokens()) {
                return read.readLine(); // Read the next line
            }
            StringBuilder sb = new StringBuilder();
            while (tokenize.hasMoreTokens()) {
                sb.append(tokenize.nextToken());
                if (tokenize.hasMoreTokens()) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new NoSuchElementException("Error: " + e.getMessage());
        }
    }

    
    /**
     * Scans next token of the input as a boolean.
     * @return The boolean scanned from the input.
     * @throws NoSuchElementException If no more tokens are available.
     * @throws InputMismatchException If the next token does not match the Boolean regular expression,
     *         which is defined as true or false, ignores case.
     */
    
    public boolean nextBoolean() {
        String token = next().toLowerCase();
        if (token.equals("true") || token.equals("false")) {
            return Boolean.parseBoolean(token);
        } else {
            throw new InputMismatchException("Input is not a valid boolean value: " + token);
        }
    }


    
    /**
     * Sets delimiter used to tokenize the input string.
     * @param pattern The delimiter pattern as a String.
     */
    
    public void useDelimiter(String pattern) {
        tokenize = null; 
        read = new BufferedReader(new TokenizingReader(read, pattern)); 
    }

    
    /**
     * Checks if there is more input to be read.
     * @return true if there is more input, false if not.
     */
    
    public boolean hasNext() {
        try {
            if (tokenize != null && tokenize.hasMoreTokens()) {
                return true; 
            }
            String line = read.readLine(); 
            if (line != null) {
                tokenize = new StringTokenizer(line); 
                return true; 
            }
            return false; 
        } catch (IOException e) {
            return false; 
        }
    }

        
    /**
     * Checks if there is a next integer token to be read.
     * @return true if there is a next integer token, false if not.
     */
    
    public boolean hasNextInt() {
        try {
            if (tokenize != null && tokenize.hasMoreTokens()) {
                Integer.parseInt(tokenize.nextToken()); 
                return true;
            }
            String line = read.readLine(); 
            if (line != null) {
                tokenize = new StringTokenizer(line); 
                if (tokenize.hasMoreTokens()) {
                    Integer.parseInt(tokenize.nextToken()); 
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException | IOException e) {
            return false; 
        }
    }

   
    
    /**
     * Checks if there is a next double token to be read.
     * @return true if there is a next double token, false if not.
     */
    
    public boolean hasNextDouble() {
        try {
            if (tokenize != null && tokenize.hasMoreTokens()) {
                Double.parseDouble(tokenize.nextToken()); 
                return true;
            }
            String line = read.readLine(); 
            if (line != null) {
                tokenize = new StringTokenizer(line); 
                if (tokenize.hasMoreTokens()) {
                    Double.parseDouble(tokenize.nextToken()); 
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException | IOException e) {
            return false; 
        }
    }
}


class TokenizingReader extends Reader {
    private BufferedReader reader; 
    private String pattern; 
    private StringBuilder buffer = new StringBuilder();

    
    /**
     * Constructs a new TokenizingReader with the delimiter.
     * @param reader A BufferedReader object to read input.
     * @param pattern The delimiter pattern as a String.
     */
    
    public TokenizingReader(BufferedReader reader, String pattern) {
        this.reader = reader; 
        this.pattern = pattern; 
    }

    /**
     * Overrides the read() method of the Reader class to read the next character from the input stream.
     * If buffer is empty, it reads the next line from the underlying reader and adds it to the buffer.
     * If end is reached, returns -1.
     * @return The next character read from input stream, or -1 if the limit of stream is reached.
     * @throws IOException If an I/O error occurs while reading from the input stream.
     */
    
    @Override
    public int read() throws IOException {
        if (buffer.length() == 0) {
            String line = reader.readLine(); 
            if (line == null) {
                return -1; 
            }
            buffer.append(line).append('\n');
        }
        return buffer.charAt(0); 
    }

    /**
     * Overrides read(char[], int, int) method of the Reader class to read characters into a portion of an array.
     * If the buffer is empty and has reached the end of input, returns -1.
     * Copies characters from buffer to array, up to the specified length.
     * Deletes read characters from buffer.
     * @param charBuf The character buffer into which the data is read.
     * @param off The start offset in the character array where data is written.
     * @param lengt The number of characters to read.
     * @return The total number of characters read into buffer, or -1 if the end has been reached.
     * @throws IOException If an I/O error occurs while reading the data.
     */
    
    @Override
    public int read(char[] charBuf, int off, int lengt) throws IOException {
        if (buffer.length() == 0 && read() == -1) {
            return -1; 
        }
        int length = Math.min(lengt, buffer.length()); 
        buffer.getChars(0, length, charBuf, off); 
        buffer.delete(0, length); 
        return length; 
    }

    /**
     * Overrides close() method of Reader class to close the underlying reader.
     * Closes reader, to save space.
     * @throws IOException If an I/O error occurs while closing.
     */
    
    @Override
    public void close() throws IOException {
    	reader.close(); 
        
    }
}
