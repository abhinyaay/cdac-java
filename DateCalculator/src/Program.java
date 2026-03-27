class Program {

    private int day, month, year;

    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public int getDaysOfMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month - 1];
    }

    // Count leap years from year 0 up to (but not including) the given year
    private int leapYearsBefore(int y) {
        y--;
        return y / 4 - y / 100 + y / 400;
    }

    public void setDate(int day, int month, int year) {

        if (year < 2000 || year > 2100) {
            year = 2026;
        }

        if (month < 1 || month > 12) {
            month = 1;
        }

        int maxDays = getDaysOfMonth(month, year);

        if (day < 1 || day > maxDays) {
            day = 1;
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int toTotalDays() {
        // Calculate days from years using leap year formula instead of looping
        int years = year - 2000;
        int total = years * 365 + (leapYearsBefore(year) - leapYearsBefore(2000));

        for (int i = 1; i < month; i++) {
            total += getDaysOfMonth(i, year);
        }

        total += day;

        return total;
    }

    public void fromTotalDays(int total) {

        year = 2000;

        while (true) {
            int daysInYear = isLeapYear(year) ? 366 : 365;

            if (total > daysInYear) {
                total -= daysInYear;
                year++;
            } else {
                break;
            }
        }

        month = 1;

        while (true) {
            int dim = getDaysOfMonth(month, year);

            if (total > dim) {
                total -= dim;
                month++;
            } else {
                break;
            }
        }

        day = total;
    }

    public void addDays(int numOfDays) {
        fromTotalDays(toTotalDays() + numOfDays);
    }

    public void addMonths(int numOfMonths) {
        int totalMonths = (month - 1) + numOfMonths;
        year += totalMonths / 12;
        month = (totalMonths % 12) + 1;

        setDate(day, month, year);
    }

    public void addYears(int numOfYears) {
        year += numOfYears;
        setDate(day, month, year);
    }

    public void compare(int day, int month, int year) {

        int current = toTotalDays();

        // Compute other date's total days without allocating a new object
        int other = 0;

        // Validate inputs (same logic as setDate)
        if (year < 2000 || year > 2100) year = 2026;
        if (month < 1 || month > 12) month = 1;
        int maxDays = getDaysOfMonth(month, year);
        if (day < 1 || day > maxDays) day = 1;

        int years = year - 2000;
        other = years * 365 + (leapYearsBefore(year) - leapYearsBefore(2000));
        for (int i = 1; i < month; i++) {
            other += getDaysOfMonth(i, year);
        }
        other += day;

        if (current == other)
            System.out.println("DATES ARE SAME !!!!");
        else
            System.out.println("DATES ARE NOT SAME !!!!!");
    }

    public void show() {
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }
}