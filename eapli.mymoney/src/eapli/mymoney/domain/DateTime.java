/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public final class DateTime {

	public static Period thisWeek() {
		Calendar now = eapli.util.DateTime.now();
		int weekNumber = eapli.util.DateTime.currentWeekNumber();
		int year = now.get(Calendar.YEAR);

		Calendar begin = eapli.util.DateTime.beginningOfWeek(year, weekNumber);
		Calendar end = now;

		Period period = new Period(begin, end);

		return period;
	}

	public static Period thisMonth() {
		Calendar now = eapli.util.DateTime.now();
		int monthNumber = eapli.util.DateTime.currentMonth();
		int year = now.get(Calendar.YEAR);

		Calendar begin = beginningOfMonth(now);
		Calendar end = now;

		Period period = new Period(begin, end);

		return period;
	}

	/**
	 * returns the date of the last day of a certain month
	 *
	 * @param reference a date to be used as reference month
	 * @return
	 */
	public static Calendar beginningOfMonth(final Calendar reference) {
		final Calendar firstDay = new GregorianCalendar();
		firstDay.setTime(reference.getTime());
		final int first = firstDay.getActualMinimum(Calendar.DAY_OF_MONTH);
		firstDay.set(Calendar.DAY_OF_MONTH, first);
		return firstDay;
	}
}
