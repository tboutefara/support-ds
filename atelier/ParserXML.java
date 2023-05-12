/*
 * ParserXML.java
 * 
 * Copyright 2023 Tarek <t_boutefara@esi.dz>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class ParserXML {
	
	public static void main (String args[]) {
		
		try{
			JFrame maFrame = new JFrame();
			maFrame.setSize(600, 400);
			maFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			DefaultTableModel dtm = new DefaultTableModel(null, new String[]{"id", "titre", "date de pub."});
			JTable table = new JTable(dtm);
			
			File fichierXml =new File("exemple.xml");
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(fichierXml);
			
			Element racine = document.getDocumentElement();
			NodeList fils = racine.getChildNodes();
			
			for(int i = 0; i < fils.getLength(); i++){
				Node node = fils.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element e = (Element) node;
					NodeList infos = e.getChildNodes();
					
					String[] donnees = new String[3];
					int k = 0;
					
					for(int j = 0; j < infos.getLength(); j++){
						Node node2 = infos.item(j);
						if(node2.getNodeType() == Node.ELEMENT_NODE){
							Element e2 = (Element) node2;
							// System.out.println(e2.getTagName() + " " + e2.getTextContent());
							donnees[k] = e2.getTextContent();
							k++;
						}
					}
					
					dtm.addRow(donnees);
				}
			}
			
			maFrame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
			maFrame.setVisible(true);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

