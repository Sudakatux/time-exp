import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TimeExpression {
    final Supplier<Stream<LocalDate>> dates;

    public TimeExpression(Supplier<Stream<LocalDate>> dates)  {
        this.dates = dates;
    }

    public static TimeExpression on(LocalDate aDate) {
       return  new TimeExpression(new Supplier<Stream<LocalDate>>() {
           @Override
           public Stream<LocalDate> get() {
               return Stream.of(aDate);
           }
       });
    }

    public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate aDate) {
        return new TimeExpression(new Supplier<Stream<LocalDate>>() {
            @Override
            public Stream<LocalDate> get() {
                return Stream.iterate(aDate,d->d.plusDays(anAmountOfDays));
            }
        });
    }

    public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth anYear) {
        final LocalDate aDate = LocalDate.of(anYear.getYear(),anYear.getMonth(),aDayInMonth);
        return new TimeExpression(new Supplier<Stream<LocalDate>>() {
            @Override
            public Stream<LocalDate> get() {
                return Stream.iterate(aDate,d->d.plusMonths(anAmountOfMonths));
            }
        });
    }

    public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, DayOfWeek aDayOfWeek, int aWeekInMonth, YearMonth anYear) {
        final TemporalAdjuster week = aWeekInMonth == 1 ? TemporalAdjusters.firstInMonth(aDayOfWeek) : TemporalAdjusters.lastInMonth(aDayOfWeek);
        final LocalDate aDate = LocalDate.of(anYear.getYear(),anYear.getMonth(),1).with(week);
        return new TimeExpression(new Supplier<Stream<LocalDate>>() {
            @Override
            public Stream<LocalDate> get() {
                return Stream.iterate(aDate,d->d.plusMonths(anAmountOfMonths).with(week));
            }
        });
    }

    public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
        final LocalDate yearly = LocalDate.of(anYear,aMonthDay.getMonth(),aMonthDay.getDayOfMonth());

        return new TimeExpression(new Supplier<Stream<LocalDate>>() {
            @Override
            public Stream<LocalDate> get() {
                return Stream.iterate(yearly,d->d.plusYears(anAmountOfYears));
            }
        });
    }

    public boolean isRecurringOn(LocalDate aDate) {
        return dates.get()
                .limit(dates.get().findFirst().map(id-> {
                    Long interval =  ChronoUnit.DAYS.between(id, aDate) + 1;
                    return interval < 0 ? 0: interval;
                }).orElse(0l))
                .anyMatch(d -> d.equals(aDate) );
    }
}
