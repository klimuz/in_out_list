package uz.klimuz.in_outlist.utils

val drumInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("SNARE 2", 1),
    Instrument("OVER",2, "condenser"),
    Instrument("FLOOR TOMS",2),
    Instrument("TOMS",3),
    Instrument("HAT",1, "condenser"),
    Instrument("SNARE BOT",1),
    Instrument("SNARE TOP",1),
    Instrument("SNARE",0),
    Instrument("KICK OUT",1),
    Instrument("KICK IN", 1, pickup = "condenser"),
    Instrument("KICK",0),

    Instrument("SPD mono",0, "D.I. box"),
    Instrument("SPD stereo",0, "D.I. box",true)
)
val percussionInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("DOYRA",1),
    Instrument("DOYRA MOBILE",1,"wireless"),
    Instrument("TABLA",1),
    Instrument("DOWUL",1),
    Instrument("JAMBE",0),
    Instrument("KUSHNAGORA",1),
    Instrument("CONGAS",2),
    Instrument("BONGO",1),
    Instrument("TIMBALES",2),
    Instrument("PERC.OVER",0, "condenser")
    )
val guitarInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("BASS GTR mono",1,"D.I. box"),
    Instrument("BASS GTR stereo",0,"D.I. box", true),
    Instrument("EL.GTR mono",1, "D.I. box"),
    Instrument("EL.GTR stereo",0,"D.I. box", true),
    Instrument("AC.GTR mono",1,"D.I. box"),
    Instrument("AC.GTR stereo",0,"D.I. box", true)
    )
val keyboardInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("SYNTH stereo",1,"D.I. box", true),
    Instrument("SYNTH mono",0,"D.I. box"),
    Instrument("PIANO",0,"condenser"),
    Instrument("PIANO HI",0,"condenser"),
    Instrument("PIANO LO",0,"condenser")
    )
val nationalInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("VIOLA",1,"D.I. box"),
    Instrument("GIJAK",0),
    Instrument("KONUN",1,"D.I. box"),
    Instrument("RUBOB",0,"DPA"),
    Instrument("TOR",1,"DPA"),
    Instrument("DUTOR",0,"DPA"),
    Instrument("TAMBUR",0,"DPA"),
    Instrument("SOZ",1,"D.I. box"),
    Instrument("CHANG",0),
    Instrument("NAY",1),
    Instrument("KLARNET",1),
    Instrument("SURNAY",0),
    Instrument("KUSHNAY",0),
    Instrument("HARMONICA",1),
    Instrument("HARMONICA HI",0),
    Instrument("HARMONICA LO",0)
    )
val soloistInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("MAIN VOCAL",2,"wireless"),
    Instrument("MC MAN",1),
    Instrument("MC WOMAN",1),
    Instrument("HEADSET",1,"HeadSet"),
    Instrument("AUTO-TUNER RTN",0,"D.I. box", true),
    Instrument("ROOM",0,"condenser"),
    Instrument("PRODUCER",1),
    Instrument("TRIBUNE",0,"condenser"),
    Instrument("CONDUCTOR",0,"HeadSet")
    )
val backVocalInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("CHOIR",0,"condenser"),
    Instrument("CHOIR MEN",0,"condenser"),
    Instrument("CHOIR WOMEN",0,"condenser"),
    Instrument("CHOIR BOYS",0,"condenser"),
    Instrument("CHOIR GIRLS",0,"condenser"),
    Instrument("BACK VOCAL",0),
    Instrument("BACK MEN",0),
    Instrument("BACK WOMEN",0)
    )
val stringInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("1-VIOLINES",0,"DPA"),
    Instrument("2-VIOLINES",0,"DPA"),
    Instrument("VIOLAS",0,"DPA"),
    Instrument("CELLO",0),
    Instrument("D-BASS",0,"DPA")
    )
val woodwindInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("FLUTE",0,"DPA"),
    Instrument("PICCOLO",0,"DPA"),
    Instrument("CLARINET",0,"condenser"),
    Instrument("OBOE",0,"DPA"),
    Instrument("BASSOON",0,"DPA")
    )
val brassInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("TRUMPET",0),
    Instrument("TROMBONE",0),
    Instrument("HORN",0),
    Instrument("TUBA",0),
    Instrument("SAXOPHONE",0),
    Instrument("B-SAXOPHONE",0)
    )
val playbackInstrumentsList: ArrayList<Instrument> = arrayListOf(
    Instrument("COMPUTER",0,"D.I. box", true),
    Instrument("VIDEO",0,"D.I. box", true),
    Instrument("SEQUENCER",0,"D.I. box", true),
    Instrument("D.J.",0,"D.I. box", true),
    Instrument("MEDIA",0,"D.I. box", true)
    )