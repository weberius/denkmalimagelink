package de.illilli.opendata.service.denkmalimagelink;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class AskForImageLinkTest {

	public static final String encoding = "UTF-8";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetImageLinkForImage59075() throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/image_59075.html");
		String html = IOUtils.toString(inputStream, encoding);
		String imageLink = new AskForImageLink(html).getImageLink();
		System.out.println(imageLink);
	}

}
