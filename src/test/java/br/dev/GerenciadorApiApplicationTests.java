package br.dev;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GerenciadorApiApplicationTests {

	@Test
	public int levenshtein(String hello, String kelo) {
		
		int i = 0;
		int distance = 0;
		int helloLen = hello.length();
		int keloLen = kelo.length();
		
		while (helloLen > i || keloLen > i) {
			char helloChar = hello.charAt((helloLen > i ? i : helloLen-1));
			char keloChar = kelo.charAt((keloLen > i ? i : keloLen-1));
			
			if (helloChar != keloChar) {
				distance++;
			}
			
			i++;
		}
		return distance;
		
		//assertEquals(2, distance);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String hello = "hello";
		String kelo = "elo";
		int levenshtein = new GerenciadorApiApplicationTests().levenshtein(hello,kelo);
		
		System.out.println("MyDistance: " + levenshtein);
		System.out.println("SUDistance: " + StringUtils.getLevenshteinDistance(hello,kelo));
		System.out.println("TXDistance: " + new LevenshteinDistance().apply(hello,kelo));
	}
	
}
