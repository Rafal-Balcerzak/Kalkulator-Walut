package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFile {
    public List<Cube> parseXML(String filename) {

        List<Cube> cubeList = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(filename));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Cube");

            for (int i = 2; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    cubeList.add(new Cube(element.getAttribute("currency"),
                            Double.parseDouble(element.getAttribute("rate"))));
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return cubeList;
    }
}

