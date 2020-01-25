package kw.raport.model.docxWriter;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.jaxb.Context;

import org.docx4j.model.structure.PageSizePaper;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.CTColumns;
import org.docx4j.wml.CTTabStop;
import org.docx4j.wml.CTVerticalJc;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.HpsMeasure;
import org.docx4j.wml.Jc;
import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.PPrBase;
import org.docx4j.wml.ParaRPr;
import org.docx4j.wml.R;
import org.docx4j.wml.RFonts;
import org.docx4j.wml.RPr;
import org.docx4j.wml.STVerticalJc;
import org.docx4j.wml.SectPr;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.TcPrInner.HMerge;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.docx4j.wml.Tabs;

public class DocxRaportWriter {
	private static WordprocessingMLPackage wordPackage;
	private static ObjectFactory wmlObjectFactory = Context.getWmlObjectFactory();
	private static Body body = wmlObjectFactory.createBody(); 

	public static int createDocument() {

		try {
			wordPackage = WordprocessingMLPackage.createPackage(PageSizePaper.A4, true);
			MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
			mainDocumentPart.getContent().add(body);
			setMarigins();
			File exportFile = new File("welcome.docx");

			addLocationDescriptionLine( "Województwo: ");
			addLocationDescriptionLine( "Powiat: ");
			addLocationDescriptionLine( "Jednostka ewidencyjna: ");
			addLocationDescriptionLine( "Obręb: - nazwa: ");
			addLocationDescriptionLine( "numer: ");
			
			int writableWidthTwips = wordPackage.getDocumentModel().getSections().get(0).getPageDimensions()
					.getWritableWidthTwips();
			int columnNumber = 3;
			Tbl tbl = TblFactory.createTable(4, 11, writableWidthTwips / columnNumber);

			mergeCellsHorizontal(tbl, 0, 1, 3);
			mergeCellsHorizontal(tbl, 0, 7, 8);
			mergeCellsVertically(tbl, 0, 0, 1);
			mergeCellsVertically(tbl, 4, 0, 1);
			mergeCellsVertically(tbl, 5, 0, 1);
			mergeCellsVertically(tbl, 6, 0, 1);
			mergeCellsVertically(tbl, 10, 0, 1);
			
			writeTextInCell("Lp.", tbl, 0, 0, JcEnumeration.CENTER);
			writeTextInCell("1", tbl, 2, 0, JcEnumeration.CENTER);

			writeTextInCell("DZIAŁ I", tbl, 0, 1, JcEnumeration.CENTER);
			writeTextInCell("Numer księgi wieczystej lub zbioru dokumentów", tbl, 1, 1, JcEnumeration.CENTER);
				writeTextInCell("Nazwa nieruchomości", tbl, 1, 1, JcEnumeration.CENTER);
			writeTextInCell("2", tbl, 2, 1, JcEnumeration.CENTER);

			writeTextInCell("Numer działki", tbl, 1, 2, JcEnumeration.CENTER);
			writeTextInCell("3", tbl, 2, 2, JcEnumeration.CENTER);
			writeTextInCell("Pole powierzchni", tbl, 1, 3, JcEnumeration.CENTER);
			writeTextInCell("4", tbl, 2, 3, JcEnumeration.CENTER);
			
			writeTextInCell("Położenie", tbl, 0, 4, JcEnumeration.CENTER);
				writeTextInCell("nieruchomości i inne informacje o sposobie wykorzystania", tbl, 0, 4, JcEnumeration.CENTER);
			writeTextInCell("5", tbl, 2, 4, JcEnumeration.CENTER);

			writeTextInCell("Rodzaj nieruchomości", tbl, 0, 5, JcEnumeration.CENTER);
			writeTextInCell("6", tbl, 2, 5, JcEnumeration.CENTER);

			writeTextInCell("Informacje o mapach", tbl, 0, 6, JcEnumeration.CENTER);
			writeTextInCell("7", tbl, 2, 6, JcEnumeration.CENTER);
			
			writeTextInCell("DZIAŁ II", tbl, 0, 7, JcEnumeration.CENTER);
			writeTextInCell("1.Właściciel", tbl, 1, 7, JcEnumeration.CENTER);
				writeTextInCell("2.Wieczysty użytkownik", tbl, 1, 7, JcEnumeration.CENTER);
				writeTextInCell("-----------------------------", tbl, 1, 7, JcEnumeration.CENTER);
				writeTextInCell("Imię i nazwisko, imiona rodziców lub nazwa osoby prawnej, adres", tbl, 1, 7, JcEnumeration.CENTER);
			writeTextInCell("8", tbl, 2, 7, JcEnumeration.CENTER);
				
			writeTextInCell("Podstawa ustalenia danych wym.", tbl, 1, 8, JcEnumeration.CENTER);
				writeTextInCell("w kol. 8", tbl, 1, 8, JcEnumeration.CENTER);
			writeTextInCell("9", tbl, 2, 8, JcEnumeration.CENTER);
			
			writeTextInCell("DZIAŁ III", tbl, 0, 9, JcEnumeration.CENTER);
			writeTextInCell("Rodzaj ograniczonych", tbl, 1, 9, JcEnumeration.CENTER);
				writeTextInCell("praw rzeczowych", tbl, 1, 9, JcEnumeration.CENTER);
				writeTextInCell("-----------------------", tbl, 1, 9, JcEnumeration.CENTER);
				writeTextInCell("Podstawa wpisu", tbl, 1, 9, JcEnumeration.CENTER);
			writeTextInCell("10", tbl, 2, 9, JcEnumeration.CENTER);

			writeTextInCell("UWAGI", tbl, 0, 10, JcEnumeration.CENTER);
			writeTextInCell("11", tbl, 2, 10, JcEnumeration.CENTER);
			
			createTitle();

			mainDocumentPart.getContent().add(tbl);

			wordPackage.save(exportFile);
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	private static void writeTextInCell(String text, Tbl table, int tacleRow, int tableColumn, JcEnumeration position) {
		
		Tc tableCell = getTc(table, tacleRow, tableColumn);
		CTVerticalJc ctVerticalJc = wmlObjectFactory.createCTVerticalJc();
		ctVerticalJc.setVal(STVerticalJc.CENTER);
		tableCell.getTcPr().setVAlign(ctVerticalJc);
		P p = wmlObjectFactory.createP();
		R r  = wmlObjectFactory.createR();
		p.getContent().add(r);
		setFontProperties(r, "Times New Roman", 16);
		writeTextInP(r, text);
		setHorizontalTextPosition(p, position);
		P toOwerwriteIfNull = (P)tableCell.getContent().get(0);
		
		if(checkIfPHasAllFieldsNull(toOwerwriteIfNull)&& tableCell.getContent().size()==1) {
		tableCell.getContent().set(0, p);
		}else {
			tableCell.getContent().add(p);
		}
		
	}
	
	private static boolean checkIfPHasAllFieldsNull(P pToCheck) {
		return (pToCheck.getParaId()==null
				&& pToCheck.getPPr()==null
				&& pToCheck.getRsidDel()==null
				&& pToCheck.getRsidP()==null
				&& pToCheck.getRsidR()==null
				&& pToCheck.getRsidRDefault()==null
				&& pToCheck.getRsidRPr()==null
				&& pToCheck.getTextId()==null);
	}
	
	private static P writeLine(String text, String fontName, int fontSize) {
		
		P p = wmlObjectFactory.createP();	
		R r = wmlObjectFactory.createR();
		
		p.getContent().add(r);
		
		setFontProperties(r, "Times New Roman", 28);
		
		writeTabInP(r);
		writeTextInP(r, text);
		writeTabInP(r);
	
		return p;
	}
	
	private static void setFontProperties(R r,String fontName, int fontSize) {
		
		RFonts rFonts = wmlObjectFactory.createRFonts();
        rFonts.setAscii(fontName);
        rFonts.setHAnsi(fontName);
        
        RPr rPr = wmlObjectFactory.createRPr();
		
		//Create object for font size
		   HpsMeasure hpsmeasure = wmlObjectFactory.createHpsMeasure(); 
		hpsmeasure.setVal(BigInteger.valueOf(fontSize));
		
		//Set font size and type
		rPr.setSz(hpsmeasure);
		rPr.setRFonts(rFonts);
		r.setRPr(rPr);
	}
	
	private static void setHorizontalTextPosition(P p, JcEnumeration position ) {
		
		PPr pPr = wmlObjectFactory.createPPr();
		
		 Jc jc = wmlObjectFactory.createJc(); 
         pPr.setJc(jc); 
             jc.setVal(position);
             
             p.setPPr(pPr);
	}
	
	private static P setPropertiesForTabs(P p, int leftTabInTwips, int rightTabInTwips) {
		
		PPr ppr = wmlObjectFactory.createPPr();
		p.setPPr(ppr);
		
		// Create object for tabs
				Tabs tabs = wmlObjectFactory.createTabs();
				ppr.setTabs(tabs);
				//create single tab - LEFT
				CTTabStop tabstop = wmlObjectFactory.createCTTabStop();
				tabs.getTab().add(tabstop);
				tabstop.setPos(BigInteger.valueOf(leftTabInTwips));
				tabstop.setVal(org.docx4j.wml.STTabJc.LEFT);
				
				//create single tab - RIGHT
				CTTabStop tabstop2 = wmlObjectFactory.createCTTabStop();
				tabs.getTab().add(tabstop2);
				tabstop2.setPos(BigInteger.valueOf(15450));
				tabstop2.setVal(org.docx4j.wml.STTabJc.RIGHT);
				tabstop2.setLeader(org.docx4j.wml.STTabTlc.DOT);
		
		return p;	
	}
	
	private static void writeTextInP(R r, String textToWrite) {
		
		Text text = wmlObjectFactory.createText();
		JAXBElement<org.docx4j.wml.Text> textWrapped = wmlObjectFactory.createRT(text);
		r.getContent().add(textWrapped);
		text.setValue(textToWrite);
		
		
	}
	
	private static void writeTabInP(R r) {
		R.Tab rtab = wmlObjectFactory.createRTab();
		JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = wmlObjectFactory.createRTab(rtab);
		r.getContent().add(rtabWrapped);
	}
	
	public static void addLocationDescriptionLine( String nameOfDescAttribute) {
		
				P p = writeLine(nameOfDescAttribute, "Times New Roman", 24);
				body.getContent().add(p);
				setPropertiesForTabs(p, 10206, 15450);
	}
	
	public static void createTitle() {
	
		    RFonts rFonts = wmlObjectFactory.createRFonts();
            rFonts.setAscii("Times New Roman");
            rFonts.setHAnsi("Times New Roman");
		
		 P p = wmlObjectFactory.createP(); 
		 body.getContent().add( p); 
	            // Create object for pPr
	            PPr ppr = wmlObjectFactory.createPPr(); 
	            p.setPPr(ppr); 
	            
	            Jc jc1 = wmlObjectFactory.createJc(); 
                ppr.setJc(jc1); 
                    jc1.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                // Create object for rPr
	                ParaRPr pararpr = wmlObjectFactory.createParaRPr(); 
	                ppr.setRPr(pararpr); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr.setSz(hpsmeasure); 
	                        hpsmeasure.setVal( BigInteger.valueOf( 28) ); 
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    pararpr.setB(booleandefaulttrue); 
	                // Create object for pStyle
	                PPrBase.PStyle pprbasepstyle = wmlObjectFactory.createPPrBasePStyle(); 
	                ppr.setPStyle(pprbasepstyle); 
	                    pprbasepstyle.setVal( "Nagwek1"); 
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr.setSpacing(pprbasespacing); 
	                    pprbasespacing.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r = wmlObjectFactory.createR(); 
	            writeTextInP(r, "PROTOKÓŁ");
	            setFontProperties(r, "Times New Roman", 28);
	            p.getContent().add( r); 
	       
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue2 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    r.getRPr().setB(booleandefaulttrue2);	                    
	                   
	          
	        // Create object for p
	        P p2 = wmlObjectFactory.createP(); 
	        body.getContent().add( p2); 
	            // Create object for pPr
	            PPr ppr2 = wmlObjectFactory.createPPr(); 
	            p2.setPPr(ppr2); 
	                // Create object for rPr
	                ParaRPr pararpr2 = wmlObjectFactory.createParaRPr(); 
	                ppr2.setRPr(pararpr2); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure3 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr2.setSz(hpsmeasure3); 
	                    
	                        hpsmeasure3.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for jc
	                Jc jc = wmlObjectFactory.createJc(); 
	                ppr2.setJc(jc); 
	                    jc.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing2 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr2.setSpacing(pprbasespacing2); 
	                    pprbasespacing2.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing2.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r2 = wmlObjectFactory.createR(); 
	            p2.getContent().add( r2); 
	                // Create object for rPr
	                RPr rpr2 = wmlObjectFactory.createRPr(); 
	                r2.setRPr(rpr2); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure4 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr2.setSz(hpsmeasure4); 
	                    rpr2.setRFonts(rFonts);
	                        hpsmeasure4.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text2 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped2 = wmlObjectFactory.createRT(text2); 
	                r2.getContent().add( textWrapped2); 
	                    text2.setValue( "badania ksiąg wieczystych (dla nieruchomości gruntowych)"); 
	        // Create object for p
	        P p3 = wmlObjectFactory.createP(); 
	        body.getContent().add( p3); 
	            // Create object for pPr
	            PPr ppr3 = wmlObjectFactory.createPPr(); 
	            p3.setPPr(ppr3); 
	                // Create object for rPr
	                ParaRPr pararpr3 = wmlObjectFactory.createParaRPr(); 
	                ppr3.setRPr(pararpr3); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure5 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr3.setSz(hpsmeasure5); 
	                        hpsmeasure5.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for jc
	                Jc jc2 = wmlObjectFactory.createJc(); 
	                ppr3.setJc(jc2); 
	                    jc2.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                // Create object for tabs
	                Tabs tabs = wmlObjectFactory.createTabs(); 
	                ppr3.setTabs(tabs); 
	                    // Create object for tab
	                    CTTabStop tabstop = wmlObjectFactory.createCTTabStop(); 
	                    tabs.getTab().add( tabstop); 
	                        tabstop.setPos( BigInteger.valueOf( 7797) ); 
	                        tabstop.setVal(org.docx4j.wml.STTabJc.CENTER);
	                        tabstop.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing3 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr3.setSpacing(pprbasespacing3); 
	                    pprbasespacing3.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing3.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r3 = wmlObjectFactory.createR(); 
	            p3.getContent().add( r3); 
	                // Create object for rPr
	                RPr rpr3 = wmlObjectFactory.createRPr(); 
	                r3.setRPr(rpr3); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure6 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr3.setSz(hpsmeasure6); 
	                    rpr3.setRFonts(rFonts);
	                        hpsmeasure6.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text3 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped3 = wmlObjectFactory.createRT(text3); 
	                r3.getContent().add( textWrapped3); 
	                    text3.setValue( "w Sądzie Rejonowym w"); 
	            // Create object for r
	            R r4 = wmlObjectFactory.createR(); 
	            p3.getContent().add( r4); 
	                // Create object for rPr
	                RPr rpr4 = wmlObjectFactory.createRPr(); 
	                r4.setRPr(rpr4); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure7 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr4.setSz(hpsmeasure7); 
	                        hpsmeasure7.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = wmlObjectFactory.createRTab(rtab); 
	                r4.getContent().add( rtabWrapped); 
	        // Create object for p
	        P p4 = wmlObjectFactory.createP(); 
	        body.getContent().add( p4); 
	            // Create object for pPr
	            PPr ppr4 = wmlObjectFactory.createPPr(); 
	            p4.setPPr(ppr4); 
	                // Create object for rPr
	                ParaRPr pararpr4 = wmlObjectFactory.createParaRPr(); 
	                ppr4.setRPr(pararpr4); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure8 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr4.setSz(hpsmeasure8); 
	                        hpsmeasure8.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for ind
	                PPrBase.Ind pprbaseind = wmlObjectFactory.createPPrBaseInd(); 
	                ppr4.setInd(pprbaseind); 
	                    pprbaseind.setLeft( BigInteger.valueOf( 284) ); 
	                // Create object for tabs
	                Tabs tabs2 = wmlObjectFactory.createTabs(); 
	                ppr4.setTabs(tabs2); 
	                    // Create object for tab
	                    CTTabStop tabstop2 = wmlObjectFactory.createCTTabStop(); 
	                    tabs2.getTab().add( tabstop2); 
	                        tabstop2.setPos( BigInteger.valueOf( 3828) ); 
	                        tabstop2.setVal(org.docx4j.wml.STTabJc.LEFT);
	                        tabstop2.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing4 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr4.setSpacing(pprbasespacing4); 
	                    pprbasespacing4.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing4.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r5 = wmlObjectFactory.createR(); 
	            p4.getContent().add( r5); 
	                // Create object for rPr
	                RPr rpr5 = wmlObjectFactory.createRPr(); 
	                r5.setRPr(rpr5); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure9 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr5.setSz(hpsmeasure9); 
	                    rpr5.setRFonts(rFonts);
	                        hpsmeasure9.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text4 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped4 = wmlObjectFactory.createRT(text4); 
	                r5.getContent().add( textWrapped4); 
	                    text4.setValue( "Data"); 
	            // Create object for r
	            R r6 = wmlObjectFactory.createR(); 
	            p4.getContent().add( r6); 
	                // Create object for rPr
	                RPr rpr6 = wmlObjectFactory.createRPr(); 
	                r6.setRPr(rpr6); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure10 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr6.setSz(hpsmeasure10); 
	                        hpsmeasure10.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab2 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped2 = wmlObjectFactory.createRTab(rtab2); 
	                r6.getContent().add( rtabWrapped2); 
	        // Create object for sectPr
	              
	   
	}
	
	private static void setMarigins() {
		  SectPr sectpr = wordPackage.getDocumentModel().getSections().get(0)
                  .getSectPr();
//  SectPr sectpr = wmlObjectFactory.createSectPr(); 
		  body.setSectPr(sectpr); 
 
      // Create object for pgMar
      SectPr.PgMar sectprpgmar = wmlObjectFactory.createSectPrPgMar(); 
      sectpr.setPgMar(sectprpgmar); 
          sectprpgmar.setGutter( BigInteger.valueOf( 0) ); 
          sectprpgmar.setLeft( BigInteger.valueOf( 566) ); 
          sectprpgmar.setRight( BigInteger.valueOf( 566) ); 
          sectprpgmar.setTop( BigInteger.valueOf( 566) ); 
          sectprpgmar.setBottom( BigInteger.valueOf( 566) ); 
          sectprpgmar.setHeader( BigInteger.valueOf( 708) ); 
          sectprpgmar.setFooter( BigInteger.valueOf( 708) ); 
      // Create object for cols
      CTColumns columns = wmlObjectFactory.createCTColumns(); 
      sectpr.setCols(columns); 
          columns.setSpace( BigInteger.valueOf( 708) ); 
	}

	public static void mergeCellsVertically(Tbl tbl, int col, int fromRow, int toRow) {
		if (col < 0 || fromRow < 0 || toRow < 0) {
			return;
		}
		for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
			Tc tc = getTc(tbl, rowIndex, col);
			if (tc == null) {
				break;
			}
			TcPr tcPr = getTcPr(tc);
			VMerge vMerge = tcPr.getVMerge();
			if (vMerge == null) {
				vMerge = wmlObjectFactory.createTcPrInnerVMerge();
				tcPr.setVMerge(vMerge);
			}
			if (rowIndex == fromRow) {
				vMerge.setVal("restart");
			} else {
				vMerge.setVal("continue");
			}
		}
	}

	public static TcPr getTcPr(Tc tc) {
		TcPr tcPr = tc.getTcPr();
		if (tcPr == null) {
			tcPr = new TcPr();
			tc.setTcPr(tcPr);
		}
		return tcPr;
	}

	public static Tc getTc(Tbl tbl, int row, int cell) {
		if (row < 0 || cell < 0) {
			return null;
		}
		List<Tr> trList = getTblAllTr(tbl);
		if (row >= trList.size()) {
			return null;
		}
		List<Tc> tcList = getTrAllCell(trList.get(row));
		if (cell >= tcList.size()) {
			return null;
		}
		return tcList.get(cell);
	}

	public static List<Tc> getTrAllCell(Tr tr) {
		List<Object> objList = getAllElementFromObject(tr, Tc.class);
		List<Tc> tcList = new ArrayList<Tc>();
		if (objList == null) {
			return tcList;
		}
		for (Object tcObj : objList) {
			if (tcObj instanceof Tc) {
				Tc objTc = (Tc) tcObj;
				tcList.add(objTc);
			}
		}
		return tcList;
	}

	public static List<Tr> getTblAllTr(Tbl tbl) {
		List<Object> objList = getAllElementFromObject(tbl, Tr.class);
		List<Tr> trList = new ArrayList<Tr>();
		if (objList == null) {
			return trList;
		}
		for (Object obj : objList) {
			if (obj instanceof Tr) {
				Tr tr = (Tr) obj;
				trList.add(tr);
			}
		}
		return trList;
	}

	public static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
		List<Object> result = new ArrayList<Object>();
		if (obj instanceof JAXBElement) {
			obj = ((JAXBElement<?>) obj).getValue();
		}
		if (obj.getClass().equals(toSearch)) {
			result.add(obj);
		} else if (obj instanceof ContentAccessor) {
			List<?> children = ((ContentAccessor) obj).getContent();
			for (Object child : children) {
				result.addAll(getAllElementFromObject(child, toSearch));
			}
		}
		return result;
	}

	public static Tc createTableCellGspan(WordprocessingMLPackage wordMLPackage, P p, int gridspan) {
		ObjectFactory factory = Context.getWmlObjectFactory();
		org.docx4j.wml.Tc tc = factory.createTc();
		org.docx4j.wml.TcPr tcpr = factory.createTcPr();
		tc.setTcPr(tcpr);
		// CTVerticalJc valign = factory.createCTVerticalJc();
		// valign.setVal(STVerticalJc.TOP);
		// tcpr.setVAlign(valign);
		org.docx4j.wml.TcPrInner.GridSpan gspan = factory.createTcPrInnerGridSpan();
		gspan.setVal(new BigInteger("" + gridspan));
		tcpr.setGridSpan(gspan);
		tc.getContent().add(p);
		return tc;
	}

	public static void mergeCellsHorizontal(Tbl tbl, int row, int fromCell, int toCell) {
		if (row < 0 || fromCell < 0 || toCell < 0) {
			return;
		}
		List<Tr> trList = getTblAllTr(tbl);
		if (row > trList.size()) {
			return;
		}
		Tr tr = trList.get(row);
		List<Tc> tcList = getTrAllCell(tr);
		for (int cellIndex = fromCell, len = Math.min(tcList.size() - 1, toCell); cellIndex <= len; cellIndex++) {
			Tc tc = tcList.get(cellIndex);
			TcPr tcPr = getTcPr(tc);
			HMerge hMerge = tcPr.getHMerge();
			if (hMerge == null) {
				hMerge = new HMerge();
				tcPr.setHMerge(hMerge);
			}
			if (cellIndex == fromCell) {
				hMerge.setVal("restart");
			} else {
				hMerge.setVal("continue");
			}
		}
	}
}
