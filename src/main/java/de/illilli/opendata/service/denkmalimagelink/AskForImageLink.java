package de.illilli.opendata.service.denkmalimagelink;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class AskForImageLink {

	private String imageLink;

	/**
	 * <pre>
	 * ...
	 * <a 
	 *   href="/bilder/k%C3%B6ln_neustadt_nord_blumenthalstr_21_denkmal_denkmalschutz_konservator_stadt_historisch_6a5159075_1200x1600xin.jpeg"
	 *   class="border-radius" 
	 *   id="image_link" 
	 *   onclick="return false;" 
	 *   style="display:block;overflow:hidden;position:relative;width:600px;height:450px">
	 * <img 
	 *   alt="Blumenthalstr. 21, 50670 Köln - Neustadt-Nord (1975)" 
	 *   border="0" 
	 *   city="Köln" 
	 *   class="bilderbuch_image medium_image" 
	 *   deg="360" editor="true" exact_address="true" galleryimg="no" height="450" id="image_59075" image_id="59075" 
	 *   lat="50.9552096" lng="6.9603096" login="Konservator" 
	 *   src="http://in3.bilderbuch-koeln.de/bilder/k%C3%B6ln_neustadt_nord_blumenthalstr_21_denkmal_denkmalschutz_konservator_stadt_historisch_6a5159075_600x450xfr.jpeg" 
	 *   style="display:block;z-index:2;position:absolute" 
	 *   title="Blumenthalstr. 21, 50670 Köln - Neustadt-Nord (1975)" width="600" zip="50670">
	 * </a>
	 * ...
	 * </pre>
	 * 
	 * @param html
	 */
	public AskForImageLink(String html) {
		imageLink = html;
		Document doc = Jsoup.parse(html);
		Element image_link = doc.getElementById("image_link");
		Node imgNode = image_link.childNode(0);
		imageLink = imgNode.attr("src");
	}

	public String getImageLink() {
		return imageLink;
	}
}
