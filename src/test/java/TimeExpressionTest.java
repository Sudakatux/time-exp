
import junit.framework.TestCase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;

// ¡ REMEMBER ! YOU CAN ONLY CHANGE PRIMITIVE TYPES SUCH AS the Integers I used to represent days, weeks, and so on

public class TimeExpressionTest extends TestCase {

    public void testOnDate() {
        LocalDate today = LocalDate.now();
        TimeExpression todayTimeExp = TimeExpression.on(today);

        assertTrue(todayTimeExp.isRecurringOn(today));
    }

    public void testRecursEveryDay() {
        int oneDay = 1; // you can change the Int type by the one you make up
        LocalDate today = LocalDate.now();
        LocalDate theNextSixDays = today.plusDays(6);

        TimeExpression everyDayFromTodayToTheNextSixDaysTimeExp =
            TimeExpression
                .dailyEveryFromOnwards(
                    oneDay,
                    today
                );

        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(1)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(2)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(3)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(4)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(5)));
        assertTrue(everyDayFromTodayToTheNextSixDaysTimeExp.isRecurringOn(today.plusDays(6)));

    }

    public void testRecursEveryTwoDays() {
        int twoDays = 2; // you can change the Int type by the one you make up
        LocalDate today = LocalDate.now();
        LocalDate theNextSevenDays = today.plusDays(7);

        TimeExpression everyTwoDaysFromTodayToTheNextSevenDaysTimeExp =
            TimeExpression
                .dailyEveryFromOnwards(
                    twoDays,
                    today
                );

        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(1)));
        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(2)));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(3)));
        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(4)));
        assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(5)));
        assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(6)));

    }

    public void testRecursEveryMonthTheSecondDay() {
        int oneMonth = 1; // you can change the Int type by the one you make up
        int theSecondDay = 2; // you can change the Int type by the one you make up
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheSeconthDayFromJanuary2012ToMay2012 =
            TimeExpression
                .monthlyEveryOnFromOnwards(
                    oneMonth,
                    theSecondDay,
                    januaryOf2012
                );

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 1, 2);
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(1)));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(2)));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(3)));
        assertTrue(everyMonthTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(4)));

    }

    public void testRecursEveryTwoMonthsTheSeconthDay() {
        int twoMonth = 2; // you can change the Int type by the one you make up
        int theSecondDay = 2; // you can change the Int type by the one you make up
        YearMonth january2012 = YearMonth.of(2012, 1);
        YearMonth may2012 = YearMonth.of(2012, 5);

        TimeExpression everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012 =
            TimeExpression
                .monthlyEveryOnFromOnwards(
                    twoMonth,
                    theSecondDay,
                    january2012
                );

        LocalDate januaryTheSeconthOf2012 = LocalDate.of(2012, 1, 2);
        assertTrue(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012));
        assertFalse(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(1)));
        assertTrue(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(2)));
        assertFalse(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(3)));
        assertTrue(everyTwoMonthsTheSeconthDayFromJanuary2012ToMay2012.isRecurringOn(januaryTheSeconthOf2012.plusMonths(4)));

    }

    public void testRecursEveryMonthTheFirstFriday() {
        int oneMonth = 1; // you can change the Int type by the one you make up
        int theFirstWeekOfTheMonth = 1; // you can change the Int type by the one you make up
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheFirstFridayFromJanuary2012ToMay2012 =
            TimeExpression
                .monthlyEveryOnOfFromOnwards(
                    oneMonth,
                    DayOfWeek.FRIDAY,
                    theFirstWeekOfTheMonth,
                    januaryOf2012
                );

        LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012)); // first friday of january
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(1)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(2)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(3)));
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(4))); // first friday of february
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(5)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(6)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(7)));
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(8))); // first friday of march
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(9)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(10)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(11)));
        assertFalse(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(12)));
        assertTrue(everyMonthTheFirstFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(13))); // first friday of april
    }

    public void testRecursEveryMonthTheLastFriday() {
        int oneMonth = 1; // you can change the Int type by the one you make up
        int theFirstWeekOfTheMonth = 5;  // you can change the Int type by the one you make up
        YearMonth januaryOf2012 = YearMonth.of(2012, 1);
        YearMonth mayOf2012 = YearMonth.of(2012, 5);

        TimeExpression everyMonthTheLastFridayFromJanuary2012ToMay2012 =
                TimeExpression
                        .monthlyEveryOnOfFromOnwards(
                                oneMonth,
                                DayOfWeek.FRIDAY,
                                theFirstWeekOfTheMonth,
                                januaryOf2012
                        );

        LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(1)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(2)));
        assertTrue(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(3))); // last friday of january
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(4)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(5)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(6)));
        assertTrue(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(7))); // last friday of february
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(8)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(9)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(10)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(11)));
        assertTrue(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(12))); // last friday of april is
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(13)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(14)));
        assertFalse(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(15)));
        assertTrue(everyMonthTheLastFridayFromJanuary2012ToMay2012.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(16))); // fourth friday of april
    }

    public void testRecursEveryAugustTheEight() {
        int oneYear = 1; // you can change the Int type by the one you make up
        MonthDay augustTheEight = MonthDay.of(8, 8);
        TimeExpression everyAugustTheEightFrom2012To2015 =
            TimeExpression
                .yearlyEveryOnFromOnwards(
                    oneYear,
                    augustTheEight,
                    2012
                );

        LocalDate firstEightOfAugust = LocalDate.of(2012, 8, 8);
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust));
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(1)));
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(2)));
        assertTrue(everyAugustTheEightFrom2012To2015.isRecurringOn(firstEightOfAugust.plusYears(3)));
    }
}
