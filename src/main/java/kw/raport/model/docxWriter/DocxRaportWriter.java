package kw.raport.model.docxWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.Docx4J;
import org.docx4j.jaxb.Context;

import org.docx4j.model.structure.PageSizePaper;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;
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
import org.docx4j.wml.STTabJc;
import org.docx4j.wml.STTabTlc;
import org.docx4j.wml.STVerticalJc;
import org.docx4j.wml.SectPr;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.TcPrInner.HMerge;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;

import kw.raport.model.raportData.RaportData;
import kw.raport.model.raportData.RaportData.Description;
import kw.raport.model.raportData.limitedRights.LimitedRights;
import kw.raport.model.raportData.owner.EntryBasis;
import kw.raport.model.raportData.owner.Owner;

import org.docx4j.wml.Tabs;

public class DocxRaportWriter {
	private static WordprocessingMLPackage wordPackage;
	private static ObjectFactory wmlObjectFactory = Context.getWmlObjectFactory();
	private static Body body = wmlObjectFactory.createBody();

	public static ByteArrayOutputStream createDocument(RaportData raportData) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		try {
			wordPackage = WordprocessingMLPackage.createPackage(PageSizePaper.A4, true);
			MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
			mainDocumentPart.getContent().add(body);
			
			//wordPackage.save(outStream, Docx4J.FLAG_SAVE_ZIP_FILE);
			
			setMarigins();
			

			addLocationDescriptionLine("Województwo: " + raportData.getVoivodenship());
			addLocationDescriptionLine("Powiat: " + raportData.getCounty());
			addLocationDescriptionLine("Jednostka ewidencyjna: " + raportData.getLandRegistryUnit());
			addLocationDescriptionLine("Obręb: - nazwa: " + raportData.getRegistrationPrecinct());
			addLocationDescriptionLine("numer: " + raportData.getRegistrationPrecinctNumber());

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
			writeTextInCell(raportData.getLandAndMortgageRegisterNumber(), tbl, 3, 1, JcEnumeration.CENTER);
			writeTextInCell("Nazwa nieruchomości", tbl, 1, 1, JcEnumeration.CENTER);
			writeTextInCell("2", tbl, 2, 1, JcEnumeration.CENTER);

			writeTextInCell("Numer działki", tbl, 1, 2, JcEnumeration.CENTER);
			writeTextInCell("3", tbl, 2, 2, JcEnumeration.CENTER);
			writeTextInCell(raportData.getPlotOfLandNumbersAsString(), tbl, 3, 2, JcEnumeration.CENTER);
			writeTextInCell("Pole powierzchni", tbl, 1, 3, JcEnumeration.CENTER);
			writeTextInCell("4", tbl, 2, 3, JcEnumeration.CENTER);
			writeTextInCell(raportData.getRealEstateArea(), tbl, 3, 3, JcEnumeration.CENTER);

			writeTextInCell("Położenie", tbl, 0, 4, JcEnumeration.CENTER);
			writeTextInCell("nieruchomości i inne informacje o sposobie wykorzystania", tbl, 0, 4,
					JcEnumeration.CENTER);
			writeTextInCell("5", tbl, 2, 4, JcEnumeration.CENTER);
			writeTextInCell(raportData.getDescriptionForGroupedPlotsOfLand(Description.LOCATION), tbl, 3, 4, JcEnumeration.CENTER);
			writeTextInCell(raportData.getDescriptionForGroupedPlotsOfLand(Description.WAY_TO_USE), tbl, 3, 4, JcEnumeration.CENTER);

			
			writeTextInCell("Rodzaj nieruchomości", tbl, 0, 5, JcEnumeration.CENTER);
			writeTextInCell("6", tbl, 2, 5, JcEnumeration.CENTER);
			writeTextInCell("Nieruchomość gruntowa",tbl	, 3, 5, JcEnumeration.CENTER);

			writeTextInCell("Informacje o mapach", tbl, 0, 6, JcEnumeration.CENTER);
			writeTextInCell("7", tbl, 2, 6, JcEnumeration.CENTER);
			writeTextInCell(raportData.getMapInformationAsString(), tbl, 3, 6, JcEnumeration.CENTER);
			

			writeTextInCell("DZIAŁ II", tbl, 0, 7, JcEnumeration.CENTER);
			writeTextInCell("1.Właściciel", tbl, 1, 7, JcEnumeration.CENTER);
			writeTextInCell("2.Wieczysty użytkownik", tbl, 1, 7, JcEnumeration.CENTER);
			writeTextInCell("-----------------------------", tbl, 1, 7, JcEnumeration.CENTER);
			writeTextInCell("Imię i nazwisko, imiona rodziców lub nazwa osoby prawnej, adres", tbl, 1, 7,
					JcEnumeration.CENTER);
			writeTextInCell("8", tbl, 2, 7, JcEnumeration.CENTER);
			
			for (Owner owner : raportData.getOwners()) {
				writeTextInCell(owner.asString(), tbl, 3, 7, JcEnumeration.CENTER);
			}


			writeTextInCell("Podstawa ustalenia danych wym.", tbl, 1, 8, JcEnumeration.CENTER);
			writeTextInCell("w kol. 8", tbl, 1, 8, JcEnumeration.CENTER);
			writeTextInCell("9", tbl, 2, 8, JcEnumeration.CENTER);
			for(EntryBasis ownerEntryBasis : raportData.getOwnerEntryBasis() ) {
				writeTextInCell(ownerEntryBasis.asString(), tbl, 3, 8, JcEnumeration.CENTER);
			}

			writeTextInCell("DZIAŁ III", tbl, 0, 9, JcEnumeration.CENTER);
			writeTextInCell("Rodzaj ograniczonych", tbl, 1, 9, JcEnumeration.CENTER);
			writeTextInCell("praw rzeczowych", tbl, 1, 9, JcEnumeration.CENTER);
			writeTextInCell("-----------------------", tbl, 1, 9, JcEnumeration.CENTER);
			writeTextInCell("Podstawa wpisu", tbl, 1, 9, JcEnumeration.CENTER);
			writeTextInCell("10", tbl, 2, 9, JcEnumeration.CENTER);
			if(raportData.getLimitedRights() != null) {
				for(LimitedRights limitedRights : raportData.getLimitedRights()) {
					writeTextInCell(limitedRights.asString(), tbl, 3, 9, JcEnumeration.CENTER);
				}
			}
			if(raportData.getLimitedRightsEntryBasis() !=null) {
				for(EntryBasis limitedRightsEntryBasis : raportData.getLimitedRightsEntryBasis()) {
					writeTextInCell(limitedRightsEntryBasis.asString(), tbl, 3, 9, JcEnumeration.CENTER);
				}
			}

			writeTextInCell("UWAGI", tbl, 0, 10, JcEnumeration.CENTER);
			writeTextInCell("11", tbl, 2, 10, JcEnumeration.CENTER);

			createTitle(raportData);
			
			File exportFile=  new File("rap.docx");

			mainDocumentPart.getContent().add(tbl);
			createFooter(raportData);
			//wordPackage.save(outStream, Docx4J.FLAG_SAVE_ZIP_FILE);
			wordPackage.save(exportFile);
			
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wordPackage.save(outStream, Docx4J.FLAG_SAVE_ZIP_FILE);
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outStream;
	}

	private static void writeTextInCell(String text, Tbl table, int tacleRow, int tableColumn, JcEnumeration position) {

		Tc tableCell = getTc(table, tacleRow, tableColumn);
		CTVerticalJc ctVerticalJc = wmlObjectFactory.createCTVerticalJc();
		ctVerticalJc.setVal(STVerticalJc.CENTER);
		tableCell.getTcPr().setVAlign(ctVerticalJc);
		P p = wmlObjectFactory.createP();
		R r = wmlObjectFactory.createR();
		p.getContent().add(r);
		setFontProperties(r, "Times New Roman", 16);
		writeTextInP(r, text);
		setHorizontalTextPosition(p, position);
		P toOwerwriteIfNull = (P) tableCell.getContent().get(0);

		if (checkIfPHasAllFieldsNull(toOwerwriteIfNull) && tableCell.getContent().size() == 1) {
			tableCell.getContent().set(0, p);
		} else {
			tableCell.getContent().add(p);
		}

	}

	private static boolean checkIfPHasAllFieldsNull(P pToCheck) {
		return (pToCheck.getParaId() == null && pToCheck.getPPr() == null && pToCheck.getRsidDel() == null
				&& pToCheck.getRsidP() == null && pToCheck.getRsidR() == null && pToCheck.getRsidRDefault() == null
				&& pToCheck.getRsidRPr() == null && pToCheck.getTextId() == null);
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

	private static void setFontProperties(R r, String fontName, int fontSize) {

		RFonts rFonts = wmlObjectFactory.createRFonts();
		rFonts.setAscii(fontName);
		rFonts.setHAnsi(fontName);

		RPr rPr = wmlObjectFactory.createRPr();

		// Create object for font size
		HpsMeasure hpsmeasure = wmlObjectFactory.createHpsMeasure();
		hpsmeasure.setVal(BigInteger.valueOf(fontSize));

		// Set font size and type
		rPr.setSz(hpsmeasure);
		rPr.setRFonts(rFonts);
		r.setRPr(rPr);
	}

	private static void setHorizontalTextPosition(P p, JcEnumeration position) {

		PPr pPr = wmlObjectFactory.createPPr();

		Jc jc = wmlObjectFactory.createJc();
		pPr.setJc(jc);
		jc.setVal(position);

		p.setPPr(pPr);
	}

	// To add only 1 tab then secondTabInTwips=-1 and secondTabType=null
	private static P setPropertiesForTabs(P p, int firstTabInTwips, int secondTabInTwips, STTabJc firstTabType,
			STTabJc secondTabType, STTabTlc firstTabStyle) {
		PPr ppr;
		if (p.getPPr() == null) {
			ppr = wmlObjectFactory.createPPr();
		} else {
			ppr = p.getPPr();
		}

		p.setPPr(ppr);
		Tabs tabs = wmlObjectFactory.createTabs();
		// Create object for tabs

		ppr.setTabs(tabs);
		// create single tab - LEFT
		CTTabStop tabstop = wmlObjectFactory.createCTTabStop();
		tabs.getTab().add(tabstop);
		tabstop.setPos(BigInteger.valueOf(firstTabInTwips));
		tabstop.setVal(firstTabType);
		tabstop.setLeader(firstTabStyle);

		if (secondTabInTwips >= 0) {
			// create single tab - RIGHT
			CTTabStop tabstop2 = wmlObjectFactory.createCTTabStop();
			tabs.getTab().add(tabstop2);
			tabstop2.setPos(BigInteger.valueOf(secondTabInTwips));
			tabstop2.setVal(secondTabType);
			tabstop2.setLeader(org.docx4j.wml.STTabTlc.DOT);
		}

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

	public static void addLocationDescriptionLine(String nameOfDescAttribute) {

		P p = writeLine(nameOfDescAttribute, "Times New Roman", 24);
		body.getContent().add(p);
		setPropertiesForTabs(p, 10206, 15450, STTabJc.LEFT, STTabJc.RIGHT, null);
	}

	private static void setParagraphSpacingProperties(P paragraph, JcEnumeration horizontalAlign, int verticalSpacing) {
		PPr ppr;
		if (paragraph.getPPr() == null) {
			ppr = wmlObjectFactory.createPPr();
		} else {
			ppr = paragraph.getPPr();
		}
		paragraph.setPPr(ppr);
		Jc jc1 = wmlObjectFactory.createJc();
		ppr.setJc(jc1);
		jc1.setVal(horizontalAlign);
		// Create object for rPr
		ParaRPr pararpr = wmlObjectFactory.createParaRPr();
		ppr.setRPr(pararpr);

		PPrBase.Spacing pprbasespacing = wmlObjectFactory.createPPrBaseSpacing();
		ppr.setSpacing(pprbasespacing);
		pprbasespacing.setLine(BigInteger.valueOf(verticalSpacing)); // !Vertical spacing
		pprbasespacing.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
		pprbasespacing.setAfter(BigInteger.valueOf(0));

	}

	private static P createParagraphWithText(String textToWrite, JcEnumeration horizontalAlign, int verticalSpacing,
			String fontName, int fontSize) {
		P p = wmlObjectFactory.createP();
		body.getContent().add(p);

		setParagraphSpacingProperties(p, horizontalAlign, verticalSpacing);

		R r = wmlObjectFactory.createR();
		p.getContent().add(r);

		writeTextInP(r, textToWrite);
		setFontProperties(r, fontName, fontSize);

		return p;
	}
	
	private static void createFooter(RaportData raportData) {
		createParagraphWithText("Wykonawca: " + raportData.getAuthor(), JcEnumeration.RIGHT, 0, "Times New Roman", 24);
		createParagraphWithText("Nr upr. zawod: " + raportData.getprofessionalQualificationsNumber(), JcEnumeration.RIGHT, 0, "Times New Roman", 24);
		createParagraphWithText("Data:...............................................................", JcEnumeration.RIGHT, 0, "Times New Roman", 24);

	}

	private static void createTitle(RaportData raportData) {
		createParagraphWithText("PROTOKÓŁ", JcEnumeration.CENTER, 360, "Times New Roman", 28);

		createParagraphWithText("badania ksiąg wieczystych (dla nieruchomości gruntowych)", JcEnumeration.CENTER, 360,
				"Times New Roman", 28);

		// Create object for p
		P p3 = createParagraphWithText("w Sądzie Rejonowym w " + raportData.getCourthouse(), JcEnumeration.CENTER, 360, "Times New Roman", 28);

		setPropertiesForTabs(p3, 7797, -1, STTabJc.CENTER, null, STTabTlc.DOT);

		// Create object for r
		R r4 = wmlObjectFactory.createR();
		p3.getContent().add(r4);
		writeTabInP(r4);

		// Create object for p
		P p4 = createParagraphWithText("Data: " + raportData.getCreationDateSimple(), JcEnumeration.LEFT, 360, "Times New Roman", 24);

		// Create object for pPr
		PPr ppr4 = p4.getPPr();
		PPrBase.Ind pprbaseind = wmlObjectFactory.createPPrBaseInd();
		ppr4.setInd(pprbaseind);
		pprbaseind.setLeft(BigInteger.valueOf(284));
		// Create object for tabs
		setPropertiesForTabs(p4, 3828, -1, STTabJc.LEFT, null, STTabTlc.DOT);

		// Create object for r
		R r6 = wmlObjectFactory.createR();
		p4.getContent().add(r6);
		writeTabInP(r6);

	}

	private static void setMarigins() {
		SectPr sectpr = wordPackage.getDocumentModel().getSections().get(0).getSectPr();
//  SectPr sectpr = wmlObjectFactory.createSectPr(); 
		body.setSectPr(sectpr);

		// Create object for pgMar
		SectPr.PgMar sectprpgmar = wmlObjectFactory.createSectPrPgMar();
		sectpr.setPgMar(sectprpgmar);
		sectprpgmar.setGutter(BigInteger.valueOf(0));
		sectprpgmar.setLeft(BigInteger.valueOf(566));
		sectprpgmar.setRight(BigInteger.valueOf(566));
		sectprpgmar.setTop(BigInteger.valueOf(566));
		sectprpgmar.setBottom(BigInteger.valueOf(566));
		sectprpgmar.setHeader(BigInteger.valueOf(708));
		sectprpgmar.setFooter(BigInteger.valueOf(708));
		// Create object for cols
		CTColumns columns = wmlObjectFactory.createCTColumns();
		sectpr.setCols(columns);
		columns.setSpace(BigInteger.valueOf(708));
	}

	private static void mergeCellsVertically(Tbl tbl, int col, int fromRow, int toRow) {
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

	private static TcPr getTcPr(Tc tc) {
		TcPr tcPr = tc.getTcPr();
		if (tcPr == null) {
			tcPr = new TcPr();
			tc.setTcPr(tcPr);
		}
		return tcPr;
	}

	private static Tc getTc(Tbl tbl, int row, int cell) {
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

	private static List<Tc> getTrAllCell(Tr tr) {
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

	private static List<Tr> getTblAllTr(Tbl tbl) {
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

	private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
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

	private static Tc createTableCellGspan(WordprocessingMLPackage wordMLPackage, P p, int gridspan) {
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

	private static void mergeCellsHorizontal(Tbl tbl, int row, int fromCell, int toCell) {
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
