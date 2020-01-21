package kw.raport.model.docxWriter;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import org.docx4j.vml.CTLine;
import org.docx4j.wml.Body;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.CTBorder;
import org.docx4j.wml.CTColumns;
import org.docx4j.wml.CTHeight;
import org.docx4j.wml.CTTabStop;
import org.docx4j.wml.CTTblCellMar;
import org.docx4j.wml.CTTblLayoutType;
import org.docx4j.wml.CTTblLook;
import org.docx4j.wml.CTVerticalJc;
import org.docx4j.wml.Document;
import org.docx4j.wml.HeaderReference;
import org.docx4j.wml.HpsMeasure;
import org.docx4j.wml.Jc;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.PPrBase;
import org.docx4j.wml.PPrBase.Ind;
import org.docx4j.wml.PPrBase.PStyle;
import org.docx4j.wml.PPrBase.Spacing;
import org.docx4j.wml.ParaRPr;
import org.docx4j.wml.Pict;
import org.docx4j.wml.R;
import org.docx4j.wml.R.Tab;
import org.docx4j.wml.RPr;
import org.docx4j.wml.SectPr;
import org.docx4j.wml.SectPr.PgMar;
import org.docx4j.wml.SectPr.PgSz;
import org.docx4j.wml.Tabs;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblBorders;
import org.docx4j.wml.TblGrid;
import org.docx4j.wml.TblGridCol;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.TblWidth;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.TcPrInner;
import org.docx4j.wml.TcPrInner.GridSpan;
import org.docx4j.wml.TcPrInner.TcBorders;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.docx4j.wml.TrPr;

public class DocxRaportCreator {
	



	
	public Document createIt() {

	org.docx4j.wml.ObjectFactory wmlObjectFactory = new org.docx4j.wml.ObjectFactory();

	Document document = wmlObjectFactory.createDocument(); 
	    // Create object for body
	    Body body = wmlObjectFactory.createBody(); 
	    document.setBody(body); 
	        // Create object for p
	        P p = wmlObjectFactory.createP(); 
	        body.getContent().add( p); 
	            // Create object for pPr
	            PPr ppr = wmlObjectFactory.createPPr(); 
	            p.setPPr(ppr); 
	                // Create object for pStyle
	                PPrBase.PStyle pprbasepstyle = wmlObjectFactory.createPPrBasePStyle(); 
	                ppr.setPStyle(pprbasepstyle); 
	                    pprbasepstyle.setVal( "Nagwek2"); 
	                // Create object for tabs
	                Tabs tabs = wmlObjectFactory.createTabs(); 
	                ppr.setTabs(tabs); 
	                    // Create object for tab
	                    CTTabStop tabstop = wmlObjectFactory.createCTTabStop(); 
	                    tabs.getTab().add( tabstop); 
	                        tabstop.setPos( BigInteger.valueOf( 15451) ); 
	                        tabstop.setVal(org.docx4j.wml.STTabJc.RIGHT);
	                        tabstop.setLeader(org.docx4j.wml.STTabTlc.DOT);
	            // Create object for r
	            R r = wmlObjectFactory.createR(); 
	            p.getContent().add( r); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = wmlObjectFactory.createRTab(rtab); 
	                r.getContent().add( rtabWrapped); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped = wmlObjectFactory.createRT(text); 
	                r.getContent().add( textWrapped); 
	                    text.setValue( "Województwo"); 
	            // Create object for r
	            R r2 = wmlObjectFactory.createR(); 
	            p.getContent().add( r2); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab2 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped2 = wmlObjectFactory.createRTab(rtab2); 
	                r2.getContent().add( rtabWrapped2); 
	        // Create object for p
	        P p2 = wmlObjectFactory.createP(); 
	        body.getContent().add( p2); 
	            // Create object for pPr
	            PPr ppr2 = wmlObjectFactory.createPPr(); 
	            p2.setPPr(ppr2); 
	                // Create object for rPr
	                ParaRPr pararpr = wmlObjectFactory.createParaRPr(); 
	                ppr2.setRPr(pararpr); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr.setSz(hpsmeasure); 
	                        hpsmeasure.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tabs
	                Tabs tabs2 = wmlObjectFactory.createTabs(); 
	                ppr2.setTabs(tabs2); 
	                    // Create object for tab
	                    CTTabStop tabstop2 = wmlObjectFactory.createCTTabStop(); 
	                    tabs2.getTab().add( tabstop2); 
	                        tabstop2.setPos( BigInteger.valueOf( 10206) ); 
	                        tabstop2.setVal(org.docx4j.wml.STTabJc.LEFT);
	                    // Create object for tab
	                    CTTabStop tabstop3 = wmlObjectFactory.createCTTabStop(); 
	                    tabs2.getTab().add( tabstop3); 
	                        tabstop3.setPos( BigInteger.valueOf( 15451) ); 
	                        tabstop3.setVal(org.docx4j.wml.STTabJc.RIGHT);
	                        tabstop3.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr2.setSpacing(pprbasespacing); 
	                    pprbasespacing.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r3 = wmlObjectFactory.createR(); 
	            p2.getContent().add( r3); 
	                // Create object for rPr
	                RPr rpr = wmlObjectFactory.createRPr(); 
	                
	                r3.setRPr(rpr); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure2 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr.setSz(hpsmeasure2); 
	                        hpsmeasure2.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab3 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped3 = wmlObjectFactory.createRTab(rtab3); 
	                r3.getContent().add( rtabWrapped3); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text2 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped2 = wmlObjectFactory.createRT(text2); 
	                r3.getContent().add( textWrapped2); 
	                    text2.setValue( "Powiat "); 
	                    text2.setSpace( "preserve"); 
	            // Create object for r
	            R r4 = wmlObjectFactory.createR(); 
	            p2.getContent().add( r4); 
	                // Create object for rPr
	                RPr rpr2 = wmlObjectFactory.createRPr(); 
	                r4.setRPr(rpr2); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure3 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr2.setSz(hpsmeasure3); 
	                        hpsmeasure3.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab4 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped4 = wmlObjectFactory.createRTab(rtab4); 
	                r4.getContent().add( rtabWrapped4); 
	        // Create object for p
	        P p3 = wmlObjectFactory.createP(); 
	        body.getContent().add( p3); 
	            // Create object for pPr
	            PPr ppr3 = wmlObjectFactory.createPPr(); 
	            p3.setPPr(ppr3); 
	                // Create object for rPr
	                ParaRPr pararpr2 = wmlObjectFactory.createParaRPr(); 
	                ppr3.setRPr(pararpr2); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure4 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr2.setSz(hpsmeasure4); 
	                        hpsmeasure4.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tabs
	                Tabs tabs3 = wmlObjectFactory.createTabs(); 
	                ppr3.setTabs(tabs3); 
	                    // Create object for tab
	                    CTTabStop tabstop4 = wmlObjectFactory.createCTTabStop(); 
	                    tabs3.getTab().add( tabstop4); 
	                        tabstop4.setPos( BigInteger.valueOf( 10206) ); 
	                        tabstop4.setVal(org.docx4j.wml.STTabJc.LEFT);
	                    // Create object for tab
	                    CTTabStop tabstop5 = wmlObjectFactory.createCTTabStop(); 
	                    tabs3.getTab().add( tabstop5); 
	                        tabstop5.setPos( BigInteger.valueOf( 15451) ); 
	                        tabstop5.setVal(org.docx4j.wml.STTabJc.RIGHT);
	                        tabstop5.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing2 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr3.setSpacing(pprbasespacing2); 
	                    pprbasespacing2.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing2.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r5 = wmlObjectFactory.createR(); 
	            p3.getContent().add( r5); 
	                // Create object for rPr
	                RPr rpr3 = wmlObjectFactory.createRPr(); 
	                r5.setRPr(rpr3); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure5 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr3.setSz(hpsmeasure5); 
	                        hpsmeasure5.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab5 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped5 = wmlObjectFactory.createRTab(rtab5); 
	                r5.getContent().add( rtabWrapped5); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text3 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped3 = wmlObjectFactory.createRT(text3); 
	                r5.getContent().add( textWrapped3); 
	                    text3.setValue( "Jednostka ewidencyjna "); 
	                    text3.setSpace( "preserve"); 
	            // Create object for r
	            R r6 = wmlObjectFactory.createR(); 
	            p3.getContent().add( r6); 
	                // Create object for rPr
	                RPr rpr4 = wmlObjectFactory.createRPr(); 
	                r6.setRPr(rpr4); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure6 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr4.setSz(hpsmeasure6); 
	                        hpsmeasure6.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab6 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped6 = wmlObjectFactory.createRTab(rtab6); 
	                r6.getContent().add( rtabWrapped6); 
	        // Create object for p
	        P p4 = wmlObjectFactory.createP(); 
	        body.getContent().add( p4); 
	            // Create object for pPr
	            PPr ppr4 = wmlObjectFactory.createPPr(); 
	            p4.setPPr(ppr4); 
	                // Create object for rPr
	                ParaRPr pararpr3 = wmlObjectFactory.createParaRPr(); 
	                ppr4.setRPr(pararpr3); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure7 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr3.setSz(hpsmeasure7); 
	                        hpsmeasure7.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tabs
	                Tabs tabs4 = wmlObjectFactory.createTabs(); 
	                ppr4.setTabs(tabs4); 
	                    // Create object for tab
	                    CTTabStop tabstop6 = wmlObjectFactory.createCTTabStop(); 
	                    tabs4.getTab().add( tabstop6); 
	                        tabstop6.setPos( BigInteger.valueOf( 10206) ); 
	                        tabstop6.setVal(org.docx4j.wml.STTabJc.LEFT);
	                    // Create object for tab
	                    CTTabStop tabstop7 = wmlObjectFactory.createCTTabStop(); 
	                    tabs4.getTab().add( tabstop7); 
	                        tabstop7.setPos( BigInteger.valueOf( 15451) ); 
	                        tabstop7.setVal(org.docx4j.wml.STTabJc.RIGHT);
	                        tabstop7.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing3 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr4.setSpacing(pprbasespacing3); 
	                    pprbasespacing3.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing3.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r7 = wmlObjectFactory.createR(); 
	            p4.getContent().add( r7); 
	                // Create object for rPr
	                RPr rpr5 = wmlObjectFactory.createRPr(); 
	                r7.setRPr(rpr5); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure8 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr5.setSz(hpsmeasure8); 
	                        hpsmeasure8.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab7 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped7 = wmlObjectFactory.createRTab(rtab7); 
	                r7.getContent().add( rtabWrapped7); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text4 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped4 = wmlObjectFactory.createRT(text4); 
	                r7.getContent().add( textWrapped4); 
	                    text4.setValue( "Obręb: – nazwa "); 
	                    text4.setSpace( "preserve"); 
	            // Create object for r
	            R r8 = wmlObjectFactory.createR(); 
	            p4.getContent().add( r8); 
	                // Create object for rPr
	                RPr rpr6 = wmlObjectFactory.createRPr(); 
	                r8.setRPr(rpr6); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure9 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr6.setSz(hpsmeasure9); 
	                        hpsmeasure9.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab8 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped8 = wmlObjectFactory.createRTab(rtab8); 
	                r8.getContent().add( rtabWrapped8); 
	        // Create object for p
	        P p5 = wmlObjectFactory.createP(); 
	        body.getContent().add( p5); 
	            // Create object for pPr
	            PPr ppr5 = wmlObjectFactory.createPPr(); 
	            p5.setPPr(ppr5); 
	                // Create object for rPr
	                ParaRPr pararpr4 = wmlObjectFactory.createParaRPr(); 
	                ppr5.setRPr(pararpr4); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure10 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr4.setSz(hpsmeasure10); 
	                        hpsmeasure10.setVal( BigInteger.valueOf( 24) ); 
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    pararpr4.setB(booleandefaulttrue); 
	                // Create object for jc
	                Jc jc = wmlObjectFactory.createJc(); 
	                ppr5.setJc(jc); 
	                    jc.setVal(org.docx4j.wml.JcEnumeration.LEFT);
	                // Create object for pStyle
	                PPrBase.PStyle pprbasepstyle2 = wmlObjectFactory.createPPrBasePStyle(); 
	                ppr5.setPStyle(pprbasepstyle2); 
	                    pprbasepstyle2.setVal( "Tytu"); 
	                // Create object for tabs
	                Tabs tabs5 = wmlObjectFactory.createTabs(); 
	                ppr5.setTabs(tabs5); 
	                    // Create object for tab
	                    CTTabStop tabstop8 = wmlObjectFactory.createCTTabStop(); 
	                    tabs5.getTab().add( tabstop8); 
	                        tabstop8.setPos( BigInteger.valueOf( 10206) ); 
	                        tabstop8.setVal(org.docx4j.wml.STTabJc.LEFT);
	                    // Create object for tab
	                    CTTabStop tabstop9 = wmlObjectFactory.createCTTabStop(); 
	                    tabs5.getTab().add( tabstop9); 
	                        tabstop9.setPos( BigInteger.valueOf( 15451) ); 
	                        tabstop9.setVal(org.docx4j.wml.STTabJc.RIGHT);
	                        tabstop9.setLeader(org.docx4j.wml.STTabTlc.DOT);
	            // Create object for r
	            R r9 = wmlObjectFactory.createR(); 
	            p5.getContent().add( r9); 
	                // Create object for rPr
	                RPr rpr7 = wmlObjectFactory.createRPr(); 
	                r9.setRPr(rpr7); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure11 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr7.setSz(hpsmeasure11); 
	                        hpsmeasure11.setVal( BigInteger.valueOf( 24) ); 
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue2 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    rpr7.setB(booleandefaulttrue2); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab9 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped9 = wmlObjectFactory.createRTab(rtab9); 
	                r9.getContent().add( rtabWrapped9); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text5 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped5 = wmlObjectFactory.createRT(text5); 
	                r9.getContent().add( textWrapped5); 
	                    text5.setValue( ".......... – numer "); 
	                    text5.setSpace( "preserve"); 
	            // Create object for r
	            R r10 = wmlObjectFactory.createR(); 
	            p5.getContent().add( r10); 
	                // Create object for rPr
	                RPr rpr8 = wmlObjectFactory.createRPr(); 
	                r10.setRPr(rpr8); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure12 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr8.setSz(hpsmeasure12); 
	                        hpsmeasure12.setVal( BigInteger.valueOf( 24) ); 
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue3 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    rpr8.setB(booleandefaulttrue3); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab10 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped10 = wmlObjectFactory.createRTab(rtab10); 
	                r10.getContent().add( rtabWrapped10); 
	        // Create object for p
	        P p6 = wmlObjectFactory.createP(); 
	        body.getContent().add( p6); 
	            // Create object for pPr
	            PPr ppr6 = wmlObjectFactory.createPPr(); 
	            p6.setPPr(ppr6); 
	                // Create object for rPr
	                ParaRPr pararpr5 = wmlObjectFactory.createParaRPr(); 
	                ppr6.setRPr(pararpr5); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure13 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr5.setSz(hpsmeasure13); 
	                        hpsmeasure13.setVal( BigInteger.valueOf( 28) ); 
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue4 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    pararpr5.setB(booleandefaulttrue4); 
	                // Create object for pStyle
	                PPrBase.PStyle pprbasepstyle3 = wmlObjectFactory.createPPrBasePStyle(); 
	                ppr6.setPStyle(pprbasepstyle3); 
	                    pprbasepstyle3.setVal( "Nagwek1"); 
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing4 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr6.setSpacing(pprbasespacing4); 
	                    pprbasespacing4.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing4.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r11 = wmlObjectFactory.createR(); 
	            p6.getContent().add( r11); 
	                // Create object for rPr
	                RPr rpr9 = wmlObjectFactory.createRPr(); 
	                r11.setRPr(rpr9); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure14 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr9.setSz(hpsmeasure14); 
	                        hpsmeasure14.setVal( BigInteger.valueOf( 28) ); 
	                    // Create object for b
	                    BooleanDefaultTrue booleandefaulttrue5 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    rpr9.setB(booleandefaulttrue5); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text6 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped6 = wmlObjectFactory.createRT(text6); 
	                r11.getContent().add( textWrapped6); 
	                    text6.setValue( "PROTOKÓŁ"); 
	        // Create object for p
	        P p7 = wmlObjectFactory.createP(); 
	        body.getContent().add( p7); 
	            // Create object for pPr
	            PPr ppr7 = wmlObjectFactory.createPPr(); 
	            p7.setPPr(ppr7); 
	                // Create object for rPr
	                ParaRPr pararpr6 = wmlObjectFactory.createParaRPr(); 
	                ppr7.setRPr(pararpr6); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure15 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr6.setSz(hpsmeasure15); 
	                        hpsmeasure15.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for jc
	                Jc jc2 = wmlObjectFactory.createJc(); 
	                ppr7.setJc(jc2); 
	                    jc2.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing5 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr7.setSpacing(pprbasespacing5); 
	                    pprbasespacing5.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing5.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r12 = wmlObjectFactory.createR(); 
	            p7.getContent().add( r12); 
	                // Create object for rPr
	                RPr rpr10 = wmlObjectFactory.createRPr(); 
	                r12.setRPr(rpr10); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure16 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr10.setSz(hpsmeasure16); 
	                        hpsmeasure16.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text7 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped7 = wmlObjectFactory.createRT(text7); 
	                r12.getContent().add( textWrapped7); 
	                    text7.setValue( "badania ksiąg wieczystych (dla nieruchomości gruntowych)"); 
	        // Create object for p
	        P p8 = wmlObjectFactory.createP(); 
	        body.getContent().add( p8); 
	            // Create object for pPr
	            PPr ppr8 = wmlObjectFactory.createPPr(); 
	            p8.setPPr(ppr8); 
	                // Create object for rPr
	                ParaRPr pararpr7 = wmlObjectFactory.createParaRPr(); 
	                ppr8.setRPr(pararpr7); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure17 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr7.setSz(hpsmeasure17); 
	                        hpsmeasure17.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for jc
	                Jc jc3 = wmlObjectFactory.createJc(); 
	                ppr8.setJc(jc3); 
	                    jc3.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                // Create object for tabs
	                Tabs tabs6 = wmlObjectFactory.createTabs(); 
	                ppr8.setTabs(tabs6); 
	                    // Create object for tab
	                    CTTabStop tabstop10 = wmlObjectFactory.createCTTabStop(); 
	                    tabs6.getTab().add( tabstop10); 
	                        tabstop10.setPos( BigInteger.valueOf( 7797) ); 
	                        tabstop10.setVal(org.docx4j.wml.STTabJc.CENTER);
	                        tabstop10.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing6 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr8.setSpacing(pprbasespacing6); 
	                    pprbasespacing6.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing6.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r13 = wmlObjectFactory.createR(); 
	            p8.getContent().add( r13); 
	                // Create object for rPr
	                RPr rpr11 = wmlObjectFactory.createRPr(); 
	                r13.setRPr(rpr11); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure18 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr11.setSz(hpsmeasure18); 
	                        hpsmeasure18.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text8 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped8 = wmlObjectFactory.createRT(text8); 
	                r13.getContent().add( textWrapped8); 
	                    text8.setValue( "w Sądzie Rejonowym w"); 
	            // Create object for r
	            R r14 = wmlObjectFactory.createR(); 
	            p8.getContent().add( r14); 
	                // Create object for rPr
	                RPr rpr12 = wmlObjectFactory.createRPr(); 
	                r14.setRPr(rpr12); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure19 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr12.setSz(hpsmeasure19); 
	                        hpsmeasure19.setVal( BigInteger.valueOf( 28) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab11 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped11 = wmlObjectFactory.createRTab(rtab11); 
	                r14.getContent().add( rtabWrapped11); 
	        // Create object for p
	        P p9 = wmlObjectFactory.createP(); 
	        body.getContent().add( p9); 
	            // Create object for pPr
	            PPr ppr9 = wmlObjectFactory.createPPr(); 
	            p9.setPPr(ppr9); 
	                // Create object for rPr
	                ParaRPr pararpr8 = wmlObjectFactory.createParaRPr(); 
	                ppr9.setRPr(pararpr8); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure20 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr8.setSz(hpsmeasure20); 
	                        hpsmeasure20.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for ind
	                PPrBase.Ind pprbaseind = wmlObjectFactory.createPPrBaseInd(); 
	                ppr9.setInd(pprbaseind); 
	                    pprbaseind.setLeft( BigInteger.valueOf( 284) ); 
	                // Create object for tabs
	                Tabs tabs7 = wmlObjectFactory.createTabs(); 
	                ppr9.setTabs(tabs7); 
	                    // Create object for tab
	                    CTTabStop tabstop11 = wmlObjectFactory.createCTTabStop(); 
	                    tabs7.getTab().add( tabstop11); 
	                        tabstop11.setPos( BigInteger.valueOf( 3828) ); 
	                        tabstop11.setVal(org.docx4j.wml.STTabJc.LEFT);
	                        tabstop11.setLeader(org.docx4j.wml.STTabTlc.DOT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing7 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr9.setSpacing(pprbasespacing7); 
	                    pprbasespacing7.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing7.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r15 = wmlObjectFactory.createR(); 
	            p9.getContent().add( r15); 
	                // Create object for rPr
	                RPr rpr13 = wmlObjectFactory.createRPr(); 
	                r15.setRPr(rpr13); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure21 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr13.setSz(hpsmeasure21); 
	                        hpsmeasure21.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text9 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped9 = wmlObjectFactory.createRT(text9); 
	                r15.getContent().add( textWrapped9); 
	                    text9.setValue( "Data"); 
	            // Create object for r
	            R r16 = wmlObjectFactory.createR(); 
	            p9.getContent().add( r16); 
	                // Create object for rPr
	                RPr rpr14 = wmlObjectFactory.createRPr(); 
	                r16.setRPr(rpr14); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure22 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr14.setSz(hpsmeasure22); 
	                        hpsmeasure22.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab12 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped12 = wmlObjectFactory.createRTab(rtab12); 
	                r16.getContent().add( rtabWrapped12); 
	        // Create object for tbl (wrapped in JAXBElement) 
	        Tbl tbl = wmlObjectFactory.createTbl(); 
	        JAXBElement<org.docx4j.wml.Tbl> tblWrapped = wmlObjectFactory.createBodyTbl(tbl); 
	        body.getContent().add( tblWrapped); 
	            // Create object for tr
	            Tr tr = wmlObjectFactory.createTr(); 
	            tbl.getContent().add( tr); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped = wmlObjectFactory.createTrTc(tc); 
	                tr.getContent().add( tcWrapped); 
	                    // Create object for p
	                    P p10 = wmlObjectFactory.createP(); 
	                    tc.getContent().add( p10); 
	                        // Create object for pPr
	                        PPr ppr10 = wmlObjectFactory.createPPr(); 
	                        p10.setPPr(ppr10); 
	                            // Create object for rPr
	                            ParaRPr pararpr9 = wmlObjectFactory.createParaRPr(); 
	                            ppr10.setRPr(pararpr9); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure23 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr9.setSz(hpsmeasure23); 
	                                    hpsmeasure23.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc4 = wmlObjectFactory.createJc(); 
	                            ppr10.setJc(jc4); 
	                                jc4.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r17 = wmlObjectFactory.createR(); 
	                        p10.getContent().add( r17); 
	                            // Create object for rPr
	                            RPr rpr15 = wmlObjectFactory.createRPr(); 
	                            r17.setRPr(rpr15); 
	                                // Create object for noProof
	                                BooleanDefaultTrue booleandefaulttrue6 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                                rpr15.setNoProof(booleandefaulttrue6); 
	                            // Create object for pict (wrapped in JAXBElement) 
	                            Pict pict = wmlObjectFactory.createPict(); 
	                            JAXBElement<org.docx4j.wml.Pict> pictWrapped = wmlObjectFactory.createRPict(pict); 
	                            r17.getContent().add( pictWrapped); 
	org.docx4j.vml.ObjectFactory vmlObjectFactory = new org.docx4j.vml.ObjectFactory();
	                                // Create object for line (wrapped in JAXBElement) 
	                                CTLine line = vmlObjectFactory.createCTLine(); 
	                                JAXBElement<org.docx4j.vml.CTLine> lineWrapped = vmlObjectFactory.createLine(line); 
	                                pict.getAnyAndAny().add( lineWrapped); 
	                                    line.setFrom( "40.05pt,64.7pt"); 
	                                    line.setTo( "85.65pt,64.7pt"); 
	                                    line.setStyle( "position:absolute;z-index:251659264;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:0;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:0;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:page;mso-height-relative:page"); 
	                                    line.setVmlId( "Line 2"); 
	                                    line.setSpid( "_x0000_s1026"); 
	                                    line.setHralign(org.docx4j.vml.officedrawing.STHrAlign.LEFT);
	                                    line.setAllowincell(org.docx4j.vml.officedrawing.STTrueFalse.F);
	                                    line.setInsetmode(org.docx4j.vml.officedrawing.STInsetMode.CUSTOM);
	                                    line.setConnectortype(org.docx4j.vml.officedrawing.STConnectorType.STRAIGHT);
	                        // Create object for r
	                        R r18 = wmlObjectFactory.createR(); 
	                        p10.getContent().add( r18); 
	                            // Create object for rPr
	                            RPr rpr16 = wmlObjectFactory.createRPr(); 
	                            r18.setRPr(rpr16); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure24 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr16.setSz(hpsmeasure24); 
	                                    hpsmeasure24.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text10 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped10 = wmlObjectFactory.createRT(text10); 
	                            r18.getContent().add( textWrapped10); 
	                                text10.setValue( "Lp."); 
	                    // Create object for tcPr
	                    TcPr tcpr = wmlObjectFactory.createTcPr(); 
	                    tc.setTcPr(tcpr); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr.setVAlign(verticaljc); 
	                            verticaljc.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr.setVMerge(tcprinnervmerge); 
	                            tcprinnervmerge.setVal( "restart"); 
	                        // Create object for tcW
	                        TblWidth tblwidth = wmlObjectFactory.createTblWidth(); 
	                        tcpr.setTcW(tblwidth); 
	                            tblwidth.setW( BigInteger.valueOf( 425) ); 
	                            tblwidth.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc2 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped2 = wmlObjectFactory.createTrTc(tc2); 
	                tr.getContent().add( tcWrapped2); 
	                    // Create object for p
	                    P p11 = wmlObjectFactory.createP(); 
	                    tc2.getContent().add( p11); 
	                        // Create object for pPr
	                        PPr ppr11 = wmlObjectFactory.createPPr(); 
	                        p11.setPPr(ppr11); 
	                            // Create object for rPr
	                            ParaRPr pararpr10 = wmlObjectFactory.createParaRPr(); 
	                            ppr11.setRPr(pararpr10); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure25 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr10.setSz(hpsmeasure25); 
	                                    hpsmeasure25.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc5 = wmlObjectFactory.createJc(); 
	                            ppr11.setJc(jc5); 
	                                jc5.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r19 = wmlObjectFactory.createR(); 
	                        p11.getContent().add( r19); 
	                            // Create object for rPr
	                            RPr rpr17 = wmlObjectFactory.createRPr(); 
	                            r19.setRPr(rpr17); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure26 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr17.setSz(hpsmeasure26); 
	                                    hpsmeasure26.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text11 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped11 = wmlObjectFactory.createRT(text11); 
	                            r19.getContent().add( textWrapped11); 
	                                text11.setValue( "DZIAŁ I"); 
	                    // Create object for tcPr
	                    TcPr tcpr2 = wmlObjectFactory.createTcPr(); 
	                    tc2.setTcPr(tcpr2); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc2 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr2.setVAlign(verticaljc2); 
	                            verticaljc2.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for gridSpan
	                        TcPrInner.GridSpan tcprinnergridspan = wmlObjectFactory.createTcPrInnerGridSpan(); 
	                        tcpr2.setGridSpan(tcprinnergridspan); 
	                            tcprinnergridspan.setVal( BigInteger.valueOf( 3) ); 
	                        // Create object for tcW
	                        TblWidth tblwidth2 = wmlObjectFactory.createTblWidth(); 
	                        tcpr2.setTcW(tblwidth2); 
	                            tblwidth2.setW( BigInteger.valueOf( 3261) ); 
	                            tblwidth2.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc3 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped3 = wmlObjectFactory.createTrTc(tc3); 
	                tr.getContent().add( tcWrapped3); 
	                    // Create object for p
	                    P p12 = wmlObjectFactory.createP(); 
	                    tc3.getContent().add( p12); 
	                        // Create object for pPr
	                        PPr ppr12 = wmlObjectFactory.createPPr(); 
	                        p12.setPPr(ppr12); 
	                            // Create object for rPr
	                            ParaRPr pararpr11 = wmlObjectFactory.createParaRPr(); 
	                            ppr12.setRPr(pararpr11); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure27 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr11.setSz(hpsmeasure27); 
	                                    hpsmeasure27.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc6 = wmlObjectFactory.createJc(); 
	                            ppr12.setJc(jc6); 
	                                jc6.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r20 = wmlObjectFactory.createR(); 
	                        p12.getContent().add( r20); 
	                            // Create object for rPr
	                            RPr rpr18 = wmlObjectFactory.createRPr(); 
	                            r20.setRPr(rpr18); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure28 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr18.setSz(hpsmeasure28); 
	                                    hpsmeasure28.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text12 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped12 = wmlObjectFactory.createRT(text12); 
	                            r20.getContent().add( textWrapped12); 
	                                text12.setValue( "Położenie "); 
	                                text12.setSpace( "preserve"); 
	                    // Create object for p
	                    P p13 = wmlObjectFactory.createP(); 
	                    tc3.getContent().add( p13); 
	                        // Create object for pPr
	                        PPr ppr13 = wmlObjectFactory.createPPr(); 
	                        p13.setPPr(ppr13); 
	                            // Create object for rPr
	                            ParaRPr pararpr12 = wmlObjectFactory.createParaRPr(); 
	                            ppr13.setRPr(pararpr12); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure29 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr12.setSz(hpsmeasure29); 
	                                    hpsmeasure29.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc7 = wmlObjectFactory.createJc(); 
	                            ppr13.setJc(jc7); 
	                                jc7.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r21 = wmlObjectFactory.createR(); 
	                        p13.getContent().add( r21); 
	                            // Create object for rPr
	                            RPr rpr19 = wmlObjectFactory.createRPr(); 
	                            r21.setRPr(rpr19); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure30 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr19.setSz(hpsmeasure30); 
	                                    hpsmeasure30.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text13 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped13 = wmlObjectFactory.createRT(text13); 
	                            r21.getContent().add( textWrapped13); 
	                                text13.setValue( "nieruchomości              i inne informacje           o sposobie wykorzystania"); 
	                    // Create object for tcPr
	                    TcPr tcpr3 = wmlObjectFactory.createTcPr(); 
	                    tc3.setTcPr(tcpr3); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc3 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr3.setVAlign(verticaljc3); 
	                            verticaljc3.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge2 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr3.setVMerge(tcprinnervmerge2); 
	                            tcprinnervmerge2.setVal( "restart"); 
	                        // Create object for tcW
	                        TblWidth tblwidth3 = wmlObjectFactory.createTblWidth(); 
	                        tcpr3.setTcW(tblwidth3); 
	                            tblwidth3.setW( BigInteger.valueOf( 1842) ); 
	                            tblwidth3.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc4 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped4 = wmlObjectFactory.createTrTc(tc4); 
	                tr.getContent().add( tcWrapped4); 
	                    // Create object for p
	                    P p14 = wmlObjectFactory.createP(); 
	                    tc4.getContent().add( p14); 
	                        // Create object for pPr
	                        PPr ppr14 = wmlObjectFactory.createPPr(); 
	                        p14.setPPr(ppr14); 
	                            // Create object for rPr
	                            ParaRPr pararpr13 = wmlObjectFactory.createParaRPr(); 
	                            ppr14.setRPr(pararpr13); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure31 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr13.setSz(hpsmeasure31); 
	                                    hpsmeasure31.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc8 = wmlObjectFactory.createJc(); 
	                            ppr14.setJc(jc8); 
	                                jc8.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r22 = wmlObjectFactory.createR(); 
	                        p14.getContent().add( r22); 
	                            // Create object for rPr
	                            RPr rpr20 = wmlObjectFactory.createRPr(); 
	                            r22.setRPr(rpr20); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure32 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr20.setSz(hpsmeasure32); 
	                                    hpsmeasure32.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text14 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped14 = wmlObjectFactory.createRT(text14); 
	                            r22.getContent().add( textWrapped14); 
	                                text14.setValue( "Rodzaj nieruchomości"); 
	                    // Create object for tcPr
	                    TcPr tcpr4 = wmlObjectFactory.createTcPr(); 
	                    tc4.setTcPr(tcpr4); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc4 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr4.setVAlign(verticaljc4); 
	                            verticaljc4.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge3 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr4.setVMerge(tcprinnervmerge3); 
	                            tcprinnervmerge3.setVal( "restart"); 
	                        // Create object for tcW
	                        TblWidth tblwidth4 = wmlObjectFactory.createTblWidth(); 
	                        tcpr4.setTcW(tblwidth4); 
	                            tblwidth4.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth4.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc5 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped5 = wmlObjectFactory.createTrTc(tc5); 
	                tr.getContent().add( tcWrapped5); 
	                    // Create object for p
	                    P p15 = wmlObjectFactory.createP(); 
	                    tc5.getContent().add( p15); 
	                        // Create object for pPr
	                        PPr ppr15 = wmlObjectFactory.createPPr(); 
	                        p15.setPPr(ppr15); 
	                            // Create object for rPr
	                            ParaRPr pararpr14 = wmlObjectFactory.createParaRPr(); 
	                            ppr15.setRPr(pararpr14); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure33 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr14.setSz(hpsmeasure33); 
	                                    hpsmeasure33.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc9 = wmlObjectFactory.createJc(); 
	                            ppr15.setJc(jc9); 
	                                jc9.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r23 = wmlObjectFactory.createR(); 
	                        p15.getContent().add( r23); 
	                            // Create object for rPr
	                            RPr rpr21 = wmlObjectFactory.createRPr(); 
	                            r23.setRPr(rpr21); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure34 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr21.setSz(hpsmeasure34); 
	                                    hpsmeasure34.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text15 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped15 = wmlObjectFactory.createRT(text15); 
	                            r23.getContent().add( textWrapped15); 
	                                text15.setValue( "Informacje "); 
	                                text15.setSpace( "preserve"); 
	                    // Create object for p
	                    P p16 = wmlObjectFactory.createP(); 
	                    tc5.getContent().add( p16); 
	                        // Create object for pPr
	                        PPr ppr16 = wmlObjectFactory.createPPr(); 
	                        p16.setPPr(ppr16); 
	                            // Create object for rPr
	                            ParaRPr pararpr15 = wmlObjectFactory.createParaRPr(); 
	                            ppr16.setRPr(pararpr15); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure35 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr15.setSz(hpsmeasure35); 
	                                    hpsmeasure35.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc10 = wmlObjectFactory.createJc(); 
	                            ppr16.setJc(jc10); 
	                                jc10.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r24 = wmlObjectFactory.createR(); 
	                        p16.getContent().add( r24); 
	                            // Create object for rPr
	                            RPr rpr22 = wmlObjectFactory.createRPr(); 
	                            r24.setRPr(rpr22); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure36 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr22.setSz(hpsmeasure36); 
	                                    hpsmeasure36.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text16 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped16 = wmlObjectFactory.createRT(text16); 
	                            r24.getContent().add( textWrapped16); 
	                                text16.setValue( "o mapach"); 
	                    // Create object for tcPr
	                    TcPr tcpr5 = wmlObjectFactory.createTcPr(); 
	                    tc5.setTcPr(tcpr5); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc5 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr5.setVAlign(verticaljc5); 
	                            verticaljc5.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge4 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr5.setVMerge(tcprinnervmerge4); 
	                            tcprinnervmerge4.setVal( "restart"); 
	                        // Create object for tcW
	                        TblWidth tblwidth5 = wmlObjectFactory.createTblWidth(); 
	                        tcpr5.setTcW(tblwidth5); 
	                            tblwidth5.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth5.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc6 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped6 = wmlObjectFactory.createTrTc(tc6); 
	                tr.getContent().add( tcWrapped6); 
	                    // Create object for p
	                    P p17 = wmlObjectFactory.createP(); 
	                    tc6.getContent().add( p17); 
	                        // Create object for pPr
	                        PPr ppr17 = wmlObjectFactory.createPPr(); 
	                        p17.setPPr(ppr17); 
	                            // Create object for rPr
	                            ParaRPr pararpr16 = wmlObjectFactory.createParaRPr(); 
	                            ppr17.setRPr(pararpr16); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure37 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr16.setSz(hpsmeasure37); 
	                                    hpsmeasure37.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc11 = wmlObjectFactory.createJc(); 
	                            ppr17.setJc(jc11); 
	                                jc11.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r25 = wmlObjectFactory.createR(); 
	                        p17.getContent().add( r25); 
	                            // Create object for rPr
	                            RPr rpr23 = wmlObjectFactory.createRPr(); 
	                            r25.setRPr(rpr23); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure38 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr23.setSz(hpsmeasure38); 
	                                    hpsmeasure38.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text17 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped17 = wmlObjectFactory.createRT(text17); 
	                            r25.getContent().add( textWrapped17); 
	                                text17.setValue( "DZIAŁ II"); 
	                    // Create object for tcPr
	                    TcPr tcpr6 = wmlObjectFactory.createTcPr(); 
	                    tc6.setTcPr(tcpr6); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc6 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr6.setVAlign(verticaljc6); 
	                            verticaljc6.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for gridSpan
	                        TcPrInner.GridSpan tcprinnergridspan2 = wmlObjectFactory.createTcPrInnerGridSpan(); 
	                        tcpr6.setGridSpan(tcprinnergridspan2); 
	                            tcprinnergridspan2.setVal( BigInteger.valueOf( 2) ); 
	                        // Create object for tcW
	                        TblWidth tblwidth6 = wmlObjectFactory.createTblWidth(); 
	                        tcpr6.setTcW(tblwidth6); 
	                            tblwidth6.setW( BigInteger.valueOf( 3685) ); 
	                            tblwidth6.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc7 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped7 = wmlObjectFactory.createTrTc(tc7); 
	                tr.getContent().add( tcWrapped7); 
	                    // Create object for p
	                    P p18 = wmlObjectFactory.createP(); 
	                    tc7.getContent().add( p18); 
	                        // Create object for pPr
	                        PPr ppr18 = wmlObjectFactory.createPPr(); 
	                        p18.setPPr(ppr18); 
	                            // Create object for rPr
	                            ParaRPr pararpr17 = wmlObjectFactory.createParaRPr(); 
	                            ppr18.setRPr(pararpr17); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure39 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr17.setSz(hpsmeasure39); 
	                                    hpsmeasure39.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc12 = wmlObjectFactory.createJc(); 
	                            ppr18.setJc(jc12); 
	                                jc12.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r26 = wmlObjectFactory.createR(); 
	                        p18.getContent().add( r26); 
	                            // Create object for rPr
	                            RPr rpr24 = wmlObjectFactory.createRPr(); 
	                            r26.setRPr(rpr24); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure40 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr24.setSz(hpsmeasure40); 
	                                    hpsmeasure40.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text18 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped18 = wmlObjectFactory.createRT(text18); 
	                            r26.getContent().add( textWrapped18); 
	                                text18.setValue( "DZIAŁ  III"); 
	                    // Create object for tcPr
	                    TcPr tcpr7 = wmlObjectFactory.createTcPr(); 
	                    tc7.setTcPr(tcpr7); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc7 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr7.setVAlign(verticaljc7); 
	                            verticaljc7.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth7 = wmlObjectFactory.createTblWidth(); 
	                        tcpr7.setTcW(tblwidth7); 
	                            tblwidth7.setW( BigInteger.valueOf( 2127) ); 
	                            tblwidth7.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc8 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped8 = wmlObjectFactory.createTrTc(tc8); 
	                tr.getContent().add( tcWrapped8); 
	                    // Create object for p
	                    P p19 = wmlObjectFactory.createP(); 
	                    tc8.getContent().add( p19); 
	                        // Create object for pPr
	                        PPr ppr19 = wmlObjectFactory.createPPr(); 
	                        p19.setPPr(ppr19); 
	                            // Create object for rPr
	                            ParaRPr pararpr18 = wmlObjectFactory.createParaRPr(); 
	                            ppr19.setRPr(pararpr18); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure41 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr18.setSz(hpsmeasure41); 
	                                    hpsmeasure41.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc13 = wmlObjectFactory.createJc(); 
	                            ppr19.setJc(jc13); 
	                                jc13.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r27 = wmlObjectFactory.createR(); 
	                        p19.getContent().add( r27); 
	                            // Create object for rPr
	                            RPr rpr25 = wmlObjectFactory.createRPr(); 
	                            r27.setRPr(rpr25); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure42 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr25.setSz(hpsmeasure42); 
	                                    hpsmeasure42.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text19 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped19 = wmlObjectFactory.createRT(text19); 
	                            r27.getContent().add( textWrapped19); 
	                                text19.setValue( "UWAGI"); 
	                    // Create object for tcPr
	                    TcPr tcpr8 = wmlObjectFactory.createTcPr(); 
	                    tc8.setTcPr(tcpr8); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc8 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr8.setVAlign(verticaljc8); 
	                            verticaljc8.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge5 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr8.setVMerge(tcprinnervmerge5); 
	                            tcprinnervmerge5.setVal( "restart"); 
	                        // Create object for tcW
	                        TblWidth tblwidth8 = wmlObjectFactory.createTblWidth(); 
	                        tcpr8.setTcW(tblwidth8); 
	                            tblwidth8.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth8.setType( "dxa"); 
	                // Create object for trPr
	                TrPr trpr = wmlObjectFactory.createTrPr(); 
	                tr.setTrPr(trpr); 
	                    // Create object for cantSplit (wrapped in JAXBElement) 
	                    BooleanDefaultTrue booleandefaulttrue7 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    JAXBElement<org.docx4j.wml.BooleanDefaultTrue> booleandefaulttrueWrapped = wmlObjectFactory.createCTTrPrBaseCantSplit(booleandefaulttrue7); 
	                    trpr.getCnfStyleOrDivIdOrGridBefore().add( booleandefaulttrueWrapped); 
	                    // Create object for trHeight (wrapped in JAXBElement) 
	                    CTHeight height = wmlObjectFactory.createCTHeight(); 
	                    JAXBElement<org.docx4j.wml.CTHeight> heightWrapped = wmlObjectFactory.createCTTrPrBaseTrHeight(height); 
	                    trpr.getCnfStyleOrDivIdOrGridBefore().add( heightWrapped); 
	                        height.setVal( BigInteger.valueOf( 288) ); 
	            // Create object for tr
	            Tr tr2 = wmlObjectFactory.createTr(); 
	            tbl.getContent().add( tr2); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc9 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped9 = wmlObjectFactory.createTrTc(tc9); 
	                tr2.getContent().add( tcWrapped9); 
	                    // Create object for p
	                    P p20 = wmlObjectFactory.createP(); 
	                    tc9.getContent().add( p20); 
	                        // Create object for pPr
	                        PPr ppr20 = wmlObjectFactory.createPPr(); 
	                        p20.setPPr(ppr20); 
	                            // Create object for rPr
	                            ParaRPr pararpr19 = wmlObjectFactory.createParaRPr(); 
	                            ppr20.setRPr(pararpr19); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure43 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr19.setSz(hpsmeasure43); 
	                                    hpsmeasure43.setVal( BigInteger.valueOf( 24) ); 
	                            // Create object for jc
	                            Jc jc14 = wmlObjectFactory.createJc(); 
	                            ppr20.setJc(jc14); 
	                                jc14.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr9 = wmlObjectFactory.createTcPr(); 
	                    tc9.setTcPr(tcpr9); 
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge6 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr9.setVMerge(tcprinnervmerge6); 
	                        // Create object for tcW
	                        TblWidth tblwidth9 = wmlObjectFactory.createTblWidth(); 
	                        tcpr9.setTcW(tblwidth9); 
	                            tblwidth9.setW( BigInteger.valueOf( 425) ); 
	                            tblwidth9.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc10 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped10 = wmlObjectFactory.createTrTc(tc10); 
	                tr2.getContent().add( tcWrapped10); 
	                    // Create object for p
	                    P p21 = wmlObjectFactory.createP(); 
	                    tc10.getContent().add( p21); 
	                        // Create object for pPr
	                        PPr ppr21 = wmlObjectFactory.createPPr(); 
	                        p21.setPPr(ppr21); 
	                            // Create object for rPr
	                            ParaRPr pararpr20 = wmlObjectFactory.createParaRPr(); 
	                            ppr21.setRPr(pararpr20); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure44 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr20.setSz(hpsmeasure44); 
	                                    hpsmeasure44.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc15 = wmlObjectFactory.createJc(); 
	                            ppr21.setJc(jc15); 
	                                jc15.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r28 = wmlObjectFactory.createR(); 
	                        p21.getContent().add( r28); 
	                            // Create object for rPr
	                            RPr rpr26 = wmlObjectFactory.createRPr(); 
	                            r28.setRPr(rpr26); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure45 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr26.setSz(hpsmeasure45); 
	                                    hpsmeasure45.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text20 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped20 = wmlObjectFactory.createRT(text20); 
	                            r28.getContent().add( textWrapped20); 
	                                text20.setValue( "Numer księgi wieczystej lub zbioru dokumentów"); 
	                    // Create object for p
	                    P p22 = wmlObjectFactory.createP(); 
	                    tc10.getContent().add( p22); 
	                        // Create object for pPr
	                        PPr ppr22 = wmlObjectFactory.createPPr(); 
	                        p22.setPPr(ppr22); 
	                            // Create object for rPr
	                            ParaRPr pararpr21 = wmlObjectFactory.createParaRPr(); 
	                            ppr22.setRPr(pararpr21); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure46 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr21.setSz(hpsmeasure46); 
	                                    hpsmeasure46.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc16 = wmlObjectFactory.createJc(); 
	                            ppr22.setJc(jc16); 
	                                jc16.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                            // Create object for spacing
	                            PPrBase.Spacing pprbasespacing8 = wmlObjectFactory.createPPrBaseSpacing(); 
	                            ppr22.setSpacing(pprbasespacing8); 
	                                pprbasespacing8.setBefore( BigInteger.valueOf( 120) ); 
	                        // Create object for r
	                        R r29 = wmlObjectFactory.createR(); 
	                        p22.getContent().add( r29); 
	                            // Create object for rPr
	                            RPr rpr27 = wmlObjectFactory.createRPr(); 
	                            r29.setRPr(rpr27); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure47 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr27.setSz(hpsmeasure47); 
	                                    hpsmeasure47.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text21 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped21 = wmlObjectFactory.createRT(text21); 
	                            r29.getContent().add( textWrapped21); 
	                                text21.setValue( "Nazwa nieruchomości"); 
	                    // Create object for tcPr
	                    TcPr tcpr10 = wmlObjectFactory.createTcPr(); 
	                    tc10.setTcPr(tcpr10); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc9 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr10.setVAlign(verticaljc9); 
	                            verticaljc9.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth10 = wmlObjectFactory.createTblWidth(); 
	                        tcpr10.setTcW(tblwidth10); 
	                            tblwidth10.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth10.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc11 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped11 = wmlObjectFactory.createTrTc(tc11); 
	                tr2.getContent().add( tcWrapped11); 
	                    // Create object for p
	                    P p23 = wmlObjectFactory.createP(); 
	                    tc11.getContent().add( p23); 
	                        // Create object for pPr
	                        PPr ppr23 = wmlObjectFactory.createPPr(); 
	                        p23.setPPr(ppr23); 
	                            // Create object for rPr
	                            ParaRPr pararpr22 = wmlObjectFactory.createParaRPr(); 
	                            ppr23.setRPr(pararpr22); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure48 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr22.setSz(hpsmeasure48); 
	                                    hpsmeasure48.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc17 = wmlObjectFactory.createJc(); 
	                            ppr23.setJc(jc17); 
	                                jc17.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r30 = wmlObjectFactory.createR(); 
	                        p23.getContent().add( r30); 
	                            // Create object for rPr
	                            RPr rpr28 = wmlObjectFactory.createRPr(); 
	                            r30.setRPr(rpr28); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure49 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr28.setSz(hpsmeasure49); 
	                                    hpsmeasure49.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text22 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped22 = wmlObjectFactory.createRT(text22); 
	                            r30.getContent().add( textWrapped22); 
	                                text22.setValue( "Numer"); 
	                    // Create object for p
	                    P p24 = wmlObjectFactory.createP(); 
	                    tc11.getContent().add( p24); 
	                        // Create object for pPr
	                        PPr ppr24 = wmlObjectFactory.createPPr(); 
	                        p24.setPPr(ppr24); 
	                            // Create object for rPr
	                            ParaRPr pararpr23 = wmlObjectFactory.createParaRPr(); 
	                            ppr24.setRPr(pararpr23); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure50 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr23.setSz(hpsmeasure50); 
	                                    hpsmeasure50.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc18 = wmlObjectFactory.createJc(); 
	                            ppr24.setJc(jc18); 
	                                jc18.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r31 = wmlObjectFactory.createR(); 
	                        p24.getContent().add( r31); 
	                            // Create object for rPr
	                            RPr rpr29 = wmlObjectFactory.createRPr(); 
	                            r31.setRPr(rpr29); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure51 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr29.setSz(hpsmeasure51); 
	                                    hpsmeasure51.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text23 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped23 = wmlObjectFactory.createRT(text23); 
	                            r31.getContent().add( textWrapped23); 
	                                text23.setValue( "działki"); 
	                    // Create object for tcPr
	                    TcPr tcpr11 = wmlObjectFactory.createTcPr(); 
	                    tc11.setTcPr(tcpr11); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc10 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr11.setVAlign(verticaljc10); 
	                            verticaljc10.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth11 = wmlObjectFactory.createTblWidth(); 
	                        tcpr11.setTcW(tblwidth11); 
	                            tblwidth11.setW( BigInteger.valueOf( 851) ); 
	                            tblwidth11.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc12 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped12 = wmlObjectFactory.createTrTc(tc12); 
	                tr2.getContent().add( tcWrapped12); 
	                    // Create object for p
	                    P p25 = wmlObjectFactory.createP(); 
	                    tc12.getContent().add( p25); 
	                        // Create object for pPr
	                        PPr ppr25 = wmlObjectFactory.createPPr(); 
	                        p25.setPPr(ppr25); 
	                            // Create object for rPr
	                            ParaRPr pararpr24 = wmlObjectFactory.createParaRPr(); 
	                            ppr25.setRPr(pararpr24); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure52 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr24.setSz(hpsmeasure52); 
	                                    hpsmeasure52.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc19 = wmlObjectFactory.createJc(); 
	                            ppr25.setJc(jc19); 
	                                jc19.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r32 = wmlObjectFactory.createR(); 
	                        p25.getContent().add( r32); 
	                            // Create object for rPr
	                            RPr rpr30 = wmlObjectFactory.createRPr(); 
	                            r32.setRPr(rpr30); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure53 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr30.setSz(hpsmeasure53); 
	                                    hpsmeasure53.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text24 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped24 = wmlObjectFactory.createRT(text24); 
	                            r32.getContent().add( textWrapped24); 
	                                text24.setValue( "Pole  powierzchni"); 
	                    // Create object for p
	                    P p26 = wmlObjectFactory.createP(); 
	                    tc12.getContent().add( p26); 
	                        // Create object for pPr
	                        PPr ppr26 = wmlObjectFactory.createPPr(); 
	                        p26.setPPr(ppr26); 
	                            // Create object for rPr
	                            ParaRPr pararpr25 = wmlObjectFactory.createParaRPr(); 
	                            ppr26.setRPr(pararpr25); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure54 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr25.setSz(hpsmeasure54); 
	                                    hpsmeasure54.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc20 = wmlObjectFactory.createJc(); 
	                            ppr26.setJc(jc20); 
	                                jc20.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr12 = wmlObjectFactory.createTcPr(); 
	                    tc12.setTcPr(tcpr12); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc11 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr12.setVAlign(verticaljc11); 
	                            verticaljc11.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth12 = wmlObjectFactory.createTblWidth(); 
	                        tcpr12.setTcW(tblwidth12); 
	                            tblwidth12.setW( BigInteger.valueOf( 1134) ); 
	                            tblwidth12.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc13 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped13 = wmlObjectFactory.createTrTc(tc13); 
	                tr2.getContent().add( tcWrapped13); 
	                    // Create object for p
	                    P p27 = wmlObjectFactory.createP(); 
	                    tc13.getContent().add( p27); 
	                        // Create object for pPr
	                        PPr ppr27 = wmlObjectFactory.createPPr(); 
	                        p27.setPPr(ppr27); 
	                            // Create object for rPr
	                            ParaRPr pararpr26 = wmlObjectFactory.createParaRPr(); 
	                            ppr27.setRPr(pararpr26); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure55 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr26.setSz(hpsmeasure55); 
	                                    hpsmeasure55.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc21 = wmlObjectFactory.createJc(); 
	                            ppr27.setJc(jc21); 
	                                jc21.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr13 = wmlObjectFactory.createTcPr(); 
	                    tc13.setTcPr(tcpr13); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc12 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr13.setVAlign(verticaljc12); 
	                            verticaljc12.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge7 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr13.setVMerge(tcprinnervmerge7); 
	                        // Create object for tcW
	                        TblWidth tblwidth13 = wmlObjectFactory.createTblWidth(); 
	                        tcpr13.setTcW(tblwidth13); 
	                            tblwidth13.setW( BigInteger.valueOf( 1842) ); 
	                            tblwidth13.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc14 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped14 = wmlObjectFactory.createTrTc(tc14); 
	                tr2.getContent().add( tcWrapped14); 
	                    // Create object for p
	                    P p28 = wmlObjectFactory.createP(); 
	                    tc14.getContent().add( p28); 
	                        // Create object for pPr
	                        PPr ppr28 = wmlObjectFactory.createPPr(); 
	                        p28.setPPr(ppr28); 
	                            // Create object for rPr
	                            ParaRPr pararpr27 = wmlObjectFactory.createParaRPr(); 
	                            ppr28.setRPr(pararpr27); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure56 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr27.setSz(hpsmeasure56); 
	                                    hpsmeasure56.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc22 = wmlObjectFactory.createJc(); 
	                            ppr28.setJc(jc22); 
	                                jc22.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr14 = wmlObjectFactory.createTcPr(); 
	                    tc14.setTcPr(tcpr14); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc13 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr14.setVAlign(verticaljc13); 
	                            verticaljc13.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge8 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr14.setVMerge(tcprinnervmerge8); 
	                        // Create object for tcW
	                        TblWidth tblwidth14 = wmlObjectFactory.createTblWidth(); 
	                        tcpr14.setTcW(tblwidth14); 
	                            tblwidth14.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth14.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc15 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped15 = wmlObjectFactory.createTrTc(tc15); 
	                tr2.getContent().add( tcWrapped15); 
	                    // Create object for p
	                    P p29 = wmlObjectFactory.createP(); 
	                    tc15.getContent().add( p29); 
	                        // Create object for pPr
	                        PPr ppr29 = wmlObjectFactory.createPPr(); 
	                        p29.setPPr(ppr29); 
	                            // Create object for rPr
	                            ParaRPr pararpr28 = wmlObjectFactory.createParaRPr(); 
	                            ppr29.setRPr(pararpr28); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure57 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr28.setSz(hpsmeasure57); 
	                                    hpsmeasure57.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc23 = wmlObjectFactory.createJc(); 
	                            ppr29.setJc(jc23); 
	                                jc23.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr15 = wmlObjectFactory.createTcPr(); 
	                    tc15.setTcPr(tcpr15); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc14 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr15.setVAlign(verticaljc14); 
	                            verticaljc14.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge9 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr15.setVMerge(tcprinnervmerge9); 
	                        // Create object for tcW
	                        TblWidth tblwidth15 = wmlObjectFactory.createTblWidth(); 
	                        tcpr15.setTcW(tblwidth15); 
	                            tblwidth15.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth15.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc16 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped16 = wmlObjectFactory.createTrTc(tc16); 
	                tr2.getContent().add( tcWrapped16); 
	                    // Create object for p
	                    P p30 = wmlObjectFactory.createP(); 
	                    tc16.getContent().add( p30); 
	                        // Create object for pPr
	                        PPr ppr30 = wmlObjectFactory.createPPr(); 
	                        p30.setPPr(ppr30); 
	                            // Create object for rPr
	                            ParaRPr pararpr29 = wmlObjectFactory.createParaRPr(); 
	                            ppr30.setRPr(pararpr29); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure58 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr29.setSz(hpsmeasure58); 
	                                    hpsmeasure58.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc24 = wmlObjectFactory.createJc(); 
	                            ppr30.setJc(jc24); 
	                                jc24.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r33 = wmlObjectFactory.createR(); 
	                        p30.getContent().add( r33); 
	                            // Create object for rPr
	                            RPr rpr31 = wmlObjectFactory.createRPr(); 
	                            r33.setRPr(rpr31); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure59 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr31.setSz(hpsmeasure59); 
	                                    hpsmeasure59.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text25 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped25 = wmlObjectFactory.createRT(text25); 
	                            r33.getContent().add( textWrapped25); 
	                                text25.setValue( "1.Właściciel"); 
	                    // Create object for p
	                    P p31 = wmlObjectFactory.createP(); 
	                    tc16.getContent().add( p31); 
	                        // Create object for pPr
	                        PPr ppr31 = wmlObjectFactory.createPPr(); 
	                        p31.setPPr(ppr31); 
	                            // Create object for rPr
	                            ParaRPr pararpr30 = wmlObjectFactory.createParaRPr(); 
	                            ppr31.setRPr(pararpr30); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure60 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr30.setSz(hpsmeasure60); 
	                                    hpsmeasure60.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc25 = wmlObjectFactory.createJc(); 
	                            ppr31.setJc(jc25); 
	                                jc25.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r34 = wmlObjectFactory.createR(); 
	                        p31.getContent().add( r34); 
	                            // Create object for rPr
	                            RPr rpr32 = wmlObjectFactory.createRPr(); 
	                            r34.setRPr(rpr32); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure61 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr32.setSz(hpsmeasure61); 
	                                    hpsmeasure61.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text26 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped26 = wmlObjectFactory.createRT(text26); 
	                            r34.getContent().add( textWrapped26); 
	                                text26.setValue( "2.Wieczysty użytkownik"); 
	                    // Create object for p
	                    P p32 = wmlObjectFactory.createP(); 
	                    tc16.getContent().add( p32); 
	                        // Create object for pPr
	                        PPr ppr32 = wmlObjectFactory.createPPr(); 
	                        p32.setPPr(ppr32); 
	                            // Create object for rPr
	                            ParaRPr pararpr31 = wmlObjectFactory.createParaRPr(); 
	                            ppr32.setRPr(pararpr31); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure62 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr31.setSz(hpsmeasure62); 
	                                    hpsmeasure62.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc26 = wmlObjectFactory.createJc(); 
	                            ppr32.setJc(jc26); 
	                                jc26.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r35 = wmlObjectFactory.createR(); 
	                        p32.getContent().add( r35); 
	                            // Create object for rPr
	                            RPr rpr33 = wmlObjectFactory.createRPr(); 
	                            r35.setRPr(rpr33); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure63 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr33.setSz(hpsmeasure63); 
	                                    hpsmeasure63.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text27 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped27 = wmlObjectFactory.createRT(text27); 
	                            r35.getContent().add( textWrapped27); 
	                                text27.setValue( "-----------------------------"); 
	                    // Create object for p
	                    P p33 = wmlObjectFactory.createP(); 
	                    tc16.getContent().add( p33); 
	                        // Create object for pPr
	                        PPr ppr33 = wmlObjectFactory.createPPr(); 
	                        p33.setPPr(ppr33); 
	                            // Create object for rPr
	                            ParaRPr pararpr32 = wmlObjectFactory.createParaRPr(); 
	                            ppr33.setRPr(pararpr32); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure64 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr32.setSz(hpsmeasure64); 
	                                    hpsmeasure64.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc27 = wmlObjectFactory.createJc(); 
	                            ppr33.setJc(jc27); 
	                                jc27.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r36 = wmlObjectFactory.createR(); 
	                        p33.getContent().add( r36); 
	                            // Create object for rPr
	                            RPr rpr34 = wmlObjectFactory.createRPr(); 
	                            r36.setRPr(rpr34); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure65 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr34.setSz(hpsmeasure65); 
	                                    hpsmeasure65.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text28 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped28 = wmlObjectFactory.createRT(text28); 
	                            r36.getContent().add( textWrapped28); 
	                                text28.setValue( "Imię i nazwisko, imiona rodziców lub nazwa osoby prawnej, adres"); 
	                    // Create object for tcPr
	                    TcPr tcpr16 = wmlObjectFactory.createTcPr(); 
	                    tc16.setTcPr(tcpr16); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc15 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr16.setVAlign(verticaljc15); 
	                            verticaljc15.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth16 = wmlObjectFactory.createTblWidth(); 
	                        tcpr16.setTcW(tblwidth16); 
	                            tblwidth16.setW( BigInteger.valueOf( 2126) ); 
	                            tblwidth16.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc17 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped17 = wmlObjectFactory.createTrTc(tc17); 
	                tr2.getContent().add( tcWrapped17); 
	                    // Create object for p
	                    P p34 = wmlObjectFactory.createP(); 
	                    tc17.getContent().add( p34); 
	                        // Create object for pPr
	                        PPr ppr34 = wmlObjectFactory.createPPr(); 
	                        p34.setPPr(ppr34); 
	                            // Create object for rPr
	                            ParaRPr pararpr33 = wmlObjectFactory.createParaRPr(); 
	                            ppr34.setRPr(pararpr33); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure66 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr33.setSz(hpsmeasure66); 
	                                    hpsmeasure66.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc28 = wmlObjectFactory.createJc(); 
	                            ppr34.setJc(jc28); 
	                                jc28.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r37 = wmlObjectFactory.createR(); 
	                        p34.getContent().add( r37); 
	                            // Create object for rPr
	                            RPr rpr35 = wmlObjectFactory.createRPr(); 
	                            r37.setRPr(rpr35); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure67 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr35.setSz(hpsmeasure67); 
	                                    hpsmeasure67.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text29 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped29 = wmlObjectFactory.createRT(text29); 
	                            r37.getContent().add( textWrapped29); 
	                                text29.setValue( "Podstawa ustalenia danych wym."); 
	                    // Create object for p
	                    P p35 = wmlObjectFactory.createP(); 
	                    tc17.getContent().add( p35); 
	                        // Create object for pPr
	                        PPr ppr35 = wmlObjectFactory.createPPr(); 
	                        p35.setPPr(ppr35); 
	                            // Create object for rPr
	                            ParaRPr pararpr34 = wmlObjectFactory.createParaRPr(); 
	                            ppr35.setRPr(pararpr34); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure68 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr34.setSz(hpsmeasure68); 
	                                    hpsmeasure68.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc29 = wmlObjectFactory.createJc(); 
	                            ppr35.setJc(jc29); 
	                                jc29.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r38 = wmlObjectFactory.createR(); 
	                        p35.getContent().add( r38); 
	                            // Create object for rPr
	                            RPr rpr36 = wmlObjectFactory.createRPr(); 
	                            r38.setRPr(rpr36); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure69 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr36.setSz(hpsmeasure69); 
	                                    hpsmeasure69.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text30 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped30 = wmlObjectFactory.createRT(text30); 
	                            r38.getContent().add( textWrapped30); 
	                                text30.setValue( "w kol. 8"); 
	                    // Create object for tcPr
	                    TcPr tcpr17 = wmlObjectFactory.createTcPr(); 
	                    tc17.setTcPr(tcpr17); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc16 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr17.setVAlign(verticaljc16); 
	                            verticaljc16.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth17 = wmlObjectFactory.createTblWidth(); 
	                        tcpr17.setTcW(tblwidth17); 
	                            tblwidth17.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth17.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc18 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped18 = wmlObjectFactory.createTrTc(tc18); 
	                tr2.getContent().add( tcWrapped18); 
	                    // Create object for p
	                    P p36 = wmlObjectFactory.createP(); 
	                    tc18.getContent().add( p36); 
	                        // Create object for pPr
	                        PPr ppr36 = wmlObjectFactory.createPPr(); 
	                        p36.setPPr(ppr36); 
	                            // Create object for rPr
	                            ParaRPr pararpr35 = wmlObjectFactory.createParaRPr(); 
	                            ppr36.setRPr(pararpr35); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure70 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr35.setSz(hpsmeasure70); 
	                                    hpsmeasure70.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc30 = wmlObjectFactory.createJc(); 
	                            ppr36.setJc(jc30); 
	                                jc30.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r39 = wmlObjectFactory.createR(); 
	                        p36.getContent().add( r39); 
	                            // Create object for rPr
	                            RPr rpr37 = wmlObjectFactory.createRPr(); 
	                            r39.setRPr(rpr37); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure71 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr37.setSz(hpsmeasure71); 
	                                    hpsmeasure71.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text31 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped31 = wmlObjectFactory.createRT(text31); 
	                            r39.getContent().add( textWrapped31); 
	                                text31.setValue( "Rodzaj ograniczonych"); 
	                    // Create object for p
	                    P p37 = wmlObjectFactory.createP(); 
	                    tc18.getContent().add( p37); 
	                        // Create object for pPr
	                        PPr ppr37 = wmlObjectFactory.createPPr(); 
	                        p37.setPPr(ppr37); 
	                            // Create object for rPr
	                            ParaRPr pararpr36 = wmlObjectFactory.createParaRPr(); 
	                            ppr37.setRPr(pararpr36); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure72 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr36.setSz(hpsmeasure72); 
	                                    hpsmeasure72.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc31 = wmlObjectFactory.createJc(); 
	                            ppr37.setJc(jc31); 
	                                jc31.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r40 = wmlObjectFactory.createR(); 
	                        p37.getContent().add( r40); 
	                            // Create object for rPr
	                            RPr rpr38 = wmlObjectFactory.createRPr(); 
	                            r40.setRPr(rpr38); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure73 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr38.setSz(hpsmeasure73); 
	                                    hpsmeasure73.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text32 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped32 = wmlObjectFactory.createRT(text32); 
	                            r40.getContent().add( textWrapped32); 
	                                text32.setValue( "praw rzeczowych"); 
	                    // Create object for p
	                    P p38 = wmlObjectFactory.createP(); 
	                    tc18.getContent().add( p38); 
	                        // Create object for pPr
	                        PPr ppr38 = wmlObjectFactory.createPPr(); 
	                        p38.setPPr(ppr38); 
	                            // Create object for rPr
	                            ParaRPr pararpr37 = wmlObjectFactory.createParaRPr(); 
	                            ppr38.setRPr(pararpr37); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure74 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr37.setSz(hpsmeasure74); 
	                                    hpsmeasure74.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc32 = wmlObjectFactory.createJc(); 
	                            ppr38.setJc(jc32); 
	                                jc32.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r41 = wmlObjectFactory.createR(); 
	                        p38.getContent().add( r41); 
	                            // Create object for rPr
	                            RPr rpr39 = wmlObjectFactory.createRPr(); 
	                            r41.setRPr(rpr39); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure75 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr39.setSz(hpsmeasure75); 
	                                    hpsmeasure75.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text33 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped33 = wmlObjectFactory.createRT(text33); 
	                            r41.getContent().add( textWrapped33); 
	                                text33.setValue( "-----------------------"); 
	                    // Create object for p
	                    P p39 = wmlObjectFactory.createP(); 
	                    tc18.getContent().add( p39); 
	                        // Create object for pPr
	                        PPr ppr39 = wmlObjectFactory.createPPr(); 
	                        p39.setPPr(ppr39); 
	                            // Create object for rPr
	                            ParaRPr pararpr38 = wmlObjectFactory.createParaRPr(); 
	                            ppr39.setRPr(pararpr38); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure76 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr38.setSz(hpsmeasure76); 
	                                    hpsmeasure76.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for jc
	                            Jc jc33 = wmlObjectFactory.createJc(); 
	                            ppr39.setJc(jc33); 
	                                jc33.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r42 = wmlObjectFactory.createR(); 
	                        p39.getContent().add( r42); 
	                            // Create object for rPr
	                            RPr rpr40 = wmlObjectFactory.createRPr(); 
	                            r42.setRPr(rpr40); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure77 = wmlObjectFactory.createHpsMeasure(); 
	                                rpr40.setSz(hpsmeasure77); 
	                                    hpsmeasure77.setVal( BigInteger.valueOf( 18) ); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text34 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped34 = wmlObjectFactory.createRT(text34); 
	                            r42.getContent().add( textWrapped34); 
	                                text34.setValue( "Podstawa wpisu"); 
	                    // Create object for tcPr
	                    TcPr tcpr18 = wmlObjectFactory.createTcPr(); 
	                    tc18.setTcPr(tcpr18); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc17 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr18.setVAlign(verticaljc17); 
	                            verticaljc17.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth18 = wmlObjectFactory.createTblWidth(); 
	                        tcpr18.setTcW(tblwidth18); 
	                            tblwidth18.setW( BigInteger.valueOf( 2127) ); 
	                            tblwidth18.setType( "dxa"); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc19 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped19 = wmlObjectFactory.createTrTc(tc19); 
	                tr2.getContent().add( tcWrapped19); 
	                    // Create object for p
	                    P p40 = wmlObjectFactory.createP(); 
	                    tc19.getContent().add( p40); 
	                        // Create object for pPr
	                        PPr ppr40 = wmlObjectFactory.createPPr(); 
	                        p40.setPPr(ppr40); 
	                            // Create object for rPr
	                            ParaRPr pararpr39 = wmlObjectFactory.createParaRPr(); 
	                            ppr40.setRPr(pararpr39); 
	                                // Create object for sz
	                                HpsMeasure hpsmeasure78 = wmlObjectFactory.createHpsMeasure(); 
	                                pararpr39.setSz(hpsmeasure78); 
	                                    hpsmeasure78.setVal( BigInteger.valueOf( 24) ); 
	                    // Create object for tcPr
	                    TcPr tcpr19 = wmlObjectFactory.createTcPr(); 
	                    tc19.setTcPr(tcpr19); 
	                        // Create object for vMerge
	                        TcPrInner.VMerge tcprinnervmerge10 = wmlObjectFactory.createTcPrInnerVMerge(); 
	                        tcpr19.setVMerge(tcprinnervmerge10); 
	                        // Create object for tcW
	                        TblWidth tblwidth19 = wmlObjectFactory.createTblWidth(); 
	                        tcpr19.setTcW(tblwidth19); 
	                            tblwidth19.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth19.setType( "dxa"); 
	                // Create object for trPr
	                TrPr trpr2 = wmlObjectFactory.createTrPr(); 
	                tr2.setTrPr(trpr2); 
	                    // Create object for cantSplit (wrapped in JAXBElement) 
	                    BooleanDefaultTrue booleandefaulttrue8 = wmlObjectFactory.createBooleanDefaultTrue(); 
	                    JAXBElement<org.docx4j.wml.BooleanDefaultTrue> booleandefaulttrueWrapped2 = wmlObjectFactory.createCTTrPrBaseCantSplit(booleandefaulttrue8); 
	                    trpr2.getCnfStyleOrDivIdOrGridBefore().add( booleandefaulttrueWrapped2); 
	                    // Create object for trHeight (wrapped in JAXBElement) 
	                    CTHeight height2 = wmlObjectFactory.createCTHeight(); 
	                    JAXBElement<org.docx4j.wml.CTHeight> heightWrapped2 = wmlObjectFactory.createCTTrPrBaseTrHeight(height2); 
	                    trpr2.getCnfStyleOrDivIdOrGridBefore().add( heightWrapped2); 
	                        height2.setVal( BigInteger.valueOf( 1620) ); 
	            // Create object for tr
	            Tr tr3 = wmlObjectFactory.createTr(); 
	            tbl.getContent().add( tr3); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc20 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped20 = wmlObjectFactory.createTrTc(tc20); 
	                tr3.getContent().add( tcWrapped20); 
	                    // Create object for p
	                    P p41 = wmlObjectFactory.createP(); 
	                    tc20.getContent().add( p41); 
	                        // Create object for pPr
	                        PPr ppr41 = wmlObjectFactory.createPPr(); 
	                        p41.setPPr(ppr41); 
	                            // Create object for jc
	                            Jc jc34 = wmlObjectFactory.createJc(); 
	                            ppr41.setJc(jc34); 
	                                jc34.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r43 = wmlObjectFactory.createR(); 
	                        p41.getContent().add( r43); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text35 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped35 = wmlObjectFactory.createRT(text35); 
	                            r43.getContent().add( textWrapped35); 
	                                text35.setValue( "1"); 
	                    // Create object for tcPr
	                    TcPr tcpr20 = wmlObjectFactory.createTcPr(); 
	                    tc20.setTcPr(tcpr20); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc18 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr20.setVAlign(verticaljc18); 
	                            verticaljc18.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth20 = wmlObjectFactory.createTblWidth(); 
	                        tcpr20.setTcW(tblwidth20); 
	                            tblwidth20.setW( BigInteger.valueOf( 425) ); 
	                            tblwidth20.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr20.setTcBorders(tcprinnertcborders); 
	                            // Create object for bottom
	                            CTBorder border = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders.setBottom(border); 
	                                border.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border.setSz( BigInteger.valueOf( 4) ); 
	                                border.setColor( "auto"); 
	                                border.setSpace( BigInteger.valueOf( 0) ); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc21 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped21 = wmlObjectFactory.createTrTc(tc21); 
	                tr3.getContent().add( tcWrapped21); 
	                    // Create object for p
	                    P p42 = wmlObjectFactory.createP(); 
	                    tc21.getContent().add( p42); 
	                        // Create object for pPr
	                        PPr ppr42 = wmlObjectFactory.createPPr(); 
	                        p42.setPPr(ppr42); 
	                            // Create object for jc
	                            Jc jc35 = wmlObjectFactory.createJc(); 
	                            ppr42.setJc(jc35); 
	                                jc35.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r44 = wmlObjectFactory.createR(); 
	                        p42.getContent().add( r44); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text36 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped36 = wmlObjectFactory.createRT(text36); 
	                            r44.getContent().add( textWrapped36); 
	                                text36.setValue( "2"); 
	                    // Create object for tcPr
	                    TcPr tcpr21 = wmlObjectFactory.createTcPr(); 
	                    tc21.setTcPr(tcpr21); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc19 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr21.setVAlign(verticaljc19); 
	                            verticaljc19.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth21 = wmlObjectFactory.createTblWidth(); 
	                        tcpr21.setTcW(tblwidth21); 
	                            tblwidth21.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth21.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders2 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr21.setTcBorders(tcprinnertcborders2); 
	                            // Create object for bottom
	                            CTBorder border2 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders2.setBottom(border2); 
	                                border2.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border2.setSz( BigInteger.valueOf( 4) ); 
	                                border2.setColor( "auto"); 
	                                border2.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border3 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders2.setLeft(border3); 
	                                border3.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc22 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped22 = wmlObjectFactory.createTrTc(tc22); 
	                tr3.getContent().add( tcWrapped22); 
	                    // Create object for p
	                    P p43 = wmlObjectFactory.createP(); 
	                    tc22.getContent().add( p43); 
	                        // Create object for pPr
	                        PPr ppr43 = wmlObjectFactory.createPPr(); 
	                        p43.setPPr(ppr43); 
	                            // Create object for jc
	                            Jc jc36 = wmlObjectFactory.createJc(); 
	                            ppr43.setJc(jc36); 
	                                jc36.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r45 = wmlObjectFactory.createR(); 
	                        p43.getContent().add( r45); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text37 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped37 = wmlObjectFactory.createRT(text37); 
	                            r45.getContent().add( textWrapped37); 
	                                text37.setValue( "3"); 
	                    // Create object for tcPr
	                    TcPr tcpr22 = wmlObjectFactory.createTcPr(); 
	                    tc22.setTcPr(tcpr22); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc20 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr22.setVAlign(verticaljc20); 
	                            verticaljc20.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth22 = wmlObjectFactory.createTblWidth(); 
	                        tcpr22.setTcW(tblwidth22); 
	                            tblwidth22.setW( BigInteger.valueOf( 851) ); 
	                            tblwidth22.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders3 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr22.setTcBorders(tcprinnertcborders3); 
	                            // Create object for bottom
	                            CTBorder border4 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders3.setBottom(border4); 
	                                border4.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border4.setSz( BigInteger.valueOf( 4) ); 
	                                border4.setColor( "auto"); 
	                                border4.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border5 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders3.setLeft(border5); 
	                                border5.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc23 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped23 = wmlObjectFactory.createTrTc(tc23); 
	                tr3.getContent().add( tcWrapped23); 
	                    // Create object for p
	                    P p44 = wmlObjectFactory.createP(); 
	                    tc23.getContent().add( p44); 
	                        // Create object for pPr
	                        PPr ppr44 = wmlObjectFactory.createPPr(); 
	                        p44.setPPr(ppr44); 
	                            // Create object for jc
	                            Jc jc37 = wmlObjectFactory.createJc(); 
	                            ppr44.setJc(jc37); 
	                                jc37.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r46 = wmlObjectFactory.createR(); 
	                        p44.getContent().add( r46); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text38 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped38 = wmlObjectFactory.createRT(text38); 
	                            r46.getContent().add( textWrapped38); 
	                                text38.setValue( "4"); 
	                    // Create object for tcPr
	                    TcPr tcpr23 = wmlObjectFactory.createTcPr(); 
	                    tc23.setTcPr(tcpr23); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc21 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr23.setVAlign(verticaljc21); 
	                            verticaljc21.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth23 = wmlObjectFactory.createTblWidth(); 
	                        tcpr23.setTcW(tblwidth23); 
	                            tblwidth23.setW( BigInteger.valueOf( 1134) ); 
	                            tblwidth23.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders4 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr23.setTcBorders(tcprinnertcborders4); 
	                            // Create object for bottom
	                            CTBorder border6 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders4.setBottom(border6); 
	                                border6.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border6.setSz( BigInteger.valueOf( 4) ); 
	                                border6.setColor( "auto"); 
	                                border6.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border7 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders4.setLeft(border7); 
	                                border7.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc24 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped24 = wmlObjectFactory.createTrTc(tc24); 
	                tr3.getContent().add( tcWrapped24); 
	                    // Create object for p
	                    P p45 = wmlObjectFactory.createP(); 
	                    tc24.getContent().add( p45); 
	                        // Create object for pPr
	                        PPr ppr45 = wmlObjectFactory.createPPr(); 
	                        p45.setPPr(ppr45); 
	                            // Create object for jc
	                            Jc jc38 = wmlObjectFactory.createJc(); 
	                            ppr45.setJc(jc38); 
	                                jc38.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r47 = wmlObjectFactory.createR(); 
	                        p45.getContent().add( r47); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text39 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped39 = wmlObjectFactory.createRT(text39); 
	                            r47.getContent().add( textWrapped39); 
	                                text39.setValue( "5"); 
	                    // Create object for tcPr
	                    TcPr tcpr24 = wmlObjectFactory.createTcPr(); 
	                    tc24.setTcPr(tcpr24); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc22 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr24.setVAlign(verticaljc22); 
	                            verticaljc22.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth24 = wmlObjectFactory.createTblWidth(); 
	                        tcpr24.setTcW(tblwidth24); 
	                            tblwidth24.setW( BigInteger.valueOf( 1842) ); 
	                            tblwidth24.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders5 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr24.setTcBorders(tcprinnertcborders5); 
	                            // Create object for bottom
	                            CTBorder border8 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders5.setBottom(border8); 
	                                border8.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border8.setSz( BigInteger.valueOf( 4) ); 
	                                border8.setColor( "auto"); 
	                                border8.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border9 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders5.setLeft(border9); 
	                                border9.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc25 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped25 = wmlObjectFactory.createTrTc(tc25); 
	                tr3.getContent().add( tcWrapped25); 
	                    // Create object for p
	                    P p46 = wmlObjectFactory.createP(); 
	                    tc25.getContent().add( p46); 
	                        // Create object for pPr
	                        PPr ppr46 = wmlObjectFactory.createPPr(); 
	                        p46.setPPr(ppr46); 
	                            // Create object for jc
	                            Jc jc39 = wmlObjectFactory.createJc(); 
	                            ppr46.setJc(jc39); 
	                                jc39.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r48 = wmlObjectFactory.createR(); 
	                        p46.getContent().add( r48); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text40 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped40 = wmlObjectFactory.createRT(text40); 
	                            r48.getContent().add( textWrapped40); 
	                                text40.setValue( "6"); 
	                    // Create object for tcPr
	                    TcPr tcpr25 = wmlObjectFactory.createTcPr(); 
	                    tc25.setTcPr(tcpr25); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc23 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr25.setVAlign(verticaljc23); 
	                            verticaljc23.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth25 = wmlObjectFactory.createTblWidth(); 
	                        tcpr25.setTcW(tblwidth25); 
	                            tblwidth25.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth25.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders6 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr25.setTcBorders(tcprinnertcborders6); 
	                            // Create object for bottom
	                            CTBorder border10 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders6.setBottom(border10); 
	                                border10.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border10.setSz( BigInteger.valueOf( 4) ); 
	                                border10.setColor( "auto"); 
	                                border10.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border11 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders6.setLeft(border11); 
	                                border11.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc26 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped26 = wmlObjectFactory.createTrTc(tc26); 
	                tr3.getContent().add( tcWrapped26); 
	                    // Create object for p
	                    P p47 = wmlObjectFactory.createP(); 
	                    tc26.getContent().add( p47); 
	                        // Create object for pPr
	                        PPr ppr47 = wmlObjectFactory.createPPr(); 
	                        p47.setPPr(ppr47); 
	                            // Create object for jc
	                            Jc jc40 = wmlObjectFactory.createJc(); 
	                            ppr47.setJc(jc40); 
	                                jc40.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r49 = wmlObjectFactory.createR(); 
	                        p47.getContent().add( r49); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text41 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped41 = wmlObjectFactory.createRT(text41); 
	                            r49.getContent().add( textWrapped41); 
	                                text41.setValue( "7"); 
	                    // Create object for tcPr
	                    TcPr tcpr26 = wmlObjectFactory.createTcPr(); 
	                    tc26.setTcPr(tcpr26); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc24 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr26.setVAlign(verticaljc24); 
	                            verticaljc24.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth26 = wmlObjectFactory.createTblWidth(); 
	                        tcpr26.setTcW(tblwidth26); 
	                            tblwidth26.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth26.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders7 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr26.setTcBorders(tcprinnertcborders7); 
	                            // Create object for bottom
	                            CTBorder border12 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders7.setBottom(border12); 
	                                border12.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border12.setSz( BigInteger.valueOf( 4) ); 
	                                border12.setColor( "auto"); 
	                                border12.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border13 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders7.setLeft(border13); 
	                                border13.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc27 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped27 = wmlObjectFactory.createTrTc(tc27); 
	                tr3.getContent().add( tcWrapped27); 
	                    // Create object for p
	                    P p48 = wmlObjectFactory.createP(); 
	                    tc27.getContent().add( p48); 
	                        // Create object for pPr
	                        PPr ppr48 = wmlObjectFactory.createPPr(); 
	                        p48.setPPr(ppr48); 
	                            // Create object for jc
	                            Jc jc41 = wmlObjectFactory.createJc(); 
	                            ppr48.setJc(jc41); 
	                                jc41.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r50 = wmlObjectFactory.createR(); 
	                        p48.getContent().add( r50); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text42 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped42 = wmlObjectFactory.createRT(text42); 
	                            r50.getContent().add( textWrapped42); 
	                                text42.setValue( "8"); 
	                    // Create object for tcPr
	                    TcPr tcpr27 = wmlObjectFactory.createTcPr(); 
	                    tc27.setTcPr(tcpr27); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc25 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr27.setVAlign(verticaljc25); 
	                            verticaljc25.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth27 = wmlObjectFactory.createTblWidth(); 
	                        tcpr27.setTcW(tblwidth27); 
	                            tblwidth27.setW( BigInteger.valueOf( 2126) ); 
	                            tblwidth27.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders8 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr27.setTcBorders(tcprinnertcborders8); 
	                            // Create object for bottom
	                            CTBorder border14 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders8.setBottom(border14); 
	                                border14.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border14.setSz( BigInteger.valueOf( 4) ); 
	                                border14.setColor( "auto"); 
	                                border14.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border15 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders8.setLeft(border15); 
	                                border15.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc28 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped28 = wmlObjectFactory.createTrTc(tc28); 
	                tr3.getContent().add( tcWrapped28); 
	                    // Create object for p
	                    P p49 = wmlObjectFactory.createP(); 
	                    tc28.getContent().add( p49); 
	                        // Create object for pPr
	                        PPr ppr49 = wmlObjectFactory.createPPr(); 
	                        p49.setPPr(ppr49); 
	                            // Create object for jc
	                            Jc jc42 = wmlObjectFactory.createJc(); 
	                            ppr49.setJc(jc42); 
	                                jc42.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r51 = wmlObjectFactory.createR(); 
	                        p49.getContent().add( r51); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text43 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped43 = wmlObjectFactory.createRT(text43); 
	                            r51.getContent().add( textWrapped43); 
	                                text43.setValue( "9"); 
	                    // Create object for tcPr
	                    TcPr tcpr28 = wmlObjectFactory.createTcPr(); 
	                    tc28.setTcPr(tcpr28); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc26 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr28.setVAlign(verticaljc26); 
	                            verticaljc26.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth28 = wmlObjectFactory.createTblWidth(); 
	                        tcpr28.setTcW(tblwidth28); 
	                            tblwidth28.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth28.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders9 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr28.setTcBorders(tcprinnertcborders9); 
	                            // Create object for bottom
	                            CTBorder border16 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders9.setBottom(border16); 
	                                border16.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border16.setSz( BigInteger.valueOf( 4) ); 
	                                border16.setColor( "auto"); 
	                                border16.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border17 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders9.setLeft(border17); 
	                                border17.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc29 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped29 = wmlObjectFactory.createTrTc(tc29); 
	                tr3.getContent().add( tcWrapped29); 
	                    // Create object for p
	                    P p50 = wmlObjectFactory.createP(); 
	                    tc29.getContent().add( p50); 
	                        // Create object for pPr
	                        PPr ppr50 = wmlObjectFactory.createPPr(); 
	                        p50.setPPr(ppr50); 
	                            // Create object for jc
	                            Jc jc43 = wmlObjectFactory.createJc(); 
	                            ppr50.setJc(jc43); 
	                                jc43.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r52 = wmlObjectFactory.createR(); 
	                        p50.getContent().add( r52); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text44 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped44 = wmlObjectFactory.createRT(text44); 
	                            r52.getContent().add( textWrapped44); 
	                                text44.setValue( "10"); 
	                    // Create object for tcPr
	                    TcPr tcpr29 = wmlObjectFactory.createTcPr(); 
	                    tc29.setTcPr(tcpr29); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc27 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr29.setVAlign(verticaljc27); 
	                            verticaljc27.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth29 = wmlObjectFactory.createTblWidth(); 
	                        tcpr29.setTcW(tblwidth29); 
	                            tblwidth29.setW( BigInteger.valueOf( 2127) ); 
	                            tblwidth29.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders10 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr29.setTcBorders(tcprinnertcborders10); 
	                            // Create object for bottom
	                            CTBorder border18 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders10.setBottom(border18); 
	                                border18.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border18.setSz( BigInteger.valueOf( 4) ); 
	                                border18.setColor( "auto"); 
	                                border18.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border19 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders10.setLeft(border19); 
	                                border19.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc30 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped30 = wmlObjectFactory.createTrTc(tc30); 
	                tr3.getContent().add( tcWrapped30); 
	                    // Create object for p
	                    P p51 = wmlObjectFactory.createP(); 
	                    tc30.getContent().add( p51); 
	                        // Create object for pPr
	                        PPr ppr51 = wmlObjectFactory.createPPr(); 
	                        p51.setPPr(ppr51); 
	                            // Create object for jc
	                            Jc jc44 = wmlObjectFactory.createJc(); 
	                            ppr51.setJc(jc44); 
	                                jc44.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                        // Create object for r
	                        R r53 = wmlObjectFactory.createR(); 
	                        p51.getContent().add( r53); 
	                            // Create object for t (wrapped in JAXBElement) 
	                            Text text45 = wmlObjectFactory.createText(); 
	                            JAXBElement<org.docx4j.wml.Text> textWrapped45 = wmlObjectFactory.createRT(text45); 
	                            r53.getContent().add( textWrapped45); 
	                                text45.setValue( "11"); 
	                    // Create object for tcPr
	                    TcPr tcpr30 = wmlObjectFactory.createTcPr(); 
	                    tc30.setTcPr(tcpr30); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc28 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr30.setVAlign(verticaljc28); 
	                            verticaljc28.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth30 = wmlObjectFactory.createTblWidth(); 
	                        tcpr30.setTcW(tblwidth30); 
	                            tblwidth30.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth30.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders11 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr30.setTcBorders(tcprinnertcborders11); 
	                            // Create object for bottom
	                            CTBorder border20 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders11.setBottom(border20); 
	                                border20.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border20.setSz( BigInteger.valueOf( 4) ); 
	                                border20.setColor( "auto"); 
	                                border20.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border21 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders11.setLeft(border21); 
	                                border21.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for trPr
	                TrPr trpr3 = wmlObjectFactory.createTrPr(); 
	                tr3.setTrPr(trpr3); 
	                    // Create object for trHeight (wrapped in JAXBElement) 
	                    CTHeight height3 = wmlObjectFactory.createCTHeight(); 
	                    JAXBElement<org.docx4j.wml.CTHeight> heightWrapped3 = wmlObjectFactory.createCTTrPrBaseTrHeight(height3); 
	                    trpr3.getCnfStyleOrDivIdOrGridBefore().add( heightWrapped3); 
	                        height3.setVal( BigInteger.valueOf( 324) ); 
	            // Create object for tr
	            Tr tr4 = wmlObjectFactory.createTr(); 
	            tbl.getContent().add( tr4); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc31 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped31 = wmlObjectFactory.createTrTc(tc31); 
	                tr4.getContent().add( tcWrapped31); 
	                    // Create object for p
	                    P p52 = wmlObjectFactory.createP(); 
	                    tc31.getContent().add( p52); 
	                        // Create object for pPr
	                        PPr ppr52 = wmlObjectFactory.createPPr(); 
	                        p52.setPPr(ppr52); 
	                            // Create object for jc
	                            Jc jc45 = wmlObjectFactory.createJc(); 
	                            ppr52.setJc(jc45); 
	                                jc45.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr31 = wmlObjectFactory.createTcPr(); 
	                    tc31.setTcPr(tcpr31); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc29 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr31.setVAlign(verticaljc29); 
	                            verticaljc29.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth31 = wmlObjectFactory.createTblWidth(); 
	                        tcpr31.setTcW(tblwidth31); 
	                            tblwidth31.setW( BigInteger.valueOf( 425) ); 
	                            tblwidth31.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders12 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr31.setTcBorders(tcprinnertcborders12); 
	                            // Create object for top
	                            CTBorder border22 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders12.setTop(border22); 
	                                border22.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border22.setSz( BigInteger.valueOf( 4) ); 
	                                border22.setColor( "auto"); 
	                                border22.setSpace( BigInteger.valueOf( 0) ); 
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc32 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped32 = wmlObjectFactory.createTrTc(tc32); 
	                tr4.getContent().add( tcWrapped32); 
	                    // Create object for p
	                    P p53 = wmlObjectFactory.createP(); 
	                    tc32.getContent().add( p53); 
	                        // Create object for pPr
	                        PPr ppr53 = wmlObjectFactory.createPPr(); 
	                        p53.setPPr(ppr53); 
	                            // Create object for jc
	                            Jc jc46 = wmlObjectFactory.createJc(); 
	                            ppr53.setJc(jc46); 
	                                jc46.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr32 = wmlObjectFactory.createTcPr(); 
	                    tc32.setTcPr(tcpr32); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc30 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr32.setVAlign(verticaljc30); 
	                            verticaljc30.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth32 = wmlObjectFactory.createTblWidth(); 
	                        tcpr32.setTcW(tblwidth32); 
	                            tblwidth32.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth32.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders13 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr32.setTcBorders(tcprinnertcborders13); 
	                            // Create object for top
	                            CTBorder border23 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders13.setTop(border23); 
	                                border23.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border23.setSz( BigInteger.valueOf( 4) ); 
	                                border23.setColor( "auto"); 
	                                border23.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border24 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders13.setLeft(border24); 
	                                border24.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc33 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped33 = wmlObjectFactory.createTrTc(tc33); 
	                tr4.getContent().add( tcWrapped33); 
	                    // Create object for p
	                    P p54 = wmlObjectFactory.createP(); 
	                    tc33.getContent().add( p54); 
	                        // Create object for pPr
	                        PPr ppr54 = wmlObjectFactory.createPPr(); 
	                        p54.setPPr(ppr54); 
	                            // Create object for jc
	                            Jc jc47 = wmlObjectFactory.createJc(); 
	                            ppr54.setJc(jc47); 
	                                jc47.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr33 = wmlObjectFactory.createTcPr(); 
	                    tc33.setTcPr(tcpr33); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc31 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr33.setVAlign(verticaljc31); 
	                            verticaljc31.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth33 = wmlObjectFactory.createTblWidth(); 
	                        tcpr33.setTcW(tblwidth33); 
	                            tblwidth33.setW( BigInteger.valueOf( 851) ); 
	                            tblwidth33.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders14 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr33.setTcBorders(tcprinnertcborders14); 
	                            // Create object for top
	                            CTBorder border25 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders14.setTop(border25); 
	                                border25.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border25.setSz( BigInteger.valueOf( 4) ); 
	                                border25.setColor( "auto"); 
	                                border25.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border26 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders14.setLeft(border26); 
	                                border26.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc34 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped34 = wmlObjectFactory.createTrTc(tc34); 
	                tr4.getContent().add( tcWrapped34); 
	                    // Create object for p
	                    P p55 = wmlObjectFactory.createP(); 
	                    tc34.getContent().add( p55); 
	                        // Create object for pPr
	                        PPr ppr55 = wmlObjectFactory.createPPr(); 
	                        p55.setPPr(ppr55); 
	                            // Create object for jc
	                            Jc jc48 = wmlObjectFactory.createJc(); 
	                            ppr55.setJc(jc48); 
	                                jc48.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr34 = wmlObjectFactory.createTcPr(); 
	                    tc34.setTcPr(tcpr34); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc32 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr34.setVAlign(verticaljc32); 
	                            verticaljc32.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth34 = wmlObjectFactory.createTblWidth(); 
	                        tcpr34.setTcW(tblwidth34); 
	                            tblwidth34.setW( BigInteger.valueOf( 1134) ); 
	                            tblwidth34.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders15 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr34.setTcBorders(tcprinnertcborders15); 
	                            // Create object for top
	                            CTBorder border27 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders15.setTop(border27); 
	                                border27.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border27.setSz( BigInteger.valueOf( 4) ); 
	                                border27.setColor( "auto"); 
	                                border27.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border28 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders15.setLeft(border28); 
	                                border28.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc35 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped35 = wmlObjectFactory.createTrTc(tc35); 
	                tr4.getContent().add( tcWrapped35); 
	                    // Create object for p
	                    P p56 = wmlObjectFactory.createP(); 
	                    tc35.getContent().add( p56); 
	                    // Create object for tcPr
	                    TcPr tcpr35 = wmlObjectFactory.createTcPr(); 
	                    tc35.setTcPr(tcpr35); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc33 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr35.setVAlign(verticaljc33); 
	                            verticaljc33.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth35 = wmlObjectFactory.createTblWidth(); 
	                        tcpr35.setTcW(tblwidth35); 
	                            tblwidth35.setW( BigInteger.valueOf( 1842) ); 
	                            tblwidth35.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders16 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr35.setTcBorders(tcprinnertcborders16); 
	                            // Create object for top
	                            CTBorder border29 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders16.setTop(border29); 
	                                border29.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border29.setSz( BigInteger.valueOf( 4) ); 
	                                border29.setColor( "auto"); 
	                                border29.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border30 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders16.setLeft(border30); 
	                                border30.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc36 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped36 = wmlObjectFactory.createTrTc(tc36); 
	                tr4.getContent().add( tcWrapped36); 
	                    // Create object for p
	                    P p57 = wmlObjectFactory.createP(); 
	                    tc36.getContent().add( p57); 
	                        // Create object for pPr
	                        PPr ppr56 = wmlObjectFactory.createPPr(); 
	                        p57.setPPr(ppr56); 
	                            // Create object for jc
	                            Jc jc49 = wmlObjectFactory.createJc(); 
	                            ppr56.setJc(jc49); 
	                                jc49.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr36 = wmlObjectFactory.createTcPr(); 
	                    tc36.setTcPr(tcpr36); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc34 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr36.setVAlign(verticaljc34); 
	                            verticaljc34.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth36 = wmlObjectFactory.createTblWidth(); 
	                        tcpr36.setTcW(tblwidth36); 
	                            tblwidth36.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth36.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders17 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr36.setTcBorders(tcprinnertcborders17); 
	                            // Create object for top
	                            CTBorder border31 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders17.setTop(border31); 
	                                border31.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border31.setSz( BigInteger.valueOf( 4) ); 
	                                border31.setColor( "auto"); 
	                                border31.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border32 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders17.setLeft(border32); 
	                                border32.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc37 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped37 = wmlObjectFactory.createTrTc(tc37); 
	                tr4.getContent().add( tcWrapped37); 
	                    // Create object for p
	                    P p58 = wmlObjectFactory.createP(); 
	                    tc37.getContent().add( p58); 
	                        // Create object for pPr
	                        PPr ppr57 = wmlObjectFactory.createPPr(); 
	                        p58.setPPr(ppr57); 
	                            // Create object for jc
	                            Jc jc50 = wmlObjectFactory.createJc(); 
	                            ppr57.setJc(jc50); 
	                                jc50.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr37 = wmlObjectFactory.createTcPr(); 
	                    tc37.setTcPr(tcpr37); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc35 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr37.setVAlign(verticaljc35); 
	                            verticaljc35.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth37 = wmlObjectFactory.createTblWidth(); 
	                        tcpr37.setTcW(tblwidth37); 
	                            tblwidth37.setW( BigInteger.valueOf( 1276) ); 
	                            tblwidth37.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders18 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr37.setTcBorders(tcprinnertcborders18); 
	                            // Create object for top
	                            CTBorder border33 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders18.setTop(border33); 
	                                border33.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border33.setSz( BigInteger.valueOf( 4) ); 
	                                border33.setColor( "auto"); 
	                                border33.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border34 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders18.setLeft(border34); 
	                                border34.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc38 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped38 = wmlObjectFactory.createTrTc(tc38); 
	                tr4.getContent().add( tcWrapped38); 
	                    // Create object for p
	                    P p59 = wmlObjectFactory.createP(); 
	                    tc38.getContent().add( p59); 
	                        // Create object for pPr
	                        PPr ppr58 = wmlObjectFactory.createPPr(); 
	                        p59.setPPr(ppr58); 
	                            // Create object for jc
	                            Jc jc51 = wmlObjectFactory.createJc(); 
	                            ppr58.setJc(jc51); 
	                                jc51.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr38 = wmlObjectFactory.createTcPr(); 
	                    tc38.setTcPr(tcpr38); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc36 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr38.setVAlign(verticaljc36); 
	                            verticaljc36.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth38 = wmlObjectFactory.createTblWidth(); 
	                        tcpr38.setTcW(tblwidth38); 
	                            tblwidth38.setW( BigInteger.valueOf( 2126) ); 
	                            tblwidth38.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders19 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr38.setTcBorders(tcprinnertcborders19); 
	                            // Create object for top
	                            CTBorder border35 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders19.setTop(border35); 
	                                border35.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border35.setSz( BigInteger.valueOf( 4) ); 
	                                border35.setColor( "auto"); 
	                                border35.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border36 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders19.setLeft(border36); 
	                                border36.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc39 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped39 = wmlObjectFactory.createTrTc(tc39); 
	                tr4.getContent().add( tcWrapped39); 
	                    // Create object for p
	                    P p60 = wmlObjectFactory.createP(); 
	                    tc39.getContent().add( p60); 
	                        // Create object for pPr
	                        PPr ppr59 = wmlObjectFactory.createPPr(); 
	                        p60.setPPr(ppr59); 
	                            // Create object for jc
	                            Jc jc52 = wmlObjectFactory.createJc(); 
	                            ppr59.setJc(jc52); 
	                                jc52.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr39 = wmlObjectFactory.createTcPr(); 
	                    tc39.setTcPr(tcpr39); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc37 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr39.setVAlign(verticaljc37); 
	                            verticaljc37.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth39 = wmlObjectFactory.createTblWidth(); 
	                        tcpr39.setTcW(tblwidth39); 
	                            tblwidth39.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth39.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders20 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr39.setTcBorders(tcprinnertcborders20); 
	                            // Create object for top
	                            CTBorder border37 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders20.setTop(border37); 
	                                border37.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border37.setSz( BigInteger.valueOf( 4) ); 
	                                border37.setColor( "auto"); 
	                                border37.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border38 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders20.setLeft(border38); 
	                                border38.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc40 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped40 = wmlObjectFactory.createTrTc(tc40); 
	                tr4.getContent().add( tcWrapped40); 
	                    // Create object for p
	                    P p61 = wmlObjectFactory.createP(); 
	                    tc40.getContent().add( p61); 
	                        // Create object for pPr
	                        PPr ppr60 = wmlObjectFactory.createPPr(); 
	                        p61.setPPr(ppr60); 
	                            // Create object for jc
	                            Jc jc53 = wmlObjectFactory.createJc(); 
	                            ppr60.setJc(jc53); 
	                                jc53.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr40 = wmlObjectFactory.createTcPr(); 
	                    tc40.setTcPr(tcpr40); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc38 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr40.setVAlign(verticaljc38); 
	                            verticaljc38.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth40 = wmlObjectFactory.createTblWidth(); 
	                        tcpr40.setTcW(tblwidth40); 
	                            tblwidth40.setW( BigInteger.valueOf( 2127) ); 
	                            tblwidth40.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders21 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr40.setTcBorders(tcprinnertcborders21); 
	                            // Create object for top
	                            CTBorder border39 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders21.setTop(border39); 
	                                border39.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border39.setSz( BigInteger.valueOf( 4) ); 
	                                border39.setColor( "auto"); 
	                                border39.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border40 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders21.setLeft(border40); 
	                                border40.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for tc (wrapped in JAXBElement) 
	                Tc tc41 = wmlObjectFactory.createTc(); 
	                JAXBElement<org.docx4j.wml.Tc> tcWrapped41 = wmlObjectFactory.createTrTc(tc41); 
	                tr4.getContent().add( tcWrapped41); 
	                    // Create object for p
	                    P p62 = wmlObjectFactory.createP(); 
	                    tc41.getContent().add( p62); 
	                        // Create object for pPr
	                        PPr ppr61 = wmlObjectFactory.createPPr(); 
	                        p62.setPPr(ppr61); 
	                            // Create object for jc
	                            Jc jc54 = wmlObjectFactory.createJc(); 
	                            ppr61.setJc(jc54); 
	                                jc54.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	                    // Create object for tcPr
	                    TcPr tcpr41 = wmlObjectFactory.createTcPr(); 
	                    tc41.setTcPr(tcpr41); 
	                        // Create object for vAlign
	                        CTVerticalJc verticaljc39 = wmlObjectFactory.createCTVerticalJc(); 
	                        tcpr41.setVAlign(verticaljc39); 
	                            verticaljc39.setVal(org.docx4j.wml.STVerticalJc.CENTER);
	                        // Create object for tcW
	                        TblWidth tblwidth41 = wmlObjectFactory.createTblWidth(); 
	                        tcpr41.setTcW(tblwidth41); 
	                            tblwidth41.setW( BigInteger.valueOf( 1559) ); 
	                            tblwidth41.setType( "dxa"); 
	                        // Create object for tcBorders
	                        TcPrInner.TcBorders tcprinnertcborders22 = wmlObjectFactory.createTcPrInnerTcBorders(); 
	                        tcpr41.setTcBorders(tcprinnertcborders22); 
	                            // Create object for top
	                            CTBorder border41 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders22.setTop(border41); 
	                                border41.setVal(org.docx4j.wml.STBorder.DOUBLE);
	                                border41.setSz( BigInteger.valueOf( 4) ); 
	                                border41.setColor( "auto"); 
	                                border41.setSpace( BigInteger.valueOf( 0) ); 
	                            // Create object for left
	                            CTBorder border42 = wmlObjectFactory.createCTBorder(); 
	                            tcprinnertcborders22.setLeft(border42); 
	                                border42.setVal(org.docx4j.wml.STBorder.NIL);
	                // Create object for trPr
	                TrPr trpr4 = wmlObjectFactory.createTrPr(); 
	                tr4.setTrPr(trpr4); 
	                    // Create object for trHeight (wrapped in JAXBElement) 
	                    CTHeight height4 = wmlObjectFactory.createCTHeight(); 
	                    JAXBElement<org.docx4j.wml.CTHeight> heightWrapped4 = wmlObjectFactory.createCTTrPrBaseTrHeight(height4); 
	                    trpr4.getCnfStyleOrDivIdOrGridBefore().add( heightWrapped4); 
	                        height4.setVal( BigInteger.valueOf( 2355) ); 
	            // Create object for tblPr
	            TblPr tblpr = wmlObjectFactory.createTblPr(); 
	            tbl.setTblPr(tblpr); 
	                // Create object for tblBorders
	                TblBorders tblborders = wmlObjectFactory.createTblBorders(); 
	                tblpr.setTblBorders(tblborders); 
	                    // Create object for insideH
	                    CTBorder border43 = wmlObjectFactory.createCTBorder(); 
	                    tblborders.setInsideH(border43); 
	                        border43.setVal(org.docx4j.wml.STBorder.SINGLE);
	                        border43.setSz( BigInteger.valueOf( 2) ); 
	                        border43.setColor( "auto"); 
	                        border43.setSpace( BigInteger.valueOf( 0) ); 
	                    // Create object for top
	                    CTBorder border44 = wmlObjectFactory.createCTBorder(); 
	                    tblborders.setTop(border44); 
	                        border44.setVal(org.docx4j.wml.STBorder.SINGLE);
	                        border44.setSz( BigInteger.valueOf( 2) ); 
	                        border44.setColor( "auto"); 
	                        border44.setSpace( BigInteger.valueOf( 0) ); 
	                    // Create object for bottom
	                    CTBorder border45 = wmlObjectFactory.createCTBorder(); 
	                    tblborders.setBottom(border45); 
	                        border45.setVal(org.docx4j.wml.STBorder.SINGLE);
	                        border45.setSz( BigInteger.valueOf( 2) ); 
	                        border45.setColor( "auto"); 
	                        border45.setSpace( BigInteger.valueOf( 0) ); 
	                    // Create object for insideV
	                    CTBorder border46 = wmlObjectFactory.createCTBorder(); 
	                    tblborders.setInsideV(border46); 
	                        border46.setVal(org.docx4j.wml.STBorder.SINGLE);
	                        border46.setSz( BigInteger.valueOf( 2) ); 
	                        border46.setColor( "auto"); 
	                        border46.setSpace( BigInteger.valueOf( 0) ); 
	                    // Create object for right
	                    CTBorder border47 = wmlObjectFactory.createCTBorder(); 
	                    tblborders.setRight(border47); 
	                        border47.setVal(org.docx4j.wml.STBorder.SINGLE);
	                        border47.setSz( BigInteger.valueOf( 2) ); 
	                        border47.setColor( "auto"); 
	                        border47.setSpace( BigInteger.valueOf( 0) ); 
	                    // Create object for left
	                    CTBorder border48 = wmlObjectFactory.createCTBorder(); 
	                    tblborders.setLeft(border48); 
	                        border48.setVal(org.docx4j.wml.STBorder.SINGLE);
	                        border48.setSz( BigInteger.valueOf( 2) ); 
	                        border48.setColor( "auto"); 
	                        border48.setSpace( BigInteger.valueOf( 0) ); 
	                // Create object for tblCellMar
	                CTTblCellMar tblcellmar = wmlObjectFactory.createCTTblCellMar(); 
	                tblpr.setTblCellMar(tblcellmar); 
	                    // Create object for left
	                    TblWidth tblwidth42 = wmlObjectFactory.createTblWidth(); 
	                    tblcellmar.setLeft(tblwidth42); 
	                        tblwidth42.setW( BigInteger.valueOf( 70) ); 
	                        tblwidth42.setType( "dxa"); 
	                    // Create object for right
	                    TblWidth tblwidth43 = wmlObjectFactory.createTblWidth(); 
	                    tblcellmar.setRight(tblwidth43); 
	                        tblwidth43.setW( BigInteger.valueOf( 70) ); 
	                        tblwidth43.setType( "dxa"); 
	                // Create object for tblInd
	                TblWidth tblwidth44 = wmlObjectFactory.createTblWidth(); 
	                tblpr.setTblInd(tblwidth44); 
	                    tblwidth44.setW( BigInteger.valueOf( 212) ); 
	                    tblwidth44.setType( "dxa"); 
	                // Create object for tblW
	                TblWidth tblwidth45 = wmlObjectFactory.createTblWidth(); 
	                tblpr.setTblW(tblwidth45); 
	                    tblwidth45.setW( BigInteger.valueOf( 0) ); 
	                    tblwidth45.setType( "auto"); 
	                // Create object for tblLayout
	                CTTblLayoutType tbllayouttype = wmlObjectFactory.createCTTblLayoutType(); 
	                tblpr.setTblLayout(tbllayouttype); 
	                    tbllayouttype.setType(org.docx4j.wml.STTblLayoutType.FIXED);
	                // Create object for tblLook
	                CTTblLook tbllook = wmlObjectFactory.createCTTblLook(); 
	                tblpr.setTblLook(tbllook); 
	                    tbllook.setVal( "0000"); 
	                    tbllook.setFirstColumn(org.docx4j.sharedtypes.STOnOff.ZERO);
	                    tbllook.setFirstRow(org.docx4j.sharedtypes.STOnOff.ZERO);
	                    tbllook.setLastColumn(org.docx4j.sharedtypes.STOnOff.ZERO);
	                    tbllook.setLastRow(org.docx4j.sharedtypes.STOnOff.ZERO);
	                    tbllook.setNoHBand(org.docx4j.sharedtypes.STOnOff.ZERO);
	                    tbllook.setNoVBand(org.docx4j.sharedtypes.STOnOff.ZERO);
	            // Create object for tblGrid
	            TblGrid tblgrid = wmlObjectFactory.createTblGrid(); 
	            tbl.setTblGrid(tblgrid); 
	                // Create object for gridCol
	                TblGridCol tblgridcol = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol); 
	                    tblgridcol.setW( BigInteger.valueOf( 425) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol2 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol2); 
	                    tblgridcol2.setW( BigInteger.valueOf( 1276) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol3 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol3); 
	                    tblgridcol3.setW( BigInteger.valueOf( 851) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol4 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol4); 
	                    tblgridcol4.setW( BigInteger.valueOf( 1134) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol5 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol5); 
	                    tblgridcol5.setW( BigInteger.valueOf( 1842) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol6 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol6); 
	                    tblgridcol6.setW( BigInteger.valueOf( 1276) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol7 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol7); 
	                    tblgridcol7.setW( BigInteger.valueOf( 1276) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol8 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol8); 
	                    tblgridcol8.setW( BigInteger.valueOf( 2126) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol9 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol9); 
	                    tblgridcol9.setW( BigInteger.valueOf( 1559) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol10 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol10); 
	                    tblgridcol10.setW( BigInteger.valueOf( 2127) ); 
	                // Create object for gridCol
	                TblGridCol tblgridcol11 = wmlObjectFactory.createTblGridCol(); 
	                tblgrid.getGridCol().add( tblgridcol11); 
	                    tblgridcol11.setW( BigInteger.valueOf( 1559) ); 
	        // Create object for p
	        P p63 = wmlObjectFactory.createP(); 
	        body.getContent().add( p63); 
	            // Create object for pPr
	            PPr ppr62 = wmlObjectFactory.createPPr(); 
	            p63.setPPr(ppr62); 
	                // Create object for jc
	                Jc jc55 = wmlObjectFactory.createJc(); 
	                ppr62.setJc(jc55); 
	                    jc55.setVal(org.docx4j.wml.JcEnumeration.CENTER);
	        // Create object for p
	        P p64 = wmlObjectFactory.createP(); 
	        body.getContent().add( p64); 
	            // Create object for pPr
	            PPr ppr63 = wmlObjectFactory.createPPr(); 
	            p64.setPPr(ppr63); 
	                // Create object for rPr
	                ParaRPr pararpr40 = wmlObjectFactory.createParaRPr(); 
	                ppr63.setRPr(pararpr40); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure79 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr40.setSz(hpsmeasure79); 
	                        hpsmeasure79.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for ind
	                PPrBase.Ind pprbaseind2 = wmlObjectFactory.createPPrBaseInd(); 
	                ppr63.setInd(pprbaseind2); 
	                    pprbaseind2.setFirstLine( BigInteger.valueOf( 10) ); 
	                // Create object for tabs
	                Tabs tabs8 = wmlObjectFactory.createTabs(); 
	                ppr63.setTabs(tabs8); 
	                    // Create object for tab
	                    CTTabStop tabstop12 = wmlObjectFactory.createCTTabStop(); 
	                    tabs8.getTab().add( tabstop12); 
	                        tabstop12.setPos( BigInteger.valueOf( 9356) ); 
	                        tabstop12.setVal(org.docx4j.wml.STTabJc.LEFT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing9 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr63.setSpacing(pprbasespacing9); 
	                    pprbasespacing9.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing9.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r54 = wmlObjectFactory.createR(); 
	            p64.getContent().add( r54); 
	                // Create object for rPr
	                RPr rpr41 = wmlObjectFactory.createRPr(); 
	                r54.setRPr(rpr41); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure80 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr41.setSz(hpsmeasure80); 
	                        hpsmeasure80.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab13 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped13 = wmlObjectFactory.createRTab(rtab13); 
	                r54.getContent().add( rtabWrapped13); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text46 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped46 = wmlObjectFactory.createRT(text46); 
	                r54.getContent().add( textWrapped46); 
	                    text46.setValue( "Wykonawca .................................................."); 
	        // Create object for p
	        P p65 = wmlObjectFactory.createP(); 
	        body.getContent().add( p65); 
	            // Create object for pPr
	            PPr ppr64 = wmlObjectFactory.createPPr(); 
	            p65.setPPr(ppr64); 
	                // Create object for rPr
	                ParaRPr pararpr41 = wmlObjectFactory.createParaRPr(); 
	                ppr64.setRPr(pararpr41); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure81 = wmlObjectFactory.createHpsMeasure(); 
	                    pararpr41.setSz(hpsmeasure81); 
	                        hpsmeasure81.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tabs
	                Tabs tabs9 = wmlObjectFactory.createTabs(); 
	                ppr64.setTabs(tabs9); 
	                    // Create object for tab
	                    CTTabStop tabstop13 = wmlObjectFactory.createCTTabStop(); 
	                    tabs9.getTab().add( tabstop13); 
	                        tabstop13.setPos( BigInteger.valueOf( 9356) ); 
	                        tabstop13.setVal(org.docx4j.wml.STTabJc.LEFT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing10 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr64.setSpacing(pprbasespacing10); 
	                    pprbasespacing10.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing10.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r55 = wmlObjectFactory.createR(); 
	            p65.getContent().add( r55); 
	                // Create object for rPr
	                RPr rpr42 = wmlObjectFactory.createRPr(); 
	                r55.setRPr(rpr42); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure82 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr42.setSz(hpsmeasure82); 
	                        hpsmeasure82.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab14 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped14 = wmlObjectFactory.createRTab(rtab14); 
	                r55.getContent().add( rtabWrapped14); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text47 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped47 = wmlObjectFactory.createRT(text47); 
	                r55.getContent().add( textWrapped47); 
	                    text47.setValue( "Nr upr. zawod. .............................................."); 
	        // Create object for p
	        P p66 = wmlObjectFactory.createP(); 
	        body.getContent().add( p66); 
	            // Create object for pPr
	            PPr ppr65 = wmlObjectFactory.createPPr(); 
	            p66.setPPr(ppr65); 
	                // Create object for tabs
	                Tabs tabs10 = wmlObjectFactory.createTabs(); 
	                ppr65.setTabs(tabs10); 
	                    // Create object for tab
	                    CTTabStop tabstop14 = wmlObjectFactory.createCTTabStop(); 
	                    tabs10.getTab().add( tabstop14); 
	                        tabstop14.setPos( BigInteger.valueOf( 9356) ); 
	                        tabstop14.setVal(org.docx4j.wml.STTabJc.LEFT);
	                // Create object for spacing
	                PPrBase.Spacing pprbasespacing11 = wmlObjectFactory.createPPrBaseSpacing(); 
	                ppr65.setSpacing(pprbasespacing11); 
	                    pprbasespacing11.setLine( BigInteger.valueOf( 360) ); 
	                    pprbasespacing11.setLineRule(org.docx4j.wml.STLineSpacingRule.AUTO);
	            // Create object for r
	            R r56 = wmlObjectFactory.createR(); 
	            p66.getContent().add( r56); 
	                // Create object for rPr
	                RPr rpr43 = wmlObjectFactory.createRPr(); 
	                r56.setRPr(rpr43); 
	                    // Create object for sz
	                    HpsMeasure hpsmeasure83 = wmlObjectFactory.createHpsMeasure(); 
	                    rpr43.setSz(hpsmeasure83); 
	                        hpsmeasure83.setVal( BigInteger.valueOf( 24) ); 
	                // Create object for tab (wrapped in JAXBElement) 
	                R.Tab rtab15 = wmlObjectFactory.createRTab(); 
	                JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped15 = wmlObjectFactory.createRTab(rtab15); 
	                r56.getContent().add( rtabWrapped15); 
	                // Create object for t (wrapped in JAXBElement) 
	                Text text48 = wmlObjectFactory.createText(); 
	                JAXBElement<org.docx4j.wml.Text> textWrapped48 = wmlObjectFactory.createRT(text48); 
	                r56.getContent().add( textWrapped48); 
	                    text48.setValue( "Data ..............................................................."); 
	        // Create object for sectPr
	        SectPr sectpr = wmlObjectFactory.createSectPr(); 
	        body.setSectPr(sectpr); 
	            // Create object for pgSz
	            SectPr.PgSz sectprpgsz = wmlObjectFactory.createSectPrPgSz(); 
	            sectpr.setPgSz(sectprpgsz); 
	                sectprpgsz.setH( BigInteger.valueOf( 11907) ); 
	                sectprpgsz.setW( BigInteger.valueOf( 16840) ); 
	                sectprpgsz.setOrient(org.docx4j.wml.STPageOrientation.LANDSCAPE);
	                sectprpgsz.setCode( BigInteger.valueOf( 9) ); 
	            // Create object for headerReference
	            HeaderReference headerreference = wmlObjectFactory.createHeaderReference(); 
	            sectpr.getEGHdrFtrReferences().add( headerreference); 
	                headerreference.setType(org.docx4j.wml.HdrFtrRef.EVEN);
	                headerreference.setId( "rId6"); 
	            // Create object for headerReference
	            HeaderReference headerreference2 = wmlObjectFactory.createHeaderReference(); 
	            sectpr.getEGHdrFtrReferences().add( headerreference2); 
	                headerreference2.setType(org.docx4j.wml.HdrFtrRef.DEFAULT);
	                headerreference2.setId( "rId7"); 
	            // Create object for pgMar
	            SectPr.PgMar sectprpgmar = wmlObjectFactory.createSectPrPgMar(); 
	            sectpr.setPgMar(sectprpgmar); 
	                sectprpgmar.setGutter( BigInteger.valueOf( 0) ); 
	                sectprpgmar.setLeft( BigInteger.valueOf( 567) ); 
	                sectprpgmar.setRight( BigInteger.valueOf( 567) ); 
	                sectprpgmar.setTop( BigInteger.valueOf( 1127) ); 
	                sectprpgmar.setBottom( BigInteger.valueOf( 567) ); 
	                sectprpgmar.setHeader( BigInteger.valueOf( 567) ); 
	                sectprpgmar.setFooter( BigInteger.valueOf( 708) ); 
	            // Create object for cols
	            CTColumns columns = wmlObjectFactory.createCTColumns(); 
	            sectpr.setCols(columns); 
	                columns.setSpace( BigInteger.valueOf( 708) ); 
	    document.setIgnorable( "w14 w15 w16se w16cid wp14"); 

	return document;
	}
	}


