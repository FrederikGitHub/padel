export class DateUtils {




    static getWeekOfYear(tdt:any)
    {
        var dayn = (tdt.getDay() + 6) % 7;
        tdt.setDate(tdt.getDate() - dayn + 3);
        var firstThursday = tdt.valueOf();
        tdt.setMonth(0, 1);
        if (tdt.getDay() !== 4)
        {
            tdt.setMonth(0, 1 + ((4 - tdt.getDay()) + 7) % 7);
        }
        return 1 + Math.ceil((firstThursday - tdt) / 604800000);
    }

    /*static getWeekOfMonth(date:Date) {
        let monthStart = date;
        monthStart.setDate(0);
        let offset = (monthStart.getDay() + 1) % 7 - 1; // -1 is for a week starting on Monday
        return Math.ceil((date.getDate() + offset) / 7);
    }*/

    static getWeekOfMonth(date:any) {
        let monthStart = new Date(date);
        monthStart.setDate(0);
        let offset = (monthStart.getDay() + 1) % 7 - 1; // -1 is for a week starting on Monday
        return Math.ceil((date.getDate() + offset) / 7);
    }


}
