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
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.CTBookmark;
import org.docx4j.wml.CTMarkupRange;
import org.docx4j.wml.CTTabStop;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.R;
import org.docx4j.wml.R.Tab;
import org.docx4j.wml.STTabJc;
import org.docx4j.wml.STTabTlc;
import org.docx4j.wml.SectPr;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblWidth;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.TcPrInner.HMerge;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.docx4j.wml.Tabs;

public class DocxRaportWriter {
	private static WordprocessingMLPackage wordPackage;
	private static ObjectFactory factory = Context.getWmlObjectFactory();

	public static int createDocument() {

		try {
			wordPackage = WordprocessingMLPackage.createPackage(PageSizePaper.A4, true);
			MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
			mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
			mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
			File exportFile = new File("welcome.docx");

			createPlaceDescription(mainDocumentPart, "Województwo: ");
			createPlaceDescription(mainDocumentPart, "Powiat: ");
			createPlaceDescription(mainDocumentPart, "Jednostka ewidencyjna: ");
			createPlaceDescription(mainDocumentPart, "Obręb: - nazwa: ");
			createPlaceDescription(mainDocumentPart, "numer: ");
			
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

			mainDocumentPart.getContent().add(tbl);

			wordPackage.save(exportFile);
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public static void createPlaceDescription(MainDocumentPart mainDocumentPart, String nameOfDescAttribute) {

		// Create object for p
		P p = factory.createP();
		mainDocumentPart.getContent().add(p);
		// Create object for pPr
		PPr ppr = factory.createPPr();
		p.setPPr(ppr);
		// Create object for tabs
		Tabs tabs = factory.createTabs();
		ppr.setTabs(tabs);
		// Create object for tab
		CTTabStop tabstop = factory.createCTTabStop();
		tabs.getTab().add(tabstop);
		tabstop.setPos(BigInteger.valueOf(10206));
		tabstop.setVal(org.docx4j.wml.STTabJc.LEFT);
		// Create object for tab
		CTTabStop tabstop2 = factory.createCTTabStop();
		tabs.getTab().add(tabstop2);
		tabstop2.setPos(BigInteger.valueOf(14004));
		tabstop2.setVal(org.docx4j.wml.STTabJc.RIGHT);
		tabstop2.setLeader(org.docx4j.wml.STTabTlc.DOT);
		// Create object for r
		R r = factory.createR();
		p.getContent().add(r);
		// Create object for tab (wrapped in JAXBElement)
		R.Tab rtab = factory.createRTab();
		JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = factory.createRTab(rtab);
		r.getContent().add(rtabWrapped);
		// Create object for t (wrapped in JAXBElement)
		Text text = factory.createText();
		JAXBElement<org.docx4j.wml.Text> textWrapped = factory.createRT(text);
		r.getContent().add(textWrapped);
		text.setValue(nameOfDescAttribute);
		// Create object for r
		R r2 = factory.createR();
		p.getContent().add(r2);
		// Create object for tab (wrapped in JAXBElement)
		R.Tab rtab2 = factory.createRTab();
		JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped2 = factory.createRTab(rtab2);
		r2.getContent().add(rtabWrapped2);

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
				vMerge = factory.createTcPrInnerVMerge();
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

	public int createDocument1() {
		WordprocessingMLPackage wordPackage = null;
		File exportFile = new File("raport.docx");
		MainDocumentPart mainDocumentPart = null;
		try {
			wordPackage = WordprocessingMLPackage.createPackage(PageSizePaper.A4, true);
			mainDocumentPart = wordPackage.getMainDocumentPart();
			mainDocumentPart.addStyledParagraphOfText("Title", "Raport badania KW");

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectFactory factory = Context.getWmlObjectFactory();
		P p = (P) factory.createP();
		int writableWidthTwips = wordPackage.getDocumentModel().getSections().get(0).getPageDimensions()
				.getWritableWidthTwips();
		int columnNumber = 3;
		Tbl tbl = TblFactory.createTable(3, 3, writableWidthTwips / columnNumber);

		List<Object> rows = tbl.getContent();
		for (Object row : rows) {
			Tr tr = (Tr) row;
			List<Object> cells = tr.getContent();
			for (Object cell : cells) {
				Tc td = (Tc) cell;
				td.getContent().add(p);
			}
		}
		for (int i = 0; i < 1; i++) {
			Tr tr = (Tr) rows.get(i);
			Tc hMergedCell = (Tc) createTableCellGspan(wordPackage, null, 2);
			TblWidth tbWidth = new TblWidth();
			tbWidth.setW(new BigInteger("" + (writableWidthTwips / columnNumber) * 2));
			tbWidth.setType(TblWidth.TYPE_DXA);
			hMergedCell.getTcPr().setTcW(tbWidth);

			tr.getContent().set(0, hMergedCell);
			tr.getContent().remove(1);

		}
		mainDocumentPart.getContent().add(tbl);

		try {
			wordPackage.save(exportFile);
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
/*
 * Horizontal merge public static Tc
 * createTableCellGspan(WordprocessingMLPackage wordMLPackage, P p, int
 * gridspan) { org.docx4j.wml.Tc tc = factory.createTc(); org.docx4j.wml.TcPr
 * tcpr = factory.createTcPr(); tc.setTcPr(tcpr); CTVerticalJc valign =
 * factory.createCTVerticalJc(); valign.setVal(STVerticalJc.TOP);
 * tcpr.setVAlign(valign); org.docx4j.wml.TcPrInner.GridSpan gspan =
 * factory.createTcPrInnerGridSpan(); gspan.setVal(new BigInteger("" +
 * gridspan)); tcpr.setGridSpan(gspan); tc.getEGBlockLevelElts().add(p); return
 * tc; }
 */

/*
 * Horiznotal merge public static Tc
 * createTableCellVMerge(WordprocessingMLPackage wordMLPackage, P p, String
 * vMerge) { org.docx4j.wml.Tc tc = factory.createTc(); org.docx4j.wml.TcPr tcpr
 * = factory.createTcPr(); tc.setTcPr(tcpr); CTVerticalJc valign =
 * factory.createCTVerticalJc(); valign.setVal(STVerticalJc.TOP);
 * tcpr.setVAlign(valign);
 * 
 * org.docx4j.wml.TcPrInner.VMerge vm = factory.createTcPrInnerVMerge();
 * vm.setVal(vMerge); tcpr.setVMerge(vm);
 * 
 * tc.getEGBlockLevelElts().add(p); return tc; }
 * 
 */
