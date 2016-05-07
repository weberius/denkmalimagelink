package de.illilli.opendata.service.denkmalimagelink;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AskForAddressTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testVonSparrStrasse() throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/q_von_sparr_strasse.html");
		AskForAddress afa = new AskForAddress(inputStream);
		List<String> hrefList = afa.getHrefList();
		for (String href : hrefList) {
			System.out.println(href);
		}
	}

}
