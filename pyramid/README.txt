Siddhartha Pattni

Har packat min kod i en jar-fil med namnet Wineglasspyramid.jar
för att köra den så använd java -jar Wineglasspyramid.jar i en terminal eller
konsole.




Jag har använt mig av följande länkar från nätet som hjälp för att förstå 
uppgiften.

[1] http://mathforum.org/kb/message.jspa?messageID=445581
[2] http://stackoverflow.com/questions/12721730/champagne-pyramid-distribution-puzzle

Har dock inte lyckats att förstå hur jag skall summera varje enskild nods tid för att
få rätt resultat. Som framgår i uppgiften skall glas två på rad fem ta 136,66666 sekunder
vilket jag får fram om jag summerar enligt följande.

System.out.println("Tid för glas 2 på femte raden "
			+ (timePyramid[0][0] + timePyramid[1][0] + timePyramid[2][0]
					+ timePyramid[3][1] + timePyramid[4][1]));
	

Men om jag skulle ändra från timePyramid[2][0] till timePyramid[2][1] ovan skiljer det sig. Har inte lyckats ta fram en generell algoritm för att summera tiderna för varje glass.