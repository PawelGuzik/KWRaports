package tests;

import static kw.raport.model.utils.OwnerProducer.produce;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.ArrayList;
import java.util.List;
import kw.raport.model.utils.ContolNumberCalc;

import org.junit.Before;
import org.junit.Test; 

public class ControlNumberCalcUTest { 
	
	@Test
	public void ifNumberIsCorrectReturnTrueOrFalseOtherwise() {
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 9), equalTo(true));
		
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 0), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 1), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 2), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 3), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 4), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 5), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 6), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 7), equalTo(false));
		assertThat(ContolNumberCalc.isCorrect("KR1C", "00012345", 8), equalTo(false));
	}
}
