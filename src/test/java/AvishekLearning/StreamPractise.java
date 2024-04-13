package AvishekLearning;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Stream.of("Avishek", "Janu", "Raja", "Niru", "Arav","Akash").collect(Collectors.toList());
		Stream hello = names.stream().filter(s -> s.startsWith("A")).filter(s -> s.length()>4).map(s -> s.toUpperCase()).sorted();
		
		

	}

}
