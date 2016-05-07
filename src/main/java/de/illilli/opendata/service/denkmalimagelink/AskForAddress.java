package de.illilli.opendata.service.denkmalimagelink;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/**
 * Beispiel: <a
 * href="http://www.bilderbuch-koeln.de/Suche?q=von%20sparr%20strasse%2034">von
 * sparr strasse 34</a>
 *
 */
public class AskForAddress {

	public static final String charSet = "UTF-8";
	public static final String urlString = "http://www.bilderbuch-koeln.de/Suche?q=";
	public static final int timeoutMillis = 1000;
	private List<String> hrefList = new ArrayList<String>();
	private Document doc;

	public AskForAddress(String q) throws IOException {
		URL url = new URL(urlString + URLEncoder.encode(q.trim(), charSet));
		doc = Jsoup.parse(url, timeoutMillis);
	}

	public AskForAddress(InputStream inputStream) throws IOException {
		String html = IOUtils.toString(inputStream);
		doc = Jsoup.parse(html, charSet);
	}

	public List<String> getHrefList() {
		Element mainElement = doc.getElementById("main");
		Element searchResultsElement = mainElement.child(2);
		List<Node> nodeList = searchResultsElement.childNodes();
		boolean isFirst = true;
		for (Node li : nodeList) {
			if (isFirst) {
				isFirst = false;
			} else {
				int childNodeSize = li.childNodeSize();
				Node aNode = li.childNode(2);
				String href = aNode.attr("href");

				hrefList.add(href);
				System.out.println(href);
			}
		}
		return hrefList;
	}
}
