package com.realdolmen.padel.exception;

public class PadelMessageCode extends MessageCode {

    private static final long serialVersionUID = 1L;

    private static final String SYSTEM = "BOOKING";

    private static final String SUBSYSTEM = "PADEL";

    public static final MessageCode NOT_ENOUGH_TIMESLOTS = new PadelMessageCode("0010",
            "Te weinig timeslots.",
            "Voor periode @period@ zijn er te weinig timeslots gedefinieerd.Er zijn @members@ spelers ingepland voor slechts @timeslots@ timeslots.");

    public static final MessageCode NO_CORRECT_PLANNING_PERIOD = new PadelMessageCode("0020",
            "No correct planning period.",
            "De start periode @startdate@ ligt niet voor de eind periode @enddate@.");

    public static final MessageCode NOT_ENOUGH_MEMBERS_TO_MAKE_PLANNING = new PadelMessageCode("0030",
            "Not enough members.",
            "Er zijn niet genoeg spelers gedefinieerd om een correcte planning te maken.");

    public static final MessageCode MEMBER_OVERBOOKING = new PadelMessageCode("0040",
            "Member overbooked.",
            "Speler @member@ speelt deze week al op volgende data @playdates@.");

    public static final MessageCode TIMESLOT_OVERBOOKING = new PadelMessageCode("0050",
            "Court overbooked.",
            "Terrein @court@ vanaf @startPeriod@ tot @endPeriod@ op @reservationDate@ is reeds gereserveerd door de volgende personen @members@");

    public static final MessageCode NO_VALID_TIMESLOT = new PadelMessageCode("0060",
            "No valid timeslot.",
            "Timeslot @timeSlot@ is niet correct.timeslots starten iedere dag vanaf 06.30 tot 23.00");

    public static final MessageCode COURT_OVERBOOKED = new PadelMessageCode("0070",
            "Court overbooked.",
            "Terrein is overboekt");

    public static final MessageCode TOO_MANY_RESERVATIONS = new PadelMessageCode("0080",
            "Too many reservations.",
            "Een of meerdere spelers zijn overboekt.");

    public static final MessageCode MEMBER_AVAILABILITY_DUPLICATES = new PadelMessageCode("0090",
            "Too many reservations.",
            "Een of meerdere spelers zijn overboekt.");



    protected PadelMessageCode(String p_code, String p_defaultName,
                               String p_defaultMsgTemplate) {
        super(SYSTEM, SUBSYSTEM, p_code, p_defaultName, p_defaultMsgTemplate);
    }
}
