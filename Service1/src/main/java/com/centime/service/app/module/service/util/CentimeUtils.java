package com.centime.service.app.module.service.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

public class CentimeUtils {
	private static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();
	public static Timestamp now() {
		final Calendar zoneCalendar = Calendar.getInstance(DEFAULT_TIME_ZONE);
		final Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, zoneCalendar.get(Calendar.DATE));
		calendar.set(Calendar.MONTH, zoneCalendar.get(Calendar.MONTH));
		calendar.set(Calendar.YEAR, zoneCalendar.get(Calendar.YEAR));
		calendar.set(Calendar.HOUR, zoneCalendar.get(Calendar.HOUR));
		calendar.set(Calendar.HOUR_OF_DAY, zoneCalendar.get(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.AM_PM, zoneCalendar.get(Calendar.AM_PM));
		calendar.set(Calendar.MINUTE, zoneCalendar.get(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, zoneCalendar.get(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, zoneCalendar.get(Calendar.MILLISECOND));
		return new Timestamp(calendar.getTime().getTime());
	}
}
