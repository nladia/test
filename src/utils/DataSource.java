package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataSource {

	public static List<String> readFromFile(String fileName) {
		List<String> lines = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(s -> lines.add(s.trim()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
	
	public static void writeToFile(String fileName, List<String> lines) {
		Path file = Paths.get(fileName);
		try {
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
