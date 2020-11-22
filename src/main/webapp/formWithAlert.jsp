<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
}

.col-25-alert {
	float: left;
	width: 25%;
	margin-top: 6px;
	color: red;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

.alert-75 {
	color: red;
	width: 25%;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.col-25, col-25-alert, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}

h1 {
	text-align: center;
	font-family: Tahoma, Arial, sans-serif;
	color: #06D85F;
	margin: 80px 0;
}

.box {
	width: 40%;
	margin: 0 auto;
	background: rgba(255, 255, 255, 0.2);
	padding: 35px;
	border: 2px solid #fff;
	border-radius: 20px/50px;
	background-clip: padding-box;
	text-align: center;
}

.button {
	font-size: 1em;
	padding: 10px;
	color: #fff;
	border: 2px solid #06D85F;
	border-radius: 20px/50px;
	text-decoration: none;
	cursor: pointer;
	transition: all 0.3s ease-out;
}

.button:hover {
	background: #06D85F;
}

.overlay {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.7);
	transition: opacity 500ms;
	visibility: hidden;
	opacity: 0;
}

.overlay-visible {
	visibility: visible;
	opacity: 1;
}

.popup {
	margin: 70px auto;
	padding: 20px;
	background: #fff;
	border-radius: 5px;
	width: 30%;
	position: relative;
	transition: all 5s ease-in-out;
}

.popup h2 {
	margin-top: 0;
	color: #333;
	font-family: Tahoma, Arial, sans-serif;
}

.popup .close {
	position: absolute;
	top: 20px;
	right: 30px;
	transition: all 200ms;
	font-size: 30px;
	font-weight: bold;
	text-decoration: none;
	color: #333;
}

.popup .close:hover {
	color: #06D85F;
}

.popup .content {
	max-height: 30%;
	overflow: auto;
}
</style>
<head>
<meta charset="UTF-8">
<meta name="auhor" content="Paweł Guzik">
<meta name='keywords' content='KW, księgi wieczyste, raport'>
<meta name="description"
	content="Serwis do raportowania treści księgi wieczystej wymaganej podczes 
		badania KW na potrzeby prac geodezyjnych.">
<title>Generator raportów z KW</title>
</head>
<body>

	<h3>Generator raportów z KW na potrzeby prac geodezyjnych</h3>
	<p>Uzupełnij dane księgi wieczystej, z której chcesz wygenerować
		raport</p>

	<div id="popup1"
		class="overlay ${requestScope.invalidNumber ? 'overlay-visible' : ''}"
		onclick="document.getElementById('popup1').style.display='none'">
		<div class="popup">
			<h2>Błędne dane</h2>
			<a class="close" href="#">&times;</a>
			<div class="content">Podana cyfra kontrolna jest nieprawidłowa.</div>
		</div>
	</div>

	<div class="container">
		<form action="RaportServlet" method="POST">
			<div class="row">
				<div class="col-25">
					<label for="kodWydzialu">Kod wydziału</label>
				</div>
				<div class="col-75">
					<select id="kodWydzialu" name="kodWydzialu" required="required">
						<option value="" selected="selected">Wybierz</option>
						<option value="WL1A">ALEKSANDRÓW KUJAWSKI - WL1A</option>

						<option value="SU1A">AUGUSTÓW - SU1A</option>

						<option value="OL1Y">BARTOSZYCE - OL1Y</option>

						<option value="PT1B">BEŁCHATÓW - PT1B</option>

						<option value="RA2G">BIAŁOBRZEGI - RA2G</option>

						<option value="KO1B">BIAŁOGARD - KO1B</option>

						<option value="BB1B">BIELSKO-BIAŁA - BB1B</option>

						<option value="BI1P">BIELSK PODLASKI - BI1P</option>

						<option value="ZA1B">BIŁGORAJ - ZA1B</option>

						<option value="OL1B">BISKUPIEC - OL1B</option>

						<option value="JG1B">BOLESŁAWIEC - JG1B</option>

						<option value="EL1B">BRANIEWO - EL1B</option>

						<option value="OP1B">BRZEG - OP1B</option>

						<option value="KI1B">BUSKO ZDRÓJ - KI1B</option>

						<option value="BY1B">BYDGOSZCZ - BY1B</option>

						<option value="TO1C">CHEŁMNO - TO1C</option>

						<option value="PO1H">CHODZIEŻ - PO1H</option>

						<option value="SL1C">CHOJNICE - SL1C</option>

						<option value="KA1C">CHORZÓW - KA1C</option>

						<option value="KR1C">CHRZANÓW - KR1C</option>

						<option value="BB1C">CIESZYN - BB1C</option>

						<option value="PO2T">CZARNKÓW - PO2T</option>

						<option value="KR1K">CZERNICHÓW - KR1K</option>

						<option value="CZ1C">CZĘSTOCHOWA - CZ1C</option>

						<option value="RZ1D">DĘBICA - RZ1D</option>

						<option value="KO1D">DRAWSKO POMORSKIE - KO1D</option>

						<option value="SW1D">DZIERŻONIÓW - SW1D</option>

						<option value="OL1E">EŁK - OL1E</option>

						<option value="GD1G">GDAŃSK - GD1G</option>

						<option value="GD1Y">GDYNIA - GD1Y</option>

						<option value="OL1G">GIŻYCKO - OL1G</option>

						<option value="GL1G">GLIWICE - GL1G</option>

						<option value="LE1G">GŁOGÓW - LE1G</option>

						<option value="OP1G">GŁUBCZYCE - OP1G</option>

						<option value="SZ1O">GOLENIÓW - SZ1O</option>

						<option value="TO1G">GOLUB-DOBRZYŃ - TO1G</option>

						<option value="NS1G">GORLICE - NS1G</option>

						<option value="GW1G">GORZÓW WIELKOPOLSKI - GW1G</option>

						<option value="PL1G">GOSTYNIN - PL1G</option>

						<option value="PO1Y">GOSTYŃ - PO1Y</option>

						<option value="LM1G">GRAJEWO - LM1G</option>

						<option value="PO1S">GRODZISK WLKP. - PO1S</option>

						<option value="TO1U">GRUDZIĄDZ - TO1U</option>

						<option value="SZ1G">GRYFICE - SZ1G</option>

						<option value="SZ1Y">GRYFINO - SZ1Y</option>

						<option value="ZG2K">GUBIN - ZG2K</option>

						<option value="BI2P">HAJNÓWKA - BI2P</option>

						<option value="ZA1H">HRUBIESZÓW - ZA1H</option>

						<option value="BY1I">INOWROCŁAW - BY1I</option>

						<option value="ZA1J">JANÓW LUBELSKI - ZA1J</option>

						<option value="PR1J">JAROSŁAW - PR1J</option>

						<option value="GL1J">JASTRZĘBIE-ZDRÓJ - GL1J</option>

						<option value="JG1J">JELENIA GÓRA - JG1J</option>

						<option value="SZ1K">KAMIEŃ POMORSKI - SZ1K</option>

						<option value="GD1R">KARTUZY - GD1R</option>

						<option value="KA1K">KATOWICE - KA1K</option>

						<option value="KI1I">KAZIMIERZA WIELKA - KI1I</option>

						<option value="OP1K">KĘDZIERZYN-KOŹLE - OP1K</option>

						<option value="KZ1E">KĘPNO - KZ1E</option>

						<option value="OL1K">KĘTRZYN - OL1K</option>

						<option value="KR2E">KĘTY - KR2E</option>

						<option value="KI1L">KIELCE - KI1L</option>

						<option value="OP1U">KLUCZBORK - OP1U</option>

						<option value="CZ2C">KŁOBUCK - CZ2C</option>

						<option value="SW1K">KŁODZKO - SW1K</option>

						<option value="KO1L">KOŁOBRZEG - KO1L</option>

						<option value="KN1K">KOŁO - KN1K</option>

						<option value="KN1N">KONIN - KN1N</option>

						<option value="PO1K">KOŚCIAN - PO1K</option>

						<option value="RA1K">KOZIENICE - RA1K</option>

						<option value="KR1P">KRAKÓW - KR1P</option>

						<option value="ZA1K">KRASNYSTAW - ZA1K</option>

						<option value="LU1K">KRAŚNIK - LU1K</option>

						<option value="KS1K">KROSNO - KS1K</option>

						<option value="KZ1R">KROTOSZYN - KZ1R</option>

						<option value="KR2K">KRZESZOWICE - KR2K</option>

						<option value="LD1K">KUTNO - LD1K</option>

						<option value="GD1I">KWIDZYN - GD1I</option>

						<option value="WA1L">LEGIONOWO - WA1L</option>

						<option value="LE1L">LEGNICA - LE1L</option>

						<option value="PO1L">LESZNO - PO1L</option>

						<option value="RZ1E">LEŻAJSK - RZ1E</option>

						<option value="OL1L">LIDZBARK WARMIŃSKI - OL1L</option>

						<option value="NS1L">LIMANOWA - NS1L</option>

						<option value="WL1L">LIPNO - WL1L</option>

						<option value="RA1L">LIPSKO - RA1L</option>

						<option value="LU1A">LUBARTÓW - LU1A</option>

						<option value="LE1U">LUBIN - LE1U</option>

						<option value="LU1I">LUBLIN - LU1I</option>

						<option value="RZ1A">ŁAŃCUT - RZ1A</option>

						<option value="SR1L">ŁASK - SR1L</option>

						<option value="LD1Y">ŁĘCZYCA - LD1Y</option>

						<option value="SZ1L">ŁOBEZ - SZ1L</option>

						<option value="LM1L">ŁOMŻA - LM1L</option>

						<option value="SI2S">ŁOSICE - SI2S</option>

						<option value="LD1O">ŁOWICZ - LD1O</option>

						<option value="LD1M">ŁÓDŹ - LD1M</option>

						<option value="LU1U">ŁUKÓW - LU1U</option>

						<option value="GD1M">MALBORK - GD1M</option>

						<option value="SL1M">MIASTKO - SL1M</option>

						<option value="KR1M">MIECHÓW - KR1M</option>

						<option value="GW1M">MIĘDZYRZECZ - GW1M</option>

						<option value="KA1M">MIKOŁÓW - KA1M</option>

						<option value="WR1M">MILICZ - WR1M</option>

						<option value="SI1M">MIŃSK MAZOWIECKI - SI1M</option>

						<option value="OL1M">MRĄGOWO - OL1M</option>

						<option value="NS2L">MSZANA DOLNA - NS2L</option>

						<option value="NS1M">MUSZYNA - NS1M</option>

						<option value="KA1L">MYSŁOWICE - KA1L</option>

						<option value="CZ1M">MYSZKÓW - CZ1M</option>

						<option value="KR1Y">MYŚLENICE - KR1Y</option>

						<option value="SZ1M">MYŚLIBÓRZ - SZ1M</option>

						<option value="OL1N">NIDZICA - OL1N</option>

						<option value="KR2I">NIEPOŁOMICE - KR2I</option>

						<option value="TB1N">NISKO - TB1N</option>

						<option value="SW2K">NOWA RUDA - SW2K</option>

						<option value="ZG1N">NOWA SÓL - ZG1N</option>

						<option value="EL1N">NOWE MIASTO LUBAWSKIE - EL1N</option>

						<option value="GD2M">NOWY DWÓR GDAŃSKI - GD2M</option>

						<option value="WA1N">NOWY DWÓR MAZOWIECKI - WA1N</option>

						<option value="NS1S">NOWY SĄCZ - NS1S</option>

						<option value="NS1T">NOWY TARG - NS1T</option>

						<option value="PO1N">NOWY TOMYŚL - PO1N</option>

						<option value="OP1N">NYSA - OP1N</option>

						<option value="PO1O">OBORNIKI - PO1O</option>

						<option value="OL1C">OLECKO - OL1C</option>

						<option value="WR1E">OLEŚNICA - WR1E</option>

						<option value="KR1O">OLKUSZ - KR1O</option>

						<option value="OL1O">OLSZTYN - OL1O</option>

						<option value="WR1O">OŁAWA - WR1O</option>

						<option value="KI1T">OPATÓW - KI1T</option>

						<option value="PT1O">OPOCZNO - PT1O</option>

						<option value="LU1O">OPOLE LUBELSKIE - LU1O</option>

						<option value="OP1O">OPOLE - OP1O</option>

						<option value="OS1O">OSTROŁĘKA - OS1O</option>

						<option value="KI1O">OSTROWIEC ŚWIĘTOKRZYSKI - KI1O</option>

						<option value="EL1O">OSTRÓDA - EL1O</option>

						<option value="OS1M">OSTRÓW MAZOWIECKA - OS1M</option>

						<option value="KZ1W">OSTRÓW WIELKOPOLSKI - KZ1W</option>

						<option value="KZ1O">OSTRZESZÓW - KZ1O</option>

						<option value="KR1E">OŚWIĘCIM - KR1E</option>

						<option value="WA1O">OTWOCK - WA1O</option>

						<option value="LD1P">PABIANICE - LD1P</option>

						<option value="SR2W">PAJĘCZNO - SR2W</option>

						<option value="WA1I">PIASECZNO - WA1I</option>

						<option value="PO1I">PIŁA - PO1I</option>

						<option value="KI1P">PIŃCZÓW - KI1P</option>

						<option value="RA2Z">PIONKI - RA2Z</option>

						<option value="PT1P">PIOTRKÓW TRYBUNALSKI - PT1P</option>

						<option value="OL1P">PISZ - OL1P</option>

						<option value="KZ1P">PLESZEW - KZ1P</option>

						<option value="PL1P">PŁOCK - PL1P</option>

						<option value="PL1L">PŁOŃSK - PL1L</option>

						<option value="SR2L">PODDĘBICE - SR2L</option>

						<option value="SZ2S">POLICE - SZ2S</option>

						<option value="PO1P">POZNAŃ (V) - PO1P</option>

						<option value="PO2P">POZNAŃ (VI) - PO2P</option>

						<option value="KR1H">PROSZOWICE - KR1H</option>

						<option value="OP1P">PRUDNIK - OP1P</option>

						<option value="WA1P">PRUSZKÓW - WA1P</option>

						<option value="OS1P">PRZASNYSZ - OS1P</option>

						<option value="PR1P">PRZEMYŚL - PR1P</option>

						<option value="PR1R">PRZEWORSK - PR1R</option>

						<option value="RA1P">PRZYSUCHA - RA1P</option>

						<option value="KA1P">PSZCZYNA - KA1P</option>

						<option value="GD2W">PUCK - GD2W</option>

						<option value="LU1P">PUŁAWY - LU1P</option>

						<option value="OS1U">PUŁTUSK - OS1U</option>

						<option value="SZ2T">PYRZYCE - SZ2T</option>

						<option value="GL1R">RACIBÓRZ - GL1R</option>

						<option value="RA1R">RADOM - RA1R</option>

						<option value="PT1R">RADOMSKO - PT1R</option>

						<option value="WL1R">RADZIEJÓW - WL1R</option>

						<option value="LU1R">RADZYŃ PODLASKI - LU1R</option>

						<option value="LD1R">RAWA MAZOWIECKA - LD1R</option>

						<option value="PO1R">RAWICZ - PO1R</option>

						<option value="RZ1R">ROPCZYCE - RZ1R</option>

						<option value="GL1S">RUDA ŚLĄSKA - GL1S</option>

						<option value="GL1Y">RYBNIK - GL1Y</option>

						<option value="LU1Y">RYKI - LU1Y</option>

						<option value="WL1Y">RYPIN - WL1Y</option>

						<option value="RZ1Z">RZESZÓW - RZ1Z</option>

						<option value="KI1S">SANDOMIERZ - KI1S</option>

						<option value="KS1S">SANOK - KS1S</option>

						<option value="SU1N">SEJNY - SU1N</option>

						<option value="BY2T">SĘPÓLNO KRAJEŃSKIE - BY2T</option>

						<option value="SI1S">SIEDLCE - SI1S</option>

						<option value="KA1I">SIEMIANOWICE ŚLĄSKIE - KA1I</option>

						<option value="BI3P">SIEMIATYCZE - BI3P</option>

						<option value="PR2R">SIENIAWA - PR2R</option>

						<option value="SR1S">SIERADZ - SR1S</option>

						<option value="PL1E">SIERPC - PL1E</option>

						<option value="KR2P">SKAŁA - KR2P</option>

						<option value="KI1R">SKARŻYSKO-KAMIENNA - KI1R</option>

						<option value="KR3I">SKAWINA - KR3I</option>

						<option value="LD1H">SKIERNIEWICE - LD1H</option>

						<option value="KO1E">SŁAWNO - KO1E</option>

						<option value="KR1S">SŁOMNIKI - KR1S</option>

						<option value="GW1S">SŁUBICE - GW1S</option>

						<option value="KN1S">SŁUPCA - KN1S</option>

						<option value="SL1S">SŁUPSK - SL1S</option>

						<option value="PL1O">SOCHACZEW - PL1O</option>

						<option value="SI1P">SOKOŁÓW PODLASKI - SI1P</option>

						<option value="BI1S">SOKÓŁKA - BI1S</option>

						<option value="GD1S">SOPOT - GD1S</option>

						<option value="KA1S">SOSNOWIEC - KA1S</option>

						<option value="TB1S">STALOWA WOLA - TB1S</option>

						<option value="KI1H">STARACHOWICE - KI1H</option>

						<option value="SZ1T">STARGARD - SZ1T</option>

						<option value="GD1A">STAROGARD GDAŃSKI - GD1A</option>

						<option value="KI1A">STASZÓW - KI1A</option>

						<option value="GW1K">STRZELCE KRAJEŃSKIE - GW1K</option>

						<option value="OP1S">STRZELCE OPOLSKIE - OP1S</option>

						<option value="WR1T">STRZELIN - WR1T</option>

						<option value="RZ1S">STRZYŻÓW - RZ1S</option>

						<option value="KR1B">SUCHA BESKIDZKA - KR1B</option>

						<option value="ZG2S">SULECHÓW - ZG2S</option>

						<option value="GW1U">SULĘCIN - GW1U</option>

						<option value="SU1S">SUWAŁKI - SU1S</option>

						<option value="PO1A">SZAMOTUŁY - PO1A</option>

						<option value="KO1I">SZCZECINEK - KO1I</option>

						<option value="SZ1S">SZCZECIN - SZ1S</option>

						<option value="OL1S">SZCZYTNO - OL1S</option>

						<option value="GD2I">SZTUM - GD2I</option>

						<option value="BY1U">SZUBIN - BY1U</option>

						<option value="RA1S">SZYDŁOWIEC - RA1S</option>

						<option value="PO1M">ŚREM - PO1M</option>

						<option value="WR1S">ŚRODA ŚLĄSKA - WR1S</option>

						<option value="PO1D">ŚRODA WLKP. - PO1D</option>

						<option value="SW1S">ŚWIDNICA - SW1S</option>

						<option value="LU1S">ŚWIDNIK - LU1S</option>

						<option value="KO2B">ŚWIDWIN - KO2B</option>

						<option value="ZG1S">ŚWIEBODZIN - ZG1S</option>

						<option value="BY1S">ŚWIECIE - BY1S</option>

						<option value="SZ1W">ŚWINOUJŚCIE - SZ1W</option>

						<option value="TB1T">TARNOBRZEG - TB1T</option>

						<option value="GL1T">TARNOWSKIE GÓRY - GL1T</option>

						<option value="TR1T">TARNÓW - TR1T</option>

						<option value="GD1T">TCZEW - GD1T</option>

						<option value="ZA1T">TOMASZÓW LUBELSKI - ZA1T</option>

						<option value="PT1T">TOMASZÓW MAZOWIECKI - PT1T</option>

						<option value="TO1T">TORUŃ - TO1T</option>

						<option value="PO1T">TRZCIANKA - PO1T</option>

						<option value="WR1W">TRZEBNICA - WR1W</option>

						<option value="BY1T">TUCHOLA - BY1T</option>

						<option value="TR2T">TUCHÓW - TR2T</option>

						<option value="KN1T">TUREK - KN1T</option>

						<option value="KA1T">TYCHY - KA1T</option>

						<option value="RZ2Z">TYCZYN - RZ2Z</option>

						<option value="KS2E">USTRZYKI DOLNE - KS2E</option>

						<option value="KR1W">WADOWICE - KR1W</option>

						<option value="SW1W">WAŁBRZYCH - SW1W</option>

						<option value="KO1W">WAŁCZ - KO1W</option>

						<option value="WA3M">WARSZAWA (IX) - WA3M</option>

						<option value="WA1M">WARSZAWA (VI) - WA1M</option>

						<option value="WA2M">WARSZAWA (VII) - WA2M</option>

						<option value="WA4M">WARSZAWA (X) - WA4M</option>

						<option value="WA5M">WARSZAWA (XIII) - WA5M</option>

						<option value="WA6M">WARSZAWA (XV) - WA6M</option>

						<option value="CIKW">WARSZAWA - CIKW</option>

						<option value="TO1W">WĄBRZEŹNO - TO1W</option>

						<option value="PO1B">WĄGROWIEC - PO1B</option>

						<option value="GD1W">WEJHEROWO - GD1W</option>

						<option value="OL2G">WĘGORZEWO - OL2G</option>

						<option value="SI1W">WĘGRÓW - SI1W</option>

						<option value="KR1I">WIELICZKA - KR1I</option>

						<option value="SR1W">WIELUŃ - SR1W</option>

						<option value="WL1W">WŁOCŁAWEK - WL1W</option>

						<option value="LU1W">WŁODAWA - LU1W</option>

						<option value="KI1W">WŁOSZCZOWA - KI1W</option>

						<option value="GL1W">WODZISŁAW ŚLĄSKI - GL1W</option>

						<option value="PO1E">WOLSZTYN - PO1E</option>

						<option value="WA1W">WOŁOMIN - WA1W</option>

						<option value="WR1L">WOŁÓW - WR1L</option>

						<option value="WR1K">WROCŁAW - WR1K</option>

						<option value="PO1F">WRZEŚNIA - PO1F</option>

						<option value="ZG1W">WSCHOWA - ZG1W</option>

						<option value="PO2H">WYRZYSK - PO2H</option>

						<option value="LM1W">WYSOKIE MAZOWIECKIE - LM1W</option>

						<option value="OS1W">WYSZKÓW - OS1W</option>

						<option value="GL1Z">ZABRZE - GL1Z</option>

						<option value="NS1Z">ZAKOPANE - NS1Z</option>

						<option value="LM1Z">ZAMBRÓW - LM1Z</option>

						<option value="ZA1Z">ZAMOŚĆ - ZA1Z</option>

						<option value="CZ1Z">ZAWIERCIE - CZ1Z</option>

						<option value="SW1Z">ZĄBKOWICE ŚLĄSKIE - SW1Z</option>

						<option value="SR1Z">ZDUŃSKA WOLA - SR1Z</option>

						<option value="LD1G">ZGIERZ - LD1G</option>

						<option value="JG1Z">ZGORZELEC - JG1Z</option>

						<option value="ZG1E">ZIELONA GÓRA - ZG1E</option>

						<option value="LE1Z">ZŁOTORYJA - LE1Z</option>

						<option value="PO1Z">ZŁOTÓW - PO1Z</option>

						<option value="RA1Z">ZWOLEŃ - RA1Z</option>

						<option value="ZG1G">ŻAGAŃ - ZG1G</option>

						<option value="ZG1R">ŻARY - ZG1R</option>

						<option value="BY1Z">ŻNIN - BY1Z</option>

						<option value="GL1X">ŻORY - GL1X</option>

						<option value="PL2M">ŻUROMIN - PL2M</option>

						<option value="PL1Z" selected="selected">ŻYRARDÓW - PL1Z</option>

						<option value="BB1Z">ŻYWIEC - BB1Z</option>

						<option value="DIRS">ŻŻ DIRS - DIRS</option>

					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="lname">Numer KW</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="numerKW" placeholder="Numer KW"
						value="2121" required="required">
				</div>
			</div>
			<div class="row">
				<div
					class=" ${requestScope.invalidNumber ? 'col-25-alert' : 'col-25'}">
					<label for="cyfraKontrolna">Cyfra kontrolna</label>
				</div>
				<div class="col-75">
					<input type="text" id="cyfraKontrolna" name="cyfraKontrolna"
						placeholder="Cyfra kontrolna" value="0" required="required">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="author">Imię i nazwisko wykonawcy</label>
				</div>
				<div class="col-75">
					<input type="text" id="author" name="author"
						placeholder="Imię i nazwisko wykonawcy" value="BSBatory">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="voivodeship">Województwo</label>
				</div>
				<div class="col-75">
					<input type="text" id="voivodeship" name="voivodeship"
						placeholder="Województwo" value="mazowieckie">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="county">Powiat</label>
				</div>
				<div class="col-75">
					<input type="text" id="county" name="county" placeholder="Powiat"
						value="żyrardowski">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="landRegUnit">Jednostka ewidencyjna</label>
				</div>
				<div class="col-75">
					<input type="text" id="landRegUnit" name="landRegUnit"
						placeholder="Jednostka ewidencyjna" value="Puszcza">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="regPrecinct">Obręb - nazwa</label>
				</div>
				<div class="col-75">
					<input type="text" id="regPrecinct" name="regPrecinct"
						placeholder="Obręb" value="Bartniki">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="regPrecinctNumber">Obręb - numer</label>
				</div>
				<div class="col-75">
					<input type="text" id="regPrecinctNumber" name="regPrecinctNumber"
						placeholder="Obręb" value="0022">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Generuj raport">
			</div>
			<div class="row">
				<label>${requestScope.raportCreated ? 'Wysłano wygenerowany raport!' : ''}</label>
				</div>
		</form>
	</div>

</body>
</html>