package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Mainunit.class,nextPosition.class,doesWinBlack.class,DoesWinwhite.class,checkLoginTest.class,checkTrueAnswer.class,CheckPossibleDiceValue.class })
public class AllTests {
}
