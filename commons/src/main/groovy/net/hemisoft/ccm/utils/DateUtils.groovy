package net.hemisoft.ccm.utils;

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

public class DateUtils {
	static LocalDateTime convertEpochMillis(long epoch) {
		LocalDateTime.ofInstant Instant.ofEpochSecond(epoch), ZoneId.systemDefault()
	}
	
	static long convertLocalDateTime(LocalDateTime dateTime) {
		dateTime.atZone(ZoneId.systemDefault()).toEpochSecond()
	}
}
