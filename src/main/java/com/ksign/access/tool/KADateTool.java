package com.ksign.access.util;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class KADateTool {
    /**
     * date format.
     */
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
    private static final TimeZone koreaZone = TimeZone.getTimeZone("GMT+9");

    private static long currentDateGenerated = 0L;

    private static String currentDate = null;

    static {
        format.setTimeZone(koreaZone);
    }

    public static final String getCurrentDate() {
        long now = System.currentTimeMillis();
        if((now - currentDateGenerated) > 1000) {
            synchronized(format) {
                currentDateGenerated = now;
                currentDate = format.format(new Date(now));
            }
        }
        return currentDate;
    }

    public static String getDateFormat(long ms) {
        return format.format(new Date(ms));
    }
    /**
     *
     * @param timeStamp
     *            String ����� ��¥
     * @param expredTime
     *            int �д���
     * @return long timeStamp : Agent���� ���� �ð�
     */
    public static final boolean isExpired(String timeStamp, int expiredTime) {
        try {
            Date accessTime = format.parse(timeStamp);
            long tokenTime = accessTime.getTime();
            long currTime = System.currentTimeMillis(); // format.parse(getCurrentDate()).getTime();

            long eTime = tokenTime + (expiredTime * 60 * 1000);

			/*
			if(log.isDebugEnabled()) {
				log.debug("== isExpired == ");
				log.debug("tokenTime: " + new Date(tokenTime));
				log.debug("currTime : " + new Date(currTime));
				log.debug("expiredTime: " + expiredTime);
				log.debug("eTime    : " + new Date(eTime));
			}
			*/

            if (currTime < eTime)
                return false;
        } catch (ParseException ex) {
            return true;
        }
        return true;
    }

    public static final boolean isExpired(String timeStamp, long expiredTime) {
        try {
            Date accessTime = format.parse(timeStamp);
            long tokenTime = accessTime.getTime();
            long currTime = System.currentTimeMillis(); // format.parse(getCurrentDate()).getTime();

            long eTime = tokenTime + (expiredTime * 1000);
            if (currTime < eTime) return false;
        } catch (ParseException ex) {
            return true;
        }
        return true;
    }

    public static int getDateDiff(String fymd, String nymd) {
        int iCntDay = 0;
        int r_year = 0;
        int r_month = 0;
        int r_day = 0;
        long ideff = 0;
        Date dateFirst = new Date();
        Date dateNext = new Date();
        try {
            // ��
            r_year = Integer.parseInt(fymd.substring(0, 4));
            r_month = Integer.parseInt(fymd.substring(4, 6)) - 1;
            r_day = Integer.parseInt(fymd.substring(6, 8));
            dateFirst.setYear(r_year - 1900);
            dateFirst.setMonth(r_month);
            dateFirst.setDate(r_day);
            r_year = Integer.parseInt(nymd.substring(0, 4));
            r_month = Integer.parseInt(nymd.substring(4, 6)) - 1;
            r_day = Integer.parseInt(nymd.substring(6, 8));
            dateNext.setYear(r_year - 1900);
            dateNext.setMonth(r_month);
            dateNext.setDate(r_day);
            ideff = dateFirst.getTime() - dateNext.getTime();
            iCntDay = (int) Math
                    .round((double) (ideff / (1000 * 60 * 60 * 24)));
        } catch (Exception e) {
            iCntDay = -1;
        }
        return iCntDay;
    }
}
